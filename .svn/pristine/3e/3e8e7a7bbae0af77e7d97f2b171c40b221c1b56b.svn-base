package com.techsoft.client.service.config;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigLabelFieldItem;
import com.techsoft.entity.config.ConfigLabelFieldItemVo;
import com.techsoft.entity.config.ConfigLabelFieldItemParamVo;

public interface ClientConfigLabelFieldItemService extends BaseClientService<ConfigLabelFieldItem> {

	public ConfigLabelFieldItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigLabelFieldItemVo> selectListVoByParamVo(ConfigLabelFieldItemParamVo configLabelFieldItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigLabelFieldItemVo> selectPageVoByParamVo(ConfigLabelFieldItemParamVo configLabelFieldItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigLabelFieldItemVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<ConfigLabelFieldItemVo> selectListExtendVoByParamVo(ConfigLabelFieldItemParamVo configLabelFieldItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigLabelFieldItemVo> selectPageExtendVoByParamVo(
			ConfigLabelFieldItemParamVo configLabelFieldItem, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigLabelFieldItemParamVo configLabelFieldItemParamVo, CommonParam commonParam);
}
