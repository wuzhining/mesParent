package com.techsoft.dao.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigCountry;
import com.techsoft.mapper.config.ConfigCountryMapper;

@Repository
public class ConfigCountryDaoImpl extends BaseDaoImpl<ConfigCountry> implements ConfigCountryDao {
	@Resource
	protected ConfigCountryMapper configCountryMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigCountry> getEntityClass() {
		return ConfigCountry.class;
	}	
	
	@Override
	public BaseMapper<ConfigCountry> getBaseMapper() {
		return this.configCountryMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_COUNTRY";
	}
	
	@Override
	public void insertSaveCheck(ConfigCountry value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ConfigCountry value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ConfigCountry value) throws BusinessException, SQLException {
	
	}
			
}
