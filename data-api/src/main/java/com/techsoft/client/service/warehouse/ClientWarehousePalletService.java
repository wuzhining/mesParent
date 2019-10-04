package com.techsoft.client.service.warehouse;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.WarehousePallet;
import com.techsoft.entity.warehouse.WarehousePalletParamVo;
import com.techsoft.entity.warehouse.WarehousePalletVo;

public interface ClientWarehousePalletService extends BaseClientService<WarehousePallet> {

	public WarehousePalletVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<WarehousePalletVo> selectListVoByParamVo(WarehousePalletParamVo warehousePallet,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<WarehousePalletVo> selectPageVoByParamVo(WarehousePalletParamVo warehousePallet,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public WarehousePalletVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<WarehousePalletVo> selectListExtendVoByParamVo(WarehousePalletParamVo warehousePallet,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<WarehousePalletVo> selectPageExtendVoByParamVo(WarehousePalletParamVo warehousePallet,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(WarehousePalletParamVo warehousePalletParamVo, CommonParam commonParam);

	/**
	 * 修改合并栈板的箱数，sn数
	 * 
	 * @param map
	 * @param commonParam
	 * @return
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public int updatePallet(List<Map> map, CommonParam commonParam) throws BusinessException, SQLException;

	/**
	 * 修改条码主表的总数量
	 * 
	 * @param map
	 * @return
	 */
	public int updateBarcodeMain(Map<Object, Object> map, CommonParam commonParam)
			throws BusinessException, SQLException;

	/**
	 * 修改条码追踪的数量
	 * 
	 * @param map
	 * @return
	 */
	public int updateTrackBarcode(Map<Object, Object> map, CommonParam commonParam)
			throws BusinessException, SQLException;

	/**
	 * 修改被拆除栈板的箱数，sn数
	 * 
	 * @param map
	 * @param commonParam
	 * @return
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public int updatePalletPull(List<Map> map, CommonParam commonParam) throws BusinessException, SQLException;
}
