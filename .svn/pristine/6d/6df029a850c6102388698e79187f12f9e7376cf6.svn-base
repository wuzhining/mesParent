package com.techsoft.service.quality;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.QualityInspectModuleRelation;
import com.techsoft.dao.quality.QualityInspectModuleRelationDao;

@Service
public class QualityInspectModuleRelationServiceImpl extends BaseServiceImpl<QualityInspectModuleRelation> implements QualityInspectModuleRelationService {
	@Autowired
	private QualityInspectModuleRelationDao qualityInspectModuleRelationDao;
	
	@Override
	public BaseDao<QualityInspectModuleRelation> getBaseDao() {
		return qualityInspectModuleRelationDao;
	}	
	
	@Override
	public Class<QualityInspectModuleRelation> getEntityClass() {
		return QualityInspectModuleRelation.class;
	}
	
	@Override
	protected QualityInspectModuleRelation insertEntity(QualityInspectModuleRelation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected QualityInspectModuleRelation updatePartEntity(QualityInspectModuleRelation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected QualityInspectModuleRelation updateEntity(QualityInspectModuleRelation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
