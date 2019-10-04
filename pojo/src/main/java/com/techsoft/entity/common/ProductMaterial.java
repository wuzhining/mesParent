package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class ProductMaterial extends BaseEntity {
	private static final long serialVersionUID = -2636880379279752037L;


	public ProductMaterial(){	
	}
	
	private Long tenantId;	
	   
	private String materialCode;	
	   
	private String materialName;	
	   
	private String skuValue;	
	   
	private Long productId;	
	   
	private Long supplierId;	
	   
	private Long productTypeDictId;	
	   
	private Long materialStatusDictId;	
	   
	private Long semiProductTypeDictId;	
	   
	private Long stockUnitDictId;	
	   
	private Long workUnitDictId;	
	   
	private Double ratioUnit;	
	   
	private Double volume;	
	   
	private Double weight;	
	   
	private Double sizeLength;	
	   
	private Double sizeHeight;	
	   
	private Double sizeWidth;	
	   
	private String isPeriodControl;	
	   
	private Double quantityStock;	
	   
	private Integer periodManufacture;	
	   
	private Integer periodWarehouseOut;	
	   
	private Integer failurePeriodWarn;	
	   
	private Long strategyUpshelfId;	
	   
	private Long strategyDownshelfId;	
	   
	private String isUnpackBox;	
	   
	private String isUnpackInnerbox;	
	   
	private Integer weekCode;	
	   
	private String binCode;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
                		
	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
                		
	public String getSkuValue() {
		return skuValue;
	}

	public void setSkuValue(String skuValue) {
		this.skuValue = skuValue;
	}
                		
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
                		
	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
                		
	public Long getProductTypeDictId() {
		return productTypeDictId;
	}

	public void setProductTypeDictId(Long productTypeDictId) {
		this.productTypeDictId = productTypeDictId;
	}
                		
	public Long getMaterialStatusDictId() {
		return materialStatusDictId;
	}

	public void setMaterialStatusDictId(Long materialStatusDictId) {
		this.materialStatusDictId = materialStatusDictId;
	}
                		
	public Long getSemiProductTypeDictId() {
		return semiProductTypeDictId;
	}

	public void setSemiProductTypeDictId(Long semiProductTypeDictId) {
		this.semiProductTypeDictId = semiProductTypeDictId;
	}
                		
	public Long getStockUnitDictId() {
		return stockUnitDictId;
	}

	public void setStockUnitDictId(Long stockUnitDictId) {
		this.stockUnitDictId = stockUnitDictId;
	}
                		
	public Long getWorkUnitDictId() {
		return workUnitDictId;
	}

	public void setWorkUnitDictId(Long workUnitDictId) {
		this.workUnitDictId = workUnitDictId;
	}
                		
	public Double getRatioUnit() {
		return ratioUnit;
	}

	public void setRatioUnit(Double ratioUnit) {
		this.ratioUnit = ratioUnit;
	}
                		
	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}
                		
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
                		
	public Double getSizeLength() {
		return sizeLength;
	}

	public void setSizeLength(Double sizeLength) {
		this.sizeLength = sizeLength;
	}
                		
	public Double getSizeHeight() {
		return sizeHeight;
	}

	public void setSizeHeight(Double sizeHeight) {
		this.sizeHeight = sizeHeight;
	}
                		
	public Double getSizeWidth() {
		return sizeWidth;
	}

	public void setSizeWidth(Double sizeWidth) {
		this.sizeWidth = sizeWidth;
	}
                		
	public String getIsPeriodControl() {
		return isPeriodControl;
	}

	public void setIsPeriodControl(String isPeriodControl) {
		this.isPeriodControl = isPeriodControl;
	}
                		
	public Double getQuantityStock() {
		return quantityStock;
	}

	public void setQuantityStock(Double quantityStock) {
		this.quantityStock = quantityStock;
	}
                		
	public Integer getPeriodManufacture() {
		return periodManufacture;
	}

	public void setPeriodManufacture(Integer periodManufacture) {
		this.periodManufacture = periodManufacture;
	}
                		
	public Integer getPeriodWarehouseOut() {
		return periodWarehouseOut;
	}

	public void setPeriodWarehouseOut(Integer periodWarehouseOut) {
		this.periodWarehouseOut = periodWarehouseOut;
	}
                		
	public Integer getFailurePeriodWarn() {
		return failurePeriodWarn;
	}

	public void setFailurePeriodWarn(Integer failurePeriodWarn) {
		this.failurePeriodWarn = failurePeriodWarn;
	}
                		
	public Long getStrategyUpshelfId() {
		return strategyUpshelfId;
	}

	public void setStrategyUpshelfId(Long strategyUpshelfId) {
		this.strategyUpshelfId = strategyUpshelfId;
	}
                		
	public Long getStrategyDownshelfId() {
		return strategyDownshelfId;
	}

	public void setStrategyDownshelfId(Long strategyDownshelfId) {
		this.strategyDownshelfId = strategyDownshelfId;
	}
                		
	public String getIsUnpackBox() {
		return isUnpackBox;
	}

	public void setIsUnpackBox(String isUnpackBox) {
		this.isUnpackBox = isUnpackBox;
	}
                		
	public String getIsUnpackInnerbox() {
		return isUnpackInnerbox;
	}

	public void setIsUnpackInnerbox(String isUnpackInnerbox) {
		this.isUnpackInnerbox = isUnpackInnerbox;
	}
                		
	public Integer getWeekCode() {
		return weekCode;
	}

	public void setWeekCode(Integer weekCode) {
		this.weekCode = weekCode;
	}
                		
	public String getBinCode() {
		return binCode;
	}

	public void setBinCode(String binCode) {
		this.binCode = binCode;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
