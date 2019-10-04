package com.techsoft.controller.bill;

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

import com.techsoft.common.BusinessException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;

import com.techsoft.client.service.bill.ClientBillWarehouseItemService;
import com.techsoft.client.service.product.ClientProductMaterialService;
import com.techsoft.client.service.track.ClientTrackBarcodeService;
import com.techsoft.entity.bill.BillWarehouseItemVo;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.product.ProductMaterialParamVo;
import com.techsoft.entity.track.TrackBarcodeParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationVo;
import com.techsoft.entity.bill.BillWarehouseItemParamVo;

@Controller
@RequestMapping("/bill/billWarehouseItem")
public class BillWarehouseItemController extends BaseController {
	@Autowired
	private ClientBillWarehouseItemService clientBillWarehouseItemService;
	@Autowired
	private ClientProductMaterialService clientProductMaterialService;
	@Autowired
	private ClientTrackBarcodeService clientTrackBarcodeService;
	
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
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/billWarehouseItem-list");
		return modelAndView;
	}
	
	@RequestMapping("/listsn")
	public ModelAndView listsn(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/trackBarcode-list");
		return modelAndView;
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bill/billWarehouseItem-edit");
		BillWarehouseItemVo entity = new BillWarehouseItemVo();
		try {
			if (id != null) {
				entity = clientBillWarehouseItemService.getVoByID(id, this.getCommonParam(request));
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
			BillWarehouseItemParamVo billWarehouseItemParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(billWarehouseItemParamVo==null){
            	billWarehouseItemParamVo = new BillWarehouseItemParamVo();
            }
			pageInfo = clientBillWarehouseItemService.selectPageVoByParamVo(
					billWarehouseItemParamVo, this.getCommonParam(request),
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
			BillWarehouseItemParamVo billWarehouseItemParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    billWarehouseItemParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientBillWarehouseItemService.saveOrUpdate(billWarehouseItemParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
				clientBillWarehouseItemService.deleteById(id, this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	
	@RequestMapping(value = "/updateBillStatus",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage updateStatus(HttpServletRequest request,
			BillWarehouseItemVo billWarehouseItemVo)  {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (billWarehouseItemVo.getBillId() != null) {
				clientBillWarehouseItemService.updateBillStatus(billWarehouseItemVo,  this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	/**
	 * @auther:Chenzj
	 * @version:2019年5月20日上午09:43:29
	 * @param: billId 单据编码
	 * @description 判断该单据是否已生成标签
	 */
	@ResponseBody
	@RequestMapping(value = "/checkSncreate", method = RequestMethod.POST)
	public ResultMessage getLocationList(HttpServletRequest request, Long billId) {
		ResultMessage resultMessage = new ResultMessage();
		List<TrackBarcode> trackList = new ArrayList<TrackBarcode>();
		TrackBarcodeParamVo paramVo = new TrackBarcodeParamVo();
		paramVo.setBillId(billId);
		try {
			
			trackList = clientTrackBarcodeService.selectListByParamVo(paramVo, this.getCommonParam(request));
			
			if(trackList.size() ==0){
				resultMessage.addErr("0");
				resultMessage.setIsSuccess(true);
				
			}else{
				resultMessage.addErr("该单据标签已生成，请无需重复打印新标签！");
			    resultMessage.setIsSuccess(false);
			}
		}  catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}

		return resultMessage;
	}
}
