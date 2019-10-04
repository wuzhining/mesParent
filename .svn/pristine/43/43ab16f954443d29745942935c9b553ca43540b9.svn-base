package com.techsoft.service.sys;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.sys.AdminMenuDao;
import com.techsoft.entity.common.AdminMenu;

@Service
public class AdminMenuServiceImpl extends BaseServiceImpl<AdminMenu> implements AdminMenuService {
	@Autowired
	private AdminMenuDao adminMenuDao;
	
	@Override
	public BaseDao<AdminMenu> getBaseDao() {
		return adminMenuDao;
	}	
	
	@Override
	public Class<AdminMenu> getEntityClass() {
		return AdminMenu.class;
	}
	
	@Override
	protected AdminMenu insertEntity(AdminMenu entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected AdminMenu updatePartEntity(AdminMenu entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected AdminMenu updateEntity(AdminMenu entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}	
}
