package com.techsoft.service.config;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.ConfigParameter;
import com.techsoft.entity.config.ConfigParameterVo;

public interface ConfigParameterService extends BaseService<ConfigParameter> {

	public  ConfigParameterVo    getByCode(String paramCode, CommonParam commonParam) throws BusinessException, SQLException;
}
