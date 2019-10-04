package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructProductionline;
import com.techsoft.dao.struct.StructProductionlineDao;

@Service
public class StructProductionlineServiceImpl extends BaseServiceImpl<StructProductionline> implements StructProductionlineService {
	@Autowired
	private StructProductionlineDao structProductionlineDao;
	
	@Override
	public BaseDao<StructProductionline> getBaseDao() {
		return structProductionlineDao;
	}	
	
	@Override
	public Class<StructProductionline> getEntityClass() {
		return StructProductionline.class;
	}
	
	@Override
	protected StructProductionline insertEntity(StructProductionline entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructProductionline updatePartEntity(StructProductionline entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructProductionline updateEntity(StructProductionline entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
