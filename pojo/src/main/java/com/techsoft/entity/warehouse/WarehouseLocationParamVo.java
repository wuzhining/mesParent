package com.techsoft.entity.warehouse;

import java.util.Date;

import com.techsoft.entity.common.WarehouseLocation;

public class WarehouseLocationParamVo extends WarehouseLocation {
	private static final long serialVersionUID = -3826350434727582395L;


	public WarehouseLocationParamVo (){
	}
	
	public WarehouseLocationParamVo(WarehouseLocation value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeLocationCode;
	private String likeLocationName;
	
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

	public String getLikeLocationCode() {
		return likeLocationCode;
	}

	public void setLikeLocationCode(String likeLocationCode) {
		this.likeLocationCode = likeLocationCode;
	}

	public String getLikeLocationName() {
		return likeLocationName;
	}

	public void setLikeLocationName(String likeLocationName) {
		this.likeLocationName = likeLocationName;
	}			
}
