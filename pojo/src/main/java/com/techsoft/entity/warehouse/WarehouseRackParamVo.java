package com.techsoft.entity.warehouse;

import java.util.Date;
import java.util.List;

import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehouseRack;

public class WarehouseRackParamVo extends WarehouseRack {
	private static final long serialVersionUID = 4221343273255674258L;

	public WarehouseRackParamVo() {
	}

	public WarehouseRackParamVo(WarehouseRack value) {
		value.cloneProperties(this);
	}
	   
	private Long locationTypeDictId;	
	   	
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
	
	private String likeRackCode;
	private String likeRackName;

	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;
	private List<WarehouseLocation> listLocation;
	
	


	public Long getLocationTypeDictId() {
		return locationTypeDictId;
	}

	public void setLocationTypeDictId(Long locationTypeDictId) {
		this.locationTypeDictId = locationTypeDictId;
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

	public Date getCreateTimeBegin() {
		return createTimeBegin;
	}

	public void setCreateTimeBegin(Date createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public Date getModifyTimeBegin() {
		return modifyTimeBegin;
	}

	public void setModifyTimeBegin(Date modifyTimeBegin) {
		this.modifyTimeBegin = modifyTimeBegin;
	}

	public Date getModifyTimeEnd() {
		return modifyTimeEnd;
	}

	public void setModifyTimeEnd(Date modifyTimeEnd) {
		this.modifyTimeEnd = modifyTimeEnd;
	}

	public List<WarehouseLocation> getListLocation() {
		return listLocation;
	}

	public void setListLocation(List<WarehouseLocation> listLocation) {
		this.listLocation = listLocation;
	}

	public String getLikeRackCode() {
		return likeRackCode;
	}

	public void setLikeRackCode(String likeRackCode) {
		this.likeRackCode = likeRackCode;
	}

	public String getLikeRackName() {
		return likeRackName;
	}

	public void setLikeRackName(String likeRackName) {
		this.likeRackName = likeRackName;
	}


	
}
