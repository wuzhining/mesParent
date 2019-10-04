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
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.client.service.struct.ClientStructFloorService;
import com.techsoft.client.service.struct.ClientStructWorkshopService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructFloor;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructFloorParamVo;
import com.techsoft.entity.struct.StructWorkshopParamVo;
import com.techsoft.entity.struct.StructWorkshopVo;

@Controller
@RequestMapping("/struct/structWorkshop")
public class StructWorkshopController extends BaseController {
	@Autowired
	private ClientStructWorkshopService clientStructWorkshopService;
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	@Autowired
	private ClientStructFloorService clientStructFloorService;
	/**
	 * 页面关联数据初始化
	 * 
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		StructFactoryParamVo factoryParamVo = new StructFactoryParamVo();
		List<StructFactory> factoryList;
		try {
			factoryList = clientStructFactoryService.selectListByParamVo(factoryParamVo, this.getCommonParam(null));
			modelAndView.addObject("factoryList", factoryList);
			//取楼层集合
			StructFloorParamVo floorparamVo = new StructFloorParamVo();
			List<StructFloor> floorList = clientStructFloorService.selectListByParamVo(floorparamVo,this.getCommonParam(null));
			modelAndView.addObject("floorList", floorList);	
			modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
			modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structWorkshop-list");
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("struct/structWorkshop-edit");
			StructWorkshopVo entity = new StructWorkshopVo();
			if (id != null) {
				entity = clientStructWorkshopService.getVoByID(id, this.getCommonParam(request));
				//取楼层集合
				StructFloor structFloor = clientStructFloorService.getVoByID(entity.getFloorId(),this.getCommonParam(null));
				modelAndView.addObject("structFloor", structFloor);
				//取工厂层集合
				StructFactory structFactory = clientStructFactoryService.getVoByID(entity.getFactoryId(),this.getCommonParam(null));
				modelAndView.addObject("structFactory", structFactory);
				
			}
			modelAndView.addObject("entity", entity);
			initData(modelAndView);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")
	public ReturnPageInfo listJson(HttpServletRequest request, StructWorkshopParamVo structWorkshopParamVo,
			Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
			if (structWorkshopParamVo == null) {
				structWorkshopParamVo = new StructWorkshopParamVo();
			}
			pageInfo = clientStructWorkshopService.selectPageVoByParamVo(structWorkshopParamVo,
					this.getCommonParam(request), pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}

	/**
	 * 根据工厂查车间list creater:Wang
	 * 
	 * @param request
	 * @param structFloorParamVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/linkWorkshopByFactory")
	public List<StructWorkshop> floorLink(HttpServletRequest request, StructWorkshopParamVo structWorkshopParamVo) {
		if (structWorkshopParamVo == null) {
			structWorkshopParamVo = new StructWorkshopParamVo();
		}
		structWorkshopParamVo.setTenantId(getLoginTenantId(request));
		List<StructWorkshop> WorkshopList = new ArrayList<StructWorkshop>();
		try {
			WorkshopList = clientStructWorkshopService.selectListByParamVo(structWorkshopParamVo,
					this.getCommonParam(request));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return WorkshopList;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage save(HttpServletRequest request, StructWorkshopParamVo structWorkshopParamVo) {
		ResultMessage resultMessage = new ResultMessage();

		structWorkshopParamVo.setModifyUserId(getLoginUserId(request));
		resultMessage = clientStructWorkshopService.saveOrUpdate(structWorkshopParamVo, this.getCommonParam(request));

		return resultMessage;
	}
	
	@RequestMapping("/structWorkshopOpen")
	public ModelAndView structWorkshopOpen(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structWorkshop-Open");
		return modelAndView;
	}
}
