package com.techsoft.controller.struct;

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

import com.techsoft.client.service.struct.ClientStructWarehouseLocationService;
import com.techsoft.entity.struct.StructWarehouseLocationVo;
import com.techsoft.entity.struct.StructWarehouseLocationParamVo;

@Controller
@RequestMapping("/struct/structWarehouseLocation")
public class StructWarehouseLocationController extends BaseController {
	@Autowired
	private ClientStructWarehouseLocationService clientStructWarehouseLocationService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structWarehouseLocation-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("struct/structWarehouseLocation-edit");
		StructWarehouseLocationVo entity = new StructWarehouseLocationVo();
		try {
			if (id != null) {
				entity = clientStructWarehouseLocationService.getVoByID(id, this.getCommonParam(request));
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
			StructWarehouseLocationParamVo structWarehouseLocationParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structWarehouseLocationParamVo==null){
            	structWarehouseLocationParamVo = new StructWarehouseLocationParamVo();
            }
			pageInfo = clientStructWarehouseLocationService.selectPageVoByParamVo(
					structWarehouseLocationParamVo, this.getCommonParam(request),
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
			StructWarehouseLocationParamVo structWarehouseLocationParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    structWarehouseLocationParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructWarehouseLocationService.saveOrUpdate(structWarehouseLocationParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
