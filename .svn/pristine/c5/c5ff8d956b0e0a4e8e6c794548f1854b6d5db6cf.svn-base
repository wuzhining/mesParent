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
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.client.service.struct.ClientStructProcessProductService;
import com.techsoft.client.service.struct.ClientStructProcessService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructProcessParamVo;
import com.techsoft.entity.struct.StructProcessProductParamVo;
import com.techsoft.entity.struct.StructProcessProductVo;

@Controller
@RequestMapping("/struct/structProcessProduct")
public class StructProcessProductController extends BaseController {
	@Autowired
	private ClientStructProcessProductService clientStructProcessProductService;
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	@Autowired
	private ClientStructProcessService clientstructProcessService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		StructFactoryParamVo paramVo = new StructFactoryParamVo();
		StructProcessParamVo param = new StructProcessParamVo();
		List<StructFactory> factoryList;
		List<StructProcess> ProcessList;
		try {
			factoryList = clientStructFactoryService.selectListByParamVo(paramVo, null);
			modelAndView.addObject("factoryList", factoryList);
			ProcessList= clientstructProcessService.selectListByParamVo(param,null);
			modelAndView.addObject("ProcessList", ProcessList);
			initData(modelAndView);
			modelAndView.setViewName("struct/structProcessProduct-list");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	
	@RequestMapping("/viewProcess")
	public ModelAndView viewProcess(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		StructFactoryParamVo paramVo = new StructFactoryParamVo();
		StructProcessParamVo param = new StructProcessParamVo();
		List<StructFactory> factoryList;
		List<StructProcess> ProcessList;
		try {
			factoryList = clientStructFactoryService.selectListByParamVo(paramVo, null);
			modelAndView.addObject("factoryList", factoryList);
			ProcessList= clientstructProcessService.selectListByParamVo(param,null);
			modelAndView.addObject("ProcessList", ProcessList);
			initData(modelAndView);
			modelAndView.setViewName("struct/structProcessProductView");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping("/addProcess")
	public ModelAndView addProcess(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		StructFactoryParamVo paramVo = new StructFactoryParamVo();
		StructProcessParamVo param = new StructProcessParamVo();
		List<StructFactory> factoryList;
		List<StructProcess> ProcessList;
		try {
			factoryList = clientStructFactoryService.selectListByParamVo(paramVo, null);
			modelAndView.addObject("factoryList", factoryList);
			ProcessList= clientstructProcessService.selectListByParamVo(param,null);
			modelAndView.addObject("ProcessList", ProcessList);
			initData(modelAndView);
			modelAndView.setViewName("struct/structProcessProductAdd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("struct/structProcessProduct-edit");
		StructProcessProductVo entity = new StructProcessProductVo();
		try {
			
			StructFactoryParamVo paramVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(paramVo,
					this.getCommonParam(request));
			modelAndView.addObject("factoryList", factoryList);
			StructProcessParamVo processParamVo = new StructProcessParamVo();
			List<StructProcess> ProcessList = clientstructProcessService.selectListByParamVo(processParamVo,
					this.getCommonParam(request));
			modelAndView.addObject("ProcessList", ProcessList);
			if (id != null) {
				entity = clientStructProcessProductService.getVoByID(id, this.getCommonParam(request));
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
			StructProcessProductParamVo structProcessProductParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structProcessProductParamVo==null){
            	structProcessProductParamVo = new StructProcessProductParamVo();
            }
			pageInfo = clientStructProcessProductService.selectPageVoByParamVo(
					structProcessProductParamVo, this.getCommonParam(request),
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
			StructProcessProductParamVo structProcessProductParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    structProcessProductParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructProcessProductService.saveOrUpdate(structProcessProductParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
