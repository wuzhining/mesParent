package com.techsoft.dao.bill;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.utils.zklock.DistributedLock;
import com.techsoft.utils.zklock.LockManager;
import com.techsoft.entity.common.BillInventory;
import com.techsoft.entity.common.BillInventoryItem;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.mapper.bill.BillInventoryItemMapper;

@Repository
public class BillInventoryItemDaoImpl extends BaseDaoImpl<BillInventoryItem> implements BillInventoryItemDao {
	@Resource
	protected BillInventoryItemMapper billInventoryItemMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<BillInventoryItem> getEntityClass() {
		return BillInventoryItem.class;
	}	
	
	@Override
	public BaseMapper<BillInventoryItem> getBaseMapper() {
		return this.billInventoryItemMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "BILL_INVENTORY_ITEM";
	}
	
	@Override
	public void insertSaveCheck(BillInventoryItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(BillInventoryItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(BillInventoryItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void insertBatch(List<BillInventoryItem> list, CommonParam commonParam) throws BusinessException, SQLException {
		try {
			if (list.size()==0) {
				throw new BusinessException("该盘点单所属仓库无库存物料信息");
			}else{
			for (BillInventoryItem item : list) {
				insertSaveCheck(item);
				if (commonParam.getUserId() != null) {
					item.setCreateUserId(Long.valueOf(commonParam.getUserId()));
					item.setModifyUserId(Long.valueOf(commonParam.getUserId()));
				}
			}
			int rows = this.billInventoryItemMapper.insertBatch(list);
			if (rows != list.size()) {
				throw new BusinessException("新增数量不一致！请检查");
			}
		  }
		} catch (RuntimeException e) {
			throw new SQLException(e.getMessage());
		}
	}
	
	@Override
	public void updateQTYofInventory(Long id,Double quality, CommonParam commonParam)
			throws BusinessException, SQLException {
		DistributedLock distributedLock = LockManager.getZKDistributedLock(this.getEntityClass().getName(),
				id.toString());
		distributedLock.lock();
		try {
			BillInventoryItem item = this.selectById(id);
			item.setQuantity(item.getQuantity()+quality);
			//item.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			item.setModifyUserId((long) 1);
			this.updatePartEntity(item, commonParam);
		} finally {
			distributedLock.unlock();
		}

	}
	
	@Override
	public ResultMessage updateItemQty(Long id, Double updateQty,String type,CommonParam commonParam)
			throws BusinessException, SQLException {
		 ResultMessage resultMessage = new ResultMessage();
		DistributedLock distributedLock = LockManager.getZKDistributedLock(this.getEntityClass().getName(),
				id.toString());
		distributedLock.lock();
		try {
			BillInventoryItem item = this.selectById(id);
			if (type.equals("reduce")) {
				item.setQuantity(item.getQuantity()-updateQty);
			} else if(type.equals("add")) {
				item.setQuantity(item.getQuantity()+updateQty);
			}
			
			this.updatePartEntity(item, commonParam);
		} finally {
			distributedLock.unlock();
		}
		
		resultMessage.setIsSuccess(true);
		return resultMessage;
	}
}
