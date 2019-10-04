package com.techsoft.entity.config;

import java.util.Date;

import com.techsoft.entity.common.ConfigSerialNumber;

public class ConfigSerialNumberParamVo extends ConfigSerialNumber {
	private static final long serialVersionUID = 2041406771318462393L;


	public ConfigSerialNumberParamVo (){
	}
	
	public ConfigSerialNumberParamVo(ConfigSerialNumber value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeSerialName;
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

	public String getLikeSerialName() {
		return likeSerialName;
	}

	public void setLikeSerialName(String likeSerialName) {
		this.likeSerialName = likeSerialName;
	}	
	
}
