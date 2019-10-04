package com.techsoft.entity.work;

import java.util.Date;

import com.techsoft.entity.common.WorkPlanMaterial;

public class WorkPlanMaterialParamVo extends WorkPlanMaterial {
	private static final long serialVersionUID = 5320151140974708875L;

	public WorkPlanMaterialParamVo (){
	}
	
	public WorkPlanMaterialParamVo(WorkPlanMaterial value) {
		value.cloneProperties(this);
	}	
	
	private Date timePlanStartBegin;	
	private Date timePlanStartEnd;	  
	private Date timePlanEndBegin;	
	private Date timePlanEndEnd;	  
	private Date timeActualStartBegin;	
	private Date timeActualStartEnd;	  
	private Date timeActualEndBegin;	
	private Date timeActualEndEnd;	  
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	public Date getTimePlanStartBegin() {
		return timePlanStartBegin;
	}
	
	public void setTimePlanStartBegin(Date value) {
		this.timePlanStartBegin = value;
	}	
	
	public Date getTimePlanStartEnd() {
		return timePlanStartEnd;
	}

	public void setTimePlanStartEnd(Date value) {
		this.timePlanStartEnd = value;
	}	
	public Date getTimePlanEndBegin() {
		return timePlanEndBegin;
	}
	
	public void setTimePlanEndBegin(Date value) {
		this.timePlanEndBegin = value;
	}	
	
	public Date getTimePlanEndEnd() {
		return timePlanEndEnd;
	}

	public void setTimePlanEndEnd(Date value) {
		this.timePlanEndEnd = value;
	}	
	public Date getTimeActualStartBegin() {
		return timeActualStartBegin;
	}
	
	public void setTimeActualStartBegin(Date value) {
		this.timeActualStartBegin = value;
	}	
	
	public Date getTimeActualStartEnd() {
		return timeActualStartEnd;
	}

	public void setTimeActualStartEnd(Date value) {
		this.timeActualStartEnd = value;
	}	
	public Date getTimeActualEndBegin() {
		return timeActualEndBegin;
	}
	
	public void setTimeActualEndBegin(Date value) {
		this.timeActualEndBegin = value;
	}	
	
	public Date getTimeActualEndEnd() {
		return timeActualEndEnd;
	}

	public void setTimeActualEndEnd(Date value) {
		this.timeActualEndEnd = value;
	}	
	
	public Date getCreateTimeBegin() {
		return createTimeBegin;
	}

	public void setCreateTimeBegin(Date value) {
		this.createTimeBegin = value;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date value) {
		this.createTimeEnd = value;
	}

	public Date getModifyTimeBegin() {
		return modifyTimeBegin;
	}

	public void setModifyTimeBegin(Date value) {
		this.modifyTimeBegin = value;
	}

	public Date getModifyTimeEnd() {
		return modifyTimeEnd;
	}

	public void setModifyTimeEnd(Date value) {
		this.modifyTimeEnd = value;
	}			
}
