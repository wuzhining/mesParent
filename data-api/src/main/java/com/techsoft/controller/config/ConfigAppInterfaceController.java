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
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;

import com.techsoft.client.service.config.ClientConfigAppInterfaceService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.entity.config.ConfigAppInterfaceVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.config.ConfigAppInterfaceParamVo;

@Controller
@RequestMapping("/config/configAppInterface")
public class ConfigAppInterfaceController extends BaseController {
	@Autowired
	private ClientConfigAppInterfaceService clientConfigAppInterfaceService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		
		
		try {
			//接口类型
			List<ConfigDictionary> interTypeDicList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.CONFIG_INTERFACE_TYPE.getValue());
			modelAndView.addObject("interTypeDicList", interTypeDicList);
			//接口方类型
			List<ConfigDictionary> interTypeCallerDicList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.CONFIG_INTERFACE_CALLER.getValue());
			modelAndView.addObject("interTypeCallerDicList", interTypeCallerDicList);
		} catch (BusinessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("config/configAppInterface-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("config/configAppInterface-edit");
		ConfigAppInterfaceVo entity = new ConfigAppInterfaceVo();
		try {
			if (id != null) {
				entity = clientConfigAppInterfaceService.getVoByID(id, this.getCommonParam(request));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("entity", entity);
		initData(modelAndView);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			ConfigAppInterfaceParamVo configAppInterfaceParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(configAppInterfaceParamVo==null){
            	configAppInterfaceParamVo = new ConfigAppInterfaceParamVo();
            }
			pageInfo = clientConfigAppInterfaceService.selectPageVoByParamVo(
					configAppInterfaceParamVo, this.getCommonParam(request),
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
			ConfigAppInterfaceParamVo configAppInterfaceParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    configAppInterfaceParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientConfigAppInterfaceService.saveOrUpdate(configAppInterfaceParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
