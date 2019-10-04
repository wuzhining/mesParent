package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.struct.StructProcessNodeVo;
import com.techsoft.entity.struct.StructProcessNodeParamVo;

public interface ClientStructProcessNodeService extends BaseClientService<StructProcessNode> {

	public StructProcessNodeVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructProcessNodeVo> selectListVoByParamVo(StructProcessNodeParamVo structProcessNode,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructProcessNodeVo> selectPageVoByParamVo(StructProcessNodeParamVo structProcessNode,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public StructProcessNodeVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructProcessNodeVo> selectListExtendVoByParamVo(StructProcessNodeParamVo structProcessNode,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructProcessNodeVo> selectPageExtendVoByParamVo(StructProcessNodeParamVo structProcessNode,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(StructProcessNodeParamVo structProcessNodeParamVo, CommonParam commonParam);
}
