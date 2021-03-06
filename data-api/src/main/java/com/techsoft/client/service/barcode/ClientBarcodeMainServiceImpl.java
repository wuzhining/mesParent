package com.techsoft.client.service.barcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumBarcodeRule;
import com.techsoft.common.enums.EnumBarcodeStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.barcode.BarcodeMainVo;
import com.techsoft.entity.common.BarcodeBatchNumber;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillSaleorder;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.common.EquipWorkStack;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.common.TrackPallet;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehousePallet;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.service.barcode.BarcodeMainService;
import com.techsoft.service.bill.BillDeliveryService;
import com.techsoft.service.bill.BillInspectService;
import com.techsoft.service.bill.BillPurchaseService;
import com.techsoft.service.bill.BillSaleorderService;
import com.techsoft.service.bill.BillWarehouseAllocationService;
import com.techsoft.service.bill.BillWarehouseItemService;
import com.techsoft.service.bill.BillWarehouseOutService;
import com.techsoft.service.bill.BillWarehouseService;
import com.techsoft.service.bill.BillWorkorderService;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.equip.EquipFixtureService;
import com.techsoft.service.equip.EquipWorkService;
import com.techsoft.service.equip.EquipWorkStackService;
import com.techsoft.service.firm.FirmPartnerService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructProcedureInstructService;
import com.techsoft.service.struct.StructProcessNodeService;
import com.techsoft.service.struct.StructProductionlineService;
import com.techsoft.service.struct.StructWarehouseService;
import com.techsoft.service.struct.StructWorkshopAreaService;
import com.techsoft.service.struct.StructWorkshopService;
import com.techsoft.service.struct.StructWorkstationService;
import com.techsoft.service.sys.UserPassportService;
import com.techsoft.service.track.TrackBarcodeService;
import com.techsoft.service.track.TrackPalletService;
import com.techsoft.service.warehouse.WarehouseAreaService;
import com.techsoft.service.warehouse.WarehouseLocationService;
import com.techsoft.service.warehouse.WarehousePalletService;
import com.techsoft.service.warehouse.WarehouseRackService;
import com.techsoft.service.work.WorkTaskProcedureService;

