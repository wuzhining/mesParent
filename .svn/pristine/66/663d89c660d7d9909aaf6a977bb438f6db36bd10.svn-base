package com.techsoft.service.scada;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ScadaAoiWindow;
import com.techsoft.dao.scada.ScadaAoiWindowDao;

@Service
public class ScadaAoiWindowServiceImpl extends BaseServiceImpl<ScadaAoiWindow> implements ScadaAoiWindowService {
	@Autowired
	private ScadaAoiWindowDao scadaAoiWindowDao;
	
	@Override
	public BaseDao<ScadaAoiWindow> getBaseDao() {
		return scadaAoiWindowDao;
	}	
	
	@Override
	public Class<ScadaAoiWindow> getEntityClass() {
		return ScadaAoiWindow.class;
	}
	
	@Override
	protected ScadaAoiWindow insertEntity(ScadaAoiWindow entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ScadaAoiWindow updatePartEntity(ScadaAoiWindow entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ScadaAoiWindow updateEntity(ScadaAoiWindow entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
