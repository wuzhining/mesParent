package com.techsoft.client.service.warehouse;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.warehouse.WarehouseLocationVo;
import com.techsoft.entity.warehouse.WarehouseLocationParamVo;

public interface ClientWarehouseLocationService extends BaseClientService<WarehouseLocation> {

	public WarehouseLocationVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<WarehouseLocationVo> selectListVoByParamVo(WarehouseLocationParamVo warehouseLocation,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<WarehouseLocationVo> selectPageVoByParamVo(WarehouseLocationParamVo warehouseLocation,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public WarehouseLocationVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<WarehouseLocationVo> selectListExtendVoByParamVo(WarehouseLocationParamVo warehouseLocation,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<WarehouseLocationVo> selectPageExtendVoByParamVo(WarehouseLocationParamVo warehouseLocation,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(WarehouseLocationParamVo warehouseLocationParamVo, CommonParam commonParam);
}
