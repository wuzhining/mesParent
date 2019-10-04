package com.techsoft.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ConfigTableField;
import com.techsoft.dao.config.ConfigTableFieldDao;

@Service
public class ConfigTableFieldServiceImpl extends BaseServiceImpl<ConfigTableField> implements ConfigTableFieldService {
	@Autowired
	private ConfigTableFieldDao configTableFieldDao;
	
	@Override
	public BaseDao<ConfigTableField> getBaseDao() {
		return configTableFieldDao;
	}	
	
	@Override
	public Class<ConfigTableField> getEntityClass() {
		return ConfigTableField.class;
	}
	
	@Override
	protected ConfigTableField insertEntity(ConfigTableField entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigTableField updatePartEntity(ConfigTableField entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigTableField updateEntity(ConfigTableField entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
