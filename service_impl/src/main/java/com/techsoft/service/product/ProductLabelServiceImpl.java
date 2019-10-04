package com.techsoft.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ProductLabel;
import com.techsoft.dao.product.ProductLabelDao;

@Service
public class ProductLabelServiceImpl extends BaseServiceImpl<ProductLabel> implements ProductLabelService {
	@Autowired
	private ProductLabelDao productLabelDao;
	
	@Override
	public BaseDao<ProductLabel> getBaseDao() {
		return productLabelDao;
	}	
	
	@Override
	public Class<ProductLabel> getEntityClass() {
		return ProductLabel.class;
	}
	
	@Override
	protected ProductLabel insertEntity(ProductLabel entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ProductLabel updatePartEntity(ProductLabel entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ProductLabel updateEntity(ProductLabel entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
