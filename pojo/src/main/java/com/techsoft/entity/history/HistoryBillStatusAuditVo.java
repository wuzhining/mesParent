package com.techsoft.entity.history;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.HistoryBillStatusAudit;
import com.techsoft.entity.common.UserPassport;

public class HistoryBillStatusAuditVo extends HistoryBillStatusAudit {
	private static final long serialVersionUID = 640133721648504141L;
	private ConfigDictionary auditStatusictionary;//单据审核状态
	private ConfigDictionary billTypeDictionary;//单据类型
	private UserPassport caretUserPassport2;//创建人名称
	private UserPassport modifyUserPassport;//更新人名称
	/**
	 * 单据
	 */
	private String billCode;//单据编码
	
	public ConfigDictionary getAuditStatusictionary() {
		return auditStatusictionary;
	}

	public void setAuditStatusictionary(ConfigDictionary auditStatusictionary) {
		this.auditStatusictionary = auditStatusictionary;
	}

	public ConfigDictionary getBillTypeDictionary() {
		return billTypeDictionary;
	}

	public void setBillTypeDictionary(ConfigDictionary billTypeDictionary) {
		this.billTypeDictionary = billTypeDictionary;
	}

	

	public UserPassport getCaretUserPassport2() {
		return caretUserPassport2;
	}

	public void setCaretUserPassport2(UserPassport caretUserPassport2) {
		this.caretUserPassport2 = caretUserPassport2;
	}

	public UserPassport getModifyUserPassport() {
		return modifyUserPassport;
	}

	public void setModifyUserPassport(UserPassport modifyUserPassport) {
		this.modifyUserPassport = modifyUserPassport;
	}

	public HistoryBillStatusAuditVo() {	
	}
	
	public HistoryBillStatusAuditVo(HistoryBillStatusAudit value) {
		value.cloneProperties(this);
	}


	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	
}
