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
import com.techsoft.entity.common.ConfigTableField;
import com.techsoft.entity.common.ConfigTableObject;
import com.techsoft.entity.config.ConfigTableFieldParamVo;
import com.techsoft.entity.config.ConfigTableFieldVo;
import com.techsoft.service.config.ConfigTableFieldService;
import com.techsoft.service.config.ConfigTableObjectService;

@org.springframework.stereotype.Service
public class ClientConfigTableFieldServiceImpl extends BaseClientServiceImpl<ConfigTableField>
		implements ClientConfigTableFieldService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigTableFieldService configTableFieldService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigTableObjectService configTableObjectService;

	@Override
	public BaseService<ConfigTableField> getBaseService() {
		return configTableFieldService;
	}

	private ConfigTableFieldVo getVo(ConfigTableField configTableField, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigTableFieldVo vo = new ConfigTableFieldVo(configTableField);
		if (vo.getTableObjectId() != null && vo.getTableObjectId() > 0L) {
			ConfigTableObject configTableObject = configTableObjectService.selectById(vo.getTableObjectId(),
					commonParam);
			if (configTableObject != null) {
				vo.setConfigTableObject(configTableObject);
			}
		}
		return vo;
	}

	private ConfigTableFieldVo getExtendVo(ConfigTableField configTableField, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigTableFieldVo vo = this.getVo(configTableField, commonParam);

		return vo;
	}

	private List<ConfigTableFieldVo> getVoList(List<ConfigTableField> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigTableFieldVo> voList = new ArrayList<ConfigTableFieldVo>();
		for (ConfigTableField entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ConfigTableFieldVo> getExtendVoList(List<ConfigTableField> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigTableFieldVo> voList = new ArrayList<ConfigTableFieldVo>();
		for (ConfigTableField entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ConfigTableFieldVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigTableField entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ConfigTableFieldVo> selectListVoByParamVo(ConfigTableFieldParamVo configTableField,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configTableField == null) {
			configTableField = new ConfigTableFieldParamVo();
		}
		configTableField.setTenantId(commonParam.getTenantId());

		List<ConfigTableField> list = (List<ConfigTableField>) this.getBaseService()
				.selectListByParamVo(configTableField, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigTableFieldVo> selectPageVoByParamVo(ConfigTableFieldParamVo configTableField,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configTableField == null) {
			configTableField = new ConfigTableFieldParamVo();
		}
		configTableField.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigTableField> list = (PageInfo<ConfigTableField>) this.getBaseService()
				.selectPageByParamVo(configTableField, commonParam, pageNo, pageSize);
		List<ConfigTableFieldVo> volist = new ArrayList<ConfigTableFieldVo>();

		Iterator<ConfigTableField> iter = list.getList().iterator();
		ConfigTableFieldVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigTableFieldVo> vpage = new Page<ConfigTableFieldVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ConfigTableFieldVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigTableField entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ConfigTableFieldVo> selectListExtendVoByParamVo(ConfigTableFieldParamVo configTableField,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configTableField == null) {
			configTableField = new ConfigTableFieldParamVo();
		}
		configTableField.setTenantId(commonParam.getTenantId());

		List<ConfigTableField> list = (List<ConfigTableField>) this.getBaseService()
				.selectListByParamVo(configTableField, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigTableFieldVo> selectPageExtendVoByParamVo(ConfigTableFieldParamVo configTableField,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configTableField == null) {
			configTableField = new ConfigTableFieldParamVo();
		}
		configTableField.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigTableField> list = (PageInfo<ConfigTableField>) this.getBaseService()
				.selectPageByParamVo(configTableField, commonParam, pageNo, pageSize);
		List<ConfigTableFieldVo> volist = new ArrayList<ConfigTableFieldVo>();

		Iterator<ConfigTableField> iter = list.getList().iterator();
		ConfigTableFieldVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigTableFieldVo> vpage = new Page<ConfigTableFieldVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ConfigTableFieldParamVo configTableFieldParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		ConfigTableField configTableField = null;
		try {
			if (configTableFieldParamVo.getId() == null) {// 新增

				configTableFieldParamVo.setTenantId(commonParam.getTenantId());
				configTableField = configTableFieldService.saveOrUpdate(configTableFieldParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ConfigTableField configTableFieldVoTemp = this.selectById(configTableFieldParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(configTableFieldVoTemp, configTableFieldParamVo);

				configTableField = configTableFieldService.saveOrUpdate(configTableFieldVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(configTableField);
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
