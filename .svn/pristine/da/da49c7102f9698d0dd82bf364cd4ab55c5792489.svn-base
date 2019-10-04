package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.mapper.struct.StructFactoryMapper;

@Repository
public class StructFactoryDaoImpl extends BaseDaoImpl<StructFactory> implements StructFactoryDao {
	@Resource
	protected StructFactoryMapper structFactoryMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;

	@Override
	public Class<StructFactory> getEntityClass() {
		return StructFactory.class;
	}

	@Override
	public BaseMapper<StructFactory> getBaseMapper() {
		return this.structFactoryMapper;
	}

	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}

	@Override
	public String getTableName() {
		return "STRUCT_FACTORY";
	}

	@Override
	public void insertSaveCheck(StructFactory value) throws BusinessException, SQLException {
		if (value.getFactoryCode() == null || value.getFactoryCode().equals(0L)) {
			throw new BusinessException("工厂编码不能为空");
		}
		if (value.getFactoryName() == null || value.getFactoryName().equals(0L)) {
			throw new BusinessException("工厂名称不能为空");
		}
		if (value.getFactoryTypeDictId() == null || value.getFactoryTypeDictId().equals(0L)) {
			throw new BusinessException("工厂类型不能为空");
		}
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	}

	@Override
	public void updateSaveCheck(StructFactory value) throws BusinessException, SQLException {
		if (value.getFactoryCode() == null || value.getFactoryCode().equals(0L)) {
			throw new BusinessException("工厂编码不能为空");
		}
		if (value.getFactoryName() == null || value.getFactoryName().equals(0L)) {
			throw new BusinessException("工厂名称不能为空");
		}
		if (value.getFactoryTypeDictId() == null || value.getFactoryTypeDictId().equals(0L)) {
			throw new BusinessException("工厂类型不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}

	@Override
	public void deleteSaveCheck(StructFactory value) throws BusinessException, SQLException {
		throw new BusinessException("工厂基础数据不能删除");
	}

}
