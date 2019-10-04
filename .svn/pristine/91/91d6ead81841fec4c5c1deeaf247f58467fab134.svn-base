package com.techsoft.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ConfigCountry;
import com.techsoft.dao.config.ConfigCountryDao;

@Service
public class ConfigCountryServiceImpl extends BaseServiceImpl<ConfigCountry> implements ConfigCountryService {
	@Autowired
	private ConfigCountryDao configCountryDao;
	
	@Override
	public BaseDao<ConfigCountry> getBaseDao() {
		return configCountryDao;
	}	
	
	@Override
	public Class<ConfigCountry> getEntityClass() {
		return ConfigCountry.class;
	}
	
	@Override
	protected ConfigCountry insertEntity(ConfigCountry entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigCountry updatePartEntity(ConfigCountry entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigCountry updateEntity(ConfigCountry entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
