package com.techsoft.entity.quality;

import java.util.Date;

import com.techsoft.entity.common.QualitySampleLevel;

public class QualitySampleLevelParamVo extends QualitySampleLevel {
	private static final long serialVersionUID = -5072363042480976820L;


	public QualitySampleLevelParamVo (){
	}
	
	public QualitySampleLevelParamVo(QualitySampleLevel value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	private String compareQty;
	
	
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

	public String getCompareQty() {
		return compareQty;
	}

	public void setCompareQty(String compareQty) {
		this.compareQty = compareQty;
	}			
}
