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
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.bill.BillEquipVo;
import com.techsoft.entity.bill.BillEquipParamVo;
import com.techsoft.service.bill.BillEquipService;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.firm.FirmDepartmentService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructWorkshopService;

@org.springframework.stereotype.Service
public class ClientBillEquipServiceImpl extends BaseClientServiceImpl<BillEquip> implements ClientBillEquipService {
	@com.alibaba.dubbo.config.annotation.Reference
	private BillEquipService billEquipService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopService structWorkshopService;
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmDepartmentService firmDepartmentService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
    
	@Override
	public BaseService<BillEquip> getBaseService() {
		return billEquipService;
	}	    	
    
	private BillEquipVo getVo(BillEquip billEquip, CommonParam commonParam) throws BusinessException, SQLException {
		BillEquipVo vo = new BillEquipVo(billEquip);
		// TODO 此处填充其它关联字段的处理代码
		//单据类型
		if(vo.getBillTypeFixtureDictId() != null && vo.getBillTypeFixtureDictId() >0L){
			ConfigDictionary billTypeFixture = configDictionaryService.selectById(vo.getBillTypeFixtureDictId(), commonParam);
			if(billTypeFixture != null){
				vo.setBillTypeFixture(billTypeFixture);
			}
		}
		//单据状态
		if(vo.getBillStatusFixtureDictId() != null && vo.getBillStatusFixtureDictId() > 0L){
			ConfigDictionary billStatusFixture = configDictionaryService.selectById(vo.getBillStatusFixtureDictId(), commonParam);
			if(billStatusFixture != null){
				vo.setBillStatusFixture(billStatusFixture);
			}
		}
		//工厂
		if(vo.getFactoryId() != null && vo.getFactoryId() > 0L){
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if(structFactory != null){
				vo.setStructFactory(structFactory);
			}
		}
		//车间
		if(vo.getWorkshopId() != null && vo.getWorkshopId() > 0L){
			StructWorkshop structWorkshop = structWorkshopService.selectById(vo.getWorkshopId(), commonParam);
			if(structWorkshop != null){
				vo.setStructWorkshop(structWorkshop);
			}
		}
		//部门
		if(vo.getDepartmentId()!= null && vo.getDepartmentId() > 0L){
			FirmDepartment firmDepartment = firmDepartmentService.selectById(vo.getDepartmentId(), commonParam);
			if(firmDepartment != null){
				vo.setFirmDepartment(firmDepartment);
			}
		}
		
		return vo;
	} 
	
	private BillEquipVo getExtendVo(BillEquip billEquip, CommonParam commonParam) throws BusinessException, SQLException {
		BillEquipVo vo = this.getVo(billEquip, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<BillEquipVo> getVoList(List<BillEquip> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<BillEquipVo> voList = new ArrayList<BillEquipVo>();
		for (BillEquip entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<BillEquipVo> getExtendVoList(List<BillEquip> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<BillEquipVo> voList = new ArrayList<BillEquipVo>();
		for (BillEquip entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public BillEquipVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillEquip entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<BillEquipVo>  selectListVoByParamVo(BillEquipParamVo billEquip, CommonParam commonParam) throws BusinessException, SQLException {
		if(billEquip==null){
			billEquip = new BillEquipParamVo();
		}
		billEquip.setTenantId(commonParam.getTenantId());	
	
		List<BillEquip> list = (List<BillEquip>) this.getBaseService().selectListByParamVo(billEquip, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<BillEquipVo> selectPageVoByParamVo(BillEquipParamVo billEquip, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(billEquip==null){
			billEquip = new BillEquipParamVo();
		}
		billEquip.setTenantId(commonParam.getTenantId());	
					
		PageInfo<BillEquip> list  = (PageInfo<BillEquip>) this.getBaseService().selectPageByParamVo(billEquip, commonParam, pageNo, pageSize);
		List<BillEquipVo> volist = new ArrayList<BillEquipVo>();
		
		Iterator<BillEquip> iter = list.getList().iterator();
		BillEquipVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<BillEquipVo> vpage = new Page<BillEquipVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public BillEquipVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillEquip entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<BillEquipVo>  selectListExtendVoByParamVo(BillEquipParamVo billEquip, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(billEquip==null){
			billEquip = new BillEquipParamVo();
		}
		billEquip.setTenantId(commonParam.getTenantId());	
					
		List<BillEquip> list = (List<BillEquip>) this.getBaseService().selectListByParamVo(billEquip, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<BillEquipVo> selectPageExtendVoByParamVo(BillEquipParamVo billEquip, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(billEquip==null){
			billEquip = new BillEquipParamVo();
		}
		billEquip.setTenantId(commonParam.getTenantId());	
					
		PageInfo<BillEquip> list  = (PageInfo<BillEquip>) this.getBaseService().selectPageByParamVo(billEquip, commonParam, pageNo, pageSize);
		List<BillEquipVo> volist = new ArrayList<BillEquipVo>();
		
		Iterator<BillEquip> iter = list.getList().iterator();
		BillEquipVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<BillEquipVo> vpage = new Page<BillEquipVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(BillEquipParamVo billEquipParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		if (billEquipParamVo.getFactoryId() == null) {
			resultMessage.addErr("工厂不能为空");
			return resultMessage;
		}
		BillEquip billEquip = null;
		try {
			if (billEquipParamVo.getId() == null) {//新增
				//生成编码
				String code = configCodeRuleService.createCode(BillEquip.class.getName(), null, null, commonParam);
				if(code != null && code != ""){
					billEquipParamVo.setBillCode(code);
					billEquipParamVo.setTenantId(commonParam.getTenantId());
					billEquip = billEquipService.saveOrUpdate(billEquipParamVo,commonParam);
					resultMessage.setIsSuccess(true);
				}else{
					resultMessage.addErr("请维护设备单据编码");
					return resultMessage;
				}
			} else {  //修改
				BillEquip billEquipVoTemp = this.selectById(billEquipParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(billEquipVoTemp,
						billEquipParamVo);
  
				billEquip = billEquipService.saveOrUpdate(
						billEquipVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(billEquip);
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
