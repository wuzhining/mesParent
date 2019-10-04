package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructProcedureWorkstation;
import com.techsoft.entity.struct.StructProcedureWorkstationVo;
import com.techsoft.entity.struct.StructProcedureWorkstationParamVo;

public interface ClientStructProcedureWorkstationService extends BaseClientService<StructProcedureWorkstation> {
	
	public StructProcedureWorkstationVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProcedureWorkstationVo>  selectListVoByParamVo(StructProcedureWorkstationParamVo structProcedureWorkstation, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProcedureWorkstationVo>  selectPageVoByParamVo(StructProcedureWorkstationParamVo structProcedureWorkstation, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public StructProcedureWorkstationVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProcedureWorkstationVo>  selectListExtendVoByParamVo(StructProcedureWorkstationParamVo structProcedureWorkstation, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProcedureWorkstationVo>  selectPageExtendVoByParamVo(StructProcedureWorkstationParamVo structProcedureWorkstation, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(StructProcedureWorkstationParamVo structProcedureWorkstationParamVo, CommonParam commonParam);		
}
