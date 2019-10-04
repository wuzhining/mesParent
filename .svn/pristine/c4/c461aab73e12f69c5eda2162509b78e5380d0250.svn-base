package com.techsoft.dao.track;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.TrackMaterial;
import com.techsoft.mapper.track.TrackMaterialMapper;

@Repository
public class TrackMaterialDaoImpl extends BaseDaoImpl<TrackMaterial> implements TrackMaterialDao {
	@Resource
	protected TrackMaterialMapper trackMaterialMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<TrackMaterial> getEntityClass() {
		return TrackMaterial.class;
	}	
	
	@Override
	public BaseMapper<TrackMaterial> getBaseMapper() {
		return this.trackMaterialMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "TRACK_MATERIAL";
	}
	
	@Override
	public void insertSaveCheck(TrackMaterial value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(TrackMaterial value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(TrackMaterial value) throws BusinessException, SQLException {
	
	}
			
}
