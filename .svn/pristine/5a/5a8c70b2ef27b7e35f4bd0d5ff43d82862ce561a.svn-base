package com.techsoft.entity.warehouse;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.common.WarehouseLocationStock;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.entity.common.WarehouseLocation;

public class WarehouseLocationStockVo extends WarehouseLocationStock {
	private static final long serialVersionUID = -1416619839647676277L;
	private StructFactory structFactory;//工厂
	private StructWarehouse structWarehouse;//仓库
	private ProductMain productMain;//物品
	private ProductMaterial productMaterial;//物料
	private WarehouseArea warehouseArea;//仓库区域
	private WarehouseRack warehouseRack;//货位
	private WarehouseLocation warehouseLocation;//库位
	private ProductMaterialVo productMaterialVo;//实物物料
	private Double sumqty;
	private ConfigDictionary  productType;//物品类型名称数据字典
	private UserPassport  userPassport;//创建人
	private UserPassport  modifyUser;//修改人
	
	
	public UserPassport getUserPassport() {
		return userPassport;
	}

	public void setUserPassport(UserPassport userPassport) {
		this.userPassport = userPassport;
	}

	public UserPassport getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(UserPassport modifyUser) {
		this.modifyUser = modifyUser;
	}

	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	public WarehouseLocationStockVo() {	
	}
	
	public WarehouseLocationStockVo(WarehouseLocationStock value) {
		value.cloneProperties(this);
	}

	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}

	public StructWarehouse getStructWarehouse() {
		return structWarehouse;
	}

	public void setStructWarehouse(StructWarehouse structWarehouse) {
		this.structWarehouse = structWarehouse;
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

	public WarehouseLocation getWarehouseLocation() {
		return warehouseLocation;
	}

	public void setWarehouseLocation(WarehouseLocation warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
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

		
}
