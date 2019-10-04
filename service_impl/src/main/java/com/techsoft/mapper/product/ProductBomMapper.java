package com.techsoft.mapper.product;

import java.util.List;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.ProductBom;

public interface ProductBomMapper extends BaseMapper<ProductBom> {
	public void insertBatchProductBom(List<ProductBom> list) throws BusinessException, SQLException;
	public List<ProductBom> selectListBomTree(Long id) throws BusinessException, SQLException;
	
}
