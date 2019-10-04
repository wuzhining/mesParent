package com.techsoft.service.sys;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.sys.UserPassportDao;
import com.techsoft.entity.common.UserPassport;

@Service
public class UserPassportServiceImpl extends BaseServiceImpl<UserPassport> implements UserPassportService {
	@Autowired
	private UserPassportDao userPassportDao;

	@Override
	public BaseDao<UserPassport> getBaseDao() {
		return userPassportDao;
	}

	@Override
	public Class<UserPassport> getEntityClass() {
		return UserPassport.class;
	}

	public UserPassport getByUserName(String userName) throws SQLException {
		return userPassportDao.getByUserName(userName);
	}
	
	@Override
	protected UserPassport insertEntity(UserPassport entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected UserPassport updatePartEntity(UserPassport entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected UserPassport updateEntity(UserPassport entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}		
}
