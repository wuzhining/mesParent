package com.techsoft.dao.bill;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.bill.BillPurchaseItemVo;
import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.BillDeliveryItem;
import com.techsoft.entity.common.BillWarehouse;

public interface BillDeliveryDao extends BaseDao<BillDelivery> {

	/**
	*@auther:Chen
	*@version:2019年5月29日下午4:52:37
	*@param list         退货单List
	*@param billCode     供应商发货单
	*@param commonParam
	*@return  BillDelivery  供应商发货单明细List 
	*@throws BusinessException
	*@throws SQLException
	*@description  根据退货单生成供应商发货单
	*/
	public List<BillDeliveryItem> insertBatchMainAndDetail(List<BillWarehouse> list,String billCode, CommonParam commonParam)
			throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年5月29日下午4:58:09
	*@param list         采购明细信息List
	*@param billCode     送货单号
	*@param commonParam 
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description  根据采购明细List批量新增送货单主表及明细表信息
	*/
	public List<BillDeliveryItem> insertPurchaseBatchMainAndDetail(List<BillPurchaseItemVo> list, String billCode,CommonParam commonParam)
			throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年6月4日下午2:44:38
	*@param id                  主单ID
	*@param billStatusDictId    单据状态
	*@param commonParam
	*@throws BusinessException
	*@throws SQLException
	*@description  用于更新发货单状态
	*/
	public void updateBillStatusMain(Long id, Long billStatusDictId, CommonParam commonParam) throws BusinessException, SQLException;

}
