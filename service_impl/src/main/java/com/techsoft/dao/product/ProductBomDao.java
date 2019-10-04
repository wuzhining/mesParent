package com.techsoft.dao.product;

import java.util.List;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.ProductBom;

public interface ProductBomDao extends BaseDao<ProductBom> {
	/**
	*@auther:Wang
	*@version:2019年7月23日下午1:59:03
	*@param:
	*@description 批量新增产品BOM
	*/
	public void insertBatchProductBom(List<ProductBom> list) throws BusinessException, SQLException;
	public List<ProductBom> selectListBomTree(Long id,CommonParam commonParam) throws BusinessException, SQLException;
	
}
