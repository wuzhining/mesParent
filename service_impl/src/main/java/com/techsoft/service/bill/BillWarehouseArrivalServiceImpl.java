package com.techsoft.service.bill;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumAuditStatus;
import com.techsoft.common.enums.EnumBillStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.enums.EnumSampleRule;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.dao.bill.BillInspectDao;
import com.techsoft.dao.bill.BillWarehouseDao;
import com.techsoft.dao.bill.BillWarehouseItemDao;
import com.techsoft.dao.config.ConfigCodeRuleDao;
import com.techsoft.dao.history.HistoryBillStatusAuditDao;
import com.techsoft.dao.history.HistoryBillStatusDao;
import com.techsoft.dao.product.ProductMaterialDao;
import com.techsoft.dao.quality.QualityInspectModuleRelationDao;
import com.techsoft.dao.quality.QualitySampleLevelDao;
import com.techsoft.dao.quality.QualitySampleRuleDao;
import com.techsoft.dao.quality.QualitySampleRuleItemDao;
import com.techsoft.dao.track.TrackBarcodeDao;
import com.techsoft.entity.bill.BillWarehouseItemParamVo;
import com.techsoft.entity.bill.BillWarehouseVo;
import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillInventory;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.QualityInspectModuleRelation;
import com.techsoft.entity.common.QualitySampleLevel;
import com.techsoft.entity.common.QualitySampleRule;
import com.techsoft.entity.common.QualitySampleRuleItem;
import com.techsoft.entity.quality.QualityInspectModuleRelationParamVo;
import com.techsoft.entity.quality.QualitySampleLevelParamVo;
import com.techsoft.entity.quality.QualitySampleRuleItemParamVo;
import com.techsoft.entity.quality.QualitySampleRuleParamVo;
import com.techsoft.service.history.HistoryBillStatusAuditService;

/**
*@auther:Chenzj
*@version:2019年5月27日下午2:52:24
*@param:
*@description
*/
@Service
public class BillWarehouseArrivalServiceImpl extends BaseServiceImpl<BillWarehouse> implements BillWarehouseArrivalService {
	@Autowired
	private BillWarehouseDao billWarehouseDao;
	@Autowired
	private QualitySampleRuleItemDao qualitySampleRuleItemDao;
	@Autowired
	private TrackBarcodeDao trackBarcodeDao;
	@Autowired
	private BillWarehouseItemDao billWarehouseItemDao; 
	@Autowired
	private BillInspectDao billInspectDao;
	@Autowired
	private ProductMaterialDao productMaterialDao;
	@Autowired
	private QualityInspectModuleRelationDao qualityInspectModuleRelationDao;
	@Autowired
	private QualitySampleLevelDao qualitySampleLevelDao;
	@Autowired
	private QualitySampleRuleDao qualitySampleRuleDao;
	@Autowired
	private ConfigCodeRuleDao configCodeRuleDao;
	@Autowired
	private HistoryBillStatusDao historyBillStatusDao;
	@Autowired
	private HistoryBillStatusAuditDao historyBillStatusAuditDao;
	@Override
	public BaseDao<BillWarehouse> getBaseDao() {
		return billWarehouseDao;
	}

	@Override
	public Class<BillWarehouse> getEntityClass() {
		return BillWarehouse.class;
	}
	

