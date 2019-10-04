package com.techsoft.dao.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumLabelFunctionType;
import com.techsoft.common.enums.EnumYesOrNo;
import com.techsoft.common.utils.DateUtils;
import com.techsoft.common.utils.ObjectInvoke;
import com.techsoft.common.utils.StringUtil;
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
import com.techsoft.mapper.config.ConfigCodeRuleItemMapper;
import com.techsoft.mapper.config.ConfigCodeRuleMapper;
import com.techsoft.mapper.config.ConfigLabelFunctionMapper;
import com.techsoft.mapper.config.ConfigSerialNumberMapper;
import com.techsoft.mapper.config.ConfigTableFieldMapper;
import com.techsoft.mapper.config.ConfigTableObjectMapper;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.utils.zklock.DistributedLock;
import com.techsoft.utils.zklock.LockManager;

@Repository
public class ConfigCodeRuleDaoImpl extends BaseDaoImpl<ConfigCodeRule> implements ConfigCodeRuleDao {
	@Resource
	protected ConfigCodeRuleMapper configCodeRuleMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	 
	@Resource
	protected ConfigTableObjectMapper configTableObjectMapper; 
	@Resource
	protected ConfigCodeRuleItemMapper configCodeRuleItemMapper;
	@Resource
	protected ConfigLabelFunctionMapper configLabelFunctionMapper;
	@Resource
	protected ConfigTableFieldMapper configTableFieldMapper;
	@Resource
	protected ConfigSerialNumberMapper configSerialNumberMapper;
	
	
	@Override
	public Class<ConfigCodeRule> getEntityClass() {
		return ConfigCodeRule.class;
	}	
	
	@Override
	public BaseMapper<ConfigCodeRule> getBaseMapper() {
		return this.configCodeRuleMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_CODE_RULE";
	}
	
