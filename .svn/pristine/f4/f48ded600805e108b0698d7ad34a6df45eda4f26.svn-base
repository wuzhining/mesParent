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
import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.entity.common.EquipSpecsFixtureArea;
import com.techsoft.entity.equip.EquipSpecsFixtureAreaVo;
import com.techsoft.entity.equip.EquipSpecsFixtureAreaParamVo;
import com.techsoft.service.equip.EquipSpecsFixtureAreaService;
import com.techsoft.service.equip.EquipSpecsFixtureService;

@org.springframework.stereotype.Service
public class ClientEquipSpecsFixtureAreaServiceImpl extends BaseClientServiceImpl<EquipSpecsFixtureArea> implements ClientEquipSpecsFixtureAreaService {
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipSpecsFixtureAreaService equipSpecsFixtureAreaService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipSpecsFixtureService equipSpecsFixtureService;
    
	@Override
	public BaseService<EquipSpecsFixtureArea> getBaseService() {
		return equipSpecsFixtureAreaService;
	}	    	
    
	private EquipSpecsFixtureAreaVo getVo(EquipSpecsFixtureArea equipSpecsFixtureArea, CommonParam commonParam) throws BusinessException, SQLException {
		EquipSpecsFixtureAreaVo vo = new EquipSpecsFixtureAreaVo(equipSpecsFixtureArea);
		// TODO 此处填充其它关联字段的处理代码
		if(vo.getSpecsFixtureId() != null && vo.getSpecsFixtureId() > 0L){
			EquipSpecsFixture equipSpecsFixture = equipSpecsFixtureService.selectById(vo.getSpecsFixtureId(), commonParam);
			if(equipSpecsFixture != null){
				vo.setEquipSpecsFixture(equipSpecsFixture);
			}
		}
		return vo;
	} 
	
	private EquipSpecsFixtureAreaVo getExtendVo(EquipSpecsFixtureArea equipSpecsFixtureArea, CommonParam commonParam) throws BusinessException, SQLException {
		EquipSpecsFixtureAreaVo vo = this.getVo(equipSpecsFixtureArea, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<EquipSpecsFixtureAreaVo> getVoList(List<EquipSpecsFixtureArea> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipSpecsFixtureAreaVo> voList = new ArrayList<EquipSpecsFixtureAreaVo>();
		for (EquipSpecsFixtureArea entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<EquipSpecsFixtureAreaVo> getExtendVoList(List<EquipSpecsFixtureArea> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipSpecsFixtureAreaVo> voList = new ArrayList<EquipSpecsFixtureAreaVo>();
		for (EquipSpecsFixtureArea entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public EquipSpecsFixtureAreaVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipSpecsFixtureArea entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<EquipSpecsFixtureAreaVo>  selectListVoByParamVo(EquipSpecsFixtureAreaParamVo equipSpecsFixtureArea, CommonParam commonParam) throws BusinessException, SQLException {
		if(equipSpecsFixtureArea==null){
			equipSpecsFixtureArea = new EquipSpecsFixtureAreaParamVo();
		}
		equipSpecsFixtureArea.setTenantId(commonParam.getTenantId());	
	
		List<EquipSpecsFixtureArea> list = (List<EquipSpecsFixtureArea>) this.getBaseService().selectListByParamVo(equipSpecsFixtureArea, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<EquipSpecsFixtureAreaVo> selectPageVoByParamVo(EquipSpecsFixtureAreaParamVo equipSpecsFixtureArea, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(equipSpecsFixtureArea==null){
			equipSpecsFixtureArea = new EquipSpecsFixtureAreaParamVo();
		}
		equipSpecsFixtureArea.setTenantId(commonParam.getTenantId());	
					
		PageInfo<EquipSpecsFixtureArea> list  = (PageInfo<EquipSpecsFixtureArea>) this.getBaseService().selectPageByParamVo(equipSpecsFixtureArea, commonParam, pageNo, pageSize);
		List<EquipSpecsFixtureAreaVo> volist = new ArrayList<EquipSpecsFixtureAreaVo>();
		
		Iterator<EquipSpecsFixtureArea> iter = list.getList().iterator();
		EquipSpecsFixtureAreaVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<EquipSpecsFixtureAreaVo> vpage = new Page<EquipSpecsFixtureAreaVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public EquipSpecsFixtureAreaVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipSpecsFixtureArea entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<EquipSpecsFixtureAreaVo>  selectListExtendVoByParamVo(EquipSpecsFixtureAreaParamVo equipSpecsFixtureArea, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(equipSpecsFixtureArea==null){
			equipSpecsFixtureArea = new EquipSpecsFixtureAreaParamVo();
		}
		equipSpecsFixtureArea.setTenantId(commonParam.getTenantId());	
					
		List<EquipSpecsFixtureArea> list = (List<EquipSpecsFixtureArea>) this.getBaseService().selectListByParamVo(equipSpecsFixtureArea, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<EquipSpecsFixtureAreaVo> selectPageExtendVoByParamVo(EquipSpecsFixtureAreaParamVo equipSpecsFixtureArea, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(equipSpecsFixtureArea==null){
			equipSpecsFixtureArea = new EquipSpecsFixtureAreaParamVo();
		}
		equipSpecsFixtureArea.setTenantId(commonParam.getTenantId());	
					
		PageInfo<EquipSpecsFixtureArea> list  = (PageInfo<EquipSpecsFixtureArea>) this.getBaseService().selectPageByParamVo(equipSpecsFixtureArea, commonParam, pageNo, pageSize);
		List<EquipSpecsFixtureAreaVo> volist = new ArrayList<EquipSpecsFixtureAreaVo>();
		
		Iterator<EquipSpecsFixtureArea> iter = list.getList().iterator();
		EquipSpecsFixtureAreaVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<EquipSpecsFixtureAreaVo> vpage = new Page<EquipSpecsFixtureAreaVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(EquipSpecsFixtureAreaParamVo equipSpecsFixtureAreaParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		EquipSpecsFixtureArea equipSpecsFixtureArea = null;
		try {
			if (equipSpecsFixtureAreaParamVo.getId() == null) {//新增
			 
				equipSpecsFixtureAreaParamVo.setTenantId(commonParam.getTenantId());
				equipSpecsFixtureArea = equipSpecsFixtureAreaService.saveOrUpdate(equipSpecsFixtureAreaParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				EquipSpecsFixtureArea equipSpecsFixtureAreaVoTemp = this.selectById(equipSpecsFixtureAreaParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(equipSpecsFixtureAreaVoTemp,
						equipSpecsFixtureAreaParamVo);
  
				equipSpecsFixtureArea = equipSpecsFixtureAreaService.saveOrUpdate(
						equipSpecsFixtureAreaVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(equipSpecsFixtureArea);
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
