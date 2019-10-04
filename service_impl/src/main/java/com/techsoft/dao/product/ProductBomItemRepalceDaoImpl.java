package com.techsoft.dao.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ProductBomItemRepalce;
import com.techsoft.mapper.product.ProductBomItemRepalceMapper;

@Repository
public class ProductBomItemRepalceDaoImpl extends BaseDaoImpl<ProductBomItemRepalce> implements ProductBomItemRepalceDao {
	@Resource
	protected ProductBomItemRepalceMapper productBomItemRepalceMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ProductBomItemRepalce> getEntityClass() {
		return ProductBomItemRepalce.class;
	}	
	
	@Override
	public BaseMapper<ProductBomItemRepalce> getBaseMapper() {
		return this.productBomItemRepalceMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "PRODUCT_BOM_ITEM_REPALCE";
	}
	
	@Override
	public void insertSaveCheck(ProductBomItemRepalce value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ProductBomItemRepalce value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ProductBomItemRepalce value) throws BusinessException, SQLException {
	
	}
			
}
