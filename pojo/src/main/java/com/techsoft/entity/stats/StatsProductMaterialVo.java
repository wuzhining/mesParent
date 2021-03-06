package com.techsoft.entity.stats;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StatsProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.product.ProductMaterialVo;

public class StatsProductMaterialVo extends StatsProductMaterial {
	private static final long serialVersionUID = -3731932948628338831L;
	private ProductMain productMain;//获取物品
	private ProductMaterial productMaterial;//获取物料
	private ConfigDictionary billTypeDicList;//单据类型
	private UserPassport userPassportList; //操作人
	private StructFactory structFactorylist;//工厂名称
	private ProductMaterialVo productMaterialVo;//实物物料

	public StatsProductMaterialVo() {	
	}
	
	public StatsProductMaterialVo(StatsProductMaterial value) {
		value.cloneProperties(this);
	}

	public ProductMain getProductMain() {
		return productMain;
	}

	public void setProductMain(ProductMain productMain) {
		this.productMain = productMain;
	}

	public ProductMaterial getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(ProductMaterial productMaterial) {
		this.productMaterial = productMaterial;
	}

	public ConfigDictionary getBillTypeDicList() {
		return billTypeDicList;
	}

	public void setBillTypeDicList(ConfigDictionary billTypeDicList) {
		this.billTypeDicList = billTypeDicList;
	}

	public UserPassport getUserPassportList() {
		return userPassportList;
	}

	public void setUserPassportList(UserPassport userPassportList) {
		this.userPassportList = userPassportList;
	}

	public StructFactory getStructFactorylist() {
		return structFactorylist;
	}

	public void setStructFactorylist(StructFactory structFactorylist) {
		this.structFactorylist = structFactorylist;
	}

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}
	
}
