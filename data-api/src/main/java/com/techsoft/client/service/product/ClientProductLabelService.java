package com.techsoft.client.service.product;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ProductLabel;
import com.techsoft.entity.product.ProductLabelVo;
import com.techsoft.entity.product.ProductLabelParamVo;

public interface ClientProductLabelService extends BaseClientService<ProductLabel> {

	public ProductLabelVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ProductLabelVo> selectListVoByParamVo(ProductLabelParamVo productLabel, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ProductLabelVo> selectPageVoByParamVo(ProductLabelParamVo productLabel, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ProductLabelVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ProductLabelVo> selectListExtendVoByParamVo(ProductLabelParamVo productLabel, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ProductLabelVo> selectPageExtendVoByParamVo(ProductLabelParamVo productLabel,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ProductLabelParamVo productLabelParamVo, CommonParam commonParam);
}
