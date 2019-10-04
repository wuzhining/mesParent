package com.techsoft.dao.quality;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.QualityInspectDocument;
import com.techsoft.mapper.quality.QualityInspectDocumentMapper;

@Repository
public class QualityInspectDocumentDaoImpl extends BaseDaoImpl<QualityInspectDocument> implements QualityInspectDocumentDao {
	@Resource
	protected QualityInspectDocumentMapper qualityInspectDocumentMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<QualityInspectDocument> getEntityClass() {
		return QualityInspectDocument.class;
	}	
	
	@Override
	public BaseMapper<QualityInspectDocument> getBaseMapper() {
		return this.qualityInspectDocumentMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "QUALITY_INSPECT_DOCUMENT";
	}
	
	@Override
	public void insertSaveCheck(QualityInspectDocument value) throws BusinessException, SQLException {
		
		if (value.getDocumentName() == null || value.getDocumentName().equals(0L)) {
			throw new BusinessException("检验文档名称不能为空");
		}
		if (value.getSupplierId() == null || value.getSupplierId().equals(0L)) {
			throw new BusinessException("供应商名称不能为空");
		}
		if (value.getProductId() == null || value.getProductId().equals(0L)) {
			throw new BusinessException("物品名称不能为空");
		}
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	
	}
	
	@Override
	public void updateSaveCheck(QualityInspectDocument value) throws BusinessException, SQLException {
		
		if (value.getDocumentName() == null || value.getDocumentName().equals(0L)) {
			throw new BusinessException("检验文档名称不能为空");
		}
		if (value.getSupplierId() == null || value.getSupplierId().equals(0L)) {
			throw new BusinessException("供应商名称不能为空");
		}
		if (value.getProductId() == null || value.getProductId().equals(0L)) {
			throw new BusinessException("物品名称不能为空");
		}
		
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	
	}
	
	@Override
	public void deleteSaveCheck(QualityInspectDocument value) throws BusinessException, SQLException {
	
	}
			
}
