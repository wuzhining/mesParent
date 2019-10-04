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

import com.techsoft.entity.common.ScadaSpiLine;
import com.techsoft.entity.scada.ScadaSpiLineVo;
import com.techsoft.entity.scada.ScadaSpiLineParamVo;
import com.techsoft.service.scada.ScadaSpiLineService;

@org.springframework.stereotype.Service
public class ClientScadaSpiLineServiceImpl extends BaseClientServiceImpl<ScadaSpiLine> implements ClientScadaSpiLineService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ScadaSpiLineService scadaSpiLineService;
    
	@Override
	public BaseService<ScadaSpiLine> getBaseService() {
		return scadaSpiLineService;
	}	    	
    
	private ScadaSpiLineVo getVo(ScadaSpiLine scadaSpiLine, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiLineVo vo = new ScadaSpiLineVo(scadaSpiLine);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private ScadaSpiLineVo getExtendVo(ScadaSpiLine scadaSpiLine, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiLineVo vo = this.getVo(scadaSpiLine, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<ScadaSpiLineVo> getVoList(List<ScadaSpiLine> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaSpiLineVo> voList = new ArrayList<ScadaSpiLineVo>();
		for (ScadaSpiLine entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<ScadaSpiLineVo> getExtendVoList(List<ScadaSpiLine> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaSpiLineVo> voList = new ArrayList<ScadaSpiLineVo>();
		for (ScadaSpiLine entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public ScadaSpiLineVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiLine entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<ScadaSpiLineVo>  selectListVoByParamVo(ScadaSpiLineParamVo scadaSpiLine, CommonParam commonParam) throws BusinessException, SQLException {
		if(scadaSpiLine==null){
			scadaSpiLine = new ScadaSpiLineParamVo();
		}
	
		List<ScadaSpiLine> list = (List<ScadaSpiLine>) this.getBaseService().selectListByParamVo(scadaSpiLine, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaSpiLineVo> selectPageVoByParamVo(ScadaSpiLineParamVo scadaSpiLine, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaSpiLine==null){
			scadaSpiLine = new ScadaSpiLineParamVo();
		}
					
		PageInfo<ScadaSpiLine> list  = (PageInfo<ScadaSpiLine>) this.getBaseService().selectPageByParamVo(scadaSpiLine, commonParam, pageNo, pageSize);
		List<ScadaSpiLineVo> volist = new ArrayList<ScadaSpiLineVo>();
		
		Iterator<ScadaSpiLine> iter = list.getList().iterator();
		ScadaSpiLineVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaSpiLineVo> vpage = new Page<ScadaSpiLineVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ScadaSpiLineVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiLine entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<ScadaSpiLineVo>  selectListExtendVoByParamVo(ScadaSpiLineParamVo scadaSpiLine, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(scadaSpiLine==null){
			scadaSpiLine = new ScadaSpiLineParamVo();
		}
					
		List<ScadaSpiLine> list = (List<ScadaSpiLine>) this.getBaseService().selectListByParamVo(scadaSpiLine, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaSpiLineVo> selectPageExtendVoByParamVo(ScadaSpiLineParamVo scadaSpiLine, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaSpiLine==null){
			scadaSpiLine = new ScadaSpiLineParamVo();
		}
					
		PageInfo<ScadaSpiLine> list  = (PageInfo<ScadaSpiLine>) this.getBaseService().selectPageByParamVo(scadaSpiLine, commonParam, pageNo, pageSize);
		List<ScadaSpiLineVo> volist = new ArrayList<ScadaSpiLineVo>();
		
		Iterator<ScadaSpiLine> iter = list.getList().iterator();
		ScadaSpiLineVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaSpiLineVo> vpage = new Page<ScadaSpiLineVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(ScadaSpiLineParamVo scadaSpiLineParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		ScadaSpiLine scadaSpiLine = null;
		try {
			if (scadaSpiLineParamVo.getId() == null) {//新增
			 
				scadaSpiLine = scadaSpiLineService.saveOrUpdate(scadaSpiLineParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				ScadaSpiLine scadaSpiLineVoTemp = this.selectById(scadaSpiLineParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(scadaSpiLineVoTemp,
						scadaSpiLineParamVo);
  
				scadaSpiLine = scadaSpiLineService.saveOrUpdate(
						scadaSpiLineVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(scadaSpiLine);
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
