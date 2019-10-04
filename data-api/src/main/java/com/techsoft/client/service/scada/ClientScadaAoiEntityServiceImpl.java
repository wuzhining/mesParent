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

import com.techsoft.entity.common.ScadaAoiEntity;
import com.techsoft.entity.scada.ScadaAoiEntityVo;
import com.techsoft.entity.scada.ScadaAoiEntityParamVo;
import com.techsoft.service.scada.ScadaAoiEntityService;

@org.springframework.stereotype.Service
public class ClientScadaAoiEntityServiceImpl extends BaseClientServiceImpl<ScadaAoiEntity> implements ClientScadaAoiEntityService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ScadaAoiEntityService scadaAoiEntityService;
    
	@Override
	public BaseService<ScadaAoiEntity> getBaseService() {
		return scadaAoiEntityService;
	}	    	
    
	private ScadaAoiEntityVo getVo(ScadaAoiEntity scadaAoiEntity, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiEntityVo vo = new ScadaAoiEntityVo(scadaAoiEntity);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private ScadaAoiEntityVo getExtendVo(ScadaAoiEntity scadaAoiEntity, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiEntityVo vo = this.getVo(scadaAoiEntity, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<ScadaAoiEntityVo> getVoList(List<ScadaAoiEntity> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaAoiEntityVo> voList = new ArrayList<ScadaAoiEntityVo>();
		for (ScadaAoiEntity entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<ScadaAoiEntityVo> getExtendVoList(List<ScadaAoiEntity> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaAoiEntityVo> voList = new ArrayList<ScadaAoiEntityVo>();
		for (ScadaAoiEntity entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public ScadaAoiEntityVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiEntity entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<ScadaAoiEntityVo>  selectListVoByParamVo(ScadaAoiEntityParamVo scadaAoiEntity, CommonParam commonParam) throws BusinessException, SQLException {
		if(scadaAoiEntity==null){
			scadaAoiEntity = new ScadaAoiEntityParamVo();
		}
	
		List<ScadaAoiEntity> list = (List<ScadaAoiEntity>) this.getBaseService().selectListByParamVo(scadaAoiEntity, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaAoiEntityVo> selectPageVoByParamVo(ScadaAoiEntityParamVo scadaAoiEntity, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaAoiEntity==null){
			scadaAoiEntity = new ScadaAoiEntityParamVo();
		}
					
		PageInfo<ScadaAoiEntity> list  = (PageInfo<ScadaAoiEntity>) this.getBaseService().selectPageByParamVo(scadaAoiEntity, commonParam, pageNo, pageSize);
		List<ScadaAoiEntityVo> volist = new ArrayList<ScadaAoiEntityVo>();
		
		Iterator<ScadaAoiEntity> iter = list.getList().iterator();
		ScadaAoiEntityVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaAoiEntityVo> vpage = new Page<ScadaAoiEntityVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ScadaAoiEntityVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaAoiEntity entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<ScadaAoiEntityVo>  selectListExtendVoByParamVo(ScadaAoiEntityParamVo scadaAoiEntity, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(scadaAoiEntity==null){
			scadaAoiEntity = new ScadaAoiEntityParamVo();
		}
					
		List<ScadaAoiEntity> list = (List<ScadaAoiEntity>) this.getBaseService().selectListByParamVo(scadaAoiEntity, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaAoiEntityVo> selectPageExtendVoByParamVo(ScadaAoiEntityParamVo scadaAoiEntity, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaAoiEntity==null){
			scadaAoiEntity = new ScadaAoiEntityParamVo();
		}
					
		PageInfo<ScadaAoiEntity> list  = (PageInfo<ScadaAoiEntity>) this.getBaseService().selectPageByParamVo(scadaAoiEntity, commonParam, pageNo, pageSize);
		List<ScadaAoiEntityVo> volist = new ArrayList<ScadaAoiEntityVo>();
		
		Iterator<ScadaAoiEntity> iter = list.getList().iterator();
		ScadaAoiEntityVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaAoiEntityVo> vpage = new Page<ScadaAoiEntityVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(ScadaAoiEntityParamVo scadaAoiEntityParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		ScadaAoiEntity scadaAoiEntity = null;
		try {
			if (scadaAoiEntityParamVo.getId() == null) {//新增
			 
				scadaAoiEntity = scadaAoiEntityService.saveOrUpdate(scadaAoiEntityParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				ScadaAoiEntity scadaAoiEntityVoTemp = this.selectById(scadaAoiEntityParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(scadaAoiEntityVoTemp,
						scadaAoiEntityParamVo);
  
				scadaAoiEntity = scadaAoiEntityService.saveOrUpdate(
						scadaAoiEntityVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(scadaAoiEntity);
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
