package com.techsoft.dao.work;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WorkPlanWorkstation;

public interface WorkPlanWorkstationDao extends BaseDao<WorkPlanWorkstation> {
	/**
	 * 批量新增
	 * @author
	 * @param items
	 * @param commonParam
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public void insertBatch(List<WorkPlanWorkstation> items, CommonParam commonParam) throws BusinessException, SQLException;
}
