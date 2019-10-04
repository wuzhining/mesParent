package com.techsoft.dao.bill;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.BillPurchase;

public interface BillPurchaseDao extends BaseDao<BillPurchase> {

	/**
	*@auther:Chen
	*@version:2019年6月20日下午1:15:39
	*@param id
	*@param billStatusDictId
	*@param commonParam
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public void updatePurchaseBillMain(Long id, Long billStatusDictId, CommonParam commonParam)
			throws BusinessException, SQLException;


}
