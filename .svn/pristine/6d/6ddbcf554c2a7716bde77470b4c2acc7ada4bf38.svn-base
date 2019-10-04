package com.techsoft.entity.config;

import com.techsoft.entity.common.ConfigCodeRule;
import com.techsoft.entity.common.ConfigCodeRuleItem;
import com.techsoft.entity.common.ConfigLabelFunction;
import com.techsoft.entity.common.ConfigTableObject;

public class ConfigCodeRuleItemVo extends ConfigCodeRuleItem {
	private static final long serialVersionUID = -4610065122048163571L;
    private ConfigCodeRule configCodeRule;
    private ConfigLabelFunction configLabelFunction;
	private String labelFunctionName;
	private ConfigTableObject configTableObject;
	
	public ConfigTableObject getConfigTableObject() {
		return configTableObject;
	}

	public void setConfigTableObject(ConfigTableObject configTableObject) {
		this.configTableObject = configTableObject;
	}

	public ConfigCodeRule getConfigCodeRule() {
		return configCodeRule;
	}

	public void setConfigCodeRule(ConfigCodeRule configCodeRule) {
		this.configCodeRule = configCodeRule;
	}

	public ConfigLabelFunction getConfigLabelFunction() {
		return configLabelFunction;
	}

	public void setConfigLabelFunction(ConfigLabelFunction configLabelFunction) {
		this.configLabelFunction = configLabelFunction;
	}

	public String getLabelFunctionName() {
		return labelFunctionName;
	}

	public void setLabelFunctionName(String labelFunctionName) {
		this.labelFunctionName = labelFunctionName;
	}

	public ConfigCodeRuleItemVo() {	
	}
	
	public ConfigCodeRuleItemVo(ConfigCodeRuleItem value) {
		value.cloneProperties(this);
	}		
}
