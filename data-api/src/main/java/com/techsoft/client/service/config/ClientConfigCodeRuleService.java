package com.techsoft.client.service.config;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigCodeRule;
import com.techsoft.entity.config.ConfigCodeRuleVo;
import com.techsoft.entity.config.ConfigCodeRuleParamVo;

public interface ClientConfigCodeRuleService extends BaseClientService<ConfigCodeRule> {

	public ConfigCodeRuleVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigCodeRuleVo> selectListVoByParamVo(ConfigCodeRuleParamVo configCodeRule, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ConfigCodeRuleVo> selectPageVoByParamVo(ConfigCodeRuleParamVo configCodeRule,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigCodeRuleVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigCodeRuleVo> selectListExtendVoByParamVo(ConfigCodeRuleParamVo configCodeRule,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigCodeRuleVo> selectPageExtendVoByParamVo(ConfigCodeRuleParamVo configCodeRule,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigCodeRuleParamVo configCodeRuleParamVo, CommonParam commonParam);

	public String createCode(String className, Long billTypeDictId, Map<String, Object> mapTableObjectFunction,
			CommonParam commonParam) throws BusinessException, SQLException;
}
