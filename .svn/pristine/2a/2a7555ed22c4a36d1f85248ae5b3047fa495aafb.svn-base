package com.techsoft.service.config;

import java.util.List;
import java.util.Map;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.ConfigLabel;

public interface ConfigLabelService extends BaseService<ConfigLabel> {
	/**
	 * 
	 * @param Long  labelId
	 * @param quantity  条码数量
	 * @param mapTableObjectFunction 其它附加信息的对象集合
	 * @param commonParam
	 * @return 
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public List<Map<String,String>> createValue(Long labelId, Integer quantity, Map<String, Object> mapTableObjectFunction,
			CommonParam commonParam) throws BusinessException, SQLException ;
}
    