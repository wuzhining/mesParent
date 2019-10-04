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

import com.techsoft.client.service.struct.ClientStructProdlineEquipFixtureService;
import com.techsoft.entity.struct.StructProdlineEquipFixtureVo;
import com.techsoft.entity.struct.StructProdlineEquipFixtureParamVo;

@Controller
@RequestMapping("/struct/structProdlineEquipFixture")
public class StructProdlineEquipFixtureController extends BaseController {
	@Autowired
	private ClientStructProdlineEquipFixtureService clientStructProdlineEquipFixtureService;
	
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
		modelAndView.setViewName("struct/structProdlineEquipFixture-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("struct/structProdlineEquipFixture-edit");
		StructProdlineEquipFixtureVo entity = new StructProdlineEquipFixtureVo();
		try {
			if (id != null) {
				entity = clientStructProdlineEquipFixtureService.getVoByID(id, this.getCommonParam(request));
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
			StructProdlineEquipFixtureParamVo structProdlineEquipFixtureParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structProdlineEquipFixtureParamVo==null){
            	structProdlineEquipFixtureParamVo = new StructProdlineEquipFixtureParamVo();
            }
			pageInfo = clientStructProdlineEquipFixtureService.selectPageVoByParamVo(
					structProdlineEquipFixtureParamVo, this.getCommonParam(request),
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
			StructProdlineEquipFixtureParamVo structProdlineEquipFixtureParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    structProdlineEquipFixtureParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructProdlineEquipFixtureService.saveOrUpdate(structProdlineEquipFixtureParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

	@RequestMapping("/searchListEquipFixture")
	public ModelAndView searchListEquipFixture(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structLineEquipFixture");
		return modelAndView;
	}
	
	@RequestMapping("/addEquipFixture")
	public ModelAndView addEquipFixture(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structLineEquipFixture-equipFixtureAdd");
		return modelAndView;
	}
	
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
				clientStructProdlineEquipFixtureService.deleteById(id, this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

}
