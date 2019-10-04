package com.techsoft.client.service.warehouse;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.warehouse.WarehouseRackVo;
import com.techsoft.entity.warehouse.WarehouseRackParamVo;

public interface ClientWarehouseRackService extends BaseClientService<WarehouseRack> {

	public WarehouseRackVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<WarehouseRackVo> selectListVoByParamVo(WarehouseRackParamVo warehouseRack, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<WarehouseRackVo> selectPageVoByParamVo(WarehouseRackParamVo warehouseRack, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public WarehouseRackVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<WarehouseRackVo> selectListExtendVoByParamVo(WarehouseRackParamVo warehouseRack,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<WarehouseRackVo> selectPageExtendVoByParamVo(WarehouseRackParamVo warehouseRack,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(WarehouseRackParamVo warehouseRackParamVo, CommonParam commonParam);
}
