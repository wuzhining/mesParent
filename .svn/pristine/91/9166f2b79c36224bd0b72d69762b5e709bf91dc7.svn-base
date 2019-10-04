package com.techsoft.dao.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.mapper.product.ProductMaterialMapper;

@Repository
public class ProductMaterialDaoImpl extends BaseDaoImpl<ProductMaterial> implements ProductMaterialDao {
	@Resource
	protected ProductMaterialMapper productMaterialMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ProductMaterial> getEntityClass() {
		return ProductMaterial.class;
	}	
	
	@Override
	public BaseMapper<ProductMaterial> getBaseMapper() {
		return this.productMaterialMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "PRODUCT_MATERIAL";
	}
	
	@Override
	public void insertSaveCheck(ProductMaterial value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("请先登录 ");
		}
		if (value.getSupplierId() == null || value.getSupplierId().equals(0L)) {
			throw new BusinessException("供应商不能为空 ");
		}
		if (value.getMaterialCode() == null || value.getMaterialCode().length()>32) {
			throw new BusinessException("物料编码不能为空 ");
		}
		if (value.getProductTypeDictId() == null || value.getProductTypeDictId().equals(0L)) {
			throw new BusinessException("物品类型不能为空 ");
		}
		if (value.getMaterialName() == null || value.getMaterialName().length()>64) {
			throw new BusinessException("物料名称不能为空 ");
		}
		if (value.getMaterialStatusDictId() == null || value.getMaterialStatusDictId().equals(0L)) {
			throw new BusinessException("实物状态不能为空 ");
		}
		if (value.getProductId() == null || value.getProductId().equals(0L)) {
			throw new BusinessException("物品不能为空 ");
		}
		/*if (value.getVolume() == null) {
			throw new BusinessException("体积限制不能为空 ");
		}
		if (value.getWeight() == null ) {
			throw new BusinessException("重量限制不能为空 ");
		}
		if (value.getSizeLength() == null ) {
			throw new BusinessException("尺寸-长不能为空 ");
		}
		if (value.getSizeHeight() == null ) {
			throw new BusinessException("尺寸-高不能为空");
		}
		if (value.getSizeWidth() == null ) {
			throw new BusinessException("尺寸-宽不能为空");
		}
		if (value.getQuantityStock()== null ) {
			throw new BusinessException("库存数量不能为空 ");
		}
		if (value.getWeekCode()== null ) {
			throw new BusinessException("周数不能为空 ");
		}*/
	}
	
	@Override
	public void updateSaveCheck(ProductMaterial value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("请先登录 ");
		}
		if (value.getSupplierId() == null || value.getSupplierId().equals(0L)) {
			throw new BusinessException("供应商不能为空 ");
		}
		if (value.getMaterialCode() == null || value.getMaterialCode().length()>32) {
			throw new BusinessException("物料编码不能为空 ");
		}
		if (value.getProductTypeDictId() == null || value.getProductTypeDictId().equals(0L)) {
			throw new BusinessException("物品类型不能为空 ");
		}
		if (value.getMaterialName() == null || value.getMaterialName().length()>64) {
			throw new BusinessException("物料名称不能为空 ");
		}
		if (value.getMaterialStatusDictId() == null || value.getMaterialStatusDictId().equals(0L)) {
			throw new BusinessException("实物状态不能为空 ");
		}
		/*if (value.getVolume() == null) {
			throw new BusinessException("体积限制不能为空 ");
		}
		if (value.getWeight() == null ) {
			throw new BusinessException("重量限制不能为空 ");
		}
		if (value.getSizeLength() == null ) {
			throw new BusinessException("尺寸-长不能为空 ");
		}
		if (value.getSizeHeight() == null ) {
			throw new BusinessException("尺寸-高不能为空");
		}
		if (value.getSizeWidth() == null ) {
			throw new BusinessException("尺寸-宽不能为空");
		}
		if (value.getProductId() == null || value.getProductId().equals(0L)) {
			throw new BusinessException("物品不能为空 ");
		}
		if (value.getQuantityStock()== null ) {
			throw new BusinessException("库存数量不能为空 ");
		}
		if (value.getWeekCode()== null ) {
			throw new BusinessException("周数不能为空 ");
		}*/
	}
	
	@Override
	public void deleteSaveCheck(ProductMaterial value) throws BusinessException, SQLException {
	
	}

	@Override
	public void insertBatchProductMat(List<ProductMaterial> list) throws BusinessException, SQLException {
		productMaterialMapper.insertBatchProductMat(list);
	}

	@Override
	public ProductMaterial selectByCode(String code) throws BusinessException, SQLException {
		ProductMaterial productMaterial=productMaterialMapper.selectByCode(code);
		return productMaterial;
	}
			
}
