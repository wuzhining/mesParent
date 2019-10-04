package com.techsoft.service.bill;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.BillFixture;
import com.techsoft.dao.bill.BillFixtureDao;

@Service
public class BillFixtureServiceImpl extends BaseServiceImpl<BillFixture> implements BillFixtureService {
	@Autowired
	private BillFixtureDao billFixtureDao;
	
	@Override
	public BaseDao<BillFixture> getBaseDao() {
		return billFixtureDao;
	}	
	
	@Override
	public Class<BillFixture> getEntityClass() {
		return BillFixture.class;
	}
	
	@Override
	protected BillFixture insertEntity(BillFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected BillFixture updatePartEntity(BillFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected BillFixture updateEntity(BillFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
