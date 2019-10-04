package com.techsoft.entity.firm;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmEmployee;
import com.techsoft.entity.common.FirmPost;
import com.techsoft.entity.common.UserPassport;

public class FirmEmployeeVo extends FirmEmployee {
	private static final long serialVersionUID = 5548707008930905109L;
	private FirmPost firmPost;
	private ConfigDictionary configDictionary;
	private UserPassport userPassport;
	

	public UserPassport getUserPassport() {
		return userPassport;
	}

	public void setUserPassport(UserPassport userPassport) {
		this.userPassport = userPassport;
	}

	public FirmEmployeeVo() {	
	}
	
	public FirmEmployeeVo(FirmEmployee value) {
		value.cloneProperties(this);
	}

	public FirmPost getFirmPost() {
		return firmPost;
	}

	public void setFirmPost(FirmPost firmPost) {
		this.firmPost = firmPost;
	}

	public ConfigDictionary getConfigDictionary() {
		return configDictionary;
	}

	public void setConfigDictionary(ConfigDictionary configDictionary) {
		this.configDictionary = configDictionary;
	}
	
}
