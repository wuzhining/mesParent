package com.techsoft.controller.screen;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.barcode.ClientBarcodeMainService;
import com.techsoft.client.service.bill.ClientBillWarehouseService;
import com.techsoft.client.service.bill.ClientBillWorkorderService;
import com.techsoft.client.service.product.ClientProductMainService;
import com.techsoft.client.service.product.ClientProductMaterialService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.bill.BillWarehouseParamVo;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductMainParamVo;
import com.techsoft.entity.product.ProductMaterialParamVo;


@Controller
@RequestMapping("/screen/screenSluggishMaterials")
public class screenSluggishMaterialsController extends BaseController {
	@Autowired
	private ClientProductMaterialService clientProductMaterialService;
	@Autowired
	private ClientBillWarehouseService clientBillWarehouseService;
	@Autowired
	private ClientBarcodeMainService clientBarcodeMainService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try{
			
			//取物料集合
		    ProductMaterialParamVo ParamVoProductMaterialParamVo = new ProductMaterialParamVo();
		    List<ProductMaterial> materialList = clientProductMaterialService.selectListByParamVo(ParamVoProductMaterialParamVo,this.getCommonParam(null));
			modelAndView.addObject("materialList", materialList);
			
		} catch (SQLException e) {  
			e.printStackTrace();
		} 
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("screen/screenSluggishMaterials-list");
		return modelAndView;
	}


	

	
	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			BarcodeMainParamVo barcodeMainParamVo, Integer pageIndex) {
		PageInfo pageInfo = null;	
		try {
            if(barcodeMainParamVo==null){
            	barcodeMainParamVo = new BarcodeMainParamVo();
            }
            //barcodeMainParamVo.setLocationId(1000206000001L);
			pageInfo = clientBarcodeMainService.selectPageVoByParamVo(
					barcodeMainParamVo, this.getCommonParam(request),
					pageIndex, Constants.SEARCH_PAGE_SIZE);
	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}



		


}
