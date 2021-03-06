package com.techsoft.client.service.work;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumBarcodeStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.enums.EnumProcedureInstructType;
import com.techsoft.common.enums.EnumProductType;
import com.techsoft.common.enums.EnumStructProcedureInstructType;
import com.techsoft.common.enums.EnumWorkPlanStatus;
import com.techsoft.common.enums.EnumWorkTaskStatus;
import com.techsoft.common.enums.EnumYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.Arith;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.common.EquipFixtureStack;
import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.common.EquipWorkStack;
import com.techsoft.entity.common.EquipWorkStackProduct;
import com.techsoft.entity.common.ProductBom;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WorkPlanEquip;
import com.techsoft.entity.common.WorkPlanWorkstation;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.entity.equip.EquipWorkParamVo;
import com.techsoft.entity.equip.EquipWorkStackProductParamVo;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.entity.struct.StructProcedureInstructParamVo;
import com.techsoft.entity.work.WorkPlanEquipParamVo;
import com.techsoft.entity.work.WorkPlanWorkstationParamVo;
import com.techsoft.entity.work.WorkTaskProcedureParamVo;
import com.techsoft.entity.work.WorkTaskProcedureVo;
import com.techsoft.service.barcode.BarcodeMainService;
import com.techsoft.service.bill.BillWarehouseService;
import com.techsoft.service.bill.BillWorkorderService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.equip.EquipFixtureService;
import com.techsoft.service.equip.EquipFixtureStackService;
import com.techsoft.service.equip.EquipSpecsFixtureService;
import com.techsoft.service.equip.EquipWorkService;
import com.techsoft.service.equip.EquipWorkStackProductService;
import com.techsoft.service.equip.EquipWorkStackService;
import com.techsoft.service.product.ProductBomService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructProcedureInstructService;
import com.techsoft.service.struct.StructProcessNodeService;
import com.techsoft.service.struct.StructProcessService;
import com.techsoft.service.struct.StructProductionlineService;
import com.techsoft.service.struct.StructWorkshopService;
import com.techsoft.service.struct.StructWorkstationService;
import com.techsoft.service.sys.UserPassportService;
import com.techsoft.service.track.TrackBarcodeService;
import com.techsoft.service.work.WorkPlanEquipService;
import com.techsoft.service.work.WorkPlanMaterialService;
import com.techsoft.service.work.WorkPlanWorkstationService;
import com.techsoft.service.work.WorkTaskProcedureService;