	@Override
	public void insertSaveCheck(ConfigCodeRule value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ConfigCodeRule value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ConfigCodeRule value) throws BusinessException, SQLException {
	
	}
	@Override
	public String createCode(String className, Long billTypeDictId, Map<String, Object> mapTableObjectFunction,
			CommonParam commonParam) throws BusinessException, SQLException {

		String code = null;

		if (StringUtil.isBlank(className)) {
			throw new BusinessException("类名不能为空 "); 
		}
		if (commonParam == null) {
			throw new BusinessException("param不能为空 "); 
		}
		if (commonParam.getTenantId() == null) {
			throw new BusinessException("param不能为空 "); 
		}
		if (className.endsWith(BillWarehouse.class.getName())) {
			if (billTypeDictId == null) {
				return null;
			}
		}
		DistributedLock distributedLock = LockManager.getZKDistributedLock(this.getEntityClass().getName(),
				commonParam.getTenantId().toString());
		distributedLock.lock();
		try {
			// String className = FirmPartner.class.getName();
 
			int lastIndex = className.lastIndexOf(".");
			String tableObjectName = className.substring(lastIndex + 1, className.length());
			String tableObjectPath = className.substring(0, lastIndex);

			ConfigTableObjectParamVo configTableObjectParamVo = new ConfigTableObjectParamVo();
			configTableObjectParamVo.setTenantId(commonParam.getTenantId());
			configTableObjectParamVo.setTableObjectName(tableObjectName);
			configTableObjectParamVo.setTableObjectPath(tableObjectPath);
			configTableObjectParamVo.setIsValid(EnumYesOrNo.YES.getValue());
			List<ConfigTableObject> configTableObjectList = configTableObjectMapper.selectListByEntityParamVo(configTableObjectParamVo);

			if ((configTableObjectList != null) && (configTableObjectList.size() >= 1)) {
				ConfigTableObject configTableObject = configTableObjectList.get(0);

				ConfigCodeRuleParamVo configCodeRuleParamVo = new ConfigCodeRuleParamVo();
				configCodeRuleParamVo.setTenantId(commonParam.getTenantId());
				configCodeRuleParamVo.setTableObjectId(configTableObject.getId());
				if (billTypeDictId != null) {
					configCodeRuleParamVo.setBillTypeDictId(billTypeDictId);
				}

				List<ConfigCodeRule> configCodeRuleList = configCodeRuleMapper.selectListByEntityParamVo(configCodeRuleParamVo);

				if ((configCodeRuleList != null) && (configCodeRuleList.size() >= 1)) {
					ConfigCodeRule configCodeRule = configCodeRuleList.get(0);
					ConfigCodeRuleItemParamVo configCodeRuleItemParamVo = new ConfigCodeRuleItemParamVo();
					configCodeRuleItemParamVo.setCodeRuleId(configCodeRule.getId());
					List<ConfigCodeRuleItem> configCodeRuleItemList = configCodeRuleItemMapper.selectListByEntityParamVo(configCodeRuleItemParamVo);

					if ((configCodeRuleItemList != null) && (configCodeRuleItemList.size() >= 1)) {
					 
						Map<Long, Object> mapTableObjectIdFunction = new HashMap<Long, Object>();
						if (mapTableObjectFunction != null) {
							Set setTableObjectFunction = mapTableObjectFunction.keySet();
							Iterator itTableObjectFunction = setTableObjectFunction.iterator();
							while (itTableObjectFunction.hasNext()) {
								String classNameTableObjectFunction = (String) itTableObjectFunction.next();
								lastIndex = classNameTableObjectFunction.lastIndexOf(".");
								String tableObjectNameFunction = classNameTableObjectFunction.substring(lastIndex + 1,
										classNameTableObjectFunction.length());
								String tableObjectPathFunction = classNameTableObjectFunction.substring(0, lastIndex);
								ConfigTableObjectParamVo configTableObjectFunctionParamVo = new ConfigTableObjectParamVo();
								configTableObjectFunctionParamVo.setTenantId(commonParam.getTenantId());
								configTableObjectFunctionParamVo.setTableObjectName(tableObjectNameFunction);
								configTableObjectFunctionParamVo.setTableObjectPath(tableObjectPathFunction);
								configTableObjectFunctionParamVo.setIsValid(EnumYesOrNo.YES.getValue());
								List<ConfigTableObject> configTableObjectFunctionList = configTableObjectMapper.selectListByEntityParamVo(configTableObjectFunctionParamVo);
								if ((configTableObjectFunctionList != null)
										&& (configTableObjectFunctionList.size() >= 1)) {
									ConfigTableObject configTableObjectFunction = configTableObjectFunctionList.get(0);
									mapTableObjectIdFunction.put(configTableObjectFunction.getId(),
											mapTableObjectFunction.get(classNameTableObjectFunction));
								}
							}
						}

						code = "";
						for (ConfigCodeRuleItem configCodeRuleItem : configCodeRuleItemList) {
							Long labelFunctionId = configCodeRuleItem.getLabelFunctionId();
							ConfigLabelFunction configLabelFunction = configLabelFunctionMapper.selectById(labelFunctionId);
				 
							if (EnumYesOrNo.YES.getValue().equals(configLabelFunction.getIsValid())) {
					 
								if (configLabelFunction.getLabelFunctionTypeDictId()
										.equals(EnumLabelFunctionType.FIXVALUE.getValue())) {// 固定值

									code = code + configLabelFunction.getValue();

								} else if (configLabelFunction.getLabelFunctionTypeDictId()
										.equals(EnumLabelFunctionType.DATE.getValue())) {// 日期

									code = code + DateUtils.formatDate(new Date(), configLabelFunction.getValue());

								} else if (configLabelFunction.getLabelFunctionTypeDictId()
										.equals(EnumLabelFunctionType.SERIALNUMBER.getValue())) {// 序列号
 
									if (configLabelFunction.getSerialId() != null) {
										ConfigSerialNumber configSerialNumber = configSerialNumberMapper.selectById(configLabelFunction.getSerialId());
										Integer minimum = configSerialNumber.getMinimum();
										Integer maximum = configSerialNumber.getMaximum();
										Integer valueCurrent = configSerialNumber.getValueCurrent();
										Integer valueIncrease = configSerialNumber.getValueIncrease();
								 
										valueCurrent = valueCurrent + valueIncrease;

										if (valueCurrent > maximum) {
											valueCurrent = minimum;
										} 
										code = code + valueCurrent;
										configSerialNumber.setValueCurrent(valueCurrent);
										configSerialNumberMapper.updatePartEntity(configSerialNumber);

									}
								} else if (configLabelFunction.getLabelFunctionTypeDictId()
										.equals(EnumLabelFunctionType.DATATABLEFIELD.getValue())) {// 数据表字段
									if (mapTableObjectIdFunction != null) {
										ConfigTableField configTableField = configTableFieldMapper.selectById(configLabelFunction.getLabelFieldId());
										Object valueObject = (Object) ObjectInvoke.getFieldValueByName(
												mapTableObjectIdFunction.get(configLabelFunction.getTableObjectId()),
												configTableField.getTableObjectField());
										code = code + valueObject.toString();
									}
								}
							} 
						}

					}
				}

			}

		} finally {
			distributedLock.unlock();
		}

		return code;
	}		
 
}
