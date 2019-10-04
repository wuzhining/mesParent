package com.techsoft.entity.bill;

import java.util.Date;

import com.techsoft.entity.common.BillDeliveryItem;

public class BillDeliveryItemParamVo extends BillDeliveryItem {
	private static final long serialVersionUID = 5258299732642774707L;


	public BillDeliveryItemParamVo (){
	}
	
	public BillDeliveryItemParamVo(BillDeliveryItem value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	private Date dateManufactureBegin;
	private Date dateManufactureEnd;	
	
	
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

	public Date getDateManufactureBegin() {
		return dateManufactureBegin;
	}

	public void setDateManufactureBegin(Date dateManufactureBegin) {
		this.dateManufactureBegin = dateManufactureBegin;
	}

	public Date getDateManufactureEnd() {
		return dateManufactureEnd;
	}

	public void setDateManufactureEnd(Date dateManufactureEnd) {
		this.dateManufactureEnd = dateManufactureEnd;
	}			
}
