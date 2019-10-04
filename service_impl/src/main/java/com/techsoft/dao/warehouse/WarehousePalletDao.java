package com.techsoft.dao.warehouse;

import java.util.Map;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WarehousePallet;

public interface WarehousePalletDao extends BaseDao<WarehousePallet> {
	/**
	 * 修改合并栈板和待合并栈板的箱数，sn数，状态
	 * @param map
	 * @param commonParam
	 * @return
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public int updatePallet(Map<Object,Object> map, CommonParam commonParam) throws BusinessException, SQLException;
	
	/**
	 * 修改条码主表的总数量
	 * @param map
	 * @return
	 */
	public int updateBarcodeMain(Map<Object,Object> map, CommonParam commonParam) throws BusinessException, SQLException;
	
	/**
	 * 修改条码追踪的数量
	 * @param map
	 * @return
	 */
	public int updateTrackBarcode(Map<Object,Object> map, CommonParam commonParam) throws BusinessException, SQLException;
	
	/**
	 * 修改被拆除栈板的箱数，sn数
	 * @param map
	 * @param commonParam
	 * @return
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public int updatePalletPull(Map<Object,Object> map,CommonParam commonParam) throws BusinessException, SQLException;
}
