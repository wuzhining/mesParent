package com.techsoft.client.service.product;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.entity.product.ProductMaterialParamVo;

public interface ClientProductMaterialService extends BaseClientService<ProductMaterial> {

	public ProductMaterialVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ProductMaterialVo> selectListVoByParamVo(ProductMaterialParamVo productMaterial,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ProductMaterialVo> selectPageVoByParamVo(ProductMaterialParamVo productMaterial,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ProductMaterialVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ProductMaterialVo> selectListExtendVoByParamVo(ProductMaterialParamVo productMaterial,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ProductMaterialVo> selectPageExtendVoByParamVo(ProductMaterialParamVo productMaterial,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ProductMaterialParamVo productMaterialParamVo, CommonParam commonParam);
	
	public ProductMaterial getVoByCode(String code, CommonParam commonParam) throws BusinessException, SQLException;
}
