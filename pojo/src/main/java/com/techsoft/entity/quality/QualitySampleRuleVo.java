package com.techsoft.entity.quality;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.QualitySampleRule;

public class QualitySampleRuleVo extends QualitySampleRule {
	private static final long serialVersionUID = -8085637256363986994L;
	
	
	private ConfigDictionary configDictionary;

	public QualitySampleRuleVo() {	
	}
	
	public QualitySampleRuleVo(QualitySampleRule value) {
		value.cloneProperties(this);
	}

	public ConfigDictionary getConfigDictionary() {
		return configDictionary;
	}

	public void setConfigDictionary(ConfigDictionary configDictionary) {
		this.configDictionary = configDictionary;
	}
	
}
