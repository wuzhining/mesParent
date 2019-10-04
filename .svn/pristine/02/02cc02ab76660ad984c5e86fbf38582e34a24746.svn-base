package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.mapper.equip.EquipSpecsFixtureMapper;

@Repository
public class EquipSpecsFixtureDaoImpl extends BaseDaoImpl<EquipSpecsFixture> implements EquipSpecsFixtureDao {
	@Resource
	protected EquipSpecsFixtureMapper equipSpecsFixtureMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipSpecsFixture> getEntityClass() {
		return EquipSpecsFixture.class;
	}	
	
	@Override
	public BaseMapper<EquipSpecsFixture> getBaseMapper() {
		return this.equipSpecsFixtureMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_SPECS_FIXTURE";
	}
	
	@Override
	public void insertSaveCheck(EquipSpecsFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipSpecsFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipSpecsFixture value) throws BusinessException, SQLException {
	
	}
			
}
