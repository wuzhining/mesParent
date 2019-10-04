package com.techsoft.entity.firm;

import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.StructFactory;

public class FirmDepartmentVo extends FirmDepartment {
	private static final long serialVersionUID = -4423878043679181053L;
    private StructFactory structFactory;
	private FirmDepartment firmDepartment;
	
	public FirmDepartmentVo(FirmDepartment value) {
		value.cloneProperties(this);
	}
	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}

	public FirmDepartment getFirmDepartment() {
		return firmDepartment;
	}
	public void setFirmDepartment(FirmDepartment firmDepartment) {
		this.firmDepartment = firmDepartment;
	}
	public FirmDepartmentVo() {	
	}
}
