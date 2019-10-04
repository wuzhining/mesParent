package com.techsoft.entity.scada;

import java.util.Date;

import com.techsoft.entity.common.ScadaSpiSolderPcb;

public class ScadaSpiSolderPcbParamVo extends ScadaSpiSolderPcb {
	private static final long serialVersionUID = 6106115330614576463L;

	public ScadaSpiSolderPcbParamVo (){
	}
	
	public ScadaSpiSolderPcbParamVo(ScadaSpiSolderPcb value) {
		value.cloneProperties(this);
	}	
	
	private Date inspecttimeBegin;	
	private Date inspecttimeEnd;	  
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	public Date getInspecttimeBegin() {
		return inspecttimeBegin;
	}
	
	public void setInspecttimeBegin(Date value) {
		this.inspecttimeBegin = value;
	}	
	
	public Date getInspecttimeEnd() {
		return inspecttimeEnd;
	}

	public void setInspecttimeEnd(Date value) {
		this.inspecttimeEnd = value;
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
