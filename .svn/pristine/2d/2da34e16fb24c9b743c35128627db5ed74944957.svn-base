package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructProdlineWorkstation;
import com.techsoft.dao.struct.StructProdlineWorkstationDao;

@Service
public class StructProdlineWorkstationServiceImpl extends BaseServiceImpl<StructProdlineWorkstation> implements StructProdlineWorkstationService {
	@Autowired
	private StructProdlineWorkstationDao structProdlineWorkstationDao;
	
	@Override
	public BaseDao<StructProdlineWorkstation> getBaseDao() {
		return structProdlineWorkstationDao;
	}	
	
	@Override
	public Class<StructProdlineWorkstation> getEntityClass() {
		return StructProdlineWorkstation.class;
	}
	
	@Override
	protected StructProdlineWorkstation insertEntity(StructProdlineWorkstation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructProdlineWorkstation updatePartEntity(StructProdlineWorkstation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructProdlineWorkstation updateEntity(StructProdlineWorkstation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
