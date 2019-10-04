package com.techsoft.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ConfigTableObject;
import com.techsoft.dao.config.ConfigTableObjectDao;

@Service
public class ConfigTableObjectServiceImpl extends BaseServiceImpl<ConfigTableObject> implements ConfigTableObjectService {
	@Autowired
	private ConfigTableObjectDao configTableObjectDao;
	
	@Override
	public BaseDao<ConfigTableObject> getBaseDao() {
		return configTableObjectDao;
	}	
	
	@Override
	public Class<ConfigTableObject> getEntityClass() {
		return ConfigTableObject.class;
	}
	
	@Override
	protected ConfigTableObject insertEntity(ConfigTableObject entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigTableObject updatePartEntity(ConfigTableObject entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigTableObject updateEntity(ConfigTableObject entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
