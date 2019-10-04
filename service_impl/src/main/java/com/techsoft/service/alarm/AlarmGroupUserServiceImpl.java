package com.techsoft.service.alarm;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.AlarmGroupUser;
import com.techsoft.dao.alarm.AlarmGroupUserDao;

@Service
public class AlarmGroupUserServiceImpl extends BaseServiceImpl<AlarmGroupUser> implements AlarmGroupUserService {
	@Autowired
	private AlarmGroupUserDao alarmGroupUserDao;
	
	@Override
	public BaseDao<AlarmGroupUser> getBaseDao() {
		return alarmGroupUserDao;
	}	
	
	@Override
	public Class<AlarmGroupUser> getEntityClass() {
		return AlarmGroupUser.class;
	}
	
	@Override
	protected AlarmGroupUser insertEntity(AlarmGroupUser entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected AlarmGroupUser updatePartEntity(AlarmGroupUser entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected AlarmGroupUser updateEntity(AlarmGroupUser entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
