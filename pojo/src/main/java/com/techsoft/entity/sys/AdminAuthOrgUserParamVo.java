package com.techsoft.entity.sys;

import java.util.Date;
import java.util.List;

import com.techsoft.entity.common.AdminAuthOrgUser;

public class AdminAuthOrgUserParamVo extends AdminAuthOrgUser {
	private static final long serialVersionUID = 7253008400605892208L;


	public AdminAuthOrgUserParamVo (){
	}
	
	public AdminAuthOrgUserParamVo(AdminAuthOrgUser value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private List<AdminAuthOrgUser> adminAuthOrgUserList;
	
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

	public List<AdminAuthOrgUser> getAdminAuthOrgUserList() {
		return adminAuthOrgUserList;
	}

	public void setAdminAuthOrgUserList(List<AdminAuthOrgUser> adminAuthOrgUserList) {
		this.adminAuthOrgUserList = adminAuthOrgUserList;
	}		
	
}
