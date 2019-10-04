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
import com.techsoft.entity.common.StructProcedureWorkstation;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.struct.StructProcedureWorkstationVo;
import com.techsoft.entity.struct.StructProcedureWorkstationParamVo;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructFloorService;
import com.techsoft.service.struct.StructProcedureWorkstationService;
import com.techsoft.service.struct.StructProcessNodeService;
import com.techsoft.service.struct.StructWorkshopAreaService;
import com.techsoft.service.struct.StructWorkshopService;
import com.techsoft.service.struct.StructWorkstationService;

@org.springframework.stereotype.Service
public class ClientStructProcedureWorkstationServiceImpl extends BaseClientServiceImpl<StructProcedureWorkstation> implements ClientStructProcedureWorkstationService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcedureWorkstationService structProcedureWorkstationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessNodeService structProcessNodeService;
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
	public BaseService<StructProcedureWorkstation> getBaseService() {
		return structProcedureWorkstationService;
	}	    	
    
	private StructProcedureWorkstationVo getVo(StructProcedureWorkstation structProcedureWorkstation, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedureWorkstationVo vo = new StructProcedureWorkstationVo(structProcedureWorkstation);
		// TODO 此处填充其它关联字段的处理代码
		
		if (vo.getProcessNodeId() != null && vo.getProcessNodeId() > 0L) {
			StructProcessNode structProcessNode = structProcessNodeService.selectById(vo.getProcessNodeId(), commonParam);
			if (structProcessNode != null) {
				vo.setStructProcessNode(structProcessNode);
			}
		}
		if (vo.getWorkstationId() != null && vo.getWorkstationId() > 0L) {
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
	
	private StructProcedureWorkstationVo getExtendVo(StructProcedureWorkstation structProcedureWorkstation, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedureWorkstationVo vo = this.getVo(structProcedureWorkstation, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<StructProcedureWorkstationVo> getVoList(List<StructProcedureWorkstation> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<StructProcedureWorkstationVo> voList = new ArrayList<StructProcedureWorkstationVo>();
		for (StructProcedureWorkstation entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<StructProcedureWorkstationVo> getExtendVoList(List<StructProcedureWorkstation> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<StructProcedureWorkstationVo> voList = new ArrayList<StructProcedureWorkstationVo>();
		for (StructProcedureWorkstation entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public StructProcedureWorkstationVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedureWorkstation entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<StructProcedureWorkstationVo>  selectListVoByParamVo(StructProcedureWorkstationParamVo structProcedureWorkstation, CommonParam commonParam) throws BusinessException, SQLException {
		if(structProcedureWorkstation==null){
			structProcedureWorkstation = new StructProcedureWorkstationParamVo();
		}
		structProcedureWorkstation.setTenantId(commonParam.getTenantId());	
	
		List<StructProcedureWorkstation> list = (List<StructProcedureWorkstation>) this.getBaseService().selectListByParamVo(structProcedureWorkstation, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<StructProcedureWorkstationVo> selectPageVoByParamVo(StructProcedureWorkstationParamVo structProcedureWorkstation, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(structProcedureWorkstation==null){
			structProcedureWorkstation = new StructProcedureWorkstationParamVo();
		}
		structProcedureWorkstation.setTenantId(commonParam.getTenantId());	
					
		PageInfo<StructProcedureWorkstation> list  = (PageInfo<StructProcedureWorkstation>) this.getBaseService().selectPageByParamVo(structProcedureWorkstation, commonParam, pageNo, pageSize);
		List<StructProcedureWorkstationVo> volist = new ArrayList<StructProcedureWorkstationVo>();
		
		Iterator<StructProcedureWorkstation> iter = list.getList().iterator();
		StructProcedureWorkstationVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<StructProcedureWorkstationVo> vpage = new Page<StructProcedureWorkstationVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public StructProcedureWorkstationVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedureWorkstation entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<StructProcedureWorkstationVo>  selectListExtendVoByParamVo(StructProcedureWorkstationParamVo structProcedureWorkstation, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(structProcedureWorkstation==null){
			structProcedureWorkstation = new StructProcedureWorkstationParamVo();
		}
		structProcedureWorkstation.setTenantId(commonParam.getTenantId());	
					
		List<StructProcedureWorkstation> list = (List<StructProcedureWorkstation>) this.getBaseService().selectListByParamVo(structProcedureWorkstation, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<StructProcedureWorkstationVo> selectPageExtendVoByParamVo(StructProcedureWorkstationParamVo structProcedureWorkstation, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(structProcedureWorkstation==null){
			structProcedureWorkstation = new StructProcedureWorkstationParamVo();
		}
		structProcedureWorkstation.setTenantId(commonParam.getTenantId());	
					
		PageInfo<StructProcedureWorkstation> list  = (PageInfo<StructProcedureWorkstation>) this.getBaseService().selectPageByParamVo(structProcedureWorkstation, commonParam, pageNo, pageSize);
		List<StructProcedureWorkstationVo> volist = new ArrayList<StructProcedureWorkstationVo>();
		
		Iterator<StructProcedureWorkstation> iter = list.getList().iterator();
		StructProcedureWorkstationVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<StructProcedureWorkstationVo> vpage = new Page<StructProcedureWorkstationVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(StructProcedureWorkstationParamVo structProcedureWorkstationParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		StructProcedureWorkstation structProcedureWorkstation = null;
		try {
			if (structProcedureWorkstationParamVo.getId() == null) {//新增
			 
				structProcedureWorkstationParamVo.setTenantId(commonParam.getTenantId());
				structProcedureWorkstation = structProcedureWorkstationService.saveOrUpdate(structProcedureWorkstationParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				StructProcedureWorkstation structProcedureWorkstationVoTemp = this.selectById(structProcedureWorkstationParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(structProcedureWorkstationVoTemp,
						structProcedureWorkstationParamVo);
  
				structProcedureWorkstation = structProcedureWorkstationService.saveOrUpdate(
						structProcedureWorkstationVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(structProcedureWorkstation);
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
