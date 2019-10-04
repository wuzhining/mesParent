package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.struct.StructWorkshopAreaVo;
import com.techsoft.entity.struct.StructWorkshopAreaParamVo;

public interface ClientStructWorkshopAreaService extends BaseClientService<StructWorkshopArea> {

	public StructWorkshopAreaVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructWorkshopAreaVo> selectListVoByParamVo(StructWorkshopAreaParamVo structWorkshopArea,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructWorkshopAreaVo> selectPageVoByParamVo(StructWorkshopAreaParamVo structWorkshopArea,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public StructWorkshopAreaVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<StructWorkshopAreaVo> selectListExtendVoByParamVo(StructWorkshopAreaParamVo structWorkshopArea,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructWorkshopAreaVo> selectPageExtendVoByParamVo(StructWorkshopAreaParamVo structWorkshopArea,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(StructWorkshopAreaParamVo structWorkshopAreaParamVo, CommonParam commonParam);
}
