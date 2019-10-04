package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructProcedureEquipFixture;
import com.techsoft.entity.struct.StructProcedureEquipFixtureVo;
import com.techsoft.entity.struct.StructProcedureEquipFixtureParamVo;

public interface ClientStructProcedureEquipFixtureService extends BaseClientService<StructProcedureEquipFixture> {
	
	public StructProcedureEquipFixtureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProcedureEquipFixtureVo>  selectListVoByParamVo(StructProcedureEquipFixtureParamVo structProcedureEquipFixture, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProcedureEquipFixtureVo>  selectPageVoByParamVo(StructProcedureEquipFixtureParamVo structProcedureEquipFixture, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public StructProcedureEquipFixtureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProcedureEquipFixtureVo>  selectListExtendVoByParamVo(StructProcedureEquipFixtureParamVo structProcedureEquipFixture, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProcedureEquipFixtureVo>  selectPageExtendVoByParamVo(StructProcedureEquipFixtureParamVo structProcedureEquipFixture, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(StructProcedureEquipFixtureParamVo structProcedureEquipFixtureParamVo, CommonParam commonParam);		
}
