package com.techsoft.service.scada;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ScadaSpiBarcode;
import com.techsoft.dao.scada.ScadaSpiBarcodeDao;

@Service
public class ScadaSpiBarcodeServiceImpl extends BaseServiceImpl<ScadaSpiBarcode> implements ScadaSpiBarcodeService {
	@Autowired
	private ScadaSpiBarcodeDao scadaSpiBarcodeDao;
	
	@Override
	public BaseDao<ScadaSpiBarcode> getBaseDao() {
		return scadaSpiBarcodeDao;
	}	
	
	@Override
	public Class<ScadaSpiBarcode> getEntityClass() {
		return ScadaSpiBarcode.class;
	}
	
	@Override
	protected ScadaSpiBarcode insertEntity(ScadaSpiBarcode entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ScadaSpiBarcode updatePartEntity(ScadaSpiBarcode entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ScadaSpiBarcode updateEntity(ScadaSpiBarcode entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
