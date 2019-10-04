package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.struct.StructWorkshopVo;
import com.techsoft.entity.struct.StructWorkshopParamVo;

public interface ClientStructWorkshopService extends BaseClientService<StructWorkshop> {

	public StructWorkshopVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructWorkshopVo> selectListVoByParamVo(StructWorkshopParamVo structWorkshop, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<StructWorkshopVo> selectPageVoByParamVo(StructWorkshopParamVo structWorkshop,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public StructWorkshopVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructWorkshopVo> selectListExtendVoByParamVo(StructWorkshopParamVo structWorkshop,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructWorkshopVo> selectPageExtendVoByParamVo(StructWorkshopParamVo structWorkshop,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(StructWorkshopParamVo structWorkshopParamVo, CommonParam commonParam);
}
