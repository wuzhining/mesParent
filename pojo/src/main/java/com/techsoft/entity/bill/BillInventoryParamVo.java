package com.techsoft.entity.bill;

import java.util.Date;

import com.techsoft.entity.common.BillInventory;

public class BillInventoryParamVo extends BillInventory {
	private static final long serialVersionUID = -4828022005486181916L;

	public BillInventoryParamVo (){
	}
	
	public BillInventoryParamVo(BillInventory value) {
		value.cloneProperties(this);
	}	
	
	private Date timeStartBegin;	
	private Date timeStartEnd;	  
	private Date timeEndBegin;	
	private Date timeEndEnd;	  
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;
	private Long notFinish;
	
	public Date getTimeStartBegin() {
		return timeStartBegin;
	}
	
	public void setTimeStartBegin(Date value) {
		this.timeStartBegin = value;
	}	
	
	public Date getTimeStartEnd() {
		return timeStartEnd;
	}

	public void setTimeStartEnd(Date value) {
		this.timeStartEnd = value;
	}	
	public Date getTimeEndBegin() {
		return timeEndBegin;
	}
	
	public void setTimeEndBegin(Date value) {
		this.timeEndBegin = value;
	}	
	
	public Date getTimeEndEnd() {
		return timeEndEnd;
	}

	public void setTimeEndEnd(Date value) {
		this.timeEndEnd = value;
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

	
	public Long getNotFinish() {
		return notFinish;
	}

	public void setNotFinish(Long notFinish) {
		this.notFinish = notFinish;
	}			
}
