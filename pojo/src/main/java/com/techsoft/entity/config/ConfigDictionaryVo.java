package com.techsoft.entity.config;

import com.techsoft.entity.common.ConfigDictionary;

public class ConfigDictionaryVo extends ConfigDictionary {
	private static final long serialVersionUID = 3654536066849844952L;
   
	private ConfigDictionary parentConfigDictionary;

	public ConfigDictionaryVo() {	
	}
	
	public ConfigDictionaryVo(ConfigDictionary value) {
		value.cloneProperties(this);
	}	
	
	
	public ConfigDictionary getParentConfigDictionary() {
		return parentConfigDictionary;
	}

	public void setParentConfigDictionary(ConfigDictionary parentConfigDictionary) {
		this.parentConfigDictionary = parentConfigDictionary;
	}

}
