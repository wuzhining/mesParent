package com.techsoft.client.service.work;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.WorkPlanWorkstation;
import com.techsoft.entity.work.WorkPlanWorkstationVo;
import com.techsoft.entity.work.WorkPlanWorkstationParamVo;

public interface ClientWorkPlanWorkstationService extends BaseClientService<WorkPlanWorkstation> {
	
	public WorkPlanWorkstationVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<WorkPlanWorkstationVo>  selectListVoByParamVo(WorkPlanWorkstationParamVo workPlanWorkstation, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<WorkPlanWorkstationVo>  selectPageVoByParamVo(WorkPlanWorkstationParamVo workPlanWorkstation, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public WorkPlanWorkstationVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<WorkPlanWorkstationVo>  selectListExtendVoByParamVo(WorkPlanWorkstationParamVo workPlanWorkstation, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<WorkPlanWorkstationVo>  selectPageExtendVoByParamVo(WorkPlanWorkstationParamVo workPlanWorkstation, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(WorkPlanWorkstationParamVo workPlanWorkstationParamVo, CommonParam commonParam);		
}
