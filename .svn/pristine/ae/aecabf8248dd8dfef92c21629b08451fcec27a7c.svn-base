package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipFixture;
import com.techsoft.mapper.equip.EquipFixtureMapper;

@Repository
public class EquipFixtureDaoImpl extends BaseDaoImpl<EquipFixture> implements EquipFixtureDao {
	@Resource
	protected EquipFixtureMapper equipFixtureMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipFixture> getEntityClass() {
		return EquipFixture.class;
	}	
	
	@Override
	public BaseMapper<EquipFixture> getBaseMapper() {
		return this.equipFixtureMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_FIXTURE";
	}
	
	@Override
	public void insertSaveCheck(EquipFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipFixture value) throws BusinessException, SQLException {
	
	}
			
}
