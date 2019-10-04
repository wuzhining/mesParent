package com.techsoft.dao.scada;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ScadaSpiRedgumPcb;
import com.techsoft.mapper.scada.ScadaSpiRedgumPcbMapper;

@Repository
public class ScadaSpiRedgumPcbDaoImpl extends BaseDaoImpl<ScadaSpiRedgumPcb> implements ScadaSpiRedgumPcbDao {
	@Resource
	protected ScadaSpiRedgumPcbMapper scadaSpiRedgumPcbMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ScadaSpiRedgumPcb> getEntityClass() {
		return ScadaSpiRedgumPcb.class;
	}	
	
	@Override
	public BaseMapper<ScadaSpiRedgumPcb> getBaseMapper() {
		return this.scadaSpiRedgumPcbMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "SCADA_SPI_REDGUM_PCB";
	}
	
	@Override
	public void insertSaveCheck(ScadaSpiRedgumPcb value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ScadaSpiRedgumPcb value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ScadaSpiRedgumPcb value) throws BusinessException, SQLException {
	
	}
			
}
