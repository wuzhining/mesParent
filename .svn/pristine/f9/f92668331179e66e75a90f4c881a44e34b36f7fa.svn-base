package com.techsoft.entity.quality;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.QualityInspectDocument;

public class QualityInspectDocumentVo extends QualityInspectDocument {
	private static final long serialVersionUID = -6846244272206835583L;
	
	//供应商
	private FirmPartner supplier;	
	//物品
	private ProductMain productMain;
	//物品类型
	private ConfigDictionary productType;

	public QualityInspectDocumentVo() {	
	}
	
	public QualityInspectDocumentVo(QualityInspectDocument value) {
		value.cloneProperties(this);
	}

	public FirmPartner getSupplier() {
		return supplier;
	}

	public void setSupplier(FirmPartner supplier) {
		this.supplier = supplier;
	}

	public ProductMain getProductMain() {
		return productMain;
	}

	public void setProductMain(ProductMain productMain) {
		this.productMain = productMain;
	}

	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}
	
	
}
