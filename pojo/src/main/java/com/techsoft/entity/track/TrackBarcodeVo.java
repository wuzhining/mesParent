package com.techsoft.entity.track;

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
import com.techsoft.entity.common.StructProcessLine;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehousePallet;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.entity.product.ProductMaterialVo;

public class TrackBarcodeVo extends TrackBarcode {
	private static final long serialVersionUID = -8115333072654000301L;

	private ProductMain productMain;//获取物品
	private ProductMaterial productMaterial;//获取物料
	private ConfigDictionary barcodeRuleList;//条码规则
	private ConfigDictionary barcodeStatusList;//条码状态
	private ConfigDictionary operationStatusList;//操作状态
	private ConfigDictionary billTypeDicList;//单据类型
	private ConfigDictionary billStatusDicList;//单据状态
	private FirmPartner firmPartnerList;//合作伙伴
	private StructWarehouse structWarehouseList;//仓库	
	private WarehouseLocation warehouseLocationList;//货位
	private UserPassport userPassportList; //操作人
	private StructFactory structFactorylist;//工厂名称
	private ProductMaterialVo productMaterialVo;//实物物料
	private WarehousePallet warehousePallet;//栈板
	private BillWorkorder billWorkorder;//工单
	private WorkTaskProcedure workTaskProcedure;//工作工序任务
	private StructWorkshop structWorkshop;//车间
	private StructWorkshopArea structWorkshopArea;//车间区域
	private EquipWork equipWork;//设备
	private EquipWorkStack equipWorkStack;//设备栈位
	private EquipFixture equipFixture;//工具设备
	private StructProcessNode structProcessNode;//工序
	private StructProcedureInstruct structProcedureInstruct;//工序指令
	private StructWorkstation structWorkstation;//工位
	private StructProductionline structProductionline;//生产线
	private ConfigDictionary productType;//物品类型
	
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

	public StructWorkstation getStructWorkstation() {
		return structWorkstation;
	}

	public void setStructWorkstation(StructWorkstation structWorkstation) {
		this.structWorkstation = structWorkstation;
	}

	private String billCode;
	/**
	 * 单据
	 */
	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
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

	public TrackBarcodeVo() {	
	}
	
	public TrackBarcodeVo(TrackBarcode value) {
		value.cloneProperties(this);
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

	public ConfigDictionary getBarcodeRuleList() {
		return barcodeRuleList;
	}

	public void setBarcodeRuleList(ConfigDictionary barcodeRuleList) {
		this.barcodeRuleList = barcodeRuleList;
	}

	public ConfigDictionary getBarcodeStatusList() {
		return barcodeStatusList;
	}

	public void setBarcodeStatusList(ConfigDictionary barcodeStatusList) {
		this.barcodeStatusList = barcodeStatusList;
	}

	public ConfigDictionary getOperationStatusList() {
		return operationStatusList;
	}

	public void setOperationStatusList(ConfigDictionary operationStatusList) {
		this.operationStatusList = operationStatusList;
	}

	public ConfigDictionary getBillTypeDicList() {
		return billTypeDicList;
	}

	public void setBillTypeDicList(ConfigDictionary billTypeDicList) {
		this.billTypeDicList = billTypeDicList;
	}

	public ConfigDictionary getBillStatusDicList() {
		return billStatusDicList;
	}

	public void setBillStatusDicList(ConfigDictionary billStatusDicList) {
		this.billStatusDicList = billStatusDicList;
	}

	public FirmPartner getFirmPartnerList() {
		return firmPartnerList;
	}

	public void setFirmPartnerList(FirmPartner firmPartnerList) {
		this.firmPartnerList = firmPartnerList;
	}

	public StructWarehouse getStructWarehouseList() {
		return structWarehouseList;
	}

	public void setStructWarehouseList(StructWarehouse structWarehouseList) {
		this.structWarehouseList = structWarehouseList;
	}

	public WarehouseLocation getWarehouseLocationList() {
		return warehouseLocationList;
	}

	public void setWarehouseLocationList(WarehouseLocation warehouseLocationList) {
		this.warehouseLocationList = warehouseLocationList;
	}

	public UserPassport getUserPassportList() {
		return userPassportList;
	}

	public void setUserPassportList(UserPassport userPassportList) {
		this.userPassportList = userPassportList;
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

	public WarehousePallet getWarehousePallet() {
		return warehousePallet;
	}

	public void setWarehousePallet(WarehousePallet warehousePallet) {
		this.warehousePallet = warehousePallet;
	}

	public StructProductionline getStructProductionline() {
		return structProductionline;
	}

	public void setStructProductionline(StructProductionline structProductionline) {
		this.structProductionline = structProductionline;
	}

	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

}
