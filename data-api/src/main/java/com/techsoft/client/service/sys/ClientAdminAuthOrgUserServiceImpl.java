package com.techsoft.client.service.sys;

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

import com.techsoft.entity.common.AdminAuthOrgUser;
import com.techsoft.entity.common.AdminMenu;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.sys.AdminAuthOrgUserVo;
import com.techsoft.entity.sys.AdminAuthOrgUserParamVo;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructWarehouseService;
import com.techsoft.service.struct.StructWorkshopService;
import com.techsoft.service.sys.AdminAuthOrgUserService;
import com.techsoft.service.sys.UserPassportService;

@org.springframework.stereotype.Service
public class ClientAdminAuthOrgUserServiceImpl extends BaseClientServiceImpl<AdminAuthOrgUser> implements ClientAdminAuthOrgUserService {
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminAuthOrgUserService adminAuthOrgUserService;
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWarehouseService structWarehouseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopService structWorkshopService;
    
	@Override
	public BaseService<AdminAuthOrgUser> getBaseService() {
		return adminAuthOrgUserService;
	}	    	
    
	private AdminAuthOrgUserVo getVo(AdminAuthOrgUser adminAuthOrgUser, CommonParam commonParam) throws BusinessException, SQLException {
		AdminAuthOrgUserVo vo = new AdminAuthOrgUserVo(adminAuthOrgUser);
		if (vo.getUserId() != null && vo.getUserId() > 0L) {
			UserPassport userPassport = userPassportService.selectById(vo.getUserId(), commonParam);
			if (userPassport != null) {
				vo.setUserPassport(userPassport);
			}
		}
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				String factory = structFactory.getFactoryName()+"("+structFactory.getId()+")";
				structFactory.setFactoryName(factory);
				vo.setStructFactory(structFactory);
			}
		}
		if (vo.getWarehouseId() != null && vo.getWarehouseId() > 0L) {
			StructWarehouse structWarehouse = structWarehouseService.selectById(vo.getWarehouseId(), commonParam);
			if (structWarehouse != null) {
				String warehouse = structWarehouse.getWarehouseName()+"("+structWarehouse.getId()+")";
				structWarehouse.setWarehouseName(warehouse);
				vo.setStructWarehouse(structWarehouse);
			}
		}
		if (vo.getWorkshopId() != null && vo.getWorkshopId() > 0L) {
			StructWorkshop structWorkshop = structWorkshopService.selectById(vo.getWorkshopId(), commonParam);
			if (structWorkshop != null) {
				String workshop = structWorkshop.getWorkshopName()+"("+structWorkshop.getId()+")";
				structWorkshop.setWorkshopName(workshop);
				vo.setStructWorkshop(structWorkshop);
			}
		}
		return vo;
	} 
	
	private AdminAuthOrgUserVo getExtendVo(AdminAuthOrgUser adminAuthOrgUser, CommonParam commonParam) throws BusinessException, SQLException {
		AdminAuthOrgUserVo vo = this.getVo(adminAuthOrgUser, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<AdminAuthOrgUserVo> getVoList(List<AdminAuthOrgUser> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<AdminAuthOrgUserVo> voList = new ArrayList<AdminAuthOrgUserVo>();
		for (AdminAuthOrgUser entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<AdminAuthOrgUserVo> getExtendVoList(List<AdminAuthOrgUser> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<AdminAuthOrgUserVo> voList = new ArrayList<AdminAuthOrgUserVo>();
		for (AdminAuthOrgUser entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public AdminAuthOrgUserVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminAuthOrgUser entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<AdminAuthOrgUserVo>  selectListVoByParamVo(AdminAuthOrgUserParamVo adminAuthOrgUser, CommonParam commonParam) throws BusinessException, SQLException {
		if(adminAuthOrgUser==null){
			adminAuthOrgUser = new AdminAuthOrgUserParamVo();
		}
		adminAuthOrgUser.setTenantId(commonParam.getTenantId());	
	
		List<AdminAuthOrgUser> list = (List<AdminAuthOrgUser>) this.getBaseService().selectListByParamVo(adminAuthOrgUser, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<AdminAuthOrgUserVo> selectPageVoByParamVo(AdminAuthOrgUserParamVo adminAuthOrgUser, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(adminAuthOrgUser==null){
			adminAuthOrgUser = new AdminAuthOrgUserParamVo();
		}
		adminAuthOrgUser.setTenantId(commonParam.getTenantId());	
					
		PageInfo<AdminAuthOrgUser> list  = (PageInfo<AdminAuthOrgUser>) this.getBaseService().selectPageByParamVo(adminAuthOrgUser, commonParam, pageNo, pageSize);
		List<AdminAuthOrgUserVo> volist = new ArrayList<AdminAuthOrgUserVo>();
		
		Iterator<AdminAuthOrgUser> iter = list.getList().iterator();
		AdminAuthOrgUserVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<AdminAuthOrgUserVo> vpage = new Page<AdminAuthOrgUserVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public AdminAuthOrgUserVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminAuthOrgUser entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<AdminAuthOrgUserVo>  selectListExtendVoByParamVo(AdminAuthOrgUserParamVo adminAuthOrgUser, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(adminAuthOrgUser==null){
			adminAuthOrgUser = new AdminAuthOrgUserParamVo();
		}
		adminAuthOrgUser.setTenantId(commonParam.getTenantId());	
					
		List<AdminAuthOrgUser> list = (List<AdminAuthOrgUser>) this.getBaseService().selectListByParamVo(adminAuthOrgUser, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<AdminAuthOrgUserVo> selectPageExtendVoByParamVo(AdminAuthOrgUserParamVo adminAuthOrgUser, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(adminAuthOrgUser==null){
			adminAuthOrgUser = new AdminAuthOrgUserParamVo();
		}
		adminAuthOrgUser.setTenantId(commonParam.getTenantId());	
					
		PageInfo<AdminAuthOrgUser> list  = (PageInfo<AdminAuthOrgUser>) this.getBaseService().selectPageByParamVo(adminAuthOrgUser, commonParam, pageNo, pageSize);
		List<AdminAuthOrgUserVo> volist = new ArrayList<AdminAuthOrgUserVo>();
		
		Iterator<AdminAuthOrgUser> iter = list.getList().iterator();
		AdminAuthOrgUserVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<AdminAuthOrgUserVo> vpage = new Page<AdminAuthOrgUserVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(AdminAuthOrgUserParamVo adminAuthOrgUserParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		AdminAuthOrgUser adminAuthOrgUser = null;
		
		try {
			if (adminAuthOrgUserParamVo.getId() == null) {//新增
			 
				adminAuthOrgUserParamVo.setTenantId(commonParam.getTenantId());
				adminAuthOrgUser = adminAuthOrgUserService.saveOrUpdate(adminAuthOrgUserParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				AdminAuthOrgUser adminAuthOrgUserVoTemp = this.selectById(adminAuthOrgUserParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(adminAuthOrgUserVoTemp,
						adminAuthOrgUserParamVo);
  
				adminAuthOrgUser = adminAuthOrgUserService.saveOrUpdate(
						adminAuthOrgUserVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(adminAuthOrgUser);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	/**
	 * 批量增加分配数据权限表
	 */
	@Override
	public ResultMessage bathinsertAuthOrgsUser(List<AdminAuthOrgUser> adminAuthOrgUserList, CommonParam commonParam)
			throws BusinessException, SQLException {
		ResultMessage resultMessage = new ResultMessage();
		AdminAuthOrgUserParamVo adminAuthOrgUserParamVo = new AdminAuthOrgUserParamVo();
		List<AdminAuthOrgUser> adminAuthOrgUserLists = new ArrayList<>();
		if(adminAuthOrgUserList.size() > 0){
			for(AdminAuthOrgUser adminAuthOrgUser : adminAuthOrgUserList){
				adminAuthOrgUserLists.add(adminAuthOrgUser);
			}
			adminAuthOrgUserParamVo.setAdminAuthOrgUserList(adminAuthOrgUserLists);
		}
		int result = adminAuthOrgUserService.insertAuthOrgsUser(adminAuthOrgUserParamVo, commonParam);
		if(result > 0){
			resultMessage.setIsSuccess(true);
		}else{
			resultMessage.setIsSuccess(false);
		}
		return resultMessage; 
	}	
}
