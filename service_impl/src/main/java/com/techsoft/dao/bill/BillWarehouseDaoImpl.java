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
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.utils.zklock.DistributedLock;
import com.techsoft.utils.zklock.LockManager;
import com.techsoft.entity.bill.BillDeliveryItemVo;
import com.techsoft.entity.bill.BillInspectParamVo;
import com.techsoft.entity.bill.BillPurchaseItemVo;
import com.techsoft.entity.bill.BillWarehouseItemParamVo;
import com.techsoft.entity.bill.BillWarehouseParamVo;
import com.techsoft.entity.bill.BillWarehouseVo;
import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.BillDeliveryItem;
import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.BillPurchaseItem;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.mapper.bill.BillDeliveryMapper;
import com.techsoft.mapper.bill.BillInspectMapper;
import com.techsoft.mapper.bill.BillPurchaseMapper;
import com.techsoft.mapper.bill.BillWarehouseItemMapper;
import com.techsoft.mapper.bill.BillWarehouseMapper;
import com.techsoft.mapper.product.ProductMainMapper;
import com.techsoft.mapper.product.ProductMaterialMapper;

@Repository
public class BillWarehouseDaoImpl extends BaseDaoImpl<BillWarehouse> implements BillWarehouseDao {
	@Resource
	protected BillWarehouseMapper billWarehouseMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper; 
	@Resource
	protected BillWarehouseItemMapper billWarehouseItemMapper; 
	@Resource
	protected BillInspectMapper billInspectMapper;
	@Resource
	protected BillPurchaseMapper billPurchaseMapper;
	@Resource
	protected BillDeliveryMapper billDeliveryMapper;
	@Resource
	protected ProductMaterialMapper productMaterialMapper;
	
	
	@Override
	public Class<BillWarehouse> getEntityClass() {
		return BillWarehouse.class;
	}

