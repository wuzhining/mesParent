package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class WorkSchedulingEmployee extends BaseEntity {
	private static final long serialVersionUID = 8778801845808279443L;


	public WorkSchedulingEmployee(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long workshopId;	
	   
	private Long workshopAreaId;	
	   
	private Long workstationId;	
	   
	private Long employeeId;	
	   
	private String dates;	
	   
	private Integer dateYear;	
	   
	private Integer dateMonth;	
	   
	private Integer dateDay;	
	   
	private String weekday;	
	   
	private String periodtime;	
	   
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
                		
	public Long getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Long workshopId) {
		this.workshopId = workshopId;
	}
                		
	public Long getWorkshopAreaId() {
		return workshopAreaId;
	}

	public void setWorkshopAreaId(Long workshopAreaId) {
		this.workshopAreaId = workshopAreaId;
	}
                		
	public Long getWorkstationId() {
		return workstationId;
	}

	public void setWorkstationId(Long workstationId) {
		this.workstationId = workstationId;
	}
                		
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
                		
	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}
                		
	public Integer getDateYear() {
		return dateYear;
	}

	public void setDateYear(Integer dateYear) {
		this.dateYear = dateYear;
	}
                		
	public Integer getDateMonth() {
		return dateMonth;
	}

	public void setDateMonth(Integer dateMonth) {
		this.dateMonth = dateMonth;
	}
                		
	public Integer getDateDay() {
		return dateDay;
	}

	public void setDateDay(Integer dateDay) {
		this.dateDay = dateDay;
	}
                		
	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
                		
	public String getPeriodtime() {
		return periodtime;
	}

	public void setPeriodtime(String periodtime) {
		this.periodtime = periodtime;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
