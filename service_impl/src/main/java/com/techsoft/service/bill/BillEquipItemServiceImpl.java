package com.techsoft.service.bill;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.BillEquipItem;
import com.techsoft.dao.bill.BillEquipItemDao;

@Service
public class BillEquipItemServiceImpl extends BaseServiceImpl<BillEquipItem> implements BillEquipItemService {
	@Autowired
	private BillEquipItemDao billEquipItemDao;
	
	@Override
	public BaseDao<BillEquipItem> getBaseDao() {
		return billEquipItemDao;
	}	
	
	@Override
	public Class<BillEquipItem> getEntityClass() {
		return BillEquipItem.class;
	}
	
	@Override
	protected BillEquipItem insertEntity(BillEquipItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected BillEquipItem updatePartEntity(BillEquipItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected BillEquipItem updateEntity(BillEquipItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
