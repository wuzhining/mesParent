package com.techsoft.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ProductPackbox;
import com.techsoft.dao.product.ProductPackboxDao;

@Service
public class ProductPackboxServiceImpl extends BaseServiceImpl<ProductPackbox> implements ProductPackboxService {
	@Autowired
	private ProductPackboxDao productPackboxDao;
	
	@Override
	public BaseDao<ProductPackbox> getBaseDao() {
		return productPackboxDao;
	}	
	
	@Override
	public Class<ProductPackbox> getEntityClass() {
		return ProductPackbox.class;
	}
	
	@Override
	protected ProductPackbox insertEntity(ProductPackbox entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ProductPackbox updatePartEntity(ProductPackbox entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ProductPackbox updateEntity(ProductPackbox entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
