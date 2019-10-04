package com.techsoft.client.service.work;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.WorkPlanMaterial;
import com.techsoft.entity.work.WorkPlanMaterialVo;
import com.techsoft.entity.work.WorkPlanMaterialParamVo;

public interface ClientWorkPlanMaterialService extends BaseClientService<WorkPlanMaterial> {
	
	public WorkPlanMaterialVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<WorkPlanMaterialVo>  selectListVoByParamVo(WorkPlanMaterialParamVo workPlanMaterial, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<WorkPlanMaterialVo>  selectPageVoByParamVo(WorkPlanMaterialParamVo workPlanMaterial, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public WorkPlanMaterialVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<WorkPlanMaterialVo>  selectListExtendVoByParamVo(WorkPlanMaterialParamVo workPlanMaterial, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<WorkPlanMaterialVo>  selectPageExtendVoByParamVo(WorkPlanMaterialParamVo workPlanMaterial, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(WorkPlanMaterialParamVo workPlanMaterialParamVo, CommonParam commonParam);		
}
