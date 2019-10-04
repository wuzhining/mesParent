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
import com.techsoft.entity.common.ConfigSerialNumber;
import com.techsoft.entity.common.ConfigTableObject;
import com.techsoft.entity.config.ConfigSerialNumberParamVo;
import com.techsoft.entity.config.ConfigSerialNumberVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.config.ConfigSerialNumberService;
import com.techsoft.service.config.ConfigTableObjectService;

@org.springframework.stereotype.Service
public class ClientConfigSerialNumberServiceImpl extends BaseClientServiceImpl<ConfigSerialNumber>
		implements ClientConfigSerialNumberService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigSerialNumberService configSerialNumberService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigTableObjectService configTableObjectService;

	@Override
	public BaseService<ConfigSerialNumber> getBaseService() {
		return configSerialNumberService;
	}

	private ConfigSerialNumberVo getVo(ConfigSerialNumber configSerialNumber, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigSerialNumberVo vo = new ConfigSerialNumberVo(configSerialNumber);
		if (vo.getTableObjectId() != null && vo.getTableObjectId() > 0L) {
			ConfigTableObject configTableObject = configTableObjectService.selectById(vo.getTableObjectId(),
					commonParam);
			if (configTableObject != null) {
				vo.setConfigTableObject(configTableObject);
			}
		}

		if (vo.getResetmodeDictId() != null && vo.getResetmodeDictId() > 0L) {
			ConfigDictionary configresetmodeList = configDictionaryService.selectById(vo.getResetmodeDictId(),
					commonParam);
			if (configresetmodeList != null) {
				vo.setConfigresetmodeList(configresetmodeList);
			}
		}
		return vo;
	}

	private ConfigSerialNumberVo getExtendVo(ConfigSerialNumber configSerialNumber, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigSerialNumberVo vo = this.getVo(configSerialNumber, commonParam);

		return vo;
	}

	private List<ConfigSerialNumberVo> getVoList(List<ConfigSerialNumber> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigSerialNumberVo> voList = new ArrayList<ConfigSerialNumberVo>();
		for (ConfigSerialNumber entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ConfigSerialNumberVo> getExtendVoList(List<ConfigSerialNumber> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigSerialNumberVo> voList = new ArrayList<ConfigSerialNumberVo>();
		for (ConfigSerialNumber entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ConfigSerialNumberVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigSerialNumber entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ConfigSerialNumberVo> selectListVoByParamVo(ConfigSerialNumberParamVo configSerialNumber,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configSerialNumber == null) {
			configSerialNumber = new ConfigSerialNumberParamVo();
		}
		configSerialNumber.setTenantId(commonParam.getTenantId());

		List<ConfigSerialNumber> list = (List<ConfigSerialNumber>) this.getBaseService()
				.selectListByParamVo(configSerialNumber, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigSerialNumberVo> selectPageVoByParamVo(ConfigSerialNumberParamVo configSerialNumber,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configSerialNumber == null) {
			configSerialNumber = new ConfigSerialNumberParamVo();
		}
		configSerialNumber.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigSerialNumber> list = (PageInfo<ConfigSerialNumber>) this.getBaseService()
				.selectPageByParamVo(configSerialNumber, commonParam, pageNo, pageSize);
		List<ConfigSerialNumberVo> volist = new ArrayList<ConfigSerialNumberVo>();

		Iterator<ConfigSerialNumber> iter = list.getList().iterator();
		ConfigSerialNumberVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigSerialNumberVo> vpage = new Page<ConfigSerialNumberVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ConfigSerialNumberVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigSerialNumber entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ConfigSerialNumberVo> selectListExtendVoByParamVo(ConfigSerialNumberParamVo configSerialNumber,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configSerialNumber == null) {
			configSerialNumber = new ConfigSerialNumberParamVo();
		}
		configSerialNumber.setTenantId(commonParam.getTenantId());

		List<ConfigSerialNumber> list = (List<ConfigSerialNumber>) this.getBaseService()
				.selectListByParamVo(configSerialNumber, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigSerialNumberVo> selectPageExtendVoByParamVo(ConfigSerialNumberParamVo configSerialNumber,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configSerialNumber == null) {
			configSerialNumber = new ConfigSerialNumberParamVo();
		}
		configSerialNumber.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigSerialNumber> list = (PageInfo<ConfigSerialNumber>) this.getBaseService()
				.selectPageByParamVo(configSerialNumber, commonParam, pageNo, pageSize);
		List<ConfigSerialNumberVo> volist = new ArrayList<ConfigSerialNumberVo>();

		Iterator<ConfigSerialNumber> iter = list.getList().iterator();
		ConfigSerialNumberVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigSerialNumberVo> vpage = new Page<ConfigSerialNumberVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ConfigSerialNumberParamVo configSerialNumberParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		ConfigSerialNumber configSerialNumber = null;
		if (configSerialNumberParamVo.getSerialName() == null) {
			resultMessage.addErr("序列号名称不能为空");
			return resultMessage;
		}
		/*
		 * if (configSerialNumberVo.getDatatableDictId() == null) {
		 * resultMessage.addErr("数据表id不能为空"); return resultMessage; }
		 */
		if (configSerialNumberParamVo.getMinimum() == null) {
			resultMessage.addErr("最小值不能为空");
			return resultMessage;
		}
		if (configSerialNumberParamVo.getMaximum() == null) {
			resultMessage.addErr("最大值不能为空");
			return resultMessage;
		}
		if (configSerialNumberParamVo.getResetmodeDictId() == null) {
			resultMessage.addErr("复位方式不能为空");
			return resultMessage;
		}
		try {
			if (configSerialNumberParamVo.getId() == null) {// 新增

				configSerialNumberParamVo.setTenantId(commonParam.getTenantId());
				configSerialNumber = configSerialNumberService.saveOrUpdate(configSerialNumberParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ConfigSerialNumber configSerialNumberVoTemp = this.selectById(configSerialNumberParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(configSerialNumberVoTemp, configSerialNumberParamVo);

				configSerialNumber = configSerialNumberService.saveOrUpdate(configSerialNumberVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(configSerialNumber);
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
