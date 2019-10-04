package com.techsoft.client.service.struct;

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
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructFloor;
import com.techsoft.entity.common.StructProdlineWorkstation;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.struct.StructProdlineWorkstationVo;
import com.techsoft.entity.struct.StructProdlineWorkstationParamVo;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructFloorService;
import com.techsoft.service.struct.StructProdlineWorkstationService;
import com.techsoft.service.struct.StructWorkshopAreaService;
import com.techsoft.service.struct.StructWorkshopService;
import com.techsoft.service.struct.StructWorkstationService;

@org.springframework.stereotype.Service
public class ClientStructProdlineWorkstationServiceImpl extends BaseClientServiceImpl<StructProdlineWorkstation> implements ClientStructProdlineWorkstationService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProdlineWorkstationService structProdlineWorkstationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkstationService structWorkstationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopService structWorkshopService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopAreaService structWorkshopAreaService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFloorService structFloorService;
    
	@Override
	public BaseService<StructProdlineWorkstation> getBaseService() {
		return structProdlineWorkstationService;
	}	    	
    
	private StructProdlineWorkstationVo getVo(StructProdlineWorkstation structProdlineWorkstation, CommonParam commonParam) throws BusinessException, SQLException {
		StructProdlineWorkstationVo vo = new StructProdlineWorkstationVo(structProdlineWorkstation);
		// TODO 此处填充其它关联字段的处理代码
		//工位
		if(vo.getWorkstationId() != null && vo.getWorkstationId() > 0L){
			StructWorkstation structWorkstation = structWorkstationService.selectById(vo.getWorkstationId(), commonParam);
			if(structWorkstation != null){
				//工厂
				if(structWorkstation.getFactoryId() != null && structWorkstation.getFactoryId() > 0L){
					StructFactory structFactory = structFactoryService.selectById(structWorkstation.getFactoryId(), commonParam);
					if(structFactory != null){
						vo.setStructFactory(structFactory);
					}
				}
				//车间
				if(structWorkstation.getWorkshopId() != null && structWorkstation.getWorkshopId() > 0L){
					StructWorkshop structWorkshop = structWorkshopService.selectById(structWorkstation.getWorkshopId(), commonParam);
					if(structWorkshop != null){
						//楼层
						if(structWorkshop.getFloorId() != null && structWorkshop.getFloorId() > 0L){
							StructFloor structFloor = structFloorService.selectById(structWorkshop.getFloorId(), commonParam);
							if(structFloor != null){
								vo.setStructFloor(structFloor);
							}
						}
						vo.setStructWorkshop(structWorkshop);
					}
				}
				//车间区域
				if(structWorkstation.getWorkshopAreaId() != null && structWorkstation.getWorkshopAreaId() > 0L){
					StructWorkshopArea structWorkshopArea = structWorkshopAreaService.selectById(structWorkstation.getWorkshopAreaId(), commonParam);
					if(structWorkshopArea != null){
						vo.setStructWorkshopArea(structWorkshopArea);
					}
				}
				
				vo.setStructWorkstation(structWorkstation);
			}
		}
		return vo;
	} 
	
	private StructProdlineWorkstationVo getExtendVo(StructProdlineWorkstation structProdlineWorkstation, CommonParam commonParam) throws BusinessException, SQLException {
		StructProdlineWorkstationVo vo = this.getVo(structProdlineWorkstation, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<StructProdlineWorkstationVo> getVoList(List<StructProdlineWorkstation> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<StructProdlineWorkstationVo> voList = new ArrayList<StructProdlineWorkstationVo>();
		for (StructProdlineWorkstation entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<StructProdlineWorkstationVo> getExtendVoList(List<StructProdlineWorkstation> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<StructProdlineWorkstationVo> voList = new ArrayList<StructProdlineWorkstationVo>();
		for (StructProdlineWorkstation entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public StructProdlineWorkstationVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProdlineWorkstation entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<StructProdlineWorkstationVo>  selectListVoByParamVo(StructProdlineWorkstationParamVo structProdlineWorkstation, CommonParam commonParam) throws BusinessException, SQLException {
		if(structProdlineWorkstation==null){
			structProdlineWorkstation = new StructProdlineWorkstationParamVo();
		}
		structProdlineWorkstation.setTenantId(commonParam.getTenantId());	
	
		List<StructProdlineWorkstation> list = (List<StructProdlineWorkstation>) this.getBaseService().selectListByParamVo(structProdlineWorkstation, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<StructProdlineWorkstationVo> selectPageVoByParamVo(StructProdlineWorkstationParamVo structProdlineWorkstation, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(structProdlineWorkstation==null){
			structProdlineWorkstation = new StructProdlineWorkstationParamVo();
		}
		structProdlineWorkstation.setTenantId(commonParam.getTenantId());	
					
		PageInfo<StructProdlineWorkstation> list  = (PageInfo<StructProdlineWorkstation>) this.getBaseService().selectPageByParamVo(structProdlineWorkstation, commonParam, pageNo, pageSize);
		List<StructProdlineWorkstationVo> volist = new ArrayList<StructProdlineWorkstationVo>();
		
		Iterator<StructProdlineWorkstation> iter = list.getList().iterator();
		StructProdlineWorkstationVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<StructProdlineWorkstationVo> vpage = new Page<StructProdlineWorkstationVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public StructProdlineWorkstationVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProdlineWorkstation entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<StructProdlineWorkstationVo>  selectListExtendVoByParamVo(StructProdlineWorkstationParamVo structProdlineWorkstation, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(structProdlineWorkstation==null){
			structProdlineWorkstation = new StructProdlineWorkstationParamVo();
		}
		structProdlineWorkstation.setTenantId(commonParam.getTenantId());	
					
		List<StructProdlineWorkstation> list = (List<StructProdlineWorkstation>) this.getBaseService().selectListByParamVo(structProdlineWorkstation, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<StructProdlineWorkstationVo> selectPageExtendVoByParamVo(StructProdlineWorkstationParamVo structProdlineWorkstation, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(structProdlineWorkstation==null){
			structProdlineWorkstation = new StructProdlineWorkstationParamVo();
		}
		structProdlineWorkstation.setTenantId(commonParam.getTenantId());	
					
		PageInfo<StructProdlineWorkstation> list  = (PageInfo<StructProdlineWorkstation>) this.getBaseService().selectPageByParamVo(structProdlineWorkstation, commonParam, pageNo, pageSize);
		List<StructProdlineWorkstationVo> volist = new ArrayList<StructProdlineWorkstationVo>();
		
		Iterator<StructProdlineWorkstation> iter = list.getList().iterator();
		StructProdlineWorkstationVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<StructProdlineWorkstationVo> vpage = new Page<StructProdlineWorkstationVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(StructProdlineWorkstationParamVo structProdlineWorkstationParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		StructProdlineWorkstation structProdlineWorkstation = null;
		try {
			if (structProdlineWorkstationParamVo.getId() == null) {//新增
			 
				structProdlineWorkstationParamVo.setTenantId(commonParam.getTenantId());
				structProdlineWorkstation = structProdlineWorkstationService.saveOrUpdate(structProdlineWorkstationParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				StructProdlineWorkstation structProdlineWorkstationVoTemp = this.selectById(structProdlineWorkstationParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(structProdlineWorkstationVoTemp,
						structProdlineWorkstationParamVo);
  
				structProdlineWorkstation = structProdlineWorkstationService.saveOrUpdate(
						structProdlineWorkstationVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(structProdlineWorkstation);
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
