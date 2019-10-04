package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.mapper.struct.StructWorkstationMapper;

@Repository
public class StructWorkstationDaoImpl extends BaseDaoImpl<StructWorkstation> implements StructWorkstationDao {
	@Resource
	protected StructWorkstationMapper structWorkstationMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<StructWorkstation> getEntityClass() {
		return StructWorkstation.class;
	}	
	
	@Override
	public BaseMapper<StructWorkstation> getBaseMapper() {
		return this.structWorkstationMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "STRUCT_WORKSTATION";
	}
	
	@Override
	public void insertSaveCheck(StructWorkstation value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
		if (value.getFactoryId() == null || value.getFactoryId().equals(0L)) {
			throw new BusinessException("工厂名称不能为空");
		}
		if (value.getWorkstationCode()== null || value.getWorkstationCode().equals(0L)) {
			throw new BusinessException("工站编码不能为空");
		}
		if (value.getWorkstationName()== null || value.getWorkstationName().equals(0L)) {
			throw new BusinessException("工站名称不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(StructWorkstation value) throws BusinessException, SQLException {
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(StructWorkstation value) throws BusinessException, SQLException {
		throw new BusinessException("工站基础数据不能删除");
	}
			
}
