package com.techsoft.dao.sys;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.AdminFunction;
import com.techsoft.mapper.sys.AdminFunctionMapper;

@Repository
public class AdminFunctionDaoImpl extends BaseDaoImpl<AdminFunction> implements AdminFunctionDao {
	@Resource
	protected AdminFunctionMapper adminFunctionMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<AdminFunction> getEntityClass() {
		return AdminFunction.class;
	}	
	
	@Override
	public BaseMapper<AdminFunction> getBaseMapper() {
		return this.adminFunctionMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "ADMIN_FUNCTION";
	}
	
	@Override
	public void insertSaveCheck(AdminFunction value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(AdminFunction value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(AdminFunction value) throws BusinessException, SQLException {
	
	}
			
}
