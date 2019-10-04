package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class QualityInspectModuleRelation extends BaseEntity {
	private static final long serialVersionUID = -7301717234188264875L;


	public QualityInspectModuleRelation(){	
	}
	
	private Long tenantId;	
	   
	private Long inspectItemId;	
	   
	private Long sampleLevelDictId;	
	   
	private Long sampleLevelRankDictId;	
	   
	private Long supplierId;	
	   
	private Long productId;	
	   
	private Long productClassesId;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getInspectItemId() {
		return inspectItemId;
	}

	public void setInspectItemId(Long inspectItemId) {
		this.inspectItemId = inspectItemId;
	}
                		
	public Long getSampleLevelDictId() {
		return sampleLevelDictId;
	}

	public void setSampleLevelDictId(Long sampleLevelDictId) {
		this.sampleLevelDictId = sampleLevelDictId;
	}
                		
	public Long getSampleLevelRankDictId() {
		return sampleLevelRankDictId;
	}

	public void setSampleLevelRankDictId(Long sampleLevelRankDictId) {
		this.sampleLevelRankDictId = sampleLevelRankDictId;
	}
                		
	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
                		
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
                		
	public Long getProductClassesId() {
		return productClassesId;
	}

	public void setProductClassesId(Long productClassesId) {
		this.productClassesId = productClassesId;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
