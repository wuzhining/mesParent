package com.techsoft.service.work;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumBarcodeStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.enums.EnumEquipStatusType;
import com.techsoft.common.enums.EnumProcedureInstructType;
import com.techsoft.common.enums.EnumProductType;
import com.techsoft.common.enums.EnumWorkPlanStatus;
import com.techsoft.common.enums.EnumWorkTaskStatus;
import com.techsoft.common.enums.EnumWorkorderStatus;
import com.techsoft.common.enums.EnumYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.Arith;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.dao.barcode.BarcodeMainDao;
import com.techsoft.dao.bill.BillWorkorderDao;
import com.techsoft.dao.equip.EquipWorkDao;
import com.techsoft.dao.product.ProductMaterialDao;
import com.techsoft.dao.struct.StructProcedureInstructDao;
import com.techsoft.dao.struct.StructProcessNodeDao;
import com.techsoft.dao.track.TrackBarcodeDao;
import com.techsoft.dao.work.WorkPlanEquipDao;
import com.techsoft.dao.work.WorkPlanEquipFixtureDao;
import com.techsoft.dao.work.WorkPlanMaterialDao;
import com.techsoft.dao.work.WorkPlanWorkstationDao;
import com.techsoft.dao.work.WorkTaskProcedureDao;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.common.WorkPlanEquip;
import com.techsoft.entity.common.WorkPlanEquipFixture;
import com.techsoft.entity.common.WorkPlanMaterial;
import com.techsoft.entity.common.WorkPlanWorkstation;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.entity.work.WorkPlanEquipParamVo;
import com.techsoft.entity.work.WorkPlanMaterialParamVo;
import com.techsoft.entity.work.WorkPlanWorkstationParamVo;
import com.techsoft.entity.work.WorkTaskProcedureParamVo;
import com.techsoft.entity.work.WorkTaskProcedureVo;

