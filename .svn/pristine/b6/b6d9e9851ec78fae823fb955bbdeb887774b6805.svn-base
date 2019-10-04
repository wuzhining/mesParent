package com.techsoft.service.config;

import java.util.ArrayList;
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
import com.techsoft.dao.config.ConfigLabelDao;
import com.techsoft.dao.config.ConfigLabelFieldDao;
import com.techsoft.dao.config.ConfigLabelFieldItemDao;
import com.techsoft.dao.config.ConfigLabelFunctionDao;
import com.techsoft.dao.config.ConfigLabelItemDao;
import com.techsoft.dao.config.ConfigSerialNumberDao;
import com.techsoft.dao.config.ConfigTableFieldDao;
import com.techsoft.dao.config.ConfigTableObjectDao;
import com.techsoft.entity.common.ConfigLabel;
import com.techsoft.entity.common.ConfigLabelField;
import com.techsoft.entity.common.ConfigLabelFieldItem;
import com.techsoft.entity.common.ConfigLabelFunction;
import com.techsoft.entity.common.ConfigLabelItem;
import com.techsoft.entity.common.ConfigSerialNumber;
import com.techsoft.entity.common.ConfigTableField;
import com.techsoft.entity.common.ConfigTableObject;
import com.techsoft.entity.config.ConfigLabelFieldItemParamVo;
import com.techsoft.entity.config.ConfigLabelItemParamVo;
import com.techsoft.entity.config.ConfigTableObjectParamVo;
import com.techsoft.utils.zklock.DistributedLock;
import com.techsoft.utils.zklock.LockManager;

@Service
public class ConfigLabelServiceImpl extends BaseServiceImpl<ConfigLabel> implements ConfigLabelService {
	@Autowired
	private ConfigLabelDao configLabelDao;
	@Autowired
	private ConfigLabelItemDao configLabelItemDao;
	@Autowired
	private ConfigLabelFieldDao configLabelFieldDao;
	@Autowired
	private ConfigLabelFieldItemDao configLabelFieldItemDao;
	@Autowired
	private ConfigLabelFunctionDao configLabelFunctionDao;
	@Autowired
	private ConfigSerialNumberDao configSerialNumberDao;
	@Autowired
	private ConfigTableObjectDao configTableObjectDao;
	@Autowired
	private ConfigTableFieldDao configTableFieldDao;

	@Override
	public BaseDao<ConfigLabel> getBaseDao() {
		return configLabelDao;
	}

	@Override
	public Class<ConfigLabel> getEntityClass() {
		return ConfigLabel.class;
	}

