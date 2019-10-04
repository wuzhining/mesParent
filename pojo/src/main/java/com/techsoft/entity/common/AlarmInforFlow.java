package com.techsoft.entity.common;

import java.util.Date;

import com.techsoft.common.BaseEntity;

public class AlarmInforFlow extends BaseEntity {
	private static final long serialVersionUID = -7942091255733728557L;


	public AlarmInforFlow(){	
	}
	
	private Long tenantId;	
	   
	private Long equipWorkId;	
	   
	private Long problemId;	
	   
	private Long alarmLevelId;	
	   
	private Long alarmTypeDictId;	
	   
	private Long statusDictId;	
	   
	private Long dealResultDictId;	
	   
	private Long alarmUserId;	
	   
	private Long respondUserId;	
	   
	private Long dealUserId;	
	   
	private Long confirmUserId;	
	   
	private Date alarmTime;	
	   
	private Date respondTime;	
	   
	private Date confirmTime;	
	   
	private Date dealTime;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getEquipWorkId() {
		return equipWorkId;
	}

	public void setEquipWorkId(Long equipWorkId) {
		this.equipWorkId = equipWorkId;
	}
                		
	public Long getProblemId() {
		return problemId;
	}

	public void setProblemId(Long problemId) {
		this.problemId = problemId;
	}
                		
	public Long getAlarmLevelId() {
		return alarmLevelId;
	}

	public void setAlarmLevelId(Long alarmLevelId) {
		this.alarmLevelId = alarmLevelId;
	}
                		
	public Long getAlarmTypeDictId() {
		return alarmTypeDictId;
	}

	public void setAlarmTypeDictId(Long alarmTypeDictId) {
		this.alarmTypeDictId = alarmTypeDictId;
	}
                		
	public Long getStatusDictId() {
		return statusDictId;
	}

	public void setStatusDictId(Long statusDictId) {
		this.statusDictId = statusDictId;
	}
                		
	public Long getDealResultDictId() {
		return dealResultDictId;
	}

	public void setDealResultDictId(Long dealResultDictId) {
		this.dealResultDictId = dealResultDictId;
	}
                		
	public Long getAlarmUserId() {
		return alarmUserId;
	}

	public void setAlarmUserId(Long alarmUserId) {
		this.alarmUserId = alarmUserId;
	}
                		
	public Long getRespondUserId() {
		return respondUserId;
	}

	public void setRespondUserId(Long respondUserId) {
		this.respondUserId = respondUserId;
	}
                		
	public Long getDealUserId() {
		return dealUserId;
	}

	public void setDealUserId(Long dealUserId) {
		this.dealUserId = dealUserId;
	}
                		
	public Long getConfirmUserId() {
		return confirmUserId;
	}

	public void setConfirmUserId(Long confirmUserId) {
		this.confirmUserId = confirmUserId;
	}
                		
	public Date getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}
                		
	public Date getRespondTime() {
		return respondTime;
	}

	public void setRespondTime(Date respondTime) {
		this.respondTime = respondTime;
	}
                		
	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}
                		
	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
