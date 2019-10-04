package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.dao.struct.StructWorkshopDao;

@Service
public class StructWorkshopServiceImpl extends BaseServiceImpl<StructWorkshop> implements StructWorkshopService {
	@Autowired
	private StructWorkshopDao structWorkshopDao;
	
	@Override
	public BaseDao<StructWorkshop> getBaseDao() {
		return structWorkshopDao;
	}	
	
	@Override
	public Class<StructWorkshop> getEntityClass() {
		return StructWorkshop.class;
	}
	
	@Override
	protected StructWorkshop insertEntity(StructWorkshop entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructWorkshop updatePartEntity(StructWorkshop entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructWorkshop updateEntity(StructWorkshop entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
