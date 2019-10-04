package com.techsoft.service.work;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WorkPlanWorkstation;
import com.techsoft.entity.work.WorkPlanWorkstationParamVo;

public interface WorkPlanWorkstationService extends BaseService<WorkPlanWorkstation> {

	//获取可以工位的计划
	public List<WorkPlanWorkstation>  selectListCanWorking(WorkPlanWorkstationParamVo workPlanWorkstationParamVo , CommonParam commonParam) throws BusinessException, SQLException;
}
