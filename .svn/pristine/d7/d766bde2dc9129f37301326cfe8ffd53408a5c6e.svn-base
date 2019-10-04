package com.techsoft.client.service.warehouse;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.WarehouseStrategyUpshelf;
import com.techsoft.entity.warehouse.WarehouseStrategyUpshelfParamVo;
import com.techsoft.entity.warehouse.WarehouseStrategyUpshelfVo;

public interface ClientWarehouseStrategyUpshelfService extends BaseClientService<WarehouseStrategyUpshelf> {

	public WarehouseStrategyUpshelfVo getVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<WarehouseStrategyUpshelfVo> selectListVoByParamVo(
			WarehouseStrategyUpshelfParamVo warehouseStrategyUpshelf, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<WarehouseStrategyUpshelfVo> selectPageVoByParamVo(
			WarehouseStrategyUpshelfParamVo warehouseStrategyUpshelf, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException;

	public WarehouseStrategyUpshelfVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<WarehouseStrategyUpshelfVo> selectListExtendVoByParamVo(
			WarehouseStrategyUpshelfParamVo warehouseStrategyUpshelf, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<WarehouseStrategyUpshelfVo> selectPageExtendVoByParamVo(
			WarehouseStrategyUpshelfParamVo warehouseStrategyUpshelf, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(WarehouseStrategyUpshelfParamVo warehouseStrategyUpshelfParamVo,
			CommonParam commonParam);
}
