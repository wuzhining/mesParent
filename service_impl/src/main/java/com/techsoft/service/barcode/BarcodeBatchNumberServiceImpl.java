package com.techsoft.service.barcode;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.BarcodeBatchNumber;
import com.techsoft.dao.barcode.BarcodeBatchNumberDao;

@Service
public class BarcodeBatchNumberServiceImpl extends BaseServiceImpl<BarcodeBatchNumber> implements BarcodeBatchNumberService {
	@Autowired
	private BarcodeBatchNumberDao barcodeBatchNumberDao;
	
	@Override
	public BaseDao<BarcodeBatchNumber> getBaseDao() {
		return barcodeBatchNumberDao;
	}	
	
	@Override
	public Class<BarcodeBatchNumber> getEntityClass() {
		return BarcodeBatchNumber.class;
	}
	
	@Override
	protected BarcodeBatchNumber insertEntity(BarcodeBatchNumber entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected BarcodeBatchNumber updatePartEntity(BarcodeBatchNumber entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected BarcodeBatchNumber updateEntity(BarcodeBatchNumber entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
