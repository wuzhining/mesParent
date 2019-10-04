package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class AlarmLevel extends BaseEntity {
	private static final long serialVersionUID = -2590695745420163575L;


	public AlarmLevel(){	
	}
	
	private Long tenantId;	
	   
	private Long problemId;	
	   
	private Integer minuteRespond;	
	   
	private Integer minuteDeal;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getProblemId() {
		return problemId;
	}

	public void setProblemId(Long problemId) {
		this.problemId = problemId;
	}
                		
	public Integer getMinuteRespond() {
		return minuteRespond;
	}

	public void setMinuteRespond(Integer minuteRespond) {
		this.minuteRespond = minuteRespond;
	}
                		
	public Integer getMinuteDeal() {
		return minuteDeal;
	}

	public void setMinuteDeal(Integer minuteDeal) {
		this.minuteDeal = minuteDeal;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
