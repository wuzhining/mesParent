package com.techsoft.dao.sys;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.AdminUser;
import com.techsoft.mapper.sys.AdminUserMapper;
import com.techsoft.mapper.sys.MycatSequenceMapper;

@Repository
public class AdminUserDaoImpl extends BaseDaoImpl<AdminUser> implements AdminUserDao {
	@Resource
	protected AdminUserMapper adminUserMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<AdminUser> getEntityClass() {
		return AdminUser.class;
	}	
	
	@Override
	public BaseMapper<AdminUser> getBaseMapper() {
		return this.adminUserMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "admin_user";
	}	
	
	@Override
	public void insertSaveCheck(AdminUser value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(AdminUser value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(AdminUser value) throws BusinessException, SQLException {
	
	}		
}
