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
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;

import com.techsoft.client.service.struct.ClientStructProdlineEquipService;
import com.techsoft.entity.struct.StructProdlineEquipVo;
import com.techsoft.entity.struct.StructProdlineEquipParamVo;

@Controller
@RequestMapping("/struct/structProdlineEquip")
public class StructProdlineEquipController extends BaseController {
	@Autowired
	private ClientStructProdlineEquipService clientStructProdlineEquipService;
	
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
		initData(modelAndView);
		modelAndView.setViewName("struct/structProdlineEquip-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("struct/structProdlineEquip-edit");
		StructProdlineEquipVo entity = new StructProdlineEquipVo();
		try {
			if (id != null) {
				entity = clientStructProdlineEquipService.getVoByID(id, this.getCommonParam(request));
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
			StructProdlineEquipParamVo structProdlineEquipParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structProdlineEquipParamVo==null){
            	structProdlineEquipParamVo = new StructProdlineEquipParamVo();
            }
            structProdlineEquipParamVo.setTenantId(getLoginTenantId(request));
			pageInfo = clientStructProdlineEquipService.selectPageVoByParamVo(
					structProdlineEquipParamVo, this.getCommonParam(request),
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
			StructProdlineEquipParamVo structProdlineEquipParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    structProdlineEquipParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructProdlineEquipService.saveOrUpdate(structProdlineEquipParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

	@RequestMapping("/searchListEquip")
	public ModelAndView searchListEquip(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structLineEquip");
		return modelAndView;
	}
	
	@RequestMapping("/addEquip")
	public ModelAndView addEquip(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structLineEquip-equipAdd");
		return modelAndView;
	}
	
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
				clientStructProdlineEquipService.deleteById(id, this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
}
