package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;

public class BillPurchaseVo extends BillPurchase {
	private static final long serialVersionUID = 2674430934844041929L;

	private FirmPartner firmPartnerLiat;//供应商
	private ConfigDictionary billStatusDic;//单据状态
	private ConfigDictionary auditStatusDict;//单据审核状态
	public BillPurchaseVo() {	
	}
	
	public BillPurchaseVo(BillPurchase value) {
		value.cloneProperties(this);
	}

	public FirmPartner getFirmPartnerLiat() {
		return firmPartnerLiat;
	}

	public void setFirmPartnerLiat(FirmPartner firmPartnerLiat) {
		this.firmPartnerLiat = firmPartnerLiat;
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
