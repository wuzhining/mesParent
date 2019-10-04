package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructFloor;
import com.techsoft.dao.struct.StructFloorDao;

@Service
public class StructFloorServiceImpl extends BaseServiceImpl<StructFloor> implements StructFloorService {
	@Autowired
	private StructFloorDao structFloorDao;
	
	@Override
	public BaseDao<StructFloor> getBaseDao() {
		return structFloorDao;
	}	
	
	@Override
	public Class<StructFloor> getEntityClass() {
		return StructFloor.class;
	}
	
	@Override
	protected StructFloor insertEntity(StructFloor entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructFloor updatePartEntity(StructFloor entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructFloor updateEntity(StructFloor entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
