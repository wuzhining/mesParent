package com.techsoft.dao.scada;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ScadaAoiEntity;
import com.techsoft.mapper.scada.ScadaAoiEntityMapper;

@Repository
public class ScadaAoiEntityDaoImpl extends BaseDaoImpl<ScadaAoiEntity> implements ScadaAoiEntityDao {
	@Resource
	protected ScadaAoiEntityMapper scadaAoiEntityMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ScadaAoiEntity> getEntityClass() {
		return ScadaAoiEntity.class;
	}	
	
	@Override
	public BaseMapper<ScadaAoiEntity> getBaseMapper() {
		return this.scadaAoiEntityMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "SCADA_AOI_ENTITY";
	}
	
	@Override
	public void insertSaveCheck(ScadaAoiEntity value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ScadaAoiEntity value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ScadaAoiEntity value) throws BusinessException, SQLException {
	
	}
			
}
