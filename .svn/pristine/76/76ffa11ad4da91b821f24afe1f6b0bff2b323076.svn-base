package com.techsoft.service.bill;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.BillFixtureItem;
import com.techsoft.dao.bill.BillFixtureItemDao;

@Service
public class BillFixtureItemServiceImpl extends BaseServiceImpl<BillFixtureItem> implements BillFixtureItemService {
	@Autowired
	private BillFixtureItemDao billFixtureItemDao;
	
	@Override
	public BaseDao<BillFixtureItem> getBaseDao() {
		return billFixtureItemDao;
	}	
	
	@Override
	public Class<BillFixtureItem> getEntityClass() {
		return BillFixtureItem.class;
	}
	
	@Override
	protected BillFixtureItem insertEntity(BillFixtureItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected BillFixtureItem updatePartEntity(BillFixtureItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected BillFixtureItem updateEntity(BillFixtureItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
