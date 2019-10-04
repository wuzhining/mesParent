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
import com.techsoft.client.service.bill.ClientBillWarehouseItemService;
import com.techsoft.client.service.bill.ClientBillWarehouseService;
import com.techsoft.client.service.struct.ClientStructWarehouseService;
import com.techsoft.client.service.sys.ClientAdminMenuService;
import com.techsoft.client.service.track.ClientTrackBarcodeService;
import com.techsoft.client.service.warehouse.ClientWarehouseLocationService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumBarcodeStatus;
import com.techsoft.common.enums.EnumBillStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.enums.EnumSystemType;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.JsonUtils;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.barcode.BarcodeMainVo;
import com.techsoft.entity.bill.BillWarehouseItemParamVo;
import com.techsoft.entity.bill.BillWarehouseItemVo;
import com.techsoft.entity.bill.BillWarehouseParamVo;
import com.techsoft.entity.bill.BillWarehouseVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.QualitySampleRuleItem;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.struct.StructWarehouseParamVo;
import com.techsoft.entity.struct.StructWarehouseVo;
import com.techsoft.entity.sys.AdminMenuParamVo;
import com.techsoft.entity.sys.AdminMenuVo;
import com.techsoft.entity.track.TrackBarcodeParamVo;
import com.techsoft.entity.track.TrackBarcodeVo;
import com.techsoft.entity.warehouse.WarehouseLocationParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationVo;
import com.techsoft.service.barcode.BarcodeMainService;

import javassist.expr.NewArray;

/**
 * @auther:Chen
 * @version:2019年4月30日上午10:33:10
 * @param:
 * @description pda更新离线信息controller层
 */
@Controller
@RequestMapping("/pda/pdaUpdateData")
public class PdaUpdateDataController extends BaseController {
	@Autowired
	private ClientBillWarehouseService clientBillWarehouseService;
	@Autowired
	private ClientBillWarehouseItemService clientBillWarehouseItemService;
	@Autowired
	private ClientBarcodeMainService clientBarcodeMainService;
	@Autowired
	private ClientStructWarehouseService clientStructWarehouseService;
	@Autowired
	private ClientTrackBarcodeService clientTrackBarcodeService;
	@Autowired
	private ClientWarehouseLocationService clientWarehouseLocationService;
	
	/**
	 * @auther:Chenzj
	 * @version:2019年5月09日上午14:48:29
	 * @description 查询货位信息
	 */
	@ResponseBody
	@RequestMapping(value = "/locationData", method = RequestMethod.POST)
	public ResultMessage getlocation(HttpServletRequest request,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<WarehouseLocationVo> location = new ArrayList<WarehouseLocationVo>();
		WarehouseLocationParamVo paramVo = new WarehouseLocationParamVo();
		try {
			location = clientWarehouseLocationService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (location.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无货位信息");
			} else {
				resultMessage.put(location);
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
	@RequestMapping(value = "/barcodelData", method = RequestMethod.POST)
	public ResultMessage getBacode(HttpServletRequest request,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BarcodeMainVo> barcode = new ArrayList<BarcodeMainVo>();
		BarcodeMainParamVo paramVo = new BarcodeMainParamVo();
		try {
			barcode = clientBarcodeMainService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (barcode.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无标签信息");
			} else {
				resultMessage.put(barcode);
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
	@RequestMapping(value = "/trackBarcodelData", method = RequestMethod.POST)
	public ResultMessage getTrackBarcodelData(HttpServletRequest request,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<TrackBarcodeVo> barcode = new ArrayList<TrackBarcodeVo>();
		TrackBarcodeParamVo paramVo = new TrackBarcodeParamVo();
		try {
			barcode = clientTrackBarcodeService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (barcode.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无条码追踪表信息");
			} else {
				resultMessage.put(barcode);
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
	@RequestMapping(value = "/billWarehouseData", method = RequestMethod.POST)
	public ResultMessage getBillWarehouseData(HttpServletRequest request,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BillWarehouseVo> bill = new ArrayList<BillWarehouseVo>();
		BillWarehouseParamVo paramVo = new BillWarehouseParamVo();
		try {
			bill = clientBillWarehouseService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (bill.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无仓库单据信息");
			} else {
				resultMessage.put(bill);
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
	@RequestMapping(value = "/billWarehouseItemData", method = RequestMethod.POST)
	public ResultMessage getBillWarehouseItemData(HttpServletRequest request,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BillWarehouseItemVo> billItem = new ArrayList<BillWarehouseItemVo>();
		BillWarehouseItemParamVo paramVo = new BillWarehouseItemParamVo();
		try {
			billItem = clientBillWarehouseItemService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (billItem.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无仓库单据明细信息");
			} else {
				resultMessage.put(billItem);
				resultMessage.setIsSuccess(true);
			}
		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}

		return resultMessage;
	}
	
}
