package com.techsoft.dao.sys;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.AdminRoleMenu;
import com.techsoft.mapper.sys.AdminRoleMenuMapper;

@Repository
public class AdminRoleMenuDaoImpl extends BaseDaoImpl<AdminRoleMenu> implements AdminRoleMenuDao {
	@Resource
	protected AdminRoleMenuMapper adminRoleMenuMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<AdminRoleMenu> getEntityClass() {
		return AdminRoleMenu.class;
	}	
	
	@Override
	public BaseMapper<AdminRoleMenu> getBaseMapper() {
		return this.adminRoleMenuMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "ADMIN_ROLE_MENU";
	}
	
	@Override
	public void insertSaveCheck(AdminRoleMenu value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(AdminRoleMenu value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(AdminRoleMenu value) throws BusinessException, SQLException {
	
	}
			
}