@Service
public class WorkTaskProcedureServiceImpl extends BaseServiceImpl<WorkTaskProcedure>
		implements WorkTaskProcedureService {
	@Autowired
	private WorkTaskProcedureDao workTaskProcedureDao;
	@Autowired
	private WorkPlanEquipFixtureDao workPlanEquipFixtureDao;
	@Autowired
	private WorkPlanEquipDao workPlanEquipDao;
	@Autowired
	private WorkPlanMaterialDao workPlanMaterialDao;
	@Autowired
	private WorkPlanWorkstationDao workPlanWorkstationDao;
	@Autowired
	private BarcodeMainDao barcodeMainDao;
	@Autowired
	private TrackBarcodeDao trackBarcodeDao;
	@Autowired
	private BillWorkorderDao billWorkorderDao;
	@Autowired
	private ProductMaterialDao productMaterialDao;
	@Autowired
	private StructProcedureInstructDao structProcedureInstructDao;
	@Autowired
	private StructProcessNodeDao structProcessNodeDao;
	@Autowired
	private EquipWorkDao equipWorkDao;

	@Override
	public BaseDao<WorkTaskProcedure> getBaseDao() {
		return workTaskProcedureDao;
	}

	@Override
	public Class<WorkTaskProcedure> getEntityClass() {
		return WorkTaskProcedure.class;
	}

	@Override
	protected WorkTaskProcedure insertEntity(WorkTaskProcedure entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WorkTaskProcedure updatePartEntity(WorkTaskProcedure entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WorkTaskProcedure updateEntity(WorkTaskProcedure entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public List<WorkTaskProcedure> selectListCanWorking(WorkTaskProcedureParamVo workTaskProcedureParamVo,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (workTaskProcedureParamVo == null) {
			workTaskProcedureParamVo = new WorkTaskProcedureParamVo();
			workTaskProcedureParamVo.setTenantId(commonParam.getTenantId());
		}
		List<WorkTaskProcedure> list = new ArrayList<WorkTaskProcedure>();
		workTaskProcedureParamVo.setIsLocked(EnumYesOrNo.NO.getValue());// 未锁定的，
		workTaskProcedureParamVo.setTaskStatusDictId(EnumWorkTaskStatus.NOTSTARTED.getValue());// 未开始
		List<WorkTaskProcedure> list1 = workTaskProcedureDao.selectListByParamVo(workTaskProcedureParamVo);
		if ((list1 != null) && (!list1.isEmpty())) {
			list.addAll(list1);
		}

		workTaskProcedureParamVo.setTaskStatusDictId(EnumWorkTaskStatus.DOING.getValue());// 进行中的
		List<WorkTaskProcedure> list2 = workTaskProcedureDao.selectListByParamVo(workTaskProcedureParamVo);
		if ((list2 != null) && (!list2.isEmpty())) {
			list.addAll(list2);
		}
		return list;
	}

	@Override
	public ResultMessage updateFeed(CommonParam commonParam, Long factoryId, List<BarcodeMain> barcodeMainRawList,
			List<BarcodeMain> barcodeMainNewList, BillWorkorder billWorkorder, WorkTaskProcedureVo workTaskProcedureVo,
			StructProcedureInstruct procedureInstruct, EquipWork equipWork, WorkPlanEquip workPlanEquip,
			EquipFixture equipFixture, WorkPlanEquipFixture workPlanEquipFixture, String remark)
			throws BusinessException, SQLException, IllegalAccessException, InvocationTargetException {
		ResultMessage resultMessage = new ResultMessage();

		Long userId = new Long(commonParam.getUserId());

		if ((barcodeMainRawList != null) && (!barcodeMainRawList.isEmpty())) {

			Double quantity = 0d;

			StructWorkstation structWorkstation = workTaskProcedureVo.getStructWorkstation();
			WorkPlanWorkstation workPlanWorkstation = workTaskProcedureVo.getWorkPlanWorkstation();

			WorkTaskProcedure workTaskProcedure = workTaskProcedureDao.selectById(workTaskProcedureVo.getId());
			if (workPlanWorkstation != null) {
				workPlanWorkstation = workPlanWorkstationDao.selectById(workPlanWorkstation.getId());
			}

			if (billWorkorder != null) { // 进入 生产

				if (EnumProcedureInstructType.IN.getValue().equals(procedureInstruct.getInstructTypeDictId())) {

					if (workTaskProcedure.getQuantityInput() >= workTaskProcedure.getQuantity()) {
						resultMessage.setIsSuccess(false);
						resultMessage.addErr("该物品不能进入当前作业任务,输入数量已超出");
						return resultMessage;
					}
				}
			}

			for (BarcodeMain barcodeMain : barcodeMainRawList) {

				if (billWorkorder != null) {
					barcodeMain.setBillTypeDictId(EnumBillType.BILL_TYPE_WORKORDER.getValue());
					barcodeMain.setBillWorkorderId(billWorkorder.getId());
					barcodeMain.setBillId(billWorkorder.getId());
					barcodeMain.setBillCode(billWorkorder.getWorkorderCode());
					barcodeMain.setBillStatusDictId(billWorkorder.getWorkorderStatusDictId());
					barcodeMain.setBillItemId(null);
				}

				if (equipWork != null) {
					barcodeMain.setEquipWorkId(equipWork.getId());
					barcodeMain.setWorkshopId(equipWork.getWorkshopId());
					barcodeMain.setWorkshopAreaId(equipWork.getWorkshopAreaId());
					barcodeMain.setWorkstationId(equipWork.getWorkstationId());
				}
				if (workTaskProcedure != null) {
					barcodeMain.setProductionlineId(workTaskProcedure.getProductionlineId());
					barcodeMain.setTaskProcedureId(workTaskProcedure.getId());
					barcodeMain.setProcessId(workTaskProcedure.getProcessId());
					barcodeMain.setProcessNodeId(workTaskProcedure.getProcessNodeId());
				}
				if (procedureInstruct != null) {
					barcodeMain.setProcessNodeId(procedureInstruct.getProcessNodeId());
					barcodeMain.setInstructId(procedureInstruct.getId());
					barcodeMain.setInstructTypeDictId(procedureInstruct.getInstructTypeDictId());
					if (StringUtils.isBlank(remark)) {
						remark = procedureInstruct.getInstructName();
					}
				}

				if (structWorkstation != null) {
					barcodeMain.setWorkshopId(structWorkstation.getWorkshopId());
					barcodeMain.setWorkshopAreaId(structWorkstation.getWorkshopAreaId());
					barcodeMain.setWorkstationId(structWorkstation.getId());
				}

				TrackBarcode trackBarcode = new TrackBarcode();
				BeanUtil.copyNotNullProperties(trackBarcode, barcodeMain);
				if (EnumProcedureInstructType.IN.getValue().equals(procedureInstruct.getInstructTypeDictId())) {

					if (!((workTaskProcedure.getMaterialId().equals(barcodeMain.getMaterialId()))
							|| (billWorkorder.getMaterialId().equals(barcodeMain.getMaterialId())))) {
						barcodeMain.setQuantity(0d);
					}

					barcodeMain.setBarcodeStatusDictId(EnumBarcodeStatus.WORKED.getValue());

					quantity = Arith.add(quantity, barcodeMain.getQuantity());

					WorkPlanMaterialParamVo workPlanMaterialParamVo = new WorkPlanMaterialParamVo();
					workPlanMaterialParamVo.setTenantId(commonParam.getTenantId());
					workPlanMaterialParamVo.setFactoryId(workTaskProcedure.getFactoryId());
					workPlanMaterialParamVo.setMaterialId(barcodeMain.getMaterialId());
					workPlanMaterialParamVo.setProcessId(workTaskProcedure.getProcessId());
					workPlanMaterialParamVo.setBillWorkorderId(workTaskProcedure.getBillWorkorderId());
					workPlanMaterialParamVo.setTaskId(workTaskProcedure.getId());
					List<WorkPlanMaterial> workPlanMaterialList = workPlanMaterialDao
							.selectListByParamVo(workPlanMaterialParamVo);

					if ((workPlanMaterialList != null) && (!workPlanMaterialList.isEmpty())) {
						for (WorkPlanMaterial workPlanMaterial : workPlanMaterialList) {
							workPlanMaterial.setQuantityInput(
									Arith.add(workPlanMaterial.getQuantityInput(), barcodeMain.getQuantity()));

							if (workPlanMaterial.getTimeActualStart() == null) {
								workPlanMaterial.setPlanStatusDictId(EnumWorkPlanStatus.DOING.getValue());
								workPlanMaterial.setTimeActualStart(new Date());
							}
							if (workPlanMaterial.getQuantityInput() >= workPlanMaterial.getQuantity()) {
								workPlanMaterial.setPlanStatusDictId(EnumWorkPlanStatus.FINISH.getValue());
								if (workPlanMaterial.getTimeActualEnd() == null) {
									workPlanMaterial.setTimeActualEnd(new Date());
								}
							}

							workPlanMaterialDao.updateEntity(workPlanMaterial, commonParam);
						}
					}
				}

				trackBarcode.setBarcodeId(barcodeMain.getId());
				trackBarcode.setCreateUserId(userId);
				trackBarcode.setModifyUserId(userId);
				trackBarcode.setId(null);
				trackBarcode.setVersion(null);
				trackBarcode.setRemark(remark);
				barcodeMainDao.updateEntity(barcodeMain, commonParam);
				trackBarcodeDao.insertEntity(trackBarcode, commonParam);

				resultMessage.setIsSuccess(true);
				resultMessage.setMessage("成功执行" + remark);
			}

			if (billWorkorder != null) { // 进入 生产

				billWorkorder = billWorkorderDao.selectById(billWorkorder.getId());

				if (EnumProcedureInstructType.IN.getValue().equals(procedureInstruct.getInstructTypeDictId())) {

					workTaskProcedure.setQuantityInput(Arith.add(workTaskProcedure.getQuantityInput(), quantity));

					if (workTaskProcedure.getTimeActualStart() == null) {
						workTaskProcedure.setTaskStatusDictId(EnumWorkTaskStatus.DOING.getValue());
						workTaskProcedure.setTimeActualStart(new Date());
					}

					if (workPlanWorkstation != null) {
						workPlanWorkstation
								.setQuantityInput(Arith.add(workPlanWorkstation.getQuantityInput(), quantity));

						if (workPlanWorkstation.getTimeActualStart() == null) {
							workPlanWorkstation.setPlanStatusDictId(EnumWorkPlanStatus.DOING.getValue());
							workPlanWorkstation.setTimeActualStart(new Date());
						}

						if (workPlanWorkstation.getQuantityInput() >= workPlanWorkstation.getQuantity()) {
							workPlanWorkstation.setPlanStatusDictId(EnumWorkPlanStatus.FINISH.getValue());
							if (workPlanWorkstation.getTimeActualEnd() == null) {
								workPlanWorkstation.setTimeActualEnd(new Date());
							}
						}
						workPlanWorkstationDao.updateEntity(workPlanWorkstation, commonParam);
					}

					if (equipWork != null) {
						workPlanEquip = workPlanEquipDao.selectById(workPlanEquip.getId());
						equipWork = equipWorkDao.selectById(equipWork.getId());

						if (workPlanEquip.getTimeActualStart() == null) {
							workPlanEquip.setPlanStatusDictId(EnumWorkPlanStatus.DOING.getValue());
							workPlanEquip.setTimeActualStart(new Date());
						}
						if (workPlanEquip.getQuantityInput() >= workPlanEquip.getQuantity()) {
							workPlanEquip.setPlanStatusDictId(EnumWorkPlanStatus.FINISH.getValue());
							if (workPlanEquip.getTimeActualEnd() == null) {
								workPlanEquip.setTimeActualEnd(new Date());
							}
						}
						workPlanEquip.setQuantityInput(Arith.add(workPlanEquip.getQuantityInput(), quantity));
						workPlanEquipDao.updateEntity(workPlanEquip, commonParam);
					}

				}

				if (billWorkorder.getTimeActualStart() == null) {
					billWorkorder.setWorkorderStatusDictId(EnumWorkorderStatus.AP03.getValue());
					billWorkorder.setTimeActualStart(new Date());
				}

				if (billWorkorder.getQuantityOutput() >= billWorkorder.getQuantity()) {
					billWorkorder.setWorkorderStatusDictId(EnumWorkorderStatus.AP04.getValue());
					if (billWorkorder.getTimeActualEnd() == null) {
						billWorkorder.setTimeActualEnd(new Date());
					}
				}

				workTaskProcedureDao.updateEntity(workTaskProcedure, commonParam);

				billWorkorderDao.updateEntity(billWorkorder, commonParam);
			}
			if ((barcodeMainNewList != null) && (!barcodeMainNewList.isEmpty())) {// 替换新的条码，暂只有贴标
				for (BarcodeMain barcodeMainNew : barcodeMainNewList) {

					TrackBarcode trackBarcodeNew = new TrackBarcode();
					BeanUtil.copyNotNullProperties(trackBarcodeNew, barcodeMainNew);
					trackBarcodeNew.setBarcodeId(barcodeMainNew.getId());
					trackBarcodeNew.setCreateUserId(userId);
					trackBarcodeNew.setModifyUserId(userId);
					trackBarcodeNew.setId(null);
					trackBarcodeNew.setVersion(null);
					trackBarcodeNew.setRemark("贴标");

					barcodeMainDao.updateEntity(barcodeMainNew, commonParam);
					trackBarcodeDao.insertEntity(trackBarcodeNew, commonParam);
				}
			}

		}
		return resultMessage;
	}

	public ResultMessage updateEquipWorkDo(Long doType, CommonParam commonParam, Long factoryId,
			Long barcodeStatusDictId, EquipWork equipWork, List<BarcodeMain> barcodeMainList)
			throws BusinessException, SQLException {
		ResultMessage resultMessage = new ResultMessage();
		Long userId = new Long(commonParam.getUserId());
		try {
			String remark = "过站扫描";
			EquipFixture equipFixture = null; // 送料器
			WorkTaskProcedure workTaskProcedure = null; // 工序任务
			WorkPlanWorkstation workPlanWorkstation = null; // 工位计划
			BillWorkorder billWorkorder = null; // 工单
			StructProcessNode structProcessNode = null; // 工序

			if ((barcodeMainList == null) || (barcodeMainList.isEmpty())) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到该物品");
				return resultMessage;
			}

			if (equipWork == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到设备");
				return resultMessage;
			}

			if (!EnumEquipStatusType.AF01.getValue().equals(equipWork.getEquipStatusDictId())) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("该设备不能正常工作");
				return resultMessage;
			}

			Long structProcessId = null;
			Long billWorkorderId = null;
			for (BarcodeMain barcodeMain : barcodeMainList) { // 如果条码已经绑定了工单和工序
				structProcessId = barcodeMain.getProcessId();
				billWorkorderId = barcodeMain.getBillWorkorderId();

			}

			WorkPlanEquipParamVo workPlanEquipParamVo = new WorkPlanEquipParamVo();
			workPlanEquipParamVo.setTenantId(commonParam.getTenantId());
			workPlanEquipParamVo.setFactoryId(factoryId);
			workPlanEquipParamVo.setEquipWorkId(equipWork.getId());
			if (structProcessId != null) {
				workPlanEquipParamVo.setProcessId(structProcessId);
			}
			if (billWorkorderId != null) {
				workPlanEquipParamVo.setBillWorkorderId(billWorkorderId);
			}

			WorkPlanEquip planEquip = null; // 设备计划
			List<WorkPlanEquip> tempWorkPlanEquipList = workPlanEquipDao.selectListCanWorking(workPlanEquipParamVo,
					commonParam);
			if ((tempWorkPlanEquipList != null) && (!tempWorkPlanEquipList.isEmpty())) {
				for (WorkPlanEquip tempWorkPlanEquip : tempWorkPlanEquipList) {
					// 暂时只支持一个设备同时间只进行一个工序任务
					planEquip = tempWorkPlanEquip;
				}
			}
			if (planEquip == null) {// 输入和产出如果没有可进行的计划和任务，继续补上一次计划和任务的数量
				workPlanEquipParamVo.setIsLocked(EnumYesOrNo.NO.getValue());// 未锁定的，
				workPlanEquipParamVo.setPlanStatusDictId(EnumWorkPlanStatus.FINISH.getValue());// 未开始
				List<WorkPlanEquip> list1 = workPlanEquipDao.selectListByParamVo(workPlanEquipParamVo);
				if ((list1 != null) && (!list1.isEmpty())) {
					planEquip = list1.get(0);
				}
			}
			if (planEquip == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到设备进行的工序计划");
				return resultMessage;
			}

			structProcessNode = structProcessNodeDao.selectById(planEquip.getProcessNodeId());
			workTaskProcedure = workTaskProcedureDao.selectById(planEquip.getTaskId());

			if (EnumYesOrNo.YES.getValue().equals(workTaskProcedure.getIsLocked())) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("作业任务已经锁住");
				return resultMessage;
			}

			billWorkorder = billWorkorderDao.selectById(workTaskProcedure.getBillWorkorderId());

			WorkPlanWorkstationParamVo workPlanWorkstationParamVo = new WorkPlanWorkstationParamVo();
			workPlanWorkstationParamVo.setTenantId(commonParam.getTenantId());
			workPlanWorkstationParamVo.setFactoryId(factoryId);
			workPlanWorkstationParamVo.setTaskId(workTaskProcedure.getId());
			workPlanWorkstationParamVo.setProcessNodeId(structProcessNode.getId());
			workPlanWorkstationParamVo.setWorkstationId(planEquip.getWorkstationId());
			List<WorkPlanWorkstation> workPlanWorkstationList = workPlanWorkstationDao
					.selectListByParamVo(workPlanWorkstationParamVo);
			if ((workPlanWorkstationList != null) && (!workPlanWorkstationList.isEmpty())) {
				workPlanWorkstation = workPlanWorkstationList.get(0);
			}

			StructProcedureInstruct procedureInstructDowork = structProcedureInstructDao.getByType(commonParam,
					structProcessNode.getId(), EnumProcedureInstructType.DOWORK.getValue());
			WorkPlanEquip workPlanEquipDowork = null; // 加工设备计划
			if (procedureInstructDowork != null) {
				workPlanEquipParamVo = new WorkPlanEquipParamVo();
				workPlanEquipParamVo.setTenantId(commonParam.getTenantId());
				workPlanEquipParamVo.setFactoryId(factoryId);
				workPlanEquipParamVo.setProcessNodeId(structProcessNode.getId());
				workPlanEquipParamVo.setInstructId(procedureInstructDowork.getId());
				List<WorkPlanEquip> workPlanEquipList = workPlanEquipDao.selectListByParamVo(workPlanEquipParamVo);
				if ((workPlanEquipList != null) && (!workPlanEquipList.isEmpty())) {
					workPlanEquipDowork = workPlanEquipList.get(0);
				}

			} else {
				resultMessage.setIsSuccess(true);
			}

			if (EnumProcedureInstructType.OUT.getValue().equals(doType)) {// 如果是出站

				if (procedureInstructDowork != null) {
					if (workPlanEquipDowork != null) {
						resultMessage = updateEquipWorkDoData(doType, commonParam, factoryId, barcodeStatusDictId,
								barcodeMainList, billWorkorder, workTaskProcedure, workPlanWorkstation,
								workPlanEquipDowork, structProcessNode, procedureInstructDowork, remark);
					}
				} else {
					resultMessage.setIsSuccess(true);
				}

				if (resultMessage.getIsSuccess()) {
					StructProcedureInstruct procedureInstructOut = structProcedureInstructDao.getByType(commonParam,
							structProcessNode.getId(), EnumProcedureInstructType.OUT.getValue());

					if (procedureInstructOut != null) {
						WorkPlanEquip workPlanEquipOut = null; // 设备计划
						workPlanEquipParamVo = new WorkPlanEquipParamVo();
						workPlanEquipParamVo.setTenantId(commonParam.getTenantId());
						workPlanEquipParamVo.setFactoryId(factoryId);
						workPlanEquipParamVo.setProcessNodeId(structProcessNode.getId());
						workPlanEquipParamVo.setInstructId(procedureInstructOut.getId());
						List<WorkPlanEquip> workPlanEquipList = workPlanEquipDao
								.selectListByParamVo(workPlanEquipParamVo);
						if ((workPlanEquipList != null) && (!workPlanEquipList.isEmpty())) {
							workPlanEquipOut = workPlanEquipList.get(0);
						}

						resultMessage = updateEquipWorkDoData(doType, commonParam, factoryId, barcodeStatusDictId,
								barcodeMainList, billWorkorder, workTaskProcedure, workPlanWorkstation,
								workPlanEquipOut, structProcessNode, procedureInstructOut, remark);
					}
				}
			} else { // 如果是进站
				StructProcedureInstruct procedureInstructIn = structProcedureInstructDao
						.selectById(planEquip.getInstructId());
				resultMessage = updateEquipWorkDoData(doType, commonParam, factoryId, barcodeStatusDictId,
						barcodeMainList, billWorkorder, workTaskProcedure, workPlanWorkstation, planEquip,
						structProcessNode, procedureInstructIn, remark);

				if (resultMessage.getIsSuccess()) {
					if (procedureInstructDowork != null) {
						if (workPlanEquipDowork != null) {
							resultMessage = updateEquipWorkDoData(doType, commonParam, factoryId, barcodeStatusDictId,
									barcodeMainList, billWorkorder, workTaskProcedure, workPlanWorkstation,
									workPlanEquipDowork, structProcessNode, procedureInstructDowork, remark);
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMessage.addErr("运行异常");
		}

		return resultMessage;
	}

	private ResultMessage updateEquipWorkDoData(Long doType, CommonParam commonParam, Long factoryId,
			Long barcodeStatusDictId, List<BarcodeMain> barcodeMainList, BillWorkorder billWorkorder,
			WorkTaskProcedure workTaskProcedure, WorkPlanWorkstation workPlanWorkstation, WorkPlanEquip workPlanEquip,
			StructProcessNode structProcessNode, StructProcedureInstruct procedureInstruct, String remark) {
		EquipFixture equipFixture = null; // 送料器
		EquipWork equipWork = null;
		ResultMessage resultMessage = new ResultMessage();
		Long userId = new Long(commonParam.getUserId());
		try {

			if (workPlanEquip != null) {
				equipWork = equipWorkDao.selectById(workPlanEquip.getEquipWorkId());
			}

			Double quantity = 0d;
			Long productTypeId = null;
			Boolean isFitFinishedProduct = false;
			for (BarcodeMain barcodeMain : barcodeMainList) {
				barcodeMain = barcodeMainDao.selectById(barcodeMain.getId());
				barcodeMain.setBillTypeDictId(EnumBillType.BILL_TYPE_WORKORDER.getValue());
				barcodeMain.setBillId(billWorkorder.getId());
				barcodeMain.setBillWorkorderId(billWorkorder.getId());
				barcodeMain.setBillCode(billWorkorder.getWorkorderCode());
				barcodeMain.setBillStatusDictId(billWorkorder.getWorkorderStatusDictId());
				barcodeMain.setBillItemId(null);
				barcodeMain.setModifyUserId(userId);
				barcodeMain.setProductionlineId(workTaskProcedure.getProductionlineId());
				barcodeMain.setTaskProcedureId(workTaskProcedure.getId());
				barcodeMain.setProcessId(workTaskProcedure.getProcessId());
				barcodeMain.setProcessNodeId(structProcessNode.getId());

				if (procedureInstruct != null) {
					barcodeMain.setInstructId(procedureInstruct.getId());
					barcodeMain.setInstructTypeDictId(procedureInstruct.getInstructTypeDictId());
					remark = procedureInstruct.getInstructName();
				}

				if (equipFixture != null) {
					barcodeMain.setEquipFixtureId(equipFixture.getId());
				}

				if (equipWork != null) {
					barcodeMain.setEquipWorkId(equipWork.getId());
				}

				barcodeMain.setWorkshopId(workPlanWorkstation.getWorkshopId());
				barcodeMain.setWorkshopAreaId(workPlanWorkstation.getWorkshopAreaId());
				barcodeMain.setWorkstationId(workPlanWorkstation.getWorkstationId());

				barcodeMain.setBarcodeStatusDictId(barcodeStatusDictId);

				if (procedureInstruct != null) {
					if (EnumProcedureInstructType.OUT.getValue().equals(procedureInstruct.getInstructTypeDictId())) {

						if (procedureInstruct.getMaterialId() != null) {
							if (!barcodeMain.getMaterialId().equals(procedureInstruct.getMaterialId())) {
								// 条码对应的物品性质开始按BOM树向上级转化，直到是成品
								barcodeMain.setProductId(procedureInstruct.getProductId());
								barcodeMain.setMaterialId(procedureInstruct.getMaterialId());
								ProductMaterial productMaterial = productMaterialDao
										.selectById(procedureInstruct.getMaterialId());
								barcodeMain.setProductTypeDictId(productMaterial.getProductTypeDictId());

								if (billWorkorder.getMaterialId().equals(procedureInstruct.getMaterialId())) {
									barcodeMain.setBarcodeStatusDictId(EnumBarcodeStatus.PRODUCTION.getValue());
									isFitFinishedProduct = true;
									productTypeId = barcodeMain.getProductTypeDictId();
								}
							}
						}
					}
				}

				TrackBarcode trackBarcode = new TrackBarcode();
				BeanUtil.copyNotNullProperties(trackBarcode, barcodeMain);

				trackBarcode.setBarcodeId(barcodeMain.getId());
				trackBarcode.setCreateUserId(userId);
				trackBarcode.setModifyUserId(userId);
				trackBarcode.setId(null);
				trackBarcode.setVersion(null);
				trackBarcode.setRemark(remark);

				quantity = Arith.add(quantity, barcodeMain.getQuantity());
				barcodeMainDao.updateEntity(barcodeMain, commonParam);
				trackBarcodeDao.insertEntity(trackBarcode, commonParam);
			}

			if (procedureInstruct != null) {
				if (EnumProcedureInstructType.OUT.getValue().equals(doType)) {// 如果是出站

					if (workPlanEquip != null) {
						workPlanEquip.setQuantityOutput(Arith.add(workPlanEquip.getQuantityOutput(), quantity));
						workPlanEquip.setModifyUserId(userId);
						if (workPlanEquip.getTimeActualStart() == null) {
							workPlanEquip.setPlanStatusDictId(EnumWorkPlanStatus.DOING.getValue());
							workPlanEquip.setTimeActualStart(new Date());
						}
						if (workPlanEquip.getQuantityOutput() >= workPlanEquip.getQuantity()) {
							workPlanEquip.setPlanStatusDictId(EnumWorkPlanStatus.FINISH.getValue());
							if (workPlanEquip.getTimeActualEnd() == null) {
								workPlanEquip.setTimeActualEnd(new Date());
							}
						}

						workPlanEquipDao.updateEntity(workPlanEquip, commonParam);

						equipWork.setQuantityOutput(Arith.add(equipWork.getQuantityOutput(), quantity));
						equipWorkDao.updateEntity(equipWork, commonParam);

					}

					if (EnumProcedureInstructType.OUT.getValue().equals(procedureInstruct.getInstructTypeDictId())) {

						workTaskProcedure.setQuantityOutput(Arith.add(workTaskProcedure.getQuantityOutput(), quantity));
						workPlanWorkstation
								.setQuantityOutput(Arith.add(workPlanWorkstation.getQuantityOutput(), quantity));
						workTaskProcedure.setModifyUserId(userId);
						workPlanWorkstation.setModifyUserId(userId);

						if (workTaskProcedure.getTimeActualStart() == null) {
							workTaskProcedure.setTaskStatusDictId(EnumWorkTaskStatus.DOING.getValue());
							workTaskProcedure.setTimeActualStart(new Date());
						}
						if (workPlanWorkstation.getTimeActualStart() == null) {
							workPlanWorkstation.setPlanStatusDictId(EnumWorkPlanStatus.DOING.getValue());
							workPlanWorkstation.setTimeActualStart(new Date());
						}

						if (workTaskProcedure.getQuantityOutput() >= workTaskProcedure.getQuantity()) {
							workTaskProcedure.setTaskStatusDictId(EnumWorkTaskStatus.FINISH.getValue());
							if (workTaskProcedure.getTimeActualEnd() == null) {
								workTaskProcedure.setTimeActualEnd(new Date());
							}
						}
						if (workPlanWorkstation.getQuantityOutput() >= workPlanWorkstation.getQuantity()) {
							workPlanWorkstation.setPlanStatusDictId(EnumWorkPlanStatus.FINISH.getValue());
							if (workPlanWorkstation.getTimeActualEnd() == null) {
								workPlanWorkstation.setTimeActualEnd(new Date());
							}
						}

						if (billWorkorder.getTimeActualStart() == null) {
							billWorkorder.setWorkorderStatusDictId(EnumWorkorderStatus.AP03.getValue());
							billWorkorder.setTimeActualStart(new Date());
						}
						if (isFitFinishedProduct) {
							if (EnumProductType.FINISHED.getValue().equals(productTypeId)) {

								if (billWorkorder.getQuantityOutput() >= billWorkorder.getQuantity()) {
									billWorkorder.setWorkorderStatusDictId(EnumWorkorderStatus.AP04.getValue());
									if (billWorkorder.getTimeActualEnd() == null) {
										billWorkorder.setTimeActualEnd(new Date());
									}
								}
							}
						}

						workTaskProcedureDao.updateEntity(workTaskProcedure, commonParam);
						workPlanWorkstationDao.updateEntity(workPlanWorkstation, commonParam);
						billWorkorderDao.updateEntity(billWorkorder, commonParam);
					}
				} else { // 如果是进站

					if (equipWork != null) {
						workPlanEquip = workPlanEquipDao.selectById(workPlanEquip.getId());
						equipWork = equipWorkDao.selectById(equipWork.getId());

						if (workPlanEquip.getTimeActualStart() == null) {
							workPlanEquip.setPlanStatusDictId(EnumWorkPlanStatus.DOING.getValue());
							workPlanEquip.setTimeActualStart(new Date());
						}
						if (workPlanEquip.getQuantityInput() >= workPlanEquip.getQuantity()) {
							workPlanEquip.setPlanStatusDictId(EnumWorkPlanStatus.FINISH.getValue());
							if (workPlanEquip.getTimeActualEnd() == null) {
								workPlanEquip.setTimeActualEnd(new Date());
							}
						}
						workPlanEquip.setQuantityInput(Arith.add(workPlanEquip.getQuantityInput(), quantity));
						workPlanEquipDao.updateEntity(workPlanEquip, commonParam);
					}

					if (EnumProcedureInstructType.IN.getValue().equals(procedureInstruct.getInstructTypeDictId())) {
						workTaskProcedure.setQuantityInput(Arith.add(workTaskProcedure.getQuantityInput(), quantity));

						if (workTaskProcedure.getTimeActualStart() == null) {
							workTaskProcedure.setTaskStatusDictId(EnumWorkTaskStatus.DOING.getValue());
							workTaskProcedure.setTimeActualStart(new Date());
						}

						if (workPlanWorkstation != null) {
							workPlanWorkstation
									.setQuantityInput(Arith.add(workPlanWorkstation.getQuantityInput(), quantity));

							if (workPlanWorkstation.getTimeActualStart() == null) {
								workPlanWorkstation.setPlanStatusDictId(EnumWorkPlanStatus.DOING.getValue());
								workPlanWorkstation.setTimeActualStart(new Date());
							}

							if (workPlanWorkstation.getQuantityInput() >= workPlanWorkstation.getQuantity()) {
								workPlanWorkstation.setPlanStatusDictId(EnumWorkPlanStatus.FINISH.getValue());
								if (workPlanWorkstation.getTimeActualEnd() == null) {
									workPlanWorkstation.setTimeActualEnd(new Date());
								}
							}
							workPlanWorkstationDao.updateEntity(workPlanWorkstation, commonParam);
						}
						if (billWorkorder.getTimeActualStart() == null) {
							billWorkorder.setWorkorderStatusDictId(EnumWorkorderStatus.AP03.getValue());
							billWorkorder.setTimeActualStart(new Date());
						}

						if (billWorkorder.getQuantityOutput() >= billWorkorder.getQuantity()) {
							billWorkorder.setWorkorderStatusDictId(EnumWorkorderStatus.AP04.getValue());
							if (billWorkorder.getTimeActualEnd() == null) {
								billWorkorder.setTimeActualEnd(new Date());
							}
						}

						workTaskProcedureDao.updateEntity(workTaskProcedure, commonParam);

						billWorkorderDao.updateEntity(billWorkorder, commonParam);
					}
				}
			}

			resultMessage.setIsSuccess(true);
			resultMessage.setMessage("成功执行" + remark);

		} catch (Exception e) {
			e.printStackTrace();
			resultMessage.addErr("运行异常");
		}

		return resultMessage;
	}

	@Override
	public ResultMessage updateEnter(CommonParam commonParam, Long factoryId, EquipWork equipWork,
			List<BarcodeMain> barcodeMainList) throws BusinessException, SQLException {
		return updateEquipWorkDo(EnumProcedureInstructType.OUT.getValue(), commonParam, factoryId,
				EnumBarcodeStatus.WORKED.getValue(), equipWork, barcodeMainList);
	}

	@Override
	public ResultMessage updatePass(CommonParam commonParam, Long factoryId, Long barcodeStatusDictId,
			EquipWork equipWork, List<BarcodeMain> barcodeMainList) throws BusinessException, SQLException {
		return updateEquipWorkDo(EnumProcedureInstructType.IN.getValue(), commonParam, factoryId, barcodeStatusDictId,
				equipWork, barcodeMainList);
	}
}
