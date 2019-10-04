package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructProdlineWorkstation;
import com.techsoft.entity.struct.StructProdlineWorkstationVo;
import com.techsoft.entity.struct.StructProdlineWorkstationParamVo;

public interface ClientStructProdlineWorkstationService extends BaseClientService<StructProdlineWorkstation> {
	
	public StructProdlineWorkstationVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProdlineWorkstationVo>  selectListVoByParamVo(StructProdlineWorkstationParamVo structProdlineWorkstation, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProdlineWorkstationVo>  selectPageVoByParamVo(StructProdlineWorkstationParamVo structProdlineWorkstation, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public StructProdlineWorkstationVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProdlineWorkstationVo>  selectListExtendVoByParamVo(StructProdlineWorkstationParamVo structProdlineWorkstation, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProdlineWorkstationVo>  selectPageExtendVoByParamVo(StructProdlineWorkstationParamVo structProdlineWorkstation, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(StructProdlineWorkstationParamVo structProdlineWorkstationParamVo, CommonParam commonParam);		
}
