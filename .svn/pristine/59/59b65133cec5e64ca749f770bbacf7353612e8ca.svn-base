package com.techsoft.client.service.config;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigLabelField;
import com.techsoft.entity.config.ConfigLabelFieldVo;
import com.techsoft.entity.config.ConfigLabelFieldParamVo;

public interface ClientConfigLabelFieldService extends BaseClientService<ConfigLabelField> {

	public ConfigLabelFieldVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigLabelFieldVo> selectListVoByParamVo(ConfigLabelFieldParamVo configLabelField,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigLabelFieldVo> selectPageVoByParamVo(ConfigLabelFieldParamVo configLabelField,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigLabelFieldVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigLabelFieldVo> selectListExtendVoByParamVo(ConfigLabelFieldParamVo configLabelField,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigLabelFieldVo> selectPageExtendVoByParamVo(ConfigLabelFieldParamVo configLabelField,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigLabelFieldParamVo configLabelFieldParamVo, CommonParam commonParam);
}
