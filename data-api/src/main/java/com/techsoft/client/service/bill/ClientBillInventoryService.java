package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.BillInventory;
import com.techsoft.entity.bill.BillInventoryVo;
import com.techsoft.entity.bill.BillInventoryParamVo;

public interface ClientBillInventoryService extends BaseClientService<BillInventory> {
	
	public BillInventoryVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<BillInventoryVo>  selectListVoByParamVo(BillInventoryParamVo billInventory, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<BillInventoryVo>  selectPageVoByParamVo(BillInventoryParamVo billInventory, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public BillInventoryVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<BillInventoryVo>  selectListExtendVoByParamVo(BillInventoryParamVo billInventory, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<BillInventoryVo>  selectPageExtendVoByParamVo(BillInventoryParamVo billInventory, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(BillInventoryParamVo billInventoryParamVo, CommonParam commonParam);

	/**
	*@auther:Chen
	*@version:2019年7月3日下午4:44:21
	*@param id                  盘点单ID
	*@param auditStatusDictId   审核状态
	*@param commonParam
	*@return
	*@description    根据传回的盘点单喝审核状态更新数据
	*/
	public ResultMessage updateAuditStatus(Long id, Long auditStatusDictId, CommonParam commonParam);

	/**
	*@auther:Chen
	*@version:2019年7月5日下午1:34:58
	*@param id
	*@param commonParam
	*@return
	*@description
	*/
	public ResultMessage settle(Long id, CommonParam commonParam);

	
}
