package com.techsoft.entity.config;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ConfigLabelField;

public class ConfigLabelFieldVo extends ConfigLabelField {
	private static final long serialVersionUID = -460000694674545494L;
	
	private ConfigDictionary printModeDict;//打印方式

	public ConfigLabelFieldVo() {	
	}
	
	public ConfigLabelFieldVo(ConfigLabelField value) {
		value.cloneProperties(this);
	}

	public ConfigDictionary getPrintModeDict() {
		return printModeDict;
	}

	public void setPrintModeDict(ConfigDictionary printModeDict) {
		this.printModeDict = printModeDict;
	}
	
	
}
