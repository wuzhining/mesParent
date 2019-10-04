package com.techsoft.service.bill;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.track.TrackBarcodeVo;

/**
 * @auther:Wang
 * @version:2019年5月27日下午2:49:09
 * @param:
 * @description
 */
public interface BillWarehouseRejectService extends BaseService<BillWarehouse> {

	
	/**
	*@auther:Chen
	*@version:2019年5月29日下午4:49:10
	*@param list          退货单List
	*@param commonParam
	*@return ResultMessage
	*@throws BusinessException
	*@throws SQLException
	*@description  根据前端传回选择的单据List批量处理
	*/
	public ResultMessage rejectBatchSaveOrUpdate(List<BillWarehouse> list, CommonParam commonParam) throws BusinessException, SQLException;
	

}
