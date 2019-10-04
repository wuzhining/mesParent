package com.techsoft.client.service.warehouse;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.WarehousePalletItem;
import com.techsoft.entity.warehouse.WarehousePalletItemVo;
import com.techsoft.entity.warehouse.WarehousePalletItemParamVo;

public interface ClientWarehousePalletItemService extends BaseClientService<WarehousePalletItem> {

	public WarehousePalletItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<WarehousePalletItemVo> selectListVoByParamVo(WarehousePalletItemParamVo warehousePalletItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<WarehousePalletItemVo> selectPageVoByParamVo(WarehousePalletItemParamVo warehousePalletItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public WarehousePalletItemVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<WarehousePalletItemVo> selectListExtendVoByParamVo(WarehousePalletItemParamVo warehousePalletItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<WarehousePalletItemVo> selectPageExtendVoByParamVo(WarehousePalletItemParamVo warehousePalletItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(WarehousePalletItemParamVo warehousePalletItemParamVo, CommonParam commonParam);

	/**
	 * 采集栈板到条码主表
	 * 
	 * @param ParamVo
	 * @param commonParam
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public int updateBarcodeMainByBarcode(Map<Object, Object> map, CommonParam commonParam)
			throws BusinessException, SQLException;
}
