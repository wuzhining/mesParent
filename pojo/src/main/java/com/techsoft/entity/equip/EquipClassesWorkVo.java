package com.techsoft.entity.equip;

import com.techsoft.entity.common.EquipClassesWork;

public class EquipClassesWorkVo extends EquipClassesWork {
	private static final long serialVersionUID = -4710399268385434007L;

	public EquipClassesWorkVo() {	
	}
	
	public EquipClassesWorkVo(EquipClassesWork value) {
		value.cloneProperties(this);
	}		
}
