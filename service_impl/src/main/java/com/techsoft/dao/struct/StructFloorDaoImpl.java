package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructFloor;
import com.techsoft.mapper.struct.StructFloorMapper;

@Repository
public class StructFloorDaoImpl extends BaseDaoImpl<StructFloor> implements StructFloorDao {
	@Resource
	protected StructFloorMapper structFloorMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;

	@Override
	public Class<StructFloor> getEntityClass() {
		return StructFloor.class;
	}

	@Override
	public BaseMapper<StructFloor> getBaseMapper() {
		return this.structFloorMapper;
	}

	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}

	@Override
	public String getTableName() {
		return "STRUCT_FLOOR";
	}

	@Override
	public void insertSaveCheck(StructFloor value) throws BusinessException, SQLException {
		if (value.getFactoryId() == null || value.getFactoryId().equals(0L)) {
			throw new BusinessException("工厂名称不能为空");
		}
		if (value.getFloorCode() == null || value.getFloorCode().equals(0L)) {
			throw new BusinessException("楼层编码不能为空");
		}
		if (value.getFloorName() == null || value.getFloorName().equals(0L)) {
			throw new BusinessException("楼层名称不能为空");
		}
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	}

	@Override
	public void updateSaveCheck(StructFloor value) throws BusinessException, SQLException {
		if (value.getFactoryId() == null || value.getFactoryId().equals(0L)) {
			throw new BusinessException("工厂名称不能为空");
		}
		if (value.getFloorCode() == null || value.getFloorCode().equals(0L)) {
			throw new BusinessException("楼层编码不能为空");
		}
		if (value.getFloorName() == null || value.getFloorName().equals(0L)) {
			throw new BusinessException("楼层名称不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}

	@Override
	public void deleteSaveCheck(StructFloor value) throws BusinessException, SQLException {
		throw new BusinessException("楼层基础数据不能删除");
	}

}
