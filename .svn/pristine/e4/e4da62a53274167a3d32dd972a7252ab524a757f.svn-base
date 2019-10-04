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
import com.techsoft.client.service.struct.ClientStructWorkshopAreaService;
import com.techsoft.client.service.struct.ClientStructWorkshopService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructWorkshopAreaParamVo;
import com.techsoft.entity.struct.StructWorkshopAreaVo;
import com.techsoft.entity.struct.StructWorkshopParamVo;

@Controller
@RequestMapping("/struct/structWorkshopArea")
public class StructWorkshopAreaController extends BaseController {
	@Autowired
	private ClientStructWorkshopAreaService clientStructWorkshopAreaService;
	
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	
	@Autowired
	private ClientStructWorkshopService clientStructWorkshopService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		try {
			//获取工厂
			List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(new StructFactoryParamVo(), this.getCommonParam(null));
			modelAndView.addObject("factoryList", factoryList);
			//获取车间
			List<StructWorkshop> workshopList = clientStructWorkshopService.selectListByParamVo(new StructWorkshopParamVo(),this.getCommonParam(null));
			modelAndView.addObject("workshopList", workshopList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structWorkshopArea-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("struct/structWorkshopArea-edit");
		StructWorkshopAreaVo entity = new StructWorkshopAreaVo();
		try {
			if (id != null) {
				entity = clientStructWorkshopAreaService.getVoByID(id, this.getCommonParam(request));

				StructWorkshop structWorkshop = clientStructWorkshopService.getVoByID(entity.getWorkshopId(), this.getCommonParam(request));
				modelAndView.addObject("structWorkshop", structWorkshop);
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
			StructWorkshopAreaParamVo structWorkshopAreaParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structWorkshopAreaParamVo==null){
            	structWorkshopAreaParamVo = new StructWorkshopAreaParamVo();
            }
			pageInfo = clientStructWorkshopAreaService.selectPageVoByParamVo(
					structWorkshopAreaParamVo, this.getCommonParam(request),
					pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}

	/**
	 * 根据工厂查车间区域list creater:Wang
	 * 
	 * @param request
	 * @param structProductionlineParamVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/linkWorkshopAreaByFactory")
	public List<StructWorkshopArea> proLineLink(HttpServletRequest request,
			StructWorkshopAreaParamVo structWorkshopAreaParamVo) {
		if (structWorkshopAreaParamVo == null) {
			structWorkshopAreaParamVo = new StructWorkshopAreaParamVo();
		}
		structWorkshopAreaParamVo.setTenantId(getLoginTenantId(request));
		List<StructWorkshopArea> prolineList = new ArrayList<StructWorkshopArea>();
		try {
			prolineList = clientStructWorkshopAreaService.selectListByParamVo(structWorkshopAreaParamVo,
					this.getCommonParam(request));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prolineList;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage save(HttpServletRequest request,
			StructWorkshopAreaParamVo structWorkshopAreaParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    structWorkshopAreaParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructWorkshopAreaService.saveOrUpdate(structWorkshopAreaParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	
	
	@RequestMapping("/structWorkshopAreaOpen")
	public ModelAndView structWorkshopAreaOpen(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structWorkshopArea-Open");
		return modelAndView;
	}


}
