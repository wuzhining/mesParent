package com.techsoft.service.bill;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.BillSaleorderItem;
import com.techsoft.dao.bill.BillSaleorderItemDao;

@Service
public class BillSaleorderItemServiceImpl extends BaseServiceImpl<BillSaleorderItem> implements BillSaleorderItemService {
	@Autowired
	private BillSaleorderItemDao billSaleorderItemDao;
	
	@Override
	public BaseDao<BillSaleorderItem> getBaseDao() {
		return billSaleorderItemDao;
	}	
	
	@Override
	public Class<BillSaleorderItem> getEntityClass() {
		return BillSaleorderItem.class;
	}
	
	@Override
	protected BillSaleorderItem insertEntity(BillSaleorderItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected BillSaleorderItem updatePartEntity(BillSaleorderItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected BillSaleorderItem updateEntity(BillSaleorderItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
