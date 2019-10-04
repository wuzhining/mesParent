package com.techsoft.client.service.warehouse;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.WarehouseStrategyDownshelf;
import com.techsoft.entity.warehouse.WarehouseStrategyDownshelfParamVo;
import com.techsoft.entity.warehouse.WarehouseStrategyDownshelfVo;

public interface ClientWarehouseStrategyDownshelfService extends BaseClientService<WarehouseStrategyDownshelf> {

	public WarehouseStrategyDownshelfVo getVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<WarehouseStrategyDownshelfVo> selectListVoByParamVo(
			WarehouseStrategyDownshelfParamVo warehouseStrategyDownshelf, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<WarehouseStrategyDownshelfVo> selectPageVoByParamVo(
			WarehouseStrategyDownshelfParamVo warehouseStrategyDownshelf, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException;

	public WarehouseStrategyDownshelfVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<WarehouseStrategyDownshelfVo> selectListExtendVoByParamVo(
			WarehouseStrategyDownshelfParamVo warehouseStrategyDownshelf, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<WarehouseStrategyDownshelfVo> selectPageExtendVoByParamVo(
			WarehouseStrategyDownshelfParamVo warehouseStrategyDownshelf, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(WarehouseStrategyDownshelfParamVo warehouseStrategyDownshelfParamVo,
			CommonParam commonParam);
}
