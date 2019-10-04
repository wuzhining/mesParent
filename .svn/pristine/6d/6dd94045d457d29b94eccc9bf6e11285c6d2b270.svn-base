package com.techsoft.dao.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigLabelField;
import com.techsoft.mapper.config.ConfigLabelFieldMapper;

@Repository
public class ConfigLabelFieldDaoImpl extends BaseDaoImpl<ConfigLabelField> implements ConfigLabelFieldDao {
	@Resource
	protected ConfigLabelFieldMapper configLabelFieldMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigLabelField> getEntityClass() {
		return ConfigLabelField.class;
	}	
	
	@Override
	public BaseMapper<ConfigLabelField> getBaseMapper() {
		return this.configLabelFieldMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_LABEL_FIELD";
	}
	
	@Override
	public void insertSaveCheck(ConfigLabelField value) throws BusinessException, SQLException {
		if(value.getLabelFieldName() == null && value.getLabelFieldName().equals(0L)){
			throw new BusinessException("标签字段名称不能为空");
		}
		
		if(value.getPrintModeDictId() == null && value.getPrintModeDictId().equals(0L)){
			throw new BusinessException("打印方式不能为空");
		}
		
		if(value.getIsBold() == null){
			throw new BusinessException("是否粗体不能为空");
		}
		
		if(value.getIsValid() == null){
			throw new BusinessException("是否有效不能为空");
		}
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(ConfigLabelField value) throws BusinessException, SQLException {
		if(value.getLabelFieldName() == null && value.getLabelFieldName().equals(0L)){
			throw new BusinessException("标签字段名称不能为空");
		}
		
		if(value.getPrintModeDictId() == null && value.getPrintModeDictId().equals(0L)){
			throw new BusinessException("打印方式不能为空");
		}
		
		if(value.getIsBold() == null){
			throw new BusinessException("是否粗体不能为空");
		}
		
		if(value.getIsValid() == null){
			throw new BusinessException("是否有效不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(ConfigLabelField value) throws BusinessException, SQLException {
	
	}
			
}
