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

import com.techsoft.entity.common.EquipFixtureProduct;
import com.techsoft.entity.equip.EquipFixtureProductVo;
import com.techsoft.entity.equip.EquipFixtureProductParamVo;
import com.techsoft.service.equip.EquipFixtureProductService;

@org.springframework.stereotype.Service
public class ClientEquipFixtureProductServiceImpl extends BaseClientServiceImpl<EquipFixtureProduct> implements ClientEquipFixtureProductService {
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipFixtureProductService equipFixtureProductService;
    
	@Override
	public BaseService<EquipFixtureProduct> getBaseService() {
		return equipFixtureProductService;
	}	    	
    
	private EquipFixtureProductVo getVo(EquipFixtureProduct equipFixtureProduct, CommonParam commonParam) throws BusinessException, SQLException {
		EquipFixtureProductVo vo = new EquipFixtureProductVo(equipFixtureProduct);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private EquipFixtureProductVo getExtendVo(EquipFixtureProduct equipFixtureProduct, CommonParam commonParam) throws BusinessException, SQLException {
		EquipFixtureProductVo vo = this.getVo(equipFixtureProduct, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<EquipFixtureProductVo> getVoList(List<EquipFixtureProduct> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipFixtureProductVo> voList = new ArrayList<EquipFixtureProductVo>();
		for (EquipFixtureProduct entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<EquipFixtureProductVo> getExtendVoList(List<EquipFixtureProduct> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipFixtureProductVo> voList = new ArrayList<EquipFixtureProductVo>();
		for (EquipFixtureProduct entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public EquipFixtureProductVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipFixtureProduct entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<EquipFixtureProductVo>  selectListVoByParamVo(EquipFixtureProductParamVo equipFixtureProduct, CommonParam commonParam) throws BusinessException, SQLException {
		if(equipFixtureProduct==null){
			equipFixtureProduct = new EquipFixtureProductParamVo();
		}
		equipFixtureProduct.setTenantId(commonParam.getTenantId());	
	
		List<EquipFixtureProduct> list = (List<EquipFixtureProduct>) this.getBaseService().selectListByParamVo(equipFixtureProduct, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<EquipFixtureProductVo> selectPageVoByParamVo(EquipFixtureProductParamVo equipFixtureProduct, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(equipFixtureProduct==null){
			equipFixtureProduct = new EquipFixtureProductParamVo();
		}
		equipFixtureProduct.setTenantId(commonParam.getTenantId());	
					
		PageInfo<EquipFixtureProduct> list  = (PageInfo<EquipFixtureProduct>) this.getBaseService().selectPageByParamVo(equipFixtureProduct, commonParam, pageNo, pageSize);
		List<EquipFixtureProductVo> volist = new ArrayList<EquipFixtureProductVo>();
		
		Iterator<EquipFixtureProduct> iter = list.getList().iterator();
		EquipFixtureProductVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<EquipFixtureProductVo> vpage = new Page<EquipFixtureProductVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public EquipFixtureProductVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipFixtureProduct entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<EquipFixtureProductVo>  selectListExtendVoByParamVo(EquipFixtureProductParamVo equipFixtureProduct, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(equipFixtureProduct==null){
			equipFixtureProduct = new EquipFixtureProductParamVo();
		}
		equipFixtureProduct.setTenantId(commonParam.getTenantId());	
					
		List<EquipFixtureProduct> list = (List<EquipFixtureProduct>) this.getBaseService().selectListByParamVo(equipFixtureProduct, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<EquipFixtureProductVo> selectPageExtendVoByParamVo(EquipFixtureProductParamVo equipFixtureProduct, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(equipFixtureProduct==null){
			equipFixtureProduct = new EquipFixtureProductParamVo();
		}
		equipFixtureProduct.setTenantId(commonParam.getTenantId());	
					
		PageInfo<EquipFixtureProduct> list  = (PageInfo<EquipFixtureProduct>) this.getBaseService().selectPageByParamVo(equipFixtureProduct, commonParam, pageNo, pageSize);
		List<EquipFixtureProductVo> volist = new ArrayList<EquipFixtureProductVo>();
		
		Iterator<EquipFixtureProduct> iter = list.getList().iterator();
		EquipFixtureProductVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<EquipFixtureProductVo> vpage = new Page<EquipFixtureProductVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(EquipFixtureProductParamVo equipFixtureProductParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		EquipFixtureProduct equipFixtureProduct = null;
		try {
			if (equipFixtureProductParamVo.getId() == null) {//新增
			 
				equipFixtureProductParamVo.setTenantId(commonParam.getTenantId());
				equipFixtureProduct = equipFixtureProductService.saveOrUpdate(equipFixtureProductParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				EquipFixtureProduct equipFixtureProductVoTemp = this.selectById(equipFixtureProductParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(equipFixtureProductVoTemp,
						equipFixtureProductParamVo);
  
				equipFixtureProduct = equipFixtureProductService.saveOrUpdate(
						equipFixtureProductVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(equipFixtureProduct);
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
