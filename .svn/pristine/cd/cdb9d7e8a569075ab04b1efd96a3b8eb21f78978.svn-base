package com.techsoft.dao.sys;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.AdminRole;
import com.techsoft.mapper.sys.AdminRoleMapper;

@Repository
public class AdminRoleDaoImpl extends BaseDaoImpl<AdminRole> implements AdminRoleDao {
	@Resource
	protected AdminRoleMapper adminRoleMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<AdminRole> getEntityClass() {
		return AdminRole.class;
	}	
	
	@Override
	public BaseMapper<AdminRole> getBaseMapper() {
		return this.adminRoleMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "ADMIN_ROLE";
	}
	
	@Override
	public void insertSaveCheck(AdminRole value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(AdminRole value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(AdminRole value) throws BusinessException, SQLException {
	
	}
			
}
