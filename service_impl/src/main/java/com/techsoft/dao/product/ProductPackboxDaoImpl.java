package com.techsoft.dao.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ProductPackbox;
import com.techsoft.mapper.product.ProductPackboxMapper;

@Repository
public class ProductPackboxDaoImpl extends BaseDaoImpl<ProductPackbox> implements ProductPackboxDao {
	@Resource
	protected ProductPackboxMapper productPackboxMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ProductPackbox> getEntityClass() {
		return ProductPackbox.class;
	}	
	
	@Override
	public BaseMapper<ProductPackbox> getBaseMapper() {
		return this.productPackboxMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "PRODUCT_PACKBOX";
	}
	
	@Override
	public void insertSaveCheck(ProductPackbox value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("请先登录 ");
		}
 
		if (value.getPackboxName() == null  ) {
			throw new BusinessException("包装箱规格名称不能为空 ");
		}
		if(value.getPackboxName().length()>64){
			throw new BusinessException("包装箱规格名称不能超过64位");
		}
		if (value.getProductId() == null || value.getProductId().equals(0L)) {
			throw new BusinessException("物品不能为空 ");
		}
		if (value.getMaterialId() == null || value.getMaterialId().equals(0L)) {
			throw new BusinessException("物料不能为空 ");
		}
		if (value.getQuantityMain() == null  ) {
			throw new BusinessException("主单位数量不能为空 ");
		}
		if (value.getQuantityPack() == null || value.getQuantityPack() ==0 ) {
			throw new BusinessException("包装数量不能为空或0 ");
		}
		if(value.getIsInner().equals("1")){//选择是有内包装数时
			 if (value.getQuantityInner() == null || value.getQuantityInner()==0) {
				 throw new BusinessException("内包装数量不能为空或0 ");
			 }
		 }
		 
		if (value.getRemark() != null ) {
			if(value.getRemark().length()>128){
				throw new BusinessException("备注不能超过128个字符");
			}
		} 
	}
	
	@Override
	public void updateSaveCheck(ProductPackbox value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("请先登录 ");
		}
		 
		if (value.getPackboxName() == null  ) {
			throw new BusinessException("包装箱名称不能为空 ");
		}
		if(value.getPackboxName().length()>64){
			throw new BusinessException("包装箱名称不能超过64位");
		}
		 
		if (value.getProductId() == null || value.getProductId().equals(0L)) {
			throw new BusinessException("物品不能为空 ");
		}
		if (value.getMaterialId() == null || value.getMaterialId().equals(0L)) {
			throw new BusinessException("物料不能为空 ");
		}
		if (value.getQuantityMain() == null  ) {
			throw new BusinessException("主单位数量不能为空 ");
		}
		if (value.getQuantityPack() == null || value.getQuantityPack() ==0 ) {
			throw new BusinessException("包装数量不能为空或0 ");
		}
		 
		if(value.getIsInner().equals("1")){//选择是有内包装数时
			 if (value.getQuantityInner() == null || value.getQuantityInner()==0) {
				 throw new BusinessException("内包装数量不能为空或0 ");
			 }
		 }
		if (value.getRemark() != null ) {
			if(value.getRemark().length()>128){
				throw new BusinessException("备注不能超过128个字符");
			}
		}
	}
	
	@Override
	public void deleteSaveCheck(ProductPackbox value) throws BusinessException, SQLException {
	
	}
			
}
