package com.techsoft.client.service.config;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigCountry;
import com.techsoft.entity.config.ConfigCountryVo;
import com.techsoft.entity.config.ConfigCountryParamVo;

public interface ClientConfigCountryService extends BaseClientService<ConfigCountry> {

	public ConfigCountryVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigCountryVo> selectListVoByParamVo(ConfigCountryParamVo configCountry, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ConfigCountryVo> selectPageVoByParamVo(ConfigCountryParamVo configCountry, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigCountryVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigCountryVo> selectListExtendVoByParamVo(ConfigCountryParamVo configCountry,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigCountryVo> selectPageExtendVoByParamVo(ConfigCountryParamVo configCountry,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigCountryParamVo configCountryParamVo, CommonParam commonParam);
}
