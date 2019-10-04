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

import com.techsoft.entity.common.ScadaAoiVersion;
import com.techsoft.entity.scada.ScadaAoiVersionVo;
import com.techsoft.entity.scada.ScadaAoiVersionParamVo;
import com.techsoft.service.scada.ScadaAoiVersionService;

@org.springframework.stereotype.Service
public class ClientScadaAoiVersionServiceImpl extends BaseClientServiceImpl<ScadaAoiVersion> implements ClientScadaAoiVersionService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ScadaAoiVersionService scadaAoiVersionService;
    
	@Override
	public BaseService<ScadaAoiVersion> getBaseService() {
		return scadaAoiVersionService;
	}	    	
    
	private ScadaAoiVersionVo getVo(ScadaAoiVersion scadaAoiVersion, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiVersionVo vo = new ScadaAoiVersionVo(scadaAoiVersion);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private ScadaAoiVersionVo getExtendVo(ScadaAoiVersion scadaAoiVersion, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiVersionVo vo = this.getVo(scadaAoiVersion, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<ScadaAoiVersionVo> getVoList(List<ScadaAoiVersion> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaAoiVersionVo> voList = new ArrayList<ScadaAoiVersionVo>();
		for (ScadaAoiVersion entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<ScadaAoiVersionVo> getExtendVoList(List<ScadaAoiVersion> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaAoiVersionVo> voList = new ArrayList<ScadaAoiVersionVo>();
		for (ScadaAoiVersion entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public ScadaAoiVersionVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiVersion entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<ScadaAoiVersionVo>  selectListVoByParamVo(ScadaAoiVersionParamVo scadaAoiVersion, CommonParam commonParam) throws BusinessException, SQLException {
		if(scadaAoiVersion==null){
			scadaAoiVersion = new ScadaAoiVersionParamVo();
		}
	
		List<ScadaAoiVersion> list = (List<ScadaAoiVersion>) this.getBaseService().selectListByParamVo(scadaAoiVersion, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaAoiVersionVo> selectPageVoByParamVo(ScadaAoiVersionParamVo scadaAoiVersion, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaAoiVersion==null){
			scadaAoiVersion = new ScadaAoiVersionParamVo();
		}
					
		PageInfo<ScadaAoiVersion> list  = (PageInfo<ScadaAoiVersion>) this.getBaseService().selectPageByParamVo(scadaAoiVersion, commonParam, pageNo, pageSize);
		List<ScadaAoiVersionVo> volist = new ArrayList<ScadaAoiVersionVo>();
		
		Iterator<ScadaAoiVersion> iter = list.getList().iterator();
		ScadaAoiVersionVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaAoiVersionVo> vpage = new Page<ScadaAoiVersionVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ScadaAoiVersionVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiVersion entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<ScadaAoiVersionVo>  selectListExtendVoByParamVo(ScadaAoiVersionParamVo scadaAoiVersion, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(scadaAoiVersion==null){
			scadaAoiVersion = new ScadaAoiVersionParamVo();
		}
					
		List<ScadaAoiVersion> list = (List<ScadaAoiVersion>) this.getBaseService().selectListByParamVo(scadaAoiVersion, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaAoiVersionVo> selectPageExtendVoByParamVo(ScadaAoiVersionParamVo scadaAoiVersion, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaAoiVersion==null){
			scadaAoiVersion = new ScadaAoiVersionParamVo();
		}
					
		PageInfo<ScadaAoiVersion> list  = (PageInfo<ScadaAoiVersion>) this.getBaseService().selectPageByParamVo(scadaAoiVersion, commonParam, pageNo, pageSize);
		List<ScadaAoiVersionVo> volist = new ArrayList<ScadaAoiVersionVo>();
		
		Iterator<ScadaAoiVersion> iter = list.getList().iterator();
		ScadaAoiVersionVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaAoiVersionVo> vpage = new Page<ScadaAoiVersionVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(ScadaAoiVersionParamVo scadaAoiVersionParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		ScadaAoiVersion scadaAoiVersion = null;
		try {
			if (scadaAoiVersionParamVo.getId() == null) {//新增
			 
				scadaAoiVersion = scadaAoiVersionService.saveOrUpdate(scadaAoiVersionParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				ScadaAoiVersion scadaAoiVersionVoTemp = this.selectById(scadaAoiVersionParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(scadaAoiVersionVoTemp,
						scadaAoiVersionParamVo);
  
				scadaAoiVersion = scadaAoiVersionService.saveOrUpdate(
						scadaAoiVersionVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(scadaAoiVersion);
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
