package com.techsoft.dao.quality;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.QualitySampleLevel;
import com.techsoft.entity.common.QualitySampleRuleItem;
import com.techsoft.entity.quality.QualitySampleRuleItemVo;
import com.techsoft.mapper.quality.QualitySampleRuleItemMapper;

@Repository
public class QualitySampleRuleItemDaoImpl extends BaseDaoImpl<QualitySampleRuleItem> implements QualitySampleRuleItemDao {
	@Resource
	protected QualitySampleRuleItemMapper qualitySampleRuleItemMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<QualitySampleRuleItem> getEntityClass() {
		return QualitySampleRuleItem.class;
	}	
	
	@Override
	public BaseMapper<QualitySampleRuleItem> getBaseMapper() {
		return this.qualitySampleRuleItemMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "QUALITY_SAMPLE_RULE_ITEM";
	}
	
	@Override
	public void insertSaveCheck(QualitySampleRuleItem value) throws BusinessException, SQLException {
		if (value.getSampleRuleId() == null || value.getSampleRuleId().equals(0L)) {
			throw new BusinessException("抽样规则ID不能为空");
		}
		if (value.getSampleLetter() == null || value.getSampleLetter().equals(0L)) {
			throw new BusinessException("索引字母不能为空");
		}
		if (value.getQuantity() == null || value.getQuantity().equals(0L)) {
			throw new BusinessException("抽检样本数量不能为空");
		}
		
		if (value.getQuantityAc() == null) {
			throw new BusinessException("抽检样本AC数量不能为空");
		}
		
		if (value.getQuantityRe() == null) {
			throw new BusinessException("抽检样本RE数量不能为空");
		}

		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(QualitySampleRuleItem value) throws BusinessException, SQLException {
		if (value.getSampleRuleId() == null || value.getSampleRuleId().equals(0L)) {
			throw new BusinessException("抽样规则ID不能为空");
		}
		if (value.getSampleLetter() == null || value.getSampleLetter().equals(0L)) {
			throw new BusinessException("索引字母不能为空");
		}
		if (value.getQuantity() == null || value.getQuantity().equals(0L)) {
			throw new BusinessException("抽检样本数量不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(QualitySampleRuleItem value) throws BusinessException, SQLException {
	
	}

	@Override
	public void insertBatch(QualitySampleRuleItemVo qualitySampleRuleItemVo,List<QualitySampleRuleItem> sampleRuleItem, CommonParam commonParam) throws BusinessException, SQLException {
		try {
			DecimalFormat df=new DecimalFormat("0000");
			Integer index = 0;
			String idString = "";
			Long idLong = 0L;
			Long id = this.qualitySampleRuleItemMapper.getIDValue();
			List<QualitySampleRuleItem> listItem = new ArrayList<QualitySampleRuleItem>();
			for (QualitySampleRuleItem item : sampleRuleItem) {
				QualitySampleRuleItem qSampleRuleItem = new QualitySampleRuleItem();
				qSampleRuleItem.setCreateUserId(Long.valueOf(commonParam.getUserId()));
				qSampleRuleItem.setModifyUserId(Long.valueOf(commonParam.getUserId()));
				qSampleRuleItem.setTenantId(commonParam.getTenantId());
				qSampleRuleItem.setSampleRuleId(qualitySampleRuleItemVo.getSampleRuleId());
				qSampleRuleItem.setSampleLetter(item.getSampleLetter());
				qSampleRuleItem.setQuantity(item.getQuantity());
				qSampleRuleItem.setQuantityAc(item.getQuantityAc());  
				qSampleRuleItem.setQuantityRe(item.getQuantityRe());
				insertSaveCheck(qSampleRuleItem);
				index++;
				idString=df.format(index);
				idLong = Long.valueOf(id.toString() + idString);
				qSampleRuleItem.setId(idLong);
				listItem.addAll(sampleRuleItem);
			}
			int rows = this.qualitySampleRuleItemMapper.insertBatch(listItem);
			if (rows != sampleRuleItem.size()) {
				throw new BusinessException("批量增加的AQL明细数据与传入的AQL明细列表数量不一致， 请检查!");
			}

		} catch (RuntimeException e) {
			throw new SQLException(e.getMessage());
		}
			
    }
	

	@Override
	public void updateBatch(QualitySampleRuleItem qualitySampleRuleItemVo,List<QualitySampleRuleItem> sampleRuleItem, CommonParam commonParam) throws BusinessException, SQLException {
		try {
			for (QualitySampleRuleItem item : sampleRuleItem) {
				item.setModifyUserId(Long.valueOf(commonParam.getUserId()));
				item.setTenantId(qualitySampleRuleItemVo.getTenantId());
			}
			this.qualitySampleRuleItemMapper.updateBatch(sampleRuleItem);
		} catch (RuntimeException e) {
			throw new SQLException(e.getMessage());
		}
			
    }
	
	
	
	
	
	
	
	
	
	
}