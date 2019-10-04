package com.techsoft.client.service.config;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigLabelFunction;
import com.techsoft.entity.config.ConfigLabelFunctionVo;
import com.techsoft.entity.config.ConfigLabelFunctionParamVo;

public interface ClientConfigLabelFunctionService extends BaseClientService<ConfigLabelFunction> {

	public ConfigLabelFunctionVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigLabelFunctionVo> selectListVoByParamVo(ConfigLabelFunctionParamVo configLabelFunction,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigLabelFunctionVo> selectPageVoByParamVo(ConfigLabelFunctionParamVo configLabelFunction,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigLabelFunctionVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<ConfigLabelFunctionVo> selectListExtendVoByParamVo(ConfigLabelFunctionParamVo configLabelFunction,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigLabelFunctionVo> selectPageExtendVoByParamVo(ConfigLabelFunctionParamVo configLabelFunction,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigLabelFunctionParamVo configLabelFunctionParamVo, CommonParam commonParam);
}
