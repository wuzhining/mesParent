package com.techsoft.service.bill;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillWarehouse;

/**
*@auther:Wang
*@version:2019年7月8日下午2:03:13
*@param:
*@description
*/
public interface BillWarehouseDiscardedService extends BaseService<BillWarehouse> {
	/**
	*@auther:Wang
	*@version:2019年7月8日下午2:05:16
	*@param:list 条码集合
	*@description 报废出库单生成
	*/
	public ResultMessage insertDiscarded(List<BarcodeMain> list,Long factoryId, CommonParam commonParam) throws BusinessException, SQLException;
	
	
}
