package com.techsoft.client.service.config;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigTableObject;
import com.techsoft.entity.config.ConfigTableObjectVo;
import com.techsoft.entity.config.ConfigTableObjectParamVo;

public interface ClientConfigTableObjectService extends BaseClientService<ConfigTableObject> {

	public ConfigTableObjectVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigTableObjectVo> selectListVoByParamVo(ConfigTableObjectParamVo configTableObject,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigTableObjectVo> selectPageVoByParamVo(ConfigTableObjectParamVo configTableObject,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigTableObjectVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigTableObjectVo> selectListExtendVoByParamVo(ConfigTableObjectParamVo configTableObject,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigTableObjectVo> selectPageExtendVoByParamVo(ConfigTableObjectParamVo configTableObject,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigTableObjectParamVo configTableObjectParamVo, CommonParam commonParam);
}
