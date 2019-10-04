package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipFixtureStackProduct;
import com.techsoft.entity.equip.EquipFixtureStackProductVo;
import com.techsoft.entity.equip.EquipFixtureStackProductParamVo;

public interface ClientEquipFixtureStackProductService extends BaseClientService<EquipFixtureStackProduct> {
	
	public EquipFixtureStackProductVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipFixtureStackProductVo>  selectListVoByParamVo(EquipFixtureStackProductParamVo equipFixtureStackProduct, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipFixtureStackProductVo>  selectPageVoByParamVo(EquipFixtureStackProductParamVo equipFixtureStackProduct, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public EquipFixtureStackProductVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipFixtureStackProductVo>  selectListExtendVoByParamVo(EquipFixtureStackProductParamVo equipFixtureStackProduct, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipFixtureStackProductVo>  selectPageExtendVoByParamVo(EquipFixtureStackProductParamVo equipFixtureStackProduct, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(EquipFixtureStackProductParamVo equipFixtureStackProductParamVo, CommonParam commonParam);		
}
