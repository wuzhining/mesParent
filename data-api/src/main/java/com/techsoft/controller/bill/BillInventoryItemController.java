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

import com.techsoft.common.BusinessException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumBarcodeStatus;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.utils.JsonUtils;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;
import com.techsoft.client.service.barcode.ClientBarcodeMainService;
import com.techsoft.client.service.bill.ClientBillInventoryItemService;
import com.techsoft.client.service.warehouse.ClientWarehouseLocationStockService;
import com.techsoft.entity.bill.BillInventoryItemVo;
import com.techsoft.entity.bill.BillInventoryParamVo;
import com.techsoft.entity.bill.BillPurchaseItemParamVo;
import com.techsoft.entity.bill.BillPurchaseItemVo;
import com.techsoft.entity.bill.BillWarehouseParamVo;
import com.techsoft.entity.bill.BillWarehouseVo;
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.warehouse.WarehouseLocationStockVo;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.barcode.BarcodeMainVo;
import com.techsoft.entity.bill.BillInventoryItemParamVo;

@Controller
@RequestMapping("/bill/billInventoryItem")
public class BillInventoryItemController extends BaseController {
	@Autowired
	private ClientBillInventoryItemService clientBillInventoryItemService;
	@Autowired
	private ClientWarehouseLocationStockService clientWarehouseLocationStockService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/billInventoryItem-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bill/billInventoryItem-edit");
		BillInventoryItemVo entity = new BillInventoryItemVo();
		try {
			if (id != null) {
				entity = clientBillInventoryItemService.getVoByID(id, this.getCommonParam(request));
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
			BillInventoryItemParamVo billInventoryItemParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(billInventoryItemParamVo==null){
            	billInventoryItemParamVo = new BillInventoryItemParamVo();
            }
			pageInfo = clientBillInventoryItemService.selectPageVoByParamVo(
					billInventoryItemParamVo, this.getCommonParam(request),
					pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}
	


	/**
	*@auther:Chen
	*@version:2019年7月3日下午4:50:33
	*@param request
	*@param warehouseLocationStockVo   仓库库存条件对象
	*@param pageIndex                  分页
	*@return
	*@description  根据盘点单的仓库查询仓库的所有物料及库存
	*/
	@ResponseBody
	@RequestMapping("/getStockMaterial/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo getStockMaterial(HttpServletRequest request,WarehouseLocationStockVo warehouseLocationStockVo, Integer pageIndex) {
		PageInfo pageInfo = null;
		if(warehouseLocationStockVo==null){
			warehouseLocationStockVo = new WarehouseLocationStockVo();
        }
			try {
				//warehouseLocationStockVo.setWarehouseId(warehouseLocationStockVo.getWarehouseId());
				pageInfo = clientWarehouseLocationStockService.selectPageBarcodeVoByParamVo(
						warehouseLocationStockVo, this.getCommonParam(request),
						pageIndex, Constants.SEARCH_PAGE_SIZE);
			} catch (BusinessException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return new ReturnPageInfo(pageInfo);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage save(HttpServletRequest request,
			BillInventoryItemParamVo billInventoryItemParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    billInventoryItemParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientBillInventoryItemService.saveOrUpdate(billInventoryItemParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


	@RequestMapping("/choiceMaterial")
	public ModelAndView choiceWorkOrder(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/billInventory-choiceMaterial");
		return modelAndView;
	}
	
	/**
	*@auther:Chen
	*@version:2019年7月3日下午4:52:49
	*@param request
	*@param id    盘点明细ID
	*@return
	*@description  根据盘点单删除相应的明细及标签
	*/
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
				clientBillInventoryItemService.deleteItem(id, this.getCommonParam(request));
				
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	/**
	*@auther:Chen
	*@version:2019年7月3日下午5:03:54
	*@param request
	*@param warehouseLocationStockVo
	*@return
	*@description  新增选择盘点的物料明细及条码
	*/
	@RequestMapping(value = "/addInventoryItem", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage addInventoryItem(HttpServletRequest request,
			WarehouseLocationStockVo warehouseLocationStockVo) {
		ResultMessage resultMessage = new ResultMessage();
		
		String item=request.getParameter("array");
		String billId=request.getParameter("billId");
		List<WarehouseLocationStockVo> list = JsonUtils.conversionToList(item, WarehouseLocationStockVo.class);
		System.err.println(list);
	    
			resultMessage = clientBillInventoryItemService.addInventoryItem(list, Long.valueOf(billId), this.getCommonParam(request));
		

		return resultMessage;
	}
	
	/**
	*@auther:Chen
	*@version:2019年7月3日下午5:09:09
	*@param request
	*@param billInventoryParamVo 盘点单据对象
	*@return
	*@description  根据选择的盘点单生成该盘点仓库的所有物料盘点明细及条码
	*/
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage billInventoryCheck(HttpServletRequest request,
			BillInventoryParamVo billInventoryParamVo) {
		ResultMessage resultMessage = new ResultMessage();
		
		resultMessage = clientBillInventoryItemService.billInventoryCheck(billInventoryParamVo, this.getCommonParam(request));

		return resultMessage;
	}
}
