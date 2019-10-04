package com.techsoft.dao.scada;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ScadaSpiLine;
import com.techsoft.mapper.scada.ScadaSpiLineMapper;

@Repository
public class ScadaSpiLineDaoImpl extends BaseDaoImpl<ScadaSpiLine> implements ScadaSpiLineDao {
	@Resource
	protected ScadaSpiLineMapper scadaSpiLineMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ScadaSpiLine> getEntityClass() {
		return ScadaSpiLine.class;
	}	
	
	@Override
	public BaseMapper<ScadaSpiLine> getBaseMapper() {
		return this.scadaSpiLineMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "SCADA_SPI_LINE";
	}
	
	@Override
	public void insertSaveCheck(ScadaSpiLine value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ScadaSpiLine value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ScadaSpiLine value) throws BusinessException, SQLException {
	
	}
			
}
