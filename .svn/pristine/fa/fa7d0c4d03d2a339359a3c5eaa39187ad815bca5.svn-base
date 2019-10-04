package com.techsoft.dao.track;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.TrackFixture;
import com.techsoft.mapper.track.TrackFixtureMapper;

@Repository
public class TrackFixtureDaoImpl extends BaseDaoImpl<TrackFixture> implements TrackFixtureDao {
	@Resource
	protected TrackFixtureMapper trackFixtureMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<TrackFixture> getEntityClass() {
		return TrackFixture.class;
	}	
	
	@Override
	public BaseMapper<TrackFixture> getBaseMapper() {
		return this.trackFixtureMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "TRACK_FIXTURE";
	}
	
	@Override
	public void insertSaveCheck(TrackFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(TrackFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(TrackFixture value) throws BusinessException, SQLException {
	
	}
			
}
