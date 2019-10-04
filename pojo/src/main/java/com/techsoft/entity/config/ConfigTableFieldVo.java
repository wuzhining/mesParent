package com.techsoft.entity.config;

import com.techsoft.entity.common.ConfigTableField;
import com.techsoft.entity.common.ConfigTableObject;

public class ConfigTableFieldVo extends ConfigTableField {
	private static final long serialVersionUID = -2375545226947070298L;
	private ConfigTableObject configTableObject;

	public ConfigTableFieldVo() {	
	}
	
	public ConfigTableFieldVo(ConfigTableField value) {
		value.cloneProperties(this);
	}

	public ConfigTableObject getConfigTableObject() {
		return configTableObject;
	}

	public void setConfigTableObject(ConfigTableObject configTableObject) {
		this.configTableObject = configTableObject;
	}
	
}
