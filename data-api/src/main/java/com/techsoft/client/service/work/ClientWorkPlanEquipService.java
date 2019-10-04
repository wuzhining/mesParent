package com.techsoft.client.service.work;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.WorkPlanEquip;
import com.techsoft.entity.work.WorkPlanEquipVo;
import com.techsoft.entity.work.WorkPlanEquipParamVo;

public interface ClientWorkPlanEquipService extends BaseClientService<WorkPlanEquip> {
	
	public WorkPlanEquipVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<WorkPlanEquipVo>  selectListVoByParamVo(WorkPlanEquipParamVo workPlanEquip, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<WorkPlanEquipVo>  selectPageVoByParamVo(WorkPlanEquipParamVo workPlanEquip, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public WorkPlanEquipVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<WorkPlanEquipVo>  selectListExtendVoByParamVo(WorkPlanEquipParamVo workPlanEquip, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<WorkPlanEquipVo>  selectPageExtendVoByParamVo(WorkPlanEquipParamVo workPlanEquip, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(WorkPlanEquipParamVo workPlanEquipParamVo, CommonParam commonParam);		
}
