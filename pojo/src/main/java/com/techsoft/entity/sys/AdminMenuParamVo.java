package com.techsoft.entity.sys;

import java.util.Date;

import com.techsoft.entity.common.AdminMenu;

public class AdminMenuParamVo extends AdminMenu {
	private static final long serialVersionUID = 4090622847377588720L;


	public AdminMenuParamVo (){
	}
	
	public AdminMenuParamVo(AdminMenu value) {
		value.cloneProperties(this);
	}	
	private Integer parent;
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeMenuName;
	
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
	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public String getLikeMenuName() {
		return likeMenuName;
	}

	public void setLikeMenuName(String likeMenuName) {
		this.likeMenuName = likeMenuName;
	}
	
}
