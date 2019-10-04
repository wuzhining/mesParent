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
import com.techsoft.client.service.config.ClientConfigLabelFieldService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ConfigLabelField;
import com.techsoft.entity.common.ConfigLabelFieldItem;
import com.techsoft.entity.config.ConfigLabelFieldItemParamVo;
import com.techsoft.entity.config.ConfigLabelFieldParamVo;
import com.techsoft.entity.config.ConfigLabelFieldVo;

@Controller
@RequestMapping("/config/configLabelField")
public class ConfigLabelFieldController extends BaseController {
	@Autowired
	private ClientConfigLabelFieldService clientConfigLabelFieldService;
	
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try{
			//打印方式
			List<ConfigDictionary> printModeDictList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.CONFIG_BARCODE_PRINT_MODE.getValue());
			modelAndView.addObject("printModeDictList1", printModeDictList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
	}
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("config/configLabelField-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("config/configLabelField-edit");
		ConfigLabelFieldVo entity = new ConfigLabelFieldVo();

		try {
			
			//打印方式
			List<ConfigDictionary> printModeDictList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.CONFIG_BARCODE_PRINT_MODE.getValue());
			modelAndView.addObject("printModeDictList", printModeDictList);
			if (id != null) {
				entity = clientConfigLabelFieldService.getVoByID(id, this.getCommonParam(request));
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
			ConfigLabelFieldParamVo configLabelFieldParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(configLabelFieldParamVo==null){
            	configLabelFieldParamVo = new ConfigLabelFieldParamVo();
            }
			pageInfo = clientConfigLabelFieldService.selectPageVoByParamVo(
					configLabelFieldParamVo, this.getCommonParam(request),
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
			ConfigLabelFieldParamVo configLabelFieldParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    configLabelFieldParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientConfigLabelFieldService.saveOrUpdate(configLabelFieldParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	
	@RequestMapping("/labelFieldAdd")
	public ModelAndView labelFieldAdd(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("config/configLabelField-Add");
		List<ConfigLabelField> entityList =new ArrayList<ConfigLabelField>();
		try {
			entityList = clientConfigLabelFieldService.selectListByParamVo(new ConfigLabelFieldParamVo(), this.getCommonParam(request));
		} catch (Exception e) {                            
			e.printStackTrace();
		}
		modelAndView.addObject(entityList);
		initData(modelAndView);
		return modelAndView;
	}
	

}
