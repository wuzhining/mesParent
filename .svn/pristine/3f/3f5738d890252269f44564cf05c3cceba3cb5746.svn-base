package com.techsoft.service.bill;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.BillDelivery;
import com.techsoft.dao.bill.BillDeliveryDao;

@Service
public class BillDeliveryServiceImpl extends BaseServiceImpl<BillDelivery> implements BillDeliveryService {
	@Autowired
	private BillDeliveryDao billDeliveryDao;
	
	@Override
	public BaseDao<BillDelivery> getBaseDao() {
		return billDeliveryDao;
	}	
	
	@Override
	public Class<BillDelivery> getEntityClass() {
		return BillDelivery.class;
	}
	
	@Override
	protected BillDelivery insertEntity(BillDelivery entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected BillDelivery updatePartEntity(BillDelivery entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected BillDelivery updateEntity(BillDelivery entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
