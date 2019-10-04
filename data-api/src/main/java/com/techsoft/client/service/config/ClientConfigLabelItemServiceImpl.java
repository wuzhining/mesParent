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
import com.techsoft.entity.common.ConfigLabel;
import com.techsoft.entity.common.ConfigLabelField;
import com.techsoft.entity.common.ConfigLabelItem;
import com.techsoft.entity.config.ConfigLabelItemParamVo;
import com.techsoft.entity.config.ConfigLabelItemVo;
import com.techsoft.service.config.ConfigLabelFieldService;
import com.techsoft.service.config.ConfigLabelItemService;
import com.techsoft.service.config.ConfigLabelService;

@org.springframework.stereotype.Service
public class ClientConfigLabelItemServiceImpl extends BaseClientServiceImpl<ConfigLabelItem>
		implements ClientConfigLabelItemService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigLabelItemService configLabelItemService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigLabelFieldService configLabelFieldService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigLabelService ConfigLabelService;

	@Override
	public BaseService<ConfigLabelItem> getBaseService() {
		return configLabelItemService;
	}

	private ConfigLabelItemVo getVo(ConfigLabelItem configLabelItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigLabelItemVo vo = new ConfigLabelItemVo(configLabelItem);
		// 字段
		if (vo.getLabelFieldId() != null && vo.getLabelFieldId() > 0L) {
			ConfigLabelField configLabelField = configLabelFieldService.selectById(vo.getLabelFieldId(), commonParam);
			if (configLabelField != null) {
				vo.setConfigLabelField(configLabelField);
			}
		}

		// 字段
		if (vo.getLabelId() != null && vo.getLabelId() > 0L) {
			ConfigLabel configLabel = ConfigLabelService.selectById(vo.getLabelId(), commonParam);
			if (configLabel != null) {
				vo.setConfigLabel(configLabel);
			}
		}

		return vo;
	}

	private ConfigLabelItemVo getExtendVo(ConfigLabelItem configLabelItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigLabelItemVo vo = this.getVo(configLabelItem, commonParam);

		return vo;
	}

	private List<ConfigLabelItemVo> getVoList(List<ConfigLabelItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigLabelItemVo> voList = new ArrayList<ConfigLabelItemVo>();
		for (ConfigLabelItem entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ConfigLabelItemVo> getExtendVoList(List<ConfigLabelItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigLabelItemVo> voList = new ArrayList<ConfigLabelItemVo>();
		for (ConfigLabelItem entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ConfigLabelItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigLabelItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ConfigLabelItemVo> selectListVoByParamVo(ConfigLabelItemParamVo configLabelItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configLabelItem == null) {
			configLabelItem = new ConfigLabelItemParamVo();
		}
		configLabelItem.setTenantId(commonParam.getTenantId());

		List<ConfigLabelItem> list = (List<ConfigLabelItem>) this.getBaseService().selectListByParamVo(configLabelItem,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigLabelItemVo> selectPageVoByParamVo(ConfigLabelItemParamVo configLabelItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configLabelItem == null) {
			configLabelItem = new ConfigLabelItemParamVo();
		}
		configLabelItem.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigLabelItem> list = (PageInfo<ConfigLabelItem>) this.getBaseService()
				.selectPageByParamVo(configLabelItem, commonParam, pageNo, pageSize);
		List<ConfigLabelItemVo> volist = new ArrayList<ConfigLabelItemVo>();

		Iterator<ConfigLabelItem> iter = list.getList().iterator();
		ConfigLabelItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigLabelItemVo> vpage = new Page<ConfigLabelItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ConfigLabelItemVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigLabelItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ConfigLabelItemVo> selectListExtendVoByParamVo(ConfigLabelItemParamVo configLabelItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configLabelItem == null) {
			configLabelItem = new ConfigLabelItemParamVo();
		}
		configLabelItem.setTenantId(commonParam.getTenantId());

		List<ConfigLabelItem> list = (List<ConfigLabelItem>) this.getBaseService().selectListByParamVo(configLabelItem,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigLabelItemVo> selectPageExtendVoByParamVo(ConfigLabelItemParamVo configLabelItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configLabelItem == null) {
			configLabelItem = new ConfigLabelItemParamVo();
		}
		configLabelItem.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigLabelItem> list = (PageInfo<ConfigLabelItem>) this.getBaseService()
				.selectPageByParamVo(configLabelItem, commonParam, pageNo, pageSize);
		List<ConfigLabelItemVo> volist = new ArrayList<ConfigLabelItemVo>();

		Iterator<ConfigLabelItem> iter = list.getList().iterator();
		ConfigLabelItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigLabelItemVo> vpage = new Page<ConfigLabelItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ConfigLabelItemParamVo configLabelItemParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		ConfigLabelItem configLabelItem = null;
		try {
			if (configLabelItemParamVo.getId() == null) {// 新增

				configLabelItemParamVo.setTenantId(commonParam.getTenantId());
				configLabelItem = configLabelItemService.saveOrUpdate(configLabelItemParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ConfigLabelItem configLabelItemVoTemp = this.selectById(configLabelItemParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(configLabelItemVoTemp, configLabelItemParamVo);

				configLabelItem = configLabelItemService.saveOrUpdate(configLabelItemVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(configLabelItem);
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
