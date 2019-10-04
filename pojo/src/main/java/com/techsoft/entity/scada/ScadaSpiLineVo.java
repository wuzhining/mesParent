package com.techsoft.entity.scada;

import com.techsoft.entity.common.ScadaSpiLine;

public class ScadaSpiLineVo extends ScadaSpiLine {
	private static final long serialVersionUID = 4682167783349339237L;

	public ScadaSpiLineVo() {	
	}
	
	public ScadaSpiLineVo(ScadaSpiLine value) {
		value.cloneProperties(this);
	}		
}
