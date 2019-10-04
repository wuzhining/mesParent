package com.techsoft.client.service.firm;

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
import com.techsoft.entity.common.ConfigArea;
import com.techsoft.entity.common.ConfigCountry;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.firm.FirmPartnerParamVo;
import com.techsoft.entity.firm.FirmPartnerVo;
import com.techsoft.service.config.ConfigAreaService;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigCountryService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.firm.FirmPartnerService;

@org.springframework.stereotype.Service
public class ClientFirmPartnerServiceImpl extends BaseClientServiceImpl<FirmPartner>
		implements ClientFirmPartnerService {
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmPartnerService firmPartnerService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCountryService configCountryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigAreaService configAreaService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;

	@Override
	public BaseService<FirmPartner> getBaseService() {
		return firmPartnerService;
	}

	private FirmPartnerVo getVo(FirmPartner firmPartner, CommonParam commonParam)
			throws BusinessException, SQLException {
		FirmPartnerVo vo = new FirmPartnerVo(firmPartner);
		if (vo.getPartnerTypeDictId() != null && vo.getPartnerTypeDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getPartnerTypeDictId(),
					commonParam);
			if (configDictionary != null) {
				vo.setConfigDictionary(configDictionary);
			}
		}
		if (vo.getCountryId() != null && vo.getCountryId() > 0L) {
			ConfigCountry configCountry = configCountryService.selectById(vo.getCountryId(), commonParam);
			if (configCountry != null) {
				vo.setConfigCountry(configCountry);
			}
		}
		if (vo.getProvinceId() != null && vo.getProvinceId() > 0L) {
			ConfigArea ConfigAreaP = configAreaService.selectById(vo.getProvinceId(), commonParam);
			if (ConfigAreaP != null) {
				vo.setConfigAreaP(ConfigAreaP);
			}
		}
		if (vo.getCityId() != null && vo.getCityId() > 0L) {
			ConfigArea ConfigAreaC = configAreaService.selectById(vo.getCityId(), commonParam);
			if (ConfigAreaC != null) {
				vo.setConfigAreaC(ConfigAreaC);
			}
		}
		if (vo.getAreaId() != null && vo.getAreaId() > 0L) {
			ConfigArea ConfigArea = configAreaService.selectById(vo.getAreaId(), commonParam);
			if (ConfigArea != null) {
				vo.setConfigArea(ConfigArea);
			}
		}
		return vo;
	}

	private FirmPartnerVo getExtendVo(FirmPartner firmPartner, CommonParam commonParam)
			throws BusinessException, SQLException {
		FirmPartnerVo vo = this.getVo(firmPartner, commonParam);

		return vo;
	}

	private List<FirmPartnerVo> getVoList(List<FirmPartner> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<FirmPartnerVo> voList = new ArrayList<FirmPartnerVo>();
		for (FirmPartner entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<FirmPartnerVo> getExtendVoList(List<FirmPartner> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<FirmPartnerVo> voList = new ArrayList<FirmPartnerVo>();
		for (FirmPartner entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public FirmPartnerVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		FirmPartner entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<FirmPartnerVo> selectListVoByParamVo(FirmPartnerParamVo firmPartner, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (firmPartner == null) {
			firmPartner = new FirmPartnerParamVo();
		}
		firmPartner.setTenantId(commonParam.getTenantId());

		List<FirmPartner> list = (List<FirmPartner>) this.getBaseService().selectListByParamVo(firmPartner,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<FirmPartnerVo> selectPageVoByParamVo(FirmPartnerParamVo firmPartner, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (firmPartner == null) {
			firmPartner = new FirmPartnerParamVo();
		}
		firmPartner.setTenantId(commonParam.getTenantId());

		PageInfo<FirmPartner> list = (PageInfo<FirmPartner>) this.getBaseService().selectPageByParamVo(firmPartner,
				commonParam, pageNo, pageSize);
		List<FirmPartnerVo> volist = new ArrayList<FirmPartnerVo>();

		Iterator<FirmPartner> iter = list.getList().iterator();
		FirmPartnerVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<FirmPartnerVo> vpage = new Page<FirmPartnerVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public FirmPartnerVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		FirmPartner entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<FirmPartnerVo> selectListExtendVoByParamVo(FirmPartnerParamVo firmPartner, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (firmPartner == null) {
			firmPartner = new FirmPartnerParamVo();
		}
		firmPartner.setTenantId(commonParam.getTenantId());

		List<FirmPartner> list = (List<FirmPartner>) this.getBaseService().selectListByParamVo(firmPartner,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<FirmPartnerVo> selectPageExtendVoByParamVo(FirmPartnerParamVo firmPartner, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (firmPartner == null) {
			firmPartner = new FirmPartnerParamVo();
		}
		firmPartner.setTenantId(commonParam.getTenantId());

		PageInfo<FirmPartner> list = (PageInfo<FirmPartner>) this.getBaseService().selectPageByParamVo(firmPartner,
				commonParam, pageNo, pageSize);
		List<FirmPartnerVo> volist = new ArrayList<FirmPartnerVo>();

		Iterator<FirmPartner> iter = list.getList().iterator();
		FirmPartnerVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<FirmPartnerVo> vpage = new Page<FirmPartnerVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(FirmPartnerParamVo firmPartnerParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		FirmPartner firmPartner = null;
		if (firmPartnerParamVo.getStatus() == null) {
			resultMessage.addErr("状态不能为空");
			return resultMessage;
		}
		if (firmPartnerParamVo.getPartnerTypeDictId() == null) {
			resultMessage.addErr("合作伙伴类型不能为空");
			return resultMessage;
		}
		if (firmPartnerParamVo.getCompanyName() == null) {
			resultMessage.addErr("公司名称不能为空");
			return resultMessage;
		}
		try {
			if (firmPartnerParamVo.getId() == null) {// 新增
				//生成编码
				/*String code = configCodeRuleService.createCode(FirmPartner.class.getName(), null, null, commonParam);
				if(code!=null&&code!=""){
					firmPartnerParamVo.setCompanyCode(code);
					firmPartnerParamVo.setTenantId(commonParam.getTenantId());
					firmPartner = firmPartnerService.saveOrUpdate(firmPartnerParamVo, commonParam);
					resultMessage.setIsSuccess(true);
				}else{
					resultMessage.addErr("请维护公司编码");
					return resultMessage;
				}*/
				
				firmPartnerParamVo.setTenantId(commonParam.getTenantId());
				firmPartner = firmPartnerService.saveOrUpdate(firmPartnerParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				FirmPartner firmPartnerVoTemp = this.selectById(firmPartnerParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(firmPartnerVoTemp, firmPartnerParamVo);

				firmPartner = firmPartnerService.saveOrUpdate(firmPartnerVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(firmPartner);
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
