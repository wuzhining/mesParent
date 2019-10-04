package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.product.ProductMaterialVo;

public class BillInspectVo extends BillInspect {
	private static final long serialVersionUID = 977118725061042019L;
	private ConfigDictionary fromBillTypeList;//源单据类型
	private ConfigDictionary inspectStatusList;//检验单状态
	private ConfigDictionary inspectResultList;//检验结果
	private ConfigDictionary dealResultList;//处理结果
	private ConfigDictionary productType;//物品类型
	private FirmPartner firmPartnerList; //获取供应商
	private ProductMain productMain;//物品
	private ProductMaterial productMaterial;//获取物料
	private BillWarehouse billWarehouse;//仓库到货到
	private ConfigDictionary inspectModeList; //从数据字典里获取抽样方式
	private ProductMaterialVo productMaterialVo;//实物物料
	private String waitingTime;//IQC来料待检时长
	private UserPassport userPassportList; //操作人
	private StructFactory structFactorylist;//工厂名称
	
	private ConfigDictionary auditStatusDict;//审核状态
	
	public ConfigDictionary getAuditStatusDict() {
		return auditStatusDict;
	}

	public void setAuditStatusDict(ConfigDictionary auditStatusDict) {
		this.auditStatusDict = auditStatusDict;
	}

	public BillInspectVo() {	
	}
	
	public BillInspectVo(BillInspect value) {
		value.cloneProperties(this);
	}

	public ConfigDictionary getFromBillTypeList() {
		return fromBillTypeList;
	}

	public void setFromBillTypeList(ConfigDictionary fromBillTypeList) {
		this.fromBillTypeList = fromBillTypeList;
	}

	public ConfigDictionary getInspectStatusList() {
		return inspectStatusList;
	}

	public void setInspectStatusList(ConfigDictionary inspectStatusList) {
		this.inspectStatusList = inspectStatusList;
	}

	public ConfigDictionary getInspectResultList() {
		return inspectResultList;
	}

	public void setInspectResultList(ConfigDictionary inspectResultList) {
		this.inspectResultList = inspectResultList;
	}

	public ConfigDictionary getDealResultList() {
		return dealResultList;
	}

	public void setDealResultList(ConfigDictionary dealResultList) {
		this.dealResultList = dealResultList;
	}

	public FirmPartner getFirmPartnerList() {
		return firmPartnerList;
	}

	public void setFirmPartnerList(FirmPartner firmPartnerList) {
		this.firmPartnerList = firmPartnerList;
	}

	public ProductMaterial getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(ProductMaterial productMaterial) {
		this.productMaterial = productMaterial;
	}

	public ConfigDictionary getInspectModeList() {
		return inspectModeList;
	}

	public void setInspectModeList(ConfigDictionary inspectModeList) {
		this.inspectModeList = inspectModeList;
	}

	public String getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(String waitingTime) {
		this.waitingTime = waitingTime;
	}

	public UserPassport getUserPassportList() {
		return userPassportList;
	}

	public void setUserPassportList(UserPassport userPassportList) {
		this.userPassportList = userPassportList;
	}

	public StructFactory getStructFactorylist() {
		return structFactorylist;
	}

	public void setStructFactorylist(StructFactory structFactorylist) {
		this.structFactorylist = structFactorylist;
	}

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}

	public BillWarehouse getBillWarehouse() {
		return billWarehouse;
	}

	public void setBillWarehouse(BillWarehouse billWarehouse) {
		this.billWarehouse = billWarehouse;
	}

	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	public ProductMain getProductMain() {
		return productMain;
	}

	public void setProductMain(ProductMain productMain) {
		this.productMain = productMain;
	}



	
}
