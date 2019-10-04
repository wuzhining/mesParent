package com.techsoft.entity.sys;

import com.techsoft.entity.common.AdminMenu;
import com.techsoft.entity.common.AdminRole;
import com.techsoft.entity.common.AdminRoleMenu;

public class AdminRoleMenuVo extends AdminRoleMenu {
	private static final long serialVersionUID = 6217612182675345566L;
	private AdminRole adminRole;
	private AdminMenu adminMenu;
	
	public AdminRole getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(AdminRole adminRole) {
		this.adminRole = adminRole;
	}

	public AdminMenu getAdminMenu() {
		return adminMenu;
	}

	public void setAdminMenu(AdminMenu adminMenu) {
		this.adminMenu = adminMenu;
	}

	public AdminRoleMenuVo() {	
	}
	
	public AdminRoleMenuVo(AdminRoleMenu value) {
		value.cloneProperties(this);
	}		
}
