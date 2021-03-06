package com.techsoft.entity.track;

import java.util.Date;
import java.util.List;


import com.techsoft.entity.common.TrackBarcode;

public class TrackBarcodeParamVo extends TrackBarcode {
	private static final long serialVersionUID = 5499282920434706381L;


	public TrackBarcodeParamVo (){
	}
	
	public TrackBarcodeParamVo(TrackBarcode value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;
	private List<TrackBarcode> listSn;	
	private String isWarehouseId;
	private Double notQuantity;
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
	
	public List<TrackBarcode> getListSn() {
		return listSn;
	}

	public void setListSn(List<TrackBarcode> listSn) {
		this.listSn = listSn;
	}

	public String getIsWarehouseId() {
		return isWarehouseId;
	}

	public void setIsWarehouseId(String isWarehouseId) {
		this.isWarehouseId = isWarehouseId;
	}

	public Double getNotQuantity() {
		return notQuantity;
	}

	public void setNotQuantity(Double notQuantity) {
		this.notQuantity = notQuantity;
	}

	public String getCompareQty() {
		return compareQty;
	}

	public void setCompareQty(String compareQty) {
		this.compareQty = compareQty;
	}
}
