package com.techsoft.entity.alarm;

import java.util.Date;

import com.techsoft.entity.common.AlarmProblem;

public class AlarmProblemParamVo extends AlarmProblem {
	private static final long serialVersionUID = -6298686407843568024L;


	public AlarmProblemParamVo (){
	}
	
	public AlarmProblemParamVo(AlarmProblem value) {
		value.cloneProperties(this);
	}	
	private String problemLike;
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	
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

	public String getProblemLike() {
		return problemLike;
	}

	public void setProblemLike(String problemLike) {
		this.problemLike = problemLike;
	}	
	
}
