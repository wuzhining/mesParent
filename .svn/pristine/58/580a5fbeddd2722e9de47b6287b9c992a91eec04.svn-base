package com.techsoft.service.sys;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.sys.AdminUserDao;
import com.techsoft.entity.common.AdminUser;

@Service
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUser> implements AdminUserService {
	@Autowired
	private AdminUserDao adminUserDao;
	
	@Override
	public BaseDao<AdminUser> getBaseDao() {
		return adminUserDao;
	}	
	
	@Override
	public Class<AdminUser> getEntityClass() {
		return AdminUser.class;
	}
	
	@Override
	protected AdminUser insertEntity(AdminUser entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected AdminUser updatePartEntity(AdminUser entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected AdminUser updateEntity(AdminUser entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}	
}
