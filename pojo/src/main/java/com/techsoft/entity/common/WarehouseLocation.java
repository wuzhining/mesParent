package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class WarehouseLocation extends BaseEntity {
	private static final long serialVersionUID = -1449269743756600094L;


	public WarehouseLocation(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long productTypeDictId;	
	   
	private Long locationTypeDictId;	
	   
	private Long warehouseId;	
	   
	private String locationName;	
	   
	private String locationCode;	
	   
	private Long areaId;	
	   
	private Long rackId;	
	   
	private Integer serialColumn;	
	   
	private Integer serialLine;	
	   
	private String isValid;	
	   
	private Integer coordinateX;	
	   
	private Integer coordinateY;	
	   
	private Integer coordinateZ;	
	   
	private Double limitVolume;	
	   
	private Double limitWeight;	
	   
	private Double limitQuantity;	
	   
	private Double limitQuantityBox;	
	   
	private Double limitQuantityPallet;	
	   
	private Double sizeLength;	
	   
	private Double sizeHeight;	
	   
	private Double sizeWidth;	
	   
	private String isMixProduct;	
	   
	private String isMixBatch;	
	   
	private String remark;	
	   
                		
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
                		
	public Long getProductTypeDictId() {
		return productTypeDictId;
	}

	public void setProductTypeDictId(Long productTypeDictId) {
		this.productTypeDictId = productTypeDictId;
	}
                		
	public Long getLocationTypeDictId() {
		return locationTypeDictId;
	}

	public void setLocationTypeDictId(Long locationTypeDictId) {
		this.locationTypeDictId = locationTypeDictId;
	}
                		
	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
                		
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
                		
	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
                		
	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
                		
	public Long getRackId() {
		return rackId;
	}

	public void setRackId(Long rackId) {
		this.rackId = rackId;
	}
                		
	public Integer getSerialColumn() {
		return serialColumn;
	}

	public void setSerialColumn(Integer serialColumn) {
		this.serialColumn = serialColumn;
	}
                		
	public Integer getSerialLine() {
		return serialLine;
	}

	public void setSerialLine(Integer serialLine) {
		this.serialLine = serialLine;
	}
                		
	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
                		
	public Integer getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(Integer coordinateX) {
		this.coordinateX = coordinateX;
	}
                		
	public Integer getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(Integer coordinateY) {
		this.coordinateY = coordinateY;
	}
                		
	public Integer getCoordinateZ() {
		return coordinateZ;
	}

	public void setCoordinateZ(Integer coordinateZ) {
		this.coordinateZ = coordinateZ;
	}
                		
	public Double getLimitVolume() {
		return limitVolume;
	}

	public void setLimitVolume(Double limitVolume) {
		this.limitVolume = limitVolume;
	}
                		
	public Double getLimitWeight() {
		return limitWeight;
	}

	public void setLimitWeight(Double limitWeight) {
		this.limitWeight = limitWeight;
	}
                		
	public Double getLimitQuantity() {
		return limitQuantity;
	}

	public void setLimitQuantity(Double limitQuantity) {
		this.limitQuantity = limitQuantity;
	}
                		
	public Double getLimitQuantityBox() {
		return limitQuantityBox;
	}

	public void setLimitQuantityBox(Double limitQuantityBox) {
		this.limitQuantityBox = limitQuantityBox;
	}
                		
	public Double getLimitQuantityPallet() {
		return limitQuantityPallet;
	}

	public void setLimitQuantityPallet(Double limitQuantityPallet) {
		this.limitQuantityPallet = limitQuantityPallet;
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
                		
	public String getIsMixProduct() {
		return isMixProduct;
	}

	public void setIsMixProduct(String isMixProduct) {
		this.isMixProduct = isMixProduct;
	}
                		
	public String getIsMixBatch() {
		return isMixBatch;
	}

	public void setIsMixBatch(String isMixBatch) {
		this.isMixBatch = isMixBatch;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
