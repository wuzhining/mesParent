package com.techsoft.entity.bill;

import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.product.ProductMaterialVo;

public class BillWarehouseVo extends BillWarehouse {
	private static final long serialVersionUID = 8169197584341327432L;
	
	private ConfigDictionary typeStockDic;//出入库单类型
	private ConfigDictionary billTypeDic;//单据类型
	private ConfigDictionary billStatusDic;//单据状态
	private ConfigDictionary fromBillTypeDic;//来源单据类型
	private ConfigDictionary auditStatusDic;//审核状态
	private BillWorkorder	 fromBill;//来源单
	private StructWarehouse  fromWarehouse;//来源仓库
	private StructWarehouse  toWarehouse;//目标仓库
	private StructProductionline fromProductionline;//来源产线
	private StructProductionline toProductionline;//目标产线
	private FirmDepartment department;//部门
	private FirmPartner firmPartner;//客户 合作伙伴
	private ProductMaterial  productMaterial;//物料
	private ProductMain      productMain;//物品
	private BillWorkorder    billWorkorder;//工单
	private BillWarehouseItem    billWarehouseItem;//仓库明细
	private StructProductionline structProductionline;//产线
	private BillWarehouse billWarehouse;//仓库单
	private BillInspect billInpect;//检验单
	private BillPurchase billPurchase;//采购单
	private BillDelivery billDelivery;//送货单
	private ProductMaterialVo productMaterialVo;//实物物料
	
	/**
	 * 单据
	 */
	private String fromBillCode;
	
	

	public ProductMaterial getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(ProductMaterial productMaterial) {
		this.productMaterial = productMaterial;
	}

	public ProductMain getProductMain() {
		return productMain;
	}

	public void setProductMain(ProductMain productMain) {
		this.productMain = productMain;
	}

	public BillWorkorder getBillWorkorder() {
		return billWorkorder;
	}

	public void setBillWorkorder(BillWorkorder billWorkorder) {
		this.billWorkorder = billWorkorder;
	}

	public BillWarehouseItem getBillWarehouseItem() {
		return billWarehouseItem;
	}

	public void setBillWarehouseItem(BillWarehouseItem billWarehouseItem) {
		this.billWarehouseItem = billWarehouseItem;
	}

	public StructProductionline getStructProductionline() {
		return structProductionline;
	}

	public void setStructProductionline(StructProductionline structProductionline) {
		this.structProductionline = structProductionline;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BillWarehouseVo() {	
	}
	
	public BillWarehouseVo(BillWarehouse value) {
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

	public BillWorkorder getFromBill() {
		return fromBill;
	}

	public void setFromBill(BillWorkorder fromBill) {
		this.fromBill = fromBill;
	}

	public StructWarehouse getFromWarehouse() {
		return fromWarehouse;
	}

	public void setFromWarehouse(StructWarehouse fromWarehouse) {
		this.fromWarehouse = fromWarehouse;
	}

	public StructWarehouse getToWarehouse() {
		return toWarehouse;
	}

	public void setToWarehouse(StructWarehouse toWarehouse) {
		this.toWarehouse = toWarehouse;
	}

	public StructProductionline getFromProductionline() {
		return fromProductionline;
	}

	public void setFromProductionline(StructProductionline fromProductionline) {
		this.fromProductionline = fromProductionline;
	}

	public StructProductionline getToProductionline() {
		return toProductionline;
	}

	public void setToProductionline(StructProductionline toProductionline) {
		this.toProductionline = toProductionline;
	}

	public FirmDepartment getDepartment() {
		return department;
	}

	public void setDepartment(FirmDepartment department) {
		this.department = department;
	}

	public FirmPartner getFirmPartner() {
		return firmPartner;
	}

	public void setFirmPartner(FirmPartner firmPartner) {
		this.firmPartner = firmPartner;
	}

	public BillWarehouse getBillWarehouse() {
		return billWarehouse;
	}

	public void setBillWarehouse(BillWarehouse billWarehouse) {
		this.billWarehouse = billWarehouse;
	}

	public BillInspect getBillInpect() {
		return billInpect;
	}

	public void setBillInpect(BillInspect billInpect) {
		this.billInpect = billInpect;
	}

	public BillPurchase getBillPurchase() {
		return billPurchase;
	}

	public void setBillPurchase(BillPurchase billPurchase) {
		this.billPurchase = billPurchase;
	}

 

	public BillDelivery getBillDelivery() {
		return billDelivery;
	}

	public void setBillDelivery(BillDelivery billDelivery) {
		this.billDelivery = billDelivery;
	}

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}

	public String getFromBillCode() {
		return fromBillCode;
	}

	public void setFromBillCode(String fromBillCode) {
		this.fromBillCode = fromBillCode;
	}

	public ConfigDictionary getAuditStatusDic() {
		return auditStatusDic;
	}

	public void setAuditStatusDic(ConfigDictionary auditStatusDic) {
		this.auditStatusDic = auditStatusDic;
	}
	
	
}
