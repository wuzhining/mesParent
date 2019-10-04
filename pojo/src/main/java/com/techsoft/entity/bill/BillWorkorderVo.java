package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductBom;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.product.ProductMaterialVo;

public class BillWorkorderVo extends BillWorkorder {
	private static final long serialVersionUID = -4958138026745149994L;
	
	private ConfigDictionary customerDictionary;//客户id
	private StructProductionline structProductionline;//产线
	private StructProcess structProcess;//工艺流程
	private StructWorkshop structWorkshop;//车间
	private ProductMain productMain; //物品
	private ProductMaterial productMaterial ;//物品规格
	private ConfigDictionary processDictDictionary;//制程
	private ConfigDictionary workorderStatusDictionary;//工单状态
	private ProductMaterialVo productMaterialVo;//物品规格值
	private ConfigDictionary workAuditStatusDictionary;//工单审核状态
	private ConfigDictionary auditStatusDict;//单据审核状态
	private ConfigDictionary productType;//物品类型
	private ProductBom productBom;//产品BOM
	private UserPassport userPassport;//用户
	private UserPassport modifyUser;//修改者
	private StructFactory structFactory;//工厂
	

	public ConfigDictionary getWorkAuditStatusDictionary() {
		return workAuditStatusDictionary;
	}

	public void setWorkAuditStatusDictionary(ConfigDictionary workAuditStatusDictionary) {
		this.workAuditStatusDictionary = workAuditStatusDictionary;
	}

	public BillWorkorderVo() {	
	}
	
	public BillWorkorderVo(BillWorkorder value) {
		value.cloneProperties(this);
	}

	public ConfigDictionary getCustomerDictionary() {
		return customerDictionary;
	}

	public void setCustomerDictionary(ConfigDictionary customerDictionary) {
		this.customerDictionary = customerDictionary;
	}

	public StructProductionline getStructProductionline() {
		return structProductionline;
	}

	public void setStructProductionline(StructProductionline structProductionline) {
		this.structProductionline = structProductionline;
	}


	public ProductMain getProductMain() {
		return productMain;
	}

	public void setProductMain(ProductMain productMain) {
		this.productMain = productMain;
	}

	public ConfigDictionary getProcessDictDictionary() {
		return processDictDictionary;
	}

	public void setProcessDictDictionary(ConfigDictionary processDictDictionary) {
		this.processDictDictionary = processDictDictionary;
	}

	public ConfigDictionary getWorkorderStatusDictionary() {
		return workorderStatusDictionary;
	}

	public void setWorkorderStatusDictionary(ConfigDictionary workorderStatusDictionary) {
		this.workorderStatusDictionary = workorderStatusDictionary;
	}

	public StructProcess getStructProcess() {
		return structProcess;
	}

	public void setStructProcess(StructProcess structProcess) {
		this.structProcess = structProcess;
	}

	public StructWorkshop getStructWorkshop() {
		return structWorkshop;
	}

	public void setStructWorkshop(StructWorkshop structWorkshop) {
		this.structWorkshop = structWorkshop;
	}

	public ProductMaterial getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(ProductMaterial productMaterial) {
		this.productMaterial = productMaterial;
	}

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}

	public ConfigDictionary getAuditStatusDict() {
		return auditStatusDict;
	}

	public void setAuditStatusDict(ConfigDictionary auditStatusDict) {
		this.auditStatusDict = auditStatusDict;
	}

	public ProductBom getProductBom() {
		return productBom;
	}

	public void setProductBom(ProductBom productBom) {
		this.productBom = productBom;
	}

	public UserPassport getUserPassport() {
		return userPassport;
	}

	public void setUserPassport(UserPassport userPassport) {
		this.userPassport = userPassport;
	}

	public StructFactory getStructFactory() {
		return structFactory;
	}

	public void setStructFactory(StructFactory structFactory) {
		this.structFactory = structFactory;
	}

	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	public UserPassport getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(UserPassport modifyUser) {
		this.modifyUser = modifyUser;
	}
	
	 
}
