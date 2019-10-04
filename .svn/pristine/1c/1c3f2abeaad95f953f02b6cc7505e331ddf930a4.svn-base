package com.techsoft.client.service.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.ConfigCodeRule;
import com.techsoft.entity.common.ConfigCodeRuleItem;
import com.techsoft.entity.common.ConfigLabelFunction;
import com.techsoft.entity.config.ConfigCodeRuleItemVo;
import com.techsoft.entity.config.ConfigCodeRuleItemParamVo;
import com.techsoft.service.config.ConfigCodeRuleItemService;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.config.ConfigLabelFunctionService;
import com.techsoft.service.config.ConfigSerialNumberService;
import com.techsoft.service.config.ConfigTableFieldService;
import com.techsoft.service.config.ConfigTableObjectService;

@org.springframework.stereotype.Service
public class ClientConfigCodeRuleItemServiceImpl extends BaseClientServiceImpl<ConfigCodeRuleItem>
		implements ClientConfigCodeRuleItemService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleItemService configCodeRuleItemService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
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
	public BaseService<ConfigCodeRuleItem> getBaseService() {
		return configCodeRuleItemService;
	}

	private ConfigCodeRuleItemVo getVo(ConfigCodeRuleItem configCodeRuleItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigCodeRuleItemVo vo = new ConfigCodeRuleItemVo(configCodeRuleItem);
		if (vo.getCodeRuleId() != null && vo.getCodeRuleId() > 0L) {
			ConfigCodeRule configCodeRule = configCodeRuleService.selectById(vo.getCodeRuleId(), commonParam);
			if (configCodeRule != null) {
				vo.setConfigCodeRule(configCodeRule);
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

	private ConfigCodeRuleItemVo getExtendVo(ConfigCodeRuleItem configCodeRuleItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigCodeRuleItemVo vo = this.getVo(configCodeRuleItem, commonParam);

		return vo;
	}

	private List<ConfigCodeRuleItemVo> getVoList(List<ConfigCodeRuleItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigCodeRuleItemVo> voList = new ArrayList<ConfigCodeRuleItemVo>();
		for (ConfigCodeRuleItem entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ConfigCodeRuleItemVo> getExtendVoList(List<ConfigCodeRuleItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigCodeRuleItemVo> voList = new ArrayList<ConfigCodeRuleItemVo>();
		for (ConfigCodeRuleItem entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ConfigCodeRuleItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigCodeRuleItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ConfigCodeRuleItemVo> selectListVoByParamVo(ConfigCodeRuleItemParamVo configCodeRuleItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configCodeRuleItem == null) {
			configCodeRuleItem = new ConfigCodeRuleItemParamVo();
		}
		configCodeRuleItem.setTenantId(commonParam.getTenantId());

		List<ConfigCodeRuleItem> list = (List<ConfigCodeRuleItem>) this.getBaseService()
				.selectListByParamVo(configCodeRuleItem, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigCodeRuleItemVo> selectPageVoByParamVo(ConfigCodeRuleItemParamVo configCodeRuleItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configCodeRuleItem == null) {
			configCodeRuleItem = new ConfigCodeRuleItemParamVo();
		}
		configCodeRuleItem.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigCodeRuleItem> list = (PageInfo<ConfigCodeRuleItem>) this.getBaseService()
				.selectPageByParamVo(configCodeRuleItem, commonParam, pageNo, pageSize);
		List<ConfigCodeRuleItemVo> volist = new ArrayList<ConfigCodeRuleItemVo>();

		Iterator<ConfigCodeRuleItem> iter = list.getList().iterator();
		ConfigCodeRuleItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigCodeRuleItemVo> vpage = new Page<ConfigCodeRuleItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ConfigCodeRuleItemVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigCodeRuleItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ConfigCodeRuleItemVo> selectListExtendVoByParamVo(ConfigCodeRuleItemParamVo configCodeRuleItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configCodeRuleItem == null) {
			configCodeRuleItem = new ConfigCodeRuleItemParamVo();
		}
		configCodeRuleItem.setTenantId(commonParam.getTenantId());

		List<ConfigCodeRuleItem> list = (List<ConfigCodeRuleItem>) this.getBaseService()
				.selectListByParamVo(configCodeRuleItem, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigCodeRuleItemVo> selectPageExtendVoByParamVo(ConfigCodeRuleItemParamVo configCodeRuleItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configCodeRuleItem == null) {
			configCodeRuleItem = new ConfigCodeRuleItemParamVo();
		}
		configCodeRuleItem.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigCodeRuleItem> list = (PageInfo<ConfigCodeRuleItem>) this.getBaseService()
				.selectPageByParamVo(configCodeRuleItem, commonParam, pageNo, pageSize);
		List<ConfigCodeRuleItemVo> volist = new ArrayList<ConfigCodeRuleItemVo>();

		Iterator<ConfigCodeRuleItem> iter = list.getList().iterator();
		ConfigCodeRuleItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigCodeRuleItemVo> vpage = new Page<ConfigCodeRuleItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ConfigCodeRuleItemParamVo configCodeRuleItemParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		ConfigCodeRuleItem configCodeRuleItem = null;
		try {
			if (configCodeRuleItemParamVo.getId() == null) {// 新增

				configCodeRuleItemParamVo.setTenantId(commonParam.getTenantId());
				configCodeRuleItem = configCodeRuleItemService.saveOrUpdate(configCodeRuleItemParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ConfigCodeRuleItem configCodeRuleItemVoTemp = this.selectById(configCodeRuleItemParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(configCodeRuleItemVoTemp, configCodeRuleItemParamVo);

				configCodeRuleItem = configCodeRuleItemService.saveOrUpdate(configCodeRuleItemVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(configCodeRuleItem);
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
