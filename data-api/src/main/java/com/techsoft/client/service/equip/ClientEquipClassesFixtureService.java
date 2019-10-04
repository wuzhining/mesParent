package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipClassesFixture;
import com.techsoft.entity.equip.EquipClassesFixtureVo;
import com.techsoft.entity.equip.EquipClassesFixtureParamVo;

public interface ClientEquipClassesFixtureService extends BaseClientService<EquipClassesFixture> {
	
	public EquipClassesFixtureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipClassesFixtureVo>  selectListVoByParamVo(EquipClassesFixtureParamVo equipClassesFixture, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipClassesFixtureVo>  selectPageVoByParamVo(EquipClassesFixtureParamVo equipClassesFixture, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public EquipClassesFixtureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipClassesFixtureVo>  selectListExtendVoByParamVo(EquipClassesFixtureParamVo equipClassesFixture, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipClassesFixtureVo>  selectPageExtendVoByParamVo(EquipClassesFixtureParamVo equipClassesFixture, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(EquipClassesFixtureParamVo equipClassesFixtureParamVo, CommonParam commonParam);		
}
