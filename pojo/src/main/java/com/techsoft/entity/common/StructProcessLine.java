package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class StructProcessLine extends BaseEntity {
	private static final long serialVersionUID = 5294801537625245210L;


	public StructProcessLine(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long processId;	
	   
	private Integer processVersion;	
	   
	private Long prevNodeId;	
	   
	private Long nextNodeId;	
	   
	private Long lineTypeDictId;	
	   
	private Integer prevNodeCoordinateX;	
	   
	private Integer prevNodeCoordinateY;	
	   
	private Integer nextNodeCoordinateX;	
	   
	private Integer nextNodeCoordinateY;	
	   
                		
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
                		
	public Long getProcessId() {
		return processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
	}
                		
	public Integer getProcessVersion() {
		return processVersion;
	}

	public void setProcessVersion(Integer processVersion) {
		this.processVersion = processVersion;
	}
                		
	public Long getPrevNodeId() {
		return prevNodeId;
	}

	public void setPrevNodeId(Long prevNodeId) {
		this.prevNodeId = prevNodeId;
	}
                		
	public Long getNextNodeId() {
		return nextNodeId;
	}

	public void setNextNodeId(Long nextNodeId) {
		this.nextNodeId = nextNodeId;
	}
                		
	public Long getLineTypeDictId() {
		return lineTypeDictId;
	}

	public void setLineTypeDictId(Long lineTypeDictId) {
		this.lineTypeDictId = lineTypeDictId;
	}
                		
	public Integer getPrevNodeCoordinateX() {
		return prevNodeCoordinateX;
	}

	public void setPrevNodeCoordinateX(Integer prevNodeCoordinateX) {
		this.prevNodeCoordinateX = prevNodeCoordinateX;
	}
                		
	public Integer getPrevNodeCoordinateY() {
		return prevNodeCoordinateY;
	}

	public void setPrevNodeCoordinateY(Integer prevNodeCoordinateY) {
		this.prevNodeCoordinateY = prevNodeCoordinateY;
	}
                		
	public Integer getNextNodeCoordinateX() {
		return nextNodeCoordinateX;
	}

	public void setNextNodeCoordinateX(Integer nextNodeCoordinateX) {
		this.nextNodeCoordinateX = nextNodeCoordinateX;
	}
                		
	public Integer getNextNodeCoordinateY() {
		return nextNodeCoordinateY;
	}

	public void setNextNodeCoordinateY(Integer nextNodeCoordinateY) {
		this.nextNodeCoordinateY = nextNodeCoordinateY;
	}
}
