package com.techsoft.entity.struct;

import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProcessProduct;

public class StructProcessProductVo extends StructProcessProduct {
	private static final long serialVersionUID = 8076885930096031536L;
	
	private ProductMain productMain;
	private ProductMaterial productMaterial;
	private StructFactory structFactory;
	private StructProcess structProcess;

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

	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}

	public StructProcess getStructProcess() {
		return structProcess;
	}

	public void setStructProcess(StructProcess structProcess) {
		this.structProcess = structProcess;
	}

	public StructProcessProductVo() {	
	}
	
	public StructProcessProductVo(StructProcessProduct value) {
		value.cloneProperties(this);
	}		
}
