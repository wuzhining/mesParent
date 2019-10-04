package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class EquipWorkStackProduct extends BaseEntity {
	private static final long serialVersionUID = -9151898501730412525L;


	public EquipWorkStackProduct(){	
	}
	
	private Long tenantId;	
	   
	private Long equipWorkId;	
	   
	private Long equipWorkStackId;	
	   
	private Long productId;	
	   
	private Long materialId;	
	   
	private Long rawProductId;	
	   
	private Long rawMaterialId;	
	   
	private Long specsFixtureId;	
	   
	private Long specsFixtureAreaId;	
	   
	private Double quantity;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getEquipWorkId() {
		return equipWorkId;
	}

	public void setEquipWorkId(Long equipWorkId) {
		this.equipWorkId = equipWorkId;
	}
                		
	public Long getEquipWorkStackId() {
		return equipWorkStackId;
	}

	public void setEquipWorkStackId(Long equipWorkStackId) {
		this.equipWorkStackId = equipWorkStackId;
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
                		
	public Long getRawProductId() {
		return rawProductId;
	}

	public void setRawProductId(Long rawProductId) {
		this.rawProductId = rawProductId;
	}
                		
	public Long getRawMaterialId() {
		return rawMaterialId;
	}

	public void setRawMaterialId(Long rawMaterialId) {
		this.rawMaterialId = rawMaterialId;
	}
                		
	public Long getSpecsFixtureId() {
		return specsFixtureId;
	}

	public void setSpecsFixtureId(Long specsFixtureId) {
		this.specsFixtureId = specsFixtureId;
	}
                		
	public Long getSpecsFixtureAreaId() {
		return specsFixtureAreaId;
	}

	public void setSpecsFixtureAreaId(Long specsFixtureAreaId) {
		this.specsFixtureAreaId = specsFixtureAreaId;
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
