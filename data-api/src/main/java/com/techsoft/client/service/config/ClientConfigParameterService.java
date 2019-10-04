package com.techsoft.client.service.config;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigParameter;
import com.techsoft.entity.config.ConfigParameterVo;
import com.techsoft.entity.config.ConfigParameterParamVo;

public interface ClientConfigParameterService extends BaseClientService<ConfigParameter> {

	public ConfigParameterVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigParameterVo> selectListVoByParamVo(ConfigParameterParamVo configParameter,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigParameterVo> selectPageVoByParamVo(ConfigParameterParamVo configParameter,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigParameterVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigParameterVo> selectListExtendVoByParamVo(ConfigParameterParamVo configParameter,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigParameterVo> selectPageExtendVoByParamVo(ConfigParameterParamVo configParameter,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigParameterParamVo configParameterParamVo, CommonParam commonParam);

	public  ConfigParameterVo    getByCode(String paramCode, CommonParam commonParam) throws BusinessException, SQLException;
}
