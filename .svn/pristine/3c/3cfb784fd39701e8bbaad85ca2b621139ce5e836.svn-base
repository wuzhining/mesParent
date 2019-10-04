package com.techsoft.service.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumLabelFunctionType;
import com.techsoft.common.enums.EnumYesOrNo;
import com.techsoft.common.utils.DateUtils;
import com.techsoft.common.utils.ObjectInvoke;
import com.techsoft.common.utils.StringUtil;
import com.techsoft.dao.config.ConfigCodeRuleDao;
import com.techsoft.dao.config.ConfigCodeRuleItemDao;
import com.techsoft.dao.config.ConfigLabelFunctionDao;
import com.techsoft.dao.config.ConfigSerialNumberDao;
import com.techsoft.dao.config.ConfigTableFieldDao;
import com.techsoft.dao.config.ConfigTableObjectDao;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.ConfigCodeRule;
import com.techsoft.entity.common.ConfigCodeRuleItem;
import com.techsoft.entity.common.ConfigLabelFunction;
import com.techsoft.entity.common.ConfigSerialNumber;
import com.techsoft.entity.common.ConfigTableField;
import com.techsoft.entity.common.ConfigTableObject;
import com.techsoft.entity.config.ConfigCodeRuleItemParamVo;
import com.techsoft.entity.config.ConfigCodeRuleParamVo;
import com.techsoft.entity.config.ConfigTableObjectParamVo;
import com.techsoft.utils.zklock.DistributedLock;
import com.techsoft.utils.zklock.LockManager;

@Service
public class ConfigCodeRuleServiceImpl extends BaseServiceImpl<ConfigCodeRule> implements ConfigCodeRuleService {
	@Autowired
	private ConfigCodeRuleDao configCodeRuleDao;

	@Autowired
	private ConfigCodeRuleItemDao configCodeRuleItemDao;
	@Autowired
	private ConfigTableObjectDao configTableObjectDao;
	@Autowired
	private ConfigTableFieldDao configTableFieldDao;
	@Autowired
	private ConfigLabelFunctionDao configLabelFunctionDao;
	@Autowired
	private ConfigSerialNumberDao configSerialNumberDao;

	@Override
	public BaseDao<ConfigCodeRule> getBaseDao() {
		return configCodeRuleDao;
	}

	@Override
	public Class<ConfigCodeRule> getEntityClass() {
		return ConfigCodeRule.class;
	}

	@Override
	protected ConfigCodeRule insertEntity(ConfigCodeRule entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigCodeRule updatePartEntity(ConfigCodeRule entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigCodeRule updateEntity(ConfigCodeRule entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public String createCode(String className, Long billTypeDictId, Map<String, Object> mapTableObjectFunction,
			CommonParam commonParam) throws BusinessException, SQLException {
 
		return configCodeRuleDao.createCode(className, billTypeDictId, mapTableObjectFunction, commonParam);
	}

}
