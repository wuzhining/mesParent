package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructFloor;
import com.techsoft.entity.struct.StructFloorVo;
import com.techsoft.entity.struct.StructFloorParamVo;

public interface ClientStructFloorService extends BaseClientService<StructFloor> {

	public StructFloorVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructFloorVo> selectListVoByParamVo(StructFloorParamVo structFloor, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<StructFloorVo> selectPageVoByParamVo(StructFloorParamVo structFloor, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public StructFloorVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructFloorVo> selectListExtendVoByParamVo(StructFloorParamVo structFloor, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<StructFloorVo> selectPageExtendVoByParamVo(StructFloorParamVo structFloor, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(StructFloorParamVo structFloorParamVo, CommonParam commonParam);
}
