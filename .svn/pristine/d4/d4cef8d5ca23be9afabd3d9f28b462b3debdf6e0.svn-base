package com.techsoft.dao.scada;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ScadaAoiVersion;
import com.techsoft.mapper.scada.ScadaAoiVersionMapper;

@Repository
public class ScadaAoiVersionDaoImpl extends BaseDaoImpl<ScadaAoiVersion> implements ScadaAoiVersionDao {
	@Resource
	protected ScadaAoiVersionMapper scadaAoiVersionMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ScadaAoiVersion> getEntityClass() {
		return ScadaAoiVersion.class;
	}	
	
	@Override
	public BaseMapper<ScadaAoiVersion> getBaseMapper() {
		return this.scadaAoiVersionMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "SCADA_AOI_VERSION";
	}
	
	@Override
	public void insertSaveCheck(ScadaAoiVersion value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ScadaAoiVersion value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ScadaAoiVersion value) throws BusinessException, SQLException {
	
	}
			
}
