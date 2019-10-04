package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipSpecsFixtureArea;
import com.techsoft.entity.equip.EquipSpecsFixtureAreaVo;
import com.techsoft.entity.equip.EquipSpecsFixtureAreaParamVo;

public interface ClientEquipSpecsFixtureAreaService extends BaseClientService<EquipSpecsFixtureArea> {
	
	public EquipSpecsFixtureAreaVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipSpecsFixtureAreaVo>  selectListVoByParamVo(EquipSpecsFixtureAreaParamVo equipSpecsFixtureArea, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipSpecsFixtureAreaVo>  selectPageVoByParamVo(EquipSpecsFixtureAreaParamVo equipSpecsFixtureArea, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public EquipSpecsFixtureAreaVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipSpecsFixtureAreaVo>  selectListExtendVoByParamVo(EquipSpecsFixtureAreaParamVo equipSpecsFixtureArea, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipSpecsFixtureAreaVo>  selectPageExtendVoByParamVo(EquipSpecsFixtureAreaParamVo equipSpecsFixtureArea, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(EquipSpecsFixtureAreaParamVo equipSpecsFixtureAreaParamVo, CommonParam commonParam);		
}
