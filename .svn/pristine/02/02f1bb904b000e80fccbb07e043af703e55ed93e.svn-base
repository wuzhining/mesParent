package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipSpecsFixtureArea;
import com.techsoft.mapper.equip.EquipSpecsFixtureAreaMapper;

@Repository
public class EquipSpecsFixtureAreaDaoImpl extends BaseDaoImpl<EquipSpecsFixtureArea> implements EquipSpecsFixtureAreaDao {
	@Resource
	protected EquipSpecsFixtureAreaMapper equipSpecsFixtureAreaMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipSpecsFixtureArea> getEntityClass() {
		return EquipSpecsFixtureArea.class;
	}	
	
	@Override
	public BaseMapper<EquipSpecsFixtureArea> getBaseMapper() {
		return this.equipSpecsFixtureAreaMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_SPECS_FIXTURE_AREA";
	}
	
	@Override
	public void insertSaveCheck(EquipSpecsFixtureArea value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipSpecsFixtureArea value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipSpecsFixtureArea value) throws BusinessException, SQLException {
	
	}
			
}
