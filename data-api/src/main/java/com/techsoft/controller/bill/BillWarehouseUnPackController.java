package com.techsoft.controller.bill;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.techsoft.client.service.barcode.ClientBarcodeMainService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.controller.BaseController;

/**
*@auther:Wang
*@version:2019年5月21日下午4:24:17
*@param:
*@description
*/
@Controller
@RequestMapping("/bill/billWarehouseUnPack")
public class BillWarehouseUnPackController extends BaseController{
	@Autowired
	private ClientBarcodeMainService clientBarcodeMainService;
	
	
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
		modelAndView.setViewName("track/trackBarcode-offUnPack");
		return modelAndView;
	}
	
	@RequestMapping(value = "/scanBarcode")
	@ResponseBody
	public ResultMessage scanBarcode(HttpServletRequest request,
			String barcode) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			resultMessage=clientBarcodeMainService.scanUnpackBarcode(barcode, this.getCommonParam(request));
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}
	
	@RequestMapping(value = "/unpack")
	@ResponseBody
	public ResultMessage unpack(HttpServletRequest request,
			String barcode,String unpackQty) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			resultMessage=clientBarcodeMainService.unpackBarcode(barcode, unpackQty, this.getCommonParam(request));
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}
	

}
