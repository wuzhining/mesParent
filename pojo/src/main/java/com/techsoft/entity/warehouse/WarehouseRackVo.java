package com.techsoft.entity.warehouse;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductClasses;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.common.WarehouseRack;

public class WarehouseRackVo extends WarehouseRack {
	private static final long serialVersionUID = -8687857234782819844L;
	private StructFactory structFactory;
	private StructWarehouse structWarehouse;
	private ConfigDictionary configDictionary;
	private ProductClasses productClasses;
	private WarehouseArea warehouseArea;

	
	public WarehouseArea getWarehouseArea() {
		return warehouseArea;
	}

	public void setWarehouseArea(WarehouseArea warehouseArea) {
		this.warehouseArea = warehouseArea;
	}

	public WarehouseRackVo() {
	}

	public WarehouseRackVo(WarehouseRack value) {
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
	
	public ConfigDictionary getConfigDictionary() {
		return configDictionary;
	}

	public void setConfigDictionary(ConfigDictionary configDictionary) {
		this.configDictionary = configDictionary;
	}
	
	public ProductClasses getProductClasses() {
		return productClasses;
	}

	public void setProductClasses(ProductClasses productClasses) {
		this.productClasses = productClasses;
	}	
}
