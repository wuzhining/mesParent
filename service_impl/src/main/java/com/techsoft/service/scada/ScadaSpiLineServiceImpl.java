package com.techsoft.service.scada;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ScadaSpiLine;
import com.techsoft.dao.scada.ScadaSpiLineDao;

@Service
public class ScadaSpiLineServiceImpl extends BaseServiceImpl<ScadaSpiLine> implements ScadaSpiLineService {
	@Autowired
	private ScadaSpiLineDao scadaSpiLineDao;
	
	@Override
	public BaseDao<ScadaSpiLine> getBaseDao() {
		return scadaSpiLineDao;
	}	
	
	@Override
	public Class<ScadaSpiLine> getEntityClass() {
		return ScadaSpiLine.class;
	}
	
	@Override
	protected ScadaSpiLine insertEntity(ScadaSpiLine entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ScadaSpiLine updatePartEntity(ScadaSpiLine entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ScadaSpiLine updateEntity(ScadaSpiLine entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
