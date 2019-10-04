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
import com.techsoft.client.service.quality.ClientQualityInspectTypeService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.quality.QualityInspectTypeParamVo;
import com.techsoft.entity.quality.QualityInspectTypeVo;

@Controller
@RequestMapping("/quality/qualityInspectType")
public class QualityInspectTypeController extends BaseController {
	@Autowired
	private ClientQualityInspectTypeService clientQualityInspectTypeService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			List<ConfigDictionary> typeQCList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.QUALITY_INSPECT_TYPE_QC.getValue());
			modelAndView.addObject("typeQCList", typeQCList);
			List<ConfigDictionary> itemTypeList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.QUALITY_INSPECT_ITEM_TYPE.getValue());
			modelAndView.addObject("itemTypeList", itemTypeList);
		} catch (BusinessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("quality/qualityInspectType-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("quality/qualityInspectType-edit");
		QualityInspectTypeVo entity = new QualityInspectTypeVo();
		try {
 		 if (id != null) {
				entity = clientQualityInspectTypeService.getVoByID(id, this.getCommonParam(request));
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
			QualityInspectTypeParamVo qualityInspectTypeParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(qualityInspectTypeParamVo==null){
            	qualityInspectTypeParamVo = new QualityInspectTypeParamVo();
            }
			pageInfo = clientQualityInspectTypeService.selectPageVoByParamVo(
					qualityInspectTypeParamVo, this.getCommonParam(request),
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
			QualityInspectTypeParamVo qualityInspectTypeParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    qualityInspectTypeParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientQualityInspectTypeService.saveOrUpdate(qualityInspectTypeParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	
	@RequestMapping("/qualityInspectTypeOpen")
	public ModelAndView openWinInspectType(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("quality/qualityInspectType-Open");
		return modelAndView;
	}


}
