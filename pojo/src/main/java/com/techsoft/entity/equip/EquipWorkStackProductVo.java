package com.techsoft.entity.equip;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.entity.common.EquipSpecsFixtureArea;
import com.techsoft.entity.common.EquipWorkStackProduct;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductMaterialVo;

public class EquipWorkStackProductVo extends EquipWorkStackProduct {
	private static final long serialVersionUID = -5485238473379421055L;

	public EquipWorkStackProductVo() {
	}

	public EquipWorkStackProductVo(EquipWorkStackProduct value) {
		value.cloneProperties(this);
	}

	private ProductMaterial productMaterial;
	private ProductMaterial rawProductMaterial;//原材料规格
	private ProductMain rawProductMain;//原材料
	private ProductMain productMain;
	private ProductMaterialVo rawProductMaterialVo;//原材料规格值
	private ProductMaterialVo productMaterialVo;
	private EquipSpecsFixture equipSpecsFixture;
	private EquipSpecsFixtureArea equipSpecsFixtureArea;
	
	private ConfigDictionary  productType;//物品类型名称数据字典
	
	private String isBind;
	
	
	public EquipSpecsFixture getEquipSpecsFixture() {
		return equipSpecsFixture;
	}

	public void setEquipSpecsFixture(EquipSpecsFixture equipSpecsFixture) {
		this.equipSpecsFixture = equipSpecsFixture;
	}

	public EquipSpecsFixtureArea getEquipSpecsFixtureArea() {
		return equipSpecsFixtureArea;
	}

	public void setEquipSpecsFixtureArea(EquipSpecsFixtureArea equipSpecsFixtureArea) {
		this.equipSpecsFixtureArea = equipSpecsFixtureArea;
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


	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
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

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}

	public String getIsBind() {
		return isBind;
	}

	public void setIsBind(String isBind) {
		this.isBind = isBind;
	}

}
