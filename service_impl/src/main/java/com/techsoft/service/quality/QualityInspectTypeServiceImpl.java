package com.techsoft.service.quality;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.QualityInspectType;
import com.techsoft.dao.quality.QualityInspectTypeDao;

@Service
public class QualityInspectTypeServiceImpl extends BaseServiceImpl<QualityInspectType> implements QualityInspectTypeService {
	@Autowired
	private QualityInspectTypeDao qualityInspectTypeDao;
	
	@Override
	public BaseDao<QualityInspectType> getBaseDao() {
		return qualityInspectTypeDao;
	}	
	
	@Override
	public Class<QualityInspectType> getEntityClass() {
		return QualityInspectType.class;
	}
	
	@Override
	protected QualityInspectType insertEntity(QualityInspectType entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected QualityInspectType updatePartEntity(QualityInspectType entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected QualityInspectType updateEntity(QualityInspectType entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
