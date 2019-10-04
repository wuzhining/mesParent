package com.techsoft.controller.struct;

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
import com.techsoft.common.BusinessException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.client.service.struct.ClientStructProcessNodeService;
import com.techsoft.client.service.struct.ClientStructProcessService;
import com.techsoft.entity.struct.StructProcessNodeVo;
import com.techsoft.entity.struct.StructProcessParamVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructProcessNodeParamVo;

@Controller
@RequestMapping("/struct/structProcessNode")
public class StructProcessNodeController extends BaseController {
	@Autowired
	private ClientStructProcessNodeService clientStructProcessNodeService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	@Autowired
	private ClientStructProcessService clientstructProcessService;
	
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		StructFactoryParamVo paramVo = new StructFactoryParamVo();
		StructProcessParamVo param = new StructProcessParamVo();
		List<StructFactory> factoryList;
		
		List<StructProcess> ProcessList;
		try {
			factoryList = clientStructFactoryService.selectListByParamVo(paramVo, null);
			modelAndView.addObject("factoryList", factoryList);
			ProcessList= clientstructProcessService.selectListByParamVo(param,null);
			modelAndView.addObject("ProcessList", ProcessList);
			modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structProcessNode-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("struct/structProcessNode-edit");
		StructProcessNodeVo entity = new StructProcessNodeVo();
		try {
			StructFactoryParamVo paramVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(paramVo,
					this.getCommonParam(request));
			modelAndView.addObject("factoryList", factoryList);
			List<ConfigDictionary> executiveDicList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.PROCESS_EXECUTIVE_TYPE.getValue());
			modelAndView.addObject("executiveDicList", executiveDicList);
			StructProcessParamVo processParamVo = new StructProcessParamVo();
			List<StructProcess> ProcessList = clientstructProcessService.selectListByParamVo(processParamVo,
					this.getCommonParam(request));
			modelAndView.addObject("ProcessList", ProcessList);
			if (id != null) {
				entity = clientStructProcessNodeService.getVoByID(id, this.getCommonParam(request));
				StructFactory structFactory = clientStructFactoryService.getVoByID(entity.getFactoryId(), this.getCommonParam(request));
				modelAndView.addObject("structFactory", structFactory);
				StructProcess structProcess = clientstructProcessService.getVoByID(entity.getProcessId(), this.getCommonParam(request));
				modelAndView.addObject("structProcess", structProcess);
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
			StructProcessNodeParamVo structProcessNodeParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structProcessNodeParamVo==null){
            	structProcessNodeParamVo = new StructProcessNodeParamVo();
            }
			pageInfo = clientStructProcessNodeService.selectPageVoByParamVo(
					structProcessNodeParamVo, this.getCommonParam(request),
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
			StructProcessNodeParamVo structProcessNodeParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	    structProcessNodeParamVo.setModifyUserId(getLoginUserId(request));
	    structProcessNodeParamVo.setNodeName(structProcessNodeParamVo.getNodeNames());
		resultMessage = clientStructProcessNodeService.saveOrUpdate(structProcessNodeParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

	@RequestMapping("/listNode")
	public ModelAndView listNode(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("equip/equipWorkNodes");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/listNodes")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listNodes(HttpServletRequest request,
			StructProcessNodeParamVo structProcessNodeParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		System.out.println(EnumDictionary.PROCESS_EXECUTIVE_TYPE.getValue());
		List<ConfigDictionary> dictionaryList = new ArrayList<>();
		try {
			dictionaryList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.PROCESS_EXECUTIVE_TYPE.getValue());
		} catch (BusinessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Long dictCode = null;
		for (int i = 0; i < dictionaryList.size(); i++) {
			if(dictionaryList.get(i).getDictName().equals("设备自动")){
				dictCode = dictionaryList.get(i).getId();
			}
		}
		structProcessNodeParamVo.setExecutiveTypeDictId(dictCode);
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
			pageInfo = clientStructProcessNodeService.selectPageVoByParamVo(
					structProcessNodeParamVo, this.getCommonParam(request),
					pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}
	
	
	@RequestMapping("/listProcessNode")
	public ModelAndView lineProcess(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structProcedureInstruct-node");
		return modelAndView;
	}
	
}
