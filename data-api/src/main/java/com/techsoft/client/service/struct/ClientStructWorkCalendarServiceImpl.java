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
import com.techsoft.entity.common.StructWorkCalendar;
import com.techsoft.entity.struct.StructWorkCalendarVo;
import com.techsoft.entity.struct.StructWorkCalendarParamVo;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructWorkCalendarService;

@org.springframework.stereotype.Service
public class ClientStructWorkCalendarServiceImpl extends BaseClientServiceImpl<StructWorkCalendar> implements ClientStructWorkCalendarService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkCalendarService structWorkCalendarService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	
	@Override
	public BaseService<StructWorkCalendar> getBaseService() {
		return structWorkCalendarService;
	}	    	
    
	private StructWorkCalendarVo getVo(StructWorkCalendar structWorkCalendar, CommonParam commonParam) throws BusinessException, SQLException {
		StructWorkCalendarVo vo = new StructWorkCalendarVo(structWorkCalendar);
		// TODO 此处填充其它关联字段的处理代码
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}
		return vo;
	} 
	
	private StructWorkCalendarVo getExtendVo(StructWorkCalendar structWorkCalendar, CommonParam commonParam) throws BusinessException, SQLException {
		StructWorkCalendarVo vo = this.getVo(structWorkCalendar, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<StructWorkCalendarVo> getVoList(List<StructWorkCalendar> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<StructWorkCalendarVo> voList = new ArrayList<StructWorkCalendarVo>();
		for (StructWorkCalendar entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<StructWorkCalendarVo> getExtendVoList(List<StructWorkCalendar> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<StructWorkCalendarVo> voList = new ArrayList<StructWorkCalendarVo>();
		for (StructWorkCalendar entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public StructWorkCalendarVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructWorkCalendar entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<StructWorkCalendarVo>  selectListVoByParamVo(StructWorkCalendarParamVo structWorkCalendar, CommonParam commonParam) throws BusinessException, SQLException {
		if(structWorkCalendar==null){
			structWorkCalendar = new StructWorkCalendarParamVo();
		}
		structWorkCalendar.setTenantId(commonParam.getTenantId());	
	
		List<StructWorkCalendar> list = (List<StructWorkCalendar>) this.getBaseService().selectListByParamVo(structWorkCalendar, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<StructWorkCalendarVo> selectPageVoByParamVo(StructWorkCalendarParamVo structWorkCalendar, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(structWorkCalendar==null){
			structWorkCalendar = new StructWorkCalendarParamVo();
		}
		structWorkCalendar.setTenantId(commonParam.getTenantId());	
					
		PageInfo<StructWorkCalendar> list  = (PageInfo<StructWorkCalendar>) this.getBaseService().selectPageByParamVo(structWorkCalendar, commonParam, pageNo, pageSize);
		List<StructWorkCalendarVo> volist = new ArrayList<StructWorkCalendarVo>();
		
		Iterator<StructWorkCalendar> iter = list.getList().iterator();
		StructWorkCalendarVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<StructWorkCalendarVo> vpage = new Page<StructWorkCalendarVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public StructWorkCalendarVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructWorkCalendar entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<StructWorkCalendarVo>  selectListExtendVoByParamVo(StructWorkCalendarParamVo structWorkCalendar, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(structWorkCalendar==null){
			structWorkCalendar = new StructWorkCalendarParamVo();
		}
		structWorkCalendar.setTenantId(commonParam.getTenantId());	
					
		List<StructWorkCalendar> list = (List<StructWorkCalendar>) this.getBaseService().selectListByParamVo(structWorkCalendar, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<StructWorkCalendarVo> selectPageExtendVoByParamVo(StructWorkCalendarParamVo structWorkCalendar, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(structWorkCalendar==null){
			structWorkCalendar = new StructWorkCalendarParamVo();
		}
		structWorkCalendar.setTenantId(commonParam.getTenantId());	
					
		PageInfo<StructWorkCalendar> list  = (PageInfo<StructWorkCalendar>) this.getBaseService().selectPageByParamVo(structWorkCalendar, commonParam, pageNo, pageSize);
		List<StructWorkCalendarVo> volist = new ArrayList<StructWorkCalendarVo>();
		
		Iterator<StructWorkCalendar> iter = list.getList().iterator();
		StructWorkCalendarVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<StructWorkCalendarVo> vpage = new Page<StructWorkCalendarVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(StructWorkCalendarParamVo structWorkCalendarParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		StructWorkCalendar structWorkCalendar = null;
		try {
			if (structWorkCalendarParamVo.getId() == null) {//新增
			 
				structWorkCalendarParamVo.setTenantId(commonParam.getTenantId());
				structWorkCalendar = structWorkCalendarService.saveOrUpdate(structWorkCalendarParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				StructWorkCalendar structWorkCalendarVoTemp = this.selectById(structWorkCalendarParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(structWorkCalendarVoTemp,
						structWorkCalendarParamVo);
  
				structWorkCalendar = structWorkCalendarService.saveOrUpdate(
						structWorkCalendarVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(structWorkCalendar);
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
