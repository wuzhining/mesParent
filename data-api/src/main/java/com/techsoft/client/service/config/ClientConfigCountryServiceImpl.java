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
import com.techsoft.entity.common.ConfigCountry;
import com.techsoft.entity.config.ConfigCountryParamVo;
import com.techsoft.entity.config.ConfigCountryVo;
import com.techsoft.service.config.ConfigCountryService;

@org.springframework.stereotype.Service
public class ClientConfigCountryServiceImpl extends BaseClientServiceImpl<ConfigCountry>
		implements ClientConfigCountryService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCountryService configCountryService;

	@Override
	public BaseService<ConfigCountry> getBaseService() {
		return configCountryService;
	}

	private ConfigCountryVo getVo(ConfigCountry configCountry, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigCountryVo vo = new ConfigCountryVo(configCountry);

		return vo;
	}

	private ConfigCountryVo getExtendVo(ConfigCountry configCountry, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigCountryVo vo = this.getVo(configCountry, commonParam);

		return vo;
	}

	private List<ConfigCountryVo> getVoList(List<ConfigCountry> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigCountryVo> voList = new ArrayList<ConfigCountryVo>();
		for (ConfigCountry entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ConfigCountryVo> getExtendVoList(List<ConfigCountry> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigCountryVo> voList = new ArrayList<ConfigCountryVo>();
		for (ConfigCountry entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ConfigCountryVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigCountry entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ConfigCountryVo> selectListVoByParamVo(ConfigCountryParamVo configCountry, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (configCountry == null) {
			configCountry = new ConfigCountryParamVo();
		}
		configCountry.setTenantId(commonParam.getTenantId());

		List<ConfigCountry> list = (List<ConfigCountry>) this.getBaseService().selectListByParamVo(configCountry,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigCountryVo> selectPageVoByParamVo(ConfigCountryParamVo configCountry, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configCountry == null) {
			configCountry = new ConfigCountryParamVo();
		}
		configCountry.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigCountry> list = (PageInfo<ConfigCountry>) this.getBaseService()
				.selectPageByParamVo(configCountry, commonParam, pageNo, pageSize);
		List<ConfigCountryVo> volist = new ArrayList<ConfigCountryVo>();

		Iterator<ConfigCountry> iter = list.getList().iterator();
		ConfigCountryVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigCountryVo> vpage = new Page<ConfigCountryVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ConfigCountryVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigCountry entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ConfigCountryVo> selectListExtendVoByParamVo(ConfigCountryParamVo configCountry,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configCountry == null) {
			configCountry = new ConfigCountryParamVo();
		}
		configCountry.setTenantId(commonParam.getTenantId());

		List<ConfigCountry> list = (List<ConfigCountry>) this.getBaseService().selectListByParamVo(configCountry,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigCountryVo> selectPageExtendVoByParamVo(ConfigCountryParamVo configCountry,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configCountry == null) {
			configCountry = new ConfigCountryParamVo();
		}
		configCountry.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigCountry> list = (PageInfo<ConfigCountry>) this.getBaseService()
				.selectPageByParamVo(configCountry, commonParam, pageNo, pageSize);
		List<ConfigCountryVo> volist = new ArrayList<ConfigCountryVo>();

		Iterator<ConfigCountry> iter = list.getList().iterator();
		ConfigCountryVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigCountryVo> vpage = new Page<ConfigCountryVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ConfigCountryParamVo configCountryParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		ConfigCountry configCountry = null;
		if(configCountryParamVo.getCountryName() == null){
			resultMessage.addErr("国家不能为空");
			return resultMessage;
		}
		if(configCountryParamVo.getCountryCode() == null){
			resultMessage.addErr("国家英文名称不能为空");
			return resultMessage;
		}
		if(configCountryParamVo.getContinent() == null){
			resultMessage.addErr("大陆名称不能为空");
			return resultMessage;
		}
		if(configCountryParamVo.getCountryType() == null){
			resultMessage.addErr("国家类型不能为空");
			return resultMessage;
		}
		try {
			if (configCountryParamVo.getId() == null) {// 新增

				configCountryParamVo.setTenantId(commonParam.getTenantId());
				configCountry = configCountryService.saveOrUpdate(configCountryParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ConfigCountry configCountryVoTemp = this.selectById(configCountryParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(configCountryVoTemp, configCountryParamVo);

				configCountry = configCountryService.saveOrUpdate(configCountryVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(configCountry);
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
