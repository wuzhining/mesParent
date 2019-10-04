package com.techsoft.dao.bill;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumAuditStatus;
import com.techsoft.common.enums.EnumBillStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.dao.product.ProductMaterialDao;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.utils.zklock.DistributedLock;
import com.techsoft.utils.zklock.LockManager;
import com.techsoft.entity.bill.BillPurchaseItemVo;
import com.techsoft.entity.bill.BillWarehouseItemParamVo;
import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.BillDeliveryItem;
import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.BillPurchaseItem;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.mapper.bill.BillDeliveryItemMapper;
import com.techsoft.mapper.bill.BillDeliveryMapper;
import com.techsoft.mapper.bill.BillPurchaseMapper;
import com.techsoft.mapper.bill.BillWarehouseItemMapper;
import com.techsoft.mapper.bill.BillWarehouseMapper;
import com.techsoft.mapper.product.ProductMaterialMapper;

@Repository
public class BillDeliveryDaoImpl extends BaseDaoImpl<BillDelivery> implements BillDeliveryDao {
	@Resource
	protected BillDeliveryMapper billDeliveryMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	@Resource
	protected BillDeliveryItemMapper billDeliveryItemMapper; 
	@Resource
	protected BillWarehouseItemMapper billWarehouseItemMapper; 
	@Resource
	protected BillWarehouseMapper billWarehouseMapper; 
	@Resource
	protected BillPurchaseMapper billPurchaseMapper; 
	@Resource
	protected ProductMaterialMapper productMaterialMapper; 
	
	@Override
	public Class<BillDelivery> getEntityClass() {
		return BillDelivery.class;
	}	
	
	@Override
	public BaseMapper<BillDelivery> getBaseMapper() {
		return this.billDeliveryMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "BILL_DELIVERY";
	}
	
