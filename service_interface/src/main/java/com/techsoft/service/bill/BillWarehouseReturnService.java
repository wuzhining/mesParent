package com.techsoft.service.bill;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.bill.BillPurchaseItemVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWorkorder;

/**
 * @auther:Wang
 * @version:2019年5月27日下午2:49:09
 * @param:
 * @description
 */
public interface BillWarehouseReturnService extends BaseService<BillWarehouse> {


	
	/**
	*@auther:Chen
	*@version:2019年5月31日下午3:06:56
	*@param list             退料工单List
	*@param commonParam     
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public ResultMessage workerReturnSava(List<BillWorkorder> list, CommonParam commonParam) throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年6月13日下午3:55:58
	*@param list            退料标签List
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description  扫描标签生成退料单以及入库上架单
	*/
	public ResultMessage barcodeReturn(List<BarcodeMain> list, CommonParam commonParam) throws BusinessException, SQLException;
	
	

}
