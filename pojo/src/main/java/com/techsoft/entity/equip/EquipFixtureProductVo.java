package com.techsoft.entity.equip;

import com.techsoft.entity.common.EquipFixtureProduct;

public class EquipFixtureProductVo extends EquipFixtureProduct {
	private static final long serialVersionUID = -8655463171272007666L;

	public EquipFixtureProductVo() {	
	}
	
	public EquipFixtureProductVo(EquipFixtureProduct value) {
		value.cloneProperties(this);
	}		
}
