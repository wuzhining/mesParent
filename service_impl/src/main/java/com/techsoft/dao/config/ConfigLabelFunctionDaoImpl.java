package com.techsoft.dao.config;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigLabelFunction;
import com.techsoft.mapper.config.ConfigLabelFunctionMapper;

@Repository
public class ConfigLabelFunctionDaoImpl extends BaseDaoImpl<ConfigLabelFunction> implements ConfigLabelFunctionDao {
	@Resource
	protected ConfigLabelFunctionMapper configLabelFunctionMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigLabelFunction> getEntityClass() {
		return ConfigLabelFunction.class;
	}	
	
	@Override
	public BaseMapper<ConfigLabelFunction> getBaseMapper() {
		return this.configLabelFunctionMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_LABEL_FUNCTION";
	}
	
	@Override
	public void insertSaveCheck(ConfigLabelFunction value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ConfigLabelFunction value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ConfigLabelFunction value) throws BusinessException, SQLException {
	
	}

	@Override
	public String createCode(Long labelFunctionId, Map<String, Object> mapTableObject, CommonParam commonParam)
			throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
			
}
