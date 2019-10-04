package com.techsoft.entity.scada;

import com.techsoft.entity.common.ScadaSpi;

public class ScadaSpiVo extends ScadaSpi {
	private static final long serialVersionUID = -1260479718796146428L;

	public ScadaSpiVo() {	
	}
	
	public ScadaSpiVo(ScadaSpi value) {
		value.cloneProperties(this);
	}		
}
