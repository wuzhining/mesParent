package com.techsoft.controller.pda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techsoft.client.service.barcode.ClientBarcodeMainService;
import com.techsoft.client.service.bill.ClientBillWarehouseItemService;
import com.techsoft.client.service.bill.ClientBillWarehouseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumBarcodeStatus;
import com.techsoft.common.enums.EnumBillStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.enums.EnumYesOrNo;
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
import com.techsoft.entity.track.TrackBarcodeParamVo;
import com.techsoft.entity.track.TrackBarcodeVo;
import com.techsoft.service.barcode.BarcodeMainService;

/**
 * @auther:Wang
 * @version:2019年4月26日上午10:33:10
 * @param:
 * @description pda出库请求controller层
 */
@Controller
@RequestMapping("/pda/pdaOutStore")
public class PdaOutStoreController extends BaseController {
	@Autowired
	private ClientBillWarehouseService clientBillWarehouseService;
	@Autowired
	private ClientBillWarehouseItemService clientBillWarehouseItemService;
	@Autowired
	private ClientBarcodeMainService clientBarcodeMainService;

	/**
	 * @auther:Wang
	 * @version:2019年4月26日上午10:48:29
	 * @param:billCode 单据编码
	 * @param:billTypeDictId 单据类型(参考数据字典)
	 * @description pda查询领料单接口返回领料单json
	 */
	@ResponseBody
	@RequestMapping(value = "/billList", method = RequestMethod.POST)
	public ResultMessage getBillList(HttpServletRequest request, String billCode, String billTypeDictId, String billAuditStauts,Long factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BillWarehouseVo> billWarehouseList = new ArrayList<BillWarehouseVo>();
		BillWarehouseParamVo paramVo = new BillWarehouseParamVo();
		if (factoryId == null) {
			resultMessage.addErr("工厂不能为空");
			return resultMessage;
		}
		paramVo.setBillCode(billCode);
		paramVo.setBillTypeDictId(Long.valueOf(billTypeDictId));
		if (billAuditStauts != null) {
			paramVo.setAuditStatusDictId(Long.valueOf(billAuditStauts));
		}
		try {
			billWarehouseList = clientBillWarehouseService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (billWarehouseList.size() <= 0) {
				resultMessage.addErr("系统无该领料单");
			}
			if (billWarehouseList.size() > 0) {
				if (billWarehouseList.get(0).getBillStatusDic().equals(EnumBillStatus.FINISHED.getValue())) {
					resultMessage.addErr("当前领料单已完结");
				} else {
					resultMessage.put(billWarehouseList);
					resultMessage.setIsSuccess(true);
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
	 * @auther:Wang
	 * @version:2019年4月26日上午11:33:09
	 * @param:
	 * @description pda根据领料单返回领料明细json
	 */
	@ResponseBody
	@RequestMapping(value = "/billItemList", method = RequestMethod.POST)
	public ResultMessage getitemList(HttpServletRequest request, String billId,Long factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BillWarehouseItemVo> billWarehouseItemList = new ArrayList<BillWarehouseItemVo>();
		BillWarehouseItemParamVo paramVo = new BillWarehouseItemParamVo();
		paramVo.setBillId(Long.valueOf(billId));
		if (factoryId == null) {
			resultMessage.addErr("工厂不能为空");
			return resultMessage;
		}
		try {
			billWarehouseItemList = clientBillWarehouseItemService.selectListVoByParamVo(paramVo,
					this.getCommonParam(request));

			resultMessage.put(billWarehouseItemList);
			resultMessage.setIsSuccess(true);
		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}
		return resultMessage;
	}

	/**
	 * @auther:Wang
	 * @version:2019年4月29日下午4:02:04
	 * @param:materialId:领料单物料编码
	 * @description 根据领料单物料编码查询出仓库中该物料的推荐库位
	 */
	@ResponseBody
	@RequestMapping(value = "/matBestLocation", method = RequestMethod.POST)
	public ResultMessage getMatBestLocation(HttpServletRequest request, String materialId,Long factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BarcodeMainVo> barcodeList = new ArrayList<BarcodeMainVo>();
		if (factoryId == null) {
			resultMessage.addErr("工厂不能为空");
			return resultMessage;
		}
		try {
			barcodeList = clientBarcodeMainService.bestLocation(Long.parseLong(materialId),
					this.getCommonParam(request));
			resultMessage.put(barcodeList);
			resultMessage.setIsSuccess(true);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}
		return resultMessage;
	}

	/**
	 * @auther:Wang
	 * @version:2019年5月13日上午10:18:00
	 * @param:materialId 物料Id
	 ** @param:billId 领料单id
	 ** @param:billItemId 领料明细id
	 * @description 查询当前领料明细下架的条码
	 */
	@ResponseBody
	@RequestMapping(value = "/getOffBarcode", method = RequestMethod.POST)
	public ResultMessage getOffBarcode(HttpServletRequest request, String materialId, String billId,
			String billItemId,Long factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BarcodeMainVo> barcodeList = new ArrayList<BarcodeMainVo>();
		BarcodeMainParamVo paramVo = new BarcodeMainParamVo();
		if (factoryId == null) {
			resultMessage.addErr("工厂不能为空");
			return resultMessage;
		}
		long barcodeStatus = EnumBarcodeStatus.OFFSTORE.getValue();// 下架状态
		long barcodePackbox = 0;// 最外箱
		paramVo.setBarcodeStatusDictId(barcodeStatus);
		paramVo.setMaterialId(Long.valueOf(materialId));
		paramVo.setBarcodePackboxId(barcodePackbox);
		paramVo.setInstoreDateDesc(EnumYesOrNo.YES.getValue());// 排序
		paramVo.setBillId(Long.parseLong(billId));
		paramVo.setBillItemId(Long.parseLong(billItemId));
		try {
			barcodeList = clientBarcodeMainService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			resultMessage.put(barcodeList);
			resultMessage.setIsSuccess(true);
		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}
		return resultMessage;
	}

	/**
	 * @auther:Wang
	 * @version:2019年5月13日下午1:57:14
	 * @param:
	 * @description 根据条件得到条码数量
	 */
	@ResponseBody
	@RequestMapping(value = "/getInventory", method = RequestMethod.POST)
	public ResultMessage getInventory(HttpServletRequest request, String materialId,Long factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		BarcodeMainParamVo paramVo = new BarcodeMainParamVo();
		paramVo.setMaterialId(Long.valueOf(materialId));
		if (factoryId == null) {
			resultMessage.addErr("工厂不能为空");
			return resultMessage;
		}
		try {
			resultMessage.setResultCode(clientBarcodeMainService.getInventory(paramVo, this.getCommonParam(request)));
			resultMessage.setIsSuccess(true);
		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}
		return resultMessage;
	}

	/**
	 * @auther:Wang
	 * @version:2019年4月30日下午1:28:50
	 * @param:materialId 物料ID
	 * @param:barcode 扫描标签
	 * @param:billId 单据ID
	 * @param:billItemId 单据明细ID
	 * @description pda扫描标签进行下架
	 */
	@ResponseBody
	@RequestMapping(value = "/offBarcode", method = RequestMethod.POST)
	public ResultMessage offBarcode(HttpServletRequest request, String materialId, String barcode, String billId,
			String billItemId,Long factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		BarcodeMainVo barcodeMainVo = new BarcodeMainVo();
		if (factoryId == null) {
			resultMessage.addErr("工厂不能为空");
			return resultMessage;
		}
		barcodeMainVo.setMaterialId(Long.valueOf(materialId));
		barcodeMainVo.setBarcode(barcode);
		barcodeMainVo.setBillId(Long.valueOf(billId));
		barcodeMainVo.setBillItemId(Long.valueOf(billItemId));
		resultMessage = clientBarcodeMainService.offBarcode(barcodeMainVo, this.getCommonParam(request));
		return resultMessage;
	}

	/**
	 * @auther:Wang
	 * @version:2019年5月7日上午8:54:17
	 * @param:billId 领料单ID
	 * @description pda领料出库 完结领料
	 */
	@ResponseBody
	@RequestMapping(value = "/outBarcode", method = RequestMethod.POST)
	public ResultMessage outBarcode(HttpServletRequest request, String billId,Long factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		if (factoryId == null) {
			resultMessage.addErr("工厂不能为空");
			return resultMessage;
		}
		try {
			resultMessage = clientBarcodeMainService.outBarcode(billId,factoryId, this.getCommonParam(request));
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	/**
	 * @auther:Wang
	 * @version:2019年7月8日下午1:38:11
	 * @param:
	 * @description 报废出库扫码条码获得标签信息
	 */
	@ResponseBody
	@RequestMapping(value = "/barcodeDiscardedScan", method = RequestMethod.POST)
	public ResultMessage discardedScan(HttpServletRequest request, String barcode,Long factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BarcodeMainVo> barcodeMainList = new ArrayList<BarcodeMainVo>();
		BarcodeMainParamVo paramVo = new BarcodeMainParamVo();
		if (factoryId == null) {
			resultMessage.addErr("工厂不能为空");
			return resultMessage;
		}
		paramVo.setBarcode(barcode);
		try {

			// 查找标签信息，根据返回结果判断是否有数据
			barcodeMainList = clientBarcodeMainService.selectListVoByParamVo(paramVo, this.getCommonParam(request));
			if (barcodeMainList.size() == 0) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无此标签信息");

			} else {

				// 判断标签的状态是否是上架状态，其他状态均不可出库
				if (barcodeMainList.get(0).getBarcodeStatusDictId().equals(EnumBarcodeStatus.INSTORE.getValue())) {

					if (barcodeMainList.get(0).getBarcodePackboxId() == 0) {

						resultMessage.put(barcodeMainList);
						resultMessage.setIsSuccess(true);

					} else {
						resultMessage.setIsSuccess(false);
						resultMessage.addErr("请扫描最外层箱号！");
					}

				} else if (barcodeMainList.get(0).getBarcodeStatusDictId()
						.equals(EnumBarcodeStatus.OFFSTORE.getValue())) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("该标签处于下架状态！");
				} else if (barcodeMainList.get(0).getBarcodeStatusDictId()
						.equals(EnumBarcodeStatus.OUTSTORE.getValue())) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("该标签处于出库状态！");
				} else {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("该标签不属于在库状态！");
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
	 * @auther:Wang
	 * @version:2019年7月8日下午1:54:01
	 * @param:barcodeStr 批量拼接扫描标签字符串
	 * @description 批量拼接扫描标签传回，生成报废出库单
	 */
	@ResponseBody
	@RequestMapping(value = "/outDiscarded", method = RequestMethod.POST)
	public ResultMessage outDiscarded(HttpServletRequest request, String barcodeStr,Long factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		List<BarcodeMain> barcodeList = new ArrayList<BarcodeMain>();
		if (factoryId == null) {
			resultMessage.addErr("工厂不能为空");
			return resultMessage;
		}
		String[] barcodeItem = extractMessageByRegular(barcodeStr).split(",");
		for (String barcodeItems : barcodeItem) {
			BarcodeMain sample = new BarcodeMain();
			sample.setBarcode(barcodeItems);
			barcodeList.add(sample);
		}

		try {
			resultMessage = clientBillWarehouseService.discardedOutInsert(barcodeList, factoryId,this.getCommonParam(request));
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	// 截取中括号的字符串
	public static String extractMessageByRegular(String str) {
		str = str.replace("\"", "");
		str = str.replace("[", "");
		str = str.replace("]", "");
		str.split(",");
		return str;
	}

	/**
	 * @auther:wang
	 * @version:2019年6月15日上午9:09:59
	 * @param request
	 * @param barcode
	 *            扫描标签
	 * @return
	 * @description 根据扫描标签获取报废单号
	 */
	@ResponseBody
	@RequestMapping(value = "/barcodeToBill", method = RequestMethod.POST)
	public ResultMessage barcodeToBill(HttpServletRequest request, String barcode,Long factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		BarcodeMainParamVo paramVo = new BarcodeMainParamVo();
		if (factoryId == null) {
			resultMessage.addErr("工厂不能为空");
			return resultMessage;
		}
		paramVo.setBarcode(barcode);
		paramVo.setBillStatusDictId(EnumBillStatus.DOING.getValue());
		paramVo.setBillTypeDictId(EnumBillType.BILL_TYPE_WAREHOUSE_DISCARDED.getValue());
		paramVo.setBarcodeStatusDictId(EnumBarcodeStatus.OFFSTORE.getValue());
		List<BarcodeMain> codeList;
		try {
			codeList = clientBarcodeMainService.selectListByParamVo(paramVo, this.getCommonParam(request));
			if (codeList.size() <= 0) {
				resultMessage.addErr("扫描标签无报废出库单信息");
				return resultMessage;
			}
			BillWarehouseParamVo billParamVo = new BillWarehouseParamVo();
			billParamVo.setId(codeList.get(0).getBillId());
			List<BillWarehouseVo> billWarehouseList = clientBillWarehouseService.selectListVoByParamVo(billParamVo, this.getCommonParam(request));
			if (!billWarehouseList.get(0).getBillTypeDictId()
					.equals(EnumBillType.BILL_TYPE_WAREHOUSE_DISCARDED.getValue())) {
				resultMessage.addErr("扫描标签绑定单据并非报废出库单");
				return resultMessage;

			}
			resultMessage.put(billWarehouseList);
			resultMessage.setIsSuccess(true);
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		}

		return resultMessage;
	}

}
