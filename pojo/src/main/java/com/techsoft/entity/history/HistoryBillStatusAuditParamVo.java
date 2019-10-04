package com.techsoft.entity.history;

import java.util.Date;

import com.techsoft.entity.common.HistoryBillStatusAudit;

public class HistoryBillStatusAuditParamVo extends HistoryBillStatusAudit {
	private static final long serialVersionUID = -6235204285126456797L;


	public HistoryBillStatusAuditParamVo (){
	}
	
	public HistoryBillStatusAuditParamVo(HistoryBillStatusAudit value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	private String billCodeLike;
	
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

	public String getBillCodeLike() {
		return billCodeLike;
	}

	public void setBillCodeLike(String billCodeLike) {
		this.billCodeLike = billCodeLike;
	}
	
}
