package com.techsoft.entity.struct;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.common.StructWorkshop;

public class StructProductionlineVo extends StructProductionline {
	private static final long serialVersionUID = -3377721339194096046L;
	private StructFactory structFactory;
	private StructWorkshop structWorkshop;
	private ConfigDictionary configDictionary;
	private StructProcess structProcess;
	
	public StructProcess getStructProcess() {
		return structProcess;
	}

	public void setStructProcess(StructProcess structProcess) {
		this.structProcess = structProcess;
	}

	public StructProductionlineVo() {	
	}
	
	public StructProductionlineVo(StructProductionline value) {
		value.cloneProperties(this);
	}	
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
	public ConfigDictionary getConfigDictionary() {
		return configDictionary;
	}

	public void setConfigDictionary(ConfigDictionary configDictionary) {
		this.configDictionary = configDictionary;
	}

}
