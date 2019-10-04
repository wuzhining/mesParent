package com.techsoft.entity.config;

import java.util.Date;

import com.techsoft.entity.common.ConfigCountry;

public class ConfigCountryParamVo extends ConfigCountry {
	private static final long serialVersionUID = 7368906562108958870L;


	public ConfigCountryParamVo (){
	}
	
	public ConfigCountryParamVo(ConfigCountry value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeCountryName;
	private String likeContinent;
	public Date getCreateTimeBegin() {
		return createTimeBegin;
	}

	public void setCreateTimeBegin(Date value) {
		this.createTimeBegin = value;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date value) {
		this.createTimeEnd = value;
	}

	public Date getModifyTimeBegin() {
		return modifyTimeBegin;
	}

	public void setModifyTimeBegin(Date value) {
		this.modifyTimeBegin = value;
	}

	public Date getModifyTimeEnd() {
		return modifyTimeEnd;
	}

	public void setModifyTimeEnd(Date value) {
		this.modifyTimeEnd = value;
	}

	public String getLikeCountryName() {
		return likeCountryName;
	}

	public void setLikeCountryName(String likeCountryName) {
		this.likeCountryName = likeCountryName;
	}

	public String getLikeContinent() {
		return likeContinent;
	}

	public void setLikeContinent(String likeContinent) {
		this.likeContinent = likeContinent;
	}		
	
}
