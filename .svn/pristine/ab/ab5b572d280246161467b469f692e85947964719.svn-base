package com.techsoft.entity.config;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ConfigSerialNumber;
import com.techsoft.entity.common.ConfigTableObject;

public class ConfigSerialNumberVo extends ConfigSerialNumber {
	private static final long serialVersionUID = 8498618477192213785L;
	private ConfigTableObject configTableObject;//数据表
	private ConfigDictionary configresetmodeList;//复位方式数据字典
	
	public ConfigTableObject getConfigTableObject() {
		return configTableObject;
	}

	public void setConfigTableObject(ConfigTableObject configTableObject) {
		this.configTableObject = configTableObject;
	}

	public ConfigDictionary getConfigresetmodeList() {
		return configresetmodeList;
	}

	public void setConfigresetmodeList(ConfigDictionary configresetmodeList) {
		this.configresetmodeList = configresetmodeList;
	}

	public ConfigSerialNumberVo() {	
	}
	
	public ConfigSerialNumberVo(ConfigSerialNumber value) {
		value.cloneProperties(this);
	}		
}
