package com.techsoft.service.sys;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.sys.AdminRoleFunctionDao;
import com.techsoft.entity.common.AdminRoleFunction;

@Service
public class AdminRoleFunctionServiceImpl extends BaseServiceImpl<AdminRoleFunction> implements AdminRoleFunctionService {
	@Autowired
	private AdminRoleFunctionDao adminRoleFunctionDao;
	
	@Override
	public BaseDao<AdminRoleFunction> getBaseDao() {
		return adminRoleFunctionDao;
	}	
	
	@Override
	public Class<AdminRoleFunction> getEntityClass() {
		return AdminRoleFunction.class;
	}	
	
	@Override
	protected AdminRoleFunction insertEntity(AdminRoleFunction entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected AdminRoleFunction updatePartEntity(AdminRoleFunction entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected AdminRoleFunction updateEntity(AdminRoleFunction entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}	
}
