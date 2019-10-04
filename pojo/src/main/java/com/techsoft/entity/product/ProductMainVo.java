package com.techsoft.entity.product;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductClasses;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.WarehouseStrategyDownshelf;
import com.techsoft.entity.common.WarehouseStrategyUpshelf;

public class ProductMainVo extends ProductMain {
	private static final long serialVersionUID = 41763849215941555L;
	private FirmPartner firmPartner;//供应商
	private ProductClasses  productClasses;//物品分类名称数据字典
	private ConfigDictionary  productType;//物品类型名称数据字典
	private ConfigDictionary  productStatus;//物品状态名称数据字典
	private ConfigDictionary  productSourse;//物品状态名称数据字典
	private ConfigDictionary  inspectModeDict;//检验方式名称数据字典
	private WarehouseStrategyDownshelf warehouseStrategyDownshelf;//下架策略
	private WarehouseStrategyUpshelf warehouseStrategyUpshelf;//下架策略
	private ConfigDictionary  semiProductType;//半成品类型数据字典
	public ConfigDictionary getSemiProductType() {
		return semiProductType;
	}

	public void setSemiProductType(ConfigDictionary semiProductType) {
		this.semiProductType = semiProductType;
	}

	public ProductMainVo() {	
	}
	
	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	public ConfigDictionary getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ConfigDictionary productStatus) {
		this.productStatus = productStatus;
	}

	public ConfigDictionary getProductSourse() {
		return productSourse;
	}

	public void setProductSourse(ConfigDictionary productSourse) {
		this.productSourse = productSourse;
	}

	public FirmPartner getFirmPartner() {
		return firmPartner;
	}

	public void setFirmPartner(FirmPartner firmPartner) {
		this.firmPartner = firmPartner;
	}


	public ProductMainVo(ProductMain value) {
		value.cloneProperties(this);
	}

	public ProductClasses getProductClasses() {
		return productClasses;
	}

	public void setProductClasses(ProductClasses productClasses) {
		this.productClasses = productClasses;
	}


	public ConfigDictionary getInspectModeDict() {
		return inspectModeDict;
	}

	public void setInspectModeDict(ConfigDictionary inspectModeDict) {
		this.inspectModeDict = inspectModeDict;
	}

	public WarehouseStrategyDownshelf getWarehouseStrategyDownshelf() {
		return warehouseStrategyDownshelf;
	}

	public void setWarehouseStrategyDownshelf(WarehouseStrategyDownshelf warehouseStrategyDownshelf) {
		this.warehouseStrategyDownshelf = warehouseStrategyDownshelf;
	}

	public WarehouseStrategyUpshelf getWarehouseStrategyUpshelf() {
		return warehouseStrategyUpshelf;
	}

	public void setWarehouseStrategyUpshelf(WarehouseStrategyUpshelf warehouseStrategyUpshelf) {
		this.warehouseStrategyUpshelf = warehouseStrategyUpshelf;
	}


		
}
