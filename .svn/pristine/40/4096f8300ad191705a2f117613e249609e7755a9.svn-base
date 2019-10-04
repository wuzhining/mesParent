package com.techsoft.service.config;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.config.ConfigDictionaryVo;

public interface ConfigDictionaryService extends BaseService<ConfigDictionary> {
 
	
	public List<ConfigDictionary>  selectListByParentId(Long parentId) throws BusinessException, SQLException;
	
	public List<ConfigDictionary>  selectListByParentCode(String dictCode, CommonParam commonParam) throws BusinessException, SQLException;

	public  ConfigDictionaryVo    getByCode(String dictCode, CommonParam commonParam) throws BusinessException, SQLException;
 
}
