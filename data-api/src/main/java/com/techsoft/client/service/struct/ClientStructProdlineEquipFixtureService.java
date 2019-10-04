package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructProdlineEquipFixture;
import com.techsoft.entity.struct.StructProdlineEquipFixtureVo;
import com.techsoft.entity.struct.StructProdlineEquipFixtureParamVo;

public interface ClientStructProdlineEquipFixtureService extends BaseClientService<StructProdlineEquipFixture> {
	
	public StructProdlineEquipFixtureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProdlineEquipFixtureVo>  selectListVoByParamVo(StructProdlineEquipFixtureParamVo structProdlineEquipFixture, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProdlineEquipFixtureVo>  selectPageVoByParamVo(StructProdlineEquipFixtureParamVo structProdlineEquipFixture, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public StructProdlineEquipFixtureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProdlineEquipFixtureVo>  selectListExtendVoByParamVo(StructProdlineEquipFixtureParamVo structProdlineEquipFixture, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProdlineEquipFixtureVo>  selectPageExtendVoByParamVo(StructProdlineEquipFixtureParamVo structProdlineEquipFixture, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(StructProdlineEquipFixtureParamVo structProdlineEquipFixtureParamVo, CommonParam commonParam);		
}
