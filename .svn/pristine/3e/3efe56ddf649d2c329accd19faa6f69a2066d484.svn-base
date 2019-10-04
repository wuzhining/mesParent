package com.techsoft.dao.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigLabelItem;
import com.techsoft.mapper.config.ConfigLabelItemMapper;

@Repository
public class ConfigLabelItemDaoImpl extends BaseDaoImpl<ConfigLabelItem> implements ConfigLabelItemDao {
	@Resource
	protected ConfigLabelItemMapper configLabelItemMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigLabelItem> getEntityClass() {
		return ConfigLabelItem.class;
	}	
	
	@Override
	public BaseMapper<ConfigLabelItem> getBaseMapper() {
		return this.configLabelItemMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_LABEL_ITEM";
	}
	
	@Override
	public void insertSaveCheck(ConfigLabelItem value) throws BusinessException, SQLException {
		if(value.getLabelId() == null && value.getLabelId().equals(0L)){
			throw new BusinessException("标签ID不能为空");
		}
		
		if(value.getLabelFieldId() == null && value.getLabelFieldId().equals(0L)){
			throw new BusinessException("标签字段ID不能为空");
		}
		if(value.getSortNo() == null){
			throw new BusinessException("排序号不能为空");
		}
		
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(ConfigLabelItem value) throws BusinessException, SQLException {
		if(value.getLabelId() == null && value.getLabelId().equals(0L)){
			throw new BusinessException("标签ID不能为空");
		}
		
		if(value.getLabelFieldId() == null && value.getLabelFieldId().equals(0L)){
			throw new BusinessException("标签字段ID不能为空");
		}
		if(value.getSortNo() == null){
			throw new BusinessException("排序号不能为空");
		}
		
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(ConfigLabelItem value) throws BusinessException, SQLException {
	
	}
			
}
