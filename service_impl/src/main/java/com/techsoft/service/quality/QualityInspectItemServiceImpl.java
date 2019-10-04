package com.techsoft.service.quality;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.QualityInspectItem;
import com.techsoft.dao.quality.QualityInspectItemDao;

@Service
public class QualityInspectItemServiceImpl extends BaseServiceImpl<QualityInspectItem> implements QualityInspectItemService {
	@Autowired
	private QualityInspectItemDao qualityInspectItemDao;
	
	@Override
	public BaseDao<QualityInspectItem> getBaseDao() {
		return qualityInspectItemDao;
	}	
	
	@Override
	public Class<QualityInspectItem> getEntityClass() {
		return QualityInspectItem.class;
	}
	
	@Override
	protected QualityInspectItem insertEntity(QualityInspectItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected QualityInspectItem updatePartEntity(QualityInspectItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected QualityInspectItem updateEntity(QualityInspectItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
