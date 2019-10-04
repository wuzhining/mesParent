package com.techsoft.client.service.equip;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.EquipClassesWork;
import com.techsoft.entity.common.EquipSpecsWork;
import com.techsoft.entity.common.FirmEmployee;
import com.techsoft.entity.equip.EquipSpecsWorkParamVo;
import com.techsoft.entity.equip.EquipSpecsWorkVo;
import com.techsoft.entity.firm.FirmEmployeeParamVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.equip.EquipClassesWorkService;
import com.techsoft.service.equip.EquipSpecsWorkService;

@org.springframework.stereotype.Service
public class ClientEquipSpecsWorkServiceImpl extends BaseClientServiceImpl<EquipSpecsWork> implements ClientEquipSpecsWorkService {
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipSpecsWorkService equipSpecsWorkService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipClassesWorkService equipClassesWorkService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@Override
	public BaseService<EquipSpecsWork> getBaseService() {
		return equipSpecsWorkService;
	}	    	
    
	private EquipSpecsWorkVo getVo(EquipSpecsWork equipSpecsWork, CommonParam commonParam) throws BusinessException, SQLException {
		EquipSpecsWorkVo vo = new EquipSpecsWorkVo(equipSpecsWork);
		if (vo.getClassesId() != null && vo.getClassesId() > 0L) {
			EquipClassesWork equipClassesWork = equipClassesWorkService.selectById(vo.getClassesId(), commonParam);
			if (equipClassesWork != null) {
				vo.setEquipClassesWork(equipClassesWork);
			}
		}
		return vo;
	} 
	
