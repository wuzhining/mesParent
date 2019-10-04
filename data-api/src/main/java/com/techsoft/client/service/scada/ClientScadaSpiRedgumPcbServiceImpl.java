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

import com.techsoft.entity.common.ScadaSpiRedgumPcb;
import com.techsoft.entity.scada.ScadaSpiRedgumPcbVo;
import com.techsoft.entity.scada.ScadaSpiRedgumPcbParamVo;
import com.techsoft.service.scada.ScadaSpiRedgumPcbService;

@org.springframework.stereotype.Service
public class ClientScadaSpiRedgumPcbServiceImpl extends BaseClientServiceImpl<ScadaSpiRedgumPcb> implements ClientScadaSpiRedgumPcbService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ScadaSpiRedgumPcbService scadaSpiRedgumPcbService;
    
	@Override
	public BaseService<ScadaSpiRedgumPcb> getBaseService() {
		return scadaSpiRedgumPcbService;
	}	    	
    
	private ScadaSpiRedgumPcbVo getVo(ScadaSpiRedgumPcb scadaSpiRedgumPcb, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiRedgumPcbVo vo = new ScadaSpiRedgumPcbVo(scadaSpiRedgumPcb);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private ScadaSpiRedgumPcbVo getExtendVo(ScadaSpiRedgumPcb scadaSpiRedgumPcb, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiRedgumPcbVo vo = this.getVo(scadaSpiRedgumPcb, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<ScadaSpiRedgumPcbVo> getVoList(List<ScadaSpiRedgumPcb> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaSpiRedgumPcbVo> voList = new ArrayList<ScadaSpiRedgumPcbVo>();
		for (ScadaSpiRedgumPcb entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<ScadaSpiRedgumPcbVo> getExtendVoList(List<ScadaSpiRedgumPcb> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaSpiRedgumPcbVo> voList = new ArrayList<ScadaSpiRedgumPcbVo>();
		for (ScadaSpiRedgumPcb entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public ScadaSpiRedgumPcbVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiRedgumPcb entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<ScadaSpiRedgumPcbVo>  selectListVoByParamVo(ScadaSpiRedgumPcbParamVo scadaSpiRedgumPcb, CommonParam commonParam) throws BusinessException, SQLException {
		if(scadaSpiRedgumPcb==null){
			scadaSpiRedgumPcb = new ScadaSpiRedgumPcbParamVo();
		}
	
		List<ScadaSpiRedgumPcb> list = (List<ScadaSpiRedgumPcb>) this.getBaseService().selectListByParamVo(scadaSpiRedgumPcb, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaSpiRedgumPcbVo> selectPageVoByParamVo(ScadaSpiRedgumPcbParamVo scadaSpiRedgumPcb, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaSpiRedgumPcb==null){
			scadaSpiRedgumPcb = new ScadaSpiRedgumPcbParamVo();
		}
					
		PageInfo<ScadaSpiRedgumPcb> list  = (PageInfo<ScadaSpiRedgumPcb>) this.getBaseService().selectPageByParamVo(scadaSpiRedgumPcb, commonParam, pageNo, pageSize);
		List<ScadaSpiRedgumPcbVo> volist = new ArrayList<ScadaSpiRedgumPcbVo>();
		
		Iterator<ScadaSpiRedgumPcb> iter = list.getList().iterator();
		ScadaSpiRedgumPcbVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaSpiRedgumPcbVo> vpage = new Page<ScadaSpiRedgumPcbVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ScadaSpiRedgumPcbVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiRedgumPcb entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<ScadaSpiRedgumPcbVo>  selectListExtendVoByParamVo(ScadaSpiRedgumPcbParamVo scadaSpiRedgumPcb, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(scadaSpiRedgumPcb==null){
			scadaSpiRedgumPcb = new ScadaSpiRedgumPcbParamVo();
		}
					
		List<ScadaSpiRedgumPcb> list = (List<ScadaSpiRedgumPcb>) this.getBaseService().selectListByParamVo(scadaSpiRedgumPcb, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaSpiRedgumPcbVo> selectPageExtendVoByParamVo(ScadaSpiRedgumPcbParamVo scadaSpiRedgumPcb, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaSpiRedgumPcb==null){
			scadaSpiRedgumPcb = new ScadaSpiRedgumPcbParamVo();
		}
					
		PageInfo<ScadaSpiRedgumPcb> list  = (PageInfo<ScadaSpiRedgumPcb>) this.getBaseService().selectPageByParamVo(scadaSpiRedgumPcb, commonParam, pageNo, pageSize);
		List<ScadaSpiRedgumPcbVo> volist = new ArrayList<ScadaSpiRedgumPcbVo>();
		
		Iterator<ScadaSpiRedgumPcb> iter = list.getList().iterator();
		ScadaSpiRedgumPcbVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaSpiRedgumPcbVo> vpage = new Page<ScadaSpiRedgumPcbVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(ScadaSpiRedgumPcbParamVo scadaSpiRedgumPcbParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		ScadaSpiRedgumPcb scadaSpiRedgumPcb = null;
		try {
			if (scadaSpiRedgumPcbParamVo.getId() == null) {//新增
			 
				scadaSpiRedgumPcb = scadaSpiRedgumPcbService.saveOrUpdate(scadaSpiRedgumPcbParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				ScadaSpiRedgumPcb scadaSpiRedgumPcbVoTemp = this.selectById(scadaSpiRedgumPcbParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(scadaSpiRedgumPcbVoTemp,
						scadaSpiRedgumPcbParamVo);
  
				scadaSpiRedgumPcb = scadaSpiRedgumPcbService.saveOrUpdate(
						scadaSpiRedgumPcbVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(scadaSpiRedgumPcb);
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
