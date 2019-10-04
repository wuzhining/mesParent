package com.techsoft.dao.quality;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.QualityInspectType;
import com.techsoft.mapper.quality.QualityInspectTypeMapper;

@Repository
public class QualityInspectTypeDaoImpl extends BaseDaoImpl<QualityInspectType> implements QualityInspectTypeDao {
	@Resource
	protected QualityInspectTypeMapper qualityInspectTypeMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<QualityInspectType> getEntityClass() {
		return QualityInspectType.class;
	}	
	
	@Override
	public BaseMapper<QualityInspectType> getBaseMapper() {
		return this.qualityInspectTypeMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "QUALITY_INSPECT_TYPE";
	}
	
	@Override
	public void insertSaveCheck(QualityInspectType value) throws BusinessException, SQLException {

		if (value.getInspectTypeCode() == null || value.getInspectTypeCode().equals(0L)) {
			throw new BusinessException("检验类型编码不能为空");
		}
		if (value.getInspectTypeName() == null || value.getInspectTypeName().equals(0L)) {
			throw new BusinessException("检验类型名称不能为空");
		}
		if (value.getInspectTypeQcDictId() == null || value.getInspectTypeQcDictId().equals(0L)) {
			throw new BusinessException("QC类型不能为空");
		}
		if (value.getInspectItemTypeDictId() == null || value.getInspectItemTypeDictId().equals(0L)) {
			throw new BusinessException("检验项类型不能为空");
		}

		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	
	}
	
	@Override
	public void updateSaveCheck(QualityInspectType value) throws BusinessException, SQLException {
		if (value.getInspectTypeCode() == null || value.getInspectTypeCode().equals(0L)) {
			throw new BusinessException("检验类型编码不能为空");
		}
		if (value.getInspectTypeName() == null || value.getInspectTypeName().equals(0L)) {
			throw new BusinessException("检验类型名称不能为空");
		}
		if (value.getInspectTypeQcDictId() == null || value.getInspectTypeQcDictId().equals(0L)) {
			throw new BusinessException("QC类型不能为空");
		}
		if (value.getInspectItemTypeDictId() == null || value.getInspectItemTypeDictId().equals(0L)) {
			throw new BusinessException("检验项类型不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	
	}
	
	@Override
	public void deleteSaveCheck(QualityInspectType value) throws BusinessException, SQLException {
	
	}
			
}
