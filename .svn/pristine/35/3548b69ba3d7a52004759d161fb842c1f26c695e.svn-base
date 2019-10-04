package com.techsoft.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ConfigCodeRuleItem;
import com.techsoft.dao.config.ConfigCodeRuleItemDao;

@Service
public class ConfigCodeRuleItemServiceImpl extends BaseServiceImpl<ConfigCodeRuleItem> implements ConfigCodeRuleItemService {
	@Autowired
	private ConfigCodeRuleItemDao configCodeRuleItemDao;
	
	@Override
	public BaseDao<ConfigCodeRuleItem> getBaseDao() {
		return configCodeRuleItemDao;
	}	
	
	@Override
	public Class<ConfigCodeRuleItem> getEntityClass() {
		return ConfigCodeRuleItem.class;
	}
	
	@Override
	protected ConfigCodeRuleItem insertEntity(ConfigCodeRuleItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigCodeRuleItem updatePartEntity(ConfigCodeRuleItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigCodeRuleItem updateEntity(ConfigCodeRuleItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
