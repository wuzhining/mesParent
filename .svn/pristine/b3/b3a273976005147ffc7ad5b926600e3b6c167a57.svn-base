package com.techsoft.client.service.equip;

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

import com.techsoft.entity.common.EquipWorkProduct;
import com.techsoft.entity.equip.EquipWorkProductVo;
import com.techsoft.entity.equip.EquipWorkProductParamVo;
import com.techsoft.service.equip.EquipWorkProductService;

@org.springframework.stereotype.Service
public class ClientEquipWorkProductServiceImpl extends BaseClientServiceImpl<EquipWorkProduct> implements ClientEquipWorkProductService {
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipWorkProductService equipWorkProductService;
    
	@Override
	public BaseService<EquipWorkProduct> getBaseService() {
		return equipWorkProductService;
	}	    	
    
	private EquipWorkProductVo getVo(EquipWorkProduct equipWorkProduct, CommonParam commonParam) throws BusinessException, SQLException {
		EquipWorkProductVo vo = new EquipWorkProductVo(equipWorkProduct);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private EquipWorkProductVo getExtendVo(EquipWorkProduct equipWorkProduct, CommonParam commonParam) throws BusinessException, SQLException {
		EquipWorkProductVo vo = this.getVo(equipWorkProduct, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<EquipWorkProductVo> getVoList(List<EquipWorkProduct> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipWorkProductVo> voList = new ArrayList<EquipWorkProductVo>();
		for (EquipWorkProduct entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<EquipWorkProductVo> getExtendVoList(List<EquipWorkProduct> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipWorkProductVo> voList = new ArrayList<EquipWorkProductVo>();
		for (EquipWorkProduct entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public EquipWorkProductVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipWorkProduct entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<EquipWorkProductVo>  selectListVoByParamVo(EquipWorkProductParamVo equipWorkProduct, CommonParam commonParam) throws BusinessException, SQLException {
		if(equipWorkProduct==null){
			equipWorkProduct = new EquipWorkProductParamVo();
		}
		equipWorkProduct.setTenantId(commonParam.getTenantId());	
	
		List<EquipWorkProduct> list = (List<EquipWorkProduct>) this.getBaseService().selectListByParamVo(equipWorkProduct, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<EquipWorkProductVo> selectPageVoByParamVo(EquipWorkProductParamVo equipWorkProduct, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(equipWorkProduct==null){
			equipWorkProduct = new EquipWorkProductParamVo();
		}
		equipWorkProduct.setTenantId(commonParam.getTenantId());	
					
		PageInfo<EquipWorkProduct> list  = (PageInfo<EquipWorkProduct>) this.getBaseService().selectPageByParamVo(equipWorkProduct, commonParam, pageNo, pageSize);
		List<EquipWorkProductVo> volist = new ArrayList<EquipWorkProductVo>();
		
		Iterator<EquipWorkProduct> iter = list.getList().iterator();
		EquipWorkProductVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<EquipWorkProductVo> vpage = new Page<EquipWorkProductVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public EquipWorkProductVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipWorkProduct entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<EquipWorkProductVo>  selectListExtendVoByParamVo(EquipWorkProductParamVo equipWorkProduct, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(equipWorkProduct==null){
			equipWorkProduct = new EquipWorkProductParamVo();
		}
		equipWorkProduct.setTenantId(commonParam.getTenantId());	
					
		List<EquipWorkProduct> list = (List<EquipWorkProduct>) this.getBaseService().selectListByParamVo(equipWorkProduct, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<EquipWorkProductVo> selectPageExtendVoByParamVo(EquipWorkProductParamVo equipWorkProduct, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(equipWorkProduct==null){
			equipWorkProduct = new EquipWorkProductParamVo();
		}
		equipWorkProduct.setTenantId(commonParam.getTenantId());	
					
		PageInfo<EquipWorkProduct> list  = (PageInfo<EquipWorkProduct>) this.getBaseService().selectPageByParamVo(equipWorkProduct, commonParam, pageNo, pageSize);
		List<EquipWorkProductVo> volist = new ArrayList<EquipWorkProductVo>();
		
		Iterator<EquipWorkProduct> iter = list.getList().iterator();
		EquipWorkProductVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<EquipWorkProductVo> vpage = new Page<EquipWorkProductVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(EquipWorkProductParamVo equipWorkProductParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		EquipWorkProduct equipWorkProduct = null;
		try {
			if (equipWorkProductParamVo.getId() == null) {//新增
			 
				equipWorkProductParamVo.setTenantId(commonParam.getTenantId());
				equipWorkProduct = equipWorkProductService.saveOrUpdate(equipWorkProductParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				EquipWorkProduct equipWorkProductVoTemp = this.selectById(equipWorkProductParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(equipWorkProductVoTemp,
						equipWorkProductParamVo);
  
				equipWorkProduct = equipWorkProductService.saveOrUpdate(
						equipWorkProductVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(equipWorkProduct);
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
