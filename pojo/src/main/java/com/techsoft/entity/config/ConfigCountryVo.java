package com.techsoft.entity.config;

import com.techsoft.entity.common.ConfigCountry;

public class ConfigCountryVo extends ConfigCountry {
	private static final long serialVersionUID = 8538830725974993105L;

	public ConfigCountryVo() {	
	}
	
	public ConfigCountryVo(ConfigCountry value) {
		value.cloneProperties(this);
	}		
}
