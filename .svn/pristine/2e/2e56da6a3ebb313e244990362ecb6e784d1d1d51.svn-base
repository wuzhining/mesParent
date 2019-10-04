package com.techsoft.entity.history;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.HistoryBillStatus;
import com.techsoft.entity.common.UserPassport;

public class HistoryBillStatusVo extends HistoryBillStatus {
	private static final long serialVersionUID = 7055287848345264093L;
	private ConfigDictionary billStatusDictionary;//单据状态
	private ConfigDictionary billTypeDictionary;//单据类型
	private UserPassport caretUserPassport;//创建人名称
	private UserPassport modifyUserPassport;//更新人名称
	/**
	 * 单据
	 */
	private String billCode;//单据编码
	
	public UserPassport getCaretUserPassport() {
		return caretUserPassport;
	}

	public void setCaretUserPassport(UserPassport caretUserPassport) {
		this.caretUserPassport = caretUserPassport;
	}

	public UserPassport getModifyUserPassport() {
		return modifyUserPassport;
	}

	public void setModifyUserPassport(UserPassport modifyUserPassport) {
		this.modifyUserPassport = modifyUserPassport;
	}

	public ConfigDictionary getBillStatusDictionary() {
		return billStatusDictionary;
	}

	public void setBillStatusDictionary(ConfigDictionary billStatusDictionary) {
		this.billStatusDictionary = billStatusDictionary;
	}

	public ConfigDictionary getBillTypeDictionary() {
		return billTypeDictionary;
	}

	public void setBillTypeDictionary(ConfigDictionary billTypeDictionary) {
		this.billTypeDictionary = billTypeDictionary;
	}

	public HistoryBillStatusVo() {	
	}
	
	public HistoryBillStatusVo(HistoryBillStatus value) {
		value.cloneProperties(this);
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	
}
