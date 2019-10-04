package com.techsoft.service.quality;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.QualityInspectDocument;
import com.techsoft.dao.quality.QualityInspectDocumentDao;

@Service
public class QualityInspectDocumentServiceImpl extends BaseServiceImpl<QualityInspectDocument> implements QualityInspectDocumentService {
	@Autowired
	private QualityInspectDocumentDao qualityInspectDocumentDao;
	
	@Override
	public BaseDao<QualityInspectDocument> getBaseDao() {
		return qualityInspectDocumentDao;
	}	
	
	@Override
	public Class<QualityInspectDocument> getEntityClass() {
		return QualityInspectDocument.class;
	}
	
	@Override
	protected QualityInspectDocument insertEntity(QualityInspectDocument entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected QualityInspectDocument updatePartEntity(QualityInspectDocument entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected QualityInspectDocument updateEntity(QualityInspectDocument entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
