package com.techsoft.controller.pda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techsoft.client.service.barcode.ClientBarcodeMainService;
import com.techsoft.client.service.bill.ClientBillDeliveryItemService;
import com.techsoft.client.service.bill.ClientBillDeliveryService;
import com.techsoft.client.service.bill.ClientBillWarehouseItemService;
import com.techsoft.client.service.bill.ClientBillWarehouseService;
import com.techsoft.client.service.track.ClientTrackBarcodeService;
import com.techsoft.client.service.warehouse.ClientWarehouseLocationService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumBarcodeStatus;
import com.techsoft.common.enums.EnumBillStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.barcode.BarcodeMainVo;
import com.techsoft.entity.bill.BillDeliveryItemParamVo;
import com.techsoft.entity.bill.BillDeliveryItemVo;
import com.techsoft.entity.bill.BillDeliveryParamVo;
import com.techsoft.entity.bill.BillDeliveryVo;
import com.techsoft.entity.bill.BillWarehouseItemParamVo;
import com.techsoft.entity.bill.BillWarehouseItemVo;
import com.techsoft.entity.bill.BillWarehouseParamVo;
import com.techsoft.entity.bill.BillWarehouseVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.track.TrackBarcodeParamVo;
import com.techsoft.entity.track.TrackBarcodeVo;
import com.techsoft.entity.warehouse.WarehouseLocationParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationVo;
import com.techsoft.service.barcode.BarcodeMainService;

/**
 * @auther:Chen
 * @version:2019年4月30日上午10:33:10
 * @param:
 * @description pda生产退料请求controller层
 */
@Controller
@RequestMapping("/pda/pdaSupReject")
public class PdaSupRejectController extends BaseController {
	@Autowired
	private ClientBillDeliveryService clientBillDeliveryService;
	@Autowired
	private ClientBillDeliveryItemService clientBillDeliveryItemService;
	@Autowired
	private ClientBarcodeMainService clientBarcodeMainService;
	@Autowired
	private ClientWarehouseLocationService clientWarehouseLocationService;
	@Autowired
	private ClientTrackBarcodeService clientTrackBarcodeService;
	
	/**
	*@auther:Chen
	*@version:2019年7月26日下午4:10:40
	*@param request
	*@return
	*@description
	*/
	@ResponseBody
	@RequestMapping(value = "/rejectBillMain", method = RequestMethod.POST)
	public ResultMessage getBillMain(HttpServletRequest request,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BillDeliveryVo> billMain = new ArrayList<BillDeliveryVo>();
		BillDeliveryParamVo paramVo = new BillDeliveryParamVo();
		paramVo.setBillTypeDictId(EnumBillType.BILL_TYPE_DELIVERY_SUPPLIER.getValue());
		paramVo.setBillStatusDictId(EnumBillStatus.NEW.getValue());
		try {
			billMain = clientBillDeliveryService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (billMain.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("暂无发货单信息");
			} else {
				resultMessage.put(billMain);
				resultMessage.setIsSuccess(true);
			}
		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}

		return resultMessage;
	}
	
	
	/**
	*@auther:Chen
	*@version:2019年7月26日下午4:32:25
	*@param request
	*@param billId
	*@return
	*@description
	*/
	@ResponseBody
	@RequestMapping(value = "/rejectDetail", method = RequestMethod.POST)
	public ResultMessage getBillDetail(HttpServletRequest request,Long billId,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BillDeliveryItemVo> billDetail = new ArrayList<BillDeliveryItemVo>();
		BillDeliveryItemParamVo paramVo = new BillDeliveryItemParamVo();
		paramVo.setBillId(billId);
		try {
			billDetail = clientBillDeliveryItemService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (billDetail.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("暂无发货单明细信息");
			} else {
				resultMessage.put(billDetail);
				resultMessage.setIsSuccess(true);
			}
		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}

		return resultMessage;
	}
	
	@ResponseBody
	@RequestMapping(value = "/endBill", method = RequestMethod.POST)
	public ResultMessage endBill(HttpServletRequest request,Long billId,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		resultMessage=clientBillDeliveryItemService.endBill(billId,this.getCommonParam(request));

		return resultMessage;
	}
}
