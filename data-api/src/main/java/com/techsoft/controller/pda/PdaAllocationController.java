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
 * @description pda调拨请求controller层
 */
@Controller
@RequestMapping("/pda/pdaAllocation")
public class PdaAllocationController extends BaseController {
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
	
	/**
	 * @auther:Chenzj
	 * @version:2019年5月09日上午14:48:29
	 * @description 选择或扫描调拨单
	 */
	@ResponseBody
	@RequestMapping(value = "/billMain", method = RequestMethod.POST)
	public ResultMessage getBillMain(HttpServletRequest request,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BillWarehouseVo> billMain = new ArrayList<BillWarehouseVo>();
		BillWarehouseParamVo paramVo = new BillWarehouseParamVo();
		paramVo.setBillTypeDictId(EnumBillType.BILL_TYPE_WAREHOUSE_ALLOCATION.getValue());
		paramVo.setNotFinish(EnumBillStatus.FINISHED.getValue());
		try {
			billMain = clientBillWarehouseService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (billMain.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无调拨单信息");
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
	 * @auther:Chenzj
	 * @version:2019年5月09日上午14:48:29
	 * @param: billId 来源单
	 * @description 选择或扫描调拨单
	 */
	@ResponseBody
	@RequestMapping(value = "/billDetail", method = RequestMethod.POST)
	public ResultMessage getBillDetail(HttpServletRequest request, Long billId,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BillWarehouseItemVo> billDetail = new ArrayList<BillWarehouseItemVo>();
		BillWarehouseItemParamVo paramVo = new BillWarehouseItemParamVo();
		paramVo.setBillId(billId);
		try {
			billDetail = clientBillWarehouseItemService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (billDetail.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无此单据明细信息");
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
	
	
	
	/**
	 * @auther:Chenzj
	 * @version:2019年5月09日上午10:48:29
	 * @param: barcode 物料标签
	 * @param: billId  调拨单号
	 * @description pda扫描物料标签判断是否属于该调拨单物料并返回相关处理信息
	 */
	@ResponseBody
	@RequestMapping(value = "/barcodeScan", method = RequestMethod.POST)
	public ResultMessage getBarcodeList(HttpServletRequest request, String barcode,Long billId,String factoryId) {
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
				
				//判断标签的状态是否是上架状态，其他状态均不可下架
                if (barcodeMainList.get(0).getBarcodeStatusDictId().equals(EnumBarcodeStatus.INSTORE.getValue())) {
                	
                	List<BillWarehouseItem> materialItem = new ArrayList<BillWarehouseItem>();
    				BillWarehouseItemParamVo materialParamVo = new BillWarehouseItemParamVo();
    				materialParamVo.setBillId(billId);
    				materialParamVo.setMaterialId(barcodeMainList.get(0).getMaterialId());
    				
    				//查找调拨单是否包含该标签物料，根据返回结果判断是否属于
    				materialItem=clientBillWarehouseItemService.selectListByParamVo(materialParamVo, this.getCommonParam(request));
    				if (materialItem.size()==0) {
    					resultMessage.setIsSuccess(false);
    					resultMessage.addErr("该标签物料不属于此调拨单！");
    				} else {
    					resultMessage.put(barcodeMainList);
    					resultMessage.setIsSuccess(true);
    				}
				} else if (barcodeMainList.get(0).getBarcodeStatusDictId().equals(EnumBarcodeStatus.OFFSTORE.getValue())) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("该标签已下架！");
				}else if (barcodeMainList.get(0).getBarcodeStatusDictId().equals(EnumBarcodeStatus.OUTSTORE.getValue())){
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("该标签已出库！");
				}else {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("该标签不属于上架状态！");
				}
				
				
			}
		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}

		return resultMessage;
	}
	
	
	/**
	 * @auther:Chenzj
	 * @version:2019年5月09日上午10:48:29
	 * @param: NPSTOREID 去重选择仓库的标志
	 * @description pda选择仓库时，筛选已选择的源仓库
	 */
	@ResponseBody
	@RequestMapping(value = "/warehosueList", method = RequestMethod.POST)
	public ResultMessage getWarehosueList(HttpServletRequest request, Long NPSTOREID,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<StructWarehouseVo> barcodeMainList = new ArrayList<StructWarehouseVo>();
		StructWarehouseParamVo paramVo = new StructWarehouseParamVo();
		paramVo.setNpstoreId(NPSTOREID);
		try {
			barcodeMainList = clientStructWarehouseService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (barcodeMainList.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无仓库信息");
			} else {
				resultMessage.put(barcodeMainList);
				resultMessage.setIsSuccess(true);
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
	 * @auther:Chenzj
	 * @version:2019年5月04日下午8:50:04
	 * @param: barcodestr:扫描标签拼接字符串
	 * @param: billItemstr:标签所属调拨明细Id字符串
	 * @param: billId:调拨单
	 * @param: fromWarehouseId:源仓库
	 * @param: toWarehouseId:目标仓库
	 * @description 根据扫描标签进行下架出库并生成调拨出库单和相应的调拨上架单
	 */
	@ResponseBody
	@RequestMapping(value = "/allocationBarcodeListOutput", method = RequestMethod.POST)
	public ResultMessage AllocationBarcodeListOutput(HttpServletRequest request,String barcodestr,String billItemstr,Long billId,Long fromWarehouseId,Long  toWarehouseId,Long factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BarcodeMain> barcodeList=new ArrayList<BarcodeMain>();
        String[] barcodeItem = extractMessageByRegular(barcodestr).split(",");
        String[] billAllItem = extractMessageByRegular(billItemstr).split(",");
        Integer index = 0;
        for(String barcodeItems : barcodeItem){
        	BarcodeMain sample= new BarcodeMain();
        	sample.setBarcode(barcodeItems);
        	sample.setBillItemId(Long.parseLong(billAllItem[index]));
        	sample.setBillId(billId);
        	barcodeList.add(sample);
        	index++;
        	
        };
		
		resultMessage=clientBillWarehouseService.allocationOutput(barcodeList, fromWarehouseId,toWarehouseId,factoryId,this.getCommonParam(request));
		return resultMessage;
	}
	
	
	/**
	 * @auther:Chenzj
	 * @version:2019年5月13日上午14:20:29
	 * @description 选择要入库上架的调拨单
	 */
	@ResponseBody
	@RequestMapping(value = "/billMainIn", method = RequestMethod.POST)
	public ResultMessage getBillMainIn(HttpServletRequest request,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BillWarehouseVo> billMain = new ArrayList<BillWarehouseVo>();
		BillWarehouseParamVo paramVo = new BillWarehouseParamVo();
		paramVo.setBillTypeDictId(EnumBillType.BILL_TYPE_WAREHOUSE_IN.getValue());
		paramVo.setFromBillTypeDictId(EnumBillType.BILL_TYPE_WAREHOUSE_ALLOCATION.getValue());
		paramVo.setBillStatusDictId(EnumBillStatus.NEW.getValue());
		try {
			billMain = clientBillWarehouseService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (billMain.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无调拨上架单信息");
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
	 * @auther:Chenzj
	 * @version:2019年5月13日上午14:24:29
	 * @param: billId:调拨上架单Id
	 * @description 根据调拨单查询上架标签信息
	 */
	@ResponseBody
	@RequestMapping(value = "/billInSn", method = RequestMethod.POST)
	public ResultMessage getBillInputSn(HttpServletRequest request, Long billId,String factoryId) {
		
		ResultMessage resultMessage = new ResultMessage();
		List<TrackBarcodeVo> billSn = new ArrayList<TrackBarcodeVo>();
		TrackBarcodeParamVo paramVo = new TrackBarcodeParamVo();
		paramVo.setBillId(billId);
		paramVo.setIsWarehouseId("0");
		paramVo.setBarcodePackboxId((long) 0);
		try {
			billSn = clientTrackBarcodeService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (billSn.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无此单据标签信息");
			} else {
				resultMessage.put(billSn);
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
	 * @auther:Chenzj
	 * @version:2019年5月04日下午8:50:04
	 * @param:barcode:标签
	 * @param:locationId:货位Id
	 * @param:warehouseId:仓库Id
	 * @description 根据扫描标签上架
	 */
	@ResponseBody
	@RequestMapping(value = "/allocationBarcodeInput", method = RequestMethod.POST)
	public ResultMessage onBarcode(HttpServletRequest request,String barcode,Long locationId,Long warehouseId,Long billId,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		
		TrackBarcodeVo trackBarcodeVo=new TrackBarcodeVo();
		trackBarcodeVo.setBarcode(barcode);
		trackBarcodeVo.setLocationId(Long.valueOf(locationId));
		trackBarcodeVo.setWarehouseId(Long.valueOf(warehouseId));
		trackBarcodeVo.setBillId(billId);
		resultMessage=clientBillWarehouseService.allocationnBillBarcodeInput(trackBarcodeVo, this.getCommonParam(request));
		return resultMessage;
	}
	
	
	/**
	 * @auther:Chenzj
	 * @version:2019年5月09日上午10:48:29
	 * @param: barcode 物料标签
	 * @description pda扫描物料标签返回信息
	 */
	@ResponseBody
	@RequestMapping(value = "/transpositionBarcodeScan", method = RequestMethod.POST)
	public ResultMessage transpositionBarcodeScan(HttpServletRequest request, String barcode,String factoryId) {
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
				
				//判断标签的状态是否是上架状态，其他状态均不可下架
                if (barcodeMainList.get(0).getBarcodeStatusDictId().equals(EnumBarcodeStatus.INSTORE.getValue())) {
                	
                	//判断标签是否为最外层箱号
                	 if(barcodeMainList.get(0).getBarcodePackboxId()==0){
                		 resultMessage.put(barcodeMainList);
     					 resultMessage.setIsSuccess(true);
                	 }else{
                		 resultMessage.setIsSuccess(false);
     					 resultMessage.addErr("请扫描最外层箱号！");
                	 }
                	 
    					
				} else if (barcodeMainList.get(0).getBarcodeStatusDictId().equals(EnumBarcodeStatus.OFFSTORE.getValue())) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("该标签已下架！");
				}else if (barcodeMainList.get(0).getBarcodeStatusDictId().equals(EnumBarcodeStatus.OFFSTORE.getValue())){
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("该标签已出库！");
				}else if (barcodeMainList.get(0).getBarcodeStatusDictId().equals(EnumBarcodeStatus.NEW.getValue())){
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("该标签暂未入库！");
				}
				
				
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
	*@version:2019年5月30日下午1:35:57
	*@param request
	*@param barcode       物料标签
	*@param locationId    货位ID
	*@param warehouseId   仓库ID
	*@return
	*@description  扫描物料标签进行同仓库移位
	*/
	@ResponseBody
	@RequestMapping(value = "/allocationTransposition", method = RequestMethod.POST)
	public ResultMessage transposition(HttpServletRequest request,String barcode,Long locationId,Long warehouseId,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		
		BarcodeMain barcodeMain=new BarcodeMain();
		barcodeMain.setBarcode(barcode);
		barcodeMain.setLocationId(Long.valueOf(locationId));
		barcodeMain.setWarehouseId(Long.valueOf(warehouseId));
		resultMessage=clientBarcodeMainService.barcodeTransposition(barcodeMain, this.getCommonParam(request));
		return resultMessage;
	}
	
}
