package com.techsoft.dao.quality;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.QualityInspectModuleRelation;
import com.techsoft.mapper.quality.QualityInspectModuleRelationMapper;

@Repository
public class QualityInspectModuleRelationDaoImpl extends BaseDaoImpl<QualityInspectModuleRelation> implements QualityInspectModuleRelationDao {
	@Resource
	protected QualityInspectModuleRelationMapper qualityInspectModuleRelationMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<QualityInspectModuleRelation> getEntityClass() {
		return QualityInspectModuleRelation.class;
	}	
	
	@Override
	public BaseMapper<QualityInspectModuleRelation> getBaseMapper() {
		return this.qualityInspectModuleRelationMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "QUALITY_INSPECT_MODULE_RELATION";
	}
	
	@Override
	public void insertSaveCheck(QualityInspectModuleRelation value) throws BusinessException, SQLException {
		
		
		if (value.getInspectItemId() == null || value.getInspectItemId().equals(0L)) {
			throw new BusinessException("检验模板名称不能为空");
		}
		if (value.getSampleLevelDictId() == null || value.getSampleLevelDictId().equals(0L)) {
			throw new BusinessException("抽样水平名称不能为空");
		}
		if (value.getSampleLevelRankDictId() == null || value.getSampleLevelRankDictId().equals(0L)) {
			throw new BusinessException("抽样水平等级不能为空");
		}
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	
	}
	
	@Override
	public void updateSaveCheck(QualityInspectModuleRelation value) throws BusinessException, SQLException {
		if (value.getInspectItemId() == null || value.getInspectItemId().equals(0L)) {
			throw new BusinessException("检验模板名称不能为空");
		}
		if (value.getSampleLevelDictId() == null || value.getSampleLevelDictId().equals(0L)) {
			throw new BusinessException("抽样水平名称不能为空");
		}
		if (value.getSampleLevelRankDictId() == null || value.getSampleLevelRankDictId().equals(0L)) {
			throw new BusinessException("抽样水平等级不能为空");
		}
		
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	
	}
	
	@Override
	public void deleteSaveCheck(QualityInspectModuleRelation value) throws BusinessException, SQLException {
	
	}
			
}
