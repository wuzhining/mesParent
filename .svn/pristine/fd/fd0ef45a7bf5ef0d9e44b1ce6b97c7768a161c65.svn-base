package com.techsoft.service.track;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.TrackFixture;
import com.techsoft.dao.track.TrackFixtureDao;

@Service
public class TrackFixtureServiceImpl extends BaseServiceImpl<TrackFixture> implements TrackFixtureService {
	@Autowired
	private TrackFixtureDao trackFixtureDao;
	
	@Override
	public BaseDao<TrackFixture> getBaseDao() {
		return trackFixtureDao;
	}	
	
	@Override
	public Class<TrackFixture> getEntityClass() {
		return TrackFixture.class;
	}
	
	@Override
	protected TrackFixture insertEntity(TrackFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected TrackFixture updatePartEntity(TrackFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected TrackFixture updateEntity(TrackFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
