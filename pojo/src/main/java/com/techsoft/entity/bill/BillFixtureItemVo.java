package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillFixture;
import com.techsoft.entity.common.BillFixtureItem;
import com.techsoft.entity.common.EquipFixture;

public class BillFixtureItemVo extends BillFixtureItem {
	private static final long serialVersionUID = 608003802138548089L;
	private EquipFixture equipFixture;
	private BillFixture billFixture;
	
	public BillFixture getBillFixture() {
		return billFixture;
	}

	public void setBillFixture(BillFixture billFixture) {
		this.billFixture = billFixture;
	}

	public BillFixtureItemVo() {	
	}
	
	public BillFixtureItemVo(BillFixtureItem value) {
		value.cloneProperties(this);
	}

	public EquipFixture getEquipFixture() {
		return equipFixture;
	}

	public void setEquipFixture(EquipFixture equipFixture) {
		this.equipFixture = equipFixture;
	}	
	
}
