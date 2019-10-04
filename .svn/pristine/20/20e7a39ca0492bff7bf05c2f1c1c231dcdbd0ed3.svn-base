package com.techsoft.client.service.scada;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ScadaSpiSolderPcb;
import com.techsoft.entity.scada.ScadaSpiSolderPcbVo;
import com.techsoft.entity.scada.ScadaSpiSolderPcbParamVo;

public interface ClientScadaSpiSolderPcbService extends BaseClientService<ScadaSpiSolderPcb> {
	
	public ScadaSpiSolderPcbVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaSpiSolderPcbVo>  selectListVoByParamVo(ScadaSpiSolderPcbParamVo scadaSpiSolderPcb, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaSpiSolderPcbVo>  selectPageVoByParamVo(ScadaSpiSolderPcbParamVo scadaSpiSolderPcb, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ScadaSpiSolderPcbVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaSpiSolderPcbVo>  selectListExtendVoByParamVo(ScadaSpiSolderPcbParamVo scadaSpiSolderPcb, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaSpiSolderPcbVo>  selectPageExtendVoByParamVo(ScadaSpiSolderPcbParamVo scadaSpiSolderPcb, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ScadaSpiSolderPcbParamVo scadaSpiSolderPcbParamVo, CommonParam commonParam);		
}
