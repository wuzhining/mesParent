package com.techsoft.entity.config;

import java.util.Date;

import com.techsoft.entity.common.ConfigLabel;
import com.techsoft.entity.common.ConfigLabelField;
import com.techsoft.entity.common.ConfigLabelItem;

public class ConfigLabelItemParamVo extends ConfigLabelItem {
	private static final long serialVersionUID = 1678434912145607084L;
	



	public ConfigLabelItemParamVo (){
	}
	
	public ConfigLabelItemParamVo(ConfigLabelItem value) {
		value.cloneProperties(this);
	}	
	
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


	
	
	
}
