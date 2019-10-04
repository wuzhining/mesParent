package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipFixtureStack;
import com.techsoft.mapper.equip.EquipFixtureStackMapper;

@Repository
public class EquipFixtureStackDaoImpl extends BaseDaoImpl<EquipFixtureStack> implements EquipFixtureStackDao {
	@Resource
	protected EquipFixtureStackMapper equipFixtureStackMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipFixtureStack> getEntityClass() {
		return EquipFixtureStack.class;
	}	
	
	@Override
	public BaseMapper<EquipFixtureStack> getBaseMapper() {
		return this.equipFixtureStackMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_FIXTURE_STACK";
	}
	
	@Override
	public void insertSaveCheck(EquipFixtureStack value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipFixtureStack value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipFixtureStack value) throws BusinessException, SQLException {
	
	}
			
}
