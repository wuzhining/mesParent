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
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ConfigLabelField;
import com.techsoft.entity.config.ConfigLabelFieldParamVo;
import com.techsoft.entity.config.ConfigLabelFieldVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.config.ConfigLabelFieldService;

@org.springframework.stereotype.Service
public class ClientConfigLabelFieldServiceImpl extends BaseClientServiceImpl<ConfigLabelField>
		implements ClientConfigLabelFieldService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigLabelFieldService configLabelFieldService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;

	@Override
	public BaseService<ConfigLabelField> getBaseService() {
		return configLabelFieldService;
	}

	private ConfigLabelFieldVo getVo(ConfigLabelField configLabelField, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigLabelFieldVo vo = new ConfigLabelFieldVo(configLabelField);

		// 打印方式
		if (vo.getPrintModeDictId() != null && vo.getPrintModeDictId() > 0L) {
			ConfigDictionary printModeDictId = configDictionaryService.selectById(vo.getPrintModeDictId(), commonParam);
			if (printModeDictId != null) {
				vo.setPrintModeDict(printModeDictId);
			}
		}
		return vo;
	}

	private ConfigLabelFieldVo getExtendVo(ConfigLabelField configLabelField, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigLabelFieldVo vo = this.getVo(configLabelField, commonParam);

		return vo;
	}

	private List<ConfigLabelFieldVo> getVoList(List<ConfigLabelField> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigLabelFieldVo> voList = new ArrayList<ConfigLabelFieldVo>();
		for (ConfigLabelField entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ConfigLabelFieldVo> getExtendVoList(List<ConfigLabelField> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigLabelFieldVo> voList = new ArrayList<ConfigLabelFieldVo>();
		for (ConfigLabelField entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ConfigLabelFieldVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigLabelField entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ConfigLabelFieldVo> selectListVoByParamVo(ConfigLabelFieldParamVo configLabelField,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configLabelField == null) {
			configLabelField = new ConfigLabelFieldParamVo();
		}
		configLabelField.setTenantId(commonParam.getTenantId());

		List<ConfigLabelField> list = (List<ConfigLabelField>) this.getBaseService()
				.selectListByParamVo(configLabelField, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigLabelFieldVo> selectPageVoByParamVo(ConfigLabelFieldParamVo configLabelField,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configLabelField == null) {
			configLabelField = new ConfigLabelFieldParamVo();
		}
		configLabelField.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigLabelField> list = (PageInfo<ConfigLabelField>) this.getBaseService()
				.selectPageByParamVo(configLabelField, commonParam, pageNo, pageSize);
		List<ConfigLabelFieldVo> volist = new ArrayList<ConfigLabelFieldVo>();

		Iterator<ConfigLabelField> iter = list.getList().iterator();
		ConfigLabelFieldVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigLabelFieldVo> vpage = new Page<ConfigLabelFieldVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ConfigLabelFieldVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigLabelField entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ConfigLabelFieldVo> selectListExtendVoByParamVo(ConfigLabelFieldParamVo configLabelField,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configLabelField == null) {
			configLabelField = new ConfigLabelFieldParamVo();
		}
		configLabelField.setTenantId(commonParam.getTenantId());

		List<ConfigLabelField> list = (List<ConfigLabelField>) this.getBaseService()
				.selectListByParamVo(configLabelField, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigLabelFieldVo> selectPageExtendVoByParamVo(ConfigLabelFieldParamVo configLabelField,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configLabelField == null) {
			configLabelField = new ConfigLabelFieldParamVo();
		}
		configLabelField.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigLabelField> list = (PageInfo<ConfigLabelField>) this.getBaseService()
				.selectPageByParamVo(configLabelField, commonParam, pageNo, pageSize);
		List<ConfigLabelFieldVo> volist = new ArrayList<ConfigLabelFieldVo>();

		Iterator<ConfigLabelField> iter = list.getList().iterator();
		ConfigLabelFieldVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigLabelFieldVo> vpage = new Page<ConfigLabelFieldVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ConfigLabelFieldParamVo configLabelFieldParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		if (configLabelFieldParamVo.getLabelFieldName() == null) {
			resultMessage.addErr("标签字段名称不能为空");
			return resultMessage;
		}
		if (configLabelFieldParamVo.getPrintModeDictId() == null) {
			resultMessage.addErr("打印方式不能为空");
			return resultMessage;
		}
		
		if (configLabelFieldParamVo.getIsBold() == null) {
			resultMessage.addErr("是否粗体不能为空");
			return resultMessage;
		}
		
		if (configLabelFieldParamVo.getIsValid() == null) {
			resultMessage.addErr("是否有效不能为空");
			return resultMessage;
		}
		ConfigLabelField configLabelField = null;
		try {
			if (configLabelFieldParamVo.getId() == null) {// 新增

				configLabelFieldParamVo.setTenantId(commonParam.getTenantId());
				configLabelField = configLabelFieldService.saveOrUpdate(configLabelFieldParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ConfigLabelField configLabelFieldVoTemp = this.selectById(configLabelFieldParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(configLabelFieldVoTemp, configLabelFieldParamVo);

				configLabelField = configLabelFieldService.saveOrUpdate(configLabelFieldVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(configLabelField);
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
