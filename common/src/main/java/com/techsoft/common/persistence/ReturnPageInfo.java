package com.techsoft.common.persistence;

import java.util.Collections;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseEntity;

public class ReturnPageInfo extends BaseEntity {

	private static final long serialVersionUID = 780085706010046654L;

	private int resultCode = 1; // 信息状态
	private String message = ""; // 信息内容

	protected int recordCount = 0;
	protected Integer targetPage = 1;
	protected Integer pageSize = 20;
	protected int pageCount = 0;
	protected int returnResult;
	protected List pageNumList;
	private BaseEntity entity;
	private List resultlist;

	public ReturnPageInfo() {

	}

	public ReturnPageInfo(PageInfo pageInfo) {
		if (pageInfo == null || pageInfo.getTotal() == 0) {
			setRecordCount(0);
			setResultlist(Collections.emptyList());
			setMessage("暂时没有数据");
		} else {
			setRecordCount((int) pageInfo.getTotal());
			setResultlist(pageInfo.getList());
		}
	}

	public List getResultlist() {
		return resultlist;
	}

	public void setResultlist(List resultlist) {
		this.resultlist = resultlist;
	}

	public BaseEntity getEntity() {
		return entity;
	}

	public void setEntity(BaseEntity entity) {
		this.entity = entity;
	}

	public int getReturnResult() {
		return returnResult;
	}

	public void setReturnResult(int returnResult) {
		this.returnResult = returnResult;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public Integer getTargetPage() {
		return targetPage;
	}

	public void setTargetPage(Integer targetPage) {
		this.targetPage = targetPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		int t = recordCount % pageSize;
		pageCount = recordCount / pageSize + (t == 0 ? 0 : 1);

		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List getPageNumList() {
		return pageNumList;
	}

	public void setPageNumList(List pageNumList) {
		this.pageNumList = pageNumList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

}
