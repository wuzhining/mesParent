package com.techsoft.entity.bill;

import java.util.Date;
import java.util.List;

import com.techsoft.entity.common.BillPurchaseItem;

public class BillPurchaseItemParamVo extends BillPurchaseItem {
	private static final long serialVersionUID = -4518535963817725391L;


	public BillPurchaseItemParamVo (){
	}
	
	public BillPurchaseItemParamVo(BillPurchaseItem value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;
	private Long notFinish;
	
	private String billPurchase;
	private List<Long> ids;
	
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

	public String getBillPurchase() {
		return billPurchase;
	}

	public void setBillPurchase(String billPurchase) {
		this.billPurchase = billPurchase;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}			
}
