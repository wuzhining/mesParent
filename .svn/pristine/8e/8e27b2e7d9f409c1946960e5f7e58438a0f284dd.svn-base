package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.entity.equip.EquipSpecsFixtureVo;
import com.techsoft.entity.equip.EquipSpecsFixtureParamVo;

public interface ClientEquipSpecsFixtureService extends BaseClientService<EquipSpecsFixture> {
	
	public EquipSpecsFixtureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipSpecsFixtureVo>  selectListVoByParamVo(EquipSpecsFixtureParamVo equipSpecsFixture, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipSpecsFixtureVo>  selectPageVoByParamVo(EquipSpecsFixtureParamVo equipSpecsFixture, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public EquipSpecsFixtureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipSpecsFixtureVo>  selectListExtendVoByParamVo(EquipSpecsFixtureParamVo equipSpecsFixture, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipSpecsFixtureVo>  selectPageExtendVoByParamVo(EquipSpecsFixtureParamVo equipSpecsFixture, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(EquipSpecsFixtureParamVo equipSpecsFixtureParamVo, CommonParam commonParam);		
}
