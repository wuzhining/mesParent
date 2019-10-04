package com.techsoft.client.service.config;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigTableField;
import com.techsoft.entity.config.ConfigTableFieldVo;
import com.techsoft.entity.config.ConfigTableFieldParamVo;

public interface ClientConfigTableFieldService extends BaseClientService<ConfigTableField> {

	public ConfigTableFieldVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigTableFieldVo> selectListVoByParamVo(ConfigTableFieldParamVo configTableField,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigTableFieldVo> selectPageVoByParamVo(ConfigTableFieldParamVo configTableField,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigTableFieldVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigTableFieldVo> selectListExtendVoByParamVo(ConfigTableFieldParamVo configTableField,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigTableFieldVo> selectPageExtendVoByParamVo(ConfigTableFieldParamVo configTableField,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigTableFieldParamVo configTableFieldParamVo, CommonParam commonParam);
}
