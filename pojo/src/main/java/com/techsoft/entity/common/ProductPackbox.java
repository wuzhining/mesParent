package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class ProductPackbox extends BaseEntity {
	private static final long serialVersionUID = 7111253875312379626L;


	public ProductPackbox(){	
	}
	
	private Long tenantId;	
	   
	private String packboxName;	
	   
	private String packboxCode;	
	   
	private Long productId;	
	   
	private Long materialId;	
	   
	private String isInner;	
	   
	private Long measureTypeDictId;	
	   
	private Long mainMeasureTypeDictId;	
	   
	private Double quantityMain;	
	   
	private Double quantityPack;	
	   
	private Double quantityInner;	
	   
	private String remark;	
	   
	private String untitled;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public String getPackboxName() {
		return packboxName;
	}

	public void setPackboxName(String packboxName) {
		this.packboxName = packboxName;
	}
                		
	public String getPackboxCode() {
		return packboxCode;
	}

	public void setPackboxCode(String packboxCode) {
		this.packboxCode = packboxCode;
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
                		
	public String getIsInner() {
		return isInner;
	}

	public void setIsInner(String isInner) {
		this.isInner = isInner;
	}
                		
	public Long getMeasureTypeDictId() {
		return measureTypeDictId;
	}

	public void setMeasureTypeDictId(Long measureTypeDictId) {
		this.measureTypeDictId = measureTypeDictId;
	}
                		
	public Long getMainMeasureTypeDictId() {
		return mainMeasureTypeDictId;
	}

	public void setMainMeasureTypeDictId(Long mainMeasureTypeDictId) {
		this.mainMeasureTypeDictId = mainMeasureTypeDictId;
	}
                		
	public Double getQuantityMain() {
		return quantityMain;
	}

	public void setQuantityMain(Double quantityMain) {
		this.quantityMain = quantityMain;
	}
                		
	public Double getQuantityPack() {
		return quantityPack;
	}

	public void setQuantityPack(Double quantityPack) {
		this.quantityPack = quantityPack;
	}
                		
	public Double getQuantityInner() {
		return quantityInner;
	}

	public void setQuantityInner(Double quantityInner) {
		this.quantityInner = quantityInner;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
                		
	public String getUntitled() {
		return untitled;
	}

	public void setUntitled(String untitled) {
		this.untitled = untitled;
	}
}
