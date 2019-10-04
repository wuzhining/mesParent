package com.techsoft.client.service.config;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigCodeRuleItem;
import com.techsoft.entity.config.ConfigCodeRuleItemVo;
import com.techsoft.entity.config.ConfigCodeRuleItemParamVo;

public interface ClientConfigCodeRuleItemService extends BaseClientService<ConfigCodeRuleItem> {

	public ConfigCodeRuleItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigCodeRuleItemVo> selectListVoByParamVo(ConfigCodeRuleItemParamVo configCodeRuleItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigCodeRuleItemVo> selectPageVoByParamVo(ConfigCodeRuleItemParamVo configCodeRuleItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigCodeRuleItemVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<ConfigCodeRuleItemVo> selectListExtendVoByParamVo(ConfigCodeRuleItemParamVo configCodeRuleItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigCodeRuleItemVo> selectPageExtendVoByParamVo(ConfigCodeRuleItemParamVo configCodeRuleItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigCodeRuleItemParamVo configCodeRuleItemParamVo, CommonParam commonParam);
}
