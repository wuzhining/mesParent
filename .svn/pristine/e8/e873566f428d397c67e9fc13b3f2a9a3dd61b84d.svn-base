package com.techsoft.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ConfigArea;
import com.techsoft.dao.config.ConfigAreaDao;

@Service
public class ConfigAreaServiceImpl extends BaseServiceImpl<ConfigArea> implements ConfigAreaService {
	@Autowired
	private ConfigAreaDao configAreaDao;
	
	@Override
	public BaseDao<ConfigArea> getBaseDao() {
		return configAreaDao;
	}	
	
	@Override
	public Class<ConfigArea> getEntityClass() {
		return ConfigArea.class;
	}
	
	@Override
	protected ConfigArea insertEntity(ConfigArea entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigArea updatePartEntity(ConfigArea entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigArea updateEntity(ConfigArea entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
