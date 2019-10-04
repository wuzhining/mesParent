package com.techsoft.dao.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.mapper.config.ConfigDictionaryMapper;

@Repository
public class ConfigDictionaryDaoImpl extends BaseDaoImpl<ConfigDictionary> implements ConfigDictionaryDao {
	@Resource
	protected ConfigDictionaryMapper configDictionaryMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigDictionary> getEntityClass() {
		return ConfigDictionary.class;
	}	
	
	@Override
	public BaseMapper<ConfigDictionary> getBaseMapper() {
		return this.configDictionaryMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_DICTIONARY";
	}
	
	@Override
	public void insertSaveCheck(ConfigDictionary value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ConfigDictionary value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ConfigDictionary value) throws BusinessException, SQLException {
	
	}
			
}
