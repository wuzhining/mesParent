package com.techsoft.client.service.scada;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ScadaSpiRedgumPcb;
import com.techsoft.entity.scada.ScadaSpiRedgumPcbVo;
import com.techsoft.entity.scada.ScadaSpiRedgumPcbParamVo;

public interface ClientScadaSpiRedgumPcbService extends BaseClientService<ScadaSpiRedgumPcb> {
	
	public ScadaSpiRedgumPcbVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaSpiRedgumPcbVo>  selectListVoByParamVo(ScadaSpiRedgumPcbParamVo scadaSpiRedgumPcb, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaSpiRedgumPcbVo>  selectPageVoByParamVo(ScadaSpiRedgumPcbParamVo scadaSpiRedgumPcb, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ScadaSpiRedgumPcbVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaSpiRedgumPcbVo>  selectListExtendVoByParamVo(ScadaSpiRedgumPcbParamVo scadaSpiRedgumPcb, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaSpiRedgumPcbVo>  selectPageExtendVoByParamVo(ScadaSpiRedgumPcbParamVo scadaSpiRedgumPcb, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ScadaSpiRedgumPcbParamVo scadaSpiRedgumPcbParamVo, CommonParam commonParam);		
}
