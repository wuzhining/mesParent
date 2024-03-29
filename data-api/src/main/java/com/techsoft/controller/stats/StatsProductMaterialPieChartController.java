package com.techsoft.controller.stats;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.rpc.Result;
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
import com.techsoft.client.service.product.ClientProductMainService;
import com.techsoft.client.service.product.ClientProductMaterialService;
import com.techsoft.client.service.stats.ClientStatsProductMaterialService;
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.entity.stats.StatsProductMaterialVo;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StatsProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.product.ProductMainParamVo;
import com.techsoft.entity.product.ProductMaterialParamVo;
import com.techsoft.entity.stats.StatsProductMaterialParamVo;

@Controller
@RequestMapping("/stats/statsProductMaterialPieChart")
public class StatsProductMaterialPieChartController extends BaseController {
	@Autowired
	private ClientStatsProductMaterialService clientStatsProductMaterialService;
	@Autowired
	private ClientProductMainService clientProductMainService;
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	@Autowired
	private ClientProductMaterialService clientProductMaterialService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//取物品集合
			StructFactoryParamVo ParamVostructFactory = new StructFactoryParamVo();
			List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(ParamVostructFactory, this.getCommonParam(null));
			modelAndView.addObject("factoryList", factoryList);
			
			//取物品集合
			ProductMainParamVo ParamVoproduct = new ProductMainParamVo();
			List<ProductMain> productList = clientProductMainService.selectListByParamVo(ParamVoproduct, this.getCommonParam(null));
			modelAndView.addObject("productList", productList);
			
			//取物料集合
			ProductMaterialParamVo ParamVoproductMaterial = new ProductMaterialParamVo();
			List<ProductMaterial> productMaterialList = clientProductMaterialService.selectListByParamVo(ParamVoproductMaterial, this.getCommonParam(null));
			modelAndView.addObject("productMaterialList", productMaterialList);
			
			//单据类型
			List<ConfigDictionary> billTypeDicList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_TYPE.getValue());
			modelAndView.addObject("billTypeDicList", billTypeDicList);
		} catch (BusinessException |SQLException e) {
			e.printStackTrace();
		}
		
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("stats/statsProductMaterialPieChart-list");
		return modelAndView;
	}

	@RequestMapping(value = "/productStatus", method = RequestMethod.POST)
	@ResponseBody
	public List<StatsProductMaterialVo> selectListByProductSumStats(HttpServletRequest request,StatsProductMaterialParamVo statsProductMaterialParamVo) {
		List<StatsProductMaterialVo> list =new ArrayList<>();
		try {
			if(statsProductMaterialParamVo==null){
            	statsProductMaterialParamVo = new StatsProductMaterialParamVo();
            }
			list = clientStatsProductMaterialService.selectListByProductSumStats(statsProductMaterialParamVo, this.getCommonParam(request));
		} catch (BusinessException | SQLException e) {
			e.printStackTrace();
		}
		
		 return list;
	}
	
	@RequestMapping(value = "/materiaStatus", method = RequestMethod.POST)
	@ResponseBody
	public List<StatsProductMaterialVo> selectListByMaterialSumStats(HttpServletRequest request,StatsProductMaterialParamVo statsProductMaterialParamVo) {
		List<StatsProductMaterialVo> list =new ArrayList<>();
		try {
			if(statsProductMaterialParamVo==null){
				statsProductMaterialParamVo = new StatsProductMaterialParamVo();
			}
			list = clientStatsProductMaterialService.selectListByMaterialSumStats(statsProductMaterialParamVo, this.getCommonParam(request));
		} catch (BusinessException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@RequestMapping("/statsProductPieChart")
	public ModelAndView productlist(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("stats/statsProductPieChart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/productDataStatus", method = RequestMethod.POST)
	@ResponseBody
	public List<StatsProductMaterial> selectListByDataSumStats(HttpServletRequest request,StatsProductMaterialParamVo statsProductMaterialParamVo) {
		List<StatsProductMaterial> list =new ArrayList<>();
		try {
			if(statsProductMaterialParamVo==null){
				statsProductMaterialParamVo = new StatsProductMaterialParamVo();
			}
			list = clientStatsProductMaterialService.selectListByDataSumStats(statsProductMaterialParamVo, this.getCommonParam(request));
		} catch (BusinessException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@RequestMapping("/statsMaterialPieChart")
	public ModelAndView materiallist(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("stats/statsMaterialPieChart");
		return modelAndView;
	}
	
}
