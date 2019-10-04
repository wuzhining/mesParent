package com.techsoft.controller.quality;

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
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.firm.ClientFirmPartnerService;
import com.techsoft.client.service.product.ClientProductClassesService;
import com.techsoft.client.service.product.ClientProductMainService;
import com.techsoft.client.service.quality.ClientQualityInspectItemService;
import com.techsoft.client.service.quality.ClientQualityInspectModuleRelationService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductClasses;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.QualityInspectItem;
import com.techsoft.entity.config.ConfigDictionaryParamVo;
import com.techsoft.entity.firm.FirmPartnerParamVo;
import com.techsoft.entity.product.ProductClassesParamVo;
import com.techsoft.entity.product.ProductMainParamVo;
import com.techsoft.entity.quality.QualityInspectItemParamVo;
import com.techsoft.entity.quality.QualityInspectModuleRelationParamVo;
import com.techsoft.entity.quality.QualityInspectModuleRelationVo;

@Controller
@RequestMapping("/quality/qualityInspectModuleRelation")
public class QualityInspectModuleRelationController extends BaseController {
	@Autowired
	private ClientQualityInspectModuleRelationService clientQualityInspectModuleRelationService;
	@Autowired
	private ClientFirmPartnerService clientFirmPartnerService;
	@Autowired
	private ClientProductMainService clientProductMainService;
	@Autowired
	private ClientProductClassesService clientProductClassesService;
	@Autowired
	private ClientQualityInspectItemService clientQualityInspectItemService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;

	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		
		try {
		//抽样检验水平
		List<ConfigDictionary> sampleLevelList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.QUALITY_SAMPLE_LEVEL.getValue());
		modelAndView.addObject("sampleLevelList", sampleLevelList);
		//获取物品名称
		List<ProductMain> productMainList = clientProductMainService.selectListByParamVo(new ProductMainParamVo(), this.getCommonParam(null));
		modelAndView.addObject("productMainList", productMainList);
		
		//供应商 
		FirmPartnerParamVo vo = new FirmPartnerParamVo();
		vo.setPartnerTypeDictId(10313L);
		List<FirmPartner> supplierList = clientFirmPartnerService.selectListByParamVo(vo, this.getCommonParam(null));
		modelAndView.addObject("supplierList", supplierList);

		//获取物品分类集合
		List<ProductClasses> productClassesList = clientProductClassesService.selectListByParamVo( new ProductClassesParamVo(), this.getCommonParam(null));
		modelAndView.addObject("productClassesList", productClassesList);

		//获取检验模版
		QualityInspectItemParamVo qualityInspectItemParamVo = new QualityInspectItemParamVo();
		qualityInspectItemParamVo.setNotparent(100);
		List<QualityInspectItem> qualityInspectItemList = clientQualityInspectItemService.selectListByParamVo(qualityInspectItemParamVo, this.getCommonParam(null));
		modelAndView.addObject("qualityInspectItemList", qualityInspectItemList);
		
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
		}catch (SQLException | BusinessException e) {  
			e.printStackTrace();
		} 
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("quality/qualityInspectModuleRelation-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("quality/qualityInspectModuleRelation-edit");
		QualityInspectModuleRelationVo entity = new QualityInspectModuleRelationVo();
		try {
			if (id != null) {
				entity = clientQualityInspectModuleRelationService.getVoByID(id, this.getCommonParam(request));
				//获取物品集合
				if(entity.getProductId()!=null){
					ProductMain productMain = clientProductMainService.getVoByID(entity.getProductId(), this.getCommonParam(request));
					modelAndView.addObject("productMain", productMain);
				}
				//供应商
				if(entity.getSupplierId()!= null){
					FirmPartner	firmPartner = clientFirmPartnerService.getVoByID(entity.getSupplierId(), this.getCommonParam(request));
					modelAndView.addObject("firmPartner", firmPartner);
				}
				
				//检验模板
				if(entity.getInspectItemId()!= null){
					QualityInspectItem	qualityInspectItem = clientQualityInspectItemService.getVoByID(entity.getInspectItemId(), this.getCommonParam(request));
					modelAndView.addObject("qualityInspectItem", qualityInspectItem);
				}
				//检验模板
				if(entity.getProductClassesId()!= null){
					ProductClasses	productClasses = clientProductClassesService.getVoByID(entity.getProductClassesId(), this.getCommonParam(request));
					modelAndView.addObject("productClasses", productClasses);
				}
				
				
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
			QualityInspectModuleRelationParamVo qualityInspectModuleRelationParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(qualityInspectModuleRelationParamVo==null){
            	qualityInspectModuleRelationParamVo = new QualityInspectModuleRelationParamVo();
            }
			pageInfo = clientQualityInspectModuleRelationService.selectPageVoByParamVo(
					qualityInspectModuleRelationParamVo, this.getCommonParam(request),
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
			QualityInspectModuleRelationParamVo qualityInspectModuleRelationParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    qualityInspectModuleRelationParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientQualityInspectModuleRelationService.saveOrUpdate(qualityInspectModuleRelationParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	
	@ResponseBody
	@RequestMapping("/getSampleLevelByRank")
	public List<ConfigDictionary> getSampleLevelByRank(HttpServletRequest request, ConfigDictionaryParamVo configDictionaryParamVo) {
		if (configDictionaryParamVo == null) {
			configDictionaryParamVo = new ConfigDictionaryParamVo();
		}
		List<ConfigDictionary> configDictionary = new ArrayList<ConfigDictionary>();
		try {
			configDictionary = clientConfigDictionaryService.selectListByParamVo(configDictionaryParamVo, this.getCommonParam(request));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return configDictionary;
	}
	
	
}
