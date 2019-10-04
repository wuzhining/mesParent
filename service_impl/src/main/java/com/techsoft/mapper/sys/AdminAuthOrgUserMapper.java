package com.techsoft.mapper.sys;

import java.util.List;

import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.AdminAuthOrgUser;

public interface AdminAuthOrgUserMapper extends BaseMapper<AdminAuthOrgUser> {
	public int insertAuthOrgsUser(List<AdminAuthOrgUser> adminAuthOrgUser) throws BusinessException, SQLException;
	
}
