package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructProcedureEquipFixture;
import com.techsoft.mapper.struct.StructProcedureEquipFixtureMapper;

@Repository
public class StructProcedureEquipFixtureDaoImpl extends BaseDaoImpl<StructProcedureEquipFixture> implements StructProcedureEquipFixtureDao {
	@Resource
	protected StructProcedureEquipFixtureMapper structProcedureEquipFixtureMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<StructProcedureEquipFixture> getEntityClass() {
		return StructProcedureEquipFixture.class;
	}	
	
	@Override
	public BaseMapper<StructProcedureEquipFixture> getBaseMapper() {
		return this.structProcedureEquipFixtureMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "STRUCT_PROCEDURE_EQUIP_FIXTURE";
	}
	
	@Override
	public void insertSaveCheck(StructProcedureEquipFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(StructProcedureEquipFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(StructProcedureEquipFixture value) throws BusinessException, SQLException {
	
	}
			
}
