package com.techsoft.entity.alarm;

import java.util.Date;

import com.techsoft.entity.common.AlarmReason;

public class AlarmReasonParamVo extends AlarmReason {
	private static final long serialVersionUID = -3947202850083354998L;


	public AlarmReasonParamVo (){
	}
	
	public AlarmReasonParamVo(AlarmReason value) {
		value.cloneProperties(this);
	}	
	private String reasonLike;
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

	public String getReasonLike() {
		return reasonLike;
	}

	public void setReasonLike(String reasonLike) {
		this.reasonLike = reasonLike;
	}	
	
}
