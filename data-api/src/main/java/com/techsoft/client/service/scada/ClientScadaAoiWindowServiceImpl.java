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

import com.techsoft.entity.common.ScadaAoiWindow;
import com.techsoft.entity.scada.ScadaAoiWindowVo;
import com.techsoft.entity.scada.ScadaAoiWindowParamVo;
import com.techsoft.service.scada.ScadaAoiWindowService;

@org.springframework.stereotype.Service
public class ClientScadaAoiWindowServiceImpl extends BaseClientServiceImpl<ScadaAoiWindow> implements ClientScadaAoiWindowService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ScadaAoiWindowService scadaAoiWindowService;
    
	@Override
	public BaseService<ScadaAoiWindow> getBaseService() {
		return scadaAoiWindowService;
	}	    	
    
	private ScadaAoiWindowVo getVo(ScadaAoiWindow scadaAoiWindow, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiWindowVo vo = new ScadaAoiWindowVo(scadaAoiWindow);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private ScadaAoiWindowVo getExtendVo(ScadaAoiWindow scadaAoiWindow, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiWindowVo vo = this.getVo(scadaAoiWindow, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<ScadaAoiWindowVo> getVoList(List<ScadaAoiWindow> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaAoiWindowVo> voList = new ArrayList<ScadaAoiWindowVo>();
		for (ScadaAoiWindow entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<ScadaAoiWindowVo> getExtendVoList(List<ScadaAoiWindow> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaAoiWindowVo> voList = new ArrayList<ScadaAoiWindowVo>();
		for (ScadaAoiWindow entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public ScadaAoiWindowVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiWindow entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<ScadaAoiWindowVo>  selectListVoByParamVo(ScadaAoiWindowParamVo scadaAoiWindow, CommonParam commonParam) throws BusinessException, SQLException {
		if(scadaAoiWindow==null){
			scadaAoiWindow = new ScadaAoiWindowParamVo();
		}
	
		List<ScadaAoiWindow> list = (List<ScadaAoiWindow>) this.getBaseService().selectListByParamVo(scadaAoiWindow, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaAoiWindowVo> selectPageVoByParamVo(ScadaAoiWindowParamVo scadaAoiWindow, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaAoiWindow==null){
			scadaAoiWindow = new ScadaAoiWindowParamVo();
		}
					
		PageInfo<ScadaAoiWindow> list  = (PageInfo<ScadaAoiWindow>) this.getBaseService().selectPageByParamVo(scadaAoiWindow, commonParam, pageNo, pageSize);
		List<ScadaAoiWindowVo> volist = new ArrayList<ScadaAoiWindowVo>();
		
		Iterator<ScadaAoiWindow> iter = list.getList().iterator();
		ScadaAoiWindowVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaAoiWindowVo> vpage = new Page<ScadaAoiWindowVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ScadaAoiWindowVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiWindow entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<ScadaAoiWindowVo>  selectListExtendVoByParamVo(ScadaAoiWindowParamVo scadaAoiWindow, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(scadaAoiWindow==null){
			scadaAoiWindow = new ScadaAoiWindowParamVo();
		}
					
		List<ScadaAoiWindow> list = (List<ScadaAoiWindow>) this.getBaseService().selectListByParamVo(scadaAoiWindow, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaAoiWindowVo> selectPageExtendVoByParamVo(ScadaAoiWindowParamVo scadaAoiWindow, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaAoiWindow==null){
			scadaAoiWindow = new ScadaAoiWindowParamVo();
		}
					
		PageInfo<ScadaAoiWindow> list  = (PageInfo<ScadaAoiWindow>) this.getBaseService().selectPageByParamVo(scadaAoiWindow, commonParam, pageNo, pageSize);
		List<ScadaAoiWindowVo> volist = new ArrayList<ScadaAoiWindowVo>();
		
		Iterator<ScadaAoiWindow> iter = list.getList().iterator();
		ScadaAoiWindowVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaAoiWindowVo> vpage = new Page<ScadaAoiWindowVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(ScadaAoiWindowParamVo scadaAoiWindowParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		ScadaAoiWindow scadaAoiWindow = null;
		try {
			if (scadaAoiWindowParamVo.getId() == null) {//新增
			 
				scadaAoiWindow = scadaAoiWindowService.saveOrUpdate(scadaAoiWindowParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				ScadaAoiWindow scadaAoiWindowVoTemp = this.selectById(scadaAoiWindowParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(scadaAoiWindowVoTemp,
						scadaAoiWindowParamVo);
  
				scadaAoiWindow = scadaAoiWindowService.saveOrUpdate(
						scadaAoiWindowVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(scadaAoiWindow);
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
