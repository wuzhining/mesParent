package com.techsoft.dao.bill;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.BillSaleorderItem;

public interface BillSaleorderItemDao extends BaseDao<BillSaleorderItem> {
	/**
	 * 
	 *@auther :Yang
	 *@version :2019年7月24日
	 *@param
	 *@return
	 *@description
	 */
	public void updateSaleorderBillStatus(Long id, Long billStatusDictId, CommonParam commonParam)
			throws BusinessException, SQLException;

}
