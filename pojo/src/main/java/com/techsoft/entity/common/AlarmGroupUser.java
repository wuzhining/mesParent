package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class AlarmGroupUser extends BaseEntity {
	private static final long serialVersionUID = 2644955451679823188L;


	public AlarmGroupUser(){	
	}
	
	private Long tenantId;	
	   
	private Long userId;	
	   
	private Long alarmGroupDictId;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
                		
	public Long getAlarmGroupDictId() {
		return alarmGroupDictId;
	}

	public void setAlarmGroupDictId(Long alarmGroupDictId) {
		this.alarmGroupDictId = alarmGroupDictId;
	}
}
