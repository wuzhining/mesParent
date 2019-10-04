package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructProcedure;
import com.techsoft.mapper.struct.StructProcedureMapper;

@Repository
public class StructProcedureDaoImpl extends BaseDaoImpl<StructProcedure> implements StructProcedureDao {
	@Resource
	protected StructProcedureMapper structProcedureMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<StructProcedure> getEntityClass() {
		return StructProcedure.class;
	}	
	
	@Override
	public BaseMapper<StructProcedure> getBaseMapper() {
		return this.structProcedureMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "STRUCT_PROCEDURE";
	}
	
	@Override
	public void insertSaveCheck(StructProcedure value) throws BusinessException, SQLException {
		if (value.getFactoryId() == null || value.getFactoryId().equals(0L)) {
			throw new BusinessException("工厂名称不能为空");
		}
		if (value.getProcessDictId() == null || value.getProcessDictId().equals(0L)) {
			throw new BusinessException("所属制程不能为空");
		}
		if (value.getProcedureCode() == null || value.getProcedureCode().equals(0L)) {
			throw new BusinessException("工序编码不能为空");
		}
		if (value.getProcedureName() == null || value.getProcedureName().equals(0L)) {
			throw new BusinessException("工序名称不能为空");
		}
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(StructProcedure value) throws BusinessException, SQLException {
		if (value.getFactoryId() == null || value.getFactoryId().equals(0L)) {
			throw new BusinessException("工厂名称不能为空");
		}
		if (value.getProcessDictId() == null || value.getProcessDictId().equals(0L)) {
			throw new BusinessException("所属制程不能为空");
		}
		if (value.getProcedureCode() == null || value.getProcedureCode().equals(0L)) {
			throw new BusinessException("工序编码不能为空");
		}
		if (value.getProcedureName() == null || value.getProcedureName().equals(0L)) {
			throw new BusinessException("工序名称不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(StructProcedure value) throws BusinessException, SQLException {
		throw new BusinessException("工序基础数据不能删除");
	}
			
}
