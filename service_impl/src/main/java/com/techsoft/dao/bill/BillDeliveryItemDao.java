package com.techsoft.dao.bill;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.bill.BillDeliveryItemParamVo;
import com.techsoft.entity.bill.BillDeliveryItemVo;
import com.techsoft.entity.common.BillDeliveryItem;

public interface BillDeliveryItemDao extends BaseDao<BillDeliveryItem> {

	/**
	*@auther:Chen
	*@version:2019年6月4日下午2:44:38
	*@param id                  主单ID
	*@param billStatusDictId    单据状态
	*@param commonParam
	*@throws BusinessException
	*@throws SQLException
	*@description  用于更新发货单明细表状态
	*/
	public void updateBillItemStatusMain(Long id, Long billStatusDictId, CommonParam commonParam)throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年6月5日上午10:38:57
	*@param billDeliveryItemParamVo
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public List<BillDeliveryItemVo> selectSumQtyByBillId(BillDeliveryItemParamVo billDeliveryItemParamVo) throws BusinessException, SQLException;

}
