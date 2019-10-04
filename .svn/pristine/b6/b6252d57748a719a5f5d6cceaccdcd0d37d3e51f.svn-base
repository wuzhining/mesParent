package com.techsoft.client.service.product;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ProductPackbox;
import com.techsoft.entity.product.ProductPackboxVo;
import com.techsoft.entity.product.ProductPackboxParamVo;

public interface ClientProductPackboxService extends BaseClientService<ProductPackbox> {

	public ProductPackboxVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ProductPackboxVo> selectListVoByParamVo(ProductPackboxParamVo productPackbox, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ProductPackboxVo> selectPageVoByParamVo(ProductPackboxParamVo productPackbox,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ProductPackboxVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ProductPackboxVo> selectListExtendVoByParamVo(ProductPackboxParamVo productPackbox,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<ProductPackboxVo> selectPageExtendVoByParamVo(ProductPackboxParamVo productPackbox,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ProductPackboxParamVo productPackboxParamVo, CommonParam commonParam);
}
