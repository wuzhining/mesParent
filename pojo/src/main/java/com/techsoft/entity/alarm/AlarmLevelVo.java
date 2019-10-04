package com.techsoft.entity.alarm;

import com.techsoft.entity.common.AlarmLevel;
import com.techsoft.entity.common.AlarmProblem;

public class AlarmLevelVo extends AlarmLevel {
	private static final long serialVersionUID = -676499907818861082L;
	private AlarmProblem alarmProblem;

	public AlarmLevelVo() {	
	}
	
	public AlarmLevelVo(AlarmLevel value) {
		value.cloneProperties(this);
	}	
	public AlarmProblem getAlarmProblem() {
		return alarmProblem;
	}

	public void setAlarmProblem(AlarmProblem alarmProblem) {
		this.alarmProblem = alarmProblem;
	}
}
