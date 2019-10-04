package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructProcedureMaterial;
import com.techsoft.mapper.struct.StructProcedureMaterialMapper;

@Repository
public class StructProcedureMaterialDaoImpl extends BaseDaoImpl<StructProcedureMaterial> implements StructProcedureMaterialDao {
	@Resource
	protected StructProcedureMaterialMapper structProcedureMaterialMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<StructProcedureMaterial> getEntityClass() {
		return StructProcedureMaterial.class;
	}	
	
	@Override
	public BaseMapper<StructProcedureMaterial> getBaseMapper() {
		return this.structProcedureMaterialMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "STRUCT_PROCEDURE_MATERIAL";
	}
	
	@Override
	public void insertSaveCheck(StructProcedureMaterial value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(StructProcedureMaterial value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(StructProcedureMaterial value) throws BusinessException, SQLException {
	
	}
			
}
