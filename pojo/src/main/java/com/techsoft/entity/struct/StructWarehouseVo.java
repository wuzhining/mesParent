package com.techsoft.entity.struct;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructFloor;
import com.techsoft.entity.common.StructWarehouse;

public class StructWarehouseVo extends StructWarehouse {
	private static final long serialVersionUID = 5114961021826498679L;
	private ConfigDictionary warehouseTypeDic;
	private ConfigDictionary productTypeDic;
	private StructFactory structFactory;
	private StructFloor structFloor;

	

	public StructWarehouseVo() {	
	}
	
	public StructWarehouseVo(StructWarehouse value) {
		value.cloneProperties(this);
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

	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}

	public StructFloor getStructFloor() {
		return structFloor;
	}

	public void setStructFloor(StructFloor structFloor) {
		this.structFloor = structFloor;
	}
}
