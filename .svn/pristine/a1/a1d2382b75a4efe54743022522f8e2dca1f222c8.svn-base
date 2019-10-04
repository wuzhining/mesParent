package com.techsoft.client.service.product;

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

import com.techsoft.entity.common.ProductBomItemRepalce;
import com.techsoft.entity.product.ProductBomItemRepalceVo;
import com.techsoft.entity.product.ProductBomItemRepalceParamVo;
import com.techsoft.service.product.ProductBomItemRepalceService;

@org.springframework.stereotype.Service
public class ClientProductBomItemRepalceServiceImpl extends BaseClientServiceImpl<ProductBomItemRepalce> implements ClientProductBomItemRepalceService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductBomItemRepalceService productBomItemRepalceService;
    
	@Override
	public BaseService<ProductBomItemRepalce> getBaseService() {
		return productBomItemRepalceService;
	}	    	
    
	private ProductBomItemRepalceVo getVo(ProductBomItemRepalce productBomItemRepalce, CommonParam commonParam) throws BusinessException, SQLException {
		ProductBomItemRepalceVo vo = new ProductBomItemRepalceVo(productBomItemRepalce);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private ProductBomItemRepalceVo getExtendVo(ProductBomItemRepalce productBomItemRepalce, CommonParam commonParam) throws BusinessException, SQLException {
		ProductBomItemRepalceVo vo = this.getVo(productBomItemRepalce, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<ProductBomItemRepalceVo> getVoList(List<ProductBomItemRepalce> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ProductBomItemRepalceVo> voList = new ArrayList<ProductBomItemRepalceVo>();
		for (ProductBomItemRepalce entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<ProductBomItemRepalceVo> getExtendVoList(List<ProductBomItemRepalce> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<ProductBomItemRepalceVo> voList = new ArrayList<ProductBomItemRepalceVo>();
		for (ProductBomItemRepalce entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public ProductBomItemRepalceVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ProductBomItemRepalce entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<ProductBomItemRepalceVo>  selectListVoByParamVo(ProductBomItemRepalceParamVo productBomItemRepalce, CommonParam commonParam) throws BusinessException, SQLException {
		if(productBomItemRepalce==null){
			productBomItemRepalce = new ProductBomItemRepalceParamVo();
		}
		productBomItemRepalce.setTenantId(commonParam.getTenantId());	
	
		List<ProductBomItemRepalce> list = (List<ProductBomItemRepalce>) this.getBaseService().selectListByParamVo(productBomItemRepalce, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ProductBomItemRepalceVo> selectPageVoByParamVo(ProductBomItemRepalceParamVo productBomItemRepalce, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(productBomItemRepalce==null){
			productBomItemRepalce = new ProductBomItemRepalceParamVo();
		}
		productBomItemRepalce.setTenantId(commonParam.getTenantId());	
					
		PageInfo<ProductBomItemRepalce> list  = (PageInfo<ProductBomItemRepalce>) this.getBaseService().selectPageByParamVo(productBomItemRepalce, commonParam, pageNo, pageSize);
		List<ProductBomItemRepalceVo> volist = new ArrayList<ProductBomItemRepalceVo>();
		
		Iterator<ProductBomItemRepalce> iter = list.getList().iterator();
		ProductBomItemRepalceVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ProductBomItemRepalceVo> vpage = new Page<ProductBomItemRepalceVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ProductBomItemRepalceVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ProductBomItemRepalce entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<ProductBomItemRepalceVo>  selectListExtendVoByParamVo(ProductBomItemRepalceParamVo productBomItemRepalce, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(productBomItemRepalce==null){
			productBomItemRepalce = new ProductBomItemRepalceParamVo();
		}
		productBomItemRepalce.setTenantId(commonParam.getTenantId());	
					
		List<ProductBomItemRepalce> list = (List<ProductBomItemRepalce>) this.getBaseService().selectListByParamVo(productBomItemRepalce, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<ProductBomItemRepalceVo> selectPageExtendVoByParamVo(ProductBomItemRepalceParamVo productBomItemRepalce, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(productBomItemRepalce==null){
			productBomItemRepalce = new ProductBomItemRepalceParamVo();
		}
		productBomItemRepalce.setTenantId(commonParam.getTenantId());	
					
		PageInfo<ProductBomItemRepalce> list  = (PageInfo<ProductBomItemRepalce>) this.getBaseService().selectPageByParamVo(productBomItemRepalce, commonParam, pageNo, pageSize);
		List<ProductBomItemRepalceVo> volist = new ArrayList<ProductBomItemRepalceVo>();
		
		Iterator<ProductBomItemRepalce> iter = list.getList().iterator();
		ProductBomItemRepalceVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<ProductBomItemRepalceVo> vpage = new Page<ProductBomItemRepalceVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(ProductBomItemRepalceParamVo productBomItemRepalceParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		ProductBomItemRepalce productBomItemRepalce = null;
		try {
			if (productBomItemRepalceParamVo.getId() == null) {//新增
			 
				productBomItemRepalceParamVo.setTenantId(commonParam.getTenantId());
				productBomItemRepalce = productBomItemRepalceService.saveOrUpdate(productBomItemRepalceParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				ProductBomItemRepalce productBomItemRepalceVoTemp = this.selectById(productBomItemRepalceParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(productBomItemRepalceVoTemp,
						productBomItemRepalceParamVo);
  
				productBomItemRepalce = productBomItemRepalceService.saveOrUpdate(
						productBomItemRepalceVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(productBomItemRepalce);
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