@org.springframework.stereotype.Service
public class ClientBarcodeMainServiceImpl extends BaseClientServiceImpl<BarcodeMain>
		implements ClientBarcodeMainService {
	@com.alibaba.dubbo.config.annotation.Reference
	private BarcodeMainService barcodeMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private TrackPalletService trackPalletService;
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmPartnerService firmPartnerService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWarehouseService structWarehouseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseLocationService warehouseLocationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehousePalletService warehousePalletService;
	@com.alibaba.dubbo.config.annotation.Reference
	private TrackBarcodeService trackBarcodeService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWarehouseItemService billWarehouseItemService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWarehouseService billWarehouseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWarehouseOutService billWarehouseOutService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWarehouseAllocationService billWarehouseAllocationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseAreaService warehouseAreaService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseRackService warehouseRackService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WorkTaskProcedureService workTaskProcedureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessNodeService structProcessNodeService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcedureInstructService structProcedureInstructService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopService structWorkshopService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopAreaService structWorkshopAreaService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkstationService structWorkstationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipWorkService equipWorkService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipWorkStackService equipWorkStackService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipFixtureService equipFixtureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProductionlineService structProductionlineService;
	
	
	//操作人
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
	//工厂名称
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	//单据
	@com.alibaba.dubbo.config.annotation.Reference
	private BillDeliveryService billDeliveryService;//发货单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillSaleorderService billSaleorderService;//销售单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillPurchaseService billPurchaseService;//采购单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillInspectService billInspectService;//检验单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWorkorderService billWorkorderService;//工单
	
	

	@Override
	public BaseService<BarcodeMain> getBaseService() {
		return barcodeMainService;
	}

	private BarcodeMainVo getVo(BarcodeMain barcodeMain, CommonParam commonParam)
			throws BusinessException, SQLException {
		BarcodeMainVo vo = new BarcodeMainVo(barcodeMain);
		if (vo.getBarcodeRuleDictId() != null && vo.getBarcodeRuleDictId() > 0L) {
			ConfigDictionary barcodeRuleDic = configDictionaryService.selectById(vo.getBarcodeRuleDictId(), commonParam);
			if (barcodeRuleDic != null) {
				vo.setBarcodeRuleDic(barcodeRuleDic);
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
				if(productMaterial.getSkuValue()!=null&&productMaterial.getSkuValue()!=""){
					ProductMaterialVo productMateriaVo=new ProductMaterialVo();
					productMateriaVo.setSkuValue(productMaterial.getSkuValue());
					vo.setProductMaterialVo(productMateriaVo);
					
				}
				vo.setProductMaterial(productMaterial);
			}
		}
		if (vo.getBarcodePackboxId() != null && vo.getBarcodePackboxId() > 0L) {
			BarcodeMain barcodePackbox = barcodeMainService.selectById(vo.getBarcodePackboxId(), commonParam);
			if (barcodePackbox != null) {
				vo.setBarcodePackBox(barcodePackbox);
			}
		}
		// 状态
		if (vo.getBarcodeStatusDictId() != null && vo.getBarcodeStatusDictId() > 0L) {
			ConfigDictionary barcodeStatusDic = configDictionaryService.selectById(vo.getBarcodeStatusDictId(),
					commonParam);
			if (barcodeStatusDic != null) {
				vo.setBarcodeStatusDic(barcodeStatusDic);
			}
		}
		if (vo.getPalletId() != null && vo.getPalletId() > 0L) {
			WarehousePallet warehousePallet = warehousePalletService.selectById(vo.getPalletId(), commonParam);
			if (warehousePallet != null) {
				vo.setWarehousePallet(warehousePallet);
			}
		}
		if (vo.getBillItemId() != null && vo.getBillItemId() > 0L) {
			BillWarehouseItem billWarehouseItem = billWarehouseItemService.selectById(vo.getBillItemId(), commonParam);
			if (billWarehouseItem != null) {
				vo.setBillWarehouseItem(billWarehouseItem);
			}
		}
		if (vo.getPartnerId() != null && vo.getPartnerId() > 0L) {
			FirmPartner firmPartner = firmPartnerService.selectById(vo.getPartnerId(), commonParam);
			if (firmPartner != null) {
				vo.setFirmPartner(firmPartner);
			}
		}
		//仓库
		if (vo.getWarehouseId() != null && vo.getWarehouseId() > 0L) {
			StructWarehouse structWarehouse = structWarehouseService.selectById(vo.getWarehouseId(), commonParam);
			if (structWarehouse != null) {
				vo.setStructWarehouse(structWarehouse);
			}
		}
		//仓库区域
		if (vo.getLocationId() != null && vo.getLocationId() > 0L) {
			WarehouseLocation warehouseLocation = warehouseLocationService.selectById(vo.getLocationId(), commonParam);
			if (warehouseLocation != null) {
				vo.setWarehouseLocation(warehouseLocation);
			}
		}

		// 单据类型
		if (vo.getBillTypeDictId() != null && vo.getBillTypeDictId() > 0L) {
			ConfigDictionary BarcodebillType = configDictionaryService.selectById(vo.getBillTypeDictId(), commonParam);
			if (BarcodebillType != null) {
				vo.setBarcodebillType(BarcodebillType);
				 //单据
				if (vo.getBillTypeDictId().equals(EnumBillType.BILL_TYPE_DELIVERY.getValue())) {//发货单
				        BillDelivery billDelivery = billDeliveryService.selectById(vo.getBillId(), commonParam);
				        if (billDelivery!=null) {
				        	 vo.setBillCode(billDelivery.getBillCode());
						}
				} else if (vo.getBillTypeDictId().equals(EnumBillType.BILL_TYPE_SALEORDER.getValue())) {//销售单
					    BillSaleorder billSaleorder = billSaleorderService.selectById(vo.getBillId(), commonParam);
					    if (billSaleorder!=null) {
					    	vo.setBillCode(billSaleorder.getBillCode());
						}				   
				} else if (vo.getBillTypeDictId().equals(EnumBillType.BILL_TYPE_EXAMINE.getValue())) {//检验单
					    BillInspect billInspect = billInspectService.selectById(vo.getBillId(), commonParam);
					    if (billInspect!=null) {
					     	vo.setBillCode(billInspect.getInspectCode()); 
						}
		        } else if (vo.getBillTypeDictId().equals(EnumBillType.BILL_TYPE_EXAMINE.getValue())){//工单
		        	    BillWorkorder billWorkorder = billWorkorderService.selectById(vo.getBillId(), commonParam);
		        	    if (billWorkorder!=null) {
		        	    	vo.setBillCode(billWorkorder.getWorkorderCode()); 
						}    
		        }else{//仓库库单
		        	    BillWarehouse billWarehouse =billWarehouseService.selectById(vo.getBillId(), commonParam);
		        	    if(billWarehouse != null){
						    vo.setBillCode(billWarehouse.getBillCode()); 
		        	    }
		        }
			}
		}
		
		//操作人
		if (vo.getCreateUserId() != null && vo.getCreateUserId() > 0L) {
			UserPassport userPassport = userPassportService.selectById(vo.getCreateUserId(), commonParam);
			if (userPassport != null) {
				vo.setUserPassportList(userPassport);
			}
		}
		
		//工厂名称
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactorylist(structFactory);
			}
		}
		// 单据状态
		if (vo.getBillStatusDictId() != null && vo.getBillStatusDictId() > 0L) {
			ConfigDictionary billStatusDic = configDictionaryService.selectById(vo.getBillStatusDictId(), commonParam);
			if (billStatusDic != null) {
				vo.setBillStatusDic(billStatusDic);
			}
		}
		// 仓库区域
		if (vo.getRackId() != null && vo.getRackId() > 0L) {
			WarehouseRack warehouseRack = warehouseRackService.selectById(vo.getRackId(), commonParam);
			if (warehouseRack != null) {
				vo.setWarehouseRack(warehouseRack);
			}
		}
		// 工作工序
		if (vo.getTaskProcedureId() != null && vo.getTaskProcedureId() > 0L) {
			WorkTaskProcedure workTaskProcedure = workTaskProcedureService.selectById(vo.getTaskProcedureId(), commonParam);
			if (workTaskProcedure != null) {
				vo.setWorkTaskProcedure(workTaskProcedure);
			}
		}
		// 工序
		if (vo.getProcessNodeId() != null && vo.getProcessNodeId() > 0L) {
			StructProcessNode structProcessNode = structProcessNodeService.selectById(vo.getProcessNodeId(), commonParam);
			if (structProcessNode != null) {
				vo.setStructProcessNode(structProcessNode);
			}
		}
		// 工序指令
		if (vo.getInstructId() != null && vo.getInstructId() > 0L) {
			StructProcedureInstruct structProcedureInstruct = structProcedureInstructService.selectById(vo.getInstructId(), commonParam);
			if (structProcedureInstruct != null) {
				vo.setStructProcedureInstruct(structProcedureInstruct);
			}
		}
		// 车间
		if (vo.getWorkshopId() != null && vo.getWorkshopId() > 0L) {
			StructWorkshop structWorkshop = structWorkshopService.selectById(vo.getWorkshopId(), commonParam);
			if (structWorkshop != null) {
				vo.setStructWorkshop(structWorkshop);
			}
		}
		// 车间区域
		if (vo.getWorkshopAreaId() != null && vo.getWorkshopAreaId() > 0L) {
			StructWorkshopArea structWorkshopArea = structWorkshopAreaService.selectById(vo.getWorkshopAreaId(), commonParam);
			if (structWorkshopArea != null) {
				vo.setStructWorkshopArea(structWorkshopArea);
			}
		}
		// 工位
		if (vo.getWorkstationId() != null && vo.getWorkstationId() > 0L) {
			StructWorkstation structWorkstation = structWorkstationService.selectById(vo.getWorkstationId(), commonParam);
			if (structWorkstation != null) {
				vo.setStructWorkstation(structWorkstation);
			}
		}
		// 设备
		if (vo.getEquipWorkId() != null && vo.getEquipWorkId() > 0L) {
			EquipWork equipWork = equipWorkService.selectById(vo.getEquipWorkId(), commonParam);
			if (equipWork != null) {
				vo.setEquipWork(equipWork);
			}
		}
		// 设备栈位
		if (vo.getEquipWorkStackId() != null && vo.getEquipWorkStackId() > 0L) {
			EquipWorkStack equipWorkStack = equipWorkStackService.selectById(vo.getEquipWorkStackId(), commonParam);
			if (equipWorkStack != null) {
				vo.setEquipWorkStack(equipWorkStack);
			}
		}
		// 工具设备
		if (vo.getEquipFixtureId() != null && vo.getEquipFixtureId() > 0L) {
			EquipFixture equipFixture = equipFixtureService.selectById(vo.getEquipFixtureId(), commonParam);
			if (equipFixture != null) {
				vo.setEquipFixture(equipFixture);
			}
		}
		// 生产线
		if (vo.getProductionlineId() != null && vo.getProductionlineId() > 0L) {
			StructProductionline structProductionline = structProductionlineService.selectById(vo.getProductionlineId(), commonParam);
			if (structProductionline != null) {
				vo.setStructProductionline(structProductionline);
			}
		}
		//物品规格编码
		if(vo.getMaterialId() != null && vo.getMaterialId() > 0L){
			ProductMaterial materialCode = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if(materialCode != null){
				vo.setMaterialCode(materialCode);
			}
		}
		//物品类型
		if(vo.getMaterialId() != null && vo.getMaterialId() > 0L){
			ProductMaterial materialCode = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if(materialCode != null){
				ConfigDictionary dictionary = configDictionaryService.selectById(materialCode.getProductTypeDictId(), commonParam);
				vo.setProductType(dictionary);
			}
		}
		return vo;
	}

	private BarcodeMainVo getExtendVo(BarcodeMain barcodeMain, CommonParam commonParam)
			throws BusinessException, SQLException {
		BarcodeMainVo vo = this.getVo(barcodeMain, commonParam);

		return vo;
	}

	private List<BarcodeMainVo> getVoList(List<BarcodeMain> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BarcodeMainVo> voList = new ArrayList<BarcodeMainVo>();
		for (BarcodeMain entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<BarcodeMainVo> getExtendVoList(List<BarcodeMain> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BarcodeMainVo> voList = new ArrayList<BarcodeMainVo>();
		for (BarcodeMain entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public BarcodeMainVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BarcodeMain entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<BarcodeMainVo> selectListVoByParamVo(BarcodeMainParamVo barcodeMain, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (barcodeMain == null) {
			barcodeMain = new BarcodeMainParamVo();
		}
		barcodeMain.setTenantId(commonParam.getTenantId());

		List<BarcodeMain> list = (List<BarcodeMain>) this.getBaseService().selectListByParamVo(barcodeMain,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BarcodeMainVo> selectPageVoByParamVo(BarcodeMainParamVo barcodeMain, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (barcodeMain == null) {
			barcodeMain = new BarcodeMainParamVo();
		}
		barcodeMain.setTenantId(commonParam.getTenantId());

		PageInfo<BarcodeMain> list = (PageInfo<BarcodeMain>) this.getBaseService().selectPageByParamVo(barcodeMain,
				commonParam, pageNo, pageSize);
		List<BarcodeMainVo> volist = new ArrayList<BarcodeMainVo>();

		Iterator<BarcodeMain> iter = list.getList().iterator();
		BarcodeMainVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BarcodeMainVo> vpage = new Page<BarcodeMainVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public BarcodeMainVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BarcodeMain entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<BarcodeMainVo> selectListExtendVoByParamVo(BarcodeMainParamVo barcodeMain, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (barcodeMain == null) {
			barcodeMain = new BarcodeMainParamVo();
		}
		barcodeMain.setTenantId(commonParam.getTenantId());

		List<BarcodeMain> list = (List<BarcodeMain>) this.getBaseService().selectListByParamVo(barcodeMain,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BarcodeMainVo> selectPageExtendVoByParamVo(BarcodeMainParamVo barcodeMain, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (barcodeMain == null) {
			barcodeMain = new BarcodeMainParamVo();
		}
		barcodeMain.setTenantId(commonParam.getTenantId());

		PageInfo<BarcodeMain> list = (PageInfo<BarcodeMain>) this.getBaseService().selectPageByParamVo(barcodeMain,
				commonParam, pageNo, pageSize);
		List<BarcodeMainVo> volist = new ArrayList<BarcodeMainVo>();

		Iterator<BarcodeMain> iter = list.getList().iterator();
		BarcodeMainVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BarcodeMainVo> vpage = new Page<BarcodeMainVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(BarcodeMainParamVo barcodeMainParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		if (commonParam.getUserId() != null) {
			barcodeMainParamVo.setCreateUserId(Long.parseLong(commonParam.getUserId()));
		} else {
			resultMessage.addErr("请先登录");
			return resultMessage;
		}
		if (commonParam.getTenantId() != null) {
			barcodeMainParamVo.setTenantId(commonParam.getTenantId());
		}

		BarcodeMain barcodeMain = null;
		try {
			if (barcodeMainParamVo.getId() == null) {// 新增
				// 新增的到条码的状态必须是新建状态
				ConfigDictionary selectById = configDictionaryService.selectById(EnumBarcodeStatus.NEW.getValue(),
						commonParam);

				if (selectById.getId() != null) {
					barcodeMainParamVo.setBarcodeStatusDictId(selectById.getId());
				}
				barcodeMainParamVo.setTenantId(commonParam.getTenantId());
				barcodeMain = barcodeMainService.saveOrUpdate(barcodeMainParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				BarcodeMain barcodeMainVoTemp = this.selectById(barcodeMainParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(barcodeMainVoTemp, barcodeMainParamVo);

				barcodeMain = barcodeMainService.saveOrUpdate(barcodeMainVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(barcodeMain);
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
	public BarcodeMain getVoByCode(String code, CommonParam commonParam) throws BusinessException, SQLException {
	 
		return barcodeMainService.getByCode(code, commonParam);
	}

	@Override
	public ResultMessage offBarcode(BarcodeMainVo barcodeMainVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			// 得到该条码的物品规格信息
			BarcodeMain barcodeMain = billWarehouseOutService.updateOffBarcode(barcodeMainVo, commonParam);
			// 返回最外箱条码给pda
			BarcodeMainVo bMainVo = this.getVo(barcodeMain, commonParam);
			List<BarcodeMainVo> list = new ArrayList<>();
			list.add(bMainVo);
			resultMessage.put(list);
			resultMessage.addErr("下架成功");
			resultMessage.setIsSuccess(true);

		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public ResultMessage batchInsertBarcodeMain(List<BarcodeMain> barcodeMainList, CommonParam commonParam)
			throws BusinessException, SQLException {
		ResultMessage resultMessage = new ResultMessage();
		BarcodeMainParamVo barcodeMainParamVo = new BarcodeMainParamVo();
		// 新增的到条码的状态必须是新建状态
		ConfigDictionary selectById = configDictionaryService.selectById(EnumBarcodeStatus.NEW.getValue(),
				commonParam);
		List<BarcodeMain> barcodeMainLists = new ArrayList<>();
		if (barcodeMainList.size() > 0) {
			for (BarcodeMain barcodeMain : barcodeMainList) {
				barcodeMain.setBarcodeStatusDictId(selectById.getId());
				if (barcodeMain.getMaterialId() != null) {
					ProductMaterial material=productMaterialService.selectById(barcodeMain.getMaterialId(), commonParam);
					if (material != null) {
						barcodeMain.setProductTypeDictId(material.getProductTypeDictId());
						if (barcodeMain.getProductId() == null) {
							barcodeMain.setProductId(material.getProductId());
						}
						
					}
				}
				barcodeMainLists.add(barcodeMain);
			}
			barcodeMainParamVo.setBarcodeMainVoList(barcodeMainLists);
		}
		int result = barcodeMainService.insertPrintBarcodeMain(barcodeMainParamVo, commonParam);
		if (result > 0) {
			resultMessage.setIsSuccess(true);
		} else {
			resultMessage.setIsSuccess(false);
		}
		return resultMessage;
	}

	@Override
	public ResultMessage outBarcode(String billId,Long factoryId, CommonParam commonParam) throws BusinessException, SQLException {
		ResultMessage resultMessage = new ResultMessage();
		try {
			billWarehouseOutService.updateOutBarcode(billId, factoryId, commonParam);
			resultMessage.addErr("出库成功");
			resultMessage.setIsSuccess(true);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public String getInventory(BarcodeMainParamVo paramVo, CommonParam commonParam)
			throws BusinessException, SQLException {

		long barcodeStatus = EnumBarcodeStatus.INSTORE.getValue();// 上架状态
		long barcodePackbox = 0;// 最外箱
		paramVo.setBarcodeStatusDictId(barcodeStatus);
		paramVo.setBarcodePackboxId(barcodePackbox);
		String sumQty = String.valueOf(barcodeMainService.selectSumQtyByEntity(paramVo, commonParam));
		return sumQty;
	}

	@Override
	public Double selectSumQtyByEntity(BarcodeMainParamVo paramVo, CommonParam commonParam)
			throws BusinessException, SQLException {
		return barcodeMainService.selectSumQtyByEntity(paramVo, commonParam);
	}

	@Override
	public ResultMessage scanUnpackBarcode(String barcode, CommonParam commonParam)
			throws BusinessException, SQLException {
		ResultMessage resultMessage = new ResultMessage();
		// 得到条码信息
		BarcodeMain barcodeMain = this.getVoByCode(barcode, commonParam);
		if (barcodeMain == null) {
			resultMessage.addErr("系统没有该条码！");
			return resultMessage;
		}
		if (!barcodeMain.getBarcodeRuleDictId().equals(EnumBarcodeRule.PRODUCT_MATERIAL.getValue())) {
			resultMessage.addErr("请扫描物品规格标签,外箱不能拆包");
			return resultMessage;
		}
		if (barcodeMain.getBarcodeStatusDictId().equals(EnumBarcodeStatus.OFFSTORE.getValue())) {
			BarcodeMainVo barcodeMainVo = new BarcodeMainVo(barcodeMain);
			barcodeMainVo
					.setProductMaterial(productMaterialService.selectById(barcodeMainVo.getMaterialId(), commonParam));
			barcodeMainVo.setBillWarehouseItem(
					billWarehouseItemService.selectById(barcodeMainVo.getBillItemId(), commonParam));
			barcodeMainVo.setBillWarehouse(billWarehouseService.selectById(barcodeMainVo.getBillId(), commonParam));
			resultMessage.setBaseEntity(barcodeMainVo);
			resultMessage.setIsSuccess(true);
		} else {
			resultMessage.addErr("请先下架在拆包！");
		}
		return resultMessage;
	}

	@Override
	public ResultMessage unpackBarcode(String barcode, String unpackQty, CommonParam commonParam)
			throws BusinessException, SQLException {
		ResultMessage resultMessage = new ResultMessage();
		BarcodeMain barcodeMain = new BarcodeMain();
		barcodeMain = this.getVoByCode(barcode, commonParam);
		if (!barcodeMain.getBarcodeStatusDictId().equals(EnumBarcodeStatus.OFFSTORE.getValue())) {
			resultMessage.addErr("该标签状态已变更,请重新扫描");
			return resultMessage;
		}
		if (barcodeMain.getQuantity() <= Integer.parseInt(unpackQty)) {
			resultMessage.addErr("请输入小于原标签的数量");
			return resultMessage;
		}
		barcodeMain.setTenantId(commonParam.getTenantId());
		List<BarcodeMain> list = billWarehouseOutService.updateUnpackBarcode(barcodeMain, unpackQty, commonParam);
		resultMessage.setIsSuccess(true);
		resultMessage.put(list);

		return resultMessage;
	}

	@Override
	public ResultMessage barcodeTransposition(BarcodeMain barcodeMain, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			resultMessage = billWarehouseAllocationService.barcodeTransposition(barcodeMain, commonParam);

			if (resultMessage.getIsSuccess().equals(true)) {
				resultMessage.addErr("标签库内移位成功！");
				resultMessage.setIsSuccess(true);
			} else {
				resultMessage.addErr("业务异常");
			}
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public List<BarcodeMainVo> bestLocation(Long materialId, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BarcodeMain> list = billWarehouseOutService.bestLocation(materialId, commonParam);
		//去重
		list=removeDuplicateWithOrder(list);
		return this.getVoList(list, commonParam);
	}
	private List<BarcodeMain> removeDuplicateWithOrder(List<BarcodeMain> list) {
		Set<Long> set = new HashSet<Long>();
		List<BarcodeMain> newList = new ArrayList<BarcodeMain>();
		for (Iterator<BarcodeMain> iterator = list.iterator(); iterator.hasNext();) {
			BarcodeMain barcodeMain = (BarcodeMain) iterator.next();
			if (set.add(barcodeMain.getId()))    
	            newList.add(barcodeMain);  
		}
	     list.clear();    
	     list.addAll(newList);    
	     return list;
	}
	
	
	@Override
	public List<BarcodeMainVo> selectSumQtyByCondition(BarcodeMainParamVo paramVo)throws BusinessException, SQLException {
		
		List<BarcodeMainVo> list=new ArrayList<>();
		list=barcodeMainService.selectSumQtyByCondition(paramVo);
		return list;
	}
	
	@Override
	public String getBatchNumber(CommonParam commonParam)throws BusinessException, SQLException {
		String batchNumber = null;
		
		batchNumber = configCodeRuleService.createCode(BarcodeBatchNumber.class.getName(),null, null, commonParam);
		
		return batchNumber;
	}

}
