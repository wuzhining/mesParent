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
import com.techsoft.client.service.config.ClientConfigSerialNumberService;
import com.techsoft.client.service.config.ClientConfigTableObjectService;
import com.techsoft.entity.config.ConfigSerialNumberVo;
import com.techsoft.entity.config.ConfigTableObjectParamVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ConfigTableObject;
import com.techsoft.entity.config.ConfigSerialNumberParamVo;

@Controller
@RequestMapping("/config/configSerialNumber")
public class ConfigSerialNumberController extends BaseController {
	@Autowired
	private ClientConfigSerialNumberService clientConfigSerialNumberService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientConfigTableObjectService clientConfigTableObjectService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//获取数据表集合
			ConfigTableObjectParamVo  tableObjectVo = new ConfigTableObjectParamVo();
			List<ConfigTableObject> tableObjectList = clientConfigTableObjectService.selectListByParamVo(tableObjectVo, null);
			modelAndView.addObject("tableObjectList", tableObjectList);
			//获取复位集合
			List<ConfigDictionary> resetmodeList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.CONFIG_BARCODE_RESETMODE.getValue());
			modelAndView.addObject("resetmodeList", resetmodeList);
			
		} catch (Exception e) {
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
		modelAndView.setViewName("config/configSerialNumber-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//取数据表集合
			ConfigTableObjectParamVo tableObjectVo = new ConfigTableObjectParamVo();
			List<ConfigTableObject> tableObjectList = clientConfigTableObjectService.selectListByParamVo(tableObjectVo, null);
			modelAndView.addObject("tableObjectList", tableObjectList);
			//获取复位集合
			List<ConfigDictionary> resetmodeList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.CONFIG_BARCODE_RESETMODE.getValue());
			modelAndView.addObject("resetmodeList", resetmodeList);
		ConfigSerialNumberVo entity = new ConfigSerialNumberVo();
		if (id != null) {
			entity = clientConfigSerialNumberService.getVoByID(id, this.getCommonParam(request));
		}
		modelAndView.addObject("entity", entity);
		modelAndView.setViewName("config/configSerialNumber-edit");
		initData(modelAndView);
		} catch (BusinessException e) {
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			ConfigSerialNumberParamVo configSerialNumberParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(configSerialNumberParamVo==null){
            	configSerialNumberParamVo = new ConfigSerialNumberParamVo();
            }
			pageInfo = clientConfigSerialNumberService.selectPageVoByParamVo(
					configSerialNumberParamVo, this.getCommonParam(request),
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
			ConfigSerialNumberParamVo configSerialNumberParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    configSerialNumberParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientConfigSerialNumberService.saveOrUpdate(configSerialNumberParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
