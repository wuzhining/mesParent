package com.techsoft.client.service.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.ConfigCodeRule;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ConfigTableObject;
import com.techsoft.entity.config.ConfigCodeRuleParamVo;
import com.techsoft.entity.config.ConfigCodeRuleVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.config.ConfigLabelFunctionService;
import com.techsoft.service.config.ConfigTableFieldService;
import com.techsoft.service.config.ConfigTableObjectService;

@org.springframework.stereotype.Service
public class ClientConfigCodeRuleServiceImpl extends BaseClientServiceImpl<ConfigCodeRule>
		implements ClientConfigCodeRuleService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigTableObjectService configTableObjectService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigLabelFunctionService configLabelFunctionService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigTableFieldService configTableFieldService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;

	@Override
	public BaseService<ConfigCodeRule> getBaseService() {
		return configCodeRuleService;
	}

	private ConfigCodeRuleVo getVo(ConfigCodeRule configCodeRule, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigCodeRuleVo vo = new ConfigCodeRuleVo(configCodeRule);
		if (vo.getTableObjectId() != null && vo.getTableObjectId() > 0L) {
			ConfigTableObject configTableObject = configTableObjectService.selectById(vo.getTableObjectId(),
					commonParam);
			if (configTableObject != null) {
				vo.setConfigTableObject(configTableObject);
			}
		}
		if (vo.getBillTypeDictId() != null && vo.getBillTypeDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getBillTypeDictId(), commonParam);
			if (configDictionary != null) {
				vo.setConfigDictionary(configDictionary);
			}
		}
		return vo;
	}

	private ConfigCodeRuleVo getExtendVo(ConfigCodeRule configCodeRule, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigCodeRuleVo vo = this.getVo(configCodeRule, commonParam);
		return vo;
	}

	private List<ConfigCodeRuleVo> getVoList(List<ConfigCodeRule> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigCodeRuleVo> voList = new ArrayList<ConfigCodeRuleVo>();
		for (ConfigCodeRule entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ConfigCodeRuleVo> getExtendVoList(List<ConfigCodeRule> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigCodeRuleVo> voList = new ArrayList<ConfigCodeRuleVo>();
		for (ConfigCodeRule entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ConfigCodeRuleVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigCodeRule entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ConfigCodeRuleVo> selectListVoByParamVo(ConfigCodeRuleParamVo configCodeRule, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (configCodeRule == null) {
			configCodeRule = new ConfigCodeRuleParamVo();
		}
		configCodeRule.setTenantId(commonParam.getTenantId());

		List<ConfigCodeRule> list = (List<ConfigCodeRule>) this.getBaseService().selectListByParamVo(configCodeRule,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigCodeRuleVo> selectPageVoByParamVo(ConfigCodeRuleParamVo configCodeRule,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configCodeRule == null) {
			configCodeRule = new ConfigCodeRuleParamVo();
		}
		configCodeRule.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigCodeRule> list = (PageInfo<ConfigCodeRule>) this.getBaseService()
				.selectPageByParamVo(configCodeRule, commonParam, pageNo, pageSize);
		List<ConfigCodeRuleVo> volist = new ArrayList<ConfigCodeRuleVo>();

		Iterator<ConfigCodeRule> iter = list.getList().iterator();
		ConfigCodeRuleVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigCodeRuleVo> vpage = new Page<ConfigCodeRuleVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ConfigCodeRuleVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigCodeRule entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ConfigCodeRuleVo> selectListExtendVoByParamVo(ConfigCodeRuleParamVo configCodeRule,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configCodeRule == null) {
			configCodeRule = new ConfigCodeRuleParamVo();
		}
		configCodeRule.setTenantId(commonParam.getTenantId());

		List<ConfigCodeRule> list = (List<ConfigCodeRule>) this.getBaseService().selectListByParamVo(configCodeRule,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigCodeRuleVo> selectPageExtendVoByParamVo(ConfigCodeRuleParamVo configCodeRule,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configCodeRule == null) {
			configCodeRule = new ConfigCodeRuleParamVo();
		}
		configCodeRule.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigCodeRule> list = (PageInfo<ConfigCodeRule>) this.getBaseService()
				.selectPageByParamVo(configCodeRule, commonParam, pageNo, pageSize);
		List<ConfigCodeRuleVo> volist = new ArrayList<ConfigCodeRuleVo>();

		Iterator<ConfigCodeRule> iter = list.getList().iterator();
		ConfigCodeRuleVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigCodeRuleVo> vpage = new Page<ConfigCodeRuleVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ConfigCodeRuleParamVo configCodeRuleParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		ConfigCodeRule configCodeRule = null;
		if (configCodeRuleParamVo.getCodeRuleName() == null) {
			resultMessage.addErr("编码名称不能为空");
			return resultMessage;
		}
		if (configCodeRuleParamVo.getTableObjectId() == null) {
			resultMessage.addErr("数据表不能为空");
			return resultMessage;
		}
		try {
			if (configCodeRuleParamVo.getId() == null) {// 新增

				configCodeRuleParamVo.setTenantId(commonParam.getTenantId());
				configCodeRule = configCodeRuleService.saveOrUpdate(configCodeRuleParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ConfigCodeRule configCodeRuleVoTemp = this.selectById(configCodeRuleParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(configCodeRuleVoTemp, configCodeRuleParamVo);

				configCodeRule = configCodeRuleService.saveOrUpdate(configCodeRuleVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(configCodeRule);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public String createCode(String className, Long billTypeDictId, Map<String, Object> mapTableObjectFunction,
			CommonParam commonParam) throws BusinessException, SQLException {
		return configCodeRuleService.createCode(className, billTypeDictId, mapTableObjectFunction, commonParam);
	}
}
