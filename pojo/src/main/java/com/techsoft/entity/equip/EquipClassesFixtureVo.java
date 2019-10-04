package com.techsoft.entity.equip;

import com.techsoft.entity.common.EquipClassesFixture;

public class EquipClassesFixtureVo extends EquipClassesFixture {
	private static final long serialVersionUID = -5116584123789623938L;

	public EquipClassesFixtureVo() {	
	}
	
	public EquipClassesFixtureVo(EquipClassesFixture value) {
		value.cloneProperties(this);
	}		
}
