package com.techsoft.client.service.product;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ProductClasses;
import com.techsoft.entity.product.ProductClassesVo;
import com.techsoft.entity.product.ProductClassesParamVo;

public interface ClientProductClassesService extends BaseClientService<ProductClasses> {

	public ProductClassesVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ProductClassesVo> selectListVoByParamVo(ProductClassesParamVo productClasses, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ProductClassesVo> selectPageVoByParamVo(ProductClassesParamVo productClasses,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ProductClassesVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ProductClassesVo> selectListExtendVoByParamVo(ProductClassesParamVo productClasses,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ProductClassesVo> selectPageExtendVoByParamVo(ProductClassesParamVo productClasses,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ProductClassesParamVo productClassesParamVo, CommonParam commonParam);
}
