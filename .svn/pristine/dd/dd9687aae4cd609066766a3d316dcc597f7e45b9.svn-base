package com.techsoft.service.track;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.TrackBarcodeUnpack;
import com.techsoft.dao.track.TrackBarcodeUnpackDao;

@Service
public class TrackBarcodeUnpackServiceImpl extends BaseServiceImpl<TrackBarcodeUnpack> implements TrackBarcodeUnpackService {
	@Autowired
	private TrackBarcodeUnpackDao trackBarcodeUnpackDao;
	
	@Override
	public BaseDao<TrackBarcodeUnpack> getBaseDao() {
		return trackBarcodeUnpackDao;
	}	
	
	@Override
	public Class<TrackBarcodeUnpack> getEntityClass() {
		return TrackBarcodeUnpack.class;
	}
	
	@Override
	protected TrackBarcodeUnpack insertEntity(TrackBarcodeUnpack entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected TrackBarcodeUnpack updatePartEntity(TrackBarcodeUnpack entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected TrackBarcodeUnpack updateEntity(TrackBarcodeUnpack entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
