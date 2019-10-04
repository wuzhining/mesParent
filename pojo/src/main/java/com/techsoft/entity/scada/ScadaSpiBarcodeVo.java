package com.techsoft.entity.scada;

import com.techsoft.entity.common.ScadaSpiBarcode;

public class ScadaSpiBarcodeVo extends ScadaSpiBarcode {
	private static final long serialVersionUID = 3030869260916610793L;

	public ScadaSpiBarcodeVo() {	
	}
	
	public ScadaSpiBarcodeVo(ScadaSpiBarcode value) {
		value.cloneProperties(this);
	}		
}
