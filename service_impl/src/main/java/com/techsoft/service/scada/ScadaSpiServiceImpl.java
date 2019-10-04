package com.techsoft.service.scada;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ScadaSpi;
import com.techsoft.dao.scada.ScadaSpiDao;

@Service
public class ScadaSpiServiceImpl extends BaseServiceImpl<ScadaSpi> implements ScadaSpiService {
	@Autowired
	private ScadaSpiDao scadaSpiDao;
	
	@Override
	public BaseDao<ScadaSpi> getBaseDao() {
		return scadaSpiDao;
	}	
	
	@Override
	public Class<ScadaSpi> getEntityClass() {
		return ScadaSpi.class;
	}
	
	@Override
	protected ScadaSpi insertEntity(ScadaSpi entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ScadaSpi updatePartEntity(ScadaSpi entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ScadaSpi updateEntity(ScadaSpi entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
