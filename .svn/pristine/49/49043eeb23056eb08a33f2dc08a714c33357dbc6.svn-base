package com.techsoft.entity.sys;

import com.techsoft.entity.common.AdminMenu;
import com.techsoft.entity.common.ConfigDictionary;

public class AdminMenuVo extends AdminMenu {
	private static final long serialVersionUID = 3364488728004349120L;
	private AdminMenu adminMenu;
	private ConfigDictionary configDictionary;//系统类型
	
	public ConfigDictionary getConfigDictionary() {
		return configDictionary;
	}

	public void setConfigDictionary(ConfigDictionary configDictionary) {
		this.configDictionary = configDictionary;
	}

	public AdminMenu getAdminMenu() {
		return adminMenu;
	}

	public void setAdminMenu(AdminMenu adminMenu) {
		this.adminMenu = adminMenu;
	}

	public AdminMenuVo() {	
	}
	
	public AdminMenuVo(AdminMenu value) {
		value.cloneProperties(this);
	}		
}
