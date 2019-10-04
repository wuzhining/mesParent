package com.techsoft.entity.work;

import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductBom;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WorkPlanMaterial;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.entity.product.ProductMaterialVo;

public class WorkPlanMaterialVo extends WorkPlanMaterial {
	private static final long serialVersionUID = 6753712450505780529L;

	private ProductMaterialVo productMaterialVo;//实物物料
	private StructFactory factory;
	private BillWorkorder billWorkorder;
	private WorkTaskProcedure task;
	private StructWorkshop workshop;
	private StructProcessNode processNode;
	private ProductBom productBom;
	private ConfigDictionary planStatusDic;
	private StructProcedureInstruct structProcedureInstruct;
	private ProductMain productMain;
	private ProductMaterial productMaterial;
	private ConfigDictionary productType;//物品类型
	private UserPassport userPassport;//创建者
	private UserPassport modifyUser;//修改者
	
	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	public UserPassport getUserPassport() {
		return userPassport;
	}

	public void setUserPassport(UserPassport userPassport) {
		this.userPassport = userPassport;
	}

	public WorkPlanMaterialVo() {	
	}
	
	public WorkPlanMaterialVo(WorkPlanMaterial value) {
		value.cloneProperties(this);
	}

	public ProductMaterialVo getProductMaterialVo() {
		return productMaterialVo;
	}

	public void setProductMaterialVo(ProductMaterialVo productMaterialVo) {
		this.productMaterialVo = productMaterialVo;
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

	public WorkTaskProcedure getTask() {
		return task;
	}

	public void setTask(WorkTaskProcedure task) {
		this.task = task;
	}

	public StructWorkshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(StructWorkshop workshop) {
		this.workshop = workshop;
	}

	public StructProcessNode getProcessNode() {
		return processNode;
	}

	public void setProcessNode(StructProcessNode processNode) {
		this.processNode = processNode;
	}

	public ProductBom getProductBom() {
		return productBom;
	}

	public void setProductBom(ProductBom productBom) {
		this.productBom = productBom;
	}

	public ConfigDictionary getPlanStatusDic() {
		return planStatusDic;
	}

	public void setPlanStatusDic(ConfigDictionary planStatusDic) {
		this.planStatusDic = planStatusDic;
	}

	public StructProcedureInstruct getStructProcedureInstruct() {
		return structProcedureInstruct;
	}

	public void setStructProcedureInstruct(StructProcedureInstruct structProcedureInstruct) {
		this.structProcedureInstruct = structProcedureInstruct;
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

	public UserPassport getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(UserPassport modifyUser) {
		this.modifyUser = modifyUser;
	}

}
