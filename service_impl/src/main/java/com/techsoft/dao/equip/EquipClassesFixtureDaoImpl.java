package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipClassesFixture;
import com.techsoft.mapper.equip.EquipClassesFixtureMapper;

@Repository
public class EquipClassesFixtureDaoImpl extends BaseDaoImpl<EquipClassesFixture> implements EquipClassesFixtureDao {
	@Resource
	protected EquipClassesFixtureMapper equipClassesFixtureMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipClassesFixture> getEntityClass() {
		return EquipClassesFixture.class;
	}	
	
	@Override
	public BaseMapper<EquipClassesFixture> getBaseMapper() {
		return this.equipClassesFixtureMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_CLASSES_FIXTURE";
	}
	
	@Override
	public void insertSaveCheck(EquipClassesFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipClassesFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipClassesFixture value) throws BusinessException, SQLException {
	
	}
			
}
