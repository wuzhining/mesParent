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
import com.techsoft.common.enums.EnumLabelFunctionType;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.config.ClientConfigLabelFieldService;
import com.techsoft.client.service.config.ClientConfigLabelFunctionService;
import com.techsoft.client.service.config.ClientConfigSerialNumberService;
import com.techsoft.client.service.config.ClientConfigTableFieldService;
import com.techsoft.client.service.config.ClientConfigTableObjectService;
import com.techsoft.entity.config.ConfigLabelFunctionVo;
import com.techsoft.entity.config.ConfigSerialNumberParamVo;
import com.techsoft.entity.config.ConfigTableFieldParamVo;
import com.techsoft.entity.config.ConfigTableObjectParamVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ConfigLabelField;
import com.techsoft.entity.common.ConfigSerialNumber;
import com.techsoft.entity.common.ConfigTableField;
import com.techsoft.entity.common.ConfigTableObject;
import com.techsoft.entity.config.ConfigLabelFieldParamVo;
import com.techsoft.entity.config.ConfigLabelFunctionParamVo;

@Controller
@RequestMapping("/config/configLabelFunction")
public class ConfigLabelFunctionController extends BaseController {
	@Autowired
	private ClientConfigLabelFunctionService clientConfigLabelFunctionService;
	@Autowired
	private ClientConfigLabelFieldService clientConfigLabelFieldService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientConfigTableObjectService clientConfigTableObjectService;
	@Autowired
	private ClientConfigTableFieldService clientConfigTableFieldService;
	@Autowired
	private ClientConfigSerialNumberService clientConfigSerialNumberService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		try {
			//取功能定义类型集合
			List<ConfigDictionary> dictionaryListType = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.CONFIG_LABEL_FUNCTION.getValue());
			modelAndView.addObject("dictionaryListType1", dictionaryListType);
			//取数据表集合
			ConfigTableObjectParamVo CTOParamVo = new ConfigTableObjectParamVo();
			List<ConfigTableObject> CTOList = clientConfigTableObjectService.selectListByParamVo(CTOParamVo, this.getCommonParam(null));
			modelAndView.addObject("dictionaryListTable1", CTOList);
			//取数据表字段名称集合
			ConfigTableFieldParamVo CTFParamVo = new ConfigTableFieldParamVo();
			List<ConfigTableField> CTFList = clientConfigTableFieldService.selectListByParamVo(CTFParamVo, this.getCommonParam(null));
			modelAndView.addObject("dictionaryListTableField1", CTFList);
			//取序列号名称集合
			ConfigSerialNumberParamVo CTGParamVo = new ConfigSerialNumberParamVo();
			List<ConfigSerialNumber> CTGList = clientConfigSerialNumberService.selectListByParamVo(CTGParamVo, this.getCommonParam(null));
			modelAndView.addObject("dictionaryListSerialNumber1", CTGList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("config/configLabelFunction-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//取功能定义类型集合
			List<ConfigDictionary> dictionaryListType = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.CONFIG_LABEL_FUNCTION.getValue());
			modelAndView.addObject("dictionaryListType", dictionaryListType);
			
			ConfigLabelFunctionVo entity = new ConfigLabelFunctionVo();
			ConfigSerialNumber serialNum = new ConfigSerialNumber();
			ConfigTableObject tableObject = new ConfigTableObject();
			ConfigTableField tableField = new ConfigTableField();
			if (id != null) {
				entity = clientConfigLabelFunctionService.getVoByID(id, this.getCommonParam(request));
				if (entity.getSerialId() != null) {
					serialNum = clientConfigSerialNumberService.getVoByID(entity.getSerialId(), this.getCommonParam(request));
				}
				if (entity.getTableObjectId() != null && entity.getTableObjectId()>0L) {
					tableObject = clientConfigTableObjectService.getVoByID(entity.getTableObjectId(), this.getCommonParam(request));
				}
				if (entity.getTableFieldId() != null && entity.getTableFieldId()>0L) {
					tableField = clientConfigTableFieldService.getVoByID(entity.getTableFieldId(), this.getCommonParam(request));
				}
			}
			modelAndView.addObject("entity", entity);
			modelAndView.addObject("serialNum", serialNum);
			modelAndView.addObject("tableObject", tableObject);
			modelAndView.addObject("tableField", tableField);
			modelAndView.setViewName("config/configLabelFunction-edit");
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
			ConfigLabelFunctionParamVo configLabelFunctionParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(configLabelFunctionParamVo==null){
            	configLabelFunctionParamVo = new ConfigLabelFunctionParamVo();
            }
			pageInfo = clientConfigLabelFunctionService.selectPageVoByParamVo(
					configLabelFunctionParamVo, this.getCommonParam(request),
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
			ConfigLabelFunctionParamVo configLabelFunctionParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    configLabelFunctionParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientConfigLabelFunctionService.saveOrUpdate(configLabelFunctionParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
