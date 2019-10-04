package com.techsoft.service.scada;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ScadaSpiSolderPcb;
import com.techsoft.dao.scada.ScadaSpiSolderPcbDao;

@Service
public class ScadaSpiSolderPcbServiceImpl extends BaseServiceImpl<ScadaSpiSolderPcb> implements ScadaSpiSolderPcbService {
	@Autowired
	private ScadaSpiSolderPcbDao scadaSpiSolderPcbDao;
	
	@Override
	public BaseDao<ScadaSpiSolderPcb> getBaseDao() {
		return scadaSpiSolderPcbDao;
	}	
	
	@Override
	public Class<ScadaSpiSolderPcb> getEntityClass() {
		return ScadaSpiSolderPcb.class;
	}
	
	@Override
	protected ScadaSpiSolderPcb insertEntity(ScadaSpiSolderPcb entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ScadaSpiSolderPcb updatePartEntity(ScadaSpiSolderPcb entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ScadaSpiSolderPcb updateEntity(ScadaSpiSolderPcb entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
