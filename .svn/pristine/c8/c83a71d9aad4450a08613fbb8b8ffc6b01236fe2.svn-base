package com.techsoft.controller.history;

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

import com.techsoft.client.service.history.ClientHistoryInventoryLocationService;
import com.techsoft.entity.history.HistoryInventoryLocationVo;
import com.techsoft.entity.history.HistoryInventoryLocationParamVo;

@Controller
@RequestMapping("/history/historyInventoryLocation")
public class HistoryInventoryLocationController extends BaseController {
	@Autowired
	private ClientHistoryInventoryLocationService clientHistoryInventoryLocationService;
	
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
		modelAndView.setViewName("history/historyInventoryLocation-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("history/historyInventoryLocation-edit");
		HistoryInventoryLocationVo entity = new HistoryInventoryLocationVo();
		try {
			if (id != null) {
				entity = clientHistoryInventoryLocationService.getVoByID(id, this.getCommonParam(request));
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
			HistoryInventoryLocationParamVo historyInventoryLocationParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(historyInventoryLocationParamVo==null){
            	historyInventoryLocationParamVo = new HistoryInventoryLocationParamVo();
            }
			pageInfo = clientHistoryInventoryLocationService.selectPageVoByParamVo(
					historyInventoryLocationParamVo, this.getCommonParam(request),
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
			HistoryInventoryLocationParamVo historyInventoryLocationParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    historyInventoryLocationParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientHistoryInventoryLocationService.saveOrUpdate(historyInventoryLocationParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
