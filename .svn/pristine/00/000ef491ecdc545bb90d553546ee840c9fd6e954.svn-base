package com.techsoft.client.service.config;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigLabelItem;
import com.techsoft.entity.config.ConfigLabelItemVo;
import com.techsoft.entity.config.ConfigLabelItemParamVo;

public interface ClientConfigLabelItemService extends BaseClientService<ConfigLabelItem> {

	public ConfigLabelItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigLabelItemVo> selectListVoByParamVo(ConfigLabelItemParamVo configLabelItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigLabelItemVo> selectPageVoByParamVo(ConfigLabelItemParamVo configLabelItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigLabelItemVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigLabelItemVo> selectListExtendVoByParamVo(ConfigLabelItemParamVo configLabelItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigLabelItemVo> selectPageExtendVoByParamVo(ConfigLabelItemParamVo configLabelItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigLabelItemParamVo configLabelItemParamVo, CommonParam commonParam);
}
