package com.techsoft.entity.config;

import com.techsoft.entity.common.ConfigCodeRule;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ConfigLabelFunction;
import com.techsoft.entity.common.ConfigTableObject;

public class ConfigCodeRuleVo extends ConfigCodeRule {
	private static final long serialVersionUID = -6128779696539607704L;
	private ConfigTableObject configTableObject;
	private ConfigLabelFunction configLabelFunction;
	private String labelFunctionName;
	private ConfigDictionary configDictionary;//单据类型

	public ConfigDictionary getConfigDictionary() {
		return configDictionary;
	}

	public void setConfigDictionary(ConfigDictionary configDictionary) {
		this.configDictionary = configDictionary;
	}

	public String getLabelFunctionName() {
		return labelFunctionName;
	}

	public void setLabelFunctionName(String labelFunctionName) {
		this.labelFunctionName = labelFunctionName;
	}

	public ConfigCodeRuleVo() {	
	}
	
	public ConfigCodeRuleVo(ConfigCodeRule value) {
		value.cloneProperties(this);
	}

	public ConfigTableObject getConfigTableObject() {
		return configTableObject;
	}

	public void setConfigTableObject(ConfigTableObject configTableObject) {
		this.configTableObject = configTableObject;
	}

	public ConfigLabelFunction getConfigLabelFunction() {
		return configLabelFunction;
	}

	public void setConfigLabelFunction(ConfigLabelFunction configLabelFunction) {
		this.configLabelFunction = configLabelFunction;
	}	
	
}
