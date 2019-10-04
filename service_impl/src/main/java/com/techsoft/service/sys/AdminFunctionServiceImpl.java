package com.techsoft.service.sys;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.sys.AdminFunctionDao;
import com.techsoft.entity.common.AdminFunction;

@Service
public class AdminFunctionServiceImpl extends BaseServiceImpl<AdminFunction> implements AdminFunctionService {
	@Autowired
	private AdminFunctionDao adminFunctionDao;
	
	@Override
	public BaseDao<AdminFunction> getBaseDao() {
		return adminFunctionDao;
	}	
	
	@Override
	public Class<AdminFunction> getEntityClass() {
		return AdminFunction.class;
	}
	
	@Override
	protected AdminFunction insertEntity(AdminFunction entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected AdminFunction updatePartEntity(AdminFunction entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected AdminFunction updateEntity(AdminFunction entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}	
}
