package com.techsoft.dao.product;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.ProductMaterial;

public interface ProductMaterialDao extends BaseDao<ProductMaterial> {
	/**
	*@auther:Wang
	*@version:2019年7月23日下午2:12:53
	*@param: 
	*@description 批量新增物品规格
	*/
	public void insertBatchProductMat(List<ProductMaterial> list) throws BusinessException, SQLException;
	
	/**
	*@auther:Wang
	*@version:2019年7月23日下午2:00:19
	*@param: 
	*@description 根据编码查询物品规格
	*/
	public ProductMaterial selectByCode(String code) throws BusinessException, SQLException;
}
