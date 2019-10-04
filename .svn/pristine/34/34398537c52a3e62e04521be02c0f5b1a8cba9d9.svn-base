package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipFixtureStack;
import com.techsoft.entity.equip.EquipFixtureStackVo;
import com.techsoft.entity.equip.EquipFixtureStackParamVo;

public interface ClientEquipFixtureStackService extends BaseClientService<EquipFixtureStack> {
	
	public EquipFixtureStackVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipFixtureStackVo>  selectListVoByParamVo(EquipFixtureStackParamVo equipFixtureStack, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipFixtureStackVo>  selectPageVoByParamVo(EquipFixtureStackParamVo equipFixtureStack, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public EquipFixtureStackVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipFixtureStackVo>  selectListExtendVoByParamVo(EquipFixtureStackParamVo equipFixtureStack, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipFixtureStackVo>  selectPageExtendVoByParamVo(EquipFixtureStackParamVo equipFixtureStack, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(EquipFixtureStackParamVo equipFixtureStackParamVo, CommonParam commonParam);		
}
