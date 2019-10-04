package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipFixtureConfig;
import com.techsoft.mapper.equip.EquipFixtureConfigMapper;

@Repository
public class EquipFixtureConfigDaoImpl extends BaseDaoImpl<EquipFixtureConfig> implements EquipFixtureConfigDao {
	@Resource
	protected EquipFixtureConfigMapper equipFixtureConfigMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipFixtureConfig> getEntityClass() {
		return EquipFixtureConfig.class;
	}	
	
	@Override
	public BaseMapper<EquipFixtureConfig> getBaseMapper() {
		return this.equipFixtureConfigMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_FIXTURE_CONFIG";
	}
	
	@Override
	public void insertSaveCheck(EquipFixtureConfig value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipFixtureConfig value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipFixtureConfig value) throws BusinessException, SQLException {
	
	}
			
}
