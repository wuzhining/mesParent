package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.BillPurchaseItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductMaterialVo;

public class BillPurchaseItemVo extends BillPurchaseItem {
	private static final long serialVersionUID = -1836346794626452911L;

	private ProductMaterial productMaterial;
	private ProductMain productMain;
	private BillPurchase billPurchase;
	private ConfigDictionary configDictionary;
	private Double quantityNeed;
	private ProductMaterialVo productMaterialVo;// 实物物料
	private ConfigDictionary  productType;//物品类型名称数据字典
	private ProductMaterial materialCode;//物品规格编码
	
	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	public ProductMaterial getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(ProductMaterial materialCode) {
		this.materialCode = materialCode;
	}

	public BillPurchaseItemVo() {
	}

	public BillPurchaseItemVo(BillPurchaseItem value) {
		value.cloneProperties(this);
	}

	public ProductMaterial getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(ProductMaterial productMaterial) {
		this.productMaterial = productMaterial;
	}

	public ProductMain getProductMain() {
		return productMain;
	}

	public void setProductMain(ProductMain productMain) {
		this.productMain = productMain;
	}

	public BillPurchase getBillPurchase() {
		return billPurchase;
	}

	public void setBillPurchase(BillPurchase billPurchase) {
		this.billPurchase = billPurchase;
	}

	public ConfigDictionary getConfigDictionary() {
		return configDictionary;
	}

	public void setConfigDictionary(ConfigDictionary configDictionary) {
		this.configDictionary = configDictionary;
	}

	public Double getQuantityNeed() {
		return quantityNeed;
	}

	public void setQuantityNeed(Double quantityNeed) {
		this.quantityNeed = quantityNeed;
	}

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}

}
