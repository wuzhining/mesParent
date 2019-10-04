package com.techsoft.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ProductClasses;
import com.techsoft.dao.product.ProductClassesDao;

@Service
public class ProductClassesServiceImpl extends BaseServiceImpl<ProductClasses> implements ProductClassesService {
	@Autowired
	private ProductClassesDao productClassesDao;
	
	@Override
	public BaseDao<ProductClasses> getBaseDao() {
		return productClassesDao;
	}	
	
	@Override
	public Class<ProductClasses> getEntityClass() {
		return ProductClasses.class;
	}
	
	@Override
	protected ProductClasses insertEntity(ProductClasses entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ProductClasses updatePartEntity(ProductClasses entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ProductClasses updateEntity(ProductClasses entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
