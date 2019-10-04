package com.techsoft.entity.history;

import com.techsoft.entity.common.BillInventory;
import com.techsoft.entity.common.BillInventoryItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.HistoryInventoryLocation;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.product.ProductMaterialVo;

public class HistoryInventoryLocationVo extends HistoryInventoryLocation {
	private static final long serialVersionUID = 6481705583861465070L;
	private BillInventory billInventory;//盘点单据编码
	private BillInventoryItem billInventoryItem;//盘点单据编码明细
	private ProductMain productMain;//物品
	private ProductMaterial productMaterial;//物品规格
	private ProductMaterialVo productMaterialVo;//物品规格值
	private StructWarehouse structWarehouse;//仓库
	private StructWorkshopArea structWorkshopArea;//仓库区域
	private WarehouseRack warehouseRack;//仓库库位组(货架)
	private	WarehouseLocation warehouseLocation; //仓库库位
	private UserPassport caretUserPassport;//创建人名称
	private UserPassport modifyUserPassport;//更新人名称
	private ConfigDictionary productType;//物品类型

	public HistoryInventoryLocationVo() {	
	}
	
	public HistoryInventoryLocationVo(HistoryInventoryLocation value) {
		value.cloneProperties(this);
	}

	public BillInventory getBillInventory() {
		return billInventory;
	}

	public void setBillInventory(BillInventory billInventory) {
		this.billInventory = billInventory;
	}

	public BillInventoryItem getBillInventoryItem() {
		return billInventoryItem;
	}

	public void setBillInventoryItem(BillInventoryItem billInventoryItem) {
		this.billInventoryItem = billInventoryItem;
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

	public StructWarehouse getStructWarehouse() {
		return structWarehouse;
	}

	public void setStructWarehouse(StructWarehouse structWarehouse) {
		this.structWarehouse = structWarehouse;
	}

	public StructWorkshopArea getStructWorkshopArea() {
		return structWorkshopArea;
	}

	public void setStructWorkshopArea(StructWorkshopArea structWorkshopArea) {
		this.structWorkshopArea = structWorkshopArea;
	}

	public WarehouseRack getWarehouseRack() {
		return warehouseRack;
	}

	public void setWarehouseRack(WarehouseRack warehouseRack) {
		this.warehouseRack = warehouseRack;
	}

	public WarehouseLocation getWarehouseLocation() {
		return warehouseLocation;
	}

	public void setWarehouseLocation(WarehouseLocation warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	public UserPassport getCaretUserPassport() {
		return caretUserPassport;
	}

	public void setCaretUserPassport(UserPassport caretUserPassport) {
		this.caretUserPassport = caretUserPassport;
	}

	public UserPassport getModifyUserPassport() {
		return modifyUserPassport;
	}

	public void setModifyUserPassport(UserPassport modifyUserPassport) {
		this.modifyUserPassport = modifyUserPassport;
	}

	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}
	
}
