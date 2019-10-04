package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.mapper.struct.StructWorkshopMapper;

@Repository
public class StructWorkshopDaoImpl extends BaseDaoImpl<StructWorkshop> implements StructWorkshopDao {
	@Resource
	protected StructWorkshopMapper structWorkshopMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;

	@Override
	public Class<StructWorkshop> getEntityClass() {
		return StructWorkshop.class;
	}

	@Override
	public BaseMapper<StructWorkshop> getBaseMapper() {
		return this.structWorkshopMapper;
	}

	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}

	@Override
	public String getTableName() {
		return "STRUCT_WORKSHOP";
	}

	@Override
	public void insertSaveCheck(StructWorkshop value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
		if (value.getFactoryId() == null || value.getFactoryId().equals(0L)) {
			throw new BusinessException("工厂名称不能为空");
		}
		if (value.getFloorId() == null || value.getFloorId().equals(0L)) {
			throw new BusinessException("所属楼层不能为空");
		}
		if (value.getWorkshopCode() == null || value.getWorkshopCode().equals(0L)) {
			throw new BusinessException("车间编码不能为空");
		}
		if (value.getWorkshopName() == null || value.getWorkshopName().equals(0L)) {
			throw new BusinessException("车间名称不能为空");
		}
	}

	@Override
	public void updateSaveCheck(StructWorkshop value) throws BusinessException, SQLException {
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}

	@Override
	public void deleteSaveCheck(StructWorkshop value) throws BusinessException, SQLException {
		throw new BusinessException("车间基础数据不能删除");
	}

}
