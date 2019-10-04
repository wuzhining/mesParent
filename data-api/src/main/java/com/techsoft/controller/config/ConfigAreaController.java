package com.techsoft.controller.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BusinessException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;
import com.techsoft.client.service.config.ClientConfigAreaService;
import com.techsoft.client.service.config.ClientConfigCountryService;
import com.techsoft.entity.config.ConfigAreaVo;
import com.techsoft.entity.config.ConfigCountryParamVo;

import com.techsoft.entity.common.ConfigArea;
import com.techsoft.entity.common.ConfigCountry;

import com.techsoft.entity.config.ConfigAreaParamVo;

@Controller
@RequestMapping("/config/configArea")
public class ConfigAreaController extends BaseController {
	@Autowired
	private ClientConfigAreaService clientConfigAreaService;
	@Autowired
	private ClientConfigCountryService clientConfigCountryService;

	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try{
			ConfigCountryParamVo countryVo = new ConfigCountryParamVo();
			List<ConfigCountry> countryList = clientConfigCountryService.selectListByParamVo(countryVo, null);
			modelAndView.addObject("countryList", countryList);
		      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
	    modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());
	}
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("config/configArea-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//取所属国家集合
			ConfigCountryParamVo configCountryParamVo = new ConfigCountryParamVo();
			List<ConfigCountry> country = clientConfigCountryService.selectListByParamVo(configCountryParamVo, this.getCommonParam(null));
			modelAndView.addObject("country", country);
			
			//取上级地区集合
			ConfigAreaParamVo CAPVo = new ConfigAreaParamVo();
			List<ConfigArea> configArea = clientConfigAreaService.selectListByParamVo(CAPVo, this.getCommonParam(null));
			modelAndView.addObject("configArea", configArea);
			ConfigAreaVo entity = new ConfigAreaVo();
			if (id != null) {
				entity = clientConfigAreaService.getVoByID(id, this.getCommonParam(request));
			}
			if ("2".equals(entity.getAreaType())) {
				entity.setProvinceId(entity.getParentId());
			}else if ("3".equals(entity.getAreaType())) {
				ConfigAreaVo entity1 = new ConfigAreaVo();
				entity1 = clientConfigAreaService.getVoByID(entity.getParentId(), this.getCommonParam(request));
				entity.setProvinceId(entity1.getParentId());
				entity.setCityId(entity.getParentId());;
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("config/configArea-edit");
			initData(modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			ConfigAreaParamVo configAreaParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(configAreaParamVo==null){
            	configAreaParamVo = new ConfigAreaParamVo();
            }
			pageInfo = clientConfigAreaService.selectPageVoByParamVo(
					configAreaParamVo, this.getCommonParam(request),
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
			ConfigAreaParamVo configAreaParamVo) {
		ResultMessage resultMessage = new ResultMessage();
		System.out.println(configAreaParamVo.getAreaType());
		if(configAreaParamVo.getAreaType().equals("1")){
			configAreaParamVo.setParentId(configAreaParamVo.getCountryId());
		}else if(configAreaParamVo.getAreaType().equals("2")){
			configAreaParamVo.setParentId(configAreaParamVo.getProvinceId());
		}else{
			configAreaParamVo.setParentId(configAreaParamVo.getCityId());
		}
	    configAreaParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientConfigAreaService.saveOrUpdate(configAreaParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
