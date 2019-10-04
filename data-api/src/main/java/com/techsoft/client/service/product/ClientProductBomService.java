package com.techsoft.client.service.product;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ProductBomZTree;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.ProductBom;
import com.techsoft.entity.product.ProductBomParamVo;
import com.techsoft.entity.product.ProductBomVo;

public interface ClientProductBomService extends BaseClientService<ProductBom> {

	public ProductBomVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ProductBomVo> selectListVoByParamVo(ProductBomParamVo productBom, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ProductBomVo> selectPageVoByParamVo(ProductBomParamVo productBom, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ProductBomVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<ProductBomVo> selectListExtendVoByParamVo(ProductBomParamVo productBom, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<ProductBomVo> selectPageExtendVoByParamVo(ProductBomParamVo productBom, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(ProductBomParamVo productBomVo, CommonParam commonParam);

	public List<ProductBomZTree> loadZtree(ProductBomParamVo productBomParamVo, CommonParam commonParam);
	
	public List<ProductBomVo> selectListBomTree(Long id, CommonParam commonParam);

	public ResultMessage synGospellBom() throws BusinessException, SQLException;
}
