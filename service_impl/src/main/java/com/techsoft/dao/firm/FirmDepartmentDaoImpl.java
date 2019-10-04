package com.techsoft.dao.firm;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.mapper.firm.FirmDepartmentMapper;

@Repository
public class FirmDepartmentDaoImpl extends BaseDaoImpl<FirmDepartment> implements FirmDepartmentDao {
	@Resource
	protected FirmDepartmentMapper firmDepartmentMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<FirmDepartment> getEntityClass() {
		return FirmDepartment.class;
	}	
	
	@Override
	public BaseMapper<FirmDepartment> getBaseMapper() {
		return this.firmDepartmentMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "FIRM_DEPARTMENT";
	}
	
	@Override
	public void insertSaveCheck(FirmDepartment value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(FirmDepartment value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(FirmDepartment value) throws BusinessException, SQLException {
	
	}
			
}
