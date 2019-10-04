package com.techsoft.dao.barcode;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.BarcodeBatchNumber;
import com.techsoft.mapper.barcode.BarcodeBatchNumberMapper;

@Repository
public class BarcodeBatchNumberDaoImpl extends BaseDaoImpl<BarcodeBatchNumber> implements BarcodeBatchNumberDao {
	@Resource
	protected BarcodeBatchNumberMapper barcodeBatchNumberMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<BarcodeBatchNumber> getEntityClass() {
		return BarcodeBatchNumber.class;
	}	
	
	@Override
	public BaseMapper<BarcodeBatchNumber> getBaseMapper() {
		return this.barcodeBatchNumberMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "BARCODE_BATCH_NUMBER";
	}
	
	@Override
	public void insertSaveCheck(BarcodeBatchNumber value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(BarcodeBatchNumber value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(BarcodeBatchNumber value) throws BusinessException, SQLException {
	
	}
			
}
