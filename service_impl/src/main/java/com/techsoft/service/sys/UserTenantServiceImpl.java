package com.techsoft.service.sys;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.UserTenant;
import com.techsoft.dao.sys.UserTenantDao;

@Service
public class UserTenantServiceImpl extends BaseServiceImpl<UserTenant> implements UserTenantService {
	@Autowired
	private UserTenantDao userTenantDao;
	
	@Override
	public BaseDao<UserTenant> getBaseDao() {
		return userTenantDao;
	}	
	
	@Override
	public Class<UserTenant> getEntityClass() {
		return UserTenant.class;
	}
	
	@Override
	protected UserTenant insertEntity(UserTenant entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected UserTenant updatePartEntity(UserTenant entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected UserTenant updateEntity(UserTenant entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
