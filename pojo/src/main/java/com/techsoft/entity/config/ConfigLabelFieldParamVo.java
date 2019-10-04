package com.techsoft.entity.config;

import java.util.Date;

import com.techsoft.entity.common.ConfigLabelField;

public class ConfigLabelFieldParamVo extends ConfigLabelField {
	private static final long serialVersionUID = -1190674305357362252L;


	public ConfigLabelFieldParamVo (){
	}
	
	public ConfigLabelFieldParamVo(ConfigLabelField value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeLabelFieldName;
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

	public String getLikeLabelFieldName() {
		return likeLabelFieldName;
	}

	public void setLikeLabelFieldName(String likeLabelFieldName) {
		this.likeLabelFieldName = likeLabelFieldName;
	}	
	
}
