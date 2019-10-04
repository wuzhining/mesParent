package com.techsoft.client.service.scada;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ScadaSpiLine;
import com.techsoft.entity.scada.ScadaSpiLineVo;
import com.techsoft.entity.scada.ScadaSpiLineParamVo;

public interface ClientScadaSpiLineService extends BaseClientService<ScadaSpiLine> {
	
	public ScadaSpiLineVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaSpiLineVo>  selectListVoByParamVo(ScadaSpiLineParamVo scadaSpiLine, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaSpiLineVo>  selectPageVoByParamVo(ScadaSpiLineParamVo scadaSpiLine, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ScadaSpiLineVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaSpiLineVo>  selectListExtendVoByParamVo(ScadaSpiLineParamVo scadaSpiLine, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaSpiLineVo>  selectPageExtendVoByParamVo(ScadaSpiLineParamVo scadaSpiLine, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ScadaSpiLineParamVo scadaSpiLineParamVo, CommonParam commonParam);		
}
