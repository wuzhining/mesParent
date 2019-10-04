package com.techsoft.service.quality;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.QualitySampleRule;
import com.techsoft.dao.quality.QualitySampleRuleDao;

@Service
public class QualitySampleRuleServiceImpl extends BaseServiceImpl<QualitySampleRule> implements QualitySampleRuleService {
	@Autowired
	private QualitySampleRuleDao qualitySampleRuleDao;
	
	@Override
	public BaseDao<QualitySampleRule> getBaseDao() {
		return qualitySampleRuleDao;
	}	
	
	@Override
	public Class<QualitySampleRule> getEntityClass() {
		return QualitySampleRule.class;
	}
	
	@Override
	protected QualitySampleRule insertEntity(QualitySampleRule entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected QualitySampleRule updatePartEntity(QualitySampleRule entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected QualitySampleRule updateEntity(QualitySampleRule entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
