package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructProdlineEquip;
import com.techsoft.entity.struct.StructProdlineEquipVo;
import com.techsoft.entity.struct.StructProdlineEquipParamVo;

public interface ClientStructProdlineEquipService extends BaseClientService<StructProdlineEquip> {
	
	public StructProdlineEquipVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProdlineEquipVo>  selectListVoByParamVo(StructProdlineEquipParamVo structProdlineEquip, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProdlineEquipVo>  selectPageVoByParamVo(StructProdlineEquipParamVo structProdlineEquip, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public StructProdlineEquipVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProdlineEquipVo>  selectListExtendVoByParamVo(StructProdlineEquipParamVo structProdlineEquip, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProdlineEquipVo>  selectPageExtendVoByParamVo(StructProdlineEquipParamVo structProdlineEquip, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(StructProdlineEquipParamVo structProdlineEquipParamVo, CommonParam commonParam);		
}
