package com.techsoft.dao.history;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.HistoryInventoryLocation;

public interface HistoryInventoryLocationDao extends BaseDao<HistoryInventoryLocation> {

	/**
	*@auther:Chen
	*@version:2019年7月8日下午1:58:54
	*@param billId
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public ResultMessage billInventoryHistoryInsert(Long billId, CommonParam commonParam)
			throws BusinessException, SQLException;

}
