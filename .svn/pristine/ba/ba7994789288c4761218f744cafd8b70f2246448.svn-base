package com.techsoft.service.scada;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ScadaSpiRedgumPcb;
import com.techsoft.dao.scada.ScadaSpiRedgumPcbDao;

@Service
public class ScadaSpiRedgumPcbServiceImpl extends BaseServiceImpl<ScadaSpiRedgumPcb> implements ScadaSpiRedgumPcbService {
	@Autowired
	private ScadaSpiRedgumPcbDao scadaSpiRedgumPcbDao;
	
	@Override
	public BaseDao<ScadaSpiRedgumPcb> getBaseDao() {
		return scadaSpiRedgumPcbDao;
	}	
	
	@Override
	public Class<ScadaSpiRedgumPcb> getEntityClass() {
		return ScadaSpiRedgumPcb.class;
	}
	
	@Override
	protected ScadaSpiRedgumPcb insertEntity(ScadaSpiRedgumPcb entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ScadaSpiRedgumPcb updatePartEntity(ScadaSpiRedgumPcb entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ScadaSpiRedgumPcb updateEntity(ScadaSpiRedgumPcb entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
