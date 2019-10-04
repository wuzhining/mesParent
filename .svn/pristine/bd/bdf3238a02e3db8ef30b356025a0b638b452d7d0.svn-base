package com.techsoft.dao.bill;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.BillInventoryItem;

public interface BillInventoryItemDao extends BaseDao<BillInventoryItem> {

	/**
	*@auther:Chen
	*@version:2019年7月1日上午11:08:57
	*@param list
	*@param commonParam
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public void insertBatch(List<BillInventoryItem> list, CommonParam commonParam) throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年7月2日下午4:21:05
	*@param id     单据明细ID
	*@param quality 更改数量
	*@param commonParam
	*@throws BusinessException
	*@throws SQLException
	*@description 根据明细ID更新盘点数量
	*/
	public void updateQTYofInventory(Long id, Double quality, CommonParam commonParam) throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年7月3日下午5:20:11
	*@param id   盘点明细ID
	*@param updateQty 更改的数量
	*@param type  数量变化类型     add：增加；reduce：减少
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description 根据明细ID更改盘点数量
	*/
	public ResultMessage updateItemQty(Long id, Double updateQty,String type, CommonParam commonParam)
			throws BusinessException, SQLException;

}
