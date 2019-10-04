package com.techsoft.dao.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigTableField;
import com.techsoft.mapper.config.ConfigTableFieldMapper;

@Repository
public class ConfigTableFieldDaoImpl extends BaseDaoImpl<ConfigTableField> implements ConfigTableFieldDao {
	@Resource
	protected ConfigTableFieldMapper configTableFieldMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigTableField> getEntityClass() {
		return ConfigTableField.class;
	}	
	
	@Override
	public BaseMapper<ConfigTableField> getBaseMapper() {
		return this.configTableFieldMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_TABLE_FIELD";
	}
	
	@Override
	public void insertSaveCheck(ConfigTableField value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ConfigTableField value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ConfigTableField value) throws BusinessException, SQLException {
	
	}
			
}
