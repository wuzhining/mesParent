package com.techsoft.dao.warehouse;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WarehouseLocation;

public interface WarehouseLocationDao extends BaseDao<WarehouseLocation> {

	/**
	 * 批量增加货位
	 * 
	 * @param locations
	 *            货位列表
	 * @return 新增加的货位数量
	 */
	public void insertBatch(List<WarehouseLocation> locations, CommonParam commonParam) throws BusinessException, SQLException;

}
