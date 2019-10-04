package com.techsoft.dao.sys;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.AdminRoleFunction;
import com.techsoft.mapper.sys.AdminRoleFunctionMapper;

@Repository
public class AdminRoleFunctionDaoImpl extends BaseDaoImpl<AdminRoleFunction> implements AdminRoleFunctionDao {
	@Resource
	protected AdminRoleFunctionMapper adminRoleFunctionMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<AdminRoleFunction> getEntityClass() {
		return AdminRoleFunction.class;
	}	
	
	@Override
	public BaseMapper<AdminRoleFunction> getBaseMapper() {
		return this.adminRoleFunctionMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "ADMIN_ROLE_FUNCTION";
	}
	
	@Override
	public void insertSaveCheck(AdminRoleFunction value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(AdminRoleFunction value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(AdminRoleFunction value) throws BusinessException, SQLException {
	
	}
			
}
