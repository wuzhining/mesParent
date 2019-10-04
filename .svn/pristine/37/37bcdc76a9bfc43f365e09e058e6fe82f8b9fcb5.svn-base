package com.techsoft.dao.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigAppInterface;
import com.techsoft.mapper.config.ConfigAppInterfaceMapper;

@Repository
public class ConfigAppInterfaceDaoImpl extends BaseDaoImpl<ConfigAppInterface> implements ConfigAppInterfaceDao {
	@Resource
	protected ConfigAppInterfaceMapper configAppInterfaceMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigAppInterface> getEntityClass() {
		return ConfigAppInterface.class;
	}	
	
	@Override
	public BaseMapper<ConfigAppInterface> getBaseMapper() {
		return this.configAppInterfaceMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_APP_INTERFACE";
	}
	
	@Override
	public void insertSaveCheck(ConfigAppInterface value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ConfigAppInterface value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ConfigAppInterface value) throws BusinessException, SQLException {
	
	}
			
}
