package com.techsoft.entity.struct;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;

public class StructFactoryVo extends StructFactory {
	private static final long serialVersionUID = 4915427980978820924L;
	private ConfigDictionary configDictionary;

	public StructFactoryVo() {	
	}
	
	public StructFactoryVo(StructFactory value) {
		value.cloneProperties(this);
	}	
	public ConfigDictionary getConfigDictionary() {
		return configDictionary;
	}

	public void setConfigDictionary(ConfigDictionary configDictionary) {
		this.configDictionary = configDictionary;
	}
}
