package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillSaleorder;
import com.techsoft.entity.common.BillSaleorderItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductMaterialVo;

public class BillSaleorderItemVo extends BillSaleorderItem {
	private static final long serialVersionUID = 2472689097458394002L;
	private ProductMaterial productMaterial;
	private ProductMain productMain;
	private BillSaleorder billSaleorder;
	private ConfigDictionary configDictionary;
	private ProductMaterialVo productMaterialVo;//实物物料
	private String customerName;//客户名称
	private BillSaleorder Saleorder;//销售单编码
	private ProductMaterial materialCode;//物品规格编码
	private ConfigDictionary  productType;//物品类型名称数据字典
	
	
	public BillSaleorder getSaleorder() {
		return Saleorder;
	}

	public void setSaleorder(BillSaleorder saleorder) {
		Saleorder = saleorder;
	}

	public ProductMaterial getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(ProductMaterial materialCode) {
		this.materialCode = materialCode;
	}

	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	public BillSaleorderItemVo() {	
	}
	
	public BillSaleorderItemVo(BillSaleorderItem value) {
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

	public BillSaleorder getBillSaleorder() {
		return billSaleorder;
	}

	public void setBillSaleorder(BillSaleorder billSaleorder) {
		this.billSaleorder = billSaleorder;
	}

	public ConfigDictionary getConfigDictionary() {
		return configDictionary;
	}

	public void setConfigDictionary(ConfigDictionary configDictionary) {
		this.configDictionary = configDictionary;
	}

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}	
	
}
