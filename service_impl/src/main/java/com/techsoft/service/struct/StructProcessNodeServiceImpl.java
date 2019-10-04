package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.dao.struct.StructProcessNodeDao;

@Service
public class StructProcessNodeServiceImpl extends BaseServiceImpl<StructProcessNode> implements StructProcessNodeService {
	@Autowired
	private StructProcessNodeDao structProcessNodeDao;
	
	@Override
	public BaseDao<StructProcessNode> getBaseDao() {
		return structProcessNodeDao;
	}	
	
	@Override
	public Class<StructProcessNode> getEntityClass() {
		return StructProcessNode.class;
	}
	
	@Override
	protected StructProcessNode insertEntity(StructProcessNode entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructProcessNode updatePartEntity(StructProcessNode entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructProcessNode updateEntity(StructProcessNode entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
