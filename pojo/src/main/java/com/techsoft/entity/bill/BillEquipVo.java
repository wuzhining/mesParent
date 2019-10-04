package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillEquip;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWorkshop;

public class BillEquipVo extends BillEquip {
	private static final long serialVersionUID = 4221959119799158698L;

	private ConfigDictionary billTypeFixture;//单据类型
	private ConfigDictionary billStatusFixture;//单据状态
	private StructFactory structFactory;//工厂
	private StructWorkshop structWorkshop;//车间
	public StructWorkshop getStructWorkshop() {
		return structWorkshop;
	}

	public void setStructWorkshop(StructWorkshop structWorkshop) {
		this.structWorkshop = structWorkshop;
	}

	private FirmDepartment firmDepartment ;//部门
	
	public FirmDepartment getFirmDepartment() {
		return firmDepartment;
	}

	public void setFirmDepartment(FirmDepartment firmDepartment) {
		this.firmDepartment = firmDepartment;
	}

	public ConfigDictionary getBillTypeFixture() {
		return billTypeFixture;
	}

	public void setBillTypeFixture(ConfigDictionary billTypeFixture) {
		this.billTypeFixture = billTypeFixture;
	}

	public ConfigDictionary getBillStatusFixture() {
		return billStatusFixture;
	}

	public void setBillStatusFixture(ConfigDictionary billStatusFixture) {
		this.billStatusFixture = billStatusFixture;
	}

	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}

	public BillEquipVo() {	
	}
	
	public BillEquipVo(BillEquip value) {
		value.cloneProperties(this);
	}		
}
 