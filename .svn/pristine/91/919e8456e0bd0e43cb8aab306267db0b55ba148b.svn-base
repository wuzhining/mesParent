package com.techsoft.dao.warehouse;

import java.util.Map;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WarehousePalletItem;

public interface WarehousePalletItemDao extends BaseDao<WarehousePalletItem> {
	/**
	 * 采集栈板到条码主表 
	 * @param ParamVo
	 * @param commonParam
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public int updateBarcodeMainByBarcode(Map<Object,Object> map,CommonParam commonParam) throws BusinessException, SQLException;
	
	/**
	 * 采集栈板到条码追踪表 
	 * @param ParamVo
	 * @param commonParam
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public int updateTrackBarcodeByBarcode(Map<Object,Object> map,CommonParam commonParam) throws BusinessException, SQLException;
}
