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
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.struct.ClientStructProcedureMaterialService;
import com.techsoft.entity.struct.StructProcedureMaterialVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.struct.StructProcedureMaterialParamVo;

@Controller
@RequestMapping("/struct/structProcedureMaterial")
public class StructProcedureMaterialController extends BaseController {
	@Autowired
	private ClientStructProcedureMaterialService clientStructProcedureMaterialService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
		try {
			//物品类型数据字典
			List<ConfigDictionary> productTypeList  = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.PRODUCT_TYPE.getValue());
			modelAndView.addObject("productTypeList", productTypeList);
			
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structProcedureMaterial-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("struct/structProcedureMaterial-edit");
		StructProcedureMaterialVo entity = new StructProcedureMaterialVo();
		try {
			if (id != null) {
				entity = clientStructProcedureMaterialService.getVoByID(id, this.getCommonParam(request));
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
			StructProcedureMaterialParamVo structProcedureMaterialParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structProcedureMaterialParamVo==null){
            	structProcedureMaterialParamVo = new StructProcedureMaterialParamVo();
            }
            structProcedureMaterialParamVo.setTenantId(getLoginTenantId(request));
			pageInfo = clientStructProcedureMaterialService.selectPageVoByParamVo(
					structProcedureMaterialParamVo, this.getCommonParam(request),
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
			StructProcedureMaterialParamVo structProcedureMaterialParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    structProcedureMaterialParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructProcedureMaterialService.saveOrUpdate(structProcedureMaterialParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

	@RequestMapping("/addProcedureMaterial")
	public ModelAndView addProcedureFixture(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structProcedureMaterial-addProMaterial");
		return modelAndView;
	}
	
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
				clientStructProcedureMaterialService.deleteById(id, this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
}
