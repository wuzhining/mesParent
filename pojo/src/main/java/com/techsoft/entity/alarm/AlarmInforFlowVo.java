package com.techsoft.entity.alarm;

import com.techsoft.entity.common.AlarmInforFlow;
import com.techsoft.entity.common.AlarmProblem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.common.UserPassport;

public class AlarmInforFlowVo extends AlarmInforFlow {
	private static final long serialVersionUID = -5708579483357821552L;
	private EquipWork equipWork;
	private AlarmProblem alarmProblem;
	private ConfigDictionary classconfigDictionary;
	private ConfigDictionary statusconfigDictionary;
	private ConfigDictionary dealResultDict;
	private UserPassport alarmUser;
	private UserPassport respondUser;
	private UserPassport confirmUser;
	private UserPassport dealUser;

	public AlarmInforFlowVo() {
	}
	
	public AlarmInforFlowVo(AlarmInforFlow value) {
		value.cloneProperties(this);
	}	
	
	public EquipWork getEquipWork() {
		return equipWork;
	}

	public void setEquipWork(EquipWork equipWork) {
		this.equipWork = equipWork;
	}

	public AlarmProblem getAlarmProblem() {
		return alarmProblem;
	}

	public void setAlarmProblem(AlarmProblem alarmProblem) {
		this.alarmProblem = alarmProblem;
	}
	
	public ConfigDictionary getClassconfigDictionary() {
		return classconfigDictionary;
	}

	public void setClassconfigDictionary(ConfigDictionary classconfigDictionary) {
		this.classconfigDictionary = classconfigDictionary;
	}
	
	public ConfigDictionary getStatusconfigDictionary() {
		return statusconfigDictionary;
	}

	public void setStatusconfigDictionary(ConfigDictionary statusconfigDictionary) {
		this.statusconfigDictionary = statusconfigDictionary;
	}

	public ConfigDictionary getDealResultDict() {
		return dealResultDict;
	}

	public void setDealResultDict(ConfigDictionary dealResultDict) {
		this.dealResultDict = dealResultDict;
	}

	public UserPassport getAlarmUser() {
		return alarmUser;
	}

	public void setAlarmUser(UserPassport alarmUser) {
		this.alarmUser = alarmUser;
	}

	public UserPassport getRespondUser() {
		return respondUser;
	}

	public void setRespondUser(UserPassport respondUser) {
		this.respondUser = respondUser;
	}

	public UserPassport getConfirmUser() {
		return confirmUser;
	}

	public void setConfirmUser(UserPassport confirmUser) {
		this.confirmUser = confirmUser;
	}

	public UserPassport getDealUser() {
		return dealUser;
	}

	public void setDealUser(UserPassport dealUser) {
		this.dealUser = dealUser;
	}

	
}
