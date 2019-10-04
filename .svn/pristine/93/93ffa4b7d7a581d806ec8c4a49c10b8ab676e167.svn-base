package com.techsoft.entity.track;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.TrackMaterial;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.product.ProductMaterialVo;

public class TrackMaterialVo extends TrackMaterial {
	private static final long serialVersionUID = 9141282150343175738L;
	private ProductMain productMain;//获取物品
	private ProductMaterial productMaterial;//获取物料
	private ConfigDictionary billTypeDicList;//单据类型
	private ConfigDictionary billStatusDicList;//状态
	private UserPassport userPassportList; //操作人
	private StructFactory structFactorylist;//工厂名称
	private StructWarehouse structWarehouseList;//仓库
	private ProductMaterialVo productMaterialVo;//实物物料
	/**
	 * 单据
	 */
	private String billCode;//单据编码

	public TrackMaterialVo() {	
	}
	
	public TrackMaterialVo(TrackMaterial value) {
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

	public ConfigDictionary getBillStatusDicList() {
		return billStatusDicList;
	}

	public void setBillStatusDicList(ConfigDictionary billStatusDicList) {
		this.billStatusDicList = billStatusDicList;
	}

	public UserPassport getUserPassportList() {
		return userPassportList;
	}

	public void setUserPassportList(UserPassport userPassportList) {
		this.userPassportList = userPassportList;
	}
	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
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

	public StructWarehouse getStructWarehouseList() {
		return structWarehouseList;
	}

	public void setStructWarehouseList(StructWarehouse structWarehouseList) {
		this.structWarehouseList = structWarehouseList;
	}
	
}
