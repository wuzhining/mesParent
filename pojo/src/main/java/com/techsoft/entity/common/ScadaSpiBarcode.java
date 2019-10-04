package com.techsoft.entity.common;

import java.util.Date;
import com.techsoft.common.BaseEntity;

public class ScadaSpiBarcode extends BaseEntity {
	private static final long serialVersionUID = 1199433123261135749L;


	public ScadaSpiBarcode(){	
	}
	
	private Integer pcbid;	
	   
	private Integer areaid;	
	   
	private String barcode;	
	   
                		
	public Integer getPcbid() {
		return pcbid;
	}

	public void setPcbid(Integer pcbid) {
		this.pcbid = pcbid;
	}
                		
	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}
                		
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
}
