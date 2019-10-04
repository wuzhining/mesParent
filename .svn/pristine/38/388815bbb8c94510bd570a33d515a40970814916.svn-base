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

import com.techsoft.entity.common.ScadaAoi;
import com.techsoft.entity.scada.ScadaAoiVo;
import com.techsoft.entity.scada.ScadaAoiParamVo;
import com.techsoft.service.scada.ScadaAoiService;

@org.springframework.stereotype.Service
public class ClientScadaAoiServiceImpl extends BaseClientServiceImpl<ScadaAoi> implements ClientScadaAoiService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ScadaAoiService scadaAoiService;
    
	@Override
	public BaseService<ScadaAoi> getBaseService() {
		return scadaAoiService;
	}	    	
    
	private ScadaAoiVo getVo(ScadaAoi scadaAoi, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiVo vo = new ScadaAoiVo(scadaAoi);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private ScadaAoiVo getExtendVo(ScadaAoi scadaAoi, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiVo vo = this.getVo(scadaAoi, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<ScadaAoiVo> getVoList(List<ScadaAoi> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaAoiVo> voList = new ArrayList<ScadaAoiVo>();
		for (ScadaAoi entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<ScadaAoiVo> getExtendVoList(List<ScadaAoi> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaAoiVo> voList = new ArrayList<ScadaAoiVo>();
		for (ScadaAoi entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public ScadaAoiVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoi entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<ScadaAoiVo>  selectListVoByParamVo(ScadaAoiParamVo scadaAoi, CommonParam commonParam) throws BusinessException, SQLException {
		if(scadaAoi==null){
			scadaAoi = new ScadaAoiParamVo();
		}
	
		List<ScadaAoi> list = (List<ScadaAoi>) this.getBaseService().selectListByParamVo(scadaAoi, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaAoiVo> selectPageVoByParamVo(ScadaAoiParamVo scadaAoi, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaAoi==null){
			scadaAoi = new ScadaAoiParamVo();
		}
					
		PageInfo<ScadaAoi> list  = (PageInfo<ScadaAoi>) this.getBaseService().selectPageByParamVo(scadaAoi, commonParam, pageNo, pageSize);
		List<ScadaAoiVo> volist = new ArrayList<ScadaAoiVo>();
		
		Iterator<ScadaAoi> iter = list.getList().iterator();
		ScadaAoiVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaAoiVo> vpage = new Page<ScadaAoiVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ScadaAoiVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoi entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<ScadaAoiVo>  selectListExtendVoByParamVo(ScadaAoiParamVo scadaAoi, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(scadaAoi==null){
			scadaAoi = new ScadaAoiParamVo();
		}
					
		List<ScadaAoi> list = (List<ScadaAoi>) this.getBaseService().selectListByParamVo(scadaAoi, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaAoiVo> selectPageExtendVoByParamVo(ScadaAoiParamVo scadaAoi, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaAoi==null){
			scadaAoi = new ScadaAoiParamVo();
		}
					
		PageInfo<ScadaAoi> list  = (PageInfo<ScadaAoi>) this.getBaseService().selectPageByParamVo(scadaAoi, commonParam, pageNo, pageSize);
		List<ScadaAoiVo> volist = new ArrayList<ScadaAoiVo>();
		
		Iterator<ScadaAoi> iter = list.getList().iterator();
		ScadaAoiVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaAoiVo> vpage = new Page<ScadaAoiVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(ScadaAoiParamVo scadaAoiParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		ScadaAoi scadaAoi = null;
		try {
			if (scadaAoiParamVo.getId() == null) {//新增
			 
				scadaAoi = scadaAoiService.saveOrUpdate(scadaAoiParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				ScadaAoi scadaAoiVoTemp = this.selectById(scadaAoiParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(scadaAoiVoTemp,
						scadaAoiParamVo);
  
				scadaAoi = scadaAoiService.saveOrUpdate(
						scadaAoiVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(scadaAoi);
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
