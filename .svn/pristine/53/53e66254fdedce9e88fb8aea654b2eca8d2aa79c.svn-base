package com.techsoft.dao.bill;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.BillEquip;
import com.techsoft.mapper.bill.BillEquipMapper;

@Repository
public class BillEquipDaoImpl extends BaseDaoImpl<BillEquip> implements BillEquipDao {
	@Resource
	protected BillEquipMapper billEquipMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<BillEquip> getEntityClass() {
		return BillEquip.class;
	}	
	
	@Override
	public BaseMapper<BillEquip> getBaseMapper() {
		return this.billEquipMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "BILL_EQUIP";
	}
	
	@Override
	public void insertSaveCheck(BillEquip value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(BillEquip value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(BillEquip value) throws BusinessException, SQLException {
	
	}
			
}
