package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.mapper.struct.StructWorkshopAreaMapper;

@Repository
public class StructWorkshopAreaDaoImpl extends BaseDaoImpl<StructWorkshopArea> implements StructWorkshopAreaDao {
	@Resource
	protected StructWorkshopAreaMapper structWorkshopAreaMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<StructWorkshopArea> getEntityClass() {
		return StructWorkshopArea.class;
	}	
	
	@Override
	public BaseMapper<StructWorkshopArea> getBaseMapper() {
		return this.structWorkshopAreaMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "STRUCT_WORKSHOP_AREA";
	}
	
	@Override
	public void insertSaveCheck(StructWorkshopArea value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
		if (value.getFactoryId() == null || value.getFactoryId().equals(0L)) {
			throw new BusinessException("工厂名称不能为空");
		}
		if (value.getWorkshopId() == null || value.getWorkshopId().equals(0L)) {
			throw new BusinessException("所属车间不能为空");
		}
		if (value.getAreaCode() == null || value.getAreaCode().equals(0L)) {
			throw new BusinessException("区域编码不能为空");
		}
		if (value.getAreaName() == null || value.getAreaName().equals(0L)) {
			throw new BusinessException("区域名称不能为空");
		}
		 
	}
	
	@Override
	public void updateSaveCheck(StructWorkshopArea value) throws BusinessException, SQLException {
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(StructWorkshopArea value) throws BusinessException, SQLException {
		throw new BusinessException("区域基础数据不能删除");
	}
			
}
