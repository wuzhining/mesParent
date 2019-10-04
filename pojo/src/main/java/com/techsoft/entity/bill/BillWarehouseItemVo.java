package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductMaterialVo;

public class BillWarehouseItemVo extends BillWarehouseItem {
	private static final long serialVersionUID = -3878022585611228262L;
	
	private ConfigDictionary billStatus;
	private ProductMaterial productMaterial;
	private ProductMaterialVo productMaterialVo;//实物物料
	private ProductMain  productMain;
	private ConfigDictionary productType;//物品类型
	private BillWarehouse warehouse;//到货单编码
	
	public BillWarehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(BillWarehouse warehouse) {
		this.warehouse = warehouse;
	}

	public BillWarehouseItemVo() {	
	}
	
	public ConfigDictionary getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(ConfigDictionary billStatus) {
		this.billStatus = billStatus;
	}
	
	public BillWarehouseItemVo(BillWarehouseItem value) {
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
