package com.techsoft.service.firm;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.FirmEmployee;
import com.techsoft.dao.firm.FirmEmployeeDao;

@Service
public class FirmEmployeeServiceImpl extends BaseServiceImpl<FirmEmployee> implements FirmEmployeeService {
	@Autowired
	private FirmEmployeeDao firmEmployeeDao;
	
	@Override
	public BaseDao<FirmEmployee> getBaseDao() {
		return firmEmployeeDao;
	}	
	
	@Override
	public Class<FirmEmployee> getEntityClass() {
		return FirmEmployee.class;
	}
	
	@Override
	protected FirmEmployee insertEntity(FirmEmployee entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected FirmEmployee updatePartEntity(FirmEmployee entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected FirmEmployee updateEntity(FirmEmployee entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public FirmEmployee getByUserId(Long userId) throws SQLException {
		// TODO Auto-generated method stub
		return firmEmployeeDao.getByUserId(userId);
	}					
}
