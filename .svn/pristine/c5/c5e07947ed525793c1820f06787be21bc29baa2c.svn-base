package com.techsoft.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ConfigLabelFieldItem;
import com.techsoft.dao.config.ConfigLabelFieldItemDao;

@Service
public class ConfigLabelFieldItemServiceImpl extends BaseServiceImpl<ConfigLabelFieldItem> implements ConfigLabelFieldItemService {
	@Autowired
	private ConfigLabelFieldItemDao configLabelFieldItemDao;
	
	@Override
	public BaseDao<ConfigLabelFieldItem> getBaseDao() {
		return configLabelFieldItemDao;
	}	
	
	@Override
	public Class<ConfigLabelFieldItem> getEntityClass() {
		return ConfigLabelFieldItem.class;
	}
	
	@Override
	protected ConfigLabelFieldItem insertEntity(ConfigLabelFieldItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigLabelFieldItem updatePartEntity(ConfigLabelFieldItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigLabelFieldItem updateEntity(ConfigLabelFieldItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
