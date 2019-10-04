package com.techsoft.dao.bill;

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
import com.techsoft.entity.common.BillPurchaseItem;
import com.techsoft.entity.common.BillSaleorderItem;
import com.techsoft.mapper.bill.BillSaleorderItemMapper;

@Repository
public class BillSaleorderItemDaoImpl extends BaseDaoImpl<BillSaleorderItem> implements BillSaleorderItemDao {
	@Resource
	protected BillSaleorderItemMapper billSaleorderItemMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<BillSaleorderItem> getEntityClass() {
		return BillSaleorderItem.class;
	}	
	
	@Override
	public BaseMapper<BillSaleorderItem> getBaseMapper() {
		return this.billSaleorderItemMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "BILL_SALEORDER_ITEM";
	}
	
	@Override
	public void insertSaveCheck(BillSaleorderItem value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("请先登录 ");
		}
		if (value.getProductId() == null || value.getProductId()==0L) {
			throw new BusinessException("物品不能为空 ");
		}
		if (value.getMaterialId() == null || value.getMaterialId()==0L) {
			throw new BusinessException("物料不能为空 ");
		}
		if (value.getQuantity() == null || value.getQuantity()==0) {
			throw new BusinessException("单据数量不能为空或0 ");
		}
		if (value.getRemark().length()>128) {
			throw new BusinessException("备注不能超过128个字符 ");
		}
		/*if (value.getQuantityFinish() == null || value.getQuantityFinish()==0) {
			throw new BusinessException("完成数量不能为空或0 ");
		}*/
		
	}
	
	@Override
	public void updateSaveCheck(BillSaleorderItem value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("请先登录 ");
		}
		if (value.getProductId() == null || value.getProductId()==0L) {
			throw new BusinessException("物品不能为空 ");
		}
		if (value.getMaterialId() == null || value.getMaterialId()==0L) {
			throw new BusinessException("物料不能为空 ");
		}
		if (value.getQuantity() == null || value.getQuantity()==0) {
			throw new BusinessException("单据数量不能为空或0 ");
		}
		if (value.getRemark().length()>128) {
			throw new BusinessException("备注不能超过128个字符 ");
		}
	}
	
	@Override
	public void deleteSaveCheck(BillSaleorderItem value) throws BusinessException, SQLException {
	
	}
	/**
	 * 
	 *@auther :Yang
	 *@version :2019年7月24日
	 *@param id
	 *@param billStatusDictId
	 *@param commonParam
	 *@throws BusinessException
	 *@throws SQLException
	 *@description
	 */
	@Override
	public void updateSaleorderBillStatus(Long id, Long billStatusDictId,CommonParam commonParam)
			throws BusinessException, SQLException {
		
		DistributedLock distributedLock = LockManager.getZKDistributedLock(this.getEntityClass().getName(),
				id.toString());
		distributedLock.lock();
		try {
			BillSaleorderItem item = new BillSaleorderItem();
			item.setBillSaleorderId(id);
			item.setBillStatusDictId(billStatusDictId);
			item.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			item.setTenantId(commonParam.getTenantId());
			billSaleorderItemMapper.updatePartEntityS(item);
		} finally {
			distributedLock.unlock();
		}

	}
			
}
