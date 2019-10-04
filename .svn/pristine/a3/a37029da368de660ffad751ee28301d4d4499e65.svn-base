package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructProcedure;
import com.techsoft.entity.struct.StructProcedureVo;
import com.techsoft.entity.struct.StructProcedureParamVo;

public interface ClientStructProcedureService extends BaseClientService<StructProcedure> {

	public StructProcedureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructProcedureVo> selectListVoByParamVo(StructProcedureParamVo structProcedure,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructProcedureVo> selectPageVoByParamVo(StructProcedureParamVo structProcedure,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public StructProcedureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructProcedureVo> selectListExtendVoByParamVo(StructProcedureParamVo structProcedure,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructProcedureVo> selectPageExtendVoByParamVo(StructProcedureParamVo structProcedure,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(StructProcedureParamVo structProcedureParamVo, CommonParam commonParam);
}