	private EquipSpecsWorkVo getExtendVo(EquipSpecsWork equipSpecsWork, CommonParam commonParam) throws BusinessException, SQLException {
		EquipSpecsWorkVo vo = this.getVo(equipSpecsWork, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<EquipSpecsWorkVo> getVoList(List<EquipSpecsWork> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipSpecsWorkVo> voList = new ArrayList<EquipSpecsWorkVo>();
		for (EquipSpecsWork entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<EquipSpecsWorkVo> getExtendVoList(List<EquipSpecsWork> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipSpecsWorkVo> voList = new ArrayList<EquipSpecsWorkVo>();
		for (EquipSpecsWork entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public EquipSpecsWorkVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipSpecsWork entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<EquipSpecsWorkVo>  selectListVoByParamVo(EquipSpecsWorkParamVo equipSpecsWork, CommonParam commonParam) throws BusinessException, SQLException {
		if(equipSpecsWork==null){
			equipSpecsWork = new EquipSpecsWorkParamVo();
		}
		equipSpecsWork.setTenantId(commonParam.getTenantId());	
	
		List<EquipSpecsWork> list = (List<EquipSpecsWork>) this.getBaseService().selectListByParamVo(equipSpecsWork, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<EquipSpecsWorkVo> selectPageVoByParamVo(EquipSpecsWorkParamVo equipSpecsWork, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(equipSpecsWork==null){
			equipSpecsWork = new EquipSpecsWorkParamVo();
		}
		equipSpecsWork.setTenantId(commonParam.getTenantId());	
					
		PageInfo<EquipSpecsWork> list  = (PageInfo<EquipSpecsWork>) this.getBaseService().selectPageByParamVo(equipSpecsWork, commonParam, pageNo, pageSize);
		List<EquipSpecsWorkVo> volist = new ArrayList<EquipSpecsWorkVo>();
		
		Iterator<EquipSpecsWork> iter = list.getList().iterator();
		EquipSpecsWorkVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<EquipSpecsWorkVo> vpage = new Page<EquipSpecsWorkVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public EquipSpecsWorkVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipSpecsWork entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<EquipSpecsWorkVo>  selectListExtendVoByParamVo(EquipSpecsWorkParamVo equipSpecsWork, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(equipSpecsWork==null){
			equipSpecsWork = new EquipSpecsWorkParamVo();
		}
		equipSpecsWork.setTenantId(commonParam.getTenantId());	
					
		List<EquipSpecsWork> list = (List<EquipSpecsWork>) this.getBaseService().selectListByParamVo(equipSpecsWork, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<EquipSpecsWorkVo> selectPageExtendVoByParamVo(EquipSpecsWorkParamVo equipSpecsWork, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(equipSpecsWork==null){
			equipSpecsWork = new EquipSpecsWorkParamVo();
		}
		equipSpecsWork.setTenantId(commonParam.getTenantId());	
					
		PageInfo<EquipSpecsWork> list  = (PageInfo<EquipSpecsWork>) this.getBaseService().selectPageByParamVo(equipSpecsWork, commonParam, pageNo, pageSize);
		List<EquipSpecsWorkVo> volist = new ArrayList<EquipSpecsWorkVo>();
		
		Iterator<EquipSpecsWork> iter = list.getList().iterator();
		EquipSpecsWorkVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<EquipSpecsWorkVo> vpage = new Page<EquipSpecsWorkVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(EquipSpecsWorkParamVo equipSpecsWorkParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		EquipSpecsWork equipSpecsWork = null;
		
		if (equipSpecsWorkParamVo.getEquipSpecsName() == null) {
			resultMessage.addErr("设备品种规格名称不能为空");
			return resultMessage;
		}
		
		
		if (equipSpecsWorkParamVo.getEquipSpecsPattern() == null) {
			resultMessage.addErr("设备品种规格型号不能为空");
			return resultMessage;
		}
		
		
		if (equipSpecsWorkParamVo.getClassesId() == null) {
			resultMessage.addErr("设备分类不能为空");
			return resultMessage;
		}
		
		
		if (equipSpecsWorkParamVo.getQuantity() == null) {
			resultMessage.addErr("设备数量不能为空");
			return resultMessage;
		}
		
		
		if (equipSpecsWorkParamVo.getSpeedWorktime() == null) {
			resultMessage.addErr("生产速度-工时不能为空");
			return resultMessage;
		}
		
		
		if (equipSpecsWorkParamVo.getSpeedQuantity() == null) {
			resultMessage.addErr("生产速度-数量不能为空");
			return resultMessage;
		}
		
		
		
		if (equipSpecsWorkParamVo.getHoursMaintain() == null) {
			resultMessage.addErr("保养时长不能为空");
			return resultMessage;
		}
		
		
		if (equipSpecsWorkParamVo.getStandarlive() == null) {
			resultMessage.addErr("标准寿命不能为空");
			return resultMessage;
		}
		
		try {
			if (equipSpecsWorkParamVo.getId() == null) {//新增
				// 生成编码 
				String  code = equipSpecsWorkParamVo.getEquipSpecsCode();
				if (StringUtils.isBlank(code)) {
					code = configCodeRuleService.createCode(EquipSpecsWork.class.getName(), null, null, commonParam);
					equipSpecsWorkParamVo.setEquipSpecsCode(code);
				}
				if (StringUtils.isBlank(code)) {
					resultMessage.addErr("编码不能为空");
					return resultMessage;
				}
				//检验编码是否已存在
				EquipSpecsWorkParamVo equipSpecsWorkSearch = new EquipSpecsWorkParamVo();
				equipSpecsWorkSearch.setEquipSpecsCode(code);
				List<EquipSpecsWork> list = equipSpecsWorkService.selectListByParamVo(equipSpecsWorkSearch, commonParam);
				if((list!=null)&&(!list.isEmpty())){
					resultMessage.addErr("编码已经存在");
					return resultMessage;
				}

				equipSpecsWorkParamVo.setTenantId(commonParam.getTenantId());
				equipSpecsWork = equipSpecsWorkService.saveOrUpdate(
						equipSpecsWorkParamVo, commonParam); 

				resultMessage.setIsSuccess(true);
				
			} else {  //修改
				EquipSpecsWork equipSpecsWorkVoTemp = this.selectById(equipSpecsWorkParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(equipSpecsWorkVoTemp,
						equipSpecsWorkParamVo);
  
				equipSpecsWork = equipSpecsWorkService.saveOrUpdate(
						equipSpecsWorkVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(equipSpecsWork);
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
