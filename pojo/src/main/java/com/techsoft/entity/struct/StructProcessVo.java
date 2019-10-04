package com.techsoft.entity.struct;

import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcess;

public class StructProcessVo extends StructProcess {
	private static final long serialVersionUID = 3536933033624373696L;
	private StructFactory structFactory;
	
	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}

	public StructProcessVo() {	
	}
	
	public StructProcessVo(StructProcess value) {
		value.cloneProperties(this);
	}		
}
