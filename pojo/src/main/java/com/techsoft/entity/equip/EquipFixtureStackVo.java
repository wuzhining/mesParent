package com.techsoft.entity.equip;

import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.common.EquipFixtureStack;
import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.entity.common.EquipSpecsFixtureArea;

public class EquipFixtureStackVo extends EquipFixtureStack {

	private static final long serialVersionUID = -9006945969307891298L;
	
	private EquipFixture equipFixture;

	private EquipSpecsFixture equipSpecsFixture;
	
	private EquipSpecsFixtureArea equipSpecsFixtureArea;
	
	public EquipFixtureStackVo() {	
	}
	
	public EquipFixtureStackVo(EquipFixtureStack value) {
		value.cloneProperties(this);
	}

	public EquipFixture getEquipFixture() {
		return equipFixture;
	}

	public void setEquipFixture(EquipFixture equipFixture) {
		this.equipFixture = equipFixture;
	}

	public EquipSpecsFixture getEquipSpecsFixture() {
		return equipSpecsFixture;
	}

	public void setEquipSpecsFixture(EquipSpecsFixture equipSpecsFixture) {
		this.equipSpecsFixture = equipSpecsFixture;
	}

	public EquipSpecsFixtureArea getEquipSpecsFixtureArea() {
		return equipSpecsFixtureArea;
	}

	public void setEquipSpecsFixtureArea(EquipSpecsFixtureArea equipSpecsFixtureArea) {
		this.equipSpecsFixtureArea = equipSpecsFixtureArea;
	}
 
}
