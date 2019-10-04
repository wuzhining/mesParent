package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.struct.StructWarehouseVo;
import com.techsoft.entity.struct.StructWarehouseParamVo;

public interface ClientStructWarehouseService extends BaseClientService<StructWarehouse> {

	public StructWarehouseVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructWarehouseVo> selectListVoByParamVo(StructWarehouseParamVo structWarehouse,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructWarehouseVo> selectPageVoByParamVo(StructWarehouseParamVo structWarehouse,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public StructWarehouseVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructWarehouseVo> selectListExtendVoByParamVo(StructWarehouseParamVo structWarehouse,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructWarehouseVo> selectPageExtendVoByParamVo(StructWarehouseParamVo structWarehouse,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(StructWarehouseParamVo structWarehouseParamVo, CommonParam commonParam);
}
