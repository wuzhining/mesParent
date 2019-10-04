package com.techsoft.dao.firm;

import com.techsoft.common.BaseDao;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.FirmEmployee;

public interface FirmEmployeeDao extends BaseDao<FirmEmployee> { 
	public FirmEmployee getByUserId(Long userId) throws SQLException ;
}
