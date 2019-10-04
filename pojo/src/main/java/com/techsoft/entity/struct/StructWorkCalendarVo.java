package com.techsoft.entity.struct;

import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWorkCalendar;

public class StructWorkCalendarVo extends StructWorkCalendar {
	private static final long serialVersionUID = 2369795476873217185L;
	private StructFactory structFactory;
	
	public StructWorkCalendarVo() {	
	}
	
	public StructWorkCalendarVo(StructWorkCalendar value) {
		value.cloneProperties(this);
	}

	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}		
}
