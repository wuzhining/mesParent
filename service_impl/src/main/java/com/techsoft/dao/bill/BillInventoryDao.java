package com.techsoft.dao.bill;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.BillInventory;

public interface BillInventoryDao extends BaseDao<BillInventory> {

	/**
	*@auther:Chen
	*@version:2019年7月2日下午4:54:07
	*@param id        单据ID
	*@param billStatusDictId  单据状态
	*@param commonParam
	*@throws BusinessException
	*@throws SQLException
	*@description  根据单据修改单据状态
	*/
	public ResultMessage updateBillStatusMain(Long id, Long billStatusDictId, CommonParam commonParam)
			throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年7月3日下午3:16:04
	*@param id                 盘点单ID
	*@param auditStatusDictId  审核状态
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description      根据传回的盘点单喝审核状态更新数据
	*/
	public ResultMessage updateAuditStatus(Long id, Long auditStatusDictId, CommonParam commonParam)
			throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年7月6日上午11:31:25
	*@param id 盘点单ID
	*@param settleStatusDictId 结算状态
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public ResultMessage updateSettleStatus(Long id, Long settleStatusDictId, CommonParam commonParam)
			throws BusinessException, SQLException;

}
