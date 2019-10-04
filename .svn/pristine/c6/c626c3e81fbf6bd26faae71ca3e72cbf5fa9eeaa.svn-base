package com.techsoft.dao.bill;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.BillEquipItem;
import com.techsoft.mapper.bill.BillEquipItemMapper;

@Repository
public class BillEquipItemDaoImpl extends BaseDaoImpl<BillEquipItem> implements BillEquipItemDao {
	@Resource
	protected BillEquipItemMapper billEquipItemMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<BillEquipItem> getEntityClass() {
		return BillEquipItem.class;
	}	
	
	@Override
	public BaseMapper<BillEquipItem> getBaseMapper() {
		return this.billEquipItemMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "BILL_EQUIP_ITEM";
	}
	
	@Override
	public void insertSaveCheck(BillEquipItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(BillEquipItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(BillEquipItem value) throws BusinessException, SQLException {
	
	}
			
}
