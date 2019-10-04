package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class ConfigLabel extends BaseEntity {
	private static final long serialVersionUID = 5458232409047555878L;


	public ConfigLabel(){	
	}
	
	private Long tenantId;	
	   
	private String labelName;	
	   
	private Long barcodeRuleDictId;	
	   
	private Long printModeDictId;	
	   
	private String templetPath;	
	   
	private String templetContent;	
	   
	private String printerName;	
	   
	private String isValid;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
                		
	public Long getBarcodeRuleDictId() {
		return barcodeRuleDictId;
	}

	public void setBarcodeRuleDictId(Long barcodeRuleDictId) {
		this.barcodeRuleDictId = barcodeRuleDictId;
	}
                		
	public Long getPrintModeDictId() {
		return printModeDictId;
	}

	public void setPrintModeDictId(Long printModeDictId) {
		this.printModeDictId = printModeDictId;
	}
                		
	public String getTempletPath() {
		return templetPath;
	}

	public void setTempletPath(String templetPath) {
		this.templetPath = templetPath;
	}
                		
	public String getTempletContent() {
		return templetContent;
	}

	public void setTempletContent(String templetContent) {
		this.templetContent = templetContent;
	}
                		
	public String getPrinterName() {
		return printerName;
	}

	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}
                		
	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
