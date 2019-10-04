package com.techsoft.dao.scada;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ScadaAoiCatalog;
import com.techsoft.mapper.scada.ScadaAoiCatalogMapper;

@Repository
public class ScadaAoiCatalogDaoImpl extends BaseDaoImpl<ScadaAoiCatalog> implements ScadaAoiCatalogDao {
	@Resource
	protected ScadaAoiCatalogMapper scadaAoiCatalogMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ScadaAoiCatalog> getEntityClass() {
		return ScadaAoiCatalog.class;
	}	
	
	@Override
	public BaseMapper<ScadaAoiCatalog> getBaseMapper() {
		return this.scadaAoiCatalogMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "SCADA_AOI_CATALOG";
	}
	
	@Override
	public void insertSaveCheck(ScadaAoiCatalog value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ScadaAoiCatalog value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ScadaAoiCatalog value) throws BusinessException, SQLException {
	
	}
			
}
