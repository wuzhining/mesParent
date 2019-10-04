package com.techsoft.dao.quality;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.QualitySampleRule;
import com.techsoft.mapper.quality.QualitySampleRuleMapper;

@Repository
public class QualitySampleRuleDaoImpl extends BaseDaoImpl<QualitySampleRule> implements QualitySampleRuleDao {
	@Resource
	protected QualitySampleRuleMapper qualitySampleRuleMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<QualitySampleRule> getEntityClass() {
		return QualitySampleRule.class;
	}	
	
	@Override
	public BaseMapper<QualitySampleRule> getBaseMapper() {
		return this.qualitySampleRuleMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "QUALITY_SAMPLE_RULE";
	}
	
	@Override
	public void insertSaveCheck(QualitySampleRule value) throws BusinessException, SQLException {
		
		if (value.getSampleRuleName() == null || value.getSampleRuleName().equals(0L)) {
			throw new BusinessException("抽样规则名称不能为空");
		}
		if (value.getInspectModeDictId() == null || value.getInspectModeDictId().equals(0L)) {
			throw new BusinessException("抽样检验方式不能为空");
		}

		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(QualitySampleRule value) throws BusinessException, SQLException {
		if (value.getSampleRuleName() == null || value.getSampleRuleName().equals(0L)) {
			throw new BusinessException("抽样规则名称不能为空");
		}
		if (value.getInspectModeDictId() == null || value.getInspectModeDictId().equals(0L)) {
			throw new BusinessException("抽样检验方式不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(QualitySampleRule value) throws BusinessException, SQLException {
	
	}
			
}
