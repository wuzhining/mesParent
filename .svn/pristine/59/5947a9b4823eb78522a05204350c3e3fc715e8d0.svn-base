package com.techsoft.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ConfigLabelItem;
import com.techsoft.dao.config.ConfigLabelItemDao;

@Service
public class ConfigLabelItemServiceImpl extends BaseServiceImpl<ConfigLabelItem> implements ConfigLabelItemService {
	@Autowired
	private ConfigLabelItemDao configLabelItemDao;
	
	@Override
	public BaseDao<ConfigLabelItem> getBaseDao() {
		return configLabelItemDao;
	}	
	
	@Override
	public Class<ConfigLabelItem> getEntityClass() {
		return ConfigLabelItem.class;
	}
	
	@Override
	protected ConfigLabelItem insertEntity(ConfigLabelItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigLabelItem updatePartEntity(ConfigLabelItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigLabelItem updateEntity(ConfigLabelItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
