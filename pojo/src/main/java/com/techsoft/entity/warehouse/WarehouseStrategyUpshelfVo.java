package com.techsoft.entity.warehouse;

import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.common.WarehouseStrategyUpshelf;

public class WarehouseStrategyUpshelfVo extends WarehouseStrategyUpshelf {
	private static final long serialVersionUID = -4486198715312173740L;
	
	private StructFactory structFactory;//工厂
	private StructWarehouse structWarehouse;//仓库
	private WarehouseRack warehouseRack;//货架
	private WarehouseArea warehouseArea;//仓库区域
	private WarehouseLocation warehouseLocation;//仓库区域

	public WarehouseStrategyUpshelfVo() {	
	}
	
	public WarehouseStrategyUpshelfVo(WarehouseStrategyUpshelf value) {
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

	public WarehouseLocation getWarehouseLocation() {
		return warehouseLocation;
	}

	public void setWarehouseLocation(WarehouseLocation warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}		
}
