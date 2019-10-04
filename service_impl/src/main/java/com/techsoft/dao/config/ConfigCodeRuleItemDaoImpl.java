package com.techsoft.dao.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigCodeRuleItem;
import com.techsoft.mapper.config.ConfigCodeRuleItemMapper;

@Repository
public class ConfigCodeRuleItemDaoImpl extends BaseDaoImpl<ConfigCodeRuleItem> implements ConfigCodeRuleItemDao {
	@Resource
	protected ConfigCodeRuleItemMapper configCodeRuleItemMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigCodeRuleItem> getEntityClass() {
		return ConfigCodeRuleItem.class;
	}	
	
	@Override
	public BaseMapper<ConfigCodeRuleItem> getBaseMapper() {
		return this.configCodeRuleItemMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_CODE_RULE_ITEM";
	}
	
	@Override
	public void insertSaveCheck(ConfigCodeRuleItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ConfigCodeRuleItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ConfigCodeRuleItem value) throws BusinessException, SQLException {
	
	}
			
}
