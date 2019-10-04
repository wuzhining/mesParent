package com.techsoft.entity.config;

import java.util.Date;

import com.techsoft.entity.common.ConfigDictionary;

public class ConfigDictionaryParamVo extends ConfigDictionary {
	private static final long serialVersionUID = 8818617832451499871L;


	public ConfigDictionaryParamVo (){
	}
	
	public ConfigDictionaryParamVo(ConfigDictionary value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;
	/**
	 * dealResult,用途过滤质检单的处理结果
	 */
	private String dealResult;
	
	
	private String notInDictType;
	
	private String likeDictCode;
	private String likeDictName;
	
	private String orderBy;  

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

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
	
	
	public String getNotInDictType() {
		return notInDictType;
	}

	public void setNotInDictType(String notInDictType) {
		this.notInDictType = notInDictType;
	}

	public String getDealResult() {
		return dealResult;
	}

	public void setDealResult(String dealResult) {
		this.dealResult = dealResult;
	}

	public String getLikeDictCode() {
		return likeDictCode;
	}

	public void setLikeDictCode(String likeDictCode) {
		this.likeDictCode = likeDictCode;
	}

	public String getLikeDictName() {
		return likeDictName;
	}

	public void setLikeDictName(String likeDictName) {
		this.likeDictName = likeDictName;
	}
	
}
