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

import com.techsoft.client.service.config.ClientConfigCodeRuleService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.config.ClientConfigTableObjectService;
import com.techsoft.entity.config.ConfigCodeRuleVo;
import com.techsoft.entity.config.ConfigTableObjectParamVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ConfigTableObject;
import com.techsoft.entity.config.ConfigCodeRuleParamVo;

@Controller
@RequestMapping("/config/configCodeRule")
public class ConfigCodeRuleController extends BaseController {
	@Autowired
	private ClientConfigCodeRuleService clientConfigCodeRuleService;
	@Autowired
	private ClientConfigTableObjectService clientConfigTableObjectService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try{
			//获取数据表集合
			ConfigTableObjectParamVo  tableObjectVo = new ConfigTableObjectParamVo();
			List<ConfigTableObject> tableObjectList = clientConfigTableObjectService.selectListByParamVo(tableObjectVo, this.getCommonParam(null));
			modelAndView.addObject("tableObjectList", tableObjectList);
			//获取单据类型
			List<ConfigDictionary> billTypeDictIdList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_TYPE.getValue());
			modelAndView.addObject("billTypeDictIdList", billTypeDictIdList);
		}catch(Exception e){
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
		modelAndView.setViewName("config/configCodeRule-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//取数据表集合
			ConfigTableObjectParamVo tableObjectVo = new ConfigTableObjectParamVo();
			List<ConfigTableObject> tableObjectList = clientConfigTableObjectService.selectListByParamVo(tableObjectVo,  this.getCommonParam(null));
			modelAndView.addObject("tableObjectList", tableObjectList);
			//获取单据类型
			List<ConfigDictionary> billTypeDictIdList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_TYPE.getValue());
			modelAndView.addObject("billTypeDictIdList", billTypeDictIdList);
			ConfigCodeRuleVo entity = new ConfigCodeRuleVo();
			if (id != null) {
				entity = clientConfigCodeRuleService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("config/configCodeRule-edit");
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
			ConfigCodeRuleParamVo configCodeRuleParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(configCodeRuleParamVo==null){
            	configCodeRuleParamVo = new ConfigCodeRuleParamVo();
            }
			pageInfo = clientConfigCodeRuleService.selectPageVoByParamVo(
					configCodeRuleParamVo, this.getCommonParam(request),
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
			ConfigCodeRuleParamVo configCodeRuleParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    configCodeRuleParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientConfigCodeRuleService.saveOrUpdate(configCodeRuleParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
