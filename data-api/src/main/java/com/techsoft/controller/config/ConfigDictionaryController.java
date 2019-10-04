package com.techsoft.controller.config;

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
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumInpectStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.config.ConfigDictionaryParamVo;
import com.techsoft.entity.config.ConfigDictionaryVo;

@Controller
@RequestMapping("/config/configDictionary")
public class ConfigDictionaryController extends BaseController {
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			List<ConfigDictionary> parentList = clientConfigDictionaryService.selectListByParentId(1L);
			modelAndView.addObject("parentList", parentList);  
		} catch (BusinessException e) { 
			e.printStackTrace();
		} catch (SQLException e) {  
			e.printStackTrace();
		}

		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("config/configDictionary-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("config/configDictionary-edit");
		ConfigDictionaryVo entity = new ConfigDictionaryVo();
		try {
			if (id != null) {
				entity = clientConfigDictionaryService.getVoByID(id, this.getCommonParam(request));
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
			ConfigDictionaryParamVo configDictionaryParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(configDictionaryParamVo==null){
            	configDictionaryParamVo = new ConfigDictionaryParamVo();
            }
            configDictionaryParamVo.setNotInDictType("System");
			pageInfo = clientConfigDictionaryService.selectPageVoByParamVo(
					configDictionaryParamVo, this.getCommonParam(request),
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
			ConfigDictionaryParamVo configDictionaryParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    configDictionaryParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientConfigDictionaryService.saveOrUpdate(configDictionaryParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	
	/**
	 * 
	 *@auther :Yang
	 *@version :2019年7月17日
	 *@param
	 *@return
	 *@description 根据检验结果获取处理结果列表（质检单模块用途）
	 */
	@ResponseBody
	@RequestMapping("/dealResult")
	public List<ConfigDictionary> dealResult(HttpServletRequest request, ConfigDictionaryParamVo configDictionaryParamVo, Long dealResultId) {
			if (configDictionaryParamVo == null) {
				configDictionaryParamVo = new ConfigDictionaryParamVo();
			}
			if(dealResultId.equals(EnumInpectStatus.QUALITY_INSPECT_RESULT_PASS.getValue())){
				configDictionaryParamVo.setId(10477L);
			}else{
				configDictionaryParamVo.setDealResult("0");//过滤条件可放任意值，只要不为空
			}
			
			configDictionaryParamVo.setTenantId(getLoginTenantId(request));
			List<ConfigDictionary> dealResultList = new ArrayList<ConfigDictionary>();
			try {
				dealResultList = clientConfigDictionaryService.selectListByParamVo(configDictionaryParamVo,this.getCommonParam(request));
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return dealResultList;
	}

}
