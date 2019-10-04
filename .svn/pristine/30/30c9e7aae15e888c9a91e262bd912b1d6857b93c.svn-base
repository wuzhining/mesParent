package com.techsoft.client.service.config;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigLabel;
import com.techsoft.entity.config.ConfigLabelVo;
import com.techsoft.entity.config.ConfigLabelParamVo;

public interface ClientConfigLabelService extends BaseClientService<ConfigLabel> {

	public ConfigLabelVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigLabelVo> selectListVoByParamVo(ConfigLabelParamVo configLabel, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ConfigLabelVo> selectPageVoByParamVo(ConfigLabelParamVo configLabel, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigLabelVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigLabelVo> selectListExtendVoByParamVo(ConfigLabelParamVo configLabel, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ConfigLabelVo> selectPageExtendVoByParamVo(ConfigLabelParamVo configLabel, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigLabelParamVo configLabelParamVo, CommonParam commonParam);

	public List<Map<String, String>> createValue(Long labelId, Integer quantity,
			Map<String, Object> mapTableObjectFunction, CommonParam commonParam) throws BusinessException, SQLException;
}
