package com.techsoft.client.service.config;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigSerialNumber;
import com.techsoft.entity.config.ConfigSerialNumberVo;
import com.techsoft.entity.config.ConfigSerialNumberParamVo;

public interface ClientConfigSerialNumberService extends BaseClientService<ConfigSerialNumber> {

	public ConfigSerialNumberVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigSerialNumberVo> selectListVoByParamVo(ConfigSerialNumberParamVo configSerialNumber,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigSerialNumberVo> selectPageVoByParamVo(ConfigSerialNumberParamVo configSerialNumber,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigSerialNumberVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<ConfigSerialNumberVo> selectListExtendVoByParamVo(ConfigSerialNumberParamVo configSerialNumber,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigSerialNumberVo> selectPageExtendVoByParamVo(ConfigSerialNumberParamVo configSerialNumber,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigSerialNumberParamVo configSerialNumberParamVo, CommonParam commonParam);
}
