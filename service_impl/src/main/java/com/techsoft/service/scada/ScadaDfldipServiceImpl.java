package com.techsoft.service.scada;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ScadaDfldip;
import com.techsoft.dao.scada.ScadaDfldipDao;

@Service
public class ScadaDfldipServiceImpl extends BaseServiceImpl<ScadaDfldip> implements ScadaDfldipService {
	@Autowired
	private ScadaDfldipDao scadaDfldipDao;
	
	@Override
	public BaseDao<ScadaDfldip> getBaseDao() {
		return scadaDfldipDao;
	}	
	
	@Override
	public Class<ScadaDfldip> getEntityClass() {
		return ScadaDfldip.class;
	}
	
	@Override
	protected ScadaDfldip insertEntity(ScadaDfldip entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ScadaDfldip updatePartEntity(ScadaDfldip entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ScadaDfldip updateEntity(ScadaDfldip entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
