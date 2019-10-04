package com.techsoft.controller.struct;

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
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.client.service.struct.ClientStructProcedureService;
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
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructFloor;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructFloorParamVo;
import com.techsoft.entity.struct.StructProcedureParamVo;
import com.techsoft.entity.struct.StructProcedureVo;

@Controller
@RequestMapping("/struct/structProcedure")
public class StructProcedureController extends BaseController {
	@Autowired
	private ClientStructProcedureService clientStructProcedureService;
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;

	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//取工作组集合
			List<ConfigDictionary> workgroupDictList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.STRUCT_WORKGROUP.getValue());
					modelAndView.addObject("workgroupDictList", workgroupDictList);
			//取制程集合
			List<ConfigDictionary> processDictList = clientConfigDictionaryService
							.selectListByParentId(EnumDictionary.STRUCT_PROCESS.getValue());
			        modelAndView.addObject("processDictList", processDictList);
			//取工厂集合
			StructFactoryParamVo paramVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(paramVo,
					this.getCommonParam(null));
			  modelAndView.addObject("factoryList", factoryList);
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
		modelAndView.setViewName("struct/structProcedure-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
		StructFactoryParamVo paramVo = new StructFactoryParamVo();
		List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(paramVo,
				this.getCommonParam(request));
		modelAndView.addObject("factoryList", factoryList);
		List<ConfigDictionary> processDicList = clientConfigDictionaryService
				.selectListByParentId(EnumDictionary.STRUCT_PROCESS.getValue());
		List<ConfigDictionary> workgroupDicList = clientConfigDictionaryService
				.selectListByParentId(EnumDictionary.STRUCT_WORKGROUP.getValue());
		modelAndView.addObject("processDicList", processDicList);
		modelAndView.addObject("workgroupDicList", workgroupDicList);
		modelAndView.setViewName("struct/structProcedure-edit");
		StructProcedureVo entity = new StructProcedureVo();
		
			if (id != null) {
				entity = clientStructProcedureService.getVoByID(id, this.getCommonParam(request));
			}
		modelAndView.addObject("entity", entity);
		initData(modelAndView);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			StructProcedureParamVo structProcedureParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(structProcedureParamVo==null){
            	structProcedureParamVo = new StructProcedureParamVo();
            }
			pageInfo = clientStructProcedureService.selectPageVoByParamVo(
					structProcedureParamVo, this.getCommonParam(request),
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
			StructProcedureParamVo structProcedureParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    structProcedureParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructProcedureService.saveOrUpdate(structProcedureParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
