package com.techsoft.dao.bill;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.utils.zklock.DistributedLock;
import com.techsoft.utils.zklock.LockManager;
import com.techsoft.entity.bill.BillDeliveryItemParamVo;
import com.techsoft.entity.bill.BillWarehouseItemParamVo;
import com.techsoft.entity.common.BillDeliveryItem;
import com.techsoft.entity.common.BillPurchaseItem;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.mapper.bill.BillDeliveryItemMapper;
import com.techsoft.mapper.bill.BillPurchaseItemMapper;

@Repository
public class BillPurchaseItemDaoImpl extends BaseDaoImpl<BillPurchaseItem> implements BillPurchaseItemDao {
	@Resource
	protected BillPurchaseItemMapper billPurchaseItemMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	@Resource
	protected BillDeliveryItemMapper billDeliveryItemMapper;
	
	@Override
	public Class<BillPurchaseItem> getEntityClass() {
		return BillPurchaseItem.class;
	}	
	
	@Override
	public BaseMapper<BillPurchaseItem> getBaseMapper() {
		return this.billPurchaseItemMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "BILL_PURCHASE_ITEM";
	}
	
	@Override
	public void insertSaveCheck(BillPurchaseItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(BillPurchaseItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(BillPurchaseItem value) throws BusinessException, SQLException {
	
	}
		
	
	/**
	*@auther:Chenzj
	*@version:2019年5月27日下午4:35:16
	*@param id                  采购单明细ID
	*@param billStatusDictId    单据状态
	*@param quality             数量
	*@description
	*/
	
	@Override
	public void updatePurchaseBill(Long id, Long billStatusDictId, Double quality, CommonParam commonParam)
			throws BusinessException, SQLException {
		
		DistributedLock distributedLock = LockManager.getZKDistributedLock(this.getEntityClass().getName(),
				id.toString());
		distributedLock.lock();
		try {
			BillPurchaseItem item = billPurchaseItemMapper.selectById(id);
			if (quality!=null){
			item.setQuantityFinish(item.getQuantityFinish() + quality);
			item.setQuantityScan(item.getQuantityScan() + quality);
			}
			item.setBillStatusDictId(billStatusDictId);
			item.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			item.setTenantId(commonParam.getTenantId());
			billPurchaseItemMapper.updatePartEntity(item);
		} finally {
			distributedLock.unlock();
		}

	}
	
	/**
	*@auther:Chenzj
	*@version:2019年5月27日下午4:35:16
	*@param id                  采购单明细ID
	*@param billStatusDictId    单据状态
	*@param quality             数量
	*@description
	*/
	
	@Override
	public void updatePurchaseBillStatus(Long id, Long billStatusDictId,CommonParam commonParam)
			throws BusinessException, SQLException {
		
		DistributedLock distributedLock = LockManager.getZKDistributedLock(this.getEntityClass().getName(),
				id.toString());
		distributedLock.lock();
		try {
			BillPurchaseItem item = billPurchaseItemMapper.selectById(id);
			item.setBillStatusDictId(billStatusDictId);
			item.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			item.setTenantId(commonParam.getTenantId());
			billPurchaseItemMapper.updatePartEntity(item);
		} finally {
			distributedLock.unlock();
		}

	}
	
	/**
	 * 
	 *@auther :Yang
	 *@version :2019年7月22日
	 *@param id
	 *@param billStatusDictId
	 *@param commonParam
	 *@throws BusinessException
	 *@throws SQLException
	 *@description 更新状态
	 */
	@Override
	public void updatePurchaseBillStatusS(Long id, Long billStatusDictId,CommonParam commonParam)
			throws BusinessException, SQLException {
		
		DistributedLock distributedLock = LockManager.getZKDistributedLock(this.getEntityClass().getName(),
				id.toString());
		distributedLock.lock();
		try {
			BillPurchaseItem item = new BillPurchaseItem();
			item.setBillPurchaseId(id);
			item.setBillStatusDictId(billStatusDictId);
			item.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			item.setTenantId(commonParam.getTenantId());
			billPurchaseItemMapper.updatePartEntityS(item);
		} finally {
			distributedLock.unlock();
		}

	}
}
