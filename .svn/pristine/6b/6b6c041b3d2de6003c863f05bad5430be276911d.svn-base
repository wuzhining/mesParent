package com.techsoft.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ConfigSerialNumber;
import com.techsoft.dao.config.ConfigSerialNumberDao;

@Service
public class ConfigSerialNumberServiceImpl extends BaseServiceImpl<ConfigSerialNumber> implements ConfigSerialNumberService {
	@Autowired
	private ConfigSerialNumberDao configSerialNumberDao;
	
	@Override
	public BaseDao<ConfigSerialNumber> getBaseDao() {
		return configSerialNumberDao;
	}	
	
	@Override
	public Class<ConfigSerialNumber> getEntityClass() {
		return ConfigSerialNumber.class;
	}
	
	@Override
	protected ConfigSerialNumber insertEntity(ConfigSerialNumber entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigSerialNumber updatePartEntity(ConfigSerialNumber entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigSerialNumber updateEntity(ConfigSerialNumber entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
