package com.techsoft.dao.product;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.ProductMain;

public interface ProductMainDao extends BaseDao<ProductMain> {
/**
*@auther:Wang
*@version:2019年7月23日下午1:59:03
*@param:
*@description 批量新增物品
*/
public void insertBatchProductMain(List<ProductMain> list) throws BusinessException, SQLException;

/**
*@auther:Wang
*@version:2019年7月23日下午2:00:19
*@param: 
*@description 根据编码查询物品
*/
public ProductMain selectByCode(String code) throws BusinessException, SQLException;
} 
