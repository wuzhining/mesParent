package com.techsoft.entity.struct;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcedure;

public class StructProcedureVo extends StructProcedure {
	private static final long serialVersionUID = 5430147416057473983L;
	private StructFactory structFactory;
	private ConfigDictionary processDictionary;
	private ConfigDictionary groupDictionary;
	
	public StructProcedureVo() {	
	}
	
	public StructProcedureVo(StructProcedure value) {
		value.cloneProperties(this);
	}	
	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}

	public ConfigDictionary getProcessDictionary() {
		return processDictionary;
	}

	public void setProcessDictionary(ConfigDictionary processDictionary) {
		this.processDictionary = processDictionary;
	}

	public ConfigDictionary getGroupDictionary() {
		return groupDictionary;
	}

	public void setGroupDictionary(ConfigDictionary groupDictionary) {
		this.groupDictionary = groupDictionary;
	}

	

}
