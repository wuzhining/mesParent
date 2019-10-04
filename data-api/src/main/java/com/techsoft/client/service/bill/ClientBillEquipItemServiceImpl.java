package com.techsoft.client.service.bill;

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
import com.techsoft.entity.common.BillEquip;
import com.techsoft.entity.common.BillEquipItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.bill.BillEquipItemVo;
import com.techsoft.entity.bill.BillEquipItemParamVo;
import com.techsoft.service.bill.BillEquipItemService;
import com.techsoft.service.bill.BillEquipService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.equip.EquipWorkService;

@org.springframework.stereotype.Service
public class ClientBillEquipItemServiceImpl extends BaseClientServiceImpl<BillEquipItem> implements ClientBillEquipItemService {
	@com.alibaba.dubbo.config.annotation.Reference
	private BillEquipItemService billEquipItemService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillEquipService billEquipService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipWorkService EquipWorkService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
    
	@Override
	public BaseService<BillEquipItem> getBaseService() {
		return billEquipItemService;
	}	    	
    
	private BillEquipItemVo getVo(BillEquipItem billEquipItem, CommonParam commonParam) throws BusinessException, SQLException {
		BillEquipItemVo vo = new BillEquipItemVo(billEquipItem);
		// TODO 此处填充其它关联字段的处理代码
		//设备单据
		if(vo.getBillEquipId() != null && vo.getBillEquipId() > 0L){
			BillEquip billEquip = billEquipService.selectById(vo.getBillEquipId(), commonParam);
			if(billEquip != null){
				vo.setBillEquip(billEquip);
			}
		}
		//设备
		if(vo.getEquipWorkId() != null && vo.getEquipWorkId() > 0L){
			EquipWork equipWork = EquipWorkService.selectById(vo.getEquipWorkId(), commonParam);
			if(equipWork != null){
				vo.setEquipWork(equipWork);
			}
		}
		//设备
		if(vo.getDealResultDictId() != null && vo.getDealResultDictId() > 0L){
			ConfigDictionary dealResult = configDictionaryService.selectById(vo.getDealResultDictId(), commonParam);
			if(dealResult != null){
				vo.setDealResult(dealResult);
			}
		}
		return vo;
	} 
	
	private BillEquipItemVo getExtendVo(BillEquipItem billEquipItem, CommonParam commonParam) throws BusinessException, SQLException {
		BillEquipItemVo vo = this.getVo(billEquipItem, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<BillEquipItemVo> getVoList(List<BillEquipItem> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<BillEquipItemVo> voList = new ArrayList<BillEquipItemVo>();
		for (BillEquipItem entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<BillEquipItemVo> getExtendVoList(List<BillEquipItem> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<BillEquipItemVo> voList = new ArrayList<BillEquipItemVo>();
		for (BillEquipItem entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public BillEquipItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillEquipItem entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<BillEquipItemVo>  selectListVoByParamVo(BillEquipItemParamVo billEquipItem, CommonParam commonParam) throws BusinessException, SQLException {
		if(billEquipItem==null){
			billEquipItem = new BillEquipItemParamVo();
		}
		billEquipItem.setTenantId(commonParam.getTenantId());	
	
		List<BillEquipItem> list = (List<BillEquipItem>) this.getBaseService().selectListByParamVo(billEquipItem, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<BillEquipItemVo> selectPageVoByParamVo(BillEquipItemParamVo billEquipItem, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(billEquipItem==null){
			billEquipItem = new BillEquipItemParamVo();
		}
		billEquipItem.setTenantId(commonParam.getTenantId());	
					
		PageInfo<BillEquipItem> list  = (PageInfo<BillEquipItem>) this.getBaseService().selectPageByParamVo(billEquipItem, commonParam, pageNo, pageSize);
		List<BillEquipItemVo> volist = new ArrayList<BillEquipItemVo>();
		
		Iterator<BillEquipItem> iter = list.getList().iterator();
		BillEquipItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<BillEquipItemVo> vpage = new Page<BillEquipItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public BillEquipItemVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillEquipItem entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<BillEquipItemVo>  selectListExtendVoByParamVo(BillEquipItemParamVo billEquipItem, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(billEquipItem==null){
			billEquipItem = new BillEquipItemParamVo();
		}
		billEquipItem.setTenantId(commonParam.getTenantId());	
					
		List<BillEquipItem> list = (List<BillEquipItem>) this.getBaseService().selectListByParamVo(billEquipItem, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<BillEquipItemVo> selectPageExtendVoByParamVo(BillEquipItemParamVo billEquipItem, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(billEquipItem==null){
			billEquipItem = new BillEquipItemParamVo();
		}
		billEquipItem.setTenantId(commonParam.getTenantId());	
					
		PageInfo<BillEquipItem> list  = (PageInfo<BillEquipItem>) this.getBaseService().selectPageByParamVo(billEquipItem, commonParam, pageNo, pageSize);
		List<BillEquipItemVo> volist = new ArrayList<BillEquipItemVo>();
		
		Iterator<BillEquipItem> iter = list.getList().iterator();
		BillEquipItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<BillEquipItemVo> vpage = new Page<BillEquipItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(BillEquipItemParamVo billEquipItemParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		BillEquipItem billEquipItem = null;
		try {
			if (billEquipItemParamVo.getId() == null) {//新增
			 
				billEquipItemParamVo.setTenantId(commonParam.getTenantId());
				billEquipItem = billEquipItemService.saveOrUpdate(billEquipItemParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				BillEquipItem billEquipItemVoTemp = this.selectById(billEquipItemParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(billEquipItemVoTemp,
						billEquipItemParamVo);
  
				billEquipItem = billEquipItemService.saveOrUpdate(
						billEquipItemVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(billEquipItem);
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
