package com.techsoft.service.scada;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ScadaAoi;
import com.techsoft.dao.scada.ScadaAoiDao;

@Service
public class ScadaAoiServiceImpl extends BaseServiceImpl<ScadaAoi> implements ScadaAoiService {
	@Autowired
	private ScadaAoiDao scadaAoiDao;
	
	@Override
	public BaseDao<ScadaAoi> getBaseDao() {
		return scadaAoiDao;
	}	
	
	@Override
	public Class<ScadaAoi> getEntityClass() {
		return ScadaAoi.class;
	}
	
	@Override
	protected ScadaAoi insertEntity(ScadaAoi entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ScadaAoi updatePartEntity(ScadaAoi entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ScadaAoi updateEntity(ScadaAoi entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
