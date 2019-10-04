package com.techsoft.entity.equip;

import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipClassesFixture;
import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.entity.common.FirmEmployee;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.common.WarehouseLocation;

public class EquipFixtureVo extends EquipFixture {
	private static final long serialVersionUID = -3435359616474752856L;
    private StructWarehouse structWarehouse;//仓库
    private WarehouseLocation warehouseLocation;//仓库
    private EquipSpecsFixture equipSpecsFixture;//工具品种规格
	private EquipClassesFixture equipClassesFixture;//工具分类
    private ConfigDictionary configDictionary;//数据字典
    private ConfigDictionary configDictionaryStatus;//数据字典
    private FirmPartner firmPartner;//供应商
	private FirmEmployee firmEmployee;//校验确认人-员工
    private StructWorkshop structWorkshop;//车间
    private StructWorkshopArea structWorkshopArea;//车间区域
    private StructFactory structFactory;//工厂
    private StructWorkstation structWorkstation;//工站
    
    public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}

	public StructWorkstation getStructWorkstation() {
		return structWorkstation;
	}

	public void setStructWorkstation(StructWorkstation structWorkstation) {
		this.structWorkstation = structWorkstation;
	}
	public StructWorkshop getStructWorkshop() {
		return structWorkshop;
	}

	public void setStructWorkshop(StructWorkshop structWorkshop) {
		this.structWorkshop = structWorkshop;
	}

	public StructWorkshopArea getStructWorkshopArea() {
		return structWorkshopArea;
	}

	public void setStructWorkshopArea(StructWorkshopArea structWorkshopArea) {
		this.structWorkshopArea = structWorkshopArea;
	}

	public EquipFixtureVo() {	
	}
	
	public EquipFixtureVo(EquipFixture value) {
		value.cloneProperties(this);
	}

	public ConfigDictionary getConfigDictionaryStatus() {
		return configDictionaryStatus;
	}

	public void setConfigDictionaryStatus(ConfigDictionary configDictionaryStatus) {
		this.configDictionaryStatus = configDictionaryStatus;
	}

	public WarehouseLocation getWarehouseLocation() {
		return warehouseLocation;
	}

	public void setWarehouseLocation(WarehouseLocation warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	public StructWarehouse getStructWarehouse() {
		return structWarehouse;
	}

	public void setStructWarehouse(StructWarehouse structWarehouse) {
		this.structWarehouse = structWarehouse;
	}

	public ConfigDictionary getConfigDictionary() {
		return configDictionary;
	}

	public void setConfigDictionary(ConfigDictionary configDictionary) {
		this.configDictionary = configDictionary;
	}

	public FirmPartner getFirmPartner() {
		return firmPartner;
	}

	public void setFirmPartner(FirmPartner firmPartner) {
		this.firmPartner = firmPartner;
	}

	public FirmEmployee getFirmEmployee() {
		return firmEmployee;
	}

	public void setFirmEmployee(FirmEmployee firmEmployee) {
		this.firmEmployee = firmEmployee;
	}

	public EquipSpecsFixture getEquipSpecsFixture() {
		return equipSpecsFixture;
	}

	public void setEquipSpecsFixture(EquipSpecsFixture equipSpecsFixture) {
		this.equipSpecsFixture = equipSpecsFixture;
	}

	public EquipClassesFixture getEquipClassesFixture() {
		return equipClassesFixture;
	}

	public void setEquipClassesFixture(EquipClassesFixture equipClassesFixture) {
		this.equipClassesFixture = equipClassesFixture;
	}
	
}
