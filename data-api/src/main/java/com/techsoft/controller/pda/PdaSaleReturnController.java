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
import com.techsoft.entity.bill.BillWarehouseItemParamVo;
import com.techsoft.entity.bill.BillWarehouseItemVo;
import com.techsoft.entity.bill.BillWarehouseParamVo;
import com.techsoft.entity.bill.BillWarehouseVo;
import com.techsoft.entity.common.BarcodeMain;
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
 * @description pda销售退货请求controller层
 */
@Controller
@RequestMapping("/pda/pdaSaleReturn")
public class PdaSaleReturnController extends BaseController {
	@Autowired
	private ClientBillWarehouseService clientBillWarehouseService;
	@Autowired
	private ClientBillWarehouseItemService clientBillWarehouseItemService;
	@Autowired
	private ClientBarcodeMainService clientBarcodeMainService;
	@Autowired
	private ClientWarehouseLocationService clientWarehouseLocationService;
	@Autowired
	private ClientTrackBarcodeService clientTrackBarcodeService;
	
	
	
	/**
	 * @auther:Chenzj
	 * @version:2019年7月09日上午10:48:29
	 * @param: barcode 物料标签
	 * @description pda扫描物料标签判断可以销售退货
	 */
	@ResponseBody
	@RequestMapping(value = "/barcodeSaleReturnScan", method = RequestMethod.POST)
	public ResultMessage getBarcodeList(HttpServletRequest request, String barcode,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BarcodeMainVo> barcodeMainList = new ArrayList<BarcodeMainVo>();
		BarcodeMainParamVo paramVo = new BarcodeMainParamVo();
		paramVo.setBarcode(barcode);
		try {
			
			//查找标签信息，根据返回结果判断是否有数据
			barcodeMainList = clientBarcodeMainService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (barcodeMainList.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无此标签信息");
				
				
			} else {
				
				//判断标签的状态是否是出库状态，其他状态均不可上架
                if (barcodeMainList.get(0).getBarcodeStatusDictId().equals(EnumBarcodeStatus.OUTSTORE.getValue())) {
                	
                	if (barcodeMainList.get(0).getBarcodePackboxId()==0){
                		
                		if (barcodeMainList.get(0).getBillTypeDictId().equals(EnumBillType.BILL_TYPE_WAREHOUSE_SHIPPING.getValue())){
                			
	    					resultMessage.put(barcodeMainList);
	    					resultMessage.setIsSuccess(true);
    				
	                	}else {
	                		resultMessage.setIsSuccess(false);
	    					resultMessage.addErr("扫描标签并非销售出库，不能进行销售退货！");
	    				}
                	}else {
                		resultMessage.setIsSuccess(false);
    					resultMessage.addErr("请扫描最外层箱号！");
    				}
    				
				} else if (barcodeMainList.get(0).getBarcodeStatusDictId().equals(EnumBarcodeStatus.INSTORE.getValue())) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("该标签已上架！");
				}else if (barcodeMainList.get(0).getBarcodeStatusDictId().equals(EnumBarcodeStatus.OFFSTORE.getValue())){
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("该标签处于下架状态！");
				}else {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("该标签不属于出库状态！");
				}
				
				
			}
		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}

