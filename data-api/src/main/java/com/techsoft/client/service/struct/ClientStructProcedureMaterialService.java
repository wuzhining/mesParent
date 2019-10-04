package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructProcedureMaterial;
import com.techsoft.entity.struct.StructProcedureMaterialVo;
import com.techsoft.entity.struct.StructProcedureMaterialParamVo;

public interface ClientStructProcedureMaterialService extends BaseClientService<StructProcedureMaterial> {
	
	public StructProcedureMaterialVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProcedureMaterialVo>  selectListVoByParamVo(StructProcedureMaterialParamVo structProcedureMaterial, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProcedureMaterialVo>  selectPageVoByParamVo(StructProcedureMaterialParamVo structProcedureMaterial, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public StructProcedureMaterialVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProcedureMaterialVo>  selectListExtendVoByParamVo(StructProcedureMaterialParamVo structProcedureMaterial, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProcedureMaterialVo>  selectPageExtendVoByParamVo(StructProcedureMaterialParamVo structProcedureMaterial, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(StructProcedureMaterialParamVo structProcedureMaterialParamVo, CommonParam commonParam);		
}
