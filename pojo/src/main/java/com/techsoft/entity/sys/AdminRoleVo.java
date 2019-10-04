package com.techsoft.entity.sys;

import com.techsoft.entity.common.AdminRole;

public class AdminRoleVo extends AdminRole {
	private static final long serialVersionUID = -8277578809296121844L;

	public AdminRoleVo() {	
	}
	
	public AdminRoleVo(AdminRole value) {
		value.cloneProperties(this);
	}		
}
