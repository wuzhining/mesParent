package com.techsoft.entity.struct;

import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcedureMaterial;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.product.ProductMaterialVo;

public class StructProcedureMaterialVo extends StructProcedureMaterial {
	private static final long serialVersionUID = 7077313667883704074L;

	private StructProcessNode structProcessNode;//工序
	private StructProcedureInstruct structProcedureInstruct;//工序指令
	private ProductMain productMain;//物品主类
	private ProductMaterial productMaterial;//物品规格
	private ProductMaterialVo productMaterialVo;//物品规格值
	
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

	public StructProcessNode getStructProcessNode() {
		return structProcessNode;
	}

	public void setStructProcessNode(StructProcessNode structProcessNode) {
		this.structProcessNode = structProcessNode;
	}

	public StructProcedureInstruct getStructProcedureInstruct() {
		return structProcedureInstruct;
	}

	public void setStructProcedureInstruct(StructProcedureInstruct structProcedureInstruct) {
		this.structProcedureInstruct = structProcedureInstruct;
	}

	public StructProcedureMaterialVo() {	
	}
	
	public StructProcedureMaterialVo(StructProcedureMaterial value) {
		value.cloneProperties(this);
	}

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}		
}
