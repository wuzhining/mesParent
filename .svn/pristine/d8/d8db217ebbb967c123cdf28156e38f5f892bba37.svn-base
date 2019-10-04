package com.techsoft.dao.scada;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ScadaSpiBarcode;
import com.techsoft.mapper.scada.ScadaSpiBarcodeMapper;

@Repository
public class ScadaSpiBarcodeDaoImpl extends BaseDaoImpl<ScadaSpiBarcode> implements ScadaSpiBarcodeDao {
	@Resource
	protected ScadaSpiBarcodeMapper scadaSpiBarcodeMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ScadaSpiBarcode> getEntityClass() {
		return ScadaSpiBarcode.class;
	}	
	
	@Override
	public BaseMapper<ScadaSpiBarcode> getBaseMapper() {
		return this.scadaSpiBarcodeMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "SCADA_SPI_BARCODE";
	}
	
	@Override
	public void insertSaveCheck(ScadaSpiBarcode value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ScadaSpiBarcode value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ScadaSpiBarcode value) throws BusinessException, SQLException {
	
	}
			
}
