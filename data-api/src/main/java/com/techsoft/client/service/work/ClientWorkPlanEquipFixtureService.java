package com.techsoft.client.service.work;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.WorkPlanEquipFixture;
import com.techsoft.entity.work.WorkPlanEquipFixtureVo;
import com.techsoft.entity.work.WorkPlanEquipFixtureParamVo;

public interface ClientWorkPlanEquipFixtureService extends BaseClientService<WorkPlanEquipFixture> {
	
	public WorkPlanEquipFixtureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<WorkPlanEquipFixtureVo>  selectListVoByParamVo(WorkPlanEquipFixtureParamVo workPlanEquipFixture, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<WorkPlanEquipFixtureVo>  selectPageVoByParamVo(WorkPlanEquipFixtureParamVo workPlanEquipFixture, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public WorkPlanEquipFixtureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<WorkPlanEquipFixtureVo>  selectListExtendVoByParamVo(WorkPlanEquipFixtureParamVo workPlanEquipFixture, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<WorkPlanEquipFixtureVo>  selectPageExtendVoByParamVo(WorkPlanEquipFixtureParamVo workPlanEquipFixture, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(WorkPlanEquipFixtureParamVo workPlanEquipFixtureParamVo, CommonParam commonParam);		
}
