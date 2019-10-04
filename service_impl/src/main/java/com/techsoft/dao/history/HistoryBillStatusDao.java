package com.techsoft.dao.history;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.HistoryBillStatus;

public interface HistoryBillStatusDao extends BaseDao<HistoryBillStatus> {

	/**
	*@auther:Chen
	*@version:2019年6月19日上午11:54:50
	*@param billType
	*@param billStatus
	*@param billId
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public ResultMessage billHistoryInsert(Long billType, Long billStatus, Long billId, String billCode,CommonParam commonParam)
			throws BusinessException, SQLException;

}
