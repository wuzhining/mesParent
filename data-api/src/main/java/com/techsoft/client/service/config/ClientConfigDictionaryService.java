package com.techsoft.client.service.config;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.config.ConfigDictionaryVo;
import com.techsoft.entity.config.ConfigDictionaryParamVo;

public interface ClientConfigDictionaryService extends BaseClientService<ConfigDictionary> {

	public ConfigDictionaryVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigDictionaryVo> selectListVoByParamVo(ConfigDictionaryParamVo configDictionary,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigDictionaryVo> selectPageVoByParamVo(ConfigDictionaryParamVo configDictionary,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ConfigDictionaryVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ConfigDictionaryVo> selectListExtendVoByParamVo(ConfigDictionaryParamVo configDictionary,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ConfigDictionaryVo> selectPageExtendVoByParamVo(ConfigDictionaryParamVo configDictionary,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ConfigDictionaryParamVo configDictionaryParamVo, CommonParam commonParam);

	public List<ConfigDictionary> selectListByParentId(Long parentId) throws BusinessException, SQLException;

	public List<ConfigDictionary> selectListByParentCode(String dictCode, CommonParam commonParam)
			throws BusinessException, SQLException;

	public ConfigDictionaryVo getByCode(String dictCode, CommonParam commonParam)
			throws BusinessException, SQLException;

}
