package com.techsoft.entity.quality;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductClasses;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.QualityInspectItem;
import com.techsoft.entity.common.QualityInspectModuleRelation;

public class QualityInspectModuleRelationVo extends QualityInspectModuleRelation {
	private static final long serialVersionUID = 5999310869374400090L;
	
	private ConfigDictionary sampleLevel;//抽样检验水平
	private ConfigDictionary sampleLevelRank;//抽样检验水平
	private ConfigDictionary productType;//物品类型
	//检验模版
	private QualityInspectItem inspectItem;
	//供应商
	private FirmPartner supplier;	
	//物品
	private ProductMain productMain;
	//物品分类
	private ProductClasses productClasses;

	public QualityInspectModuleRelationVo() {	
	}
	
	public QualityInspectModuleRelationVo(QualityInspectModuleRelation value) {
		value.cloneProperties(this);
	}

	public QualityInspectItem getInspectItem() {
		return inspectItem;
	}

	public void setInspectItem(QualityInspectItem inspectItem) {
		this.inspectItem = inspectItem;
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

	public ProductClasses getProductClasses() {
		return productClasses;
	}

	public void setProductClasses(ProductClasses productClasses) {
		this.productClasses = productClasses;
	}

	public ConfigDictionary getSampleLevel() {
		return sampleLevel;
	}

	public void setSampleLevel(ConfigDictionary sampleLevel) {
		this.sampleLevel = sampleLevel;
	}

	public ConfigDictionary getSampleLevelRank() {
		return sampleLevelRank;
	}

	public void setSampleLevelRank(ConfigDictionary sampleLevelRank) {
		this.sampleLevelRank = sampleLevelRank;
	}

	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	
}
