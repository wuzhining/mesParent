package com.techsoft.entity.sys;

import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.UserTenant;

public class UserPassportVo extends UserPassport {
	private static final long serialVersionUID = -8779619259944394738L;
	
    private String statusName;
    private String systemRoletype;
    private UserTenant userTenant;
    
	public String getSystemRoletype() {
		return systemRoletype;
	}

	public void setSystemRoletype(String systemRoletype) {
		this.systemRoletype = systemRoletype;
	}

	public UserTenant getUserTenant() {
		return userTenant;
	}

	public void setUserTenant(UserTenant userTenant) {
		this.userTenant = userTenant;
	}

	public UserPassportVo() {	
	}
	
	public UserPassportVo(UserPassport value) {
		value.cloneProperties(this);
	}	
	
    
	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
