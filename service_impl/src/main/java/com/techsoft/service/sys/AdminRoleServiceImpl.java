package com.techsoft.service.sys;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.sys.AdminRoleDao;
import com.techsoft.entity.common.AdminRole;

@Service
public class AdminRoleServiceImpl extends BaseServiceImpl<AdminRole> implements AdminRoleService {
	@Autowired
	private AdminRoleDao adminRoleDao;
	
	@Override
	public BaseDao<AdminRole> getBaseDao() {
		return adminRoleDao;
	}	
	
	@Override
	public Class<AdminRole> getEntityClass() {
		return AdminRole.class;
	}	
	
	@Override
	protected AdminRole insertEntity(AdminRole entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected AdminRole updatePartEntity(AdminRole entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected AdminRole updateEntity(AdminRole entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}	
}
