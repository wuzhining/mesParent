package com.techsoft.controller.struct;

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
import com.techsoft.client.service.struct.ClientStructProcedureWorkstationService;
import com.techsoft.client.service.struct.ClientStructWorkstationService;
import com.techsoft.entity.struct.StructProcedureWorkstationVo;
import com.techsoft.entity.struct.StructWorkstationParamVo;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.struct.StructProcedureWorkstationParamVo;

@Controller
@RequestMapping("/struct/structProcedureWorkstation")
public class StructProcedureWorkstationController extends BaseController {
	@Autowired
	private ClientStructProcedureWorkstationService clientStructProcedureWorkstationService;
	@Autowired
	private ClientStructWorkstationService clientStructWorkstationService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		StructWorkstationParamVo param = new StructWorkstationParamVo();
		List<StructWorkstation> workstationList;
		try {
			workstationList = clientStructWorkstationService.selectListByParamVo(param, null);
			modelAndView.addObject("workstationList", workstationList);
			modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structProcedureWorkstation-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("struct/structProcedureWorkstation-edit");
		StructProcedureWorkstationVo entity = new StructProcedureWorkstationVo();
		try {
			if (id != null) {
				entity = clientStructProcedureWorkstationService.getVoByID(id, this.getCommonParam(request));
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
			StructProcedureWorkstationParamVo structProcedureWorkstationParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structProcedureWorkstationParamVo==null){
            	structProcedureWorkstationParamVo = new StructProcedureWorkstationParamVo();
            }
            structProcedureWorkstationParamVo.setTenantId(getLoginTenantId(request));
			pageInfo = clientStructProcedureWorkstationService.selectPageVoByParamVo(
					structProcedureWorkstationParamVo, this.getCommonParam(request),
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
			StructProcedureWorkstationParamVo structProcedureWorkstationParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    structProcedureWorkstationParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructProcedureWorkstationService.saveOrUpdate(structProcedureWorkstationParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
				clientStructProcedureWorkstationService.deleteById(id, this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
}
