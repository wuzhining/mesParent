package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructProdlineEquipFixture;
import com.techsoft.mapper.struct.StructProdlineEquipFixtureMapper;

@Repository
public class StructProdlineEquipFixtureDaoImpl extends BaseDaoImpl<StructProdlineEquipFixture> implements StructProdlineEquipFixtureDao {
	@Resource
	protected StructProdlineEquipFixtureMapper structProdlineEquipFixtureMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<StructProdlineEquipFixture> getEntityClass() {
		return StructProdlineEquipFixture.class;
	}	
	
	@Override
	public BaseMapper<StructProdlineEquipFixture> getBaseMapper() {
		return this.structProdlineEquipFixtureMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "STRUCT_PRODLINE_EQUIP_FIXTURE";
	}
	
	@Override
	public void insertSaveCheck(StructProdlineEquipFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(StructProdlineEquipFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(StructProdlineEquipFixture value) throws BusinessException, SQLException {
	
	}
			
}
