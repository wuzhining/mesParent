package com.techsoft.service.track;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.TrackMaterial;
import com.techsoft.dao.track.TrackMaterialDao;

@Service
public class TrackMaterialServiceImpl extends BaseServiceImpl<TrackMaterial> implements TrackMaterialService {
	@Autowired
	private TrackMaterialDao trackMaterialDao;
	
	@Override
	public BaseDao<TrackMaterial> getBaseDao() {
		return trackMaterialDao;
	}	
	
	@Override
	public Class<TrackMaterial> getEntityClass() {
		return TrackMaterial.class;
	}
	
	@Override
	protected TrackMaterial insertEntity(TrackMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected TrackMaterial updatePartEntity(TrackMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected TrackMaterial updateEntity(TrackMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
