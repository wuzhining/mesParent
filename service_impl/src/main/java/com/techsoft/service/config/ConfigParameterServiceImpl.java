package com.techsoft.service.config;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumYesOrNo;
import com.techsoft.dao.config.ConfigParameterDao;
import com.techsoft.entity.common.ConfigParameter;
import com.techsoft.entity.config.ConfigParameterParamVo;
import com.techsoft.entity.config.ConfigParameterVo;

@Service
public class ConfigParameterServiceImpl extends BaseServiceImpl<ConfigParameter> implements ConfigParameterService {
	@Autowired
	private ConfigParameterDao configParameterDao;
	
	@Override
	public BaseDao<ConfigParameter> getBaseDao() {
		return configParameterDao;
	}	
	
	@Override
	public Class<ConfigParameter> getEntityClass() {
		return ConfigParameter.class;
	}
	
	@Override
	protected ConfigParameter insertEntity(ConfigParameter entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ConfigParameter updatePartEntity(ConfigParameter entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ConfigParameter updateEntity(ConfigParameter entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public ConfigParameterVo getByCode(String paramCode, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (StringUtils.isBlank(paramCode)) {
			return null;
		}
		ConfigParameterParamVo configParameter = new ConfigParameterParamVo();
		configParameter.setParamCode(paramCode);
		configParameter.setIsValid(EnumYesOrNo.YES.getValue());
//		if(commonParam!=null){
//			if(commonParam.getTenantId()!=null){
//				configParameter.setTenantId(commonParam.getTenantId());
//			}
//		}
		List<ConfigParameter> list = (List<ConfigParameter>) configParameterDao
				.selectListByParamVo(configParameter);
		if ((list != null) && (!list.isEmpty())) {
			ConfigParameterVo configParameterVo = new ConfigParameterVo(list.get(0));
		 
			return configParameterVo;
		}
		return null;
	}					
}
