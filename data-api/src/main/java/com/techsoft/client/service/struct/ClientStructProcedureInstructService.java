package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.struct.StructProcedureInstructVo;
import com.techsoft.entity.struct.StructProcedureInstructParamVo;

public interface ClientStructProcedureInstructService extends BaseClientService<StructProcedureInstruct> {
	
	public StructProcedureInstructVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProcedureInstructVo>  selectListVoByParamVo(StructProcedureInstructParamVo structProcedureInstruct, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProcedureInstructVo>  selectPageVoByParamVo(StructProcedureInstructParamVo structProcedureInstruct, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public StructProcedureInstructVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProcedureInstructVo>  selectListExtendVoByParamVo(StructProcedureInstructParamVo structProcedureInstruct, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProcedureInstructVo>  selectPageExtendVoByParamVo(StructProcedureInstructParamVo structProcedureInstruct, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(StructProcedureInstructParamVo structProcedureInstructParamVo, CommonParam commonParam);		
}
