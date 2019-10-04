package com.techsoft.entity.config;

import com.techsoft.entity.common.ConfigLabel;
import com.techsoft.entity.common.ConfigLabelField;
import com.techsoft.entity.common.ConfigLabelItem;

public class ConfigLabelItemVo extends ConfigLabelItem {
	private static final long serialVersionUID = 7162033144138707110L;
	private ConfigLabelField configLabelField;//标签字段
	private ConfigLabel configLabel;//标签文档

	public ConfigLabelItemVo() {	
	}
	
	public ConfigLabelItemVo(ConfigLabelItem value) {
		value.cloneProperties(this);
	}
	public ConfigLabelField getConfigLabelField() {
		return configLabelField;
	}

	public void setConfigLabelField(ConfigLabelField configLabelField) {
		this.configLabelField = configLabelField;
	}

	public ConfigLabel getConfigLabel() {
		return configLabel;
	}

	public void setConfigLabel(ConfigLabel configLabel) {
		this.configLabel = configLabel;
	}	
	
}
