package com.techsoft.entity.config;

import java.util.Date;

import com.techsoft.entity.common.ConfigParameter;

public class ConfigParameterParamVo extends ConfigParameter {
	private static final long serialVersionUID = 1253299382431135124L;


	public ConfigParameterParamVo (){
	}
	
	public ConfigParameterParamVo(ConfigParameter value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeParamCode;
	private String likeParamName;
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

	public String getLikeParamCode() {
		return likeParamCode;
	}

	public void setLikeParamCode(String likeParamCode) {
		this.likeParamCode = likeParamCode;
	}

	public String getLikeParamName() {
		return likeParamName;
	}

	public void setLikeParamName(String likeParamName) {
		this.likeParamName = likeParamName;
	}	
	
}
