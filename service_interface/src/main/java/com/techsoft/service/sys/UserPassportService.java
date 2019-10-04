package com.techsoft.service.sys;

import com.techsoft.common.BaseService;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.UserPassport;

public interface UserPassportService extends BaseService<UserPassport> {
	/**
	 * 
	 * 
	 * /** 根据用户名取对象
	 */
	public UserPassport getByUserName(String userName) throws SQLException;
}
