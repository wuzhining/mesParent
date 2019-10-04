package com.techsoft.controller.work;

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
import com.techsoft.common.BusinessException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;
import com.techsoft.client.service.struct.ClientStructProductionlineService;
import com.techsoft.client.service.work.ClientWorkTaskProcedureService;
import com.techsoft.entity.work.WorkTaskProcedureVo;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.struct.StructProductionlineParamVo;
import com.techsoft.entity.work.WorkTaskProcedureParamVo;

@Controller
@RequestMapping("/work/workTaskProcedure")
public class WorkTaskProcedureController extends BaseController {
	@Autowired
	private ClientWorkTaskProcedureService clientWorkTaskProcedureService;
	@Autowired
	private ClientStructProductionlineService clientStructProductionlineService;
	
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
		modelAndView.setViewName("work/workTaskProcedure-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("bill/viewTaskProcedure-edit");
		  modelAndView.setViewName("work/workTaskProcedure-list");
		WorkTaskProcedureVo entity = new WorkTaskProcedureVo();
		List<StructProductionline> productionlineList=new ArrayList<>();
		try {
			if (id != null) {
				StructProductionlineParamVo paramVo=new StructProductionlineParamVo();
				 productionlineList=clientStructProductionlineService.selectListByParamVo(paramVo, this.getCommonParam(request));
				entity = clientWorkTaskProcedureService.getVoByID(id, this.getCommonParam(request));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("entity", entity);
		modelAndView.addObject("productionlineList", productionlineList);
		initData(modelAndView);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			WorkTaskProcedureParamVo workTaskProcedureParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(workTaskProcedureParamVo==null){
            	workTaskProcedureParamVo = new WorkTaskProcedureParamVo();
            }
			pageInfo = clientWorkTaskProcedureService.selectPageVoByParamVo(
					workTaskProcedureParamVo, this.getCommonParam(request),
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
			WorkTaskProcedureParamVo workTaskProcedureParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    workTaskProcedureParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientWorkTaskProcedureService.saveOrUpdate(workTaskProcedureParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
}
