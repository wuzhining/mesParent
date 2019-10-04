package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.mapper.struct.StructWarehouseMapper;

@Repository
public class StructWarehouseDaoImpl extends BaseDaoImpl<StructWarehouse> implements StructWarehouseDao {
	@Resource
	protected StructWarehouseMapper structWarehouseMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;

	@Override
	public Class<StructWarehouse> getEntityClass() {
		return StructWarehouse.class;
	}

	@Override
	public BaseMapper<StructWarehouse> getBaseMapper() {
		return this.structWarehouseMapper;
	}

	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}

	@Override
	public String getTableName() {
		return "STRUCT_WAREHOUSE";
	}

	@Override
	public void insertSaveCheck(StructWarehouse value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
		if (value.getFactoryId() == null || value.getFactoryId().equals(0L)) {
			throw new BusinessException("工厂名称不能为空");
		}
		if (value.getFloorId() == null || value.getFloorId().equals(0L)) {
			throw new BusinessException("所属楼层不能为空");
		}
		if (value.getProductTypeDictId() == null || value.getProductTypeDictId().equals(0L)) {
			throw new BusinessException("物品类型不能为空");
		}
		if (value.getWarehouseCode() == null || value.getWarehouseCode().equals(0L)) {
			throw new BusinessException("仓库编码不能为空");
		}
		if (value.getWarehouseName() == null || value.getWarehouseName().equals(0L)) {
			throw new BusinessException("仓库名称不能为空");
		}
		if (value.getWarehouseTypeDictId() == null || value.getWarehouseTypeDictId().equals(0L)) {
			throw new BusinessException("仓库类型不能为空");
		}
	}

	@Override
	public void updateSaveCheck(StructWarehouse value) throws BusinessException, SQLException {
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}

	@Override
	public void deleteSaveCheck(StructWarehouse value) throws BusinessException, SQLException {
		throw new BusinessException("仓库基础数据不能删除");
	}

}
