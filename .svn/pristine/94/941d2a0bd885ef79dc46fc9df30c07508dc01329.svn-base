package com.techsoft.service.sys;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.sys.AdminRoleUserDao;
import com.techsoft.entity.common.AdminRoleUser;

@Service
public class AdminRoleUserServiceImpl extends BaseServiceImpl<AdminRoleUser> implements AdminRoleUserService {
	@Autowired
	private AdminRoleUserDao adminRoleUserDao;
	
	@Override
	public BaseDao<AdminRoleUser> getBaseDao() {
		return adminRoleUserDao;
	}	
	
	@Override
	public Class<AdminRoleUser> getEntityClass() {
		return AdminRoleUser.class;
	}
	
	@Override
	protected AdminRoleUser insertEntity(AdminRoleUser entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected AdminRoleUser updatePartEntity(AdminRoleUser entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected AdminRoleUser updateEntity(AdminRoleUser entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}	
}
