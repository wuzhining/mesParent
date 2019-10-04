package com.techsoft.entity.firm;

import java.util.Date;

import com.techsoft.entity.common.FirmScheduling;

public class FirmSchedulingParamVo extends FirmScheduling {
	private static final long serialVersionUID = 8853910746719124517L;


	public FirmSchedulingParamVo (){
	}
	
	public FirmSchedulingParamVo(FirmScheduling value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	private String schedulingNameLike;
	private String schedulingCodeLike;
	
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

	public String getSchedulingNameLike() {
		return schedulingNameLike;
	}

	public void setSchedulingNameLike(String schedulingNameLike) {
		this.schedulingNameLike = schedulingNameLike;
	}

	public String getSchedulingCodeLike() {
		return schedulingCodeLike;
	}

	public void setSchedulingCodeLike(String schedulingCodeLike) {
		this.schedulingCodeLike = schedulingCodeLike;
	}
	
}
