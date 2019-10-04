package com.techsoft.controller.bill;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.bill.ClientBillSaleorderItemService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.product.ClientProductMaterialService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.bill.BillPurchaseItemParamVo;
import com.techsoft.entity.bill.BillSaleorderItemParamVo;
import com.techsoft.entity.bill.BillSaleorderItemVo;
import com.techsoft.entity.common.BillSaleorderItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductMaterialParamVo;

@Controller
@RequestMapping("/bill/billSaleorderItem")
public class BillSaleorderItemController extends BaseController {
	@Autowired
	private ClientBillSaleorderItemService clientBillSaleorderItemService;
	@Autowired
	private ClientProductMaterialService clientProductMaterialService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	
		try {
			//取物料合集
			ProductMaterialParamVo productMaterialParamVo= new ProductMaterialParamVo();
			List<ProductMaterial> productMaterialList  = clientProductMaterialService.selectListByParamVo(productMaterialParamVo, this.getCommonParam(null));
			modelAndView.addObject("productMaterialList", productMaterialList);
			//销售单状态数据字典
			List<ConfigDictionary> saleorderStatusList =clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_STATUS.getValue());
			modelAndView.addObject("saleorderStatusList",saleorderStatusList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/billSaleorderItem-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bill/billSaleorderItem-edit");
		BillSaleorderItemVo entity = new BillSaleorderItemVo();
		try {
			if (id != null) {
				entity = clientBillSaleorderItemService.getVoByID(id, this.getCommonParam(request));
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
			BillSaleorderItemParamVo billSaleorderItemParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(billSaleorderItemParamVo==null){
            	billSaleorderItemParamVo = new BillSaleorderItemParamVo();
            }
			pageInfo = clientBillSaleorderItemService.selectPageVoByParamVo(
					billSaleorderItemParamVo, this.getCommonParam(request),
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
			BillSaleorderItemParamVo billSaleorderItemParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    billSaleorderItemParamVo.setModifyUserId(getLoginUserId(request)); 
	    if (billSaleorderItemParamVo.getId() != null) {
	    	billSaleorderItemParamVo.setBillSaleorderId(null);
		}
		resultMessage = clientBillSaleorderItemService.saveOrUpdate(billSaleorderItemParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
				clientBillSaleorderItemService.deleteById(id, this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	/** 
	 *@auther :Yang
	 *@version :2019年7月24日
	 *@param
	 *@return
	 *@description 检查对应的明细边有没有数据
	 */
	@ResponseBody
	@RequestMapping("/checkData")
	public ResultMessage checkData(HttpServletRequest request,BillSaleorderItemParamVo billSaleorderItemParamVo) {
		ResultMessage resultMessage = new ResultMessage();
		 List<BillSaleorderItem> list = null;
		 try {
			 list = clientBillSaleorderItemService.selectListByParamVo(billSaleorderItemParamVo,this.getCommonParam(null));
			 if(list.size()>0){
				 resultMessage.setIsSuccess(true);
			 } 
		} catch (SQLException e) {
			e.printStackTrace();
		}    
	     return resultMessage;	
	}
	

}
