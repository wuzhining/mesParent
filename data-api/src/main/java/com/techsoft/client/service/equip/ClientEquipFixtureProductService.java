package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipFixtureProduct;
import com.techsoft.entity.equip.EquipFixtureProductVo;
import com.techsoft.entity.equip.EquipFixtureProductParamVo;

public interface ClientEquipFixtureProductService extends BaseClientService<EquipFixtureProduct> {
	
	public EquipFixtureProductVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipFixtureProductVo>  selectListVoByParamVo(EquipFixtureProductParamVo equipFixtureProduct, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipFixtureProductVo>  selectPageVoByParamVo(EquipFixtureProductParamVo equipFixtureProduct, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public EquipFixtureProductVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipFixtureProductVo>  selectListExtendVoByParamVo(EquipFixtureProductParamVo equipFixtureProduct, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipFixtureProductVo>  selectPageExtendVoByParamVo(EquipFixtureProductParamVo equipFixtureProduct, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(EquipFixtureProductParamVo equipFixtureProductParamVo, CommonParam commonParam);		
}
