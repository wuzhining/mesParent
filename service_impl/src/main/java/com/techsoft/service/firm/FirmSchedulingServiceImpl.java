package com.techsoft.service.firm;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.FirmScheduling;
import com.techsoft.dao.firm.FirmSchedulingDao;

@Service
public class FirmSchedulingServiceImpl extends BaseServiceImpl<FirmScheduling> implements FirmSchedulingService {
	@Autowired
	private FirmSchedulingDao firmSchedulingDao;
	
	@Override
	public BaseDao<FirmScheduling> getBaseDao() {
		return firmSchedulingDao;
	}	
	
	@Override
	public Class<FirmScheduling> getEntityClass() {
		return FirmScheduling.class;
	}
	
	@Override
	protected FirmScheduling insertEntity(FirmScheduling entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected FirmScheduling updatePartEntity(FirmScheduling entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected FirmScheduling updateEntity(FirmScheduling entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
