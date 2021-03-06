package com.techsoft.service.bill;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.techsoft.common.enums.EnumProductType;
import com.techsoft.common.enums.EnumTypeStock;
import com.techsoft.common.enums.EnumWorkPlanStatus;
import com.techsoft.common.enums.EnumWorkTaskStatus;
import com.techsoft.common.enums.EnumWorkorderStatus;
import com.techsoft.common.enums.EnumYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.Arith;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.dao.barcode.BarcodeMainDao;
import com.techsoft.dao.bill.BillWarehouseDao;
import com.techsoft.dao.bill.BillWarehouseItemDao;
import com.techsoft.dao.bill.BillWorkorderDao;
import com.techsoft.dao.config.ConfigCodeRuleDao;
import com.techsoft.dao.config.ConfigDictionaryDao;
import com.techsoft.dao.equip.EquipSpecsWorkDao;
import com.techsoft.dao.equip.EquipWorkDao;
import com.techsoft.dao.history.HistoryBillStatusAuditDao;
import com.techsoft.dao.history.HistoryBillStatusDao;
import com.techsoft.dao.product.ProductBomDao;
import com.techsoft.dao.product.ProductMaterialDao;
import com.techsoft.dao.struct.StructProcedureEquipFixtureDao;
import com.techsoft.dao.struct.StructProcedureInstructDao;
import com.techsoft.dao.struct.StructProcedureMaterialDao;
import com.techsoft.dao.struct.StructProcedureWorkstationDao;
import com.techsoft.dao.struct.StructProcessDao;
import com.techsoft.dao.struct.StructProcessNodeDao;
import com.techsoft.dao.struct.StructProcessProductDao;
import com.techsoft.dao.struct.StructProdlineEquipDao;
import com.techsoft.dao.struct.StructProdlineEquipFixtureDao;
import com.techsoft.dao.struct.StructProdlineWorkstationDao;
import com.techsoft.dao.struct.StructProductionlineDao;
import com.techsoft.dao.struct.StructWorkstationDao;
import com.techsoft.dao.track.TrackBarcodeDao;
import com.techsoft.dao.work.WorkPlanEquipDao;
import com.techsoft.dao.work.WorkPlanEquipFixtureDao;
import com.techsoft.dao.work.WorkPlanMaterialDao;
import com.techsoft.dao.work.WorkPlanWorkstationDao;
import com.techsoft.dao.work.WorkTaskProcedureDao;
import com.techsoft.entity.bill.BillWarehouseParamVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.common.ProductBom;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructProcedureEquipFixture;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcedureMaterial;
import com.techsoft.entity.common.StructProcedureWorkstation;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructProcessProduct;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.common.WorkPlanEquip;
import com.techsoft.entity.common.WorkPlanEquipFixture;
import com.techsoft.entity.common.WorkPlanMaterial;
import com.techsoft.entity.common.WorkPlanWorkstation;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.entity.equip.EquipWorkParamVo;
import com.techsoft.entity.product.ProductBomParamVo;
import com.techsoft.entity.product.ProductBomVo;
import com.techsoft.entity.struct.StructProcedureEquipFixtureParamVo;
import com.techsoft.entity.struct.StructProcedureInstructParamVo;
import com.techsoft.entity.struct.StructProcedureMaterialParamVo;
import com.techsoft.entity.struct.StructProcedureWorkstationParamVo;
import com.techsoft.entity.struct.StructProcessNodeParamVo;
import com.techsoft.entity.struct.StructProcessProductParamVo;
import com.techsoft.entity.struct.StructProductionlineParamVo;
import com.techsoft.entity.track.TrackBarcodeParamVo;
import com.techsoft.entity.work.WorkTaskProcedureParamVo;

@Service
public class BillWorkorderServiceImpl extends BaseServiceImpl<BillWorkorder> implements BillWorkorderService {
	@Autowired
	private BillWorkorderDao billWorkorderDao;
	@Autowired
	private ProductBomDao productBomDao;
	@Autowired
	private ProductMaterialDao productMaterialDao;
	@Autowired
	private ConfigDictionaryDao configDictionaryDao;
	@Autowired
	private StructProcessProductDao structProcessProductDao;
	@Autowired
	private StructProcessDao structProcessDao;
	@Autowired
	private StructProcessNodeDao structProcessNodeDao;
	@Autowired
	private StructProcedureInstructDao structProcedureInstructDao;
	@Autowired
	private StructProcedureEquipFixtureDao structProcedureEquipFixtureDao;
	@Autowired
	private WorkTaskProcedureDao workTaskProcedureDao;
	@Autowired
	private WorkPlanMaterialDao workPlanMaterialDao;
	@Autowired
	private HistoryBillStatusDao historyBillStatusDao;
	@Autowired
	private HistoryBillStatusAuditDao historyBillStatusAuditDao;
	@Autowired
	private StructProcedureMaterialDao structProcedureMaterialDao;
	@Autowired
	private ConfigCodeRuleDao configCodeRuleDao;
	@Autowired
	private WorkPlanEquipDao workPlanEquipDao;
	@Autowired
	private WorkPlanEquipFixtureDao workPlanEquipFixtureDao;
	@Autowired
	private StructProductionlineDao structProductionlineDao;
	@Autowired
	private StructProdlineEquipDao structProdlineEquipDao;
	@Autowired
	private StructProdlineEquipFixtureDao structProdlineEquipFixtureDao;
	@Autowired
	private EquipSpecsWorkDao equipSpecsWorkDao;
	@Autowired
	private EquipWorkDao equipWorkDao;
	@Autowired
	private StructProdlineWorkstationDao structProdlineWorkstationDao;
	@Autowired
	private StructWorkstationDao structWorkstationDao;
	@Autowired
	private StructProcedureWorkstationDao structProcedureWorkstationDao;
	@Autowired
	private WorkPlanWorkstationDao workPlanWorkstationDao;
	@Autowired
	private BillWarehouseDao billWarehouseDao;
	@Autowired
	private BillWarehouseItemDao billWarehouseItemDao;
	@Autowired
	private BarcodeMainDao barcodeMainDao;
	@Autowired
	private TrackBarcodeDao trackBarcodeDao;

