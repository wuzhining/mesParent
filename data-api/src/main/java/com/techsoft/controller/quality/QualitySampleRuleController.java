package com.techsoft.controller.quality;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.quality.ClientQualitySampleRuleService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.quality.QualitySampleRuleParamVo;
import com.techsoft.entity.quality.QualitySampleRuleVo;

@Controller
@RequestMapping("/quality/qualitySampleRule")
public class QualitySampleRuleController extends BaseController {
	@Autowired
	private ClientQualitySampleRuleService clientQualitySampleRuleService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		//取IQC检验方式集合
		try {
			List<ConfigDictionary> inspectModeList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.QUALITY_INSPECT_MODE.getValue());
			modelAndView.addObject("inspectModeList", inspectModeList);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("quality/qualitySampleRule-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("quality/qualitySampleRule-edit");
		QualitySampleRuleVo entity = new QualitySampleRuleVo();
		try {
			if (id != null) {
				entity = clientQualitySampleRuleService.getVoByID(id, this.getCommonParam(request));
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
			QualitySampleRuleParamVo qualitySampleRuleParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(qualitySampleRuleParamVo==null){
            	qualitySampleRuleParamVo = new QualitySampleRuleParamVo();
            }
			pageInfo = clientQualitySampleRuleService.selectPageVoByParamVo(
					qualitySampleRuleParamVo, this.getCommonParam(request),
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
			QualitySampleRuleParamVo qualitySampleRuleParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    qualitySampleRuleParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientQualitySampleRuleService.saveOrUpdate(qualitySampleRuleParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

}
