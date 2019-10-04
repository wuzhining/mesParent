package com.techsoft.dao.struct;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.struct.StructProcedureInstructParamVo;
import com.techsoft.mapper.struct.StructProcedureInstructMapper;

@Repository
public class StructProcedureInstructDaoImpl extends BaseDaoImpl<StructProcedureInstruct> implements StructProcedureInstructDao {
	@Resource
	protected StructProcedureInstructMapper structProcedureInstructMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<StructProcedureInstruct> getEntityClass() {
		return StructProcedureInstruct.class;
	}	
	
	@Override
	public BaseMapper<StructProcedureInstruct> getBaseMapper() {
		return this.structProcedureInstructMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "STRUCT_PROCEDURE_INSTRUCT";
	}
	
	@Override
	public void insertSaveCheck(StructProcedureInstruct value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(StructProcedureInstruct value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(StructProcedureInstruct value) throws BusinessException, SQLException {
	
	}

	@Override
	public StructProcedureInstruct getByType(CommonParam commonParam, Long processNodeId, Long instructTypeDictId)
			throws SQLException {
		StructProcedureInstruct procedureInstruct = null; // 工序指令
		StructProcedureInstructParamVo procedureInstructParamVo = new StructProcedureInstructParamVo();
		procedureInstructParamVo.setTenantId(commonParam.getTenantId());
		procedureInstructParamVo.setInstructTypeDictId(instructTypeDictId);
		procedureInstructParamVo.setProcessNodeId(processNodeId);

		List<StructProcedureInstruct> procedureInstructList = structProcedureInstructMapper.selectListByEntityParamVo(procedureInstructParamVo);
		if ((procedureInstructList != null) && (!procedureInstructList.isEmpty())) {
			procedureInstruct = procedureInstructList.get(0);
		}

		return procedureInstruct;
	}
			
}
