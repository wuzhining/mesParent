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
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.config.ClientConfigLabelService;
import com.techsoft.entity.config.ConfigLabelVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.config.ConfigLabelParamVo;

@Controller
@RequestMapping("/config/configLabel")
public class ConfigLabelController extends BaseController {
	@Autowired
	private ClientConfigLabelService clientConfigLabelService;
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
			//条码规则类型
			List<ConfigDictionary> barcodeRuleDictList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.CONFIG_BARCODE_RULE.getValue());
			modelAndView.addObject("barcodeRuleDictList1", barcodeRuleDictList);
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
		modelAndView.setViewName("config/configLabel-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("config/configLabel-edit");
		ConfigLabelVo entity = new ConfigLabelVo();
		try {
			//打印方式
			List<ConfigDictionary> printModeDictList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.CONFIG_BARCODE_PRINT_MODE.getValue());
			modelAndView.addObject("printModeDictList", printModeDictList);
			
			//条码规则类型
			List<ConfigDictionary> barcodeRuleDictList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.CONFIG_BARCODE_RULE.getValue());
			modelAndView.addObject("barcodeRuleDictList", barcodeRuleDictList);
			if (id != null) {
				entity = clientConfigLabelService.getVoByID(id, this.getCommonParam(request));
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
			ConfigLabelParamVo configLabelParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(configLabelParamVo==null){
            	configLabelParamVo = new ConfigLabelParamVo();
            }
			pageInfo = clientConfigLabelService.selectPageVoByParamVo(
					configLabelParamVo, this.getCommonParam(request),
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
			ConfigLabelParamVo configLabelParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    configLabelParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientConfigLabelService.saveOrUpdate(configLabelParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
