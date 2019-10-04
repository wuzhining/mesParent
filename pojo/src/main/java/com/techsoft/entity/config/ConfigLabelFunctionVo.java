package com.techsoft.entity.config;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ConfigLabelField;
import com.techsoft.entity.common.ConfigLabelFunction;
import com.techsoft.entity.common.ConfigSerialNumber;
import com.techsoft.entity.common.ConfigTableField;
import com.techsoft.entity.common.ConfigTableObject;

public class ConfigLabelFunctionVo extends ConfigLabelFunction {
	private static final long serialVersionUID = -3149580862232712419L;
	private ConfigLabelField configLabelField;
	private ConfigDictionary configDictionaryType;
	private ConfigTableObject configTableObject;
	private ConfigTableField configTableField;
	private ConfigSerialNumber configSerialNumber;

	public ConfigLabelFunctionVo() {	
	}
	
	public ConfigLabelFunctionVo(ConfigLabelFunction value) {
		value.cloneProperties(this);
	}

	public ConfigLabelField getConfigLabelField() {
		return configLabelField;
	}

	public void setConfigLabelField(ConfigLabelField configLabelField) {
		this.configLabelField = configLabelField;
	}

	public ConfigDictionary getConfigDictionaryType() {
		return configDictionaryType;
	}

	public void setConfigDictionaryType(ConfigDictionary configDictionaryType) {
		this.configDictionaryType = configDictionaryType;
	}

	public ConfigTableObject getConfigTableObject() {
		return configTableObject;
	}

	public void setConfigTableObject(ConfigTableObject configTableObject) {
		this.configTableObject = configTableObject;
	}

	public ConfigTableField getConfigTableField() {
		return configTableField;
	}

	public void setConfigTableField(ConfigTableField configTableField) {
		this.configTableField = configTableField;
	}

	public ConfigSerialNumber getConfigSerialNumber() {
		return configSerialNumber;
	}

	public void setConfigSerialNumber(ConfigSerialNumber configSerialNumber) {
		this.configSerialNumber = configSerialNumber;
	}
	
}
