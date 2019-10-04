package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;

public class BillDeliveryVo extends BillDelivery {
	private static final long serialVersionUID = -3661486342023876160L;
	
	private ConfigDictionary typeStockDic;//出入库单类型
	private ConfigDictionary billTypeDic;//单据类型
	private ConfigDictionary billStatusDic;//单据状态
	private ConfigDictionary fromBillTypeDic;//来源单据类型
	private FirmPartner fromFirmPartner;//客户 合作伙伴
	private FirmPartner toFirmPartner;//客户 合作伙伴
	private ConfigDictionary auditStatus;//审核状态

	public BillDeliveryVo() {	
	}
	
	public BillDeliveryVo(BillDelivery value) {
		value.cloneProperties(this);
	}

	public ConfigDictionary getTypeStockDic() {
		return typeStockDic;
	}

	public void setTypeStockDic(ConfigDictionary typeStockDic) {
		this.typeStockDic = typeStockDic;
	}

	public ConfigDictionary getBillTypeDic() {
		return billTypeDic;
	}

	public void setBillTypeDic(ConfigDictionary billTypeDic) {
		this.billTypeDic = billTypeDic;
	}

	public ConfigDictionary getBillStatusDic() {
		return billStatusDic;
	}

	public void setBillStatusDic(ConfigDictionary billStatusDic) {
		this.billStatusDic = billStatusDic;
	}

	public ConfigDictionary getFromBillTypeDic() {
		return fromBillTypeDic;
	}

	public void setFromBillTypeDic(ConfigDictionary fromBillTypeDic) {
		this.fromBillTypeDic = fromBillTypeDic;
	}

	public FirmPartner getFromFirmPartner() {
		return fromFirmPartner;
	}

	public void setFromFirmPartner(FirmPartner fromFirmPartner) {
		this.fromFirmPartner = fromFirmPartner;
	}

	public FirmPartner getToFirmPartner() {
		return toFirmPartner;
	}

	public void setToFirmPartner(FirmPartner toFirmPartner) {
		this.toFirmPartner = toFirmPartner;
	}

	public ConfigDictionary getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(ConfigDictionary auditStatus) {
		this.auditStatus = auditStatus;
	}		
}