	@Override
	public BaseDao<BillWorkorder> getBaseDao() {
		return billWorkorderDao;
	}

	@Override
	public Class<BillWorkorder> getEntityClass() {
		return BillWorkorder.class;
	}

	@Override
	protected BillWorkorder insertEntity(BillWorkorder insertEntity, CommonParam commonParam)
			throws BusinessException, SQLException {

		BillWorkorder billWorkorder = super.insertEntity(insertEntity, commonParam);

		if (billWorkorder != null) {
			// 增加单据历史记录
			historyBillStatusDao.billHistoryInsert(EnumBillType.BILL_TYPE_WORKORDER.getValue(),
					billWorkorder.getWorkorderStatusDictId(), billWorkorder.getId(), billWorkorder.getWorkorderCode(),
					commonParam);
			// 增加单据审批记录
			historyBillStatusAuditDao.billHistoryInsert(EnumBillType.BILL_TYPE_WORKORDER.getValue(),
					billWorkorder.getAuditStatusDictId(), billWorkorder.getId(), billWorkorder.getWorkorderCode(),
					commonParam);
		}
		return billWorkorder;
	}

	@Override
	protected BillWorkorder updatePartEntity(BillWorkorder entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillWorkorder billWorkorder = super.updatePartEntity(entity, commonParam);
		if (billWorkorder != null) {
			// 增加单据历史记录
			historyBillStatusDao.billHistoryInsert(EnumBillType.BILL_TYPE_WORKORDER.getValue(),
					billWorkorder.getWorkorderStatusDictId(), billWorkorder.getId(), billWorkorder.getWorkorderCode(),
					commonParam);
			// 增加单据审批记录,审批id不为未审批状态时，表示已修改审批状态
			if (billWorkorder.getAuditStatusDictId() != EnumAuditStatus.UNAUDITED.getValue()) {
				historyBillStatusAuditDao.billHistoryInsert(EnumBillType.BILL_TYPE_WORKORDER.getValue(),
						billWorkorder.getAuditStatusDictId(), billWorkorder.getId(), billWorkorder.getWorkorderCode(),
						commonParam);
			}

		}
		return billWorkorder;
	}

