package com.techsoft.entity.work;

import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipSpecsWork;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WorkPlanEquip;
import com.techsoft.entity.common.WorkTaskProcedure;

public class WorkPlanEquipVo extends WorkPlanEquip {
	private static final long serialVersionUID = -1775395113928218765L;
	private StructFactory factory;
	private BillWorkorder billWorkorder;
	private WorkTaskProcedure task;
	private StructWorkshop workshop;
	private StructProcessNode processNode;
	private EquipWork equipWork;
	private ConfigDictionary planStatusDic;
	private StructProcedureInstruct structProcedureInstruct;
	private EquipSpecsWork equipSpecsWork;
	private StructWorkshopArea structWorkshopArea;
	private StructWorkstation structWorkstation;
	private UserPassport userPassport;
	private UserPassport modifyUser;
	
	public UserPassport getUserPassport() {
		return userPassport;
	}

	public void setUserPassport(UserPassport userPassport) {
		this.userPassport = userPassport;
	}

	public StructWorkshopArea getStructWorkshopArea() {
		return structWorkshopArea;
	}

	public void setStructWorkshopArea(StructWorkshopArea structWorkshopArea) {
		this.structWorkshopArea = structWorkshopArea;
	}

	public StructWorkstation getStructWorkstation() {
		return structWorkstation;
	}

	public void setStructWorkstation(StructWorkstation structWorkstation) {
		this.structWorkstation = structWorkstation;
	}

	public WorkPlanEquipVo() {	
	}
	
	public WorkPlanEquipVo(WorkPlanEquip value) {
		value.cloneProperties(this);
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

	public EquipWork getEquipWork() {
		return equipWork;
	}

	public void setEquipWork(EquipWork equipWork) {
		this.equipWork = equipWork;
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

	public EquipSpecsWork getEquipSpecsWork() {
		return equipSpecsWork;
	}

	public void setEquipSpecsWork(EquipSpecsWork equipSpecsWork) {
		this.equipSpecsWork = equipSpecsWork;
	}

	public UserPassport getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(UserPassport modifyUser) {
		this.modifyUser = modifyUser;
	}
}
