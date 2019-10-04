package com.techsoft.entity.sys;

import java.util.ArrayList;
import java.util.List;

import com.techsoft.entity.common.UserPassport;

public class UserPassportAuthorityVo extends UserPassport {
	private static final long serialVersionUID = -8779619259944394738L;

	List<String> authorityRoleList = new ArrayList<String>();
	List<String> authorityPermissionList  = new ArrayList<String>();
	 
 

	public UserPassportAuthorityVo() {	
	}
	
	public UserPassportAuthorityVo(UserPassport value) {
		value.cloneProperties(this);
	}

	public List<String> getAuthorityRoleList() {
		return authorityRoleList;
	}

	public void setAuthorityRoleList(List<String> authorityRoleList) {
		this.authorityRoleList = authorityRoleList;
	}

	public List<String> getAuthorityPermissionList() {
		return authorityPermissionList;
	}

	public void setAuthorityPermissionList(List<String> authorityPermissionList) {
		this.authorityPermissionList = authorityPermissionList;
	}
 
 
}
