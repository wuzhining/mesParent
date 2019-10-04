package com.techsoft.service.bill;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.bill.BillWarehouseVo;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.track.TrackBarcodeVo;

/**
 * @auther:Wang
 * @version:2019年5月27日下午2:49:09
 * @param:
 * @description
 */
public interface BillWarehouseArrivalService extends BaseService<BillWarehouse> {

	
	/**
	*@auther:Chen
	*@version:2019年5月29日下午4:41:35
	*@param billWarehouseVo  单据对象
	*@param commonParam
	*@return  ResultMessage
	*@throws BusinessException
	*@throws SQLException
	*@description  来料审核生成质检单
	*/
	public ResultMessage billCheck(BillWarehouseVo billWarehouseVo, CommonParam commonParam) throws BusinessException, SQLException ;

	/**
	*@auther:Chen
	*@version:2019年6月19日下午2:47:04
	*@param billWarehouseVo
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public ResultMessage printCheck(BillWarehouseVo billWarehouseVo, CommonParam commonParam)
			throws BusinessException, SQLException;



	
	
	

}
