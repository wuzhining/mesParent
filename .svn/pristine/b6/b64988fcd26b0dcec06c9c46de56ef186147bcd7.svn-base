package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.equip.EquipWorkVo;
import com.techsoft.entity.equip.EquipWorkParamVo;

public interface ClientEquipWorkService extends BaseClientService<EquipWork> {

	public EquipWorkVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public EquipWorkVo getByEquipCode(String equipCode, CommonParam commonParam) throws BusinessException, SQLException;

	public List<EquipWorkVo> selectListVoByParamVo(EquipWorkParamVo equipWork, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<EquipWorkVo> selectPageVoByParamVo(EquipWorkParamVo equipWork, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException;

	public EquipWorkVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<EquipWorkVo> selectListExtendVoByParamVo(EquipWorkParamVo equipWork, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<EquipWorkVo> selectPageExtendVoByParamVo(EquipWorkParamVo equipWork, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(EquipWorkParamVo equipWorkParamVo, CommonParam commonParam);
}
