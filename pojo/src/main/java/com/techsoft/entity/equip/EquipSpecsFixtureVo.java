package com.techsoft.entity.equip;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipClassesFixture;
import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.entity.common.FirmPartner;

public class EquipSpecsFixtureVo extends EquipSpecsFixture {
	private static final long serialVersionUID = -341287360551703465L;
	private EquipClassesFixture equipClassesFixture;//工具分类
    private ConfigDictionary configDictionaryStatus;//数据字典
    private FirmPartner firmPartner;//供应商
    
	public EquipSpecsFixtureVo() {	
	}
	
	public EquipSpecsFixtureVo(EquipSpecsFixture value) {
		value.cloneProperties(this);
	}


	public EquipClassesFixture getEquipClassesFixture() {
		return equipClassesFixture;
	}

	public void setEquipClassesFixture(EquipClassesFixture equipClassesFixture) {
		this.equipClassesFixture = equipClassesFixture;
	}

	public ConfigDictionary getConfigDictionaryStatus() {
		return configDictionaryStatus;
	}

	public void setConfigDictionaryStatus(ConfigDictionary configDictionaryStatus) {
		this.configDictionaryStatus = configDictionaryStatus;
	}

	public FirmPartner getFirmPartner() {
		return firmPartner;
	}

	public void setFirmPartner(FirmPartner firmPartner) {
		this.firmPartner = firmPartner;
	}		
	
}
