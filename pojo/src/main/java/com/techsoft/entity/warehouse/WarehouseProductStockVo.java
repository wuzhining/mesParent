package com.techsoft.entity.warehouse;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WarehouseProductStock;
import com.techsoft.entity.product.ProductMaterialVo;

public class WarehouseProductStockVo extends WarehouseProductStock {
	private static final long serialVersionUID = -4239936151134423231L;
	private ConfigDictionary  productType;//物品类型名称数据字典
	private StructFactory structFactory;//工厂
	private ProductMaterial productMaterial;//物料
	private ProductMaterialVo productMaterialVo;//实物物料
	private ProductMain productMain;//物品
	private UserPassport userPassport;//创建人
	private UserPassport modifyUser;//创建人
	
	public UserPassport getUserPassport() {
		return userPassport;
	}

	public void setUserPassport(UserPassport userPassport) {
		this.userPassport = userPassport;
	}

	public UserPassport getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(UserPassport modifyUser) {
		this.modifyUser = modifyUser;
	}

	public ProductMain getProductMain() {
		return productMain;
	}

	public void setProductMain(ProductMain productMain) {
		this.productMain = productMain;
	}

	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
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

	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	public WarehouseProductStockVo() {	
	}
	
	public WarehouseProductStockVo(WarehouseProductStock value) {
		value.cloneProperties(this);
	}		
}
