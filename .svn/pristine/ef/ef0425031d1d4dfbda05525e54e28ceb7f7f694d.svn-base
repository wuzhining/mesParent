package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipWorkClasses;
import com.techsoft.entity.equip.EquipWorkClassesVo;
import com.techsoft.entity.equip.EquipWorkClassesParamVo;

public interface ClientEquipWorkClassesService extends BaseClientService<EquipWorkClasses> {

	public EquipWorkClassesVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<EquipWorkClassesVo> selectListVoByParamVo(EquipWorkClassesParamVo equipWorkClasses,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<EquipWorkClassesVo> selectPageVoByParamVo(EquipWorkClassesParamVo equipWorkClasses,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public EquipWorkClassesVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<EquipWorkClassesVo> selectListExtendVoByParamVo(EquipWorkClassesParamVo equipWorkClasses,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<EquipWorkClassesVo> selectPageExtendVoByParamVo(EquipWorkClassesParamVo equipWorkClasses,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(EquipWorkClassesParamVo equipWorkClassesParamVo, CommonParam commonParam);
}
