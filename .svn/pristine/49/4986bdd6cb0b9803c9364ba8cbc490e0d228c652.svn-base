package com.techsoft.dao.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigLabelFieldItem;
import com.techsoft.mapper.config.ConfigLabelFieldItemMapper;

@Repository
public class ConfigLabelFieldItemDaoImpl extends BaseDaoImpl<ConfigLabelFieldItem> implements ConfigLabelFieldItemDao {
	@Resource
	protected ConfigLabelFieldItemMapper configLabelFieldItemMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigLabelFieldItem> getEntityClass() {
		return ConfigLabelFieldItem.class;
	}	
	
	@Override
	public BaseMapper<ConfigLabelFieldItem> getBaseMapper() {
		return this.configLabelFieldItemMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_LABEL_FIELD_ITEM";
	}
	
	@Override
	public void insertSaveCheck(ConfigLabelFieldItem value) throws BusinessException, SQLException {
		if(value.getLabelFieldId() == null && value.getLabelFieldId().equals(0L)){
			throw new BusinessException("标签字段ID不能为空");
		}
		
		if(value.getLabelFunctionId() == null && value.getLabelFunctionId().equals(0L)){
			throw new BusinessException("功能定义ID不能为空");
		}
		if(value.getSortNo() == null){
			throw new BusinessException("排序号不能为空");
		}
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(ConfigLabelFieldItem value) throws BusinessException, SQLException {
		if(value.getLabelFieldId() == null && value.getLabelFieldId().equals(0L)){
			throw new BusinessException("标签字段ID不能为空");
		}
		
		if(value.getLabelFunctionId() == null && value.getLabelFunctionId().equals(0L)){
			throw new BusinessException("功能定义ID不能为空");
		}
		if(value.getSortNo() == null){
			throw new BusinessException("排序号不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(ConfigLabelFieldItem value) throws BusinessException, SQLException {
	
	}
			
}
