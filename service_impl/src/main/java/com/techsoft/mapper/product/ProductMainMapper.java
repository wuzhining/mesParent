package com.techsoft.mapper.product;

import java.util.List;

import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.ProductMain;

public interface ProductMainMapper extends BaseMapper<ProductMain> {
	public void insertBatchProductMain(List<ProductMain> list) throws BusinessException, SQLException;
	public ProductMain selectByCode(String code) throws BusinessException, SQLException;
}
