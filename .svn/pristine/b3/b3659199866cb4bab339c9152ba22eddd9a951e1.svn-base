package com.techsoft.service.alarm;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.AlarmReason;
import com.techsoft.dao.alarm.AlarmReasonDao;

@Service
public class AlarmReasonServiceImpl extends BaseServiceImpl<AlarmReason> implements AlarmReasonService {
	@Autowired
	private AlarmReasonDao alarmReasonDao;
	
	@Override
	public BaseDao<AlarmReason> getBaseDao() {
		return alarmReasonDao;
	}	
	
	@Override
	public Class<AlarmReason> getEntityClass() {
		return AlarmReason.class;
	}
	
	@Override
	protected AlarmReason insertEntity(AlarmReason entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected AlarmReason updatePartEntity(AlarmReason entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected AlarmReason updateEntity(AlarmReason entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
