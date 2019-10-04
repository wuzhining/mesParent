package com.techsoft.dao.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigTableObject;
import com.techsoft.mapper.config.ConfigTableObjectMapper;

@Repository
public class ConfigTableObjectDaoImpl extends BaseDaoImpl<ConfigTableObject> implements ConfigTableObjectDao {
	@Resource
	protected ConfigTableObjectMapper configTableObjectMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigTableObject> getEntityClass() {
		return ConfigTableObject.class;
	}	
	
	@Override
	public BaseMapper<ConfigTableObject> getBaseMapper() {
		return this.configTableObjectMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_TABLE_OBJECT";
	}
	
	@Override
	public void insertSaveCheck(ConfigTableObject value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ConfigTableObject value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ConfigTableObject value) throws BusinessException, SQLException {
	
	}
			
}
