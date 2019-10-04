package com.techsoft.service.sys;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.sys.AdminRoleMenuDao;
import com.techsoft.entity.common.AdminRoleMenu;

@Service
public class AdminRoleMenuServiceImpl extends BaseServiceImpl<AdminRoleMenu> implements AdminRoleMenuService {
	@Autowired
	private AdminRoleMenuDao adminRoleMenuDao;
	
	@Override
	public BaseDao<AdminRoleMenu> getBaseDao() {
		return adminRoleMenuDao;
	}	
	
	@Override
	public Class<AdminRoleMenu> getEntityClass() {
		return AdminRoleMenu.class;
	}	
	
	@Override
	protected AdminRoleMenu insertEntity(AdminRoleMenu entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected AdminRoleMenu updatePartEntity(AdminRoleMenu entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected AdminRoleMenu updateEntity(AdminRoleMenu entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}	
}
