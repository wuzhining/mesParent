package com.techsoft.entity.sys;

import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.UserTenant;

public class UserTenantVo extends UserTenant {
	private static final long serialVersionUID = -4402014109010013770L;
	private UserPassport userPassport;
	
	public UserPassport getUserPassport() {
		return userPassport;
	}

	public void setUserPassport(UserPassport userPassport) {
		this.userPassport = userPassport;
	}

	public UserTenantVo() {	
	}
	
	public UserTenantVo(UserTenant value) {
		value.cloneProperties(this);
	}		
}
