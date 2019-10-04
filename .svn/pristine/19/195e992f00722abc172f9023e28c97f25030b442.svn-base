package com.techsoft.entity.barcode;

import com.techsoft.entity.common.BarcodeMain;
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

public class BarcodeMainVo extends BarcodeMain {
	private static final long serialVersionUID = 2054282469936020621L;
	
	private ConfigDictionary barcodeRuleDic;
	private ProductMain productMain;
	private ProductMaterial productMaterial;
	private BarcodeMain	barcodePackBox;
	private ConfigDictionary barcodeStatusDic;
	private ConfigDictionary barcodebillType;
	private ConfigDictionary billStatusDic;
	private TrackPallet trackPallet;
	private WarehousePallet warehousePallet;
	private FirmPartner firmPartner;
	private StructWarehouse structWarehouse;//仓库
	private WarehouseLocation warehouseLocation;//仓库货位
	private BillWarehouseItem billWarehouseItem;
	private BillWarehouse billWarehouse;
	private UserPassport userPassportList; //操作人
	private StructFactory structFactorylist;//工厂名称
	private ProductMaterialVo productMaterialVo;//实物物料
	private WarehouseArea warehouseArea;//仓库区域
	private WarehouseRack warehouseRack;//货架
	private BillWorkorder billWorkorder;//工单
	private WorkTaskProcedure workTaskProcedure;//工作工序
	private StructProcessNode structProcessNode;//工序
	private StructProcedureInstruct structProcedureInstruct ;//工序指令
	private StructWorkshop structWorkshop ;//车间
	private StructWorkshopArea structWorkshopArea ;//车间区域
	private StructWorkstation structWorkstation ;//工位
	private EquipWork equipWork ;//设备
	private EquipWorkStack equipWorkStack ;//设备栈位
	private EquipFixture equipFixture ;//工具设备
	private StructProductionline structProductionline ;//生产线
	
	private ConfigDictionary  productType;//物品类型名称数据字典
	private ProductMaterial materialCode;//物品规格编码
	/**
	 * 单据
	 */
	private String billCode;
	
	private String warehouseName;
	private String locationName;
	private String materialName;
	private Double sumqty;

	public BarcodeMainVo() {	
	}
	public WarehouseArea getWarehouseArea() {
		return warehouseArea;
	}

	public void setWarehouseArea(WarehouseArea warehouseArea) {
		this.warehouseArea = warehouseArea;
	}

	public WarehouseRack getWarehouseRack() {
		return warehouseRack;
	}

	public void setWarehouseRack(WarehouseRack warehouseRack) {
		this.warehouseRack = warehouseRack;
	}

	public BillWorkorder getBillWorkorder() {
		return billWorkorder;
	}

	public void setBillWorkorder(BillWorkorder billWorkorder) {
		this.billWorkorder = billWorkorder;
	}

	public WorkTaskProcedure getWorkTaskProcedure() {
		return workTaskProcedure;
	}

	public void setWorkTaskProcedure(WorkTaskProcedure workTaskProcedure) {
		this.workTaskProcedure = workTaskProcedure;
	}

	public StructProcessNode getStructProcessNode() {
		return structProcessNode;
	}

	public void setStructProcessNode(StructProcessNode structProcessNode) {
		this.structProcessNode = structProcessNode;
	}

	public StructProcedureInstruct getStructProcedureInstruct() {
		return structProcedureInstruct;
	}

	public void setStructProcedureInstruct(StructProcedureInstruct structProcedureInstruct) {
		this.structProcedureInstruct = structProcedureInstruct;
	}

	public StructWorkshop getStructWorkshop() {
		return structWorkshop;
	}

	public void setStructWorkshop(StructWorkshop structWorkshop) {
		this.structWorkshop = structWorkshop;
	}

	public StructWorkshopArea getStructWorkshopArea() {
		return structWorkshopArea;
	}

	public void setStructWorkshopArea(StructWorkshopArea structWorkshopArea) {
		this.structWorkshopArea = structWorkshopArea;
	}

	public StructWorkstation getStructWorkstation() {
		return structWorkstation;
	}

	public void setStructWorkstation(StructWorkstation structWorkstation) {
		this.structWorkstation = structWorkstation;
	}

	public EquipWork getEquipWork() {
		return equipWork;
	}

	public void setEquipWork(EquipWork equipWork) {
		this.equipWork = equipWork;
	}

