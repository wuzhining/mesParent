package com.techsoft.entity.struct;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipSpecsWork;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructProcedure;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProcessNode;

public class StructProcedureInstructVo extends StructProcedureInstruct {
	private static final long serialVersionUID = 6867216653481097567L;

	private StructProcessNode structProcessNode;
	private ConfigDictionary listDictionary;
	private EquipSpecsWork equipSpecsWork;
	private ProductMain productMain;
	private ProductMaterial productMaterial;
	private ConfigDictionary executive;
	private StructProcess structProcess;
	
	 

	public ConfigDictionary getExecutive() {
		return executive;
	}

	public void setExecutive(ConfigDictionary executive) {
		this.executive = executive;
	}

	public EquipSpecsWork getEquipSpecsWork() {
		return equipSpecsWork;
	}

	public void setEquipSpecsWork(EquipSpecsWork equipSpecsWork) {
		this.equipSpecsWork = equipSpecsWork;
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

	public ConfigDictionary getListDictionary() {
		return listDictionary;
	}

	public void setListDictionary(ConfigDictionary listDictionary) {
		this.listDictionary = listDictionary;
	}

	public StructProcessNode getStructProcessNode() {
		return structProcessNode;
	}

	public void setStructProcessNode(StructProcessNode structProcessNode) {
		this.structProcessNode = structProcessNode;
	}

	public StructProcedureInstructVo() {	
	}
	
	public StructProcedureInstructVo(StructProcedureInstruct value) {
		value.cloneProperties(this);
	}

	public StructProcess getStructProcess() {
		return structProcess;
	}

	public void setStructProcess(StructProcess structProcess) {
		this.structProcess = structProcess;
	}

}
