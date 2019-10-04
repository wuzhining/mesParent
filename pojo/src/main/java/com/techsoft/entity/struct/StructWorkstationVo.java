package com.techsoft.entity.struct;


import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructFloor;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;

public class StructWorkstationVo extends StructWorkstation {
	private static final long serialVersionUID = 6326273484442918886L;
	private StructFactory structFactory;//工厂
	private StructWorkshopArea structWorkshopArea;//车间区域
	private StructWorkshop structWorkshop;//车间
	private StructFloor structFloor; //楼层
	private ConfigDictionary executive;//执行方
	

	
	public ConfigDictionary getExecutive() {
		return executive;
	}
	public void setExecutive(ConfigDictionary executive) {
		this.executive = executive;
	}
	public StructWorkstationVo(){
		
	}
	public StructWorkstationVo(StructWorkstation value) {
		value.cloneProperties(this);
	}	
	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}

	public StructWorkshopArea getStructWorkshopArea() {
		return structWorkshopArea;
	}

	public void setStructWorkshopArea(StructWorkshopArea structWorkshopArea) {
		this.structWorkshopArea = structWorkshopArea;
	}

	public StructWorkshop getStructWorkshop() {
		return structWorkshop;
	}

	public void setStructWorkshop(StructWorkshop structWorkshop) {
		this.structWorkshop = structWorkshop;
	}

	public StructFloor getStructFloor() {
		return structFloor;
	}

	public void setStructFloor(StructFloor structFloor) {
		this.structFloor = structFloor;
	}


}
