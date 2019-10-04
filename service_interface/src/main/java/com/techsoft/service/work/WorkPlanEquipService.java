package com.techsoft.service.work;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException; 
import com.techsoft.entity.common.WorkPlanEquip;
import com.techsoft.entity.work.WorkPlanEquipParamVo;

public interface WorkPlanEquipService extends BaseService<WorkPlanEquip> {

	//获取可以工作的计划
	public List<WorkPlanEquip>  selectListCanWorking(WorkPlanEquipParamVo workPlanEquipParamVo , CommonParam commonParam) throws BusinessException, SQLException;
}
