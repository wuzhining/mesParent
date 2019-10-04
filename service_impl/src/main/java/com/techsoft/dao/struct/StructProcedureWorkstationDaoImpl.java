package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructProcedureWorkstation;
import com.techsoft.mapper.struct.StructProcedureWorkstationMapper;

@Repository
public class StructProcedureWorkstationDaoImpl extends BaseDaoImpl<StructProcedureWorkstation> implements StructProcedureWorkstationDao {
	@Resource
	protected StructProcedureWorkstationMapper structProcedureWorkstationMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<StructProcedureWorkstation> getEntityClass() {
		return StructProcedureWorkstation.class;
	}	
	
	@Override
	public BaseMapper<StructProcedureWorkstation> getBaseMapper() {
		return this.structProcedureWorkstationMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "STRUCT_PROCEDURE_WORKSTATION";
	}
	
	@Override
	public void insertSaveCheck(StructProcedureWorkstation value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(StructProcedureWorkstation value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(StructProcedureWorkstation value) throws BusinessException, SQLException {
	
	}
			
}
