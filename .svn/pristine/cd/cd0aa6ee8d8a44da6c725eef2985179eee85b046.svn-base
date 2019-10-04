package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillInventory;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructWarehouse;

public class BillInventoryVo extends BillInventory {
	private static final long serialVersionUID = 7401274943361803992L;
	
	private ConfigDictionary billStatusDic;//单据状态
	private StructWarehouse  fromWarehouse;//来源仓库
	private ConfigDictionary  inventoryMode;//来源仓库
	private ConfigDictionary  auditStatus;//审核状态
	private ConfigDictionary  settleStatus;//结算状态

	public BillInventoryVo() {	
	}
	
	public BillInventoryVo(BillInventory value) {
		value.cloneProperties(this);
	}

	public ConfigDictionary getBillStatusDic() {
		return billStatusDic;
	}

	public void setBillStatusDic(ConfigDictionary billStatusDic) {
		this.billStatusDic = billStatusDic;
	}

	public StructWarehouse getFromWarehouse() {
		return fromWarehouse;
	}

	public void setFromWarehouse(StructWarehouse fromWarehouse) {
		this.fromWarehouse = fromWarehouse;
	}

	public ConfigDictionary getInventoryMode() {
		return inventoryMode;
	}

	public void setInventoryMode(ConfigDictionary inventoryMode) {
		this.inventoryMode = inventoryMode;
	}

	public ConfigDictionary getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(ConfigDictionary auditStatus) {
		this.auditStatus = auditStatus;
	}

	public ConfigDictionary getSettleStatus() {
		return settleStatus;
	}

	public void setSettleStatus(ConfigDictionary settleStatus) {
		this.settleStatus = settleStatus;
	}		
}
