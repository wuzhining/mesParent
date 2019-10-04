package com.techsoft.entity.alarm;

import com.techsoft.entity.common.AlarmGroupUser;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmEmployee;

public class AlarmGroupUserVo extends AlarmGroupUser {
	private static final long serialVersionUID = 6354800231069662L;
	private FirmEmployee firmEmployee;
	private ConfigDictionary configDictionary;

	public AlarmGroupUserVo() {	
	}
	
	public AlarmGroupUserVo(AlarmGroupUser value) {
		value.cloneProperties(this);
	}	
	
	public FirmEmployee getFirmEmployee() {
		return firmEmployee;
	}

	public void setFirmEmployee(FirmEmployee firmEmployee) {
		this.firmEmployee = firmEmployee;
	}
	
	public ConfigDictionary getConfigDictionary() {
		return configDictionary;
	}

	public void setConfigDictionary(ConfigDictionary configDictionary) {
		this.configDictionary = configDictionary;
	}
}
