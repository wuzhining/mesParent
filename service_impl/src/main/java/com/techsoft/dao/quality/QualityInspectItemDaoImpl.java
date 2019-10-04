package com.techsoft.dao.quality;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.QualityInspectItem;
import com.techsoft.mapper.quality.QualityInspectItemMapper;

@Repository
public class QualityInspectItemDaoImpl extends BaseDaoImpl<QualityInspectItem> implements QualityInspectItemDao {
	@Resource
	protected QualityInspectItemMapper qualityInspectItemMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<QualityInspectItem> getEntityClass() {
		return QualityInspectItem.class;
	}	
	
	@Override
	public BaseMapper<QualityInspectItem> getBaseMapper() {
		return this.qualityInspectItemMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "QUALITY_INSPECT_ITEM";
	}
	
	@Override
	public void insertSaveCheck(QualityInspectItem value) throws BusinessException, SQLException {
		
		
		if (value.getInspectItemName() == null || value.getInspectItemName().equals(0L)) {
			throw new BusinessException("检验项名称不能为空");
		}
		if (value.getIsModule() == null || value.getIsModule().equals(0L)) {
			throw new BusinessException("是否模块不能为空");
		}
		
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(QualityInspectItem value) throws BusinessException, SQLException {
		if (value.getInspectItemName() == null || value.getInspectItemName().equals(0L)) {
			throw new BusinessException("检验项名称不能为空");
		}
		if (value.getIsModule() == null || value.getIsModule().equals(0L)) {
			throw new BusinessException("是否模块不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(QualityInspectItem value) throws BusinessException, SQLException {
	
	}
			
}
