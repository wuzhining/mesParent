package com.techsoft.client.service.scada;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ScadaSpi;
import com.techsoft.entity.scada.ScadaSpiVo;
import com.techsoft.entity.scada.ScadaSpiParamVo;

public interface ClientScadaSpiService extends BaseClientService<ScadaSpi> {
	
	public ScadaSpiVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaSpiVo>  selectListVoByParamVo(ScadaSpiParamVo scadaSpi, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaSpiVo>  selectPageVoByParamVo(ScadaSpiParamVo scadaSpi, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ScadaSpiVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaSpiVo>  selectListExtendVoByParamVo(ScadaSpiParamVo scadaSpi, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaSpiVo>  selectPageExtendVoByParamVo(ScadaSpiParamVo scadaSpi, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ScadaSpiParamVo scadaSpiParamVo, CommonParam commonParam);		
}