	@Override
	protected ConfigLabel insertEntity(ConfigLabel entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigLabel updatePartEntity(ConfigLabel entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigLabel updateEntity(ConfigLabel entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public List<Map<String,String>> createValue(Long labelId, Integer quantity,
			Map<String, Object> mapTableObjectFunction, CommonParam commonParam)
			throws BusinessException, SQLException {

		if (labelId == null) {
			return null;
		}
		if (commonParam == null) {
			return null;
		}
		if (commonParam.getTenantId() == null) {
			return null;
		}
		if (quantity <= 0) {
			return null;
		}
		Map<Integer, List<String>> resultMap = new HashMap();
		DistributedLock distributedLock = LockManager.getZKDistributedLock(this.getEntityClass().getName(),
				commonParam.getTenantId().toString());
		distributedLock.lock();

		try {
			ConfigLabelItemParamVo configLabelItemParamVo = new ConfigLabelItemParamVo();
			configLabelItemParamVo.setLabelId(labelId);
			List<ConfigLabelItem> configLabelItemList = configLabelItemDao.selectListByParamVo(configLabelItemParamVo);

			if ((configLabelItemList != null) && (configLabelItemList.size() >= 1)) {

				Map<Long, Object> mapTableObjectIdFunction = new HashMap<Long, Object>();
				if (mapTableObjectFunction != null) {
					Set setTableObjectFunction = mapTableObjectFunction.keySet();
					Iterator itTableObjectFunction = setTableObjectFunction.iterator();
					while (itTableObjectFunction.hasNext()) {
						String classNameTableObjectFunction = (String) itTableObjectFunction.next();
						int lastIndex = classNameTableObjectFunction.lastIndexOf(".");
						String tableObjectNameFunction = classNameTableObjectFunction.substring(lastIndex + 1,
								classNameTableObjectFunction.length());
						String tableObjectPathFunction = classNameTableObjectFunction.substring(0, lastIndex);
						ConfigTableObjectParamVo configTableObjectFunctionParamVo = new ConfigTableObjectParamVo();
						configTableObjectFunctionParamVo.setTenantId(commonParam.getTenantId());
						configTableObjectFunctionParamVo.setTableObjectName(tableObjectNameFunction);
						configTableObjectFunctionParamVo.setTableObjectPath(tableObjectPathFunction);
						configTableObjectFunctionParamVo.setIsValid(EnumYesOrNo.YES.getValue());
						List<ConfigTableObject> configTableObjectFunctionList = configTableObjectDao
								.selectListByParamVo(configTableObjectFunctionParamVo);
						if ((configTableObjectFunctionList != null) && (configTableObjectFunctionList.size() >= 1)) {
							ConfigTableObject configTableObjectFunction = configTableObjectFunctionList.get(0);
							mapTableObjectIdFunction.put(configTableObjectFunction.getId(),
									mapTableObjectFunction.get(classNameTableObjectFunction));
						}
					}
				}

				for (ConfigLabelItem configLabelItem : configLabelItemList) {
					Long labelFieldId = configLabelItem.getLabelFieldId();

					Integer sortNo = configLabelItem.getSortNo(); // 返回标签元素排序号
					List<String> valueList = new ArrayList();

					ConfigLabelField configLabelField = configLabelFieldDao.selectById(labelFieldId);
					if (EnumYesOrNo.YES.getValue().equals(configLabelField.getIsValid())) {
						ConfigLabelFieldItemParamVo configLabelFieldItemParamVo = new ConfigLabelFieldItemParamVo();
						configLabelFieldItemParamVo.setLabelFieldId(labelFieldId);
						List<ConfigLabelFieldItem> configLabelFieldItemList = configLabelFieldItemDao
								.selectListByParamVo(configLabelFieldItemParamVo);

						if ((configLabelFieldItemList != null) && (configLabelFieldItemList.size() >= 1)) {

							for (int n = 1; n <= quantity; n++) {
								String code = "";
								for (ConfigLabelFieldItem configLabelFieldItem : configLabelFieldItemList) {
									Long labelFunctionId = configLabelFieldItem.getLabelFunctionId();

									ConfigLabelFunction configLabelFunction = configLabelFunctionDao
											.selectById(labelFunctionId);

									if (EnumYesOrNo.YES.getValue().equals(configLabelFunction.getIsValid())) {

										if (configLabelFunction.getLabelFunctionTypeDictId()
												.equals(EnumLabelFunctionType.FIXVALUE.getValue())) {// 固定值

											code = code + configLabelFunction.getValue();

										} else if (configLabelFunction.getLabelFunctionTypeDictId()
												.equals(EnumLabelFunctionType.DATE.getValue())) {// 日期

											code = code
													+ DateUtils.formatDate(new Date(), configLabelFunction.getValue());

										} else if (configLabelFunction.getLabelFunctionTypeDictId()
												.equals(EnumLabelFunctionType.SERIALNUMBER.getValue())) {// 序列号

											if (configLabelFunction.getSerialId() != null) {
												ConfigSerialNumber configSerialNumber = configSerialNumberDao
														.selectById(configLabelFunction.getSerialId());
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
												configSerialNumberDao.updatePartEntity(configSerialNumber, commonParam);

											}
										} else if (configLabelFunction.getLabelFunctionTypeDictId()
												.equals(EnumLabelFunctionType.DATATABLEFIELD.getValue())) {// 数据表字段

											if (mapTableObjectIdFunction != null) {
												ConfigTableField configTableField = configTableFieldDao
														.selectById(configLabelFunction.getTableFieldId());

												Object valueObject = (Object) ObjectInvoke.getFieldValueByName(
														mapTableObjectIdFunction
																.get(configLabelFunction.getTableObjectId()),
														configTableField.getTableObjectField());

												code = code + valueObject.toString();

											}
										}
									}

								}

								valueList.add(code);
							}

						}
					}

					resultMap.put(sortNo, valueList);
				}

			}

		} finally {
			distributedLock.unlock();
		}
		Set setResult = resultMap.keySet();
		List<Map<String,String>> resultList = new ArrayList();
		for (int n = 0; n < quantity; n++) {
			Map<String,String> mapJson = new HashMap();
			Iterator itResult = setResult.iterator();
			while (itResult.hasNext()) {
				Integer sortNo = (Integer) itResult.next();
				List<String> valueList = resultMap.get(sortNo);
				if ((valueList != null) && (valueList.size() >= (n+1))) {  
					mapJson.put(""+sortNo, valueList.get(n));
				}
			}
			 
			resultList.add(mapJson);
		}
		return resultList;
	}
}
