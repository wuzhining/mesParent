package com.techsoft.entity.bill;

import java.util.Date;
import java.util.List;

import com.techsoft.entity.common.BillInspect;

public class BillInspectParamVo extends BillInspect {
	private static final long serialVersionUID = -4827778118128052844L;


	public BillInspectParamVo (){
	}
	
	public BillInspectParamVo(BillInspect value) {
		value.cloneProperties(this);
	}	
	private String inspectCodeLike;
	private String fromBillIdLike;
	private List<Long> fromBillIdlist;
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

	public String getInspectCodeLike() {
		return inspectCodeLike;
	}

	public void setInspectCodeLike(String inspectCodeLike) {
		this.inspectCodeLike = inspectCodeLike;
	}

	public String getFromBillIdLike() {
		return fromBillIdLike;
	}

	public void setFromBillIdLike(String fromBillIdLike) {
		this.fromBillIdLike = fromBillIdLike;
	}

	public List<Long> getFromBillIdlist() {
		return fromBillIdlist;
	}

	public void setFromBillIdlist(List<Long> fromBillIdlist) {
		this.fromBillIdlist = fromBillIdlist;
	}	
	
	
}
