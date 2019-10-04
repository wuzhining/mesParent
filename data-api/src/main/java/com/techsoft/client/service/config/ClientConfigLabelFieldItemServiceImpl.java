package com.techsoft.client.service.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.ConfigLabelField;
import com.techsoft.entity.common.ConfigLabelFieldItem;
import com.techsoft.entity.common.ConfigLabelFunction;
import com.techsoft.entity.config.ConfigLabelFieldItemParamVo;
import com.techsoft.entity.config.ConfigLabelFieldItemVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.config.ConfigLabelFieldItemService;
import com.techsoft.service.config.ConfigLabelFieldService;
import com.techsoft.service.config.ConfigLabelFunctionService;
import com.techsoft.service.config.ConfigSerialNumberService;
import com.techsoft.service.config.ConfigTableFieldService;
import com.techsoft.service.config.ConfigTableObjectService;

@org.springframework.stereotype.Service
public class ClientConfigLabelFieldItemServiceImpl extends BaseClientServiceImpl<ConfigLabelFieldItem>
		implements ClientConfigLabelFieldItemService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigLabelFieldItemService configLabelFieldItemService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigLabelFieldService configLabelFieldService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigLabelFunctionService configLabelFunctionService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigTableObjectService configTableObjectService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigTableFieldService configTableFieldService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigSerialNumberService configSerialNumberService;

	@Override
	public BaseService<ConfigLabelFieldItem> getBaseService() {
		return configLabelFieldItemService;
	}

	private ConfigLabelFieldItemVo getVo(ConfigLabelFieldItem configLabelFieldItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigLabelFieldItemVo vo = new ConfigLabelFieldItemVo(configLabelFieldItem);
		if (vo.getLabelFieldId() != null && vo.getLabelFieldId() > 0L) {
			ConfigLabelField configLabelField = configLabelFieldService.selectById(vo.getLabelFieldId(), commonParam);
			if (configLabelField != null) {
				vo.setConfigLabelField(configLabelField);
			}
		}
		if (vo.getLabelFunctionId() != null && vo.getLabelFunctionId() > 0L) {
			ConfigLabelFunction configLabelFunction = configLabelFunctionService.selectById(vo.getLabelFunctionId(),
					commonParam);
			String tableObjectNameCn = "";
			String tableObjectFieldCn = "";
			String serialId = "";
			String dictName = "";
			if (configLabelFunction.getTableObjectId() != null && configLabelFunction.getTableObjectId() > 0L) {
				tableObjectNameCn = configTableObjectService
						.selectById(configLabelFunction.getTableObjectId(), commonParam).getTableObjectNameCn() + "-";
			}
			if (configLabelFunction.getTableFieldId() != null && configLabelFunction.getTableFieldId() > 0L) {
				tableObjectFieldCn = configTableFieldService
						.selectById(configLabelFunction.getTableFieldId(), commonParam).getTableObjectFieldCn();
			}
			if (configLabelFunction.getSerialId() != null && configLabelFunction.getSerialId() > 0L) {
				serialId = configSerialNumberService.selectById(configLabelFunction.getSerialId(), commonParam)
						.getSerialName();
			}
			if (configLabelFunction.getLabelFunctionTypeDictId() != null
					&& configLabelFunction.getLabelFunctionTypeDictId() > 0L) {
				dictName = configDictionaryService
						.selectById(configLabelFunction.getLabelFunctionTypeDictId(), commonParam).getDictName();
			}
			if (configLabelFunction != null) {
				String functionName = new StringBuilder(dictName).append("-").append(tableObjectNameCn)
						.append(tableObjectFieldCn).append(serialId)
						.append(configLabelFunction.getValue() == null ? "" : configLabelFunction.getValue())
						.toString();
				vo.setLabelFunctionName(functionName);
			}
		}
		return vo;
	}

	private ConfigLabelFieldItemVo getExtendVo(ConfigLabelFieldItem configLabelFieldItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigLabelFieldItemVo vo = this.getVo(configLabelFieldItem, commonParam);

		return vo;
	}

	private List<ConfigLabelFieldItemVo> getVoList(List<ConfigLabelFieldItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigLabelFieldItemVo> voList = new ArrayList<ConfigLabelFieldItemVo>();
		for (ConfigLabelFieldItem entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ConfigLabelFieldItemVo> getExtendVoList(List<ConfigLabelFieldItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigLabelFieldItemVo> voList = new ArrayList<ConfigLabelFieldItemVo>();
		for (ConfigLabelFieldItem entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ConfigLabelFieldItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigLabelFieldItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ConfigLabelFieldItemVo> selectListVoByParamVo(ConfigLabelFieldItemParamVo configLabelFieldItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configLabelFieldItem == null) {
			configLabelFieldItem = new ConfigLabelFieldItemParamVo();
		}
		configLabelFieldItem.setTenantId(commonParam.getTenantId());

		List<ConfigLabelFieldItem> list = (List<ConfigLabelFieldItem>) this.getBaseService()
				.selectListByParamVo(configLabelFieldItem, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigLabelFieldItemVo> selectPageVoByParamVo(ConfigLabelFieldItemParamVo configLabelFieldItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configLabelFieldItem == null) {
			configLabelFieldItem = new ConfigLabelFieldItemParamVo();
		}
		configLabelFieldItem.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigLabelFieldItem> list = (PageInfo<ConfigLabelFieldItem>) this.getBaseService()
				.selectPageByParamVo(configLabelFieldItem, commonParam, pageNo, pageSize);
		List<ConfigLabelFieldItemVo> volist = new ArrayList<ConfigLabelFieldItemVo>();

		Iterator<ConfigLabelFieldItem> iter = list.getList().iterator();
		ConfigLabelFieldItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigLabelFieldItemVo> vpage = new Page<ConfigLabelFieldItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ConfigLabelFieldItemVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigLabelFieldItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ConfigLabelFieldItemVo> selectListExtendVoByParamVo(ConfigLabelFieldItemParamVo configLabelFieldItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configLabelFieldItem == null) {
			configLabelFieldItem = new ConfigLabelFieldItemParamVo();
		}
		configLabelFieldItem.setTenantId(commonParam.getTenantId());

		List<ConfigLabelFieldItem> list = (List<ConfigLabelFieldItem>) this.getBaseService()
				.selectListByParamVo(configLabelFieldItem, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigLabelFieldItemVo> selectPageExtendVoByParamVo(
			ConfigLabelFieldItemParamVo configLabelFieldItem, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException {
		if (configLabelFieldItem == null) {
			configLabelFieldItem = new ConfigLabelFieldItemParamVo();
		}
		configLabelFieldItem.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigLabelFieldItem> list = (PageInfo<ConfigLabelFieldItem>) this.getBaseService()
				.selectPageByParamVo(configLabelFieldItem, commonParam, pageNo, pageSize);
		List<ConfigLabelFieldItemVo> volist = new ArrayList<ConfigLabelFieldItemVo>();

		Iterator<ConfigLabelFieldItem> iter = list.getList().iterator();
		ConfigLabelFieldItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigLabelFieldItemVo> vpage = new Page<ConfigLabelFieldItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ConfigLabelFieldItemParamVo configLabelFieldItemParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		ConfigLabelFieldItem configLabelFieldItem = null;
		try {
			if (configLabelFieldItemParamVo.getId() == null) {// 新增

				configLabelFieldItemParamVo.setTenantId(commonParam.getTenantId());
				configLabelFieldItem = configLabelFieldItemService.saveOrUpdate(configLabelFieldItemParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ConfigLabelFieldItem configLabelFieldItemVoTemp = this.selectById(configLabelFieldItemParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(configLabelFieldItemVoTemp, configLabelFieldItemParamVo);

				configLabelFieldItem = configLabelFieldItemService.saveOrUpdate(configLabelFieldItemVoTemp,
						commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(configLabelFieldItem);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}
}
