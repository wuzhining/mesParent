package com.techsoft.dao.scada;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ScadaAoi;
import com.techsoft.mapper.scada.ScadaAoiMapper;

@Repository
public class ScadaAoiDaoImpl extends BaseDaoImpl<ScadaAoi> implements ScadaAoiDao {
	@Resource
	protected ScadaAoiMapper scadaAoiMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ScadaAoi> getEntityClass() {
		return ScadaAoi.class;
	}	
	
	@Override
	public BaseMapper<ScadaAoi> getBaseMapper() {
		return this.scadaAoiMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "SCADA_AOI";
	}
	
	@Override
	public void insertSaveCheck(ScadaAoi value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ScadaAoi value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ScadaAoi value) throws BusinessException, SQLException {
	
	}
			
}
