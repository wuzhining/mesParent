package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class FirmScheduling extends BaseEntity {
	private static final long serialVersionUID = -5393330897239830901L;


	public FirmScheduling(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private String schedulingName;	
	   
	private String schedulingCode;	
	   
	private String timeStart;	
	   
	private String timeEnd;	
	   
	private String isValid;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}
                		
	public String getSchedulingName() {
		return schedulingName;
	}

	public void setSchedulingName(String schedulingName) {
		this.schedulingName = schedulingName;
	}
                		
	public String getSchedulingCode() {
		return schedulingCode;
	}

	public void setSchedulingCode(String schedulingCode) {
		this.schedulingCode = schedulingCode;
	}
                		
	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
                		
	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
                		
	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
