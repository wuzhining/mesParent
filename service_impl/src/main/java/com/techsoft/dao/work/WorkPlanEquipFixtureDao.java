package com.techsoft.dao.work;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WorkPlanEquipFixture;

public interface WorkPlanEquipFixtureDao extends BaseDao<WorkPlanEquipFixture> {

	/**
	 * 批量新增
	 * @author
	 * @param items
	 * @param commonParam
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public void insertBatch(List<WorkPlanEquipFixture> items, CommonParam commonParam) throws BusinessException, SQLException;
}
