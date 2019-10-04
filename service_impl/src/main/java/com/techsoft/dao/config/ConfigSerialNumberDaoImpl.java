package com.techsoft.dao.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigSerialNumber;
import com.techsoft.mapper.config.ConfigSerialNumberMapper;

@Repository
public class ConfigSerialNumberDaoImpl extends BaseDaoImpl<ConfigSerialNumber> implements ConfigSerialNumberDao {
	@Resource
	protected ConfigSerialNumberMapper configSerialNumberMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigSerialNumber> getEntityClass() {
		return ConfigSerialNumber.class;
	}	
	
	@Override
	public BaseMapper<ConfigSerialNumber> getBaseMapper() {
		return this.configSerialNumberMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_SERIAL_NUMBER";
	}
	
	@Override
	public void insertSaveCheck(ConfigSerialNumber value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ConfigSerialNumber value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ConfigSerialNumber value) throws BusinessException, SQLException {
	
	}
			
}
