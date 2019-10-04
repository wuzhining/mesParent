package com.techsoft.entity.product;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductBom;
import com.techsoft.entity.common.ProductClasses;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructProcess;

public class ProductBomVo extends ProductBom {
	private static final long serialVersionUID = 5150250831513160708L;
	private ProductMain productMain;//物品主类
	private ProductMaterial productMaterial ;//物品规格
	private ProductClasses  productClasses;//物品分类名称数据字典
	private ConfigDictionary  productType;//物品类型名称数据字典
	private ConfigDictionary  bomStatusType;//物品类型名称数据字典
	private ProductMaterialVo productMaterialVo;//物品规格值 
	
	private StructProcess structProcess;//物品工艺路线
	private Long productionlineId;//产线ID
	
	public ProductBomVo() {	
	}
	
	public ProductBomVo(ProductBom value) {
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

	 

	public ProductClasses getProductClasses() {
		return productClasses;
	}

	public void setProductClasses(ProductClasses productClasses) {
		this.productClasses = productClasses;
	}

	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	public ConfigDictionary getBomStatusType() {
		return bomStatusType;
	}

	public void setBomStatusType(ConfigDictionary bomStatusType) {
		this.bomStatusType = bomStatusType;
	}

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}

	public StructProcess getStructProcess() {
		return structProcess;
	}

	public void setStructProcess(StructProcess structProcess) {
		this.structProcess = structProcess;
	}

	public Long getProductionlineId() {
		return productionlineId;
	}

	public void setProductionlineId(Long productionlineId) {
		this.productionlineId = productionlineId;
	}

 
 	
}
