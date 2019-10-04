package com.techsoft.service.work;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.WorkSchedulingEmployee;
import com.techsoft.dao.work.WorkSchedulingEmployeeDao;

@Service
public class WorkSchedulingEmployeeServiceImpl extends BaseServiceImpl<WorkSchedulingEmployee> implements WorkSchedulingEmployeeService {
	@Autowired
	private WorkSchedulingEmployeeDao workSchedulingEmployeeDao;
	
	@Override
	public BaseDao<WorkSchedulingEmployee> getBaseDao() {
		return workSchedulingEmployeeDao;
	}	
	
	@Override
	public Class<WorkSchedulingEmployee> getEntityClass() {
		return WorkSchedulingEmployee.class;
	}
	
	@Override
	protected WorkSchedulingEmployee insertEntity(WorkSchedulingEmployee entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WorkSchedulingEmployee updatePartEntity(WorkSchedulingEmployee entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WorkSchedulingEmployee updateEntity(WorkSchedulingEmployee entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
