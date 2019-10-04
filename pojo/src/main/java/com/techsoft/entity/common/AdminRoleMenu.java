package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class AdminRoleMenu extends BaseEntity {
	private static final long serialVersionUID = -6575302259107435974L;


	public AdminRoleMenu(){	
	}
	
	private Long tenantId;	
	   
	private Long roleId;	
	   
	private Long menuId;	
	   
                		
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
                		
	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
}
