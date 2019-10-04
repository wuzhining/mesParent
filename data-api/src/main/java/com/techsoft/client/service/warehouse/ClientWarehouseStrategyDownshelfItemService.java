package com.techsoft.client.service.warehouse;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.WarehouseStrategyDownshelfItem;
import com.techsoft.entity.warehouse.WarehouseStrategyDownshelfItemParamVo;
import com.techsoft.entity.warehouse.WarehouseStrategyDownshelfItemVo;

public interface ClientWarehouseStrategyDownshelfItemService extends BaseClientService<WarehouseStrategyDownshelfItem> {

	public WarehouseStrategyDownshelfItemVo getVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<WarehouseStrategyDownshelfItemVo> selectListVoByParamVo(
			WarehouseStrategyDownshelfItemParamVo warehouseStrategyDownshelfItem, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<WarehouseStrategyDownshelfItemVo> selectPageVoByParamVo(
			WarehouseStrategyDownshelfItemParamVo warehouseStrategyDownshelfItem, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException;

	public WarehouseStrategyDownshelfItemVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<WarehouseStrategyDownshelfItemVo> selectListExtendVoByParamVo(
			WarehouseStrategyDownshelfItemParamVo warehouseStrategyDownshelfItem, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<WarehouseStrategyDownshelfItemVo> selectPageExtendVoByParamVo(
			WarehouseStrategyDownshelfItemParamVo warehouseStrategyDownshelfItem, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(WarehouseStrategyDownshelfItemParamVo warehouseStrategyDownshelfItemParamVo,
			CommonParam commonParam);
}
