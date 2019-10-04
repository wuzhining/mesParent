package com.techsoft.controller.firm;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.config.ClientConfigAreaService;
import com.techsoft.client.service.config.ClientConfigCountryService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.firm.ClientFirmPartnerService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigArea;
import com.techsoft.entity.common.ConfigCountry;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.config.ConfigAreaParamVo;
import com.techsoft.entity.config.ConfigCountryParamVo;
import com.techsoft.entity.firm.FirmPartnerParamVo;
import com.techsoft.entity.firm.FirmPartnerVo;

@Controller
@RequestMapping("/firm/firmPartner")
public class FirmPartnerController extends BaseController {
	@Autowired
	private ClientFirmPartnerService clientFirmPartnerService;
	
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientConfigAreaService clientConfigAreaService;
	@Autowired
	private ClientConfigCountryService clientConfigCountryService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//取公司类型集合
			List<ConfigDictionary> dictionaryList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.FIRM_PARTNER_TYPE.getValue());
			modelAndView.addObject("dictionaryList", dictionaryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("firm/firmPartner-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//取公司类型集合
			List<ConfigDictionary> dictionaryList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.FIRM_PARTNER_TYPE.getValue());
			modelAndView.addObject("dictionaryList", dictionaryList);
			//取国家集合
			ConfigCountryParamVo configAreaParamVo = new ConfigCountryParamVo();
			List<ConfigCountry> configCountryList = clientConfigCountryService.selectListByParamVo(configAreaParamVo,this.getCommonParam(null));
			modelAndView.addObject("configCountryList", configCountryList);
			
			FirmPartnerVo entity = new FirmPartnerVo();
			if (id != null) {
				entity = clientFirmPartnerService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("firm/firmPartner-edit");
			initData(modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	/**
	 * 根据国家查询省份
	 * @param request 包含有country_id
	 * @param ConfigAreaParamVo 地区对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/linkByCountry")
	public List<ConfigArea> linkByCountry(HttpServletRequest request, ConfigAreaParamVo ConfigAreaParamVo) {
			if (ConfigAreaParamVo == null) {
				ConfigAreaParamVo = new ConfigAreaParamVo();
			}
			ConfigAreaParamVo.setTenantId(getLoginTenantId(request));
			List<ConfigArea> ConfigAreaList = new ArrayList<ConfigArea>();
			try {
				ConfigAreaList=clientConfigAreaService.selectListByParamVo(ConfigAreaParamVo,this.getCommonParam(request));
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return ConfigAreaList;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			FirmPartnerParamVo firmPartnerParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(firmPartnerParamVo==null){
            	firmPartnerParamVo = new FirmPartnerParamVo();
            }
			pageInfo = clientFirmPartnerService.selectPageVoByParamVo(
					firmPartnerParamVo, this.getCommonParam(request),
					pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage save(HttpServletRequest request,
			FirmPartnerParamVo firmPartnerParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    firmPartnerParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientFirmPartnerService.saveOrUpdate(firmPartnerParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	

	@RequestMapping("/getSupplier")
	@ResponseBody
	public FirmPartner getSupplier(HttpServletRequest request, Long id) {

		FirmPartnerVo firmPartnerList = new FirmPartnerVo(); 
		try {
			firmPartnerList = clientFirmPartnerService.getVoByID(id,this.getCommonParam(request));	
		} catch (SQLException | BusinessException e) {
			e.printStackTrace();
		}
	return firmPartnerList;
   }
	
	@RequestMapping("/firmPartnerOpen")
	public ModelAndView firmPartnerOpen(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("firm/firmPartner-Open");
		return modelAndView;
	}
	
	
	

}
