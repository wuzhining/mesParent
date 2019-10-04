package com.techsoft.controller.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.config.ClientConfigTableFieldService;
import com.techsoft.client.service.config.ClientConfigTableObjectService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigTableObject;
import com.techsoft.entity.config.ConfigTableFieldParamVo;
import com.techsoft.entity.config.ConfigTableFieldVo;
import com.techsoft.entity.config.ConfigTableObjectParamVo;

@Controller
@RequestMapping("/config/configTableField")
public class ConfigTableFieldController extends BaseController {
	@Autowired
	private ClientConfigTableFieldService clientConfigTableFieldService;
	@Autowired
	private ClientConfigTableObjectService clientConfigTableObjectService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//取数据表对象集合
			ConfigTableObjectParamVo CTOVo = new ConfigTableObjectParamVo();
			List<ConfigTableObject> CTOList = clientConfigTableObjectService.selectListByParamVo(CTOVo, this.getCommonParam(null));
			modelAndView.addObject("CTOList1", CTOList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("config/configTableField-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//取数据表对象集合
			ConfigTableObjectParamVo CTOVo = new ConfigTableObjectParamVo();
			List<ConfigTableObject> CTOList = clientConfigTableObjectService.selectListByParamVo(CTOVo, this.getCommonParam(null));
			modelAndView.addObject("CTOList", CTOList);
			
			ConfigTableFieldVo entity = new ConfigTableFieldVo();
			if (id != null) {
				entity = clientConfigTableFieldService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("config/configTableField-edit");
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
			ConfigTableFieldParamVo configTableFieldParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(configTableFieldParamVo==null){
            	configTableFieldParamVo = new ConfigTableFieldParamVo();
            }
			pageInfo = clientConfigTableFieldService.selectPageVoByParamVo(
					configTableFieldParamVo, this.getCommonParam(request),
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
			ConfigTableFieldParamVo configTableFieldParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    configTableFieldParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientConfigTableFieldService.saveOrUpdate(configTableFieldParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
