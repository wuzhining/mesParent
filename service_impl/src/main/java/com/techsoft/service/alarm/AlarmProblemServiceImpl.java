package com.techsoft.service.alarm;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.AlarmProblem;
import com.techsoft.dao.alarm.AlarmProblemDao;

@Service
public class AlarmProblemServiceImpl extends BaseServiceImpl<AlarmProblem> implements AlarmProblemService {
	@Autowired
	private AlarmProblemDao alarmProblemDao;
	
	@Override
	public BaseDao<AlarmProblem> getBaseDao() {
		return alarmProblemDao;
	}	
	
	@Override
	public Class<AlarmProblem> getEntityClass() {
		return AlarmProblem.class;
	}
	
	@Override
	protected AlarmProblem insertEntity(AlarmProblem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected AlarmProblem updatePartEntity(AlarmProblem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected AlarmProblem updateEntity(AlarmProblem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