@org.springframework.stereotype.Service
public class ClientWorkTaskProcedureServiceImpl extends BaseClientServiceImpl<WorkTaskProcedure>
		implements ClientWorkTaskProcedureService {

	@com.alibaba.dubbo.config.annotation.Reference
	private WorkPlanWorkstationService workPlanWorkstationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WorkPlanEquipService workPlanEquipService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcedureInstructService structProcedureInstructService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WorkTaskProcedureService workTaskProcedureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessNodeService structProcessNodeService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessService structProcessService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopService structWorkshopService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWorkorderService billWorkorderService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProductionlineService structProductionlineService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkstationService structWorkstationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductBomService productBomService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipWorkService equipWorkService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipWorkStackService equipWorkStackService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipWorkStackProductService equipWorkStackProductService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipFixtureService equipFixtureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BarcodeMainService barcodeMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private TrackBarcodeService trackBarcodeService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WorkPlanMaterialService workPlanMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipFixtureStackService equipFixtureStackService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWarehouseService billWarehouseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipSpecsFixtureService equipSpecsFixtureService;

	@Override
	public BaseService<WorkTaskProcedure> getBaseService() {
		return workTaskProcedureService;
	}

	private WorkTaskProcedureVo getVo(WorkTaskProcedure workTaskProcedure, CommonParam commonParam)
			throws BusinessException, SQLException {
		WorkTaskProcedureVo vo = new WorkTaskProcedureVo(workTaskProcedure);
		// TODO 此处填充其它关联字段的处理代码
		if (vo.getProcessNodeId() != null && vo.getProcessNodeId() > 0L) {
			StructProcessNode structProcessNode = structProcessNodeService.selectById(vo.getProcessNodeId(),
					commonParam);
			if (structProcessNode != null) {
				vo.setStructProcessNode(structProcessNode);
			}
		}
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory factory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (factory != null) {
				vo.setFactory(factory);
			}
		}
		if (vo.getBillWorkorderId() != null && vo.getBillWorkorderId() > 0L) {
			BillWorkorder billWorkorder = billWorkorderService.selectById(vo.getBillWorkorderId(), commonParam);
			if (billWorkorder != null) {
				vo.setBillWorkorder(billWorkorder);
			}
		}
		if (vo.getWorkshopId() != null && vo.getWorkshopId() > 0L) {
			StructWorkshop workshop = structWorkshopService.selectById(vo.getWorkshopId(), commonParam);
			if (workshop != null) {
				vo.setWorkshop(workshop);
			}
		}
		if (vo.getTaskStatusDictId() != null && vo.getTaskStatusDictId() > 0L) {
			ConfigDictionary taskStatusDic = configDictionaryService.selectById(vo.getTaskStatusDictId(), commonParam);
			if (taskStatusDic != null) {
				vo.setTaskStatusDic(taskStatusDic);
			}
		}
		if (vo.getBomId() != null && vo.getBomId() > 0L) {
			ProductBom productBom = productBomService.selectById(vo.getBomId(), commonParam);
			if (productBom != null) {
				vo.setProductBom(productBom);
			}
		}
		if (vo.getProductionlineId() != null && vo.getProductionlineId() > 0L) {
			StructProductionline productionline = structProductionlineService.selectById(vo.getProductionlineId(),
					commonParam);
			if (productionline != null) {
				vo.setProductionline(productionline);
			}
		}
		if (vo.getProductId() != null && vo.getProductId() > 0L) {
			ProductMain productMain = productMainService.selectById(vo.getProductId(), commonParam);
			if (productMain != null) {
				vo.setProductMain(productMain);
			}
		}
		if (vo.getMaterialId() != null && vo.getMaterialId() > 0L) {
			ProductMaterial productMaterial = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if (productMaterial != null) {
				// 物品类型
				if (productMaterial.getProductTypeDictId() != null && productMaterial.getProductTypeDictId() > 0L) {
					ConfigDictionary productType = configDictionaryService
							.selectById(productMaterial.getProductTypeDictId(), commonParam);
					if (productType != null) {
						vo.setProductType(productType);
					}
				}
				// 物品规格值
				ProductMaterialVo productMaterialVo = new ProductMaterialVo();
				productMaterialVo.setSkuValue(productMaterial.getSkuValue());
				vo.setProductMaterialVo(productMaterialVo);
				vo.setProductMaterial(productMaterial);
			}
		}
		if (vo.getExecutiveTypeDictId() != null && vo.getExecutiveTypeDictId() > 0L) {
			ConfigDictionary executive = configDictionaryService.selectById(vo.getExecutiveTypeDictId(), commonParam);
			if (executive != null) {
				vo.setExecutive(executive);
			}
		}
		if (vo.getCreateUserId() != null && vo.getCreateUserId() > 0L) {
			UserPassport userPassport = userPassportService.selectById(vo.getCreateUserId(), commonParam);
			if (userPassport != null) {
				vo.setUserPassport(userPassport);
			}
		}
		if (vo.getModifyUserId() != null && vo.getModifyUserId() > 0L) {
			UserPassport modifyUser = userPassportService.selectById(vo.getModifyUserId(), commonParam);
			if (modifyUser != null) {
				vo.setModifyUser(modifyUser);
			}
		}
		// 工艺路线名称
		if (vo.getProcessId() != null && vo.getProcessId() > 0L) {
			StructProcess structProcess = structProcessService.selectById(vo.getProcessId(), commonParam);
			if (structProcess != null) {
				vo.setStructProcess(structProcess);
			}
		}
		return vo;
	}

	private WorkTaskProcedureVo getExtendVo(WorkTaskProcedure workTaskProcedure, CommonParam commonParam)
			throws BusinessException, SQLException {
		WorkTaskProcedureVo vo = this.getVo(workTaskProcedure, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	}

	private List<WorkTaskProcedureVo> getVoList(List<WorkTaskProcedure> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WorkTaskProcedureVo> voList = new ArrayList<WorkTaskProcedureVo>();
		for (WorkTaskProcedure entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<WorkTaskProcedureVo> getExtendVoList(List<WorkTaskProcedure> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WorkTaskProcedureVo> voList = new ArrayList<WorkTaskProcedureVo>();
		for (WorkTaskProcedure entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public WorkTaskProcedureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WorkTaskProcedure entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<WorkTaskProcedureVo> selectListVoByParamVo(WorkTaskProcedureParamVo workTaskProcedure,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (workTaskProcedure == null) {
			workTaskProcedure = new WorkTaskProcedureParamVo();
		}
		workTaskProcedure.setTenantId(commonParam.getTenantId());

		List<WorkTaskProcedure> list = (List<WorkTaskProcedure>) this.getBaseService()
				.selectListByParamVo(workTaskProcedure, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WorkTaskProcedureVo> selectPageVoByParamVo(WorkTaskProcedureParamVo workTaskProcedure,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (workTaskProcedure == null) {
			workTaskProcedure = new WorkTaskProcedureParamVo();
		}
		workTaskProcedure.setTenantId(commonParam.getTenantId());

		PageInfo<WorkTaskProcedure> list = (PageInfo<WorkTaskProcedure>) this.getBaseService()
				.selectPageByParamVo(workTaskProcedure, commonParam, pageNo, pageSize);
		List<WorkTaskProcedureVo> volist = new ArrayList<WorkTaskProcedureVo>();

		Iterator<WorkTaskProcedure> iter = list.getList().iterator();
		WorkTaskProcedureVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WorkTaskProcedureVo> vpage = new Page<WorkTaskProcedureVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public WorkTaskProcedureVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		WorkTaskProcedure entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<WorkTaskProcedureVo> selectListExtendVoByParamVo(WorkTaskProcedureParamVo workTaskProcedure,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (workTaskProcedure == null) {
			workTaskProcedure = new WorkTaskProcedureParamVo();
		}
		workTaskProcedure.setTenantId(commonParam.getTenantId());

		List<WorkTaskProcedure> list = (List<WorkTaskProcedure>) this.getBaseService()
				.selectListByParamVo(workTaskProcedure, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WorkTaskProcedureVo> selectPageExtendVoByParamVo(WorkTaskProcedureParamVo workTaskProcedure,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (workTaskProcedure == null) {
			workTaskProcedure = new WorkTaskProcedureParamVo();
		}
		workTaskProcedure.setTenantId(commonParam.getTenantId());

		PageInfo<WorkTaskProcedure> list = (PageInfo<WorkTaskProcedure>) this.getBaseService()
				.selectPageByParamVo(workTaskProcedure, commonParam, pageNo, pageSize);
		List<WorkTaskProcedureVo> volist = new ArrayList<WorkTaskProcedureVo>();

		Iterator<WorkTaskProcedure> iter = list.getList().iterator();
		WorkTaskProcedureVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WorkTaskProcedureVo> vpage = new Page<WorkTaskProcedureVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(WorkTaskProcedureParamVo workTaskProcedureParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		WorkTaskProcedure workTaskProcedure = null;
		try {
			if (workTaskProcedureParamVo.getId() == null) {// 新增

				workTaskProcedureParamVo.setTenantId(commonParam.getTenantId());
				workTaskProcedure = workTaskProcedureService.saveOrUpdate(workTaskProcedureParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				WorkTaskProcedure workTaskProcedureVoTemp = this.selectById(workTaskProcedureParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(workTaskProcedureVoTemp, workTaskProcedureParamVo);

				workTaskProcedure = workTaskProcedureService.saveOrUpdate(workTaskProcedureVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(workTaskProcedure);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}

	@Override
	public ResultMessage passByScanner(CommonParam commonParam, Long factoryId, String macaddress, String code) {

		ResultMessage resultMessage = new ResultMessage();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(macaddress)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("扫描器地址不能为空");
			return resultMessage;
		}

		if (StringUtils.isBlank(code)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("料品或物品编码不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(commonParam.getUserId())) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("操作人不能为空");
			return resultMessage;
		}

		EquipFixture equipFixture = null; // 料器
		List<BarcodeMain> barcodeMainList = new ArrayList<BarcodeMain>();
		try {
			BarcodeMain barcodeMainVo = barcodeMainService.getByCode(code, commonParam);

			if (barcodeMainVo != null) {
				barcodeMainList.add(barcodeMainVo);

			} else {
				equipFixture = equipFixtureService.getByFixtureCode(code, commonParam);
				if (equipFixture != null) {
					BarcodeMainParamVo barcodeMainParamVo = new BarcodeMainParamVo();
					barcodeMainParamVo.setTenantId(commonParam.getTenantId());
					barcodeMainParamVo.setFactoryId(factoryId);
					barcodeMainParamVo.setEquipFixtureId(equipFixture.getId());
					barcodeMainList = barcodeMainService.selectListByParamVo(barcodeMainParamVo, commonParam);
				}
			}

			if ((barcodeMainList == null) || (barcodeMainList.isEmpty())) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到该物品");
				return resultMessage;
			}

			EquipWork equipWorkScanner = equipWorkService.getByMacaddress(macaddress, commonParam);// 设备

			if (equipWorkScanner == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到扫描仪设备");
				return resultMessage;
			}

			resultMessage = workTaskProcedureService.updatePass(commonParam, factoryId,
					EnumBarcodeStatus.WORKED.getValue(), equipWorkScanner, barcodeMainList);

		} catch (Exception e) {
			e.printStackTrace();
			resultMessage.addErr("运行异常");
		}

		return resultMessage;
	}

	@Override
	public ResultMessage feedByConnectRaw(CommonParam commonParam, Long factoryId, String barcodeOld,
			String barcodeNew) {
		ResultMessage resultMessage = new ResultMessage();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(barcodeOld)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("旧条码不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(barcodeNew)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("新条码不能为空");
			return resultMessage;
		}

		try {
			BarcodeMain barcodeMainOld = barcodeMainService.getByCode(barcodeOld, commonParam);
			if (barcodeMainOld == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到旧条码的物品");
				return resultMessage;
			}
			BarcodeMain barcodeMainNew = barcodeMainService.getByCode(barcodeNew, commonParam);
			if (barcodeMainNew == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到新条码的物品");
				return resultMessage;
			}
			if (barcodeMainNew.getQuantity().equals(0d)) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("新条码已经用完");
				return resultMessage;
			}
			if (!EnumBarcodeStatus.OUTSTORE.getValue().equals(barcodeMainNew.getBarcodeStatusDictId())) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("该条码不是出库状态");
				return resultMessage;
			}
			if (barcodeMainNew.getEquipFixtureId() != null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("该物品已经绑定到料器上");
				return resultMessage;
			}
			if (barcodeMainOld.getProcessNodeId() == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到旧条码进行的工序");
				return resultMessage;
			}

			barcodeMainNew.setProductionlineId(barcodeMainOld.getProductionlineId());
			barcodeMainNew.setTaskProcedureId(barcodeMainOld.getTaskProcedureId());
			barcodeMainNew.setProcessId(barcodeMainOld.getProcessId());
			barcodeMainNew.setProcessNodeId(barcodeMainOld.getProcessNodeId());
			barcodeMainNew.setInstructId(barcodeMainOld.getInstructId());
			barcodeMainNew.setEquipWorkId(barcodeMainOld.getEquipWorkId());
			barcodeMainNew.setEquipWorkStackId(barcodeMainOld.getEquipWorkStackId());
			barcodeMainNew.setEquipFixtureId(barcodeMainOld.getEquipFixtureId());
			barcodeMainNew.setEquipFixtureStackId(barcodeMainOld.getEquipFixtureStackId());
			barcodeMainNew.setBillTypeDictId(EnumBillType.BILL_TYPE_WORKORDER.getValue());
			barcodeMainNew.setBillWorkorderId(barcodeMainOld.getBillWorkorderId());
			barcodeMainNew.setBillId(barcodeMainOld.getBillId());
			barcodeMainNew.setBillCode(barcodeMainOld.getBillCode());
			barcodeMainNew.setBillStatusDictId(barcodeMainOld.getBillStatusDictId());
			barcodeMainNew.setBillItemId(barcodeMainOld.getBillItemId());
			barcodeMainNew.setWorkshopId(barcodeMainOld.getWorkshopId());
			barcodeMainNew.setWorkshopAreaId(barcodeMainOld.getWorkshopAreaId());
			barcodeMainNew.setWorkstationId(barcodeMainOld.getWorkstationId());

			BillWorkorder billWorkorder = billWorkorderService.selectById(barcodeMainNew.getBillWorkorderId(),
					commonParam);

			WorkTaskProcedure workTaskProcedure = workTaskProcedureService
					.selectById(barcodeMainOld.getTaskProcedureId(), commonParam);

			EquipWork equipWork = equipWorkService.selectById(barcodeMainOld.getEquipWorkId(), commonParam);

			WorkPlanEquipParamVo workPlanEquipParamVo = new WorkPlanEquipParamVo();
			workPlanEquipParamVo.setTenantId(commonParam.getTenantId());
			workPlanEquipParamVo.setFactoryId(factoryId);
			workPlanEquipParamVo.setEquipWorkId(equipWork.getId());
			workPlanEquipParamVo.setProcessId(barcodeMainOld.getProcessId());
			workPlanEquipParamVo.setBillWorkorderId(barcodeMainOld.getBillWorkorderId());
			workPlanEquipParamVo.setTaskId(barcodeMainOld.getTaskProcedureId());
			WorkPlanEquip workPlanEquip = null;
			List<WorkPlanEquip> workPlanEquipList = workPlanEquipService.selectListCanWorking(workPlanEquipParamVo,
					commonParam);
			if ((workPlanEquipList != null) && (!workPlanEquipList.isEmpty())) {
				for (WorkPlanEquip tempWorkPlanEquip : workPlanEquipList) {
					workPlanEquip = tempWorkPlanEquip;
				}
			}

			WorkPlanWorkstationParamVo workPlanWorkstationParamVo = new WorkPlanWorkstationParamVo();
			workPlanWorkstationParamVo.setTenantId(commonParam.getTenantId());
			workPlanWorkstationParamVo.setFactoryId(factoryId);
			workPlanWorkstationParamVo.setProcessId(barcodeMainOld.getProcessId());
			workPlanWorkstationParamVo.setBillWorkorderId(barcodeMainOld.getBillWorkorderId());
			workPlanWorkstationParamVo.setTaskId(barcodeMainOld.getTaskProcedureId());
			workPlanWorkstationParamVo.setWorkstationId(barcodeMainOld.getWorkstationId());

			WorkPlanWorkstation workPlanWorkstation = null;
			List<WorkPlanWorkstation> workPlanWorkstationList = workPlanWorkstationService
					.selectListByParamVo(workPlanWorkstationParamVo, commonParam);

			if ((workPlanWorkstationList != null) && (!workPlanWorkstationList.isEmpty())) {
				for (WorkPlanWorkstation tempWorkPlanWorkstation : workPlanWorkstationList) {
					workPlanWorkstation = tempWorkPlanWorkstation;
				}
			}

			StructWorkstation structWorkstation = structWorkstationService
					.selectById(workPlanWorkstation.getWorkstationId(), commonParam);
			WorkTaskProcedureVo workTaskProcedureVo = new WorkTaskProcedureVo(workTaskProcedure);
			workTaskProcedureVo.setStructWorkstation(structWorkstation);
			workTaskProcedureVo.setWorkPlanWorkstation(workPlanWorkstation);
			StructProcedureInstruct procedureInstruct = structProcedureInstructService
					.selectById(barcodeMainOld.getInstructId(), commonParam);

			List<BarcodeMain> barcodeMainRawList = new ArrayList<BarcodeMain>();
			barcodeMainRawList.add(barcodeMainNew);
			resultMessage = workTaskProcedureService.updateFeed(commonParam, factoryId, barcodeMainRawList, null,
					billWorkorder, workTaskProcedureVo, procedureInstruct, equipWork, workPlanEquip, null, null,
					"接料上料");

			if (resultMessage.getIsSuccess()) {

				barcodeMainOld.setQuantity(0d);
				barcodeMainOld.setEquipFixtureId(null);
				barcodeMainOld.setEquipFixtureStackId(null);
				barcodeMainOld.setEquipWorkId(null);
				barcodeMainOld.setEquipWorkStackId(null);
				Long userId = new Long(commonParam.getUserId());

				TrackBarcode trackBarcode = new TrackBarcode();
				BeanUtil.copyNotNullProperties(trackBarcode, barcodeMainOld);
				trackBarcode.setBarcodeId(barcodeMainOld.getId());
				trackBarcode.setCreateUserId(userId);
				trackBarcode.setModifyUserId(userId);
				trackBarcode.setId(null);
				trackBarcode.setVersion(null);
				trackBarcode.setRemark("已消耗完被接料");

				trackBarcodeService.saveOrUpdate(trackBarcode, commonParam);
				barcodeMainService.saveOrUpdate(barcodeMainOld, commonParam);

				resultMessage.setIsSuccess(true);
				resultMessage.setMessage("操作成功");
			}

			return resultMessage;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMessage.addErr("运行异常");
		}

		return null;
	}

	@Override
	public ResultMessage labeling(CommonParam commonParam, Long factoryId, String workstationCode, String equipCode,
			String barcodeRaw, String barcodeNewList) {

		// TODO Auto-generated method stub
		ResultMessage resultMessage = new ResultMessage();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
			return resultMessage;
		}
		if ((StringUtils.isBlank(workstationCode)) && (StringUtils.isBlank(equipCode))) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工位编码或设备编码不能为空");
			return resultMessage;

		}
		if (StringUtils.isBlank(barcodeRaw)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("包装条码不能为空");
			return resultMessage;
		}

		if (StringUtils.isBlank(barcodeNewList)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("新标条码不能为空");
			return resultMessage;
		}
		try {

			BarcodeMain barcodeMainRaw = barcodeMainService.getByCode(barcodeRaw, commonParam);
			if (barcodeMainRaw == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到包装条码");
				return resultMessage;
			}
			List<BarcodeMain> barcodeMainNewList = new ArrayList<BarcodeMain>();
			String[] barcodeNewArray = barcodeNewList.split(",");
			if ((barcodeNewArray != null) && (barcodeNewArray.length >= 1)) {
				for (int n = 0; n < barcodeNewArray.length; n++) {
					BarcodeMain barcodeMainNew = barcodeMainService.getByCode(barcodeNewArray[n], commonParam);
					if (barcodeMainNew != null) {
						barcodeMainNewList.add(barcodeMainNew);
					} else {
						resultMessage.setIsSuccess(false);
						resultMessage.addErr(barcodeNewArray[n] + "找不到该物品");
						return resultMessage;
					}
				}
			}

			if ((barcodeMainNewList == null) || (barcodeMainNewList.isEmpty())) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到新标条码");
				return resultMessage;
			}
			if (barcodeMainRaw.getQuantity().equals(0d)) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("包装里的没有可以利用的物品数量了");
				return resultMessage;
			}
			if (barcodeMainNewList.size() != barcodeMainRaw.getQuantity().intValue()) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("包装里的物品数量是" + barcodeMainRaw.getQuantity().intValue() + ",和新标条码数量不一致");
				return resultMessage;
			}

			BillWorkorder billWorkorder = null; // 工单
			StructProcedureInstruct procedureInstruct = null; // 工序指令

			billWorkorder = getBillWorkorderByBarcode(commonParam, barcodeMainRaw);

			WorkTaskProcedureVo workTaskProcedureVo = null;
			if (StringUtils.isNotBlank(equipCode)) {
				resultMessage = getVoByEquip(commonParam, factoryId, billWorkorder.getId(), null, equipCode);
				if (resultMessage.getIsSuccess()) {
					workTaskProcedureVo = (WorkTaskProcedureVo) resultMessage.getBaseEntity();
				} else {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("找不到作业设备");
					return resultMessage;
				}
			}

			if (StringUtils.isNotBlank(workstationCode)) {
				resultMessage = getVoByWorkstation(commonParam, factoryId, billWorkorder.getId(), null,
						workstationCode);
				if (resultMessage.getIsSuccess()) {
					workTaskProcedureVo = (WorkTaskProcedureVo) resultMessage.getBaseEntity();
				} else {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("找不到作业工位");
					return resultMessage;
				}
			}

			if (workTaskProcedureVo != null) {

				StructWorkstation structWorkstation = workTaskProcedureVo.getStructWorkstation();

				procedureInstruct = structProcedureInstructService.getByType(commonParam,
						workTaskProcedureVo.getProcessNodeId(), EnumProcedureInstructType.LABELING.getValue());

				if (procedureInstruct == null) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("找不到该操作的工序指令");
					return resultMessage;
				}

				for (BarcodeMain barcodeMain : barcodeMainNewList) {
					barcodeMain.setProductionlineId(workTaskProcedureVo.getProductionlineId());
					barcodeMain.setTaskProcedureId(workTaskProcedureVo.getId());
					barcodeMain.setProcessId(workTaskProcedureVo.getProcessId());
					barcodeMain.setProcessNodeId(workTaskProcedureVo.getProcessNodeId());
					if (procedureInstruct != null) {
						barcodeMain.setInstructId(procedureInstruct.getId());
						barcodeMain.setInstructTypeDictId(procedureInstruct.getInstructTypeDictId());
					}

					barcodeMain.setWorkshopId(structWorkstation.getWorkshopId());
					barcodeMain.setWorkshopAreaId(structWorkstation.getWorkshopAreaId());
					barcodeMain.setWorkstationId(structWorkstation.getId());

					barcodeMain.setBillTypeDictId(EnumBillType.BILL_TYPE_WORKORDER.getValue());
					barcodeMain.setBillWorkorderId(billWorkorder.getId());
					barcodeMain.setBillId(billWorkorder.getId());
					barcodeMain.setBillCode(billWorkorder.getWorkorderCode());
					barcodeMain.setBillStatusDictId(billWorkorder.getWorkorderStatusDictId());
					barcodeMain.setBillItemId(null);
					barcodeMain.setBarcodeStatusDictId(EnumBarcodeStatus.WORKED.getValue());
					barcodeMain.setFromBarcode(barcodeMainRaw.getBarcode());
					barcodeMain.setFromMaterialId(barcodeMainRaw.getMaterialId());
					barcodeMain.setQuantity(1d);
					barcodeMain.setEquipFixtureId(null);
					barcodeMain.setEquipFixtureStackId(null);
					barcodeMain.setEquipWorkId(null);
					barcodeMain.setEquipWorkStackId(null);

				}

				List<BarcodeMain> barcodeMainRawList = new ArrayList<BarcodeMain>();
				barcodeMainRawList.add(barcodeMainRaw);
				resultMessage = workTaskProcedureService.updateFeed(commonParam, factoryId, barcodeMainRawList,
						barcodeMainNewList, billWorkorder, workTaskProcedureVo, procedureInstruct, null, null, null,
						null, "拆包装贴标");

			} else {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到作业任务");
				return resultMessage;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMessage.addErr("运行异常");
		}

		return resultMessage;
	}

	@Override
	public ResultMessage feedByStack(CommonParam commonParam, Long factoryId, String equipStackCode,
			String fixtureStackCode, String barcode) {
		ResultMessage resultMessage = new ResultMessage();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
			return resultMessage;
		}

		if (StringUtils.isBlank(equipStackCode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("设备栈位编码不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(fixtureStackCode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("载料器栈位编码不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(barcode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("物料条码不能为空");
			return resultMessage;
		}
		try {

			EquipWork equipWork = null; // 设备
			EquipFixture equipFixture = null; // 载料器或送料器
			EquipWorkStack equipWorkStack = null;// 设备的栈位
			EquipFixtureStack equipFixtureStack = null; // 载料器或送料器的栈位

			WorkPlanEquip workPlanEquip = null; // 设备计划

			StructProcedureInstruct procedureInstruct = null; // 工序指令
			BillWorkorder billWorkorder = null; // 工单

			BarcodeMain barcodeMainRaw = barcodeMainService.getByCode(barcode, commonParam);
			if (barcodeMainRaw == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到物品");
				return resultMessage;
			}

			if (StringUtils.isNotBlank(fixtureStackCode)) {
				equipFixtureStack = equipFixtureStackService.getByStackCode(fixtureStackCode, commonParam);
				if (equipFixtureStack != null) {
					equipFixture = equipFixtureService.selectById(equipFixtureStack.getFixtureId(), commonParam);

				}
			}

			if (equipFixture == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到载料器或送料器");
				return resultMessage;
			}

			if (StringUtils.isNotBlank(equipStackCode)) {

				equipWorkStack = equipWorkStackService.getByStackCode(equipStackCode, commonParam);

				if (equipWorkStack != null) {
					equipWork = equipWorkService.selectById(equipWorkStack.getEquipWorkId(), commonParam);

					if (equipWorkStack.getEquipFixtureId() != null) {
						if (!equipFixture.getId().equals(equipWorkStack.getEquipFixtureId())) {
							resultMessage.setIsSuccess(false);
							resultMessage.addErr("该设备栈位已经绑定了其它料器，请确认操作或先解绑");
							return resultMessage;
						}

					}

				}
			}

			if (equipWork == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到设备");
				return resultMessage;
			}

			WorkTaskProcedureVo workTaskProcedureVo = null;

			billWorkorder = getBillWorkorderByBarcode(commonParam, barcodeMainRaw);

			resultMessage = getVoByEquip(commonParam, factoryId, billWorkorder.getId(), equipWork.getId(), null);

			if (resultMessage.getIsSuccess()) {
				workTaskProcedureVo = (WorkTaskProcedureVo) resultMessage.getBaseEntity();
			} else {
				return resultMessage;
			}

			if (workTaskProcedureVo != null) {

				workPlanEquip = workTaskProcedureVo.getWorkPlanEquip();
				procedureInstruct = structProcedureInstructService.getByType(commonParam,
						workTaskProcedureVo.getProcessNodeId(), EnumProcedureInstructType.IN.getValue());

				if (procedureInstruct == null) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("找不到该操作的工序输入指令");
					return resultMessage;
				}

				if (equipFixture != null) {
					barcodeMainRaw.setEquipFixtureId(equipFixture.getId());
				}

				if (equipFixtureStack != null) {
					barcodeMainRaw.setEquipFixtureStackId(equipFixtureStack.getId());
				}
				if (equipWorkStack != null) {
					barcodeMainRaw.setEquipWorkStackId(equipWorkStack.getId());
				}

				if ((equipFixtureStack != null) && (equipWork != null)) {

					EquipSpecsFixture equipSpecsFixture = equipSpecsFixtureService
							.selectById(equipFixture.getSpecsFixtureId(), commonParam);

					EquipWorkStackProductParamVo equipWorkStackProductParamVo = new EquipWorkStackProductParamVo();
					equipWorkStackProductParamVo.setTenantId(commonParam.getTenantId());
					equipWorkStackProductParamVo.setEquipWorkId(equipWork.getId());
					equipWorkStackProductParamVo.setEquipWorkStackId(equipWorkStack.getId());
					equipWorkStackProductParamVo.setRawMaterialId(barcodeMainRaw.getMaterialId());
					equipWorkStackProductParamVo.setMaterialId(workTaskProcedureVo.getMaterialId());
					equipWorkStackProductParamVo.setSpecsFixtureId(equipSpecsFixture.getId());
					equipWorkStackProductParamVo.setSpecsFixtureAreaId(equipFixtureStack.getSpecsFixtureAreaId());
					List<EquipWorkStackProduct> equipWorkStackProductList = equipWorkStackProductService
							.selectListByParamVo(equipWorkStackProductParamVo, commonParam);

					if ((equipWorkStackProductList == null) || (equipWorkStackProductList.isEmpty())) {
						resultMessage.setIsSuccess(false);
						resultMessage
								.addErr(barcodeMainRaw.getBarcode() + equipSpecsFixture.getFixtureSpecsName() + "栈位错误");
						return resultMessage;

					}

				}

				List<BarcodeMain> barcodeMainRawList = new ArrayList<BarcodeMain>();
				barcodeMainRawList.add(barcodeMainRaw);
				resultMessage = workTaskProcedureService.updateFeed(commonParam, factoryId, barcodeMainRawList, null,
						billWorkorder, workTaskProcedureVo, procedureInstruct, equipWork, workPlanEquip, null, null,
						"通过栈位上料");

				if (resultMessage.getIsSuccess()) {
					if (equipWorkStack != null) {

						Long userId = new Long(commonParam.getUserId());

						equipWorkStack.setEquipFixtureId(equipFixture.getId());
						if (equipFixtureStack != null) {
							equipWorkStack.setEquipFixtureStackId(equipFixtureStack.getId());
						}
						equipWorkStack.setModifyUserId(userId);
						equipWorkStackService.saveOrUpdate(equipWorkStack, commonParam);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			resultMessage.addErr("运行异常");
		}

		return resultMessage;
	}

	@Override
	public ResultMessage feedByFixture(CommonParam commonParam, Long factoryId, String equipCode, String fixtureCode,
			String barcode) {
		ResultMessage resultMessage = new ResultMessage();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(equipCode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("设备编码不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(fixtureCode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("料器编码不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(barcode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("物料条码不能为空");
			return resultMessage;
		}
		try {

			Long userId = new Long(commonParam.getUserId());

			EquipWork equipWork = null; // 设备
			EquipFixture equipFixture = null; // 载料器或送料器

			WorkPlanEquip workPlanEquip = null; // 设备计划
			StructProcedureInstruct procedureInstruct = null; // 工序指令
			BillWorkorder billWorkorder = null; // 工单

			BarcodeMain barcodeMainRaw = barcodeMainService.getByCode(barcode, commonParam);
			if (barcodeMainRaw == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到物品");
				return resultMessage;
			}

			equipFixture = equipFixtureService.getByFixtureCode(fixtureCode, commonParam);
			if (equipFixture == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到料器");
				return resultMessage;
			}

			equipWork = equipWorkService.getByEquipCode(equipCode, commonParam);
			if (equipWork != null) {

				billWorkorder = getBillWorkorderByBarcode(commonParam, barcodeMainRaw);

				WorkTaskProcedureVo workTaskProcedureVo = null;
				resultMessage = getVoByEquip(commonParam, factoryId, billWorkorder.getId(), equipWork.getId(), null);
				if (resultMessage.getIsSuccess()) {
					workTaskProcedureVo = (WorkTaskProcedureVo) resultMessage.getBaseEntity();
				} else {
					return resultMessage;
				}

				if (workTaskProcedureVo != null) {

					workPlanEquip = workTaskProcedureVo.getWorkPlanEquip();
					procedureInstruct = structProcedureInstructService.getByType(commonParam,
							workTaskProcedureVo.getProcessNodeId(), EnumProcedureInstructType.IN.getValue());

					if (procedureInstruct == null) {
						resultMessage.setIsSuccess(false);
						resultMessage.addErr("找不到该操作的工序输入指令");
						return resultMessage;
					}
					barcodeMainRaw.setEquipFixtureId(equipFixture.getId());
					barcodeMainRaw.setEquipWorkId(equipWork.getId());
					List<BarcodeMain> barcodeMainRawList = new ArrayList<BarcodeMain>();
					barcodeMainRawList.add(barcodeMainRaw);
					resultMessage = workTaskProcedureService.updateFeed(commonParam, factoryId, barcodeMainRawList,
							null, billWorkorder, workTaskProcedureVo, procedureInstruct, equipWork, workPlanEquip, null,
							null, "通过栈位上料");

				}
			} else {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到设备");
				return resultMessage;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultMessage;
	}

	@Override
	public ResultMessage enterByUnbindFixtureScanner(CommonParam commonParam, Long factoryId, String macaddress,
			String equipFixtureCode) {
		ResultMessage resultMessage = new ResultMessage();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(macaddress)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("扫描器地址不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(equipFixtureCode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("料器编码不能为空");
			return resultMessage;
		}
		try {
			EquipFixture equipFixture = null; // 载料器或送料器

			equipFixture = equipFixtureService.getByFixtureCode(equipFixtureCode, commonParam);
			if (equipFixture == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到料器");
				return resultMessage;
			}

			EquipWork equipWorkScanner = equipWorkService.getByMacaddress(macaddress, commonParam);// 设备

			if (equipWorkScanner != null) {

				List<BarcodeMain> barcodeMainList = new ArrayList<BarcodeMain>();
				BarcodeMainParamVo barcodeMainParamVo = new BarcodeMainParamVo();
				barcodeMainParamVo.setTenantId(commonParam.getTenantId());
				barcodeMainParamVo.setFactoryId(factoryId);
				barcodeMainParamVo.setEquipFixtureId(equipFixture.getId());
				barcodeMainList = barcodeMainService.selectListByParamVo(barcodeMainParamVo, commonParam);
				if ((barcodeMainList == null) || (barcodeMainList.isEmpty())) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("找不到物品");
					return resultMessage;
				}

				resultMessage = workTaskProcedureService.updateEnter(commonParam, factoryId, equipWorkScanner,
						barcodeMainList);

				if (resultMessage.getIsSuccess()) {
					for (BarcodeMain barcodeMain : barcodeMainList) {
						barcodeMain = barcodeMainService.selectById(barcodeMain.getId(), commonParam);
						barcodeMain.setEquipFixtureId(null);
						barcodeMain.setEquipFixtureStackId(null);
						barcodeMain.setEquipWorkId(null);
						barcodeMain.setEquipWorkStackId(null);
						barcodeMainService.saveOrUpdateFull(barcodeMain, commonParam);
					}

					resultMessage.setIsSuccess(true);
					resultMessage.setMessage("解绑操作成功");
				}

			} else {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到扫描仪设备");
				return resultMessage;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultMessage;
	}

	@Override
	public ResultMessage enterByBindFixtureScanner(CommonParam commonParam, Long factoryId, String macaddress,
			String code) {
		ResultMessage resultMessage = new ResultMessage();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(macaddress)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("扫描器地址不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(code)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("料器或物品编码不能为空");
			return resultMessage;
		}
		try { 
			EquipFixture equipFixture = null; // 载料器
			BarcodeMain barcodeMainVo = null; // 物品
			equipFixture = equipFixtureService.getByFixtureCode(code, commonParam);
			if (equipFixture == null) {
				barcodeMainVo = barcodeMainService.getByCode(code, commonParam);
			}
			if ((equipFixture == null) && (barcodeMainVo == null)) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("让不到料器或物品");
				return resultMessage;
			}

			EquipWork equipWorkScanner = equipWorkService.getByMacaddress(macaddress, commonParam);// 设备

			if (equipWorkScanner != null) {
				if (barcodeMainVo != null) {
					List<BarcodeMain> barcodeMainList = new ArrayList<BarcodeMain>();
					barcodeMainList.add(barcodeMainVo);
					resultMessage = workTaskProcedureService.updateEnter(commonParam, factoryId, equipWorkScanner,
							barcodeMainList);
				}

			} else {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到扫描仪设备");
				return resultMessage;

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultMessage;
	}

	@Override
	public ResultMessage enterByAssembleScanner(CommonParam commonParam, Long factoryId, String macaddress,
			String barcodeList) {
		ResultMessage resultMessage = new ResultMessage();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(macaddress)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("扫描器地址不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(barcodeList)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("物品条码不能为空");
			return resultMessage;
		}
		try {
			EquipWork equipWork = null; // 设备

			WorkPlanWorkstation workPlanWorkstation = null; // 工位计划
			WorkPlanEquip workPlanEquip = null; // 设备计划

			StructProcessNode structProcessNode = null; // 工序
			StructWorkstation structWorkstation = null; // 工位
			StructProcedureInstruct procedureInstruct = null; // 工序指令
			BillWorkorder billWorkorder = null; // 工单

			EquipWork equipWorkScanner = equipWorkService.getByMacaddress(macaddress, commonParam);// 设备

			if (equipWorkScanner == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到扫描仪设备");
				return resultMessage;
			}

			BarcodeMain barcodeMainRaw = null;
			List<BarcodeMain> barcodeMainRawList = new ArrayList<BarcodeMain>();
			String[] barcodeArray = barcodeList.split(",");
			if ((barcodeArray != null) && (barcodeArray.length >= 1)) {
				for (int n = 0; n < barcodeArray.length; n++) {
					BarcodeMain barcodeMain = barcodeMainService.getByCode(barcodeArray[n], commonParam);
					if (barcodeMain != null) {
						if (!EnumBarcodeStatus.OUTSTORE.getValue().equals(barcodeMain.getBarcodeStatusDictId())) {
							resultMessage.setIsSuccess(false);
							resultMessage.addErr("该条码不是出库状态");
							return resultMessage;
						}
						if (barcodeMain.getEquipFixtureId() != null) {
							resultMessage.setIsSuccess(false);
							resultMessage.addErr("该物品已经绑定到料器上");
							return resultMessage;
						}
						if ((EnumProductType.FINISHED.getValue().equals(barcodeMain.getProductTypeDictId()))
								|| (EnumProductType.SEMIFINISHED.getValue()
										.equals(barcodeMain.getProductTypeDictId()))) {
							barcodeMainRaw = barcodeMain;
						}
						barcodeMainRawList.add(barcodeMain);
					} else {
						resultMessage.setIsSuccess(false);
						resultMessage.addErr(barcodeArray[n] + "找不到该物品");
						return resultMessage;
					}
				}
			}
			if ((barcodeMainRawList == null) || (barcodeMainRawList.isEmpty())) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到条码");
				return resultMessage;
			}

			if (barcodeMainRaw == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到该操作的工单");
				return resultMessage;
			}

			billWorkorder = getBillWorkorderByBarcode(commonParam, barcodeMainRaw);

			BarcodeMain composeBarcodeMain = null; // 组合的物品条码
			Integer numberLevel = null;
			List<ProductBom> productBomList = productBomService.selectListBomTree(billWorkorder.getBomId(),
					commonParam);
			for (BarcodeMain barcodeMain : barcodeMainRawList) { // 如果多个物品，根据bom查谁是上一级。
				for (ProductBom productBom : productBomList) {
					if (barcodeMain.getMaterialId().equals(productBom.getMaterialId())) {
						if (numberLevel == null) {
							composeBarcodeMain = barcodeMain;
							numberLevel = productBom.getNumberLevel();
						} else if (numberLevel > productBom.getNumberLevel()) {
							composeBarcodeMain = barcodeMain;
							numberLevel = productBom.getNumberLevel();
						}

					}
				}
			}

			for (BarcodeMain barcodeMain : barcodeMainRawList) {
				if (!barcodeMain.getBarcode().equals(composeBarcodeMain.getBarcode())) {
					barcodeMain.setComposeBarcode(composeBarcodeMain.getBarcode());
					barcodeMain.setComposeMaterialId(composeBarcodeMain.getMaterialId());
				}
			}

			resultMessage = getVoByEquip(commonParam, factoryId, billWorkorder.getId(), equipWorkScanner.getId(), null);
			WorkTaskProcedureVo workTaskProcedureVo = null;
			if (resultMessage.getIsSuccess()) {
				workTaskProcedureVo = (WorkTaskProcedureVo) resultMessage.getBaseEntity();
			} else {
				return resultMessage;
			}

			if (workTaskProcedureVo != null) {
				WorkPlanEquip workPlanEquipScanner = workTaskProcedureVo.getWorkPlanEquip();

				structWorkstation = workTaskProcedureVo.getStructWorkstation();
				workPlanWorkstation = workTaskProcedureVo.getWorkPlanWorkstation();

				procedureInstruct = structProcedureInstructService.getByType(commonParam,
						workTaskProcedureVo.getProcessNodeId(), EnumProcedureInstructType.IN.getValue());

				if (procedureInstruct == null) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("找不到该操作的工序输入指令");
					return resultMessage;
				}

				StructProcedureInstruct procedureInstructUsed = null;
				StructProcedureInstructParamVo structProcedureInstructParamVo = new StructProcedureInstructParamVo();
				structProcedureInstructParamVo.setProcessNodeId(workTaskProcedureVo.getProcessNodeId());
				structProcedureInstructParamVo.setInstructTypeDictId(EnumStructProcedureInstructType.USED.getValue());
				List<StructProcedureInstruct> structProcedureInstructList = structProcedureInstructService
						.selectListByParamVo(structProcedureInstructParamVo, commonParam);
				if ((structProcedureInstructList != null) && (!structProcedureInstructList.isEmpty())) {
					for (StructProcedureInstruct tempProcedureInstruct : structProcedureInstructList) {
						procedureInstructUsed = tempProcedureInstruct;
					}
				}
				if (procedureInstructUsed != null) {
					WorkPlanEquipParamVo workPlanEquipParamVo = new WorkPlanEquipParamVo();
					workPlanEquipParamVo.setTenantId(commonParam.getTenantId());
					workPlanEquipParamVo.setFactoryId(factoryId);
					workPlanEquipParamVo.setBillWorkorderId(billWorkorder.getId());
					workPlanEquipParamVo.setProcessNodeId(workTaskProcedureVo.getProcessNodeId());
					workPlanEquipParamVo.setInstructId(procedureInstructUsed.getId());
					workPlanEquipParamVo.setTaskId(workTaskProcedureVo.getId());
					workPlanEquipParamVo.setIsLocked(EnumYesOrNo.NO.getValue());// 未锁定的，
					List<WorkPlanEquip> workPlanEquipList = workPlanEquipService
							.selectListByParamVo(workPlanEquipParamVo, commonParam);
					if ((workPlanEquipList != null) && (!workPlanEquipList.isEmpty())) {
						workPlanEquip = workPlanEquipList.get(0);
						equipWork = equipWorkService.selectById(workPlanEquip.getEquipWorkId(), commonParam);
					}
				}

				if (workPlanEquip == null) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("找不到该操作的工序设备");
					return resultMessage;
				}

				resultMessage = workTaskProcedureService.updateFeed(commonParam, factoryId, barcodeMainRawList, null,
						billWorkorder, workTaskProcedureVo, procedureInstruct, equipWork, workPlanEquip, null, null,
						"通过自动扫描仪上料");

				if (resultMessage.getIsSuccess()) {
					for (BarcodeMain barcodeMain : barcodeMainRawList) {
						if (workPlanEquipScanner.getTimeActualStart() == null) {
							workPlanEquipScanner.setPlanStatusDictId(EnumWorkPlanStatus.DOING.getValue());
							workPlanEquipScanner.setTimeActualStart(new Date());
						}
						if (workPlanEquipScanner.getQuantityInput() >= workPlanEquipScanner.getQuantity()) {
							workPlanEquipScanner.setPlanStatusDictId(EnumWorkPlanStatus.FINISH.getValue());
							if (workPlanEquipScanner.getTimeActualEnd() == null) {
								workPlanEquipScanner.setTimeActualEnd(new Date());
							}
						}
						workPlanEquipScanner.setQuantityInput(
								Arith.add(workPlanEquipScanner.getQuantityInput(), barcodeMain.getQuantity()));
						workPlanEquipService.saveOrUpdate(workPlanEquipScanner, commonParam);
					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public ResultMessage unbindFixture(CommonParam commonParam, Long factoryId, String equipCode,
			String equipFixtureCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage unbindEquipStack(CommonParam commonParam, Long factoryId, String equipStackCode) {
		ResultMessage resultMessage = new ResultMessage();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(equipStackCode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("设备栈位编码不能为空");
			return resultMessage;
		}
		try {

			EquipWork equipWork = null; // 设备
			EquipWorkStack equipWorkStack = null;// 设备的栈位

			equipWorkStack = equipWorkStackService.getByStackCode(equipStackCode, commonParam);
			if (equipWorkStack != null) {

				equipWork = equipWorkService.selectById(equipWorkStack.getEquipWorkId(), commonParam);

				Long userId = new Long(commonParam.getUserId());

				List<BarcodeMain> barcodeMainList = new ArrayList<BarcodeMain>();
				BarcodeMainParamVo barcodeMainParamVo = new BarcodeMainParamVo();
				barcodeMainParamVo.setTenantId(commonParam.getTenantId());
				barcodeMainParamVo.setFactoryId(factoryId);
				barcodeMainParamVo.setEquipWorkStackId(equipWorkStack.getId());
				barcodeMainList = barcodeMainService.selectListByParamVo(barcodeMainParamVo, commonParam);

				for (BarcodeMain barcodeMain : barcodeMainList) {

					barcodeMain.setModifyUserId(userId);
					barcodeMain.setBarcodeStatusDictId(EnumBarcodeStatus.OUTSTORE.getValue());
					barcodeMain.setInstructId(null);

					TrackBarcode trackBarcode = new TrackBarcode();
					BeanUtil.copyNotNullProperties(trackBarcode, barcodeMain);

					trackBarcode.setBarcodeId(barcodeMain.getId());
					trackBarcode.setCreateUserId(userId);
					trackBarcode.setModifyUserId(userId);
					trackBarcode.setId(null);
					trackBarcode.setVersion(null);
					trackBarcode.setRemark("解绑设备栈位");
					trackBarcodeService.saveOrUpdate(trackBarcode, commonParam);

					barcodeMain.setEquipFixtureId(null);
					barcodeMain.setEquipFixtureStackId(null);
					barcodeMain.setEquipWorkId(null);
					barcodeMain.setEquipWorkStackId(null);
					barcodeMainService.saveOrUpdateFull(barcodeMain, commonParam);

					resultMessage.setIsSuccess(true);
					resultMessage.setMessage("解绑操作成功");
				}

				equipWorkStack.setEquipFixtureId(null);
				equipWorkStack.setEquipFixtureStackId(null);
				equipWorkStack.setModifyUserId(userId);
				equipWorkStackService.saveOrUpdateFull(equipWorkStack, commonParam);

			} else {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到设备");
				return resultMessage;
			}

		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultMessage;
	}

	@Override
	public ResultMessage getVoByWorkstation(CommonParam commonParam, Long factoryId, Long billWorkorderId,
			Long workstationId, String workstationCode) throws BusinessException, SQLException {

		ResultMessage resultMessage = new ResultMessage();
		WorkTaskProcedureVo workTaskProcedureVo = null;
		if (factoryId == null) {
			return resultMessage;
		}

		StructWorkstation structWorkstation = null;
		if (StringUtils.isNotBlank(workstationCode)) {
			structWorkstation = structWorkstationService.getByCode(workstationCode, commonParam);
		}
		if (workstationId != null) {
			structWorkstation = structWorkstationService.selectById(workstationId, commonParam);
		}
		if (structWorkstation != null) {

			WorkPlanWorkstationParamVo workPlanWorkstationParamVo = new WorkPlanWorkstationParamVo();
			workPlanWorkstationParamVo.setTenantId(commonParam.getTenantId());
			workPlanWorkstationParamVo.setFactoryId(factoryId);
			workPlanWorkstationParamVo.setBillWorkorderId(billWorkorderId);
			workPlanWorkstationParamVo.setWorkstationId(structWorkstation.getId());
			workPlanWorkstationParamVo.setIsLocked(EnumYesOrNo.NO.getValue());// 未锁定的，
			List<WorkPlanWorkstation> list = workPlanWorkstationService.selectListCanWorking(workPlanWorkstationParamVo,
					commonParam);
			if ((list != null) && (!list.isEmpty())) {
				WorkPlanWorkstation workPlanWorkstation = list.get(0);
				WorkTaskProcedure workTaskProcedure = workTaskProcedureService
						.selectById(workPlanWorkstation.getTaskId(), commonParam);

				if (EnumYesOrNo.YES.getValue().equals(workTaskProcedure.getIsLocked())) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("作业任务已经锁住");
					return resultMessage;
				}
				if (EnumWorkTaskStatus.FINISH.getValue().equals(workTaskProcedure.getIsLocked())) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("作业任务已经结束");
					return resultMessage;

				}

				workTaskProcedureVo = getVo(workTaskProcedure, commonParam);
				workTaskProcedureVo.setStructWorkstation(structWorkstation);
				workTaskProcedureVo.setWorkPlanWorkstation(workPlanWorkstation);
				resultMessage.setIsSuccess(true);
				resultMessage.setBaseEntity(workTaskProcedureVo);
			}
		}

		return resultMessage;
	}

	public ResultMessage getVoByEquip(CommonParam commonParam, Long factoryId, Long billWorkorderId, Long equipId,
			String equipCode) throws BusinessException, SQLException {

		ResultMessage resultMessage = new ResultMessage();
		WorkTaskProcedureVo workTaskProcedureVo = null;
		if (factoryId == null) {
			return resultMessage;
		}

		EquipWork equipWork = null;
		if (StringUtils.isNotBlank(equipCode)) {
			equipWork = equipWorkService.getByEquipCode(equipCode, commonParam);
		}
		if (equipId != null) {
			equipWork = equipWorkService.selectById(equipId, commonParam);
		}
		if (equipWork != null) {

			WorkPlanEquipParamVo workPlanEquipParamVo = new WorkPlanEquipParamVo();
			workPlanEquipParamVo.setTenantId(commonParam.getTenantId());
			workPlanEquipParamVo.setFactoryId(factoryId);
			workPlanEquipParamVo.setBillWorkorderId(billWorkorderId);
			workPlanEquipParamVo.setEquipWorkId(equipWork.getId());
			workPlanEquipParamVo.setIsLocked(EnumYesOrNo.NO.getValue());// 未锁定的，
			List<WorkPlanEquip> list = workPlanEquipService.selectListCanWorking(workPlanEquipParamVo, commonParam);
			if ((list != null) && (!list.isEmpty())) {
				WorkPlanEquip workPlanEquip = list.get(0);
				WorkTaskProcedure workTaskProcedure = workTaskProcedureService.selectById(workPlanEquip.getTaskId(),
						commonParam);

				if (EnumYesOrNo.YES.getValue().equals(workTaskProcedure.getIsLocked())) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("作业任务已经锁住");
					return resultMessage;
				}
				if (EnumWorkTaskStatus.FINISH.getValue().equals(workTaskProcedure.getIsLocked())) {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("作业任务已经结束");
					return resultMessage;

				}

				workTaskProcedureVo = getVo(workTaskProcedure, commonParam);
				workTaskProcedureVo.setEquipWork(equipWork);
				workTaskProcedureVo.setWorkPlanEquip(workPlanEquip);
				resultMessage.setIsSuccess(true);
				resultMessage.setBaseEntity(workTaskProcedureVo);
			}

			if (workTaskProcedureVo != null) {
				resultMessage = getVoByWorkstation(commonParam, factoryId, billWorkorderId,
						equipWork.getWorkstationId(), null);
				if (resultMessage.getIsSuccess()) {
					WorkTaskProcedureVo workTaskProcedureVo2 = (WorkTaskProcedureVo) resultMessage.getBaseEntity();
					if (workTaskProcedureVo2 != null) {
						workTaskProcedureVo.setStructWorkstation(workTaskProcedureVo2.getStructWorkstation());
						workTaskProcedureVo.setWorkPlanWorkstation(workTaskProcedureVo2.getWorkPlanWorkstation());
						resultMessage.setIsSuccess(true);
						resultMessage.setBaseEntity(workTaskProcedureVo);
					} else {
						resultMessage.setIsSuccess(false);
						resultMessage.addErr("找不到工序任务");
						return resultMessage;
					}
				}
			}
		}

		return resultMessage;
	}

	public BillWorkorder getBillWorkorderByBarcode(CommonParam commonParam, BarcodeMain barcodeMain)
			throws BusinessException, SQLException {
		BillWorkorder billWorkorder = null;
		if (barcodeMain.getBillWorkorderId() != null) {
			billWorkorder = billWorkorderService.selectById(barcodeMain.getBillWorkorderId(), commonParam);

		} else {
			if (EnumBillType.BILL_TYPE_WAREHOUSE_PICKING.getValue().equals(barcodeMain.getBillTypeDictId())) {

				BillWarehouse billWarehouse = billWarehouseService.selectById(barcodeMain.getBillId(), commonParam);
				if (EnumBillType.BILL_TYPE_WORKORDER.getValue().equals(billWarehouse.getFromBillTypeDictId())) {
					billWorkorder = billWorkorderService.selectById(billWarehouse.getFromBillId(), commonParam);
				}

			}
		}

		return billWorkorder;
	}

	public BillWorkorder getBillWorkorderByBarcode(CommonParam commonParam, Long factoryId, Long barcodeId,
			String barcode) throws BusinessException, SQLException {
		BillWorkorder billWorkorder = null;

		return billWorkorder;
	}

	@Override
	public ResultMessage feedByWorkstation(CommonParam commonParam, Long factoryId, String workstationCode,
			String barcode) {
		// TODO Auto-generated method stub
		return null;
	}

}
