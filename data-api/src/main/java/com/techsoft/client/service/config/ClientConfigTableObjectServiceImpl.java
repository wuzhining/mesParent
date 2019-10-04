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
import com.techsoft.entity.common.ConfigTableObject;
import com.techsoft.entity.config.ConfigTableObjectParamVo;
import com.techsoft.entity.config.ConfigTableObjectVo;
import com.techsoft.service.config.ConfigTableObjectService;

@org.springframework.stereotype.Service
public class ClientConfigTableObjectServiceImpl extends BaseClientServiceImpl<ConfigTableObject>
		implements ClientConfigTableObjectService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigTableObjectService configTableObjectService;

	@Override
	public BaseService<ConfigTableObject> getBaseService() {
		return configTableObjectService;
	}

	private ConfigTableObjectVo getVo(ConfigTableObject configTableObject, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigTableObjectVo vo = new ConfigTableObjectVo(configTableObject);

		return vo;
	}

	private ConfigTableObjectVo getExtendVo(ConfigTableObject configTableObject, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigTableObjectVo vo = this.getVo(configTableObject, commonParam);

		return vo;
	}

	private List<ConfigTableObjectVo> getVoList(List<ConfigTableObject> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigTableObjectVo> voList = new ArrayList<ConfigTableObjectVo>();
		for (ConfigTableObject entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ConfigTableObjectVo> getExtendVoList(List<ConfigTableObject> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigTableObjectVo> voList = new ArrayList<ConfigTableObjectVo>();
		for (ConfigTableObject entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ConfigTableObjectVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigTableObject entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ConfigTableObjectVo> selectListVoByParamVo(ConfigTableObjectParamVo configTableObject,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configTableObject == null) {
			configTableObject = new ConfigTableObjectParamVo();
		}
		configTableObject.setTenantId(commonParam.getTenantId());

		List<ConfigTableObject> list = (List<ConfigTableObject>) this.getBaseService()
				.selectListByParamVo(configTableObject, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigTableObjectVo> selectPageVoByParamVo(ConfigTableObjectParamVo configTableObject,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configTableObject == null) {
			configTableObject = new ConfigTableObjectParamVo();
		}
		configTableObject.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigTableObject> list = (PageInfo<ConfigTableObject>) this.getBaseService()
				.selectPageByParamVo(configTableObject, commonParam, pageNo, pageSize);
		List<ConfigTableObjectVo> volist = new ArrayList<ConfigTableObjectVo>();

		Iterator<ConfigTableObject> iter = list.getList().iterator();
		ConfigTableObjectVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigTableObjectVo> vpage = new Page<ConfigTableObjectVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ConfigTableObjectVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigTableObject entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ConfigTableObjectVo> selectListExtendVoByParamVo(ConfigTableObjectParamVo configTableObject,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configTableObject == null) {
			configTableObject = new ConfigTableObjectParamVo();
		}
		configTableObject.setTenantId(commonParam.getTenantId());

		List<ConfigTableObject> list = (List<ConfigTableObject>) this.getBaseService()
				.selectListByParamVo(configTableObject, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigTableObjectVo> selectPageExtendVoByParamVo(ConfigTableObjectParamVo configTableObject,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configTableObject == null) {
			configTableObject = new ConfigTableObjectParamVo();
		}
		configTableObject.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigTableObject> list = (PageInfo<ConfigTableObject>) this.getBaseService()
				.selectPageByParamVo(configTableObject, commonParam, pageNo, pageSize);
		List<ConfigTableObjectVo> volist = new ArrayList<ConfigTableObjectVo>();

		Iterator<ConfigTableObject> iter = list.getList().iterator();
		ConfigTableObjectVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigTableObjectVo> vpage = new Page<ConfigTableObjectVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ConfigTableObjectParamVo configTableObjectParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		ConfigTableObject configTableObject = null;
		try {
			if (configTableObjectParamVo.getId() == null) {// 新增

				configTableObjectParamVo.setTenantId(commonParam.getTenantId());
				configTableObject = configTableObjectService.saveOrUpdate(configTableObjectParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ConfigTableObject configTableObjectVoTemp = this.selectById(configTableObjectParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(configTableObjectVoTemp, configTableObjectParamVo);

				configTableObject = configTableObjectService.saveOrUpdate(configTableObjectVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(configTableObject);
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
