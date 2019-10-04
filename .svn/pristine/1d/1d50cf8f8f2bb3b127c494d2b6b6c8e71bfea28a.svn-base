package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.struct.StructProductionlineParamVo;
import com.techsoft.entity.struct.StructProductionlineVo;

public interface ClientStructProductionlineService extends BaseClientService<StructProductionline> {

	public StructProductionlineVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructProductionlineVo> selectListVoByParamVo(StructProductionlineParamVo structProductionline,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructProductionlineVo> selectPageVoByParamVo(StructProductionlineParamVo structProductionline,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public StructProductionlineVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<StructProductionlineVo> selectListExtendVoByParamVo(StructProductionlineParamVo structProductionline,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructProductionlineVo> selectPageExtendVoByParamVo(
			StructProductionlineParamVo structProductionline, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(StructProductionlineParamVo structProductionlineParamVo, CommonParam commonParam);
}
