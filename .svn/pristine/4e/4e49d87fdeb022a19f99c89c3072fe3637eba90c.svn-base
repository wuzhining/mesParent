package com.techsoft.entity.struct;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProcessNode;

public class StructProcessNodeVo extends StructProcessNode {
	private static final long serialVersionUID = 7181496374368155057L;
	private StructFactory structFactory;
	private ConfigDictionary processDictionary;
	private ConfigDictionary executiveTypeDictionary;
	private StructProcess structProcess;
	
	
	public StructProcess getStructProcess() {
		return structProcess;
	}

	public void setStructProcess(StructProcess structProcess) {
		this.structProcess = structProcess;
	}

	public ConfigDictionary getExecutiveTypeDictionary() {
		return executiveTypeDictionary;
	}

	public void setExecutiveTypeDictionary(ConfigDictionary executiveTypeDictionary) {
		this.executiveTypeDictionary = executiveTypeDictionary;
	}

	public ConfigDictionary getProcessDictionary() {
		return processDictionary;
	}

	public void setProcessDictionary(ConfigDictionary processDictionary) {
		this.processDictionary = processDictionary;
	}

	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}

	public StructProcessNodeVo() {	
	}
	
	public StructProcessNodeVo(StructProcessNode value) {
		value.cloneProperties(this);
	}		
}