	@Override
	protected BillWorkorder updateEntity(BillWorkorder entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public ResultMessage updateStart(Long id, List<StructProductionlineParamVo> productionlineList,
			CommonParam commonParam) {
 

		// TODO Auto-generated method stub
		ResultMessage resultMessage = new ResultMessage();
		ProductBomParamVo productBomParamVo = new ProductBomParamVo();
		ProductMaterial productMaterial = new ProductMaterial();
		ConfigDictionary configDictionary = new ConfigDictionary();

		List<ProductBom> bomTreeList = new ArrayList<ProductBom>();
		Map<Long, ProductBom> processProductBomMap = new HashMap<Long, ProductBom>();
		Map<Long, StructProductionline> processProductionlineMap = new HashMap<Long, StructProductionline>();

		List<StructProcessNode> allProcedureNodeList = new ArrayList<StructProcessNode>();
		List<StructProcedureInstruct> allProcedureInstructList = new ArrayList<StructProcedureInstruct>();
		List<StructProcedureMaterial> allProcedureMaterialList = new ArrayList<StructProcedureMaterial>();
		List<StructProcedureWorkstation> allProcedureWorkstationList = new ArrayList<StructProcedureWorkstation>();
		List<StructProcedureEquipFixture> allProcedureEquipFixtureList = new ArrayList<StructProcedureEquipFixture>();
		List<WorkPlanEquip> allPlanEquipList = new ArrayList<WorkPlanEquip>();
		// 生产领料单明细对象list
		List<BillWarehouseItem> billWarehouseItemList = new ArrayList<>();
		/**
		 * checkIs = true 判断是否审核成功 true表示可以生成 工作工序任务、工作物料计划、工作设备计划、工作工具计划 反之
		 * 返回审核失败的具体消息给WEB页面
		 */
		boolean checkIs = true;
		// 工单产品 BOM ID
		Long bomId = null;

		BillWorkorder billWorkorderVo = null;

		try {
			billWorkorderVo = billWorkorderDao.selectById(id);
			if (billWorkorderVo.getBomId() == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.setMessage("该工单对应BOMID，请先维护!");
				return resultMessage;
			}

			if (!EnumAuditStatus.AUDITED.getValue().equals(billWorkorderVo.getAuditStatusDictId())) {
				resultMessage.setIsSuccess(false);
				resultMessage.setMessage("该工单未审核通过，不能进行此操作!");
				return resultMessage;
			}

			if (!EnumWorkorderStatus.AP01.getValue().equals(billWorkorderVo.getWorkorderStatusDictId())) {
				resultMessage.setIsSuccess(false);
				resultMessage.setMessage("该工单不是开立状态，不能进行此操作!");
				return resultMessage;
			}

			if ((productionlineList == null) || (productionlineList.isEmpty())) {
				resultMessage.setIsSuccess(false);
				resultMessage.setMessage("产线不能为空，不能进行此操作!");
				return resultMessage;
			}

			// 工单产品 BOM ID
			bomId = billWorkorderVo.getBomId();

			productBomParamVo.setId(bomId);
			productBomParamVo.setTenantId(commonParam.getTenantId());

			bomTreeList = productBomDao.selectListBomTree(bomId, commonParam);

			if ((bomTreeList != null) && (!bomTreeList.isEmpty())) {
				labe: for (ProductBom productBom : bomTreeList) {

					productMaterial = productMaterialDao.selectById(productBom.getMaterialId());
					configDictionary = configDictionaryDao.selectById(productMaterial.getProductTypeDictId());

					if (EnumProductType.RAWMATERIAL.getValue().equals(productMaterial.getProductTypeDictId())) {
						BillWarehouseItem billWarehouseItem = new BillWarehouseItem();
						billWarehouseItem.setTenantId(commonParam.getTenantId());
						billWarehouseItem.setProductId(productBom.getProductId());
						billWarehouseItem.setMaterialId(productBom.getMaterialId());
						billWarehouseItem.setBillStatusDictId(EnumBillStatus.NEW.getValue());
						billWarehouseItem
								.setQuantity(Arith.mul(billWorkorderVo.getQuantity(), productBom.getQuantity()));
						billWarehouseItem.setQuantityFinish(0.00);
						billWarehouseItem.setQuantityScan(0.00);
						billWarehouseItemList.add(billWarehouseItem);
					}

					if (!EnumProductType.RAWMATERIAL.getValue().equals(productMaterial.getProductTypeDictId())) {

						// 根据产品ID和物料规格ID查询是否存在产品工艺路线
						StructProcessProductParamVo structProcessProduct = new StructProcessProductParamVo();
						structProcessProduct.setProductId(productMaterial.getProductId());
						structProcessProduct.setMaterialId(productMaterial.getId());
						structProcessProduct.setBomId(productBom.getId());
						List<StructProcessProduct> listPro = structProcessProductDao
								.selectListByParamVo(structProcessProduct);
						if (listPro.size() == 0) {
							resultMessage.setIsSuccess(false);
							checkIs = false;
							resultMessage.setMessage("物品规格编码为" + productMaterial.getMaterialCode() + "的"
									+ configDictionary.getDictName() + "不存在产品工艺路线请先维护!");
							break;
						}

						// 查询工艺路线是否存在
						StructProcess structProcess = structProcessDao.selectById(listPro.get(0).getProcessId());
						if (structProcess == null) {
							resultMessage.setIsSuccess(false);
							checkIs = false;
							resultMessage.setMessage("工艺路线不存在,请先维护!");
							break;
						}

						processProductBomMap.put(structProcess.getId(), productBom);

						// 查询工艺路线工序节点是否存在
						StructProcessNodeParamVo structProcessNode = new StructProcessNodeParamVo();
						structProcessNode.setProcessId(structProcess.getId());
						List<StructProcessNode> nodeList = structProcessNodeDao.selectListByParamVo(structProcessNode);
						if ((nodeList == null) || (nodeList.isEmpty())) {
							resultMessage.setIsSuccess(false);
							checkIs = false;
							resultMessage.setMessage(structProcess.getId() + "工艺路线不存在工序,请先维护!");
							break;
						}

						for (StructProductionlineParamVo productionlineParamVo : productionlineList) {
							if (productBom.getId().equals(productionlineParamVo.getProductBomId())) {
								StructProductionline productionline = structProductionlineDao
										.selectById(productionlineParamVo.getId());
								processProductionlineMap.put(productBom.getId(), productionline);
							}
						}

						if (checkIs == true) {

							allProcedureNodeList.addAll(nodeList);

							// 判断每个工序是否存在工序指令
							for (StructProcessNode processNode : nodeList) {
								StructProcedureInstructParamVo procedureInstructParamVo = new StructProcedureInstructParamVo();
								procedureInstructParamVo.setTenantId(commonParam.getTenantId());
								procedureInstructParamVo.setProcessNodeId(processNode.getId());
								List<StructProcedureInstruct> procedureInstructList = structProcedureInstructDao
										.selectListByParamVo(procedureInstructParamVo);
								if ((procedureInstructList == null) || (procedureInstructList.isEmpty())) {
									resultMessage.setIsSuccess(false);
									checkIs = false;
									resultMessage.setMessage(processNode.getNodeName() + "工序不存在工序指令,请先维护!");
									break labe;
								} else {
									allProcedureInstructList.addAll(procedureInstructList);

									// 判断每个工序是否维护工序物料清单
									StructProcedureMaterialParamVo procedureMaterial = new StructProcedureMaterialParamVo();
									procedureMaterial.setTenantId(commonParam.getTenantId());
									procedureMaterial.setProcessNodeId(processNode.getId());
									List<StructProcedureMaterial> procedureMaterialList = structProcedureMaterialDao
											.selectListByParamVo(procedureMaterial);

									if ((procedureMaterialList != null) && (!procedureMaterialList.isEmpty())) {
										allProcedureMaterialList.addAll(procedureMaterialList);
									}

									// 判断每个工序是否维护工序物料清单
									StructProcedureEquipFixtureParamVo procedureEquipFixture = new StructProcedureEquipFixtureParamVo();
									procedureEquipFixture.setTenantId(commonParam.getTenantId());
									procedureEquipFixture.setProcessNodeId(processNode.getId());
									List<StructProcedureEquipFixture> procedureEquipFixtureList = structProcedureEquipFixtureDao
											.selectListByParamVo(procedureEquipFixture);
									if ((procedureEquipFixtureList != null) && (!procedureEquipFixtureList.isEmpty())) {
										allProcedureEquipFixtureList.addAll(procedureEquipFixtureList);
									}

								}

								StructProcedureWorkstationParamVo procedureWorkstationParamVo = new StructProcedureWorkstationParamVo();
								procedureWorkstationParamVo.setTenantId(commonParam.getTenantId());
								procedureWorkstationParamVo.setProcessNodeId(processNode.getId());
								List<StructProcedureWorkstation> procedureWorkstationList = structProcedureWorkstationDao
										.selectListByParamVo(procedureWorkstationParamVo);
								if ((procedureWorkstationList == null) || (procedureWorkstationList.isEmpty())) {
									resultMessage.setIsSuccess(false);
									checkIs = false;
									resultMessage.setMessage(processNode.getNodeName() + "工序不存在工位,请先维护!");
									break labe;
								} else {
									allProcedureWorkstationList.addAll(procedureWorkstationList);
								}

							}

						}
					}
				}
			} else {
				resultMessage.setIsSuccess(false);
				checkIs = false;
				resultMessage.setMessage("该工单产品对应BOM不存在,请先维护!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// if ((bomTreeList != null) && (!bomTreeList.isEmpty())) {
		//
		// List<ProductBomVo> materialBomTreeList = new
		// ArrayList<ProductBomVo>();
		// for (ProductBom productBom : bomTreeList) {
		//
		// ProductMaterial material =
		// productMaterialDao.selectById(productBom.getMaterialId());
		// if
		// (EnumProductType.RAWMATERIAL.getValue().equals(material.getProductTypeDictId()))
		// { // 如果是物料
		// ProductBomVo productBomVo = new ProductBomVo(productBom);
		// productBomVo.setProductMaterial(material);
		// materialBomTreeList.add(productBomVo);
		// }
		// }
		// } else {
		// resultMessage.setIsSuccess(false);
		// resultMessage.setMessage("该工单产品对应BOM物料不存在,请先维护!");
		// }

		if (checkIs == true) {

			try {

				Map<Long, List<EquipWork>> sameProcessNodeMap = new HashMap<Long, List<EquipWork>>();

				for (StructProcedureWorkstation procedureWorkstation : allProcedureWorkstationList) {
					EquipWorkParamVo equipWorkParamVo = new EquipWorkParamVo();
					equipWorkParamVo.setTenantId(commonParam.getTenantId());
					equipWorkParamVo.setWorkstationId(procedureWorkstation.getWorkstationId());
					List<EquipWork> ewList = equipWorkDao.selectListByParamVo(equipWorkParamVo);

					if ((ewList != null) && (!ewList.isEmpty())) {

						List<EquipWork> ewList2 = sameProcessNodeMap.get(procedureWorkstation.getProcessNodeId());
						if ((ewList2 == null) || (ewList2.isEmpty())) {
							ewList2 = new ArrayList<EquipWork>();
						}
						for (EquipWork equipWork : ewList) {
							ewList2.add(equipWork);
						}

						sameProcessNodeMap.put(procedureWorkstation.getProcessNodeId(), ewList2);

					}
				}
				for (StructProcedureInstruct procedureInstruct : allProcedureInstructList) {
					// 找到设备清单
					if (procedureInstruct.getEquipSpecsWorkId() != null) {

						List<EquipWork> ewList2 = sameProcessNodeMap.get(procedureInstruct.getProcessNodeId());

						if ((ewList2 != null) && (!ewList2.isEmpty())) {
							for (EquipWork ew : ewList2) {
								if (procedureInstruct.getEquipSpecsWorkId().equals(ew.getSpecsWorkId())) {

									WorkPlanEquip workPlanEquip = new WorkPlanEquip();
									workPlanEquip.setProcessNodeId(procedureInstruct.getProcessNodeId());
									workPlanEquip.setInstructId(procedureInstruct.getId());
									workPlanEquip.setEquipSpecsWorkId(ew.getSpecsWorkId());
									workPlanEquip.setEquipWorkId(ew.getId());
									workPlanEquip.setWorkshopId(ew.getWorkshopId());
									workPlanEquip.setWorkshopAreaId(ew.getWorkshopAreaId());
									workPlanEquip.setWorkstationId(ew.getWorkstationId());
									allPlanEquipList.add(workPlanEquip);
								}
							}
						}

					}

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (checkIs == true) {
			if ((allPlanEquipList == null) || (allPlanEquipList.isEmpty())) {
				resultMessage.setIsSuccess(false);
				checkIs = false;
				resultMessage.setMessage("工序不存在工序设备清单,请先维护!");
			}

			if ((allProcedureMaterialList == null) || (allProcedureMaterialList.isEmpty())) {
				resultMessage.setIsSuccess(false);
				checkIs = false;
				resultMessage.setMessage("工序不存在工序物料清单,请先维护!");
			}
		}
		if (checkIs == true) {

			try {
				List<WorkTaskProcedure> taskProcedureList = new ArrayList<WorkTaskProcedure>();
				List<WorkPlanMaterial> planMaterialList = new ArrayList<WorkPlanMaterial>();
				List<WorkPlanEquipFixture> planEquipFixtureList = new ArrayList<WorkPlanEquipFixture>();
				List<WorkPlanEquip> planEquipList = new ArrayList<WorkPlanEquip>();
				List<WorkPlanWorkstation> planWorkstationList = new ArrayList<WorkPlanWorkstation>();

				Integer index = 0;
				Integer index_Equip = 0;
				Integer index_Mat = 0;
				Integer index_Workstation = 0;
				String idString = "";
				Long taskProceId = workTaskProcedureDao.getIdValue();
				Long planMatId = workPlanMaterialDao.getIdValue();
				Long planEquipFixtureId = workPlanEquipFixtureDao.getIdValue();
				Long planEquipId = workPlanEquipDao.getIdValue();
				Long planWorkstationpId = workPlanWorkstationDao.getIdValue();

				DecimalFormat locationdfID = new DecimalFormat("000000");
				Long idLong = 0L;

				for (StructProcessNode allNode : allProcedureNodeList) {
					// 工作工序任务
					WorkTaskProcedure wp = new WorkTaskProcedure();
					index++;
					idString = locationdfID.format(index);
					idLong = Long.valueOf(taskProceId.toString() + idString);
					wp.setId(idLong);
					wp.setTenantId(commonParam.getTenantId());
					wp.setFactoryId(billWorkorderVo.getFactoryId());
					wp.setBillWorkorderId(billWorkorderVo.getId());
					wp.setProcessId(allNode.getProcessId());
					wp.setProcessNodeId(allNode.getId());
					ProductBom processProductBom = processProductBomMap.get(allNode.getProcessId());
					wp.setBomId(processProductBom.getId());
					wp.setProductId(processProductBom.getProductId());
					wp.setMaterialId(processProductBom.getMaterialId());
					wp.setWorktime(allNode.getWorktime());
					wp.setExecutiveTypeDictId(allNode.getExecutiveTypeDictId());
					wp.setBuffertimePost(allNode.getBuffertimePost());
					wp.setBuffertimePre(allNode.getBuffertimePre());
					wp.setSortNo(allNode.getSortNo());
					wp.setPriority(billWorkorderVo.getPriority());
					wp.setQuantity(billWorkorderVo.getQuantity());
					wp.setQuantityInput(0d);
					wp.setQuantityOutput(0d);
					wp.setQuantityStandard(0d);
					// 自动生成单据编码
					String taskCode = configCodeRuleDao.createCode(WorkTaskProcedure.class.getName(), null, null,
							commonParam);
					wp.setTaskCode(taskCode);
					wp.setTaskStatusDictId(EnumWorkTaskStatus.NOTSTARTED.getValue());
					//wp.setTimePlanStart(billWorkorderVo.getTimePlanStart());
					//wp.setTimePlanEnd(billWorkorderVo.getTimePlanEnd());
					//wp.setTimeActualStart(billWorkorderVo.getTimeActualStart());
					//wp.setTimeActualEnd(billWorkorderVo.getTimeActualEnd());
					wp.setIsLocked(EnumYesOrNo.NO.getValue());
					wp.setModifyUserId(Long.valueOf(commonParam.getUserId()));
					wp.setCreateUserId(Long.valueOf(commonParam.getUserId()));
					StructProductionline productionline = processProductionlineMap.get(processProductBom.getId());
					Long workshopId = productionline.getWorkshopId();
					wp.setWorkshopId(workshopId);
					wp.setProductionlineId(productionline.getId());
					taskProcedureList.add(wp);

					// 工位计划
					if ((allProcedureWorkstationList != null) && (!allProcedureWorkstationList.isEmpty())) {
						for (StructProcedureWorkstation structProcedureWorkstation : allProcedureWorkstationList) {
							if (structProcedureWorkstation.getProcessNodeId().equals(allNode.getId())) {// 该个工序的
								WorkPlanWorkstation workPlanWorkstation = new WorkPlanWorkstation();

								index_Workstation++;
								idString = locationdfID.format(index_Workstation);
								workPlanWorkstation.setId(Long.valueOf(planWorkstationpId.toString() + idString));
								workPlanWorkstation.setTenantId(commonParam.getTenantId());
								workPlanWorkstation.setFactoryId(billWorkorderVo.getFactoryId());
								workPlanWorkstation.setBillWorkorderId(billWorkorderVo.getId());
								workPlanWorkstation.setTaskId(idLong);
								workPlanWorkstation.setProcessId(allNode.getProcessId());
								workPlanWorkstation.setProcessNodeId(allNode.getId());

								StructWorkstation structWorkstation = structWorkstationDao
										.selectById(structProcedureWorkstation.getWorkstationId());
								workPlanWorkstation.setWorkstationId(structWorkstation.getId());
								workPlanWorkstation.setWorkshopId(structWorkstation.getWorkshopId());
								workPlanWorkstation.setWorkshopAreaId(structWorkstation.getWorkshopAreaId());
								workPlanWorkstation.setIsLocked(EnumYesOrNo.NO.getValue());
								workPlanWorkstation.setPlanStatusDictId(EnumWorkPlanStatus.NOTSTARTED.getValue());
								workPlanWorkstation.setTimePlanStart(billWorkorderVo.getTimePlanStart());
								workPlanWorkstation.setTimePlanEnd(billWorkorderVo.getTimePlanEnd());
								workPlanWorkstation.setTimeActualStart(billWorkorderVo.getTimeActualStart());
								workPlanWorkstation.setTimeActualEnd(billWorkorderVo.getTimeActualEnd());
								workPlanWorkstation.setModifyUserId(Long.valueOf(commonParam.getUserId()));
								workPlanWorkstation.setCreateUserId(Long.valueOf(commonParam.getUserId()));

								workPlanWorkstation.setQuantity(billWorkorderVo.getQuantity());
								workPlanWorkstation.setQuantityInput(0d);
								workPlanWorkstation.setQuantityOutput(0d);
								planWorkstationList.add(workPlanWorkstation);
							}
						}
					}

					// 设备计划
					if ((allPlanEquipList != null) && (!allPlanEquipList.isEmpty())) {
						for (WorkPlanEquip tempWorkPlanEquip : allPlanEquipList) {
							if (tempWorkPlanEquip.getProcessNodeId().equals(allNode.getId())) {// 该个工序的
								WorkPlanEquip workPlanEquip = new WorkPlanEquip();

								index_Equip++;
								idString = locationdfID.format(index_Equip);
								workPlanEquip.setId(Long.valueOf(planEquipId.toString() + idString));
								workPlanEquip.setTenantId(commonParam.getTenantId());
								workPlanEquip.setFactoryId(billWorkorderVo.getFactoryId());
								workPlanEquip.setBillWorkorderId(billWorkorderVo.getId());
								workPlanEquip.setTaskId(idLong);
								workPlanEquip.setProcessId(allNode.getProcessId());
								workPlanEquip.setProcessNodeId(tempWorkPlanEquip.getProcessNodeId());
								workPlanEquip.setInstructId(tempWorkPlanEquip.getInstructId());
								workPlanEquip.setEquipSpecsWorkId(tempWorkPlanEquip.getEquipSpecsWorkId());
								workPlanEquip.setEquipWorkId(tempWorkPlanEquip.getEquipWorkId());
								workPlanEquip.setWorkshopId(tempWorkPlanEquip.getWorkshopId());
								workPlanEquip.setWorkshopAreaId(tempWorkPlanEquip.getWorkshopAreaId());
								workPlanEquip.setWorkstationId(tempWorkPlanEquip.getWorkstationId());

								workPlanEquip.setIsLocked(EnumYesOrNo.NO.getValue());
								workPlanEquip.setPlanStatusDictId(EnumWorkPlanStatus.NOTSTARTED.getValue());
								workPlanEquip.setTimePlanStart(billWorkorderVo.getTimePlanStart());
								workPlanEquip.setTimePlanEnd(billWorkorderVo.getTimePlanEnd());
								workPlanEquip.setTimeActualStart(billWorkorderVo.getTimeActualStart());
								workPlanEquip.setTimeActualEnd(billWorkorderVo.getTimeActualEnd());
								workPlanEquip.setModifyUserId(Long.valueOf(commonParam.getUserId()));
								workPlanEquip.setCreateUserId(Long.valueOf(commonParam.getUserId()));

								workPlanEquip.setQuantity(billWorkorderVo.getQuantity());
								workPlanEquip.setQuantityInput(0d);
								workPlanEquip.setQuantityOutput(0d);
								planEquipList.add(workPlanEquip);

							}
						}
					}

					// 工作物料计划
					if ((allProcedureMaterialList != null) && (!allProcedureMaterialList.isEmpty())) {
						for (StructProcedureMaterial structProcedureMaterial : allProcedureMaterialList) {
							if (structProcedureMaterial.getProcessNodeId().equals(allNode.getId()))// 该个工序的物料清单
							{
								for (ProductBom productBom : bomTreeList) {
									if (structProcedureMaterial.getMaterialId().equals(productBom.getMaterialId())) {
										index_Mat++;
										idString = locationdfID.format(index_Mat);

										WorkPlanMaterial wm = new WorkPlanMaterial();
										wm.setId(Long.valueOf(planMatId.toString() + idString));
										wm.setTenantId(commonParam.getTenantId());
										wm.setFactoryId(billWorkorderVo.getFactoryId());
										wm.setBillWorkorderId(billWorkorderVo.getId());
										wm.setTaskId(idLong);
										wm.setProcessId(allNode.getProcessId());
										wm.setProcessNodeId(allNode.getId());
										wm.setInstructId(structProcedureMaterial.getInstructId());
										wm.setBomId(productBom.getId());
										wm.setProductId(structProcedureMaterial.getProductId());
										wm.setMaterialId(structProcedureMaterial.getMaterialId());
										wm.setWorkshopId(workshopId);
										wm.setPlanStatusDictId(EnumWorkPlanStatus.NOTSTARTED.getValue());
										wm.setQuantity(
												Arith.mul(billWorkorderVo.getQuantity(), productBom.getQuantity()));
										wm.setQuantityInput(0d);
										wm.setTimePlanStart(billWorkorderVo.getTimePlanStart());
										wm.setTimePlanEnd(billWorkorderVo.getTimePlanEnd());
										wm.setTimeActualStart(billWorkorderVo.getTimeActualStart());
										wm.setTimeActualEnd(billWorkorderVo.getTimeActualEnd());
										wm.setIsLocked(EnumYesOrNo.NO.getValue());
										wm.setRemark(billWorkorderVo.getRemark());
										wm.setModifyUserId(Long.valueOf(commonParam.getUserId()));
										wm.setCreateUserId(Long.valueOf(commonParam.getUserId()));
										planMaterialList.add(wm);
									}
								}

							}
						}
					}

				}

				// 工作工序任务
				workTaskProcedureDao.insertBatch(taskProcedureList, commonParam);
				// 工作物料计划
				workPlanMaterialDao.insertBatch(planMaterialList, commonParam);
				// 工作设备计划
				workPlanEquipDao.insertBatch(planEquipList, commonParam);
				// 工作工位计划
				workPlanWorkstationDao.insertBatch(planWorkstationList, commonParam);

				// 生产领料单
				BillWarehouseParamVo billWarehouseParamVo = new BillWarehouseParamVo();
				// 自动生成单据编码
				String warehouseId = configCodeRuleDao.createCode(BillWarehouse.class.getName(),
						EnumBillType.BILL_TYPE_WAREHOUSE_PICKING.getValue(), null, commonParam);
				billWarehouseParamVo.setBillCode(warehouseId); // 单据编码
				billWarehouseParamVo.setTypeStock(EnumTypeStock.OUT.getValue());// 0入库
																				// 1出库
				billWarehouseParamVo.setTenantId(commonParam.getTenantId());
				billWarehouseParamVo.setBillTypeDictId(EnumBillType.BILL_TYPE_WAREHOUSE_PICKING.getValue());// 单据类型
																											// 生产领料单
				billWarehouseParamVo.setAuditStatusDictId(EnumAuditStatus.AUDITED.getValue());// 审核状态

				billWarehouseParamVo.setBillStatusDictId(EnumBillStatus.NEW.getValue());
				billWarehouseParamVo.setFromBillTypeDictId(EnumBillType.BILL_TYPE_WORKORDER.getValue());// 来源单据类型
																										// 工单
				billWarehouseParamVo.setFromBillId(billWorkorderVo.getId());// 来源单据id
																			// 工单id
				billWarehouseParamVo.setFromBillCode(billWorkorderVo.getWorkorderCode());// 来源单据编码
				billWarehouseParamVo.setItemList(billWarehouseItemList);
//				Long billWarehouseId = billWarehouseDao.getIdValue();
//				billWarehouseParamVo.setId(billWarehouseId);
//				billWarehouseDao.insertEntity(billWarehouseParamVo, commonParam);
//				List<BillWarehouseItem> itemList = billWarehouseItemDao.buildLocationsByRack(billWarehouseParamVo,
//						billWarehouseId, commonParam);
//				billWarehouseItemDao.insertBatch(itemList, commonParam);

				// 修改工单状态为已审核
				BillWorkorder wo = new BillWorkorder();
				wo.setId(billWorkorderVo.getId());
				wo.setIsLocked(EnumYesOrNo.NO.getValue());
				wo.setAuditStatusDictId(EnumAuditStatus.AUDITED.getValue());
				wo.setWorkorderStatusDictId(EnumWorkorderStatus.AP02.getValue());
				wo.setModifyUserId(Long.valueOf(commonParam.getUserId()));
				wo.setModifyUserId(Long.valueOf(commonParam.getUserId()));
				billWorkorderDao.updateBatch(wo, commonParam);

				historyBillStatusDao.billHistoryInsert(EnumBillType.BILL_TYPE_WORKORDER.getValue(),
						wo.getWorkorderStatusDictId(), billWorkorderVo.getId(), billWorkorderVo.getWorkorderCode(),
						commonParam);
				resultMessage.setIsSuccess(true);
				resultMessage.setMessage("操作成功!");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultMessage;
	}

	@Override
	public ResultMessage updateAudit(Long id, CommonParam commonParam) {
		// TODO Auto-generated method stub
		ResultMessage resultMessage = new ResultMessage();
		try {
			BillWorkorder billWorkorder = billWorkorderDao.selectById(id);
			if (billWorkorder.getBomId() == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.setMessage("该工单对应BOMID,请先维护!");
			}

			if (!EnumAuditStatus.UNAUDITED.getValue().equals(billWorkorder.getAuditStatusDictId())) {
				resultMessage.setIsSuccess(false);
				resultMessage.setMessage("该工单不是未审核状态，不能进行此操作!");
			}

			billWorkorder.setAuditStatusDictId(EnumAuditStatus.AUDITED.getValue());
			billWorkorder.setWorkorderStatusDictId(EnumWorkorderStatus.AP02.getValue());
			billWorkorder = billWorkorderDao.updateEntity(billWorkorder, commonParam);

			historyBillStatusAuditDao.billHistoryInsert(EnumBillType.BILL_TYPE_WORKORDER.getValue(),
					billWorkorder.getAuditStatusDictId(), billWorkorder.getId(), billWorkorder.getWorkorderCode(),
					commonParam);

			// List<StructProductionlineParamVo> productionlineList = new
			// ArrayList<StructProductionlineParamVo>();
			// StructProductionlineParamVo productionlineParamVo = new
			// StructProductionlineParamVo();
			// productionlineParamVo.setProductBomId(56478l);
			// productionlineParamVo.setId(1000009L);
			// productionlineList.add(productionlineParamVo);
			// updatStart(id, productionlineList,commonParam);
			resultMessage.setIsSuccess(true);
			resultMessage.setMessage("操作成功!");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public List<ProductBomVo> listProductBomProcess(Long id, CommonParam commonParam) {
		List<ProductBomVo> list = new ArrayList();
		List<BarcodeMain> barcodeList = new ArrayList<>();
		List<TrackBarcode> trackList = new ArrayList<>();

		try {
			BillWorkorder billWorkorder = billWorkorderDao.selectById(id);
			if (billWorkorder.getBomId() != null) {

				List<ProductBom> bomTreeList = productBomDao.selectListBomTree(billWorkorder.getBomId(), commonParam);
				if ((bomTreeList != null) && (!bomTreeList.isEmpty())) {
					for (ProductBom productBom : bomTreeList) {

						ProductMaterial productMaterial = productMaterialDao.selectById(productBom.getMaterialId());

						if (!EnumProductType.RAWMATERIAL.getValue().equals(productMaterial.getProductTypeDictId())) {

							// 根据产品ID和物料规格ID查询是否存在产品工艺路线
							StructProcessProductParamVo structProcessProduct = new StructProcessProductParamVo();
							structProcessProduct.setProductId(productMaterial.getProductId());
							structProcessProduct.setMaterialId(productMaterial.getId());
							List<StructProcessProduct> listPro = structProcessProductDao
									.selectListByParamVo(structProcessProduct);

							if ((listPro != null) && (!listPro.isEmpty())) {
								// 查询工艺路线是否存在
								StructProcess structProcess = structProcessDao
										.selectById(listPro.get(0).getProcessId());
								ProductBomVo productBomVo = new ProductBomVo(productBom);
								productBomVo.setStructProcess(structProcess);
								
								WorkTaskProcedureParamVo workTaskProcedureParamVo = new WorkTaskProcedureParamVo();
								workTaskProcedureParamVo.setTenantId(billWorkorder.getTenantId());
								workTaskProcedureParamVo.setBillWorkorderId(billWorkorder.getId());
								workTaskProcedureParamVo.setProcessId(structProcess.getId());
								workTaskProcedureParamVo.setMaterialId(productBom.getMaterialId());
								List<WorkTaskProcedure> workTaskProcedureList = workTaskProcedureDao.selectListByParamVo(workTaskProcedureParamVo);
								if ((workTaskProcedureList != null) && (!workTaskProcedureList.isEmpty())) { 
									productBomVo.setProductionlineId(workTaskProcedureList.get(0).getProductionlineId());
								}
								list.add(productBomVo); 
							}

						}

					}

				}
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ResultMessage insertPrintBarcode(Long id, CommonParam commonParam) {
		List<BarcodeMain> barcodeList = new ArrayList<>();
		List<TrackBarcode> trackList = new ArrayList<>();
		ResultMessage resultMessage = new ResultMessage();
		try {
			BillWorkorder billWorkorder = billWorkorderDao.selectById(id);
			if (billWorkorder.getBomId() != null) {

				List<ProductBom> bomTreeList = productBomDao.selectListBomTree(billWorkorder.getBomId(), commonParam);
				if ((bomTreeList != null) && (!bomTreeList.isEmpty())) {
					for (ProductBom productBom : bomTreeList) {

						ProductMaterial productMaterial = productMaterialDao.selectById(productBom.getMaterialId());

						if (!EnumProductType.RAWMATERIAL.getValue().equals(productMaterial.getProductTypeDictId())) {

							// 临时生成批量条码
							Double quantity = Arith.mul(productBom.getQuantity(), billWorkorder.getQuantity());
							
							
							DecimalFormat df=new DecimalFormat("00000000");
							Integer index = 0;
							String idString = "";
							Long idLong = 0L;
							Long barcodeId=barcodeMainDao.getIdValue();
							for (double n = 0; n < quantity; n++) {
								index++;
								idString=df.format(index);
								idLong = Long.valueOf(barcodeId.toString() + idString);
								// 条码主表
								BarcodeMain barcodeMain = new BarcodeMain();
								barcodeMain.setId(idLong);
								barcodeMain.setBillCode(billWorkorder.getWorkorderCode());
								barcodeMain.setBarcodePackboxId(Long.parseLong("0"));
								barcodeMain.setFactoryId(billWorkorder.getFactoryId());
								barcodeMain.setBarcodeRuleDictId(EnumBarcodeRule.PRODUCT_MATERIAL.getValue());
								barcodeMain.setProductTypeDictId(productMaterial.getProductTypeDictId());
								barcodeMain.setProductId(productMaterial.getProductId());
								barcodeMain.setMaterialId(productMaterial.getId());
								barcodeMain.setBarcodeStatusDictId(EnumBarcodeStatus.NEW.getValue());
								barcodeMain.setBillTypeDictId(EnumBillType.BILL_TYPE_WORKORDER.getValue());
								barcodeMain.setBillId(billWorkorder.getId());
								barcodeMain.setBillItemId(productBom.getId());
								barcodeMain.setBillStatusDictId(EnumBillStatus.NEW.getValue());
								barcodeMain.setBillWorkorderId(billWorkorder.getId());
								barcodeMain.setQuantity(productBom.getQuantity());
								barcodeMain.setTenantId(commonParam.getTenantId());
								barcodeMain.setCreateUserId(Long.parseLong(commonParam.getUserId()));
								barcodeMain.setModifyUserId(Long.parseLong(commonParam.getUserId()));
								barcodeList.add(barcodeMain);

								// 追踪条码表
								TrackBarcode trackBarcode = new TrackBarcode();
								BeanUtil.copyNotNullProperties(trackBarcode, barcodeMain);
								trackBarcode.setBarcodeId(barcodeMain.getId());
								trackBarcode.setId(null);
								trackBarcode.setVersion(null);
								trackList.add(trackBarcode);

							}
						}

					}

					// 批量新增条码主表 与 追踪条码表
					barcodeMainDao.insertPrintBarcodeMain(barcodeList, commonParam);
					TrackBarcodeParamVo tParamVo = new TrackBarcodeParamVo();
					tParamVo.setListSn(trackList);
					trackBarcodeDao.insertSnlist(tParamVo, commonParam);
					resultMessage.setIsSuccess(true);

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMessage;
	}

}
