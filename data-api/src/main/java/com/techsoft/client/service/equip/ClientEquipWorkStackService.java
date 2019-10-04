package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipWorkStack;
import com.techsoft.entity.equip.EquipWorkStackVo;
import com.techsoft.entity.equip.EquipWorkStackParamVo;

public interface ClientEquipWorkStackService extends BaseClientService<EquipWorkStack> {

	public EquipWorkStackVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<EquipWorkStackVo> selectListVoByParamVo(EquipWorkStackParamVo equipWorkStack, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<EquipWorkStackVo> selectPageVoByParamVo(EquipWorkStackParamVo equipWorkStack,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public EquipWorkStackVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<EquipWorkStackVo> selectListExtendVoByParamVo(EquipWorkStackParamVo equipWorkStack,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<EquipWorkStackVo> selectPageExtendVoByParamVo(EquipWorkStackParamVo equipWorkStack,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(EquipWorkStackParamVo equipWorkStackParamVo, CommonParam commonParam);
}