	@Override
	public BaseMapper<BillWarehouse> getBaseMapper() {
		return this.billWarehouseMapper;
	}

	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}

	@Override
	public String getTableName() {
		return "BILL_WAREHOUSE";
	}

	@Override
	public void insertSaveCheck(BillWarehouse value) throws BusinessException, SQLException {
		if (value.getId() == null || value.getId().equals(0L)) {
			throw new BusinessException("id不能为空");
		}
	}

	@Override
	public void updateSaveCheck(BillWarehouse value) throws BusinessException, SQLException {

	}

	@Override
	public void deleteSaveCheck(BillWarehouse value) throws BusinessException, SQLException {

	}

	@Override
	public void insertBatch(List<BillWarehouse> list, CommonParam commonParam) throws BusinessException, SQLException {
		try {
			for (BillWarehouse item : list) {
				insertSaveCheck(item);
				if (commonParam.getUserId() != null) {
					item.setCreateUserId(Long.valueOf(commonParam.getUserId()));
					item.setModifyUserId(Long.valueOf(commonParam.getUserId()));
				}
			}
			int rows = this.billWarehouseMapper.insertBatch(list);
			if (rows != list.size()) {
				throw new BusinessException("新增数量不一致！请检查");
			}

		} catch (RuntimeException e) {
			throw new SQLException(e.getMessage());
		}

	}

	@Override
	public void updateBillStatusMain(Long id, Long billStatusDictId, CommonParam commonParam)
			throws BusinessException, SQLException {
		DistributedLock distributedLock = LockManager.getZKDistributedLock(this.getEntityClass().getName(),
				id.toString());
		distributedLock.lock();
		try {
			BillWarehouse item = this.selectById(id);
			item.setBillStatusDictId(billStatusDictId);
			this.updatePartEntity(item, commonParam);
		} finally {
			distributedLock.unlock();
		}
	}

	@Override
	public BillWarehouse selectById(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillWarehouse  result = null;
		try {
			result = this.selectById(id);
			if (result == null) {
				throw new BusinessException("单据不存在");
			}
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		return result;
	}

	@Override
	public void updateAllocationOutstore(Long id, Long billStatusDictId, Double quality,CommonParam commonParam)
			throws BusinessException, SQLException {
		DistributedLock distributedLock = LockManager.getZKDistributedLock(this.getEntityClass().getName(),
				id.toString());
		distributedLock.lock();
		try {
			BillWarehouseItem item = billWarehouseItemMapper.selectById(id);
			item.setQuantityScan(item.getQuantityScan() + quality);
			item.setBillStatusDictId(billStatusDictId);
			billWarehouseItemMapper.updatePartEntity(item);
			// return this.updatePartEntity(item, commonParam);
		} finally {
			distributedLock.unlock();
		}

	}
	
	@Override
	public BillWarehouse insertAllocationMainAndDetail(Long billId,String creatCode, Long parentId,Long billType,Long fromBillType,Long billStatus,Long fromWarehouseId,Long toWarehouseId,String type,Long factoryId, CommonParam commonParam)
			throws BusinessException, SQLException {
	//type:OUT：出库    IN：入库   CHECK 质检
		//新增调拨出入库单主表
		BillWarehouseVo billWarehouseVoOut = new BillWarehouseVo();
		BillWarehouse billWarehouseOut= new BillWarehouse();
		if (type.equals("OUT")) {
			//String billCodeOut = configBarcode.createCode(BillWarehouse.class.getName(),billType,null, commonParam);
			billWarehouseVoOut.setBillCode(creatCode);
			billWarehouseVoOut.setBillStatusDictId(billStatus);
			billWarehouseVoOut.setBillTypeDictId(billType);
			//查询单据号
			BillWarehouse bill= billWarehouseMapper.selectById(billId);
			billWarehouseVoOut.setFromBillCode(bill.getBillCode());
			billWarehouseVoOut.setTypeStock("1");
			billWarehouseVoOut.setAuditStatusDictId(EnumAuditStatus.AUDITED.getValue());
		}else if (type.equals("IN")){
			//String billCodeIn= configBarcodeDao.createCode(BillWarehouse.class.getName(),billType, null,commonParam);
			billWarehouseVoOut.setBillCode(creatCode);
			billWarehouseVoOut.setBillStatusDictId(billStatus);
			billWarehouseVoOut.setBillTypeDictId(billType);
			//查询单据号
			BillWarehouse bill= billWarehouseMapper.selectById(billId);
			billWarehouseVoOut.setFromBillCode(bill.getBillCode());
			billWarehouseVoOut.setTypeStock("0");
			billWarehouseVoOut.setAuditStatusDictId(EnumAuditStatus.AUDITED.getValue());
		}else if (type.equals("CHECK")){
			//String billCodeIn= configBarcodeDao.createCode(BillWarehouse.class.getName(),billType,null, commonParam);
			billWarehouseVoOut.setBillCode(creatCode);
			billWarehouseVoOut.setBillStatusDictId(billStatus);
			billWarehouseVoOut.setBillTypeDictId(billType);
			//查询单据号
			BillInspect bill= billInspectMapper.selectById(billId);
			billWarehouseVoOut.setFromBillCode(bill.getInspectCode());
			if (billType.equals(EnumBillType.BILL_TYPE_WAREHOUSE_IN.getValue())) {
				billWarehouseVoOut.setTypeStock("0");
			} else if (billType.equals(EnumBillType.BILL_TYPE_WAREHOUSE_REJECT_SUPPLER.getValue())){
				billWarehouseVoOut.setTypeStock("1");
			}
			billWarehouseVoOut.setAuditStatusDictId(EnumAuditStatus.AUDITED.getValue());
		}
		billWarehouseVoOut.setPartnerId(parentId);
		billWarehouseVoOut.setFromBillTypeDictId(fromBillType);
		billWarehouseVoOut.setFromBillId(billId);
		billWarehouseVoOut.setFromWarehouseId(fromWarehouseId);
		billWarehouseVoOut.setToWarehouseId(toWarehouseId);
		billWarehouseVoOut.setTenantId(commonParam.getTenantId());
		billWarehouseVoOut.setFactoryId(factoryId); 
		//暂时赋值传回
		billWarehouseVoOut.setCreateUserId((long) 1);
		billWarehouseVoOut.setModifyUserId((long) 1);
		billWarehouseOut=this.insertEntity(billWarehouseVoOut, commonParam);
		
		
        //新增调拨单出库明细表
		
		DecimalFormat df=new DecimalFormat("0000");
		Integer index = 0;
		String idString = "";
		Long idLong = 0L;
		Long bilItemId=billWarehouseItemMapper.getIDValue();
		//状态等于检验单
		if (type.equals("CHECK")) {
			List<BillInspect> allocationOutList =new ArrayList<BillInspect>();
			BillInspectParamVo billWarehouseItem =new BillInspectParamVo();
			billWarehouseItem.setId(billId);
			allocationOutList=billInspectMapper.selectListByEntityParamVo(billWarehouseItem);
			
			for (BillInspect allOutItem : allocationOutList) {
				
				List<BillWarehouseItem> allOutist = new ArrayList<BillWarehouseItem>();
				
				BillWarehouseItem allocationOutItem = new BillWarehouseItem();
				index++;
				idString=df.format(index);
				idLong = Long.valueOf(bilItemId.toString() + idString);
				allocationOutItem.setId(idLong);
				allocationOutItem.setBillId(billWarehouseOut.getId());
			    allocationOutItem.setBillStatusDictId(billStatus);
				allocationOutItem.setQuantityFinish(0.0);
				allocationOutItem.setQuantityScan(0.0);
				allocationOutItem.setMaterialId(allOutItem.getMaterialId());
				//查询规格成品
				ProductMaterial material=productMaterialMapper.selectById(allOutItem.getMaterialId());
				allocationOutItem.setProductId(material.getProductId());
				allocationOutItem.setQuantity(allOutItem.getQuantity());
				allocationOutItem.setTenantId(commonParam.getTenantId());
				//暂时赋值传回
				allocationOutItem.setCreateUserId(Long.valueOf(commonParam.getUserId()));
				allocationOutItem.setModifyUserId(Long.valueOf(commonParam.getUserId()));
				allOutist.add(allocationOutItem);
				//批量新增明细表
				billWarehouseItemMapper.insertBatch(allOutist);
				
			}
		} else {
			List<BillWarehouseItem> allocationOutList =new ArrayList<BillWarehouseItem>();
			BillWarehouseItemParamVo billWarehouseItem =new BillWarehouseItemParamVo();
			billWarehouseItem.setBillId(billId);
			allocationOutList=billWarehouseItemMapper.selectListByEntityParamVo(billWarehouseItem);
			

			for (BillWarehouseItem allOutItem : allocationOutList) {
				
				List<BillWarehouseItem> allOutist = new ArrayList<BillWarehouseItem>();
				
				BillWarehouseItem allocationOutItem = new BillWarehouseItem();
				index++;
				idString=df.format(index);
				idLong = Long.valueOf(bilItemId.toString() + idString);
				allocationOutItem.setId(idLong);
				allocationOutItem.setBillId(billWarehouseOut.getId());
				if (type.equals("OUT")) {
					allocationOutItem.setBillStatusDictId(billStatus);
					allocationOutItem.setQuantityFinish(allOutItem.getQuantityScan());
					allocationOutItem.setQuantityScan(allOutItem.getQuantityScan());
				}else{
					allocationOutItem.setBillStatusDictId(billStatus);
					allocationOutItem.setQuantityFinish(0.0);
					allocationOutItem.setQuantityScan(0.0);
				}
				allocationOutItem.setMaterialId(allOutItem.getMaterialId());
				//查询规格成品
				ProductMaterial material=productMaterialMapper.selectById(allOutItem.getMaterialId());
				allocationOutItem.setProductId(material.getProductId());
				allocationOutItem.setQuantity(allOutItem.getQuantityScan());
				allocationOutItem.setTenantId((long) 1);
				//暂时赋值传回
				allocationOutItem.setCreateUserId((long) 1);
				allocationOutItem.setModifyUserId((long) 1);
				allOutist.add(allocationOutItem);
				//批量新增明细表
				billWarehouseItemMapper.insertBatch(allOutist);
				
			}
		}
		
		return billWarehouseOut;
	}
	
	
	@Override
	public void updateAllocationInstore(Long id, Long billStatusDictId, Double quality,CommonParam commonParam)
			throws BusinessException, SQLException {
		DistributedLock distributedLock = LockManager.getZKDistributedLock(this.getEntityClass().getName(),
				id.toString());
		distributedLock.lock();
		try {
			BillWarehouseItem item = billWarehouseItemMapper.selectById(id);
			item.setQuantityFinish(item.getQuantityFinish() + quality);
			item.setBillStatusDictId(billStatusDictId);
			billWarehouseItemMapper.updatePartEntity(item);
		} finally {
			distributedLock.unlock();
		}

	}
		
	@Override
	public List<BillWarehouse> selectPrepareMaterialsScreen() 
			throws BusinessException, SQLException{
		return billWarehouseMapper.selectPrepareMaterialsScreen(null);
	}
	
	
	@Override
	public List<BillWarehouseItem> insertArrivalMainAndDetail(List<BillDeliveryItemVo> list,String billCode,Long factoryId,CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillWarehouseItem> billList = new ArrayList<BillWarehouseItem>();
		
		//新增主表
		BillWarehouse billWarehouse = new BillWarehouse();
		billWarehouse.setId(billWarehouseMapper.getIDValue());
		billWarehouse.setBillCode(billCode);
		billWarehouse.setTypeStock("1");
		billWarehouse.setFactoryId(factoryId);
		billWarehouse.setBillStatusDictId(EnumBillStatus.DOING.getValue());
		billWarehouse.setAuditStatusDictId(EnumAuditStatus.AUDITED.getValue());
		billWarehouse.setBillTypeDictId(EnumBillType.BILL_TYPE_WAREHOUSE_ARRIVAL.getValue());
		BillDelivery billDelivery = new BillDelivery();
		billDelivery=billDeliveryMapper.selectById(list.get(0).getBillId());
		billWarehouse.setPartnerId(billDelivery.getFromPartnerId());
		billWarehouse.setFromBillTypeDictId(billDelivery.getBillTypeDictId());
		billWarehouse.setFromBillId(billDelivery.getId());
		billWarehouse.setFromBillCode(billDelivery.getBillCode());
		billWarehouse.setTenantId(commonParam.getTenantId());
		billWarehouse.setCreateUserId(Long.valueOf(commonParam.getUserId()));
		billWarehouse.setModifyUserId(Long.valueOf(commonParam.getUserId()));
		billWarehouseMapper.insertEntity(billWarehouse);
		
		//批量新增仓库单据主表及明细表
		List<BillWarehouseItem> allOutist = new ArrayList<BillWarehouseItem>();
		//新增明细表
		DecimalFormat df=new DecimalFormat("0000");
		Integer index = 0;
		String idString = "";
		Long idLong = 0L;
		Long bilItemId=billWarehouseItemMapper.getIDValue();
		for (BillDeliveryItemVo item : list) {
			BillWarehouseItem allocationOutItem = new BillWarehouseItem();
			index++;
			idString=df.format(index);
			idLong = Long.valueOf(bilItemId.toString() + idString);
			allocationOutItem.setId(idLong);
			allocationOutItem.setBillId(billWarehouse.getId());
			allocationOutItem.setBillStatusDictId(EnumBillStatus.DOING.getValue());
			allocationOutItem.setQuantityFinish(0.0);
			allocationOutItem.setQuantityScan(0.0);
			allocationOutItem.setMaterialId(item.getMaterialId());
			allocationOutItem.setProductId(item.getProductId());
			allocationOutItem.setQuantity(item.getSumqty());
			allocationOutItem.setTenantId(commonParam.getTenantId());
			allocationOutItem.setCreateUserId(Long.valueOf(commonParam.getUserId()));
			allocationOutItem.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			allOutist.add(allocationOutItem);
		}
		//批量新增明细表
		billWarehouseItemMapper.insertBatch(allOutist);
		billList.addAll(allOutist);
		
		return billList;
	}
}
