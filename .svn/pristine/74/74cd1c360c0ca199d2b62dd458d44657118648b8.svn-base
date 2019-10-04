package com.techsoft.service.bill;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumAuditStatus;
import com.techsoft.common.enums.EnumBarcodeRule;
import com.techsoft.common.enums.EnumBarcodeStatus;
import com.techsoft.common.enums.EnumBillStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.dao.barcode.BarcodeMainDao;
import com.techsoft.dao.bill.BillWarehouseDao;
import com.techsoft.dao.bill.BillWarehouseItemDao;
import com.techsoft.dao.config.ConfigCodeRuleDao;
import com.techsoft.dao.history.HistoryBillStatusDao;
import com.techsoft.dao.track.TrackBarcodeDao;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.TrackBarcode;

/**
 * @auther:Wang
 * @version:2019年7月8日下午2:06:22
 * @param:
 * @description
 */
@Service
public class BillWarehouseDiscardedServiceImpl extends BaseServiceImpl<BillWarehouse>
		implements BillWarehouseDiscardedService {
	@Autowired
	private BillWarehouseDao billWarehouseDao;
	@Autowired
	private BarcodeMainDao barcodeMainDao;
	@Autowired
	private TrackBarcodeDao trackBarcodeDao;
	@Autowired
	private BillWarehouseItemDao billWarehouseItemDao;
	@Autowired
	private ConfigCodeRuleDao configCodeRuleDao;
	@Autowired
	private HistoryBillStatusDao historyBillStatusDao;

	@Override
	public BaseDao<BillWarehouse> getBaseDao() {
		return billWarehouseDao;
	}

	@Override
	public Class<BillWarehouse> getEntityClass() {
		return BillWarehouse.class;
	}

	@Override
	public ResultMessage insertDiscarded(List<BarcodeMain> list, Long factoryId, CommonParam commonParam)
			throws BusinessException, SQLException {
		ResultMessage resultMessage = new ResultMessage();
		List<BillWarehouseItem> itemDiscardedList = new ArrayList<>();

		// 生成报废单主表信息
		List<BarcodeMain> barcodeList = new ArrayList<BarcodeMain>();
		for (BarcodeMain barcodeMain : list) {
			List<BarcodeMain> barcode = new ArrayList<BarcodeMain>();
			BarcodeMainParamVo paramVo = new BarcodeMainParamVo();
			paramVo.setBarcode(barcodeMain.getBarcode());
			barcode = barcodeMainDao.selectListByParamVo(paramVo);
			List<BarcodeMain> returnList = this.getInsideBarcode(barcode.get(0), commonParam);

			barcodeList.addAll(returnList);
		}
		String billDiscarded = configCodeRuleDao.createCode(BillWarehouse.class.getName(),
				EnumBillType.BILL_TYPE_WAREHOUSE_DISCARDED.getValue(), null, commonParam);

		// 生成退料单主表信息
		BillWarehouse billDiscard = new BillWarehouse();
		billDiscard.setBillCode(billDiscarded);
		billDiscard.setBillTypeDictId(EnumBillType.BILL_TYPE_WAREHOUSE_DISCARDED.getValue());
		billDiscard.setBillStatusDictId(EnumBillStatus.DOING.getValue());
		billDiscard.setAuditStatusDictId(EnumAuditStatus.AUDITED.getValue());
		billDiscard.setTypeStock("1");
		billDiscard.setTenantId(commonParam.getTenantId());
		billDiscard.setCreateUserId(Long.valueOf(commonParam.getUserId()));
		billDiscard.setModifyUserId(Long.valueOf(commonParam.getUserId()));
		billDiscard.setFactoryId(factoryId);
		BillWarehouse billRet = billWarehouseDao.insertEntity(billDiscard, commonParam);
		// 新增退料单新建、处理中状态历史表
		historyBillStatusDao.billHistoryInsert(EnumBillType.BILL_TYPE_WAREHOUSE_DISCARDED.getValue(),
				EnumBillStatus.NEW.getValue(), billRet.getId(),billRet.getBillCode(), commonParam);
		historyBillStatusDao.billHistoryInsert(EnumBillType.BILL_TYPE_WAREHOUSE_DISCARDED.getValue(),
				EnumBillStatus.DOING.getValue(), billRet.getId(),billRet.getBillCode(), commonParam);
		// 根据物料分组
		Map<Long, List<BarcodeMain>> barcodeMap = new HashMap<>();
		for (BarcodeMain barcodeMain : barcodeList) {
			
			barcodeMain.setBillId(billRet.getId());
			barcodeMain.setBarcodeStatusDictId(EnumBarcodeStatus.OFFSTORE.getValue());
			barcodeMain.setBillStatusDictId(EnumBillStatus.DOING.getValue());
			barcodeMain.setBillTypeDictId(EnumBillType.BILL_TYPE_WAREHOUSE_DISCARDED.getValue());
			
			if (barcodeMap.containsKey(barcodeMain.getMaterialId())) {
				barcodeMap.get(barcodeMain.getMaterialId()).add(barcodeMain);
			} else {
				List<BarcodeMain> materlist = new ArrayList<>();
				materlist.add(barcodeMain);
				barcodeMap.put(barcodeMain.getMaterialId(), materlist);
			}
			
		}

		

		Integer discardedIndex = 0;
		String idDiscardedString = "";
		Long idDiscarded = 0L;
		Long discardedItemId = billWarehouseItemDao.getIdValue();
		DecimalFormat locationdf = new DecimalFormat("000000");

		for (Entry<Long, List<BarcodeMain>> m : barcodeMap.entrySet()) {
			List<BarcodeMain> matlist = m.getValue();
			BillWarehouseItem billWarehouseItem = new BillWarehouseItem();
			discardedIndex++;
			idDiscardedString = locationdf.format(discardedIndex);
			idDiscarded = Long.valueOf(discardedItemId.toString() + idDiscardedString);
			billWarehouseItem.setId(idDiscarded);
			billWarehouseItem.setBillId(billRet.getId());
			billWarehouseItem.setBillStatusDictId(EnumBillStatus.DOING.getValue());
			Double sumQuantity = 0.0;
			for (BarcodeMain barcodeMain : matlist) {
				// 如果为最外箱 或者为最底层物料 统计数量
				if (barcodeMain.getBarcodePackboxId() == 0) {
					sumQuantity += barcodeMain.getQuantity();
				}
			}
			billWarehouseItem.setMaterialId(matlist.get(0).getMaterialId());
			billWarehouseItem.setQuantityFinish(0.0);
			billWarehouseItem.setQuantityScan(sumQuantity);
			billWarehouseItem.setQuantity(sumQuantity);
			billWarehouseItem.setTenantId(commonParam.getTenantId());
			billWarehouseItem.setCreateUserId(Long.valueOf(commonParam.getUserId()));
			billWarehouseItem.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			itemDiscardedList.add(billWarehouseItem);
		}
		for (BarcodeMain barcode : barcodeList) {
			for (BillWarehouseItem item : itemDiscardedList) {
				if (item.getMaterialId().equals(barcode.getMaterialId())) {
					barcode.setBillItemId(item.getId());
				}
			}
		}
		
		// 批量更新下架
		barcodeMainDao.updateBatch(barcodeList, commonParam);
		// 新增退料单明细表
		billWarehouseItemDao.insertBatch(itemDiscardedList, commonParam);
		// 新增退料单条码追踪表
		List<TrackBarcode> trackDiscardedList = new ArrayList<TrackBarcode>();
		Integer barDiscardedIndex = 0;
		String idbarString = "";
		Long idbarLong = 0L;
		Long discardedBar = trackBarcodeDao.getIdValue();
		for (BarcodeMain barcodeMain : barcodeList) {
			TrackBarcode trackBarcodeItem = new TrackBarcode();
			barDiscardedIndex++;
			idbarString = locationdf.format(barDiscardedIndex);
			idbarLong = Long.valueOf(discardedBar.toString() + idbarString);
			trackBarcodeItem.setId(idbarLong);
			trackBarcodeItem.setBarcode(barcodeMain.getBarcode());
			trackBarcodeItem.setBillId(billRet.getId());
			for (BillWarehouseItem returnItem : itemDiscardedList) {
				if (barcodeMain.getMaterialId().equals(returnItem.getMaterialId())) {
					trackBarcodeItem.setBillItemId(returnItem.getId());
				}
			}
			trackBarcodeItem.setFactoryId(barcodeMain.getFactoryId());
			trackBarcodeItem.setBarcodeStatusDictId(EnumBarcodeStatus.OFFSTORE.getValue());
			trackBarcodeItem.setBarcodePackboxId(barcodeMain.getBarcodePackboxId());
			trackBarcodeItem.setBarcodeRuleDictId(barcodeMain.getBarcodeRuleDictId());
			trackBarcodeItem.setBillTypeDictId(EnumBillType.BILL_TYPE_WAREHOUSE_DISCARDED.getValue());
			trackBarcodeItem.setMaterialId(barcodeMain.getMaterialId());
			trackBarcodeItem.setProductId(barcodeMain.getProductId());
			trackBarcodeItem.setQuantity(barcodeMain.getQuantity());
			trackBarcodeItem.setBillStatusDictId(EnumBillStatus.DOING.getValue());
			trackBarcodeItem.setTenantId(barcodeMain.getTenantId());
			trackBarcodeItem.setCreateUserId(Long.valueOf(commonParam.getUserId()));
			trackBarcodeItem.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			trackDiscardedList.add(trackBarcodeItem);
		}
		trackBarcodeDao.insertBatchSn(trackDiscardedList, commonParam);
		resultMessage.setIsSuccess(true);
		return resultMessage;
	}

	private List<BarcodeMain> getInsideBarcode(BarcodeMain barcodeMain, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BarcodeMain> barCodeList = new ArrayList<BarcodeMain>();
		// 将当前扫描条码记录
		// 如果扫描为包装箱 遍历取得内置所有条码
		barCodeList.add(barcodeMain);
		
		if (barcodeMain.getBarcodeRuleDictId().equals(EnumBarcodeRule.PRODUCT_PACKBOX.getValue())) {
			// 遍历方法
			recursion(barcodeMain.getId(), commonParam, barCodeList);
		}
		return barCodeList;
	}

	/**
	 * @auther:Wang
	 * @version:2019年5月27日下午4:13:54
	 * @param:
	 * @description 递归查询外箱里面的所有标签
	 */
	private void recursion(Long parentId, CommonParam commonParam, List<BarcodeMain> listBarcode) {
		BarcodeMainParamVo paramVo = new BarcodeMainParamVo();
		paramVo.setBarcodePackboxId(parentId);
		try {
			List<BarcodeMain> packBoxlist = barcodeMainDao.selectListByParamVo(paramVo);
			for (BarcodeMain barcodeMain : packBoxlist) {
				if (barcodeMain.getBarcodeStatusDictId().equals(EnumBarcodeStatus.OFFSTORE.getValue())) {
					throw new BusinessException("条码" + barcodeMain.getBarcode() + "已执行过报废");
				}
				listBarcode.add(barcodeMain);
				if (barcodeMain.getBarcodeRuleDictId().equals(EnumBarcodeRule.PRODUCT_PACKBOX.getValue())) {
					recursion(barcodeMain.getId(), commonParam, listBarcode);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
}
