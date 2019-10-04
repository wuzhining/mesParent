package com.techsoft.dao.work;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WorkPlanEquip;
import com.techsoft.entity.work.WorkPlanEquipParamVo;

public interface WorkPlanEquipDao extends BaseDao<WorkPlanEquip> {
	
	/**
	 * 批量新增
	 * @author
	 * @param items
	 * @param commonParam
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public void insertBatch(List<WorkPlanEquip> items, CommonParam commonParam) throws BusinessException, SQLException;
	

	//获取可以工作的计划
	public List<WorkPlanEquip>  selectListCanWorking(WorkPlanEquipParamVo workPlanEquipParamVo , CommonParam commonParam) throws BusinessException, SQLException;
}
