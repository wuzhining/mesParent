package com.techsoft.dao.work;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.WorkSchedulingEmployee;
import com.techsoft.mapper.work.WorkSchedulingEmployeeMapper;

@Repository
public class WorkSchedulingEmployeeDaoImpl extends BaseDaoImpl<WorkSchedulingEmployee> implements WorkSchedulingEmployeeDao {
	@Resource
	protected WorkSchedulingEmployeeMapper workSchedulingEmployeeMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<WorkSchedulingEmployee> getEntityClass() {
		return WorkSchedulingEmployee.class;
	}	
	
	@Override
	public BaseMapper<WorkSchedulingEmployee> getBaseMapper() {
		return this.workSchedulingEmployeeMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "WORK_SCHEDULING_EMPLOYEE";
	}
	
	@Override
	public void insertSaveCheck(WorkSchedulingEmployee value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(WorkSchedulingEmployee value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(WorkSchedulingEmployee value) throws BusinessException, SQLException {
	
	}
			
}
