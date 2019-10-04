package com.techsoft.service.config;

import java.util.Map;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.ConfigCodeRule;

public interface ConfigCodeRuleService extends BaseService<ConfigCodeRule> { 
	/**
	 * 
	 * @param className  类全路径和名称
	 * @param billTypeDictId  如果类是库单表，需要传库单表类型
	 * @param mapTableObjectFunction 其它附加信息的对象集合
	 * @param commonParam
	 * @return
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public String createCode(String className, Long billTypeDictId, Map<String, Object> mapTableObjectFunction,
			CommonParam commonParam) throws BusinessException, SQLException ;

}
