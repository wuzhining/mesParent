package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class StructWorkCalendar extends BaseEntity {
	private static final long serialVersionUID = 6081871691386339801L;


	public StructWorkCalendar(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private String dates;	
	   
	private Integer dateYear;	
	   
	private Integer dateMonth;	
	   
	private Integer dateDay;	
	   
	private String weekday;	
	   
	private String periodtime;	
	   
	private String isVacation;	
	   
	private String isWork;	
	   
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
                		
	public String getIsVacation() {
		return isVacation;
	}

	public void setIsVacation(String isVacation) {
		this.isVacation = isVacation;
	}
                		
	public String getIsWork() {
		return isWork;
	}

	public void setIsWork(String isWork) {
		this.isWork = isWork;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
