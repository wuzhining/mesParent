package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.StructWarehouseLocation;
import com.techsoft.entity.struct.StructWarehouseLocationParamVo;
import com.techsoft.entity.struct.StructWarehouseLocationVo;

public interface ClientStructWarehouseLocationService extends BaseClientService<StructWarehouseLocation> {

	public StructWarehouseLocationVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructWarehouseLocationVo> selectListVoByParamVo(StructWarehouseLocationParamVo structWarehouseLocation,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructWarehouseLocationVo> selectPageVoByParamVo(
			StructWarehouseLocationParamVo structWarehouseLocation, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException;

	public StructWarehouseLocationVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<StructWarehouseLocationVo> selectListExtendVoByParamVo(
			StructWarehouseLocationParamVo structWarehouseLocation, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<StructWarehouseLocationVo> selectPageExtendVoByParamVo(
			StructWarehouseLocationParamVo structWarehouseLocation, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(StructWarehouseLocationParamVo structWarehouseLocationParamVo,
			CommonParam commonParam);
}
