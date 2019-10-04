package com.techsoft.controller.firm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.firm.ClientFirmSchedulingService;
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.firm.FirmSchedulingParamVo;
import com.techsoft.entity.firm.FirmSchedulingVo;
import com.techsoft.entity.struct.StructFactoryParamVo;

@Controller
@RequestMapping("/firm/firmScheduling")
public class FirmSchedulingController extends BaseController {
	@Autowired
	private ClientFirmSchedulingService clientFirmSchedulingService;
	
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//取工厂集合
			StructFactoryParamVo ParamVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(ParamVo,this.getCommonParam(null));
			modelAndView.addObject("factoryList", factoryList); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("firm/firmScheduling-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			FirmSchedulingVo entity = new FirmSchedulingVo();
			if (id != null) {
				entity = clientFirmSchedulingService.getVoByID(id, this.getCommonParam(request));
				StructFactory structFactory = clientStructFactoryService.getVoByID(entity.getFactoryId(), this.getCommonParam(request));
				modelAndView.addObject("structFactory", structFactory);
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("firm/firmScheduling-edit");
			initData(modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			FirmSchedulingParamVo firmSchedulingParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(firmSchedulingParamVo==null){
            	firmSchedulingParamVo = new FirmSchedulingParamVo();
            }
			pageInfo = clientFirmSchedulingService.selectPageVoByParamVo(
					firmSchedulingParamVo, this.getCommonParam(request),
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
			FirmSchedulingParamVo firmSchedulingParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    firmSchedulingParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientFirmSchedulingService.saveOrUpdate(firmSchedulingParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
