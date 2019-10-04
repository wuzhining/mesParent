package com.techsoft.dao.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigParameter;
import com.techsoft.mapper.config.ConfigParameterMapper;

@Repository
public class ConfigParameterDaoImpl extends BaseDaoImpl<ConfigParameter> implements ConfigParameterDao {
	@Resource
	protected ConfigParameterMapper configParameterMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigParameter> getEntityClass() {
		return ConfigParameter.class;
	}	
	
	@Override
	public BaseMapper<ConfigParameter> getBaseMapper() {
		return this.configParameterMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_PARAMETER";
	}
	
	@Override
	public void insertSaveCheck(ConfigParameter value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ConfigParameter value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ConfigParameter value) throws BusinessException, SQLException {
	
	}
			
}
