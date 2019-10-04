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
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ConfigLabel;
import com.techsoft.entity.config.ConfigLabelParamVo;
import com.techsoft.entity.config.ConfigLabelVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.config.ConfigLabelService;

@org.springframework.stereotype.Service
public class ClientConfigLabelServiceImpl extends BaseClientServiceImpl<ConfigLabel>
		implements ClientConfigLabelService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigLabelService configLabelService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;

	@Override
	public BaseService<ConfigLabel> getBaseService() {
		return configLabelService;
	}

	private ConfigLabelVo getVo(ConfigLabel configLabel, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigLabelVo vo = new ConfigLabelVo(configLabel);
		// 打印方式
		if (vo.getPrintModeDictId() != null && vo.getPrintModeDictId() > 0L) {
			ConfigDictionary printModeDictId = configDictionaryService.selectById(vo.getPrintModeDictId(), commonParam);
			if (printModeDictId != null) {
				vo.setPrintModeDict(printModeDictId);
			}
		}

		// 条码规则类型
		if (vo.getBarcodeRuleDictId() != null && vo.getBarcodeRuleDictId() > 0L) {
			ConfigDictionary barcodeRuleDictId = configDictionaryService.selectById(vo.getBarcodeRuleDictId(),
					commonParam);
			if (barcodeRuleDictId != null) {
				vo.setBarcodeRuleDict(barcodeRuleDictId);
			}
		}
		return vo;
	}

	private ConfigLabelVo getExtendVo(ConfigLabel configLabel, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigLabelVo vo = this.getVo(configLabel, commonParam);

		return vo;
	}

	private List<ConfigLabelVo> getVoList(List<ConfigLabel> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigLabelVo> voList = new ArrayList<ConfigLabelVo>();
		for (ConfigLabel entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ConfigLabelVo> getExtendVoList(List<ConfigLabel> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigLabelVo> voList = new ArrayList<ConfigLabelVo>();
		for (ConfigLabel entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ConfigLabelVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigLabel entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ConfigLabelVo> selectListVoByParamVo(ConfigLabelParamVo configLabel, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (configLabel == null) {
			configLabel = new ConfigLabelParamVo();
		}
		configLabel.setTenantId(commonParam.getTenantId());

		List<ConfigLabel> list = (List<ConfigLabel>) this.getBaseService().selectListByParamVo(configLabel,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigLabelVo> selectPageVoByParamVo(ConfigLabelParamVo configLabel, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configLabel == null) {
			configLabel = new ConfigLabelParamVo();
		}
		configLabel.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigLabel> list = (PageInfo<ConfigLabel>) this.getBaseService().selectPageByParamVo(configLabel,
				commonParam, pageNo, pageSize);
		List<ConfigLabelVo> volist = new ArrayList<ConfigLabelVo>();

		Iterator<ConfigLabel> iter = list.getList().iterator();
		ConfigLabelVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigLabelVo> vpage = new Page<ConfigLabelVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ConfigLabelVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigLabel entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ConfigLabelVo> selectListExtendVoByParamVo(ConfigLabelParamVo configLabel, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (configLabel == null) {
			configLabel = new ConfigLabelParamVo();
		}
		configLabel.setTenantId(commonParam.getTenantId());

		List<ConfigLabel> list = (List<ConfigLabel>) this.getBaseService().selectListByParamVo(configLabel,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigLabelVo> selectPageExtendVoByParamVo(ConfigLabelParamVo configLabel, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configLabel == null) {
			configLabel = new ConfigLabelParamVo();
		}
		configLabel.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigLabel> list = (PageInfo<ConfigLabel>) this.getBaseService().selectPageByParamVo(configLabel,
				commonParam, pageNo, pageSize);
		List<ConfigLabelVo> volist = new ArrayList<ConfigLabelVo>();

		Iterator<ConfigLabel> iter = list.getList().iterator();
		ConfigLabelVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigLabelVo> vpage = new Page<ConfigLabelVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ConfigLabelParamVo configLabelParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		ConfigLabel configLabel = null;
		try {
			if (configLabelParamVo.getId() == null) {// 新增

				configLabelParamVo.setTenantId(commonParam.getTenantId());
				configLabel = configLabelService.saveOrUpdate(configLabelParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ConfigLabel configLabelVoTemp = this.selectById(configLabelParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(configLabelVoTemp, configLabelParamVo);

				configLabel = configLabelService.saveOrUpdate(configLabelVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(configLabel);
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
	public List<Map<String, String>> createValue(Long labelId, Integer quantity,
			Map<String, Object> mapTableObjectFunction, CommonParam commonParam)
			throws BusinessException, SQLException {
		return configLabelService.createValue(labelId, quantity, mapTableObjectFunction, commonParam);
	}
}
