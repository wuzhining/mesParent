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
import com.techsoft.client.service.config.ClientConfigLabelFieldItemService;
import com.techsoft.client.service.config.ClientConfigLabelFieldService;
import com.techsoft.client.service.config.ClientConfigLabelFunctionService;
import com.techsoft.client.service.config.ClientConfigSerialNumberService;
import com.techsoft.client.service.config.ClientConfigTableFieldService;
import com.techsoft.client.service.config.ClientConfigTableObjectService;
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
import com.techsoft.entity.common.ConfigLabelFunction;
import com.techsoft.entity.config.ConfigLabelFieldItemParamVo;
import com.techsoft.entity.config.ConfigLabelFieldItemVo;
import com.techsoft.entity.config.ConfigLabelFieldParamVo;
import com.techsoft.entity.config.ConfigLabelFieldVo;
import com.techsoft.entity.config.ConfigLabelFunctionParamVo;

@Controller
@RequestMapping("/config/configLabelFieldItem")
public class ConfigLabelFieldItemController extends BaseController {
	@Autowired
	private ClientConfigLabelFieldItemService clientConfigLabelFieldItemService;
	@Autowired
	private ClientConfigLabelFieldService clientConfigLabelFieldService;
	@Autowired
	private ClientConfigLabelFunctionService clientConfigLabelFunctionService;
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
			List<ConfigDictionary> dictionaryListType = clientConfigDictionaryService.selectListByParentId(EnumDictionary.CONFIG_LABEL_FUNCTION.getValue());
			modelAndView.addObject("dictionaryListType1", dictionaryListType);
			//获取标签字段
			ConfigLabelFunctionParamVo configLabelFunctionParamVo = new ConfigLabelFunctionParamVo();
			List<ConfigLabelFunction> configLabelFunctionL = new ArrayList<ConfigLabelFunction>();
			List<ConfigLabelFunction> configLabelFunctionList = clientConfigLabelFunctionService.selectListByParamVo(configLabelFunctionParamVo, 
					this.getCommonParam(null));
			for (ConfigLabelFunction configLabelFunction : configLabelFunctionList) {
				String tableObjectNameCn = "";
				String tableObjectFieldCn = "";
				String serialId = "";
				String dictName= "";
				if (configLabelFunction.getTableObjectId() != null && configLabelFunction.getTableObjectId()>0L) {
					tableObjectNameCn = clientConfigTableObjectService.selectById(configLabelFunction.getTableObjectId(), null).getTableObjectNameCn()+"-";
				}
				if (configLabelFunction.getTableFieldId() != null && configLabelFunction.getTableFieldId()>0L) {
					tableObjectFieldCn = clientConfigTableFieldService.selectById(configLabelFunction.getTableFieldId(), null).getTableObjectFieldCn();
				}
				if (configLabelFunction.getSerialId() != null && configLabelFunction.getSerialId() > 0L) {
					//serialId = String.valueOf(configLabelFunction.getSerialId());
					serialId=clientConfigSerialNumberService.selectById(configLabelFunction.getSerialId(), null).getSerialName();
				}
				if (configLabelFunction.getLabelFunctionTypeDictId() != null && configLabelFunction.getLabelFunctionTypeDictId()>0L) {
					dictName = clientConfigDictionaryService.selectById(configLabelFunction.getLabelFunctionTypeDictId(), null).getDictName();
				}
				if (configLabelFunction != null) {
					String functionName =new StringBuilder(dictName).append("-")
							.append(tableObjectNameCn)
							.append(tableObjectFieldCn)
							.append(serialId)
							.append(configLabelFunction.getValue()==null?"":configLabelFunction.getValue()).toString();
					configLabelFunction.setValue(functionName);
				}
				configLabelFunctionL.add(configLabelFunction);
			}
			
			modelAndView.addObject("configLabelFunctionList1",configLabelFunctionL);
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
		modelAndView.setViewName("config/configLabelFieldItem-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//获取标签字段
			ConfigLabelFieldParamVo configLabelFieldParamVo = new ConfigLabelFieldParamVo();
			List<ConfigLabelField> configLabelFieldList = clientConfigLabelFieldService.selectListByParamVo(configLabelFieldParamVo, this.getCommonParam(null));
			modelAndView.addObject("configLabelFieldList",configLabelFieldList);
			//获取功能定义
			ConfigLabelFunctionParamVo configLabelFunctionParamVo = new ConfigLabelFunctionParamVo();
			List<ConfigLabelFunction> configLabelFunctionList = clientConfigLabelFunctionService.selectListByParamVo(configLabelFunctionParamVo, 
					this.getCommonParam(null));
			modelAndView.addObject("configLabelFunctionList",configLabelFunctionList);
			
			ConfigLabelFieldItemVo entity = new ConfigLabelFieldItemVo();
			if (id != null) {
				entity = clientConfigLabelFieldItemService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("config/configLabelFieldItem-edit");
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
			ConfigLabelFieldItemParamVo configLabelFieldItemParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(configLabelFieldItemParamVo==null){
            	configLabelFieldItemParamVo = new ConfigLabelFieldItemParamVo();
            }
			pageInfo = clientConfigLabelFieldItemService.selectPageVoByParamVo(
					configLabelFieldItemParamVo, this.getCommonParam(request),
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
			ConfigLabelFieldItemParamVo configLabelFieldItemParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	    configLabelFieldItemParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientConfigLabelFieldItemService.saveOrUpdate(configLabelFieldItemParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	

	@RequestMapping("/details")
	public ModelAndView details(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("config/configLabelField-details");
		//ConfigLabelFieldItemVo entity = new ConfigLabelFieldItemVo();
		List<ConfigLabelFieldItem> entityList =new ArrayList<ConfigLabelFieldItem>();
		try {
			entityList = clientConfigLabelFieldItemService.selectListByParamVo(new ConfigLabelFieldItemParamVo(), this.getCommonParam(request));
		} catch (Exception e) {                            
			e.printStackTrace();
		}
		modelAndView.addObject(entityList);
		initData(modelAndView);
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
			    clientConfigLabelFieldItemService.deleteById(id, this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	
	@RequestMapping("/choiceFunct")
	public ModelAndView choiceFunct(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("config/configLabelField-choiceFunct");
		//ConfigLabelFieldItemVo entity = new ConfigLabelFieldItemVo();
		List<ConfigLabelFieldItem> entityList =new ArrayList<ConfigLabelFieldItem>();
		try {
			entityList = clientConfigLabelFieldItemService.selectListByParamVo(new ConfigLabelFieldItemParamVo(), this.getCommonParam(request));
		} catch (Exception e) {                            
			e.printStackTrace();
		}
		modelAndView.addObject(entityList);
		initData(modelAndView);
		return modelAndView;
	}
	
	


}
