package com.techsoft.service.scada;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ScadaAoiCatalog;
import com.techsoft.dao.scada.ScadaAoiCatalogDao;

@Service
public class ScadaAoiCatalogServiceImpl extends BaseServiceImpl<ScadaAoiCatalog> implements ScadaAoiCatalogService {
	@Autowired
	private ScadaAoiCatalogDao scadaAoiCatalogDao;
	
	@Override
	public BaseDao<ScadaAoiCatalog> getBaseDao() {
		return scadaAoiCatalogDao;
	}	
	
	@Override
	public Class<ScadaAoiCatalog> getEntityClass() {
		return ScadaAoiCatalog.class;
	}
	
	@Override
	protected ScadaAoiCatalog insertEntity(ScadaAoiCatalog entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ScadaAoiCatalog updatePartEntity(ScadaAoiCatalog entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ScadaAoiCatalog updateEntity(ScadaAoiCatalog entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
