package com.techsoft.client.service.config;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigArea;
import com.techsoft.entity.config.ConfigAreaVo;
import com.techsoft.entity.config.ConfigAreaParamVo;

public interface ClientConfigAreaService extends BaseClientService<ConfigArea> {

	public ConfigAreaVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigAreaVo> selectListVoByParamVo(ConfigAreaParamVo configArea, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ConfigAreaVo> selectPageVoByParamVo(ConfigAreaParamVo configArea, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigAreaVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigAreaVo> selectListExtendVoByParamVo(ConfigAreaParamVo configArea, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ConfigAreaVo> selectPageExtendVoByParamVo(ConfigAreaParamVo configArea, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigAreaParamVo configAreaParamVo, CommonParam commonParam);
}
