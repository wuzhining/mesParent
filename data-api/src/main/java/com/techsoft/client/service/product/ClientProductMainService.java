package com.techsoft.client.service.product;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.product.ProductMainVo;
import com.techsoft.entity.product.ProductMainParamVo;

public interface ClientProductMainService extends BaseClientService<ProductMain> {

	public ProductMainVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ProductMainVo> selectListVoByParamVo(ProductMainParamVo productMain, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ProductMainVo> selectPageVoByParamVo(ProductMainParamVo productMain, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ProductMainVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ProductMainVo> selectListExtendVoByParamVo(ProductMainParamVo productMain, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ProductMainVo> selectPageExtendVoByParamVo(ProductMainParamVo productMain, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ProductMainParamVo productMainParamVo, CommonParam commonParam);
	
	public ResultMessage synGospellMat() throws BusinessException, SQLException;
}
