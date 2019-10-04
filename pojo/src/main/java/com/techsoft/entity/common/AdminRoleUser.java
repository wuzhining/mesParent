package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class AdminRoleUser extends BaseEntity {
	private static final long serialVersionUID = 2293822080039510229L;


	public AdminRoleUser(){	
	}
	
	private Long tenantId;	
	   
	private Long roleId;	
	   
	private Long userId;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
                		
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
