package com.techsoft.controller.scada;

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

import com.techsoft.client.service.scada.ClientScadaAoiService;
import com.techsoft.entity.scada.ScadaAoiVo;
import com.techsoft.entity.scada.ScadaAoiParamVo;

@Controller
@RequestMapping("/scada/scadaAoi")
public class ScadaAoiController extends BaseController {
	@Autowired
	private ClientScadaAoiService clientScadaAoiService;
	
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
		modelAndView.setViewName("scada/scadaAoi-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scada/scadaAoi-edit");
		ScadaAoiVo entity = new ScadaAoiVo();
		try {
			if (id != null) {
				entity = clientScadaAoiService.getVoByID(id, this.getCommonParam(request));
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
			ScadaAoiParamVo scadaAoiParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(scadaAoiParamVo==null){
            	scadaAoiParamVo = new ScadaAoiParamVo();
            }
			pageInfo = clientScadaAoiService.selectPageVoByParamVo(
					scadaAoiParamVo, this.getCommonParam(request),
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
			ScadaAoiParamVo scadaAoiParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    scadaAoiParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientScadaAoiService.saveOrUpdate(scadaAoiParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
