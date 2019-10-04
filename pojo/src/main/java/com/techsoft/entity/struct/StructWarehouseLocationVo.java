package com.techsoft.entity.struct;

import com.techsoft.entity.common.StructWarehouseLocation;

public class StructWarehouseLocationVo extends StructWarehouseLocation {
	private static final long serialVersionUID = 5171448896802075389L;

	public StructWarehouseLocationVo() {	
	}
	
	public StructWarehouseLocationVo(StructWarehouseLocation value) {
		value.cloneProperties(this);
	}		
}
