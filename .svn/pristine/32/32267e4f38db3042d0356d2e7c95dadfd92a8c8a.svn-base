package com.techsoft.controller.warehouse;

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

import com.techsoft.client.service.warehouse.ClientWarehousePalletService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.product.ClientProductMainService;
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.client.service.struct.ClientStructWarehouseService;
import com.techsoft.entity.warehouse.WarehousePalletVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.product.ProductMainParamVo;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructWarehouseParamVo;
import com.techsoft.entity.warehouse.WarehousePalletParamVo;

@Controller
@RequestMapping("/warehouse/warehousePallet")
public class WarehousePalletController extends BaseController {
	@Autowired
	private ClientWarehousePalletService clientWarehousePalletService;
	@Autowired
	private ClientStructWarehouseService ClientStructWarehouseService;
	@Autowired
	private ClientStructFactoryService ClientStructFactoryService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientProductMainService ClientProductMainService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//取工厂集合
			StructFactoryParamVo ParamVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = ClientStructFactoryService.selectListByParamVo(ParamVo,this.getCommonParam(null));
			modelAndView.addObject("factoryList", factoryList); 
			
			//取仓库集合
			StructWarehouseParamVo ParamVowarehosue = new StructWarehouseParamVo();
			List<StructWarehouse> warehouseList = ClientStructWarehouseService.selectListByParamVo(ParamVowarehosue,this.getCommonParam(null));
			modelAndView.addObject("warehouseList", warehouseList);
			
		} catch (SQLException e) {  
			e.printStackTrace();
		}
		
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("warehouse/warehousePallet-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		
		ModelAndView modelAndView = new ModelAndView();
		try {
			//取仓库集合
			StructWarehouseParamVo ParamVowarehosue = new StructWarehouseParamVo();
			List<StructWarehouse> warehouseList = ClientStructWarehouseService.selectListByParamVo(ParamVowarehosue,this.getCommonParam(null));
			modelAndView.addObject("warehouseList", warehouseList);
			
			//取工厂集合
			StructFactoryParamVo ParamVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = ClientStructFactoryService.selectListByParamVo(ParamVo,this.getCommonParam(null));
			modelAndView.addObject("factoryList", factoryList);
			
			//取栈板状态集合
			List<ConfigDictionary> dictionaryList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.WAREHOUSE_PALLET_STATUS.getValue());
			modelAndView.addObject("dictionaryList", dictionaryList);
			
			//取物品集合
			ProductMainParamVo ParamVoProduct = new ProductMainParamVo();
			List<ProductMain> productList = ClientProductMainService.selectListByParamVo(ParamVoProduct,this.getCommonParam(null));
			modelAndView.addObject("productList", productList);
			
			WarehousePalletVo entity = new WarehousePalletVo();
			if (id != null) {;
			entity = clientWarehousePalletService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("warehouse/warehousePallet-edit");
			initData(modelAndView);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			WarehousePalletParamVo warehousePalletParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(warehousePalletParamVo==null){
            	warehousePalletParamVo = new WarehousePalletParamVo();
            }
            //warehousePalletParamVo.setTenantId(getLoginTenantId(request)); 
			pageInfo = clientWarehousePalletService.selectPageVoByParamVo(
					warehousePalletParamVo, this.getCommonParam(request),
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
			WarehousePalletParamVo warehousePalletParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    warehousePalletParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientWarehousePalletService.saveOrUpdate(warehousePalletParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
