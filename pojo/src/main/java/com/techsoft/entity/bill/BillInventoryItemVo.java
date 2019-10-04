package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillInventoryItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductMaterialVo;

public class BillInventoryItemVo extends BillInventoryItem {
	private static final long serialVersionUID = -2878179276051486564L;
	
	private ProductMaterial productMaterial;
	private ProductMaterialVo productMaterialVo;//实物物料
	private ProductMain productMain;
	private ConfigDictionary productType;//物品类型
	private ProductMaterial materialCode;//物品规格编码
	private ConfigDictionary configDictionary;
	
	public ProductMaterial getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(ProductMaterial materialCode) {
		this.materialCode = materialCode;
	}

	public ConfigDictionary getConfigDictionary() {
		return configDictionary;
	}

	public void setConfigDictionary(ConfigDictionary configDictionary) {
		this.configDictionary = configDictionary;
	}

	public BillInventoryItemVo() {	
	}
	
	public BillInventoryItemVo(BillInventoryItem value) {
		value.cloneProperties(this);
	}

	public ProductMaterial getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(ProductMaterial productMaterial) {
		this.productMaterial = productMaterial;
	}

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
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
