package com.techsoft.service.struct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumProcedureInstructType;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.struct.StructProcedureInstructParamVo;
import com.techsoft.dao.struct.StructProcedureInstructDao;

@Service
public class StructProcedureInstructServiceImpl extends BaseServiceImpl<StructProcedureInstruct>
		implements StructProcedureInstructService {
	@Autowired
	private StructProcedureInstructDao structProcedureInstructDao;

	@Override
	public BaseDao<StructProcedureInstruct> getBaseDao() {
		return structProcedureInstructDao;
	}

	@Override
	public Class<StructProcedureInstruct> getEntityClass() {
		return StructProcedureInstruct.class;
	}

	@Override
	protected StructProcedureInstruct insertEntity(StructProcedureInstruct entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructProcedureInstruct updatePartEntity(StructProcedureInstruct entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructProcedureInstruct updateEntity(StructProcedureInstruct entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public StructProcedureInstruct getByType(CommonParam commonParam, Long processNodeId, Long instructTypeDictId)
			throws SQLException {
		StructProcedureInstruct procedureInstruct = null; // 工序指令
		StructProcedureInstructParamVo procedureInstructParamVo = new StructProcedureInstructParamVo();
		procedureInstructParamVo.setTenantId(commonParam.getTenantId());
		procedureInstructParamVo.setInstructTypeDictId(instructTypeDictId);
		procedureInstructParamVo.setProcessNodeId(processNodeId);

		List<StructProcedureInstruct> procedureInstructList = structProcedureInstructDao
				.selectListByParamVo(procedureInstructParamVo);
		if ((procedureInstructList != null) && (!procedureInstructList.isEmpty())) {
			procedureInstruct = procedureInstructList.get(0);
		}

		return procedureInstruct;

	}
}
