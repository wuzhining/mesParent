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

import com.techsoft.common.BusinessException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.client.service.struct.ClientStructProcessService;
import com.techsoft.entity.struct.StructProcessVo;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructProcessParamVo;

@Controller
@RequestMapping("/struct/structProcess")
public class StructProcessController extends BaseController {
	@Autowired
	private ClientStructProcessService clientStructProcessService;
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		StructFactoryParamVo paramVo = new StructFactoryParamVo();
		try {
			List<StructFactory> factoryList;
			factoryList = clientStructFactoryService.selectListByParamVo(paramVo, null);
			modelAndView.addObject("factoryList", factoryList);
			modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
			modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structProcess-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("struct/structProcess-edit");
		StructProcessVo entity = new StructProcessVo();
		try {
			StructFactoryParamVo paramVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(paramVo,
					this.getCommonParam(request));
			modelAndView.addObject("factoryList", factoryList);
			
			if (id != null) {
				entity = clientStructProcessService.getVoByID(id, this.getCommonParam(request));
				StructFactory structFactory = clientStructFactoryService.getVoByID(entity.getFactoryId(), this.getCommonParam(request));
				modelAndView.addObject("structFactory", structFactory);
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
			StructProcessParamVo structProcessParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structProcessParamVo==null){
            	structProcessParamVo = new StructProcessParamVo();
            }
			pageInfo = clientStructProcessService.selectPageVoByParamVo(
					structProcessParamVo, this.getCommonParam(request),
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
			StructProcessParamVo structProcessParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    structProcessParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructProcessService.saveOrUpdate(structProcessParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

	
	@RequestMapping("/listProcess")
	public ModelAndView lineProcess(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structProductionline-openPro");
		return modelAndView;
	}

}
