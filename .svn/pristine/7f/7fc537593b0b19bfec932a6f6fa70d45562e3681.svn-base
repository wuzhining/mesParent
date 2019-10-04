package com.techsoft.dao.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigArea;
import com.techsoft.mapper.config.ConfigAreaMapper;

@Repository
public class ConfigAreaDaoImpl extends BaseDaoImpl<ConfigArea> implements ConfigAreaDao {
	@Resource
	protected ConfigAreaMapper configAreaMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigArea> getEntityClass() {
		return ConfigArea.class;
	}	
	
	@Override
	public BaseMapper<ConfigArea> getBaseMapper() {
		return this.configAreaMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_AREA";
	}
	
	@Override
	public void insertSaveCheck(ConfigArea value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ConfigArea value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ConfigArea value) throws BusinessException, SQLException {
	
	}
			
}
