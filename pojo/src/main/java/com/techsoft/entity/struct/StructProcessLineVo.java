package com.techsoft.entity.struct;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProcessLine;
import com.techsoft.entity.common.StructProcessNode;

public class StructProcessLineVo extends StructProcessLine {
	private static final long serialVersionUID = 1875335372202807898L;

	private StructProcess structProcess;
	private ConfigDictionary processDictionary;
	private StructFactory structFactory;
	private StructProcessNode structProcessNodeNext;
	private StructProcessNode structProcessNodePrev;
	
	
	public StructProcessNode getStructProcessNodeNext() {
		return structProcessNodeNext;
	}

	public void setStructProcessNodeNext(StructProcessNode structProcessNodeNext) {
		this.structProcessNodeNext = structProcessNodeNext;
	}

	public StructProcessNode getStructProcessNodePrev() {
		return structProcessNodePrev;
	}

	public void setStructProcessNodePrev(StructProcessNode structProcessNodePrev) {
		this.structProcessNodePrev = structProcessNodePrev;
	}

	public StructProcess getStructProcess() {
		return structProcess;
	}

	public void setStructProcess(StructProcess structProcess) {
		this.structProcess = structProcess;
	}

	public ConfigDictionary getProcessDictionary() {
		return processDictionary;
	}

	public void setProcessDictionary(ConfigDictionary processDictionary) {
		this.processDictionary = processDictionary;
	}

	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}

	public StructProcessLineVo() {	
	}
	
	public StructProcessLineVo(StructProcessLine value) {
		value.cloneProperties(this);
	}		
}
