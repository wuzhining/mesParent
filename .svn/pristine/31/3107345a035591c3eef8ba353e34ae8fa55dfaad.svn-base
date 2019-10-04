package com.techsoft.dao.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ProductLabel;
import com.techsoft.mapper.product.ProductLabelMapper;

@Repository
public class ProductLabelDaoImpl extends BaseDaoImpl<ProductLabel> implements ProductLabelDao {
	@Resource
	protected ProductLabelMapper productLabelMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ProductLabel> getEntityClass() {
		return ProductLabel.class;
	}	
	
	@Override
	public BaseMapper<ProductLabel> getBaseMapper() {
		return this.productLabelMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "PRODUCT_LABEL";
	}
	
	@Override
	public void insertSaveCheck(ProductLabel value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("请先登录 ");
		}
		if (value.getProductId() == null || value.getProductId().equals(0L)) {
			throw new BusinessException("物品不能为空 ");
		}
		if (value.getLabelId() == null || value.getLabelId().equals(0L)) {
			throw new BusinessException("模板标签不能为空 ");
		}
		if (value.getBarcodeRuleDictId()== null || value.getBarcodeRuleDictId().equals(0L)) {
			throw new BusinessException("条码规则类型不能为空 ");
		}
	}
	
	@Override
	public void updateSaveCheck(ProductLabel value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("请先登录 ");
		}
		if (value.getProductId() == null || value.getProductId().equals(0L)) {
			throw new BusinessException("物品不能为空 ");
		}
		if (value.getLabelId() == null || value.getLabelId().equals(0L)) {
			throw new BusinessException("模板标签不能为空 ");
		}
		if (value.getBarcodeRuleDictId()== null || value.getBarcodeRuleDictId().equals(0L)) {
			throw new BusinessException("条码规则类型不能为空 ");
		}
	}
	
	@Override
	public void deleteSaveCheck(ProductLabel value) throws BusinessException, SQLException {
	
	}
			
}
