package com.techsoft.dao.track;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.TrackPallet;
import com.techsoft.mapper.track.TrackPalletMapper;

@Repository
public class TrackPalletDaoImpl extends BaseDaoImpl<TrackPallet> implements TrackPalletDao {
	@Resource
	protected TrackPalletMapper trackPalletMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<TrackPallet> getEntityClass() {
		return TrackPallet.class;
	}	
	
	@Override
	public BaseMapper<TrackPallet> getBaseMapper() {
		return this.trackPalletMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "TRACK_PALLET";
	}
	
	@Override
	public void insertSaveCheck(TrackPallet value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(TrackPallet value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(TrackPallet value) throws BusinessException, SQLException {
	
	}
			
}
