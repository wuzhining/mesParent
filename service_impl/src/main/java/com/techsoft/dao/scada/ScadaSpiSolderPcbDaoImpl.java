package com.techsoft.dao.scada;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ScadaSpiSolderPcb;
import com.techsoft.mapper.scada.ScadaSpiSolderPcbMapper;

@Repository
public class ScadaSpiSolderPcbDaoImpl extends BaseDaoImpl<ScadaSpiSolderPcb> implements ScadaSpiSolderPcbDao {
	@Resource
	protected ScadaSpiSolderPcbMapper scadaSpiSolderPcbMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ScadaSpiSolderPcb> getEntityClass() {
		return ScadaSpiSolderPcb.class;
	}	
	
	@Override
	public BaseMapper<ScadaSpiSolderPcb> getBaseMapper() {
		return this.scadaSpiSolderPcbMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "SCADA_SPI_SOLDER_PCB";
	}
	
	@Override
	public void insertSaveCheck(ScadaSpiSolderPcb value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ScadaSpiSolderPcb value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ScadaSpiSolderPcb value) throws BusinessException, SQLException {
	
	}
			
}