	/**
	*@auther:Chen
	*@version:2019年5月29日下午4:42:33
	*@param billId       来料单据ID
	*@param detailList   来料单明细List
	*@param commonParam
	*@return  List<BillInspect> 质检单List
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	private List<BillInspect> insertBillInspectBatch(Long billId,Long factoryId, List<BillWarehouseItem> detailList,CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillInspect> returnList = new ArrayList<BillInspect>();
		DecimalFormat df=new DecimalFormat("0000");
		Integer index = 0;
		String idString = "";
		String billCodeLong = "";
		Long idLong = 0L;
		Long billInspectId=billInspectDao.getIdValue();
		
		
		List<BillWarehouseItem> Itemlist = new ArrayList<BillWarehouseItem>();
		BillWarehouseItemParamVo billWarehouseItem =new BillWarehouseItemParamVo();
		billWarehouseItem.setBillId(billId);
		Itemlist=billWarehouseItemDao.selectListByParamVo(billWarehouseItem);
		
		BillWarehouse billWarehouse =new BillWarehouse();
		billWarehouse=billWarehouseDao.selectById(billId);
		
		for (BillWarehouseItem item : Itemlist) {
			
			List<BillInspect> billlist = new ArrayList<BillInspect>();
			BillInspect billInspect = new BillInspect();
		
			index++;
			idString=df.format(index);
			idLong = Long.valueOf(billInspectId.toString() + idString);
			billCodeLong=configCodeRuleDao.createCode(BillInspect.class.getName(),null, null,commonParam);
			billInspect.setId(idLong);
			billInspect.setTenantId(commonParam.getTenantId());
			billInspect.setInspectCode(billCodeLong);
			billInspect.setSupplierId(billWarehouse.getPartnerId());
			billInspect.setFromBillTypeDictId(billWarehouse.getBillTypeDictId());
			billInspect.setFromBillId(billId);
			billInspect.setFactoryId(factoryId);
			//查询单据号
			BillWarehouse bill= billWarehouseDao.selectById(billId);
			billInspect.setFromBillCode(bill.getBillCode());
			billInspect.setInspectStatusDictId(EnumBillStatus.NEW.getValue());
			billInspect.setMaterialId(item.getMaterialId());
			billInspect.setQuantity(item.getQuantity());
			billInspect.setInspectModeDictId(EnumSampleRule.COMMON.getValue());
			billInspect.setAuditStatusDictId(EnumAuditStatus.UNAUDITED.getValue());
			billInspect.setQuantitySampleFail(0.0);
			//取规则抽检最大数量
			for (BillWarehouseItem items : detailList) {
				if (item.getMaterialId().equals(items.getMaterialId())) {
					billInspect.setQuantitySample(items.getQuantityScan());
				}
			}
			
			billInspect.setCreateUserId(Long.valueOf(commonParam.getUserId()));
			billInspect.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			
			billlist.add(billInspect);
			billInspectDao.insertBillInspectBatch(billlist, commonParam);
			returnList.addAll(billlist);
		}
		
		return returnList;
	}
	
	// 来料审核生成质检单相关数据
	@Override
	public ResultMessage billCheck(BillWarehouseVo billWarehouseVo,CommonParam commonParam) throws BusinessException, SQLException {
			ResultMessage resultMessage = new ResultMessage();
				    // 审核单据生成质检单
				    //完结到货单
					billWarehouseDao.updateBillStatusMain(billWarehouseVo.getId(), EnumBillStatus.FINISHED.getValue(), commonParam);
					//新增到货单完结状态的历史表
					//查询单据号
					BillWarehouse bill=billWarehouseDao.selectById(billWarehouseVo.getId());
					historyBillStatusDao.billHistoryInsert(EnumBillType.BILL_TYPE_WAREHOUSE_ARRIVAL.getValue(), EnumBillStatus.FINISHED.getValue(), billWarehouseVo.getId(), bill.getBillCode(),commonParam);
					billWarehouseItemDao.updateBillItemStatus(billWarehouseVo.getId(), EnumBillStatus.FINISHED.getValue(), commonParam);
					trackBarcodeDao.updateTrackStatus(billWarehouseVo.getId(), EnumBillStatus.FINISHED.getValue(), commonParam);

					// 根据明细物料数量取抽样数
					List<BillWarehouseItem> detailList = new ArrayList<BillWarehouseItem>();
					detailList = this.getInspectModual(billWarehouseVo.getId(), commonParam);
					
					// 生成质检单主表以及明细表
					List<BillInspect> InspectList = new ArrayList<BillInspect>();
					InspectList = this.insertBillInspectBatch(billWarehouseVo.getId(),bill.getFactoryId(), detailList,commonParam);
					for (BillInspect billInspect : InspectList) {
						//新增质检单新建状态的历史表
						//查询单据号
						BillInspect billInpect=billInspectDao.selectById(billInspect.getId());
						historyBillStatusDao.billHistoryInsert(EnumBillType.BILL_TYPE_EXAMINE.getValue(), EnumBillStatus.NEW.getValue(), billInspect.getId(),billInpect.getInspectCode(), commonParam);
						//新增检验单待审核状态的历史表
						historyBillStatusAuditDao.billHistoryInsert(EnumBillType.BILL_TYPE_EXAMINE.getValue(), EnumAuditStatus.UNAUDITED.getValue(), billInpect.getId(), billInpect.getInspectCode(), commonParam);
					}
					
					// 生成质检条码表
					trackBarcodeDao.insertIqcSnlist(billWarehouseVo.getId(), InspectList, commonParam);

					resultMessage.setIsSuccess(true);
			        return resultMessage;
		}


	// 来料打印审核处理中
	@Override
	public ResultMessage printCheck(BillWarehouseVo billWarehouseVo,CommonParam commonParam) throws BusinessException, SQLException {
			ResultMessage resultMessage = new ResultMessage();
			
			billWarehouseItemDao.updateBillItemStatus(billWarehouseVo.getId(), EnumBillStatus.DOING.getValue(), commonParam);
			billWarehouseDao.updateBillStatusMain(billWarehouseVo.getId(), EnumBillStatus.DOING.getValue(), commonParam);
			//新增单据状态历史表
			//查询单据号
			BillWarehouse bill=billWarehouseDao.selectById(billWarehouseVo.getId());
		    historyBillStatusDao.billHistoryInsert(EnumBillType.BILL_TYPE_WAREHOUSE_ARRIVAL.getValue(), EnumBillStatus.DOING.getValue(), billWarehouseVo.getId(),bill.getBillCode(), commonParam);
		    
						resultMessage.setIsSuccess(true);
				        return resultMessage;
			}
	
	/**
	*@auther:Chen
	*@version:2019年5月29日下午4:02:57
	*@param  billId   来料单ID
	*@description  根据来料单的明细信息获取抽检样本数
	*/
	private List<BillWarehouseItem> getInspectModual(Long billId, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillWarehouseItem> list = new ArrayList<BillWarehouseItem>();

		// 根据单据查询明细
		List<BillWarehouseItem> itemList = new ArrayList<BillWarehouseItem>();
		BillWarehouseItemParamVo itemParamVo = new BillWarehouseItemParamVo();
		itemParamVo.setBillId(billId);
		itemList = billWarehouseItemDao.selectListByParamVo(itemParamVo);

		// 根据单号取主表数据
		BillWarehouse billMain = new BillWarehouse();
		billMain = billWarehouseDao.selectById(billId, commonParam);

		for (BillWarehouseItem billWarehouseItem : itemList) {
			// 根据物料取分类
			ProductMaterial materialMain = new ProductMaterial();
			materialMain = productMaterialDao.selectById(billWarehouseItem.getMaterialId());

			// 取全部规则
			List<QualityInspectModuleRelation> modualList = new ArrayList<QualityInspectModuleRelation>();

			List<QualityInspectModuleRelation> modualSupList = new ArrayList<QualityInspectModuleRelation>();
			QualityInspectModuleRelationParamVo modualSupParamVo = new QualityInspectModuleRelationParamVo();
			modualSupParamVo.setSupplierId(billMain.getPartnerId());
			modualSupList = qualityInspectModuleRelationDao.selectListByParamVo(modualSupParamVo);
			modualList.addAll(modualSupList);

			List<QualityInspectModuleRelation> modualMatList = new ArrayList<QualityInspectModuleRelation>();
			QualityInspectModuleRelationParamVo modualMatParamVo = new QualityInspectModuleRelationParamVo();
			modualMatParamVo.setProductId(materialMain.getProductId());
			modualMatList = qualityInspectModuleRelationDao.selectListByParamVo(modualMatParamVo);
			modualList.addAll(modualMatList);

			List<QualityInspectModuleRelation> modualProClassList = new ArrayList<QualityInspectModuleRelation>();
			QualityInspectModuleRelationParamVo modualClassParamVo = new QualityInspectModuleRelationParamVo();
			modualClassParamVo.setProductClassesId(materialMain.getProductTypeDictId());
			modualProClassList = qualityInspectModuleRelationDao.selectListByParamVo(modualClassParamVo);
			modualList.addAll(modualProClassList);

			double reqIqcQty = 0;
			// 根据规则取抽检样本最大数
			for (QualityInspectModuleRelation qualityInspectModuleRelation : modualList) {

				String materialQty = String.valueOf(billWarehouseItem.getQuantity());

				QualitySampleLevelParamVo qualitySampleLevelParamVo = new QualitySampleLevelParamVo();
				List<QualitySampleLevel> qualitySampleLevel = new ArrayList<QualitySampleLevel>();
				qualitySampleLevelParamVo.setCompareQty(materialQty);
				qualitySampleLevelParamVo
						.setSampleLevelRankDictId(qualityInspectModuleRelation.getSampleLevelRankDictId());
				qualitySampleLevel = qualitySampleLevelDao.selectListByParamVo(qualitySampleLevelParamVo);

				QualitySampleRuleItemParamVo qualitySampleRuleItemParamVo = new QualitySampleRuleItemParamVo();
				List<QualitySampleRuleItem> qualitySampleRuleItem = new ArrayList<QualitySampleRuleItem>();
				QualitySampleRuleParamVo qualitySampleRuleParamVo = new QualitySampleRuleParamVo();
				List<QualitySampleRule> qualitySampleRule = new ArrayList<QualitySampleRule>();

				qualitySampleRuleParamVo.setInspectModeDictId(EnumSampleRule.COMMON.getValue());
				qualitySampleRule = qualitySampleRuleDao.selectListByParamVo(qualitySampleRuleParamVo);

				qualitySampleRuleItemParamVo.setSampleLetter(qualitySampleLevel.get(0).getSampleLetter());
				qualitySampleRuleItemParamVo.setSampleRuleId(qualitySampleRule.get(0).getId());
				qualitySampleRuleItem = qualitySampleRuleItemDao.selectListByParamVo(qualitySampleRuleItemParamVo);

				if (qualitySampleRuleItem.get(0).getQuantity() >= reqIqcQty) {
					reqIqcQty = qualitySampleRuleItem.get(0).getQuantity();
				}

			}

			BillWarehouseItem detailList = new BillWarehouseItem();
			detailList.setMaterialId(billWarehouseItem.getMaterialId());
			detailList.setQuantity(billWarehouseItem.getQuantity());
			detailList.setQuantityScan(reqIqcQty);
			list.add(detailList);

		}

		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
}
