package com.techsoft.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ConfigLabelField;
import com.techsoft.dao.config.ConfigLabelFieldDao;

@Service
public class ConfigLabelFieldServiceImpl extends BaseServiceImpl<ConfigLabelField> implements ConfigLabelFieldService {
	@Autowired
	private ConfigLabelFieldDao configLabelFieldDao;
	
	@Override
	public BaseDao<ConfigLabelField> getBaseDao() {
		return configLabelFieldDao;
	}	
	
	@Override
	public Class<ConfigLabelField> getEntityClass() {
		return ConfigLabelField.class;
	}
	
	@Override
	protected ConfigLabelField insertEntity(ConfigLabelField entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigLabelField updatePartEntity(ConfigLabelField entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigLabelField updateEntity(ConfigLabelField entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
