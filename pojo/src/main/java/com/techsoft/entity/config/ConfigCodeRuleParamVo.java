package com.techsoft.entity.config;

import java.util.Date;

import com.techsoft.entity.common.ConfigCodeRule;

public class ConfigCodeRuleParamVo extends ConfigCodeRule {
	private static final long serialVersionUID = -4427334816327577345L;


	public ConfigCodeRuleParamVo (){
	}
	
	public ConfigCodeRuleParamVo(ConfigCodeRule value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeCodeRuleName;
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

	public String getLikeCodeRuleName() {
		return likeCodeRuleName;
	}

	public void setLikeCodeRuleName(String likeCodeRuleName) {
		this.likeCodeRuleName = likeCodeRuleName;
	}	
	
}
