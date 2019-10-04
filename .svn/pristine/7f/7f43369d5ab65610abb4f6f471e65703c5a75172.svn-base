package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructWarehouseLocation;
import com.techsoft.mapper.struct.StructWarehouseLocationMapper;

@Repository
public class StructWarehouseLocationDaoImpl extends BaseDaoImpl<StructWarehouseLocation> implements StructWarehouseLocationDao {
	@Resource
	protected StructWarehouseLocationMapper structWarehouseLocationMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<StructWarehouseLocation> getEntityClass() {
		return StructWarehouseLocation.class;
	}	
	
	@Override
	public BaseMapper<StructWarehouseLocation> getBaseMapper() {
		return this.structWarehouseLocationMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "STRUCT_WAREHOUSE_LOCATION";
	}
	
	@Override
	public void insertSaveCheck(StructWarehouseLocation value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
		if (value.getFactoryId() == null || value.getFactoryId().equals(0L)) {
			throw new BusinessException("工厂名称不能为空");
		}
		if (value.getWarehouseId() == null || value.getWarehouseId().equals(0L)) {
			throw new BusinessException("所属仓库不能为空");
		}
		if (value.getProductTypeDictId() == null || value.getProductTypeDictId().equals(0L)) {
			throw new BusinessException("物品类型不能为空");
		}
		if (value.getLocationCode() == null || value.getLocationCode().equals(0L)) {
			throw new BusinessException("货位编码不能为空");
		}
		if (value.getLocationName() == null || value.getLocationName().equals(0L)) {
			throw new BusinessException("货位名称不能为空");
		}
		 
	}
	
	@Override
	public void updateSaveCheck(StructWarehouseLocation value) throws BusinessException, SQLException {
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(StructWarehouseLocation value) throws BusinessException, SQLException {
		throw new BusinessException("货位基础数据不能删除");
	}
			
}
