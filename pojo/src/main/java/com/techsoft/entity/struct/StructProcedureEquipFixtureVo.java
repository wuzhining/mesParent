package com.techsoft.entity.struct;

import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.entity.common.StructProcedureEquipFixture;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcessNode;

public class StructProcedureEquipFixtureVo extends StructProcedureEquipFixture {
	private static final long serialVersionUID = 3857526070325084942L;
	
	private StructProcessNode structProcessNode;
	private StructProcedureInstruct structProcedureInstruct;
	private EquipSpecsFixture equipSpecsFixture;
	

	public EquipSpecsFixture getEquipSpecsFixture() {
		return equipSpecsFixture;
	}

	public void setEquipSpecsFixture(EquipSpecsFixture equipSpecsFixture) {
		this.equipSpecsFixture = equipSpecsFixture;
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



	public StructProcedureEquipFixtureVo() {	
	}
	
	public StructProcedureEquipFixtureVo(StructProcedureEquipFixture value) {
		value.cloneProperties(this);
	}		
}
