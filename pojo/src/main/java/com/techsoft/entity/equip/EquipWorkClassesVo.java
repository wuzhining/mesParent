package com.techsoft.entity.equip;

import com.techsoft.entity.common.EquipWorkClasses;

public class EquipWorkClassesVo extends EquipWorkClasses {
	private static final long serialVersionUID = -1981414536685460549L;

	private EquipWorkClasses equipWorkClasses;
	
	public EquipWorkClassesVo() {	
	}
	
	public EquipWorkClassesVo(EquipWorkClasses value) {
		value.cloneProperties(this);
	}

	public EquipWorkClasses getEquipWorkClasses() {
		return equipWorkClasses;
	}

	public void setEquipWorkClasses(EquipWorkClasses equipWorkClasses) {
		this.equipWorkClasses = equipWorkClasses;
	}	
	
}
