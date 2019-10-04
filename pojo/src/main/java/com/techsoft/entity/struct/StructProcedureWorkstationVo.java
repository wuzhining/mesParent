package com.techsoft.entity.struct;

import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructFloor;
import com.techsoft.entity.common.StructProcedureWorkstation;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;

public class StructProcedureWorkstationVo extends StructProcedureWorkstation {
	private static final long serialVersionUID = -7830190739010750368L;

	private StructWorkstation structWorkstation;
	private StructProcessNode structProcessNode;
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

	public StructWorkstation getStructWorkstation() {
		return structWorkstation;
	}

	public void setStructWorkstation(StructWorkstation structWorkstation) {
		this.structWorkstation = structWorkstation;
	}

	public StructProcessNode getStructProcessNode() {
		return structProcessNode;
	}

	public void setStructProcessNode(StructProcessNode structProcessNode) {
		this.structProcessNode = structProcessNode;
	}

	public StructProcedureWorkstationVo() {	
	}
	
	public StructProcedureWorkstationVo(StructProcedureWorkstation value) {
		value.cloneProperties(this);
	}		
}
