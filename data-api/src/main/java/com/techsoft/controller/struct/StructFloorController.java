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
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructFloorParamVo;
import com.techsoft.entity.struct.StructFloorVo;

@Controller
@RequestMapping("/struct/structFloor")
public class StructFloorController extends BaseController {
	@Autowired
	private ClientStructFloorService clientStructFloorService;
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;

	/**
	 * 页面关联数据初始化
	 * 
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
		modelAndView.setViewName("struct/structFloor-list");
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			StructFloorVo entity = new StructFloorVo();
			if (id != null) {
				entity = clientStructFloorService.getVoByID(id, this.getCommonParam(request));
				StructFactory structFactory = clientStructFactoryService.getVoByID(entity.getFactoryId(), this.getCommonParam(request));
				modelAndView.addObject("structFactory", structFactory);
			}
			modelAndView.setViewName("struct/structFloor-edit");
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
	public ReturnPageInfo listJson(HttpServletRequest request, StructFloorParamVo structFloorParamVo,
			Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
			if (structFloorParamVo == null) {
				structFloorParamVo = new StructFloorParamVo();
			}
			pageInfo = clientStructFloorService.selectPageVoByParamVo(structFloorParamVo, this.getCommonParam(request),
					pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}

	/**
	 * 根据工厂查楼层list creater:Wang
	 * 
	 * @param request
	 * @param structFloorParamVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/linkFloorByFactory")
	public List<StructFloor> floorLink(HttpServletRequest request, StructFloorParamVo structFloorParamVo) {
		if (structFloorParamVo == null) {
			structFloorParamVo = new StructFloorParamVo();
		}
		structFloorParamVo.setTenantId(getLoginTenantId(request));
		List<StructFloor> floorList = new ArrayList<StructFloor>();
		try {
			floorList = clientStructFloorService.selectListByParamVo(structFloorParamVo, this.getCommonParam(request));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return floorList;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage save(HttpServletRequest request, StructFloorParamVo structFloorParamVo) {
		ResultMessage resultMessage = new ResultMessage();

		structFloorParamVo.setModifyUserId(getLoginUserId(request));
		resultMessage = clientStructFloorService.saveOrUpdate(structFloorParamVo, this.getCommonParam(request));

		return resultMessage;
	}
	
	
	@RequestMapping("/structFloorOpen")
	public ModelAndView structFloorOpen(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structFloor-Open");
		return modelAndView;
	}
}
