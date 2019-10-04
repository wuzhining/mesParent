package com.techsoft.dao.sys;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.UserTenant;
import com.techsoft.mapper.sys.UserTenantMapper;

@Repository
public class UserTenantDaoImpl extends BaseDaoImpl<UserTenant> implements UserTenantDao {
	@Resource
	protected UserTenantMapper userTenantMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<UserTenant> getEntityClass() {
		return UserTenant.class;
	}	
	
	@Override
	public BaseMapper<UserTenant> getBaseMapper() {
		return this.userTenantMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "USER_TENANT";
	}
	
	@Override
	public void insertSaveCheck(UserTenant value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(UserTenant value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(UserTenant value) throws BusinessException, SQLException {
	
	}
			
}
