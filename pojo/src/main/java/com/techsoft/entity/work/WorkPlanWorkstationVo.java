package com.techsoft.entity.work;

import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WorkPlanWorkstation;
import com.techsoft.entity.common.WorkTaskProcedure;

public class WorkPlanWorkstationVo extends WorkPlanWorkstation {
	private static final long serialVersionUID = 2441421066415731177L;

	private StructFactory factory;
	private BillWorkorder billWorkorder;
	private WorkTaskProcedure task;
	private StructWorkshop workshop;
	private StructProcessNode processNode;
	private ConfigDictionary planStatusDic;
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

	public ConfigDictionary getPlanStatusDic() {
		return planStatusDic;
	}

	public void setPlanStatusDic(ConfigDictionary planStatusDic) {
		this.planStatusDic = planStatusDic;
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

	public WorkPlanWorkstationVo() {	
	}
	
	public WorkPlanWorkstationVo(WorkPlanWorkstation value) {
		value.cloneProperties(this);
	}

	public UserPassport getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(UserPassport modifyUser) {
		this.modifyUser = modifyUser;
	}		
}
