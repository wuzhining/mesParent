package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.struct.StructWorkstationVo;
import com.techsoft.entity.struct.StructWorkstationParamVo;

public interface ClientStructWorkstationService extends BaseClientService<StructWorkstation> {

	public StructWorkstationVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructWorkstationVo> selectListVoByParamVo(StructWorkstationParamVo structWorkstation,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructWorkstationVo> selectPageVoByParamVo(StructWorkstationParamVo structWorkstation,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public StructWorkstationVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructWorkstationVo> selectListExtendVoByParamVo(StructWorkstationParamVo structWorkstation,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructWorkstationVo> selectPageExtendVoByParamVo(StructWorkstationParamVo structWorkstation,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(StructWorkstationParamVo structWorkstationParamVo, CommonParam commonParam);
}
