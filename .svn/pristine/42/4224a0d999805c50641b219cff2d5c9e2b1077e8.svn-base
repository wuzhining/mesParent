package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructProcessProduct;
import com.techsoft.mapper.struct.StructProcessProductMapper;

@Repository
public class StructProcessProductDaoImpl extends BaseDaoImpl<StructProcessProduct> implements StructProcessProductDao {
	@Resource
	protected StructProcessProductMapper structProcessProductMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<StructProcessProduct> getEntityClass() {
		return StructProcessProduct.class;
	}	
	
	@Override
	public BaseMapper<StructProcessProduct> getBaseMapper() {
		return this.structProcessProductMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "STRUCT_PROCESS_PRODUCT";
	}
	
	@Override
	public void insertSaveCheck(StructProcessProduct value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(StructProcessProduct value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(StructProcessProduct value) throws BusinessException, SQLException {
	
	}
			
}
