package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.dao.struct.StructWorkshopAreaDao;

@Service
public class StructWorkshopAreaServiceImpl extends BaseServiceImpl<StructWorkshopArea> implements StructWorkshopAreaService {
	@Autowired
	private StructWorkshopAreaDao structWorkshopAreaDao;
	
	@Override
	public BaseDao<StructWorkshopArea> getBaseDao() {
		return structWorkshopAreaDao;
	}	
	
	@Override
	public Class<StructWorkshopArea> getEntityClass() {
		return StructWorkshopArea.class;
	}
	
	@Override
	protected StructWorkshopArea insertEntity(StructWorkshopArea entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructWorkshopArea updatePartEntity(StructWorkshopArea entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructWorkshopArea updateEntity(StructWorkshopArea entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
