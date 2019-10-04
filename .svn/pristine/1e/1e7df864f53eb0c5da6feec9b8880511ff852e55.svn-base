package com.techsoft.dao.track;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.TrackPackbox;
import com.techsoft.mapper.track.TrackPackboxMapper;

@Repository
public class TrackPackboxDaoImpl extends BaseDaoImpl<TrackPackbox> implements TrackPackboxDao {
	@Resource
	protected TrackPackboxMapper trackPackboxMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<TrackPackbox> getEntityClass() {
		return TrackPackbox.class;
	}	
	
	@Override
	public BaseMapper<TrackPackbox> getBaseMapper() {
		return this.trackPackboxMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "TRACK_PACKBOX";
	}
	
	@Override
	public void insertSaveCheck(TrackPackbox value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(TrackPackbox value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(TrackPackbox value) throws BusinessException, SQLException {
	
	}
			
}
