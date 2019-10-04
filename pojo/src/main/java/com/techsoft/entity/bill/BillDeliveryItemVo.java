package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillDeliveryItem;
import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductMaterialVo;

public class BillDeliveryItemVo extends BillDeliveryItem {
	private static final long serialVersionUID = -9029479158920599739L;
	
	private ConfigDictionary billStatus;
	private ProductMaterial productMaterial;
	private BillWarehouse billWarehouse;
	private BillPurchase billPurchase;
	private ProductMain  productMain;
	private ProductMaterialVo productMaterialVo;//实物物料
	private ConfigDictionary productType;//物品类型
	private Double sumqty;

	public BillDeliveryItemVo() {	
	}
	
	public BillDeliveryItemVo(BillDeliveryItem value) {
		value.cloneProperties(this);
	}

	public ConfigDictionary getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(ConfigDictionary billStatus) {
		this.billStatus = billStatus;
	}

	public ProductMaterial getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(ProductMaterial productMaterial) {
		this.productMaterial = productMaterial;
	}

	public BillWarehouse getBillWarehouse() {
		return billWarehouse;
	}

	public void setBillWarehouse(BillWarehouse billWarehouse) {
		this.billWarehouse = billWarehouse;
	}

	public BillPurchase getBillPurchase() {
		return billPurchase;
	}

	public void setBillPurchase(BillPurchase billPurchase) {
		this.billPurchase = billPurchase;
	}

	public ProductMain getProductMain() {
		return productMain;
	}

	public void setProductMain(ProductMain productMain) {
		this.productMain = productMain;
	}

	public Double getSumqty() {
		return sumqty;
	}

	public void setSumqty(Double sumqty) {
		this.sumqty = sumqty;
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
}
