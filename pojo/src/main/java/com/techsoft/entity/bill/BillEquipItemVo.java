package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillEquip;
import com.techsoft.entity.common.BillEquipItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipWork;

public class BillEquipItemVo extends BillEquipItem {
	private static final long serialVersionUID = -1306515738066951218L;

	private BillEquip billEquip;//设备单据
	private EquipWork equipWork;//设备
	private ConfigDictionary dealResult;//处理结果
	
	public BillEquip getBillEquip() {
		return billEquip;
	}

	public void setBillEquip(BillEquip billEquip) {
		this.billEquip = billEquip;
	}

	public EquipWork getEquipWork() {
		return equipWork;
	}

	public void setEquipWork(EquipWork equipWork) {
		this.equipWork = equipWork;
	}

	public ConfigDictionary getDealResult() {
		return dealResult;
	}

	public void setDealResult(ConfigDictionary dealResult) {
		this.dealResult = dealResult;
	}

	public BillEquipItemVo() {	
	}
	
	public BillEquipItemVo(BillEquipItem value) {
		value.cloneProperties(this);
	}		
}
