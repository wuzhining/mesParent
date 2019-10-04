package com.techsoft.service.track;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.TrackPackbox;
import com.techsoft.dao.track.TrackPackboxDao;

@Service
public class TrackPackboxServiceImpl extends BaseServiceImpl<TrackPackbox> implements TrackPackboxService {
	@Autowired
	private TrackPackboxDao trackPackboxDao;
	
	@Override
	public BaseDao<TrackPackbox> getBaseDao() {
		return trackPackboxDao;
	}	
	
	@Override
	public Class<TrackPackbox> getEntityClass() {
		return TrackPackbox.class;
	}
	
	@Override
	protected TrackPackbox insertEntity(TrackPackbox entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected TrackPackbox updatePartEntity(TrackPackbox entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected TrackPackbox updateEntity(TrackPackbox entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
