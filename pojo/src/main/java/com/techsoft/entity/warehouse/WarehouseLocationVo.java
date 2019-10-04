package com.techsoft.entity.warehouse;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductClasses;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehouseRack;


public class WarehouseLocationVo extends WarehouseLocation {
	private static final long serialVersionUID = 3002319147317297080L;
	private StructFactory structFactory;//工厂
	private StructWarehouse structWarehouse;//仓库
	private WarehouseRack warehouseRack;//货位
	private ConfigDictionary warehouseTypeDic;//货位类型
	private ConfigDictionary productTypeDic;//物品类型
	private WarehouseArea warehouseArea;//仓库区域w


	
	public WarehouseLocationVo() {	
	}
	
	 public WarehouseLocationVo(WarehouseLocation value) {
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

	public ConfigDictionary getWarehouseTypeDic() {
		return warehouseTypeDic;
	}

	public void setWarehouseTypeDic(ConfigDictionary warehouseTypeDic) {
		this.warehouseTypeDic = warehouseTypeDic;
	}

	public ConfigDictionary getProductTypeDic() {
		return productTypeDic;
	}

	public void setProductTypeDic(ConfigDictionary productTypeDic) {
		this.productTypeDic = productTypeDic;
	}



	public void setStructWarehouse(StructWarehouse structWarehouse) {
		this.structWarehouse = structWarehouse;
	}
	

	public WarehouseRack getWarehouseRack() {
		return warehouseRack;
	}

	public void setWarehouseRack(WarehouseRack warehouseRack) {
		this.warehouseRack = warehouseRack;
	}
	


	public WarehouseArea getWarehouseArea() {
		return warehouseArea;
	}

	public void setWarehouseArea(WarehouseArea warehouseArea) {
		this.warehouseArea = warehouseArea;
	}
}
