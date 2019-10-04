package com.techsoft.entity.equip;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipFixtureStackProduct;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductMaterialVo;

public class EquipFixtureStackProductVo extends EquipFixtureStackProduct {
	private static final long serialVersionUID = 346791157547817748L;

	private ProductMaterial productMaterial;//物品规格
	private ProductMaterial rawProductMaterial;//原材料规格
	private ProductMain rawProductMain;//原材料
	private ProductMain productMain;//物品
	private ProductMaterialVo productMaterialVo;//物品规格值
	private ProductMaterialVo rawProductMaterialVo;//原材料规格值
	private ConfigDictionary  productType;//物品类型

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

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}

	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}
	
	public EquipFixtureStackProductVo() {	
	}
	
	public EquipFixtureStackProductVo(EquipFixtureStackProduct value) {
		value.cloneProperties(this);
	}

	public ProductMaterial getRawProductMaterial() {
		return rawProductMaterial;
	}

	public void setRawProductMaterial(ProductMaterial rawProductMaterial) {
		this.rawProductMaterial = rawProductMaterial;
	}

	public ProductMain getRawProductMain() {
		return rawProductMain;
	}

	public void setRawProductMain(ProductMain rawProductMain) {
		this.rawProductMain = rawProductMain;
	}

	public ProductMaterialVo getRawProductMaterialVo() {
		return rawProductMaterialVo;
	}

	public void setRawProductMaterialVo(ProductMaterialVo rawProductMaterialVo) {
		this.rawProductMaterialVo = rawProductMaterialVo;
	}
}
