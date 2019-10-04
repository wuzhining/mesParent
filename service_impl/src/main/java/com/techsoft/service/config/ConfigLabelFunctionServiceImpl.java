package com.techsoft.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ConfigLabelFunction;
import com.techsoft.dao.config.ConfigLabelFunctionDao;

@Service
public class ConfigLabelFunctionServiceImpl extends BaseServiceImpl<ConfigLabelFunction> implements ConfigLabelFunctionService {
	@Autowired
	private ConfigLabelFunctionDao configLabelFunctionDao;
	
	@Override
	public BaseDao<ConfigLabelFunction> getBaseDao() {
		return configLabelFunctionDao;
	}	
	
	@Override
	public Class<ConfigLabelFunction> getEntityClass() {
		return ConfigLabelFunction.class;
	}
	
	@Override
	protected ConfigLabelFunction insertEntity(ConfigLabelFunction entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigLabelFunction updatePartEntity(ConfigLabelFunction entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigLabelFunction updateEntity(ConfigLabelFunction entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
