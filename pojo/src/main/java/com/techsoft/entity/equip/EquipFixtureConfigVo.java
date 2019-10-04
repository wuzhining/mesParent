package com.techsoft.entity.equip;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipFixtureConfig;

public class EquipFixtureConfigVo extends EquipFixtureConfig {
	private static final long serialVersionUID = -372333000363230501L;
	private ConfigDictionary configFixtureTypeDict;
	private ConfigDictionary configCorrectTypeDict;
	private ConfigDictionary configScrapTypeDict;
	
	public EquipFixtureConfigVo() {	
	}
	
	public EquipFixtureConfigVo(EquipFixtureConfig value) {
		value.cloneProperties(this);
	}

	public ConfigDictionary getConfigFixtureTypeDict() {
		return configFixtureTypeDict;
	}

	public void setConfigFixtureTypeDict(ConfigDictionary configFixtureTypeDict) {
		this.configFixtureTypeDict = configFixtureTypeDict;
	}

	public ConfigDictionary getConfigCorrectTypeDict() {
		return configCorrectTypeDict;
	}

	public void setConfigCorrectTypeDict(ConfigDictionary configCorrectTypeDict) {
		this.configCorrectTypeDict = configCorrectTypeDict;
	}

	public ConfigDictionary getConfigScrapTypeDict() {
		return configScrapTypeDict;
	}

	public void setConfigScrapTypeDict(ConfigDictionary configScrapTypeDict) {
		this.configScrapTypeDict = configScrapTypeDict;
	}
	
}
