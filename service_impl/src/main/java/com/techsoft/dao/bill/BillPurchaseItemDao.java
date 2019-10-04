package com.techsoft.dao.bill;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.BillPurchaseItem;

public interface BillPurchaseItemDao extends BaseDao<BillPurchaseItem> {

	/**
	*@auther:Chen
	*@version:2019年6月5日下午2:36:13
	*@param id                
	*@param billStatusDictId
	*@param quality
	*@param commonParam
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public void updatePurchaseBill(Long id, Long billStatusDictId, Double quality, CommonParam commonParam)
			throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年6月5日下午3:31:41
	*@param id
	*@param billStatusDictId
	*@param commonParam
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public void updatePurchaseBillStatus(Long id, Long billStatusDictId, CommonParam commonParam)
			throws BusinessException, SQLException;
	
	
	/**
	 * 
	 *@auther :Yang
	 *@version :2019年7月22日
	 *@param
	 *@return
	 *@description
	 */
	public void updatePurchaseBillStatusS(Long id, Long billStatusDictId, CommonParam commonParam)
			throws BusinessException, SQLException;
	

}
