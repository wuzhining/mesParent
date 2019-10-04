package com.techsoft.dao.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ConfigLabel;
import com.techsoft.mapper.config.ConfigLabelMapper;

@Repository
public class ConfigLabelDaoImpl extends BaseDaoImpl<ConfigLabel> implements ConfigLabelDao {
	@Resource
	protected ConfigLabelMapper configLabelMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ConfigLabel> getEntityClass() {
		return ConfigLabel.class;
	}	
	
	@Override
	public BaseMapper<ConfigLabel> getBaseMapper() {
		return this.configLabelMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "CONFIG_LABEL";
	}
	
	@Override
	public void insertSaveCheck(ConfigLabel value) throws BusinessException, SQLException {
		if(value.getLabelName() == null && value.getLabelName().equals(0L)){
			throw new BusinessException("标签文档名称不能为空");
		}
		
		if(value.getPrintModeDictId() == null && value.getPrintModeDictId().equals(0L)){
			throw new BusinessException("打印方式不能为空");
		}
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(ConfigLabel value) throws BusinessException, SQLException {
		if(value.getLabelName() == null && value.getLabelName().equals(0L)){
			throw new BusinessException("标签文档名称不能为空");
		}
		
		if(value.getPrintModeDictId() == null && value.getPrintModeDictId().equals(0L)){
			throw new BusinessException("打印方式不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(ConfigLabel value) throws BusinessException, SQLException {
	
	}
			
}
