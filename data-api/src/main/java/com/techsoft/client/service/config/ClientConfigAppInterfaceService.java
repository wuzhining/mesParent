package com.techsoft.client.service.config;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ConfigAppInterface;
import com.techsoft.entity.config.ConfigAppInterfaceVo;
import com.techsoft.entity.config.ConfigAppInterfaceParamVo;

public interface ClientConfigAppInterfaceService extends BaseClientService<ConfigAppInterface> {
	
	public ConfigAppInterfaceVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ConfigAppInterfaceVo>  selectListVoByParamVo(ConfigAppInterfaceParamVo configAppInterface, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ConfigAppInterfaceVo>  selectPageVoByParamVo(ConfigAppInterfaceParamVo configAppInterface, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ConfigAppInterfaceVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ConfigAppInterfaceVo>  selectListExtendVoByParamVo(ConfigAppInterfaceParamVo configAppInterface, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ConfigAppInterfaceVo>  selectPageExtendVoByParamVo(ConfigAppInterfaceParamVo configAppInterface, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ConfigAppInterfaceParamVo configAppInterfaceParamVo, CommonParam commonParam);		
}
