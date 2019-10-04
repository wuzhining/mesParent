package com.techsoft.client.service.equip;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.common.EquipFixtureStack;
import com.techsoft.entity.common.EquipSpecsFixtureArea;
import com.techsoft.entity.equip.EquipFixtureStackParamVo;
import com.techsoft.entity.equip.EquipFixtureStackVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.equip.EquipFixtureService;
import com.techsoft.service.equip.EquipFixtureStackService;
import com.techsoft.service.equip.EquipSpecsFixtureAreaService;
import com.techsoft.service.equip.EquipSpecsFixtureService;

@org.springframework.stereotype.Service
public class ClientEquipFixtureStackServiceImpl extends BaseClientServiceImpl<EquipFixtureStack> implements ClientEquipFixtureStackService {
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipFixtureStackService equipFixtureStackService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipFixtureService equipFixtureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipSpecsFixtureService equipSpecsFixtureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipSpecsFixtureAreaService equipSpecsFixtureAreaService;
    
	@Override
	public BaseService<EquipFixtureStack> getBaseService() {
		return equipFixtureStackService;
	}	    	
    
	private EquipFixtureStackVo getVo(EquipFixtureStack equipFixtureStack, CommonParam commonParam) throws BusinessException, SQLException {
		EquipFixtureStackVo vo = new EquipFixtureStackVo(equipFixtureStack);
		//工具设备
		if(vo.getFixtureId() != null && vo.getFixtureId() > 0L){
			EquipFixture equipFixture = equipFixtureService.selectById(vo.getFixtureId(), commonParam);
			if(equipFixture != null){
				vo.setEquipFixture(equipFixture);
				vo.setEquipSpecsFixture(equipSpecsFixtureService.selectById(equipFixture.getSpecsFixtureId(), commonParam));
				
			}
		}
		if(vo.getSpecsFixtureAreaId() != null && vo.getSpecsFixtureAreaId() > 0L){
			EquipSpecsFixtureArea equipSpecsFixtureArea = equipSpecsFixtureAreaService.selectById(vo.getSpecsFixtureAreaId(), commonParam);
			if(equipSpecsFixtureArea != null){
				vo.setEquipSpecsFixtureArea(equipSpecsFixtureArea);
			}
		}
	 
		return vo;
	} 
	
	private EquipFixtureStackVo getExtendVo(EquipFixtureStack equipFixtureStack, CommonParam commonParam) throws BusinessException, SQLException {
		EquipFixtureStackVo vo = this.getVo(equipFixtureStack, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<EquipFixtureStackVo> getVoList(List<EquipFixtureStack> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipFixtureStackVo> voList = new ArrayList<EquipFixtureStackVo>();
		for (EquipFixtureStack entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<EquipFixtureStackVo> getExtendVoList(List<EquipFixtureStack> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipFixtureStackVo> voList = new ArrayList<EquipFixtureStackVo>();
		for (EquipFixtureStack entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public EquipFixtureStackVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipFixtureStack entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<EquipFixtureStackVo>  selectListVoByParamVo(EquipFixtureStackParamVo equipFixtureStack, CommonParam commonParam) throws BusinessException, SQLException {
		if(equipFixtureStack==null){
			equipFixtureStack = new EquipFixtureStackParamVo();
		}
		equipFixtureStack.setTenantId(commonParam.getTenantId());	
	
		List<EquipFixtureStack> list = (List<EquipFixtureStack>) this.getBaseService().selectListByParamVo(equipFixtureStack, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<EquipFixtureStackVo> selectPageVoByParamVo(EquipFixtureStackParamVo equipFixtureStack, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(equipFixtureStack==null){
			equipFixtureStack = new EquipFixtureStackParamVo();
		}
		equipFixtureStack.setTenantId(commonParam.getTenantId());	
					
		PageInfo<EquipFixtureStack> list  = (PageInfo<EquipFixtureStack>) this.getBaseService().selectPageByParamVo(equipFixtureStack, commonParam, pageNo, pageSize);
		List<EquipFixtureStackVo> volist = new ArrayList<EquipFixtureStackVo>();
		
		Iterator<EquipFixtureStack> iter = list.getList().iterator();
		EquipFixtureStackVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<EquipFixtureStackVo> vpage = new Page<EquipFixtureStackVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public EquipFixtureStackVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipFixtureStack entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<EquipFixtureStackVo>  selectListExtendVoByParamVo(EquipFixtureStackParamVo equipFixtureStack, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(equipFixtureStack==null){
			equipFixtureStack = new EquipFixtureStackParamVo();
		}
		equipFixtureStack.setTenantId(commonParam.getTenantId());	
					
		List<EquipFixtureStack> list = (List<EquipFixtureStack>) this.getBaseService().selectListByParamVo(equipFixtureStack, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<EquipFixtureStackVo> selectPageExtendVoByParamVo(EquipFixtureStackParamVo equipFixtureStack, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(equipFixtureStack==null){
			equipFixtureStack = new EquipFixtureStackParamVo();
		}
		equipFixtureStack.setTenantId(commonParam.getTenantId());	
					
		PageInfo<EquipFixtureStack> list  = (PageInfo<EquipFixtureStack>) this.getBaseService().selectPageByParamVo(equipFixtureStack, commonParam, pageNo, pageSize);
		List<EquipFixtureStackVo> volist = new ArrayList<EquipFixtureStackVo>();
		
		Iterator<EquipFixtureStack> iter = list.getList().iterator();
		EquipFixtureStackVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<EquipFixtureStackVo> vpage = new Page<EquipFixtureStackVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(EquipFixtureStackParamVo equipFixtureStackParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		EquipFixtureStack equipFixtureStack = null;
		try {
			if (equipFixtureStackParamVo.getId() == null) {//新增
				//生成编码
				String code = equipFixtureStackParamVo.getFixtureStackCode();
				if(StringUtils.isBlank(code)){
					code = configCodeRuleService.createCode(EquipFixtureStack.class.getName(), null, null, commonParam);
					equipFixtureStackParamVo.setFixtureStackCode(code);
				}
				
				equipFixtureStackParamVo.setTenantId(commonParam.getTenantId());
				equipFixtureStack = equipFixtureStackService.saveOrUpdate(equipFixtureStackParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				EquipFixtureStack equipFixtureStackVoTemp = this.selectById(equipFixtureStackParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(equipFixtureStackVoTemp,
						equipFixtureStackParamVo);
  
				equipFixtureStack = equipFixtureStackService.saveOrUpdate(
						equipFixtureStackVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(equipFixtureStack);
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
