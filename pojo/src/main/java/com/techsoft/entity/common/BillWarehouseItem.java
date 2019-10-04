package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class BillWarehouseItem extends BaseEntity {
	private static final long serialVersionUID = 3150364414339351037L;


	public BillWarehouseItem(){	
	}
	
	private Long tenantId;	
	   
	private Long billId;	
	   
	private Long productId;	
	   
	private Long materialId;	
	   
	private Long billStatusDictId;	
	   
	private Double quantity;	
	   
	private Double quantityFinish;	
	   
	private Double quantityScan;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
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
                		
	public Long getBillStatusDictId() {
		return billStatusDictId;
	}

	public void setBillStatusDictId(Long billStatusDictId) {
		this.billStatusDictId = billStatusDictId;
	}
                		
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
                		
	public Double getQuantityFinish() {
		return quantityFinish;
	}

	public void setQuantityFinish(Double quantityFinish) {
		this.quantityFinish = quantityFinish;
	}
                		
	public Double getQuantityScan() {
		return quantityScan;
	}

	public void setQuantityScan(Double quantityScan) {
		this.quantityScan = quantityScan;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
