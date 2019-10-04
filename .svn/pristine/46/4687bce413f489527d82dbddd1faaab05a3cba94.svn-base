package com.techsoft.entity.config;

import java.util.Date;

import org.aspectj.weaver.AjAttribute.PrivilegedAttribute;
import org.springframework.http.StreamingHttpOutputMessage;

import com.techsoft.entity.common.ConfigTableObject;

public class ConfigTableObjectParamVo extends ConfigTableObject {
	private static final long serialVersionUID = -5399871631534098716L;


	public ConfigTableObjectParamVo (){
	}
	
	public ConfigTableObjectParamVo(ConfigTableObject value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeTableObjectName;
	private String likeTableObjectNameCn;
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

	public String getLikeTableObjectName() {
		return likeTableObjectName;
	}

	public void setLikeTableObjectName(String likeTableObjectName) {
		this.likeTableObjectName = likeTableObjectName;
	}

	public String getLikeTableObjectNameCn() {
		return likeTableObjectNameCn;
	}

	public void setLikeTableObjectNameCn(String likeTableObjectNameCn) {
		this.likeTableObjectNameCn = likeTableObjectNameCn;
	}			
	
}
