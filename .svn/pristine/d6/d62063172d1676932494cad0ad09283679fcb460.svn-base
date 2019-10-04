package com.techsoft.service.alarm;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.AlarmInforFlow;
import com.techsoft.dao.alarm.AlarmInforFlowDao;

@Service
public class AlarmInforFlowServiceImpl extends BaseServiceImpl<AlarmInforFlow> implements AlarmInforFlowService {
	@Autowired
	private AlarmInforFlowDao alarmInforFlowDao;
	
	@Override
	public BaseDao<AlarmInforFlow> getBaseDao() {
		return alarmInforFlowDao;
	}	
	
	@Override
	public Class<AlarmInforFlow> getEntityClass() {
		return AlarmInforFlow.class;
	}
	
	@Override
	protected AlarmInforFlow insertEntity(AlarmInforFlow entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected AlarmInforFlow updatePartEntity(AlarmInforFlow entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected AlarmInforFlow updateEntity(AlarmInforFlow entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
