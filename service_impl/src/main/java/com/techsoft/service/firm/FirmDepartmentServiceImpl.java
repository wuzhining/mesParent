package com.techsoft.service.firm;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.dao.firm.FirmDepartmentDao;

@Service
public class FirmDepartmentServiceImpl extends BaseServiceImpl<FirmDepartment> implements FirmDepartmentService {
	@Autowired
	private FirmDepartmentDao firmDepartmentDao;
	
	@Override
	public BaseDao<FirmDepartment> getBaseDao() {
		return firmDepartmentDao;
	}	
	
	@Override
	public Class<FirmDepartment> getEntityClass() {
		return FirmDepartment.class;
	}
	
	@Override
	protected FirmDepartment insertEntity(FirmDepartment entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected FirmDepartment updatePartEntity(FirmDepartment entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected FirmDepartment updateEntity(FirmDepartment entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
