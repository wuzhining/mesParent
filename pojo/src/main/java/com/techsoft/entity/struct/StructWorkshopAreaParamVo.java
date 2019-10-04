package com.techsoft.entity.struct;

import java.util.Date;

import com.techsoft.entity.common.StructWorkshopArea;

public class StructWorkshopAreaParamVo extends StructWorkshopArea {
	private static final long serialVersionUID = 4817847721279800945L;


	public StructWorkshopAreaParamVo (){
	}
	
	public StructWorkshopAreaParamVo(StructWorkshopArea value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeWorkShopAreaCode;
	private String likeWorkShopAreaName;
	
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

	public String getLikeWorkShopAreaCode() {
		return likeWorkShopAreaCode;
	}

	public void setLikeWorkShopAreaCode(String likeWorkShopAreaCode) {
		this.likeWorkShopAreaCode = likeWorkShopAreaCode;
	}

	public String getLikeWorkShopAreaName() {
		return likeWorkShopAreaName;
	}

	public void setLikeWorkShopAreaName(String likeWorkShopAreaName) {
		this.likeWorkShopAreaName = likeWorkShopAreaName;
	}	
	
}

