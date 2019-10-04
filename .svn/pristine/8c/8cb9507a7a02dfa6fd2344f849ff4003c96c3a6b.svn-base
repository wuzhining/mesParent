package com.techsoft.entity.sys;

import com.techsoft.entity.common.AdminRole;
import com.techsoft.entity.common.AdminRoleUser;
import com.techsoft.entity.common.UserPassport;

public class AdminRoleUserVo extends AdminRoleUser {
	private static final long serialVersionUID = -224420582551415308L;
    private AdminRole adminRole;
    private UserPassport userPassport;
    
	public AdminRole getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(AdminRole adminRole) {
		this.adminRole = adminRole;
	}

	public UserPassport getUserPassport() {
		return userPassport;
	}

	public void setUserPassport(UserPassport userPassport) {
		this.userPassport = userPassport;
	}

	public AdminRoleUserVo() {	
	}
	
	public AdminRoleUserVo(AdminRoleUser value) {
		value.cloneProperties(this);
	}		
}