	public EquipWorkStack getEquipWorkStack() {
		return equipWorkStack;
	}

	public void setEquipWorkStack(EquipWorkStack equipWorkStack) {
		this.equipWorkStack = equipWorkStack;
	}

	public EquipFixture getEquipFixture() {
		return equipFixture;
	}


	public void setEquipFixture(EquipFixture equipFixture) {
		this.equipFixture = equipFixture;
	}


	public StructProductionline getStructProductionline() {
		return structProductionline;
	}


	public void setStructProductionline(StructProductionline structProductionline) {
		this.structProductionline = structProductionline;
	}
	
	public WarehousePallet getWarehousePallet() {
		return warehousePallet;
	}


	public void setWarehousePallet(WarehousePallet warehousePallet) {
		this.warehousePallet = warehousePallet;
	}


	public ConfigDictionary getBillStatusDic() {
		return billStatusDic;
	}

	public void setBillStatusDic(ConfigDictionary billStatusDic) {
		this.billStatusDic = billStatusDic;
	}

	public ConfigDictionary getBarcodebillType() {
		return barcodebillType;
	}

	public void setBarcodebillType(ConfigDictionary barcodebillType) {
		this.barcodebillType = barcodebillType;
	}

	public BarcodeMainVo(BarcodeMain value) {
		value.cloneProperties(this);
	}

	public ConfigDictionary getBarcodeRuleDic() {
		return barcodeRuleDic;
	}

	public void setBarcodeRuleDic(ConfigDictionary barcodeRuleDic) {
		this.barcodeRuleDic = barcodeRuleDic;
	}

	public ProductMain getProductMain() {
		return productMain;
	}

	public void setProductMain(ProductMain productMain) {
		this.productMain = productMain;
	}

	public ProductMaterial getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(ProductMaterial productMaterial) {
		this.productMaterial = productMaterial;
	}

	public BarcodeMain getBarcodePackBox() {
		return barcodePackBox;
	}

	public void setBarcodePackBox(BarcodeMain barcodePackBox) {
		this.barcodePackBox = barcodePackBox;
	}

	public ConfigDictionary getBarcodeStatusDic() {
		return barcodeStatusDic;
	}

	public void setBarcodeStatusDic(ConfigDictionary barcodeStatusDic) {
		this.barcodeStatusDic = barcodeStatusDic;
	}

	public TrackPallet getTrackPallet() {
		return trackPallet;
	}

	public void setTrackPallet(TrackPallet trackPallet) {
		this.trackPallet = trackPallet;
	}

	public FirmPartner getFirmPartner() {
		return firmPartner;
	}

	public void setFirmPartner(FirmPartner firmPartner) {
		this.firmPartner = firmPartner;
	}

	public StructWarehouse getStructWarehouse() {
		return structWarehouse;
	}

	public void setStructWarehouse(StructWarehouse structWarehouse) {
		this.structWarehouse = structWarehouse;
	}

	public WarehouseLocation getWarehouseLocation() {
		return warehouseLocation;
	}

	public void setWarehouseLocation(WarehouseLocation warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	public BillWarehouseItem getBillWarehouseItem() {
		return billWarehouseItem;
	}

	public void setBillWarehouseItem(BillWarehouseItem billWarehouseItem) {
		this.billWarehouseItem = billWarehouseItem;
	}

	public BillWarehouse getBillWarehouse() {
		return billWarehouse;
	}

	public void setBillWarehouse(BillWarehouse billWarehouse) {
		this.billWarehouse = billWarehouse;
	}



	public UserPassport getUserPassportList() {
		return userPassportList;
	}



	public void setUserPassportList(UserPassport userPassportList) {
		this.userPassportList = userPassportList;
	}



	public String getBillCode() {
		return billCode;
	}



	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public StructFactory getStructFactorylist() {
		return structFactorylist;
	}

	public void setStructFactorylist(StructFactory structFactorylist) {
		this.structFactorylist = structFactorylist;
	}



	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}



	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}



	public Double getSumqty() {
		return sumqty;
	}



	public void setSumqty(Double sumqty) {
		this.sumqty = sumqty;
	}



	public String getWarehouseName() {
		return warehouseName;
	}



	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}



	public String getLocationName() {
		return locationName;
	}



	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}



	public String getMaterialName() {
		return materialName;
	}



	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	
	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	public ProductMaterial getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(ProductMaterial materialCode) {
		this.materialCode = materialCode;
	}
}
