package com.techsoft.entity.work;

import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.common.ProductBom;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WorkPlanEquip;
import com.techsoft.entity.common.WorkPlanWorkstation;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.entity.product.ProductMaterialVo;

public class WorkTaskProcedureVo extends WorkTaskProcedure {
	private static final long serialVersionUID = -880453199314542426L;
	private StructProcessNode structProcessNode;
	private StructFactory factory;
	private BillWorkorder billWorkorder;
	private StructWorkshop	workshop;
	private ConfigDictionary taskStatusDic;
	private ProductBom productBom;
	private StructProductionline productionline;
	private ProductMain productMain;
	private ProductMaterial productMaterial;
	private ConfigDictionary executive;//执行方
	private ConfigDictionary productType;//物品类型
	private ProductMaterialVo productMaterialVo;//物品规格值
	private UserPassport userPassport;//创建者
	private UserPassport modifyUser;//修改者
	private StructProcess structProcess;//工艺路线
	private WorkPlanWorkstation workPlanWorkstation;
	private StructWorkstation structWorkstation; 
	private WorkPlanEquip workPlanEquip;
	private EquipWork equipWork; 
	
	
	
	public StructProcess getStructProcess() {
		return structProcess;
	}

	public void setStructProcess(StructProcess structProcess) {
		this.structProcess = structProcess;
	}

	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
	}

	public WorkTaskProcedureVo() {
	}

	public WorkTaskProcedureVo(WorkTaskProcedure value) {
		value.cloneProperties(this);
	}

	public ProductMain getProductMain() {
		return productMain;
	}

	public void setProductMain(ProductMain productMain) {
		this.productMain = productMain;
	}

	public ProductMaterial getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(ProductMaterial productMaterial) {
		this.productMaterial = productMaterial;
	}

	public StructProcessNode getStructProcessNode() {
		return structProcessNode;
	}

	public void setStructProcessNode(StructProcessNode structProcessNode) {
		this.structProcessNode = structProcessNode;
	}

	public StructFactory getFactory() {
		return factory;
	}

	public void setFactory(StructFactory factory) {
		this.factory = factory;
	}

	public BillWorkorder getBillWorkorder() {
		return billWorkorder;
	}

	public void setBillWorkorder(BillWorkorder billWorkorder) {
		this.billWorkorder = billWorkorder;
	}

	public StructWorkshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(StructWorkshop workshop) {
		this.workshop = workshop;
	}

	public ConfigDictionary getTaskStatusDic() {
		return taskStatusDic;
	}

	public void setTaskStatusDic(ConfigDictionary taskStatusDic) {
		this.taskStatusDic = taskStatusDic;
	}

	public ProductBom getProductBom() {
		return productBom;
	}

	public void setProductBom(ProductBom productBom) {
		this.productBom = productBom;
	}

	public StructProductionline getProductionline() {
		return productionline;
	}

	public void setProductionline(StructProductionline productionline) {
		this.productionline = productionline;
	}

	public ConfigDictionary getExecutive() {
		return executive;
	}

	public void setExecutive(ConfigDictionary executive) {
		this.executive = executive;
	}

	public UserPassport getUserPassport() {
		return userPassport;
	}

	public void setUserPassport(UserPassport userPassport) {
		this.userPassport = userPassport;
	}

	public UserPassport getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(UserPassport modifyUser) {
		this.modifyUser = modifyUser;
	}

	public StructWorkstation getStructWorkstation() {
		return structWorkstation;
	}

	public void setStructWorkstation(StructWorkstation structWorkstation) {
		this.structWorkstation = structWorkstation;
	}

	public WorkPlanWorkstation getWorkPlanWorkstation() {
		return workPlanWorkstation;
	}

	public void setWorkPlanWorkstation(WorkPlanWorkstation workPlanWorkstation) {
		this.workPlanWorkstation = workPlanWorkstation;
	}

	public WorkPlanEquip getWorkPlanEquip() {
		return workPlanEquip;
	}

	public void setWorkPlanEquip(WorkPlanEquip workPlanEquip) {
		this.workPlanEquip = workPlanEquip;
	}

	public EquipWork getEquipWork() {
		return equipWork;
	}

	public void setEquipWork(EquipWork equipWork) {
		this.equipWork = equipWork;
	}
	
}
