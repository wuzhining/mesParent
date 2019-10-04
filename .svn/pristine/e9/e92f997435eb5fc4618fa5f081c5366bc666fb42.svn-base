package com.techsoft.entity.bill;

import java.util.Date;
import java.util.List;

import org.apache.yetus.audience.InterfaceAudience.Private;

import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;

public class BillWarehouseParamVo extends BillWarehouse {
	private static final long serialVersionUID = 5551617414354714667L;


	public BillWarehouseParamVo (){
	}
	
	public BillWarehouseParamVo(BillWarehouse value) {
		value.cloneProperties(this);
	}	
	/**
	*@auther:Wang
	*@version:2019年4月23日下午5:26:39
	*@description 定义出入库单据明细集合
	*/
	private List<BillWarehouseItem> itemList;
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	private Long notFinish;
	private String billCodeLike; 
	private List<Long> ids;
	
	
	
	public Date getCreateTimeBegin() {
		return createTimeBegin;
	}

	public void setCreateTimeBegin(Date value) {
		this.createTimeBegin = value;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date value) {
		this.createTimeEnd = value;
	}

	public Date getModifyTimeBegin() {
		return modifyTimeBegin;
	}

	public void setModifyTimeBegin(Date value) {
		this.modifyTimeBegin = value;
	}

	public Date getModifyTimeEnd() {
		return modifyTimeEnd;
	}

	public void setModifyTimeEnd(Date value) {
		this.modifyTimeEnd = value;
	}	
	
	public List<BillWarehouseItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<BillWarehouseItem> itemList) {
		this.itemList = itemList;
	}

	public Long getNotFinish() {
		return notFinish;
	}

	public void setNotFinish(Long notFinish) {
		this.notFinish = notFinish;
	}

	public String getBillCodeLike() {
		return billCodeLike;
	}

	public void setBillCodeLike(String billCodeLike) {
		this.billCodeLike = billCodeLike;
	}
	
 
	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
}
