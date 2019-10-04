package com.techsoft.entity.firm;

import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.FirmPost;

public class FirmPostVo extends FirmPost {
	private static final long serialVersionUID = 5318512528856510641L;

	private FirmDepartment firmDepartment;
	private FirmPost firmPost;
	
	public FirmPostVo() {	
	}
	
	public FirmPostVo(FirmPost value) {
		value.cloneProperties(this);
	}

	public FirmDepartment getFirmDepartment() {
		return firmDepartment;
	}

	public void setFirmDepartment(FirmDepartment firmDepartment) {
		this.firmDepartment = firmDepartment;
	}

	public FirmPost getFirmPost() {
		return firmPost;
	}

	public void setFirmPost(FirmPost firmPost) {
		this.firmPost = firmPost;
	}
	
}
