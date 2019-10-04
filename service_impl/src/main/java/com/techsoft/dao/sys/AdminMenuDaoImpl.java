package com.techsoft.dao.sys;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.AdminMenu;
import com.techsoft.mapper.sys.AdminMenuMapper;

@Repository
public class AdminMenuDaoImpl extends BaseDaoImpl<AdminMenu> implements AdminMenuDao {
	@Resource
	protected AdminMenuMapper adminMenuMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<AdminMenu> getEntityClass() {
		return AdminMenu.class;
	}	
	
	@Override
	public BaseMapper<AdminMenu> getBaseMapper() {
		return this.adminMenuMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "ADMIN_MENU";
	}
	
	@Override
	public void insertSaveCheck(AdminMenu value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(AdminMenu value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(AdminMenu value) throws BusinessException, SQLException {
	
	}
			
}
