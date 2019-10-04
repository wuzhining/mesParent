package com.techsoft.client.service.scada;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ScadaAoiCatalog;
import com.techsoft.entity.scada.ScadaAoiCatalogVo;
import com.techsoft.entity.scada.ScadaAoiCatalogParamVo;

public interface ClientScadaAoiCatalogService extends BaseClientService<ScadaAoiCatalog> {
	
	public ScadaAoiCatalogVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaAoiCatalogVo>  selectListVoByParamVo(ScadaAoiCatalogParamVo scadaAoiCatalog, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaAoiCatalogVo>  selectPageVoByParamVo(ScadaAoiCatalogParamVo scadaAoiCatalog, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ScadaAoiCatalogVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaAoiCatalogVo>  selectListExtendVoByParamVo(ScadaAoiCatalogParamVo scadaAoiCatalog, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaAoiCatalogVo>  selectPageExtendVoByParamVo(ScadaAoiCatalogParamVo scadaAoiCatalog, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ScadaAoiCatalogParamVo scadaAoiCatalogParamVo, CommonParam commonParam);		
}
