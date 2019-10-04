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

import com.techsoft.entity.common.ScadaSpi;
import com.techsoft.entity.scada.ScadaSpiVo;
import com.techsoft.entity.scada.ScadaSpiParamVo;
import com.techsoft.service.scada.ScadaSpiService;

@org.springframework.stereotype.Service
public class ClientScadaSpiServiceImpl extends BaseClientServiceImpl<ScadaSpi> implements ClientScadaSpiService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ScadaSpiService scadaSpiService;
    
	@Override
	public BaseService<ScadaSpi> getBaseService() {
		return scadaSpiService;
	}	    	
    
	private ScadaSpiVo getVo(ScadaSpi scadaSpi, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiVo vo = new ScadaSpiVo(scadaSpi);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private ScadaSpiVo getExtendVo(ScadaSpi scadaSpi, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiVo vo = this.getVo(scadaSpi, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<ScadaSpiVo> getVoList(List<ScadaSpi> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaSpiVo> voList = new ArrayList<ScadaSpiVo>();
		for (ScadaSpi entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<ScadaSpiVo> getExtendVoList(List<ScadaSpi> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaSpiVo> voList = new ArrayList<ScadaSpiVo>();
		for (ScadaSpi entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public ScadaSpiVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpi entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<ScadaSpiVo>  selectListVoByParamVo(ScadaSpiParamVo scadaSpi, CommonParam commonParam) throws BusinessException, SQLException {
		if(scadaSpi==null){
			scadaSpi = new ScadaSpiParamVo();
		}
	
		List<ScadaSpi> list = (List<ScadaSpi>) this.getBaseService().selectListByParamVo(scadaSpi, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaSpiVo> selectPageVoByParamVo(ScadaSpiParamVo scadaSpi, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaSpi==null){
			scadaSpi = new ScadaSpiParamVo();
		}
					
		PageInfo<ScadaSpi> list  = (PageInfo<ScadaSpi>) this.getBaseService().selectPageByParamVo(scadaSpi, commonParam, pageNo, pageSize);
		List<ScadaSpiVo> volist = new ArrayList<ScadaSpiVo>();
		
		Iterator<ScadaSpi> iter = list.getList().iterator();
		ScadaSpiVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaSpiVo> vpage = new Page<ScadaSpiVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ScadaSpiVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpi entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<ScadaSpiVo>  selectListExtendVoByParamVo(ScadaSpiParamVo scadaSpi, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(scadaSpi==null){
			scadaSpi = new ScadaSpiParamVo();
		}
					
		List<ScadaSpi> list = (List<ScadaSpi>) this.getBaseService().selectListByParamVo(scadaSpi, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaSpiVo> selectPageExtendVoByParamVo(ScadaSpiParamVo scadaSpi, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaSpi==null){
			scadaSpi = new ScadaSpiParamVo();
		}
					
		PageInfo<ScadaSpi> list  = (PageInfo<ScadaSpi>) this.getBaseService().selectPageByParamVo(scadaSpi, commonParam, pageNo, pageSize);
		List<ScadaSpiVo> volist = new ArrayList<ScadaSpiVo>();
		
		Iterator<ScadaSpi> iter = list.getList().iterator();
		ScadaSpiVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaSpiVo> vpage = new Page<ScadaSpiVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(ScadaSpiParamVo scadaSpiParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		ScadaSpi scadaSpi = null;
		try {
			if (scadaSpiParamVo.getId() == null) {//新增
			 
				scadaSpi = scadaSpiService.saveOrUpdate(scadaSpiParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				ScadaSpi scadaSpiVoTemp = this.selectById(scadaSpiParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(scadaSpiVoTemp,
						scadaSpiParamVo);
  
				scadaSpi = scadaSpiService.saveOrUpdate(
						scadaSpiVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(scadaSpi);
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
