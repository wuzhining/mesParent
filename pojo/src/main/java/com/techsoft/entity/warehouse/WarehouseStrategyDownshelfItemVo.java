package com.techsoft.entity.warehouse;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.common.WarehouseStrategyDownshelfItem;

public class WarehouseStrategyDownshelfItemVo extends WarehouseStrategyDownshelfItem {
	private static final long serialVersionUID = 1760784728576659166L;

	private ConfigDictionary modeMatchingDict;
	private ConfigDictionary attributeDict;
	private ConfigDictionary adcdesOrderDict;
	private WarehouseArea warehouseArea;
	private WarehouseRack warehouseRack;
	private WarehouseLocation warehouseLocation;
	
	public WarehouseStrategyDownshelfItemVo() {	
	}
	
	public WarehouseStrategyDownshelfItemVo(WarehouseStrategyDownshelfItem value) {
		value.cloneProperties(this);
	}

	public ConfigDictionary getModeMatchingDict() {
		return modeMatchingDict;
	}

	public void setModeMatchingDict(ConfigDictionary modeMatchingDict) {
		this.modeMatchingDict = modeMatchingDict;
	}

	public ConfigDictionary getAttributeDict() {
		return attributeDict;
	}

	public void setAttributeDict(ConfigDictionary attributeDict) {
		this.attributeDict = attributeDict;
	}

	public ConfigDictionary getAdcdesOrderDict() {
		return adcdesOrderDict;
	}

	public void setAdcdesOrderDict(ConfigDictionary adcdesOrderDict) {
		this.adcdesOrderDict = adcdesOrderDict;
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
	
}
