package com.techsoft.service.bill;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.BillPurchaseItem;
import com.techsoft.dao.bill.BillPurchaseItemDao;

@Service
public class BillPurchaseItemServiceImpl extends BaseServiceImpl<BillPurchaseItem> implements BillPurchaseItemService {
	@Autowired
	private BillPurchaseItemDao billPurchaseItemDao;
	
	@Override
	public BaseDao<BillPurchaseItem> getBaseDao() {
		return billPurchaseItemDao;
	}	
	
	@Override
	public Class<BillPurchaseItem> getEntityClass() {
		return BillPurchaseItem.class;
	}
	
	@Override
	protected BillPurchaseItem insertEntity(BillPurchaseItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected BillPurchaseItem updatePartEntity(BillPurchaseItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected BillPurchaseItem updateEntity(BillPurchaseItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
