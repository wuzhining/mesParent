package com.techsoft.service.quality;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.QualitySampleRuleItem;
import com.techsoft.entity.quality.QualitySampleRuleItemVo;
import com.techsoft.dao.quality.QualitySampleRuleItemDao;

@Service
public class QualitySampleRuleItemServiceImpl extends BaseServiceImpl<QualitySampleRuleItem>
		implements QualitySampleRuleItemService {
	@Autowired
	private QualitySampleRuleItemDao qualitySampleRuleItemDao;

	@Override
	public BaseDao<QualitySampleRuleItem> getBaseDao() {
		return qualitySampleRuleItemDao;
	}

	@Override
	public Class<QualitySampleRuleItem> getEntityClass() {
		return QualitySampleRuleItem.class;
	}

	@Override
	protected QualitySampleRuleItem insertEntity(QualitySampleRuleItem entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected QualitySampleRuleItem updatePartEntity(QualitySampleRuleItem entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected QualitySampleRuleItem updateEntity(QualitySampleRuleItem entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public QualitySampleRuleItem batchInsert(QualitySampleRuleItemVo qualitySampleRuleItemVo, CommonParam commonParam,
			List<QualitySampleRuleItem> qualitySampleRuleItem) throws BusinessException, SQLException {

		qualitySampleRuleItemDao.insertBatch(qualitySampleRuleItemVo,qualitySampleRuleItem, commonParam);

		return null;
	}
	
	@Override
	public QualitySampleRuleItem batchUpdate(QualitySampleRuleItem qualitySampleRuleItemVo, CommonParam commonParam,
			List<QualitySampleRuleItem> qualitySampleRuleItem) throws BusinessException, SQLException {

		   qualitySampleRuleItemDao.updateBatch(qualitySampleRuleItemVo,qualitySampleRuleItem, commonParam);

		return null;
	}
	
	
	
	
}
