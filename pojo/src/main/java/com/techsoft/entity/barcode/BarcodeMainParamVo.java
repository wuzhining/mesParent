package com.techsoft.entity.barcode;

import java.util.Date;
import java.util.List;

import com.techsoft.entity.common.BarcodeMain;

public class BarcodeMainParamVo extends BarcodeMain {
	private static final long serialVersionUID = 26919509709395029L;


	public BarcodeMainParamVo (){
	}
	
	public BarcodeMainParamVo(BarcodeMain value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	private Date outstoreTimeBegin;
	private Date outstoreTimeEnd;
	private Date instoreTimeBegin;
	private Date instoreTimeEnd;
	private Date dateManufactureBegin;
	private Date dateManufactureEnd;
	private Date dateInvalidationBegin;
	private Date dateInvalidationEnd;
	private String instoreDateAsc;//入库日期排序 
	private String instoreDateDesc;//入库日期排序 
	private String productionDateAsc;//生产日期排序 
	private String productionDateDesc;//生产日期排序 
	private List<BarcodeMain> barcodeMainVoList;
	
	
	private String likeBarcode;
	
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
	

	public Date getOutstoreTimeBegin() {
		return outstoreTimeBegin;
	}

	public void setOutstoreTimeBegin(Date outstoreTimeBegin) {
		this.outstoreTimeBegin = outstoreTimeBegin;
	}

	public Date getOutstoreTimeEnd() {
		return outstoreTimeEnd;
	}

	public void setOutstoreTimeEnd(Date outstoreTimeEnd) {
		this.outstoreTimeEnd = outstoreTimeEnd;
	}

	public Date getInstoreTimeBegin() {
		return instoreTimeBegin;
	}

	public void setInstoreTimeBegin(Date instoreTimeBegin) {
		this.instoreTimeBegin = instoreTimeBegin;
	}

	public Date getInstoreTimeEnd() {
		return instoreTimeEnd;
	}

	public void setInstoreTimeEnd(Date instoreTimeEnd) {
		this.instoreTimeEnd = instoreTimeEnd;
	}

	public List<BarcodeMain> getBarcodeMainVoList() {
		return barcodeMainVoList;
	}

	public void setBarcodeMainVoList(List<BarcodeMain> barcodeMainVoList) {
		this.barcodeMainVoList = barcodeMainVoList;
	}

	public String getInstoreDateAsc() {
		return instoreDateAsc;
	}

	public void setInstoreDateAsc(String instoreDateAsc) {
		this.instoreDateAsc = instoreDateAsc;
	}

	public String getInstoreDateDesc() {
		return instoreDateDesc;
	}

	public void setInstoreDateDesc(String instoreDateDesc) {
		this.instoreDateDesc = instoreDateDesc;
	}

	public String getProductionDateAsc() {
		return productionDateAsc;
	}

	public void setProductionDateAsc(String productionDateAsc) {
		this.productionDateAsc = productionDateAsc;
	}

	public String getProductionDateDesc() {
		return productionDateDesc;
	}

	public void setProductionDateDesc(String productionDateDesc) {
		this.productionDateDesc = productionDateDesc;
	}

	public Date getDateManufactureBegin() {
		return dateManufactureBegin;
	}

	public void setDateManufactureBegin(Date dateManufactureBegin) {
		this.dateManufactureBegin = dateManufactureBegin;
	}

	public Date getDateManufactureEnd() {
		return dateManufactureEnd;
	}

	public void setDateManufactureEnd(Date dateManufactureEnd) {
		this.dateManufactureEnd = dateManufactureEnd;
	}

	public Date getDateInvalidationBegin() {
		return dateInvalidationBegin;
	}

	public void setDateInvalidationBegin(Date dateInvalidationBegin) {
		this.dateInvalidationBegin = dateInvalidationBegin;
	}

	public Date getDateInvalidationEnd() {
		return dateInvalidationEnd;
	}

	public void setDateInvalidationEnd(Date dateInvalidationEnd) {
		this.dateInvalidationEnd = dateInvalidationEnd;
	}

	public String getLikeBarcode() {
		return likeBarcode;
	}

	public void setLikeBarcode(String likeBarcode) {
		this.likeBarcode = likeBarcode;
	}

	 
	 	
}
