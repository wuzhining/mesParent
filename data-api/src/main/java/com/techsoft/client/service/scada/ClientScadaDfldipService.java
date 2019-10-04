package com.techsoft.client.service.scada;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ScadaDfldip;
import com.techsoft.entity.scada.ScadaDfldipVo;
import com.techsoft.entity.scada.ScadaDfldipParamVo;

public interface ClientScadaDfldipService extends BaseClientService<ScadaDfldip> {
	
	public ScadaDfldipVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaDfldipVo>  selectListVoByParamVo(ScadaDfldipParamVo scadaDfldip, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaDfldipVo>  selectPageVoByParamVo(ScadaDfldipParamVo scadaDfldip, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ScadaDfldipVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaDfldipVo>  selectListExtendVoByParamVo(ScadaDfldipParamVo scadaDfldip, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaDfldipVo>  selectPageExtendVoByParamVo(ScadaDfldipParamVo scadaDfldip, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ScadaDfldipParamVo scadaDfldipParamVo, CommonParam commonParam);		
}
