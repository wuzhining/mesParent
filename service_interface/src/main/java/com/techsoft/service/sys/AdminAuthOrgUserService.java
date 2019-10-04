package com.techsoft.service.sys;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.AdminAuthOrgUser;
import com.techsoft.entity.sys.AdminAuthOrgUserParamVo;

public interface AdminAuthOrgUserService extends BaseService<AdminAuthOrgUser> {
  
	/**
	 * 批量增加分配数据权限表
	 */
	public int insertAuthOrgsUser(AdminAuthOrgUserParamVo adminAuthOrgUserParamVo, CommonParam commonParam)
			throws BusinessException, SQLException;
}
