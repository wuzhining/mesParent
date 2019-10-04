package com.techsoft.client.service.scada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;

import com.techsoft.entity.common.ScadaAoiCatalog;
import com.techsoft.entity.scada.ScadaAoiCatalogVo;
import com.techsoft.entity.scada.ScadaAoiCatalogParamVo;
import com.techsoft.service.scada.ScadaAoiCatalogService;

@org.springframework.stereotype.Service
public class ClientScadaAoiCatalogServiceImpl extends BaseClientServiceImpl<ScadaAoiCatalog> implements ClientScadaAoiCatalogService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ScadaAoiCatalogService scadaAoiCatalogService;
    
	@Override
	public BaseService<ScadaAoiCatalog> getBaseService() {
		return scadaAoiCatalogService;
	}	    	
    
	private ScadaAoiCatalogVo getVo(ScadaAoiCatalog scadaAoiCatalog, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiCatalogVo vo = new ScadaAoiCatalogVo(scadaAoiCatalog);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private ScadaAoiCatalogVo getExtendVo(ScadaAoiCatalog scadaAoiCatalog, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiCatalogVo vo = this.getVo(scadaAoiCatalog, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<ScadaAoiCatalogVo> getVoList(List<ScadaAoiCatalog> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaAoiCatalogVo> voList = new ArrayList<ScadaAoiCatalogVo>();
		for (ScadaAoiCatalog entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<ScadaAoiCatalogVo> getExtendVoList(List<ScadaAoiCatalog> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaAoiCatalogVo> voList = new ArrayList<ScadaAoiCatalogVo>();
		for (ScadaAoiCatalog entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public ScadaAoiCatalogVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiCatalog entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<ScadaAoiCatalogVo>  selectListVoByParamVo(ScadaAoiCatalogParamVo scadaAoiCatalog, CommonParam commonParam) throws BusinessException, SQLException {
		if(scadaAoiCatalog==null){
			scadaAoiCatalog = new ScadaAoiCatalogParamVo();
		}
	
		List<ScadaAoiCatalog> list = (List<ScadaAoiCatalog>) this.getBaseService().selectListByParamVo(scadaAoiCatalog, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaAoiCatalogVo> selectPageVoByParamVo(ScadaAoiCatalogParamVo scadaAoiCatalog, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaAoiCatalog==null){
			scadaAoiCatalog = new ScadaAoiCatalogParamVo();
		}
					
		PageInfo<ScadaAoiCatalog> list  = (PageInfo<ScadaAoiCatalog>) this.getBaseService().selectPageByParamVo(scadaAoiCatalog, commonParam, pageNo, pageSize);
		List<ScadaAoiCatalogVo> volist = new ArrayList<ScadaAoiCatalogVo>();
		
		Iterator<ScadaAoiCatalog> iter = list.getList().iterator();
		ScadaAoiCatalogVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaAoiCatalogVo> vpage = new Page<ScadaAoiCatalogVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ScadaAoiCatalogVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiCatalog entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<ScadaAoiCatalogVo>  selectListExtendVoByParamVo(ScadaAoiCatalogParamVo scadaAoiCatalog, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(scadaAoiCatalog==null){
			scadaAoiCatalog = new ScadaAoiCatalogParamVo();
		}
					
		List<ScadaAoiCatalog> list = (List<ScadaAoiCatalog>) this.getBaseService().selectListByParamVo(scadaAoiCatalog, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaAoiCatalogVo> selectPageExtendVoByParamVo(ScadaAoiCatalogParamVo scadaAoiCatalog, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaAoiCatalog==null){
			scadaAoiCatalog = new ScadaAoiCatalogParamVo();
		}
					
		PageInfo<ScadaAoiCatalog> list  = (PageInfo<ScadaAoiCatalog>) this.getBaseService().selectPageByParamVo(scadaAoiCatalog, commonParam, pageNo, pageSize);
		List<ScadaAoiCatalogVo> volist = new ArrayList<ScadaAoiCatalogVo>();
		
		Iterator<ScadaAoiCatalog> iter = list.getList().iterator();
		ScadaAoiCatalogVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaAoiCatalogVo> vpage = new Page<ScadaAoiCatalogVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(ScadaAoiCatalogParamVo scadaAoiCatalogParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		ScadaAoiCatalog scadaAoiCatalog = null;
		try {
			if (scadaAoiCatalogParamVo.getId() == null) {//新增
			 
				scadaAoiCatalog = scadaAoiCatalogService.saveOrUpdate(scadaAoiCatalogParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				ScadaAoiCatalog scadaAoiCatalogVoTemp = this.selectById(scadaAoiCatalogParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(scadaAoiCatalogVoTemp,
						scadaAoiCatalogParamVo);
  
				scadaAoiCatalog = scadaAoiCatalogService.saveOrUpdate(
						scadaAoiCatalogVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(scadaAoiCatalog);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}	
}