	@Override
	public void insertSaveCheck(BillDelivery value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(BillDelivery value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(BillDelivery value) throws BusinessException, SQLException {
	
	}
	
	
	@Override
	public List<BillDeliveryItem> insertBatchMainAndDetail(List<BillWarehouse> list,String billCode,CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillDeliveryItem> billList = new ArrayList<BillDeliveryItem>();
		
		//新增主表
		BillDelivery billWarehouseVo = new BillDelivery();
		billWarehouseVo.setId(billDeliveryMapper.getIDValue());
	    billWarehouseVo.setBillCode(billCode);
		billWarehouseVo.setBillStatusDictId(EnumBillStatus.NEW.getValue());
		billWarehouseVo.setAuditStatusDictId(EnumAuditStatus.UNAUDITED.getValue());
		billWarehouseVo.setBillTypeDictId(EnumBillType.BILL_TYPE_DELIVERY_SUPPLIER.getValue());
		billWarehouseVo.setFromPartnerId(list.get(0).getPartnerId());
		billWarehouseVo.setFromBillTypeDictId(list.get(0).getBillTypeDictId());
		billWarehouseVo.setTenantId(commonParam.getTenantId());
		//暂时赋值传回
		billWarehouseVo.setCreateUserId(Long.valueOf(commonParam.getUserId()));
		billWarehouseVo.setModifyUserId(Long.valueOf(commonParam.getUserId()));
		billDeliveryMapper.insertEntity(billWarehouseVo);
		
		//批量新增仓库单据主表及明细表
		for (BillWarehouse billWarehouseMain : list) {
			//新增明细表
			DecimalFormat df=new DecimalFormat("0000");
			Integer index = 0;
			String idString = "";
			Long idLong = 0L;
			Long bilItemId=billDeliveryItemMapper.getIDValue();
			List<BillWarehouseItem> allocationOutList =new ArrayList<BillWarehouseItem>();
			BillWarehouseItemParamVo billWarehouseItem =new BillWarehouseItemParamVo();
			billWarehouseItem.setBillId(billWarehouseMain.getId());
			allocationOutList=billWarehouseItemMapper.selectListByEntityParamVo(billWarehouseItem);
				
            for (BillWarehouseItem allOutItem : allocationOutList) {
					
					List<BillDeliveryItem> allOutist = new ArrayList<BillDeliveryItem>();
					BillDeliveryItem allocationOutItem = new BillDeliveryItem();
					index++;
					idString=df.format(index);
					idLong = Long.valueOf(bilItemId.toString() + idString);
					allocationOutItem.setId(idLong);
					allocationOutItem.setBillId(billWarehouseVo.getId());
					allocationOutItem.setBillStatusDictId(EnumBillStatus.NEW.getValue());
					allocationOutItem.setFromBillId(billWarehouseMain.getId());
					allocationOutItem.setFromBillCode(billWarehouseMain.getBillCode());
					//查询单据号
					//BillWarehouse bill=billWarehouseMapper.selectById(billWarehouseMain.getId());
					allocationOutItem.setQuantityFinish(0.0);
					allocationOutItem.setQuantityScan(0.0);
					ProductMaterial material=productMaterialMapper.selectById(allOutItem.getMaterialId());
					allocationOutItem.setProductId(material.getProductId());
					allocationOutItem.setMaterialId(allOutItem.getMaterialId());
					allocationOutItem.setQuantity(allOutItem.getQuantity());
					allocationOutItem.setTenantId(commonParam.getTenantId());
					//暂时赋值传回
					allocationOutItem.setCreateUserId(Long.valueOf(commonParam.getUserId()));
					allocationOutItem.setModifyUserId(Long.valueOf(commonParam.getUserId()));
					allOutist.add(allocationOutItem);
					//批量新增明细表
					billDeliveryItemMapper.insertBatch(allOutist);
					billList.addAll(allOutist);
					
				}
            
			}
		
		return billList;
	} 
	
	@Override
	public List<BillDeliveryItem> insertPurchaseBatchMainAndDetail(List<BillPurchaseItemVo> list, String billCode,CommonParam commonParam)
			throws BusinessException, SQLException {
		
		//批量新增仓库单据主表
		List<BillDeliveryItem> billPurchase= new ArrayList<BillDeliveryItem>();
		List<BillDeliveryItem> allOutist = new ArrayList<BillDeliveryItem>();
		DecimalFormat df=new DecimalFormat("0000");
		
	    //新增送货单主表数据
	    BillDelivery billWarehouseReal =new BillDelivery();
		billWarehouseReal.setId(billDeliveryMapper.getIDValue());
		billWarehouseReal.setBillCode(billCode);
		billWarehouseReal.setBillStatusDictId(EnumBillStatus.NEW.getValue());
		billWarehouseReal.setAuditStatusDictId(EnumAuditStatus.UNAUDITED.getValue());
		billWarehouseReal.setBillTypeDictId(EnumBillType.BILL_TYPE_DELIVERY.getValue());
		BillPurchase billPurchaseMain =new BillPurchase();
		billPurchaseMain =billPurchaseMapper.selectById(list.get(0).getBillPurchaseId());
		billWarehouseReal.setFromPartnerId(billPurchaseMain.getSupplierId());
		billWarehouseReal.setFromBillTypeDictId(EnumBillType.BILL_TYPE_PURCHASE.getValue());
		billWarehouseReal.setTenantId(commonParam.getTenantId());
		billWarehouseReal.setCreateUserId(Long.valueOf(commonParam.getUserId()));
		billWarehouseReal.setModifyUserId(Long.valueOf(commonParam.getUserId()));
		billDeliveryMapper.insertEntity(billWarehouseReal);
		
		//新增历史表
		
	     
	    //批量新增送货单明细表数据
		Integer itemindex = 0;
		String itemIdString = "";
		Long itemIdLong = 0L;
		Long billItemId=billDeliveryItemMapper.getIDValue();
		for (BillPurchaseItemVo billPurchaseItem : list) {
	    	 BillDeliveryItem allocationOutItem = new BillDeliveryItem();
	    	 itemindex++;
	    	 itemIdString=df.format(itemindex);
	    	 itemIdLong = Long.valueOf(billItemId.toString() + itemIdString);
			 allocationOutItem.setId(itemIdLong);
			 allocationOutItem.setBillId(billWarehouseReal.getId());
			 allocationOutItem.setFromBillId(billPurchaseItem.getBillPurchaseId());
			 //查询采购单号
			 BillPurchase bill=billPurchaseMapper.selectById(billPurchaseItem.getBillPurchaseId());
			 allocationOutItem.setFromBillCode(bill.getBillCode());
			 allocationOutItem.setBillStatusDictId(EnumBillStatus.NEW.getValue());
			 allocationOutItem.setQuantityFinish(0.0);
			 allocationOutItem.setQuantityScan(0.0);
			 allocationOutItem.setMaterialId(billPurchaseItem.getMaterialId());
			 allocationOutItem.setProductId(billPurchaseItem.getProductId());
			 allocationOutItem.setQuantity(billPurchaseItem.getQuantityNeed());
			 //allocationOutItem.setDateManufacture(dateManufacture);
			 allocationOutItem.setTenantId(commonParam.getTenantId());
			 allocationOutItem.setCreateUserId(Long.valueOf(commonParam.getUserId()));
			 allocationOutItem.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			 allOutist.add(allocationOutItem);
	     } 
		 billDeliveryItemMapper.insertBatch(allOutist);
		 billPurchase.addAll(allOutist);
		 
		return billPurchase;
	}
	
	@Override
	public void updateBillStatusMain(Long id, Long billStatusDictId, CommonParam commonParam)
			throws BusinessException, SQLException {
		DistributedLock distributedLock = LockManager.getZKDistributedLock(this.getEntityClass().getName(),
				id.toString());
		distributedLock.lock();
		try {
			BillDelivery item = this.selectById(id);
			item.setBillStatusDictId(billStatusDictId);
			
			this.updatePartEntity(item, commonParam);
		} finally {
			distributedLock.unlock();
		}
	}
}
