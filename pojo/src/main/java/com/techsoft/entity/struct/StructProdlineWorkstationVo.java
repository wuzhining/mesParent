package com.techsoft.entity.struct;

import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructFloor;
import com.techsoft.entity.common.StructProdlineWorkstation;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;

public class StructProdlineWorkstationVo extends StructProdlineWorkstation {
	private static final long serialVersionUID = -499588943302652430L;
	
	private StructWorkstation structWorkstation;
	private StructFactory structFactory;
	private StructWorkshop structWorkshop;
	private StructWorkshopArea structWorkshopArea;
	private StructFloor structFloor;

	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}

	public StructWorkshop getStructWorkshop() {
		return structWorkshop;
	}

	public void setStructWorkshop(StructWorkshop structWorkshop) {
		this.structWorkshop = structWorkshop;
	}

	public StructWorkshopArea getStructWorkshopArea() {
		return structWorkshopArea;
	}

	public void setStructWorkshopArea(StructWorkshopArea structWorkshopArea) {
		this.structWorkshopArea = structWorkshopArea;
	}

	public StructFloor getStructFloor() {
		return structFloor;
	}

	public void setStructFloor(StructFloor structFloor) {
		this.structFloor = structFloor;
	}

	public StructProdlineWorkstationVo() {	
	}
	
	public StructProdlineWorkstationVo(StructProdlineWorkstation value) {
		value.cloneProperties(this);
	}

	public StructWorkstation getStructWorkstation() {
		return structWorkstation;
	}

	public void setStructWorkstation(StructWorkstation structWorkstation) {
		this.structWorkstation = structWorkstation;
	}		
}
