package com.techsoft.service.scada;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ScadaAoiVersion;
import com.techsoft.dao.scada.ScadaAoiVersionDao;

@Service
public class ScadaAoiVersionServiceImpl extends BaseServiceImpl<ScadaAoiVersion> implements ScadaAoiVersionService {
	@Autowired
	private ScadaAoiVersionDao scadaAoiVersionDao;
	
	@Override
	public BaseDao<ScadaAoiVersion> getBaseDao() {
		return scadaAoiVersionDao;
	}	
	
	@Override
	public Class<ScadaAoiVersion> getEntityClass() {
		return ScadaAoiVersion.class;
	}
	
	@Override
	protected ScadaAoiVersion insertEntity(ScadaAoiVersion entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ScadaAoiVersion updatePartEntity(ScadaAoiVersion entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ScadaAoiVersion updateEntity(ScadaAoiVersion entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
