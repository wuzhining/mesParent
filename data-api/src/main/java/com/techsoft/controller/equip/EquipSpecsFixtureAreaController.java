package com.techsoft.controller.equip;

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

import com.techsoft.client.service.equip.ClientEquipSpecsFixtureAreaService;
import com.techsoft.entity.equip.EquipSpecsFixtureAreaVo;
import com.techsoft.entity.equip.EquipSpecsFixtureAreaParamVo;

@Controller
@RequestMapping("/equip/equipSpecsFixtureArea")
public class EquipSpecsFixtureAreaController extends BaseController {
	@Autowired
	private ClientEquipSpecsFixtureAreaService clientEquipSpecsFixtureAreaService;
	
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
		modelAndView.setViewName("equip/equipSpecsFixtureArea-list");
		return modelAndView;
	}
	
	@RequestMapping("/equipSpecsFixtureAreaOpen")
	public ModelAndView openWinProduct(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("equip/equipSpecsFixtureAreaOpen");
		return modelAndView;
	}
	
	
	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("equip/equipSpecsFixtureArea-edit");
		EquipSpecsFixtureAreaVo entity = new EquipSpecsFixtureAreaVo();
		try {
			if (id != null) {
				entity = clientEquipSpecsFixtureAreaService.getVoByID(id, this.getCommonParam(request));
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
			EquipSpecsFixtureAreaParamVo equipSpecsFixtureAreaParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(equipSpecsFixtureAreaParamVo==null){
            	equipSpecsFixtureAreaParamVo = new EquipSpecsFixtureAreaParamVo();
            }
			pageInfo = clientEquipSpecsFixtureAreaService.selectPageVoByParamVo(
					equipSpecsFixtureAreaParamVo, this.getCommonParam(request),
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
			EquipSpecsFixtureAreaParamVo equipSpecsFixtureAreaParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    equipSpecsFixtureAreaParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientEquipSpecsFixtureAreaService.saveOrUpdate(equipSpecsFixtureAreaParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
				clientEquipSpecsFixtureAreaService.deleteById(id, this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
}
