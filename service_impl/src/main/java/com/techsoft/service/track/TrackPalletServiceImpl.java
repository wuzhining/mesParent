package com.techsoft.service.track;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.TrackPallet;
import com.techsoft.dao.track.TrackPalletDao;

@Service
public class TrackPalletServiceImpl extends BaseServiceImpl<TrackPallet> implements TrackPalletService {
	@Autowired
	private TrackPalletDao trackPalletDao;
	
	@Override
	public BaseDao<TrackPallet> getBaseDao() {
		return trackPalletDao;
	}	
	
	@Override
	public Class<TrackPallet> getEntityClass() {
		return TrackPallet.class;
	}
	
	@Override
	protected TrackPallet insertEntity(TrackPallet entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected TrackPallet updatePartEntity(TrackPallet entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected TrackPallet updateEntity(TrackPallet entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
