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
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.client.service.struct.ClientStructWarehouseService;
import com.techsoft.client.service.warehouse.ClientWarehouseLocationStockService;
import com.techsoft.client.service.warehouse.ClientWarehouseAreaService;
import com.techsoft.client.service.warehouse.ClientWarehouseLocationService;
import com.techsoft.client.service.warehouse.ClientWarehouseRackService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.product.ProductMainParamVo;
import com.techsoft.entity.product.ProductMaterialParamVo;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructWarehouseParamVo;
import com.techsoft.entity.warehouse.WarehouseAreaParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationStockParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationStockVo;
import com.techsoft.entity.warehouse.WarehouseRackParamVo;
import com.techsoft.client.service.product.ClientProductMainService;
import com.techsoft.client.service.product.ClientProductMaterialService;;

@Controller
@RequestMapping("/warehouse/warehouseLocationStock")
public class WarehouseLocationStockController extends BaseController {
	@Autowired
	private ClientWarehouseLocationStockService clientWarehouseLocationStockService;
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	@Autowired
	private ClientWarehouseRackService clientWarehouseRackService;
	@Autowired
	private ClientStructWarehouseService clientStructWarehouseService;
	@Autowired
	private ClientWarehouseLocationService clientWarehouseLocationService;
	@Autowired
	private ClientProductMainService clientProductMainService;
	@Autowired
	private ClientProductMaterialService clientProductMaterialService;
	@Autowired
	private ClientWarehouseAreaService clientWarehouseAreaService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try{
		//取工厂集合
		StructFactoryParamVo paramVo = new StructFactoryParamVo();
		List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(paramVo,this.getCommonParam(null));
		modelAndView.addObject("factoryList", factoryList); 
		
		//取仓库集合
		StructWarehouseParamVo paramVowarehosue = new StructWarehouseParamVo();
		List<StructWarehouse> warehouseList = clientStructWarehouseService.selectListByParamVo(paramVowarehosue,this.getCommonParam(null));
		modelAndView.addObject("warehouseList", warehouseList);
		
		//取货架集合
		WarehouseRackParamVo paramVorack = new WarehouseRackParamVo();
		List<WarehouseRack> rackList = clientWarehouseRackService.selectListByParamVo(paramVorack,this.getCommonParam(null));
		modelAndView.addObject("rackList", rackList);
		
		//取库位集合
		WarehouseLocationParamVo paramVolocation = new WarehouseLocationParamVo();
		List<WarehouseLocation> locationList = clientWarehouseLocationService.selectListByParamVo(paramVolocation,this.getCommonParam(null));
		modelAndView.addObject("locationList", locationList);
		
		//取物品集合
		ProductMainParamVo paramVoproductmain = new ProductMainParamVo();
		List<ProductMain> productMainList = clientProductMainService.selectListByParamVo(paramVoproductmain,this.getCommonParam(null));
		modelAndView.addObject("productMainList", productMainList);
		
		//取物料集合
		ProductMaterialParamVo paramVoproductmaterial = new ProductMaterialParamVo();
		List<ProductMaterial> ProductMaterialList = clientProductMaterialService.selectListByParamVo(paramVoproductmaterial,this.getCommonParam(null));
		modelAndView.addObject("ProductMaterialList", ProductMaterialList);
		
		//取仓库区域名称集合
		WarehouseAreaParamVo warehouseArea = new WarehouseAreaParamVo();
		List<WarehouseArea> warehouseAreaList = clientWarehouseAreaService.selectListByParamVo(warehouseArea,this.getCommonParam(null));
		modelAndView.addObject("warehouseAreaList", warehouseAreaList);
		
		
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
		modelAndView.setViewName("warehouse/warehouseLocationStock-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("warehouse/warehouseLocationStock-edit");
		WarehouseLocationStockVo entity = new WarehouseLocationStockVo();
		try {
			if (id != null) {
				entity = clientWarehouseLocationStockService.getVoByID(id, this.getCommonParam(request));
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
			WarehouseLocationStockParamVo warehouseLocationStockParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(warehouseLocationStockParamVo==null){
            	warehouseLocationStockParamVo = new WarehouseLocationStockParamVo();
            }
			pageInfo = clientWarehouseLocationStockService.selectPageVoByParamVo(
					warehouseLocationStockParamVo, this.getCommonParam(request),
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
			WarehouseLocationStockParamVo warehouseLocationStockParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    warehouseLocationStockParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientWarehouseLocationStockService.saveOrUpdate(warehouseLocationStockParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
