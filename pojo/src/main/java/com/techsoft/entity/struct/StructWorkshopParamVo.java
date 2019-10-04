package com.techsoft.entity.struct;

import java.util.Date;

import com.techsoft.entity.common.StructWorkshop;

public class StructWorkshopParamVo extends StructWorkshop {
	private static final long serialVersionUID = -1301074244284205594L;


	public StructWorkshopParamVo (){
	}
	
	public StructWorkshopParamVo(StructWorkshop value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeWorkShopCode;
	private String likeWorkShopName;
	
	
	
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

	public String getLikeWorkShopCode() {
		return likeWorkShopCode;
	}

	public void setLikeWorkShopCode(String likeWorkShopCode) {
		this.likeWorkShopCode = likeWorkShopCode;
	}

	public String getLikeWorkShopName() {
		return likeWorkShopName;
	}

	public void setLikeWorkShopName(String likeWorkShopName) {
		this.likeWorkShopName = likeWorkShopName;
	}		
	
}
