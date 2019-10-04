package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillSaleorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;

public class BillSaleorderVo extends BillSaleorder {
	private static final long serialVersionUID = 3563008788708104809L;
	private FirmPartner firmPartner;//客户
	private ConfigDictionary billStatusDic;//单据状态
	private ConfigDictionary auditStatusDict;//单据审核状态
	public BillSaleorderVo() {	
	}
	
	public BillSaleorderVo(BillSaleorder value) {
		value.cloneProperties(this);
	}

	public FirmPartner getFirmPartner() {
		return firmPartner;
	}

	public void setFirmPartner(FirmPartner firmPartner) {
		this.firmPartner = firmPartner;
	}

	public ConfigDictionary getBillStatusDic() {
		return billStatusDic;
	}

	public void setBillStatusDic(ConfigDictionary billStatusDic) {
		this.billStatusDic = billStatusDic;
	}

	public ConfigDictionary getAuditStatusDict() {
		return auditStatusDict;
	}

	public void setAuditStatusDict(ConfigDictionary auditStatusDict) {
		this.auditStatusDict = auditStatusDict;
	}		
}
