package com.techsoft.service.firm;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.FirmPartner;
import com.techsoft.dao.firm.FirmPartnerDao;

@Service
public class FirmPartnerServiceImpl extends BaseServiceImpl<FirmPartner> implements FirmPartnerService {
	@Autowired
	private FirmPartnerDao firmPartnerDao;
	
	@Override
	public BaseDao<FirmPartner> getBaseDao() {
		return firmPartnerDao;
	}	
	
	@Override
	public Class<FirmPartner> getEntityClass() {
		return FirmPartner.class;
	}
	
	@Override
	protected FirmPartner insertEntity(FirmPartner entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected FirmPartner updatePartEntity(FirmPartner entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected FirmPartner updateEntity(FirmPartner entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
