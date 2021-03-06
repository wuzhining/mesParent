package com.techsoft.entity.bill;

import java.util.Date;

import com.techsoft.entity.common.BillDelivery;

public class BillDeliveryParamVo extends BillDelivery {
	private static final long serialVersionUID = 7025132267740628629L;

	public BillDeliveryParamVo (){
	}
	
	public BillDeliveryParamVo(BillDelivery value) {
		value.cloneProperties(this);
	}	
	
	private Date deliveryTimeBegin;	
	private Date deliveryTimeEnd;	  
	private Date predictArrivalTimeBegin;	
	private Date predictArrivalTimeEnd;	  
	private Date arrivalTimeBegin;	
	private Date arrivalTimeEnd;	  
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeBillCode;
	
	public Date getDeliveryTimeBegin() {
		return deliveryTimeBegin;
	}
	
	public void setDeliveryTimeBegin(Date value) {
		this.deliveryTimeBegin = value;
	}	
	
	public Date getDeliveryTimeEnd() {
		return deliveryTimeEnd;
	}

	public void setDeliveryTimeEnd(Date value) {
		this.deliveryTimeEnd = value;
	}	
	public Date getPredictArrivalTimeBegin() {
		return predictArrivalTimeBegin;
	}
	
	public void setPredictArrivalTimeBegin(Date value) {
		this.predictArrivalTimeBegin = value;
	}	
	
	public Date getPredictArrivalTimeEnd() {
		return predictArrivalTimeEnd;
	}

	public void setPredictArrivalTimeEnd(Date value) {
		this.predictArrivalTimeEnd = value;
	}	
	public Date getArrivalTimeBegin() {
		return arrivalTimeBegin;
	}
	
	public void setArrivalTimeBegin(Date value) {
		this.arrivalTimeBegin = value;
	}	
	
	public Date getArrivalTimeEnd() {
		return arrivalTimeEnd;
	}

	public void setArrivalTimeEnd(Date value) {
		this.arrivalTimeEnd = value;
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

	public String getLikeBillCode() {
		return likeBillCode;
	}

	public void setLikeBillCode(String likeBillCode) {
		this.likeBillCode = likeBillCode;
	}			
}
