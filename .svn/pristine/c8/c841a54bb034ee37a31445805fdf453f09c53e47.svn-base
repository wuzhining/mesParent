package com.techsoft.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ProductBomItemRepalce;
import com.techsoft.dao.product.ProductBomItemRepalceDao;

@Service
public class ProductBomItemRepalceServiceImpl extends BaseServiceImpl<ProductBomItemRepalce> implements ProductBomItemRepalceService {
	@Autowired
	private ProductBomItemRepalceDao productBomItemRepalceDao;
	
	@Override
	public BaseDao<ProductBomItemRepalce> getBaseDao() {
		return productBomItemRepalceDao;
	}	
	
	@Override
	public Class<ProductBomItemRepalce> getEntityClass() {
		return ProductBomItemRepalce.class;
	}
	
	@Override
	protected ProductBomItemRepalce insertEntity(ProductBomItemRepalce entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ProductBomItemRepalce updatePartEntity(ProductBomItemRepalce entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ProductBomItemRepalce updateEntity(ProductBomItemRepalce entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
