package com.techsoft.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ConfigAppInterface;
import com.techsoft.dao.config.ConfigAppInterfaceDao;

@Service
public class ConfigAppInterfaceServiceImpl extends BaseServiceImpl<ConfigAppInterface> implements ConfigAppInterfaceService {
	@Autowired
	private ConfigAppInterfaceDao configAppInterfaceDao;
	
	@Override
	public BaseDao<ConfigAppInterface> getBaseDao() {
		return configAppInterfaceDao;
	}	
	
	@Override
	public Class<ConfigAppInterface> getEntityClass() {
		return ConfigAppInterface.class;
	}
	
	@Override
	protected ConfigAppInterface insertEntity(ConfigAppInterface entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigAppInterface updatePartEntity(ConfigAppInterface entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigAppInterface updateEntity(ConfigAppInterface entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
