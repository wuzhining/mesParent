package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructProcessProduct;
import com.techsoft.entity.struct.StructProcessProductVo;
import com.techsoft.entity.struct.StructProcessProductParamVo;

public interface ClientStructProcessProductService extends BaseClientService<StructProcessProduct> {
	
	public StructProcessProductVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProcessProductVo>  selectListVoByParamVo(StructProcessProductParamVo structProcessProduct, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProcessProductVo>  selectPageVoByParamVo(StructProcessProductParamVo structProcessProduct, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public StructProcessProductVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructProcessProductVo>  selectListExtendVoByParamVo(StructProcessProductParamVo structProcessProduct, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructProcessProductVo>  selectPageExtendVoByParamVo(StructProcessProductParamVo structProcessProduct, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(StructProcessProductParamVo structProcessProductParamVo, CommonParam commonParam);		
}
