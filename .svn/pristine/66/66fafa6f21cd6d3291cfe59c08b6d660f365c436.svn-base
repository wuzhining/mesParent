package com.techsoft.client.service.product;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ProductBomItemRepalce;
import com.techsoft.entity.product.ProductBomItemRepalceVo;
import com.techsoft.entity.product.ProductBomItemRepalceParamVo;

public interface ClientProductBomItemRepalceService extends BaseClientService<ProductBomItemRepalce> {
	
	public ProductBomItemRepalceVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ProductBomItemRepalceVo>  selectListVoByParamVo(ProductBomItemRepalceParamVo productBomItemRepalce, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ProductBomItemRepalceVo>  selectPageVoByParamVo(ProductBomItemRepalceParamVo productBomItemRepalce, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ProductBomItemRepalceVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ProductBomItemRepalceVo>  selectListExtendVoByParamVo(ProductBomItemRepalceParamVo productBomItemRepalce, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ProductBomItemRepalceVo>  selectPageExtendVoByParamVo(ProductBomItemRepalceParamVo productBomItemRepalce, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ProductBomItemRepalceParamVo productBomItemRepalceParamVo, CommonParam commonParam);		
}
