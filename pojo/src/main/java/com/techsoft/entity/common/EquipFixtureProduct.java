package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class EquipFixtureProduct extends BaseEntity {
	private static final long serialVersionUID = -1439436412091336444L;


	public EquipFixtureProduct(){	
	}
	
	private Long tenantId;	
	   
	private Long specsFixtureId;	
	   
	private Long productId;	
	   
	private Long materialId;	
	   
	private Double quantity;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getSpecsFixtureId() {
		return specsFixtureId;
	}

	public void setSpecsFixtureId(Long specsFixtureId) {
		this.specsFixtureId = specsFixtureId;
	}
                		
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
                		
	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}
                		
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
