package com.techsoft.controller.bill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.bill.ClientBillPurchaseItemService;
import com.techsoft.client.service.bill.ClientBillPurchaseService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.product.ClientProductMainService;
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
import com.techsoft.entity.bill.BillPurchaseItemVo;
import com.techsoft.entity.bill.BillPurchaseParamVo;
import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.BillPurchaseItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductMainParamVo;
import com.techsoft.entity.product.ProductMaterialParamVo;

@Controller
@RequestMapping("/bill/billPurchaseItem")
public class BillPurchaseItemController extends BaseController {
	@Autowired
	private ClientBillPurchaseItemService clientBillPurchaseItemService;
	@Autowired
	private ClientBillPurchaseService clientBillPurchaseService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientProductMainService clientProductMainService;
	@Autowired
	private ClientProductMaterialService clientProductMaterialService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		try {
			//取物品集合
			ProductMainParamVo productMainParamVo = new ProductMainParamVo();
			List<ProductMain> productMainList =clientProductMainService.selectListByParamVo(productMainParamVo, this.getCommonParam(null));
			modelAndView.addObject("productMainList1", productMainList);
			//取采购单明细状态集合
			List<ConfigDictionary> dictionaryList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_STATUS.getValue());
			modelAndView.addObject("dictionaryList1", dictionaryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/billPurchaseItem-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			//取物品集合
			ProductMainParamVo productMainParamVo = new ProductMainParamVo();
			List<ProductMain> productMainList =clientProductMainService.selectListByParamVo(productMainParamVo, this.getCommonParam(null));
			modelAndView.addObject("productMainList", productMainList);
			//取物料集合
			ProductMaterialParamVo productMaterialParamVo = new ProductMaterialParamVo();
			List<ProductMaterial> productMaterialList =clientProductMaterialService.selectListByParamVo(productMaterialParamVo, this.getCommonParam(null));
			modelAndView.addObject("productMaterialList", productMaterialList);
			//取采购单集合
			BillPurchaseParamVo billPurchaseParamVo = new BillPurchaseParamVo();
			List<BillPurchase> BillPurchaseList =clientBillPurchaseService.selectListByParamVo(billPurchaseParamVo, this.getCommonParam(null));
			modelAndView.addObject("BillPurchaseList", BillPurchaseList);
			//取采购单明细状态集合
			List<ConfigDictionary> dictionaryList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_STATUS.getValue());
			modelAndView.addObject("dictionaryList", dictionaryList);
			
			BillPurchaseItemVo entity = new BillPurchaseItemVo();
			if (id != null) {
				entity = clientBillPurchaseItemService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.setViewName("bill/billPurchaseItem-edit");
			modelAndView.addObject("entity", entity);
			initData(modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			BillPurchaseItemParamVo billPurchaseItemParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(billPurchaseItemParamVo==null){
            	billPurchaseItemParamVo = new BillPurchaseItemParamVo();
            }
			pageInfo = clientBillPurchaseItemService.selectPageVoByParamVo(
					billPurchaseItemParamVo, this.getCommonParam(request),
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
			BillPurchaseItemParamVo billPurchaseItemParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    billPurchaseItemParamVo.setModifyUserId(getLoginUserId(request));
	    if (billPurchaseItemParamVo.getId() != null) {
	    	 billPurchaseItemParamVo.setBillPurchaseId(null);
		}
		resultMessage = clientBillPurchaseItemService.saveOrUpdate(billPurchaseItemParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
				clientBillPurchaseItemService.deleteById(id, this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	
	/**
	 * 
	 *@auther :Yang
	 *@version :2019年7月19日
	 *@param
	 *@return
	 *@description 检查对应的明细边有没有数据
	 */
	@ResponseBody
	@RequestMapping("/checkData")
	public ResultMessage checkData(HttpServletRequest request,BillPurchaseItemParamVo billPurchaseItemParamVo) {
		ResultMessage resultMessage = new ResultMessage();
		 List<BillPurchaseItem> list = null;
		 try {
			 list = clientBillPurchaseItemService.selectListByParamVo(billPurchaseItemParamVo,this.getCommonParam(null));
			 if(list.size()>0){
				 resultMessage.setIsSuccess(true);
			 } 
		} catch (SQLException e) {
			e.printStackTrace();
		}    
	     return resultMessage;	
	}
	
	

}
