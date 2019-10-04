package com.techsoft.client.service.warehouse;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.warehouse.WarehouseAreaVo;
import com.techsoft.entity.warehouse.WarehouseAreaParamVo;

public interface ClientWarehouseAreaService extends BaseClientService<WarehouseArea> {

	public WarehouseAreaVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<WarehouseAreaVo> selectListVoByParamVo(WarehouseAreaParamVo warehouseArea, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<WarehouseAreaVo> selectPageVoByParamVo(WarehouseAreaParamVo warehouseArea, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public WarehouseAreaVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<WarehouseAreaVo> selectListExtendVoByParamVo(WarehouseAreaParamVo warehouseArea,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<WarehouseAreaVo> selectPageExtendVoByParamVo(WarehouseAreaParamVo warehouseArea,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(WarehouseAreaParamVo warehouseAreaParamVo, CommonParam commonParam);
}
