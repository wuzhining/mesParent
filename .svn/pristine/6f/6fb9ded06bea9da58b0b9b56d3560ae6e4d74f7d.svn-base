package com.techsoft.entity.history;

import com.techsoft.entity.common.BillFixture;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.HistoryBillFixtureStatus;
import com.techsoft.entity.common.UserPassport;

public class HistoryBillFixtureStatusVo extends HistoryBillFixtureStatus {
	private static final long serialVersionUID = 1258047585336628358L;
	private ConfigDictionary billTypeFixture;//工具单据类型
	private ConfigDictionary billStatusFixture;//工具单据状态
	private UserPassport caretUserPassport;//创建人名称
	private UserPassport modifyUserPassport;//更新人名称
	private BillFixture billFixture;//单据工具

	public HistoryBillFixtureStatusVo() {	
	}
	
	public HistoryBillFixtureStatusVo(HistoryBillFixtureStatus value) {
		value.cloneProperties(this);
	}

	public ConfigDictionary getBillTypeFixture() {
		return billTypeFixture;
	}

	public void setBillTypeFixture(ConfigDictionary billTypeFixture) {
		this.billTypeFixture = billTypeFixture;
	}

	public ConfigDictionary getBillStatusFixture() {
		return billStatusFixture;
	}

	public void setBillStatusFixture(ConfigDictionary billStatusFixture) {
		this.billStatusFixture = billStatusFixture;
	}

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

	public BillFixture getBillFixture() {
		return billFixture;
	}

	public void setBillFixture(BillFixture billFixture) {
		this.billFixture = billFixture;
	}
	
}
