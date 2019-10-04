package com.techsoft.dao.work;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WorkTaskProcedure;

public interface WorkTaskProcedureDao extends BaseDao<WorkTaskProcedure> {
	
	/**
	 * 批量新增工作工序任务
	 * @author
	 * @param items
	 * @param commonParam
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public void insertBatch(List<WorkTaskProcedure> items, CommonParam commonParam) throws BusinessException, SQLException;

}
