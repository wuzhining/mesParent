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

import com.techsoft.entity.common.ScadaDfldip;
import com.techsoft.entity.scada.ScadaDfldipVo;
import com.techsoft.entity.scada.ScadaDfldipParamVo;
import com.techsoft.service.scada.ScadaDfldipService;

@org.springframework.stereotype.Service
public class ClientScadaDfldipServiceImpl extends BaseClientServiceImpl<ScadaDfldip> implements ClientScadaDfldipService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ScadaDfldipService scadaDfldipService;
    
	@Override
	public BaseService<ScadaDfldip> getBaseService() {
		return scadaDfldipService;
	}	    	
    
	private ScadaDfldipVo getVo(ScadaDfldip scadaDfldip, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaDfldipVo vo = new ScadaDfldipVo(scadaDfldip);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private ScadaDfldipVo getExtendVo(ScadaDfldip scadaDfldip, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaDfldipVo vo = this.getVo(scadaDfldip, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<ScadaDfldipVo> getVoList(List<ScadaDfldip> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaDfldipVo> voList = new ArrayList<ScadaDfldipVo>();
		for (ScadaDfldip entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<ScadaDfldipVo> getExtendVoList(List<ScadaDfldip> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaDfldipVo> voList = new ArrayList<ScadaDfldipVo>();
		for (ScadaDfldip entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public ScadaDfldipVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaDfldip entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<ScadaDfldipVo>  selectListVoByParamVo(ScadaDfldipParamVo scadaDfldip, CommonParam commonParam) throws BusinessException, SQLException {
		if(scadaDfldip==null){
			scadaDfldip = new ScadaDfldipParamVo();
		}
//		scadaDfldip.setTenantId(commonParam.getTenantId());	
	
		List<ScadaDfldip> list = (List<ScadaDfldip>) this.getBaseService().selectListByParamVo(scadaDfldip, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaDfldipVo> selectPageVoByParamVo(ScadaDfldipParamVo scadaDfldip, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaDfldip==null){
			scadaDfldip = new ScadaDfldipParamVo();
		}
//		scadaDfldip.setTenantId(commonParam.getTenantId());	
					
		PageInfo<ScadaDfldip> list  = (PageInfo<ScadaDfldip>) this.getBaseService().selectPageByParamVo(scadaDfldip, commonParam, pageNo, pageSize);
		List<ScadaDfldipVo> volist = new ArrayList<ScadaDfldipVo>();
		
		Iterator<ScadaDfldip> iter = list.getList().iterator();
		ScadaDfldipVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaDfldipVo> vpage = new Page<ScadaDfldipVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ScadaDfldipVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaDfldip entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<ScadaDfldipVo>  selectListExtendVoByParamVo(ScadaDfldipParamVo scadaDfldip, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(scadaDfldip==null){
			scadaDfldip = new ScadaDfldipParamVo();
		}
//		scadaDfldip.setTenantId(commonParam.getTenantId());	
					
		List<ScadaDfldip> list = (List<ScadaDfldip>) this.getBaseService().selectListByParamVo(scadaDfldip, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaDfldipVo> selectPageExtendVoByParamVo(ScadaDfldipParamVo scadaDfldip, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaDfldip==null){
			scadaDfldip = new ScadaDfldipParamVo();
		}
//		scadaDfldip.setTenantId(commonParam.getTenantId());	
					
		PageInfo<ScadaDfldip> list  = (PageInfo<ScadaDfldip>) this.getBaseService().selectPageByParamVo(scadaDfldip, commonParam, pageNo, pageSize);
		List<ScadaDfldipVo> volist = new ArrayList<ScadaDfldipVo>();
		
		Iterator<ScadaDfldip> iter = list.getList().iterator();
		ScadaDfldipVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaDfldipVo> vpage = new Page<ScadaDfldipVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(ScadaDfldipParamVo scadaDfldipParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		ScadaDfldip scadaDfldip = null;
		try {
			if (scadaDfldipParamVo.getId() == null) {//新增
			 
//				scadaDfldipParamVo.setTenantId(commonParam.getTenantId());
				scadaDfldip = scadaDfldipService.saveOrUpdate(scadaDfldipParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				ScadaDfldip scadaDfldipVoTemp = this.selectById(scadaDfldipParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(scadaDfldipVoTemp,
						scadaDfldipParamVo);
  
				scadaDfldip = scadaDfldipService.saveOrUpdate(
						scadaDfldipVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(scadaDfldip);
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
