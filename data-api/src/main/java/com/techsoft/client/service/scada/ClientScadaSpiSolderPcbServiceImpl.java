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

import com.techsoft.entity.common.ScadaSpiSolderPcb;
import com.techsoft.entity.scada.ScadaSpiSolderPcbVo;
import com.techsoft.entity.scada.ScadaSpiSolderPcbParamVo;
import com.techsoft.service.scada.ScadaSpiSolderPcbService;

@org.springframework.stereotype.Service
public class ClientScadaSpiSolderPcbServiceImpl extends BaseClientServiceImpl<ScadaSpiSolderPcb> implements ClientScadaSpiSolderPcbService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ScadaSpiSolderPcbService scadaSpiSolderPcbService;
    
	@Override
	public BaseService<ScadaSpiSolderPcb> getBaseService() {
		return scadaSpiSolderPcbService;
	}	    	
    
	private ScadaSpiSolderPcbVo getVo(ScadaSpiSolderPcb scadaSpiSolderPcb, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiSolderPcbVo vo = new ScadaSpiSolderPcbVo(scadaSpiSolderPcb);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private ScadaSpiSolderPcbVo getExtendVo(ScadaSpiSolderPcb scadaSpiSolderPcb, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiSolderPcbVo vo = this.getVo(scadaSpiSolderPcb, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<ScadaSpiSolderPcbVo> getVoList(List<ScadaSpiSolderPcb> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaSpiSolderPcbVo> voList = new ArrayList<ScadaSpiSolderPcbVo>();
		for (ScadaSpiSolderPcb entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<ScadaSpiSolderPcbVo> getExtendVoList(List<ScadaSpiSolderPcb> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaSpiSolderPcbVo> voList = new ArrayList<ScadaSpiSolderPcbVo>();
		for (ScadaSpiSolderPcb entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public ScadaSpiSolderPcbVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiSolderPcb entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<ScadaSpiSolderPcbVo>  selectListVoByParamVo(ScadaSpiSolderPcbParamVo scadaSpiSolderPcb, CommonParam commonParam) throws BusinessException, SQLException {
		if(scadaSpiSolderPcb==null){
			scadaSpiSolderPcb = new ScadaSpiSolderPcbParamVo();
		}
	
		List<ScadaSpiSolderPcb> list = (List<ScadaSpiSolderPcb>) this.getBaseService().selectListByParamVo(scadaSpiSolderPcb, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaSpiSolderPcbVo> selectPageVoByParamVo(ScadaSpiSolderPcbParamVo scadaSpiSolderPcb, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaSpiSolderPcb==null){
			scadaSpiSolderPcb = new ScadaSpiSolderPcbParamVo();
		}
					
		PageInfo<ScadaSpiSolderPcb> list  = (PageInfo<ScadaSpiSolderPcb>) this.getBaseService().selectPageByParamVo(scadaSpiSolderPcb, commonParam, pageNo, pageSize);
		List<ScadaSpiSolderPcbVo> volist = new ArrayList<ScadaSpiSolderPcbVo>();
		
		Iterator<ScadaSpiSolderPcb> iter = list.getList().iterator();
		ScadaSpiSolderPcbVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaSpiSolderPcbVo> vpage = new Page<ScadaSpiSolderPcbVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ScadaSpiSolderPcbVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiSolderPcb entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<ScadaSpiSolderPcbVo>  selectListExtendVoByParamVo(ScadaSpiSolderPcbParamVo scadaSpiSolderPcb, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(scadaSpiSolderPcb==null){
			scadaSpiSolderPcb = new ScadaSpiSolderPcbParamVo();
		}
					
		List<ScadaSpiSolderPcb> list = (List<ScadaSpiSolderPcb>) this.getBaseService().selectListByParamVo(scadaSpiSolderPcb, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaSpiSolderPcbVo> selectPageExtendVoByParamVo(ScadaSpiSolderPcbParamVo scadaSpiSolderPcb, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaSpiSolderPcb==null){
			scadaSpiSolderPcb = new ScadaSpiSolderPcbParamVo();
		}
					
		PageInfo<ScadaSpiSolderPcb> list  = (PageInfo<ScadaSpiSolderPcb>) this.getBaseService().selectPageByParamVo(scadaSpiSolderPcb, commonParam, pageNo, pageSize);
		List<ScadaSpiSolderPcbVo> volist = new ArrayList<ScadaSpiSolderPcbVo>();
		
		Iterator<ScadaSpiSolderPcb> iter = list.getList().iterator();
		ScadaSpiSolderPcbVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaSpiSolderPcbVo> vpage = new Page<ScadaSpiSolderPcbVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(ScadaSpiSolderPcbParamVo scadaSpiSolderPcbParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		ScadaSpiSolderPcb scadaSpiSolderPcb = null;
		try {
			if (scadaSpiSolderPcbParamVo.getId() == null) {//新增
			 
				scadaSpiSolderPcb = scadaSpiSolderPcbService.saveOrUpdate(scadaSpiSolderPcbParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				ScadaSpiSolderPcb scadaSpiSolderPcbVoTemp = this.selectById(scadaSpiSolderPcbParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(scadaSpiSolderPcbVoTemp,
						scadaSpiSolderPcbParamVo);
  
				scadaSpiSolderPcb = scadaSpiSolderPcbService.saveOrUpdate(
						scadaSpiSolderPcbVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(scadaSpiSolderPcb);
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
