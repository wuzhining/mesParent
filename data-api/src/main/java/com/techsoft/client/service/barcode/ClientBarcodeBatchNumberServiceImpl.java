package com.techsoft.client.service.barcode;

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

import com.techsoft.entity.common.BarcodeBatchNumber;
import com.techsoft.entity.barcode.BarcodeBatchNumberVo;
import com.techsoft.entity.barcode.BarcodeBatchNumberParamVo;
import com.techsoft.service.barcode.BarcodeBatchNumberService;

@org.springframework.stereotype.Service
public class ClientBarcodeBatchNumberServiceImpl extends BaseClientServiceImpl<BarcodeBatchNumber> implements ClientBarcodeBatchNumberService {
	@com.alibaba.dubbo.config.annotation.Reference
	private BarcodeBatchNumberService barcodeBatchNumberService;
    
	@Override
	public BaseService<BarcodeBatchNumber> getBaseService() {
		return barcodeBatchNumberService;
	}	    	
    
	private BarcodeBatchNumberVo getVo(BarcodeBatchNumber barcodeBatchNumber, CommonParam commonParam) throws BusinessException, SQLException {
		BarcodeBatchNumberVo vo = new BarcodeBatchNumberVo(barcodeBatchNumber);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private BarcodeBatchNumberVo getExtendVo(BarcodeBatchNumber barcodeBatchNumber, CommonParam commonParam) throws BusinessException, SQLException {
		BarcodeBatchNumberVo vo = this.getVo(barcodeBatchNumber, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<BarcodeBatchNumberVo> getVoList(List<BarcodeBatchNumber> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<BarcodeBatchNumberVo> voList = new ArrayList<BarcodeBatchNumberVo>();
		for (BarcodeBatchNumber entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<BarcodeBatchNumberVo> getExtendVoList(List<BarcodeBatchNumber> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<BarcodeBatchNumberVo> voList = new ArrayList<BarcodeBatchNumberVo>();
		for (BarcodeBatchNumber entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public BarcodeBatchNumberVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BarcodeBatchNumber entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<BarcodeBatchNumberVo>  selectListVoByParamVo(BarcodeBatchNumberParamVo barcodeBatchNumber, CommonParam commonParam) throws BusinessException, SQLException {
		if(barcodeBatchNumber==null){
			barcodeBatchNumber = new BarcodeBatchNumberParamVo();
		}
		barcodeBatchNumber.setTenantId(commonParam.getTenantId());	
	
		List<BarcodeBatchNumber> list = (List<BarcodeBatchNumber>) this.getBaseService().selectListByParamVo(barcodeBatchNumber, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<BarcodeBatchNumberVo> selectPageVoByParamVo(BarcodeBatchNumberParamVo barcodeBatchNumber, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(barcodeBatchNumber==null){
			barcodeBatchNumber = new BarcodeBatchNumberParamVo();
		}
		barcodeBatchNumber.setTenantId(commonParam.getTenantId());	
					
		PageInfo<BarcodeBatchNumber> list  = (PageInfo<BarcodeBatchNumber>) this.getBaseService().selectPageByParamVo(barcodeBatchNumber, commonParam, pageNo, pageSize);
		List<BarcodeBatchNumberVo> volist = new ArrayList<BarcodeBatchNumberVo>();
		
		Iterator<BarcodeBatchNumber> iter = list.getList().iterator();
		BarcodeBatchNumberVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<BarcodeBatchNumberVo> vpage = new Page<BarcodeBatchNumberVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public BarcodeBatchNumberVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BarcodeBatchNumber entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<BarcodeBatchNumberVo>  selectListExtendVoByParamVo(BarcodeBatchNumberParamVo barcodeBatchNumber, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(barcodeBatchNumber==null){
			barcodeBatchNumber = new BarcodeBatchNumberParamVo();
		}
		barcodeBatchNumber.setTenantId(commonParam.getTenantId());	
					
		List<BarcodeBatchNumber> list = (List<BarcodeBatchNumber>) this.getBaseService().selectListByParamVo(barcodeBatchNumber, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<BarcodeBatchNumberVo> selectPageExtendVoByParamVo(BarcodeBatchNumberParamVo barcodeBatchNumber, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(barcodeBatchNumber==null){
			barcodeBatchNumber = new BarcodeBatchNumberParamVo();
		}
		barcodeBatchNumber.setTenantId(commonParam.getTenantId());	
					
		PageInfo<BarcodeBatchNumber> list  = (PageInfo<BarcodeBatchNumber>) this.getBaseService().selectPageByParamVo(barcodeBatchNumber, commonParam, pageNo, pageSize);
		List<BarcodeBatchNumberVo> volist = new ArrayList<BarcodeBatchNumberVo>();
		
		Iterator<BarcodeBatchNumber> iter = list.getList().iterator();
		BarcodeBatchNumberVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<BarcodeBatchNumberVo> vpage = new Page<BarcodeBatchNumberVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(BarcodeBatchNumberParamVo barcodeBatchNumberParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		BarcodeBatchNumber barcodeBatchNumber = null;
		try {
			if (barcodeBatchNumberParamVo.getId() == null) {//新增
			 
				barcodeBatchNumberParamVo.setTenantId(commonParam.getTenantId());
				barcodeBatchNumber = barcodeBatchNumberService.saveOrUpdate(barcodeBatchNumberParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				BarcodeBatchNumber barcodeBatchNumberVoTemp = this.selectById(barcodeBatchNumberParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(barcodeBatchNumberVoTemp,
						barcodeBatchNumberParamVo);
  
				barcodeBatchNumber = barcodeBatchNumberService.saveOrUpdate(
						barcodeBatchNumberVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(barcodeBatchNumber);
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
