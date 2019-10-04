package com.techsoft.dao.scada;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ScadaSpi;
import com.techsoft.mapper.scada.ScadaSpiMapper;

@Repository
public class ScadaSpiDaoImpl extends BaseDaoImpl<ScadaSpi> implements ScadaSpiDao {
	@Resource
	protected ScadaSpiMapper scadaSpiMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ScadaSpi> getEntityClass() {
		return ScadaSpi.class;
	}	
	
	@Override
	public BaseMapper<ScadaSpi> getBaseMapper() {
		return this.scadaSpiMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "SCADA_SPI";
	}
	
	@Override
	public void insertSaveCheck(ScadaSpi value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ScadaSpi value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ScadaSpi value) throws BusinessException, SQLException {
	
	}
			
}
