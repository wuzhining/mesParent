package com.techsoft.dao.config;

import java.util.Map;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.ConfigLabelFunction;

public interface ConfigLabelFunctionDao extends BaseDao<ConfigLabelFunction> {
	public String createCode(Long labelFunctionId, Map<String,Object> mapTableObject, CommonParam commonParam)
			throws BusinessException, SQLException;
}
