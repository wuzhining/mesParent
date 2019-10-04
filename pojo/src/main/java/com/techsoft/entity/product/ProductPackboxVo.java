package com.techsoft.entity.product;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.ProductPackbox;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.StructWarehouseLocation;
import com.techsoft.entity.common.WarehouseLocation;

public class ProductPackboxVo extends ProductPackbox {
	private static final long serialVersionUID = 3746474619671040918L;
	private WarehouseLocation warehouseLocation;//仓库货位
	private StructWarehouse structWarehouse;//仓库
	private ProductMain productMain;//物品主类
	private FirmPartner firmPartner;//供应商
	private ProductMaterial productMaterial;//实物物料
	private ProductMaterialVo productMaterialVo;//实物物料
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

	public ProductPackboxVo() {	
	}
	
	public ProductPackboxVo(ProductPackbox value) {
		value.cloneProperties(this);
	}

	public WarehouseLocation getWarehouseLocation() {
		return warehouseLocation;
	}

	public void setWarehouseLocation(WarehouseLocation warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
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

	public FirmPartner getFirmPartner() {
		return firmPartner;
	}

	public void setFirmPartner(FirmPartner firmPartner) {
		this.firmPartner = firmPartner;
	}

	public StructWarehouse getStructWarehouse() {
		return structWarehouse;
	}

	public void setStructWarehouse(StructWarehouse structWarehouse) {
		this.structWarehouse = structWarehouse;
	}

	public ProductMaterialVo getProductMaterialVo() {
		return  productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}


	
}
