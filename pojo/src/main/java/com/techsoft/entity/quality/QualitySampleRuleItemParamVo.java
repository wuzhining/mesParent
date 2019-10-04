package com.techsoft.entity.quality;

import java.util.Date;

import com.techsoft.entity.common.QualitySampleRuleItem;

public class QualitySampleRuleItemParamVo extends QualitySampleRuleItem {
	private static final long serialVersionUID = -6112128781970865061L;


	public QualitySampleRuleItemParamVo (){
	}
	
	public QualitySampleRuleItemParamVo(QualitySampleRuleItem value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	
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
}
