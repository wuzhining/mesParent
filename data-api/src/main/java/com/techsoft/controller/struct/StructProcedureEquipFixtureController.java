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
import com.techsoft.client.service.struct.ClientStructProcedureEquipFixtureService;
import com.techsoft.client.service.struct.ClientStructProcedureInstructService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.struct.StructProcedureEquipFixtureParamVo;
import com.techsoft.entity.struct.StructProcedureEquipFixtureVo;
import com.techsoft.entity.struct.StructProcedureInstructParamVo;

@Controller
@RequestMapping("/struct/structProcedureEquipFixture")
public class StructProcedureEquipFixtureController extends BaseController {
	@Autowired
	private ClientStructProcedureEquipFixtureService clientStructProcedureEquipFixtureService;
	@Autowired
	private ClientStructProcedureInstructService clientStructProcedureInstructService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		StructProcedureInstructParamVo param = new StructProcedureInstructParamVo();
		List<StructProcedureInstruct> instructList;
		try {
			instructList = clientStructProcedureInstructService.selectListByParamVo(param, null);
			modelAndView.addObject("instructList", instructList);
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
		modelAndView.setViewName("struct/structProcedureEquipFixture-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("struct/structProcedureEquipFixture-edit");
		StructProcedureEquipFixtureVo entity = new StructProcedureEquipFixtureVo();
		try {
			if (id != null) {
				entity = clientStructProcedureEquipFixtureService.getVoByID(id, this.getCommonParam(request));
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
			StructProcedureEquipFixtureParamVo structProcedureEquipFixtureParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structProcedureEquipFixtureParamVo==null){
            	structProcedureEquipFixtureParamVo = new StructProcedureEquipFixtureParamVo();
            }
            structProcedureEquipFixtureParamVo.setTenantId(getLoginTenantId(request));
			pageInfo = clientStructProcedureEquipFixtureService.selectPageVoByParamVo(
					structProcedureEquipFixtureParamVo, this.getCommonParam(request),
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
			StructProcedureEquipFixtureParamVo structProcedureEquipFixtureParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    structProcedureEquipFixtureParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructProcedureEquipFixtureService.saveOrUpdate(structProcedureEquipFixtureParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	@RequestMapping("/addProcedureFixture")
	public ModelAndView addProcedureFixture(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structProcedureEquipFixture-addProFixture");
		return modelAndView;
	}

	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
				clientStructProcedureEquipFixtureService.deleteById(id, this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

}
