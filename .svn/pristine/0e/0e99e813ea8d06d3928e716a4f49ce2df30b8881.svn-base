package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructProcess;
import com.techsoft.dao.struct.StructProcessDao;

@Service
public class StructProcessServiceImpl extends BaseServiceImpl<StructProcess> implements StructProcessService {
	@Autowired
	private StructProcessDao structProcessDao;
	
	@Override
	public BaseDao<StructProcess> getBaseDao() {
		return structProcessDao;
	}	
	
	@Override
	public Class<StructProcess> getEntityClass() {
		return StructProcess.class;
	}
	
	@Override
	protected StructProcess insertEntity(StructProcess entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructProcess updatePartEntity(StructProcess entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructProcess updateEntity(StructProcess entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
