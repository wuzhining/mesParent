package com.techsoft.dao.sys;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.AdminRoleUser;
import com.techsoft.mapper.sys.AdminRoleUserMapper;

@Repository
public class AdminRoleUserDaoImpl extends BaseDaoImpl<AdminRoleUser> implements AdminRoleUserDao {
	@Resource
	protected AdminRoleUserMapper adminRoleUserMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<AdminRoleUser> getEntityClass() {
		return AdminRoleUser.class;
	}	
	
	@Override
	public BaseMapper<AdminRoleUser> getBaseMapper() {
		return this.adminRoleUserMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "ADMIN_ROLE_USER";
	}
	
	@Override
	public void insertSaveCheck(AdminRoleUser value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(AdminRoleUser value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(AdminRoleUser value) throws BusinessException, SQLException {
	
	}
			
}
