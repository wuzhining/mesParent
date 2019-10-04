package com.techsoft.entity.scada;

import com.techsoft.entity.common.ScadaAoiVersion;

public class ScadaAoiVersionVo extends ScadaAoiVersion {
	private static final long serialVersionUID = -968227647701935138L;

	public ScadaAoiVersionVo() {	
	}
	
	public ScadaAoiVersionVo(ScadaAoiVersion value) {
		value.cloneProperties(this);
	}		
}
