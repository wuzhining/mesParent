package com.techsoft.dao.work;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WorkPlanMaterial;

public interface WorkPlanMaterialDao extends BaseDao<WorkPlanMaterial> {
	public void updateBatch(List<WorkPlanMaterial> list,CommonParam commonParam) throws BusinessException,SQLException;
	
	/**
	 * 批量新增工作物料计划
	 * @author
	 * @param items
	 * @param commonParam
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public void insertBatch(List<WorkPlanMaterial> items, CommonParam commonParam) throws BusinessException, SQLException;
}
