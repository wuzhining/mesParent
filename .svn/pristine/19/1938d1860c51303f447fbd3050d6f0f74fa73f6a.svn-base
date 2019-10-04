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

import com.techsoft.entity.common.ScadaSpiBarcode;
import com.techsoft.entity.scada.ScadaSpiBarcodeVo;
import com.techsoft.entity.scada.ScadaSpiBarcodeParamVo;
import com.techsoft.service.scada.ScadaSpiBarcodeService;

@org.springframework.stereotype.Service
public class ClientScadaSpiBarcodeServiceImpl extends BaseClientServiceImpl<ScadaSpiBarcode> implements ClientScadaSpiBarcodeService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ScadaSpiBarcodeService scadaSpiBarcodeService;
    
	@Override
	public BaseService<ScadaSpiBarcode> getBaseService() {
		return scadaSpiBarcodeService;
	}	    	
    
	private ScadaSpiBarcodeVo getVo(ScadaSpiBarcode scadaSpiBarcode, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiBarcodeVo vo = new ScadaSpiBarcodeVo(scadaSpiBarcode);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private ScadaSpiBarcodeVo getExtendVo(ScadaSpiBarcode scadaSpiBarcode, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiBarcodeVo vo = this.getVo(scadaSpiBarcode, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<ScadaSpiBarcodeVo> getVoList(List<ScadaSpiBarcode> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaSpiBarcodeVo> voList = new ArrayList<ScadaSpiBarcodeVo>();
		for (ScadaSpiBarcode entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<ScadaSpiBarcodeVo> getExtendVoList(List<ScadaSpiBarcode> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ScadaSpiBarcodeVo> voList = new ArrayList<ScadaSpiBarcodeVo>();
		for (ScadaSpiBarcode entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public ScadaSpiBarcodeVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiBarcode entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<ScadaSpiBarcodeVo>  selectListVoByParamVo(ScadaSpiBarcodeParamVo scadaSpiBarcode, CommonParam commonParam) throws BusinessException, SQLException {
		if(scadaSpiBarcode==null){
			scadaSpiBarcode = new ScadaSpiBarcodeParamVo();
		}
	
		List<ScadaSpiBarcode> list = (List<ScadaSpiBarcode>) this.getBaseService().selectListByParamVo(scadaSpiBarcode, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaSpiBarcodeVo> selectPageVoByParamVo(ScadaSpiBarcodeParamVo scadaSpiBarcode, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaSpiBarcode==null){
			scadaSpiBarcode = new ScadaSpiBarcodeParamVo();
		}
					
		PageInfo<ScadaSpiBarcode> list  = (PageInfo<ScadaSpiBarcode>) this.getBaseService().selectPageByParamVo(scadaSpiBarcode, commonParam, pageNo, pageSize);
		List<ScadaSpiBarcodeVo> volist = new ArrayList<ScadaSpiBarcodeVo>();
		
		Iterator<ScadaSpiBarcode> iter = list.getList().iterator();
		ScadaSpiBarcodeVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaSpiBarcodeVo> vpage = new Page<ScadaSpiBarcodeVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ScadaSpiBarcodeVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ScadaSpiBarcode entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<ScadaSpiBarcodeVo>  selectListExtendVoByParamVo(ScadaSpiBarcodeParamVo scadaSpiBarcode, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(scadaSpiBarcode==null){
			scadaSpiBarcode = new ScadaSpiBarcodeParamVo();
		}
					
		List<ScadaSpiBarcode> list = (List<ScadaSpiBarcode>) this.getBaseService().selectListByParamVo(scadaSpiBarcode, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ScadaSpiBarcodeVo> selectPageExtendVoByParamVo(ScadaSpiBarcodeParamVo scadaSpiBarcode, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(scadaSpiBarcode==null){
			scadaSpiBarcode = new ScadaSpiBarcodeParamVo();
		}
					
		PageInfo<ScadaSpiBarcode> list  = (PageInfo<ScadaSpiBarcode>) this.getBaseService().selectPageByParamVo(scadaSpiBarcode, commonParam, pageNo, pageSize);
		List<ScadaSpiBarcodeVo> volist = new ArrayList<ScadaSpiBarcodeVo>();
		
		Iterator<ScadaSpiBarcode> iter = list.getList().iterator();
		ScadaSpiBarcodeVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ScadaSpiBarcodeVo> vpage = new Page<ScadaSpiBarcodeVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(ScadaSpiBarcodeParamVo scadaSpiBarcodeParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		ScadaSpiBarcode scadaSpiBarcode = null;
		try {
			if (scadaSpiBarcodeParamVo.getId() == null) {//新增
			 
				scadaSpiBarcode = scadaSpiBarcodeService.saveOrUpdate(scadaSpiBarcodeParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				ScadaSpiBarcode scadaSpiBarcodeVoTemp = this.selectById(scadaSpiBarcodeParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(scadaSpiBarcodeVoTemp,
						scadaSpiBarcodeParamVo);
  
				scadaSpiBarcode = scadaSpiBarcodeService.saveOrUpdate(
						scadaSpiBarcodeVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(scadaSpiBarcode);
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
