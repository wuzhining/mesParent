package com.techsoft.service.bill;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.BillEquip;
import com.techsoft.dao.bill.BillEquipDao;

@Service
public class BillEquipServiceImpl extends BaseServiceImpl<BillEquip> implements BillEquipService {
	@Autowired
	private BillEquipDao billEquipDao;
	
	@Override
	public BaseDao<BillEquip> getBaseDao() {
		return billEquipDao;
	}	
	
	@Override
	public Class<BillEquip> getEntityClass() {
		return BillEquip.class;
	}
	
	@Override
	protected BillEquip insertEntity(BillEquip entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected BillEquip updatePartEntity(BillEquip entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected BillEquip updateEntity(BillEquip entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
