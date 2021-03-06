package com.techsoft.entity.bill;

import java.util.Date;

import com.techsoft.entity.common.BillSaleorder;

public class BillSaleorderParamVo extends BillSaleorder {
	private static final long serialVersionUID = 7226811437792898609L;

	public BillSaleorderParamVo (){
	}
	
	public BillSaleorderParamVo(BillSaleorder value) {
		value.cloneProperties(this);
	}	
	
	private Date planTimeBegin;	
	private Date planTimeEnd;	  
	private Date deliveryTimeBegin;	
	private Date deliveryTimeEnd;	  
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	private String billCodeLike;
	
	public Date getPlanTimeBegin() {
		return planTimeBegin;
	}
	
	public void setPlanTimeBegin(Date value) {
		this.planTimeBegin = value;
	}	
	
	public Date getPlanTimeEnd() {
		return planTimeEnd;
	}

	public void setPlanTimeEnd(Date value) {
		this.planTimeEnd = value;
	}	
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
