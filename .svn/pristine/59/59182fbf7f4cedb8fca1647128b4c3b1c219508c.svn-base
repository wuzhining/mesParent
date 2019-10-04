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

import com.techsoft.entity.common.ScadaAoiLine;
import com.techsoft.entity.scada.ScadaAoiLineVo;
import com.techsoft.entity.scada.ScadaAoiLineParamVo;
import com.techsoft.service.scada.ScadaAoiLineService;

@org.springframework.stereotype.Service
public class ClientScadaAoiLineServiceImpl extends BaseClientServiceImpl<ScadaAoiLine> implements ClientScadaAoiLineService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ScadaAoiLineService scadaAoiLineService;
    
	@Override
	public BaseService<ScadaAoiLine> getBaseService() {
		return scadaAoiLineService;
	}	    	
    
	private ScadaAoiLineVo getVo(ScadaAoiLine scadaAoiLine, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiLineVo vo = new ScadaAoiLineVo(scadaAoiLine);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private ScadaAoiLineVo getExtendVo(ScadaAoiLine scadaAoiLine, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiLineVo vo = this.getVo(scadaAoiLine, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<ScadaAoiLineVo> getVoList(List<ScadaAoiLine> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaAoiLineVo> voList = new ArrayList<ScadaAoiLineVo>();
		for (ScadaAoiLine entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<ScadaAoiLineVo> getExtendVoList(List<ScadaAoiLine> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaAoiLineVo> voList = new ArrayList<ScadaAoiLineVo>();
		for (ScadaAoiLine entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public ScadaAoiLineVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiLine entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<ScadaAoiLineVo>  selectListVoByParamVo(ScadaAoiLineParamVo scadaAoiLine, CommonParam commonParam) throws BusinessException, SQLException {
		if(scadaAoiLine==null){
			scadaAoiLine = new ScadaAoiLineParamVo();
		}
	
		List<ScadaAoiLine> list = (List<ScadaAoiLine>) this.getBaseService().selectListByParamVo(scadaAoiLine, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaAoiLineVo> selectPageVoByParamVo(ScadaAoiLineParamVo scadaAoiLine, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaAoiLine==null){
			scadaAoiLine = new ScadaAoiLineParamVo();
		}
					
		PageInfo<ScadaAoiLine> list  = (PageInfo<ScadaAoiLine>) this.getBaseService().selectPageByParamVo(scadaAoiLine, commonParam, pageNo, pageSize);
		List<ScadaAoiLineVo> volist = new ArrayList<ScadaAoiLineVo>();
		
		Iterator<ScadaAoiLine> iter = list.getList().iterator();
		ScadaAoiLineVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaAoiLineVo> vpage = new Page<ScadaAoiLineVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ScadaAoiLineVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiLine entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<ScadaAoiLineVo>  selectListExtendVoByParamVo(ScadaAoiLineParamVo scadaAoiLine, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(scadaAoiLine==null){
			scadaAoiLine = new ScadaAoiLineParamVo();
		}
					
		List<ScadaAoiLine> list = (List<ScadaAoiLine>) this.getBaseService().selectListByParamVo(scadaAoiLine, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaAoiLineVo> selectPageExtendVoByParamVo(ScadaAoiLineParamVo scadaAoiLine, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaAoiLine==null){
			scadaAoiLine = new ScadaAoiLineParamVo();
		}
					
		PageInfo<ScadaAoiLine> list  = (PageInfo<ScadaAoiLine>) this.getBaseService().selectPageByParamVo(scadaAoiLine, commonParam, pageNo, pageSize);
		List<ScadaAoiLineVo> volist = new ArrayList<ScadaAoiLineVo>();
		
		Iterator<ScadaAoiLine> iter = list.getList().iterator();
		ScadaAoiLineVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaAoiLineVo> vpage = new Page<ScadaAoiLineVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(ScadaAoiLineParamVo scadaAoiLineParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		ScadaAoiLine scadaAoiLine = null;
		try {
			if (scadaAoiLineParamVo.getId() == null) {//新增
			 
				scadaAoiLine = scadaAoiLineService.saveOrUpdate(scadaAoiLineParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				ScadaAoiLine scadaAoiLineVoTemp = this.selectById(scadaAoiLineParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(scadaAoiLineVoTemp,
						scadaAoiLineParamVo);
  
				scadaAoiLine = scadaAoiLineService.saveOrUpdate(
						scadaAoiLineVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(scadaAoiLine);
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
