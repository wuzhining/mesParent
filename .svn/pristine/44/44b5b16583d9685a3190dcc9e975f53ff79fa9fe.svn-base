package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipWorkStack;
import com.techsoft.mapper.equip.EquipWorkStackMapper;

@Repository
public class EquipWorkStackDaoImpl extends BaseDaoImpl<EquipWorkStack> implements EquipWorkStackDao {
	@Resource
	protected EquipWorkStackMapper equipWorkStackMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipWorkStack> getEntityClass() {
		return EquipWorkStack.class;
	}	
	
	@Override
	public BaseMapper<EquipWorkStack> getBaseMapper() {
		return this.equipWorkStackMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_WORK_STACK";
	}
	
	@Override
	public void insertSaveCheck(EquipWorkStack value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipWorkStack value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipWorkStack value) throws BusinessException, SQLException {
	
	}
			
}
