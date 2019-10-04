package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructProcessProduct;
import com.techsoft.dao.struct.StructProcessProductDao;

@Service
public class StructProcessProductServiceImpl extends BaseServiceImpl<StructProcessProduct> implements StructProcessProductService {
	@Autowired
	private StructProcessProductDao structProcessProductDao;
	
	@Override
	public BaseDao<StructProcessProduct> getBaseDao() {
		return structProcessProductDao;
	}	
	
	@Override
	public Class<StructProcessProduct> getEntityClass() {
		return StructProcessProduct.class;
	}
	
	@Override
	protected StructProcessProduct insertEntity(StructProcessProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructProcessProduct updatePartEntity(StructProcessProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructProcessProduct updateEntity(StructProcessProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
