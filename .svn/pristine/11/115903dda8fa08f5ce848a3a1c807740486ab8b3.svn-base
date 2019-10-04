package com.techsoft.service.firm;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.FirmPost;
import com.techsoft.dao.firm.FirmPostDao;

@Service
public class FirmPostServiceImpl extends BaseServiceImpl<FirmPost> implements FirmPostService {
	@Autowired
	private FirmPostDao firmPostDao;
	
	@Override
	public BaseDao<FirmPost> getBaseDao() {
		return firmPostDao;
	}	
	
	@Override
	public Class<FirmPost> getEntityClass() {
		return FirmPost.class;
	}
	
	@Override
	protected FirmPost insertEntity(FirmPost entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected FirmPost updatePartEntity(FirmPost entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected FirmPost updateEntity(FirmPost entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
