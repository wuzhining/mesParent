package com.techsoft.entity.product;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ConfigLabel;
import com.techsoft.entity.common.ProductLabel;
import com.techsoft.entity.common.ProductMain;

public class ProductLabelVo extends ProductLabel {
	private static final long serialVersionUID = 5949278662962233163L;
	private ProductMain productMain;//物品主类
	private ConfigLabel configLabel;//标签文档
	private ConfigDictionary  barcodeRuleDict;//条码规则类型名称数据字典
	public ProductLabelVo() {	
	}
	
	public ProductLabelVo(ProductLabel value) {
		value.cloneProperties(this);
	}

	public ProductMain getProductMain() {
		return productMain;
	}

	public void setProductMain(ProductMain productMain) {
		this.productMain = productMain;
	}

	public ConfigLabel getConfigLabel() {
		return configLabel;
	}

	public void setConfigLabel(ConfigLabel configLabel) {
		this.configLabel = configLabel;
	}

	public ConfigDictionary getBarcodeRuleDict() {
		return barcodeRuleDict;
	}

	public void setBarcodeRuleDict(ConfigDictionary barcodeRuleDict) {
		this.barcodeRuleDict = barcodeRuleDict;
	}		
}