		return resultMessage;
	}
	
	//截取中括号的字符串
	public static String extractMessageByRegular(String str){	
				str =str.replace("\"", "");
				str =str.replace("[", "");
				str =str.replace("]", "");
				str.split(",");
				return str;
	}
	
	
	/**
	*@auther:Chen
	*@version:2019年6月18日上午9:39:26
	*@param request
	*@param barcodeStr   批量拼接扫描标签字符串
	*@return
	*@description   批量拼接扫描标签传回，生成销售退货单及退货上架单
	*/
	@ResponseBody
	@RequestMapping(value = "/barcodeSaleReturn", method = RequestMethod.POST)
	public ResultMessage barcodeSaleReturn(HttpServletRequest request,String barcodeStr,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BarcodeMain> barcodeList=new ArrayList<BarcodeMain>();
		String[] barcodeItem = extractMessageByRegular(barcodeStr).split(",");
        for(String barcodeItems : barcodeItem){
        	BarcodeMain sample= new BarcodeMain();
        	sample.setBarcode(barcodeItems);
        	barcodeList.add(sample);
        };
        
		
		resultMessage=clientBillWarehouseService.barcodeSaleReturn(barcodeList, this.getCommonParam(request));
		return resultMessage;
	}
	
	
	/**
	 * @auther:Chenzj
	 * @version:2019年4月30日上午10:48:29
	 * @param:locationCode 货位标签
	 * @description pda扫描货位标签返回数据
	 */
	@ResponseBody
	@RequestMapping(value = "/locationList", method = RequestMethod.POST)
	public ResultMessage getLocationList(HttpServletRequest request, String locationCode,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<WarehouseLocationVo> warehouseLocationList = new ArrayList<WarehouseLocationVo>();
		WarehouseLocationParamVo paramVo = new WarehouseLocationParamVo();
		paramVo.setLocationCode(locationCode);
		try {
			warehouseLocationList = clientWarehouseLocationService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if(warehouseLocationList.size() ==0){
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无此货位信息");
			}else{
				resultMessage.put(warehouseLocationList);
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
	*@version:2019年6月15日上午9:09:59
	*@param request
	*@param barcode  扫描标签
	*@return
	*@description    根据扫描标签获取退料上架单号
	*/
	@ResponseBody
	@RequestMapping(value = "/barcodeToBill", method = RequestMethod.POST)
	public ResultMessage barcodeToBill(HttpServletRequest request,String barcode,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<TrackBarcodeVo> returnList=new ArrayList<TrackBarcodeVo>();
		TrackBarcodeParamVo trackBarcodeVo=new TrackBarcodeParamVo();
		trackBarcodeVo.setBarcode(barcode);
		trackBarcodeVo.setBillTypeDictId(EnumBillType.BILL_TYPE_WAREHOUSE_IN.getValue());;
		trackBarcodeVo.setBillStatusDictId(EnumBillStatus.NEW.getValue());
		trackBarcodeVo.setBarcodeStatusDictId(EnumBarcodeStatus.NEW.getValue());
		try {
			returnList=clientTrackBarcodeService.selectListVoByParamVo(trackBarcodeVo, this.getCommonParam(request));
			
			if (returnList.size()>0) {
				
				BillWarehouse billWarehouse =clientBillWarehouseService.selectById(returnList.get(0).getBillId(), this.getCommonParam(request));
				
				if (billWarehouse.getFromBillTypeDictId().equals(EnumBillType.BILL_TYPE_WAREHOUSE_REJECT_CUSTOMER.getValue())) {
					resultMessage.put(returnList);
				    resultMessage.setIsSuccess(true);
					
				}else{
					resultMessage.addErr("扫描标签上架单并非销售退货上架单");
				}
				
			}else{
				resultMessage.addErr("扫描标签无销售退货上架单信息");
			}
			
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		}
		return resultMessage;
	}

	
	/**
	*@auther:Chen
	*@version:2019年6月15日上午9:10:05
	*@param request
	*@param billId    退料上架单ID
	*@return
	*@description     查询退货上架单所有标签信息
	*/
	@ResponseBody
	@RequestMapping(value = "/billSnlist", method = RequestMethod.POST)
	public ResultMessage billSnlist(HttpServletRequest request,Long billId,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		
		List<TrackBarcodeVo> returnList=new ArrayList<TrackBarcodeVo>();
		TrackBarcodeParamVo trackBarcodeVo=new TrackBarcodeParamVo();
		trackBarcodeVo.setBillId(billId);
		trackBarcodeVo.setBillTypeDictId(EnumBillType.BILL_TYPE_WAREHOUSE_IN.getValue());;
		trackBarcodeVo.setBillStatusDictId(EnumBillStatus.NEW.getValue());
		trackBarcodeVo.setBarcodeStatusDictId(EnumBarcodeStatus.NEW.getValue());
		trackBarcodeVo.setBarcodePackboxId((long) 0);
		try {
			returnList=clientTrackBarcodeService.selectListVoByParamVo(trackBarcodeVo, this.getCommonParam(request));
			
			if (returnList.size()>0) {
				
				resultMessage.put(returnList);
			    resultMessage.setIsSuccess(true);
			    
			} else {
				 resultMessage.addErr("单据无需上架标签信息");
			}
		
		} catch (SQLException e) {
					resultMessage.addErr("SQL查询异常");
		} catch (BusinessException e) {
			        resultMessage.addErr("业务异常");
		} 
		
		return resultMessage;
	}
	
	
	
	/**
	*@auther:Chen
	*@version:2019年6月17日上午10:00:23
	*@param request
	*@param billId            退货上架单ID
	*@param billItemId        退货上架单明细ID
	*@param barcode           退货标签
	*@param locationId        货位ID
	*@param warehouseId       仓库ID
	*@return
	*@description    扫描标签进行退料上架
	*/
	@ResponseBody
	@RequestMapping(value = "/billSaleReturnInput", method = RequestMethod.POST)
	public ResultMessage billReturnInput(HttpServletRequest request,Long billId,Long billItemId,String barcode,Long locationId,Long warehouseId,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		
		TrackBarcode trackBarcode=new TrackBarcode();
		trackBarcode.setBarcode(barcode);
		trackBarcode.setBillId(billId);
		trackBarcode.setBillItemId(billItemId);
		trackBarcode.setLocationId(locationId);
		trackBarcode.setWarehouseId(warehouseId);
		
		resultMessage=clientTrackBarcodeService.billSaleReturnInput(trackBarcode, this.getCommonParam(request));
	
		
		return resultMessage;
	}
}
