package com.techsoft.service.alarm;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.AlarmLevel;
import com.techsoft.dao.alarm.AlarmLevelDao;

@Service
public class AlarmLevelServiceImpl extends BaseServiceImpl<AlarmLevel> implements AlarmLevelService {
	@Autowired
	private AlarmLevelDao alarmLevelDao;
	
	@Override
	public BaseDao<AlarmLevel> getBaseDao() {
		return alarmLevelDao;
	}	
	
	@Override
	public Class<AlarmLevel> getEntityClass() {
		return AlarmLevel.class;
	}
	
	@Override
	protected AlarmLevel insertEntity(AlarmLevel entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected AlarmLevel updatePartEntity(AlarmLevel entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected AlarmLevel updateEntity(AlarmLevel entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
