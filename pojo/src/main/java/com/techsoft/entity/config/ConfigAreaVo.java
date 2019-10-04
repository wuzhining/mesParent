package com.techsoft.entity.config;

import com.techsoft.entity.common.ConfigArea;
import com.techsoft.entity.common.ConfigCountry;

public class ConfigAreaVo extends ConfigArea {
	private static final long serialVersionUID = 3834152235510270373L;
	private ConfigCountry configCountry;
	private ConfigArea configArea;
	private Long provinceId;
	private Long cityId;
	public ConfigAreaVo() {	
	}
	
	public ConfigAreaVo(ConfigArea value) {
		value.cloneProperties(this);
	}

	public ConfigCountry getConfigCountry() {
		return configCountry;
	}

	public void setConfigCountry(ConfigCountry configCountry) {
		this.configCountry = configCountry;
	}

	public ConfigArea getConfigArea() {
		return configArea;
	}

	public void setConfigArea(ConfigArea configArea) {
		this.configArea = configArea;
	}
	
	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
}
