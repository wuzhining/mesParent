package com.techsoft.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.dao.product.ProductMaterialDao;

@Service
public class ProductMaterialServiceImpl extends BaseServiceImpl<ProductMaterial> implements ProductMaterialService {
	@Autowired
	private ProductMaterialDao productMaterialDao;
	
	@Override
	public BaseDao<ProductMaterial> getBaseDao() {
		return productMaterialDao;
	}	
	
	@Override
	public Class<ProductMaterial> getEntityClass() {
		return ProductMaterial.class;
	}
	
	@Override
	protected ProductMaterial insertEntity(ProductMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ProductMaterial updatePartEntity(ProductMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ProductMaterial updateEntity(ProductMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
