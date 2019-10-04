package com.techsoft.service.scada;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ScadaAoiEntity;
import com.techsoft.dao.scada.ScadaAoiEntityDao;

@Service
public class ScadaAoiEntityServiceImpl extends BaseServiceImpl<ScadaAoiEntity> implements ScadaAoiEntityService {
	@Autowired
	private ScadaAoiEntityDao scadaAoiEntityDao;
	
	@Override
	public BaseDao<ScadaAoiEntity> getBaseDao() {
		return scadaAoiEntityDao;
	}	
	
	@Override
	public Class<ScadaAoiEntity> getEntityClass() {
		return ScadaAoiEntity.class;
	}
	
	@Override
	protected ScadaAoiEntity insertEntity(ScadaAoiEntity entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ScadaAoiEntity updatePartEntity(ScadaAoiEntity entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ScadaAoiEntity updateEntity(ScadaAoiEntity entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
