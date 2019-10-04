package com.techsoft.controller.equip;

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
import com.techsoft.client.service.equip.ClientEquipFixtureService;
import com.techsoft.client.service.equip.ClientEquipFixtureStackService;
import com.techsoft.entity.equip.EquipFixtureStackVo;
import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.equip.EquipFixtureParamVo;
import com.techsoft.entity.equip.EquipFixtureStackParamVo;

@Controller
@RequestMapping("/equip/equipFixtureStack")
public class EquipFixtureStackController extends BaseController {
	@Autowired
	private ClientEquipFixtureStackService clientEquipFixtureStackService;
	@Autowired
	private ClientEquipFixtureService clientEquipFixtureService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			EquipFixtureParamVo equipFixtureParamVo = new EquipFixtureParamVo();
			List<EquipFixture> equipFixtureList = clientEquipFixtureService.selectListByParamVo(equipFixtureParamVo, this.getCommonParam(null));
			modelAndView.addObject("equipFixtureList",equipFixtureList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("equip/equipFixtureStack-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("equip/equipFixtureStack-edit");
		EquipFixtureStackVo entity = new EquipFixtureStackVo();
		try {
			if (id != null) {
				entity = clientEquipFixtureStackService.getVoByID(id, this.getCommonParam(request));
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
			EquipFixtureStackParamVo equipFixtureStackParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(equipFixtureStackParamVo==null){
            	equipFixtureStackParamVo = new EquipFixtureStackParamVo();
            }
			pageInfo = clientEquipFixtureStackService.selectPageVoByParamVo(
					equipFixtureStackParamVo, this.getCommonParam(request),
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
			EquipFixtureStackParamVo equipFixtureStackParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    equipFixtureStackParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientEquipFixtureStackService.saveOrUpdate(equipFixtureStackParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
