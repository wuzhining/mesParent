package com.techsoft.client.service.history;

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

import com.techsoft.entity.common.HistoryBillEquipStatus;
import com.techsoft.entity.history.HistoryBillEquipStatusVo;
import com.techsoft.entity.history.HistoryBillEquipStatusParamVo;
import com.techsoft.service.history.HistoryBillEquipStatusService;

@org.springframework.stereotype.Service
public class ClientHistoryBillEquipStatusServiceImpl extends BaseClientServiceImpl<HistoryBillEquipStatus> implements ClientHistoryBillEquipStatusService {
	@com.alibaba.dubbo.config.annotation.Reference
	private HistoryBillEquipStatusService historyBillEquipStatusService;
    
	@Override
	public BaseService<HistoryBillEquipStatus> getBaseService() {
		return historyBillEquipStatusService;
	}	    	
    
	private HistoryBillEquipStatusVo getVo(HistoryBillEquipStatus historyBillEquipStatus, CommonParam commonParam) throws BusinessException, SQLException {
		HistoryBillEquipStatusVo vo = new HistoryBillEquipStatusVo(historyBillEquipStatus);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private HistoryBillEquipStatusVo getExtendVo(HistoryBillEquipStatus historyBillEquipStatus, CommonParam commonParam) throws BusinessException, SQLException {
		HistoryBillEquipStatusVo vo = this.getVo(historyBillEquipStatus, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<HistoryBillEquipStatusVo> getVoList(List<HistoryBillEquipStatus> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<HistoryBillEquipStatusVo> voList = new ArrayList<HistoryBillEquipStatusVo>();
		for (HistoryBillEquipStatus entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<HistoryBillEquipStatusVo> getExtendVoList(List<HistoryBillEquipStatus> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<HistoryBillEquipStatusVo> voList = new ArrayList<HistoryBillEquipStatusVo>();
		for (HistoryBillEquipStatus entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public HistoryBillEquipStatusVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		HistoryBillEquipStatus entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<HistoryBillEquipStatusVo>  selectListVoByParamVo(HistoryBillEquipStatusParamVo historyBillEquipStatus, CommonParam commonParam) throws BusinessException, SQLException {
		if(historyBillEquipStatus==null){
			historyBillEquipStatus = new HistoryBillEquipStatusParamVo();
		}
		historyBillEquipStatus.setTenantId(commonParam.getTenantId());	
	
		List<HistoryBillEquipStatus> list = (List<HistoryBillEquipStatus>) this.getBaseService().selectListByParamVo(historyBillEquipStatus, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<HistoryBillEquipStatusVo> selectPageVoByParamVo(HistoryBillEquipStatusParamVo historyBillEquipStatus, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(historyBillEquipStatus==null){
			historyBillEquipStatus = new HistoryBillEquipStatusParamVo();
		}
		historyBillEquipStatus.setTenantId(commonParam.getTenantId());	
					
		PageInfo<HistoryBillEquipStatus> list  = (PageInfo<HistoryBillEquipStatus>) this.getBaseService().selectPageByParamVo(historyBillEquipStatus, commonParam, pageNo, pageSize);
		List<HistoryBillEquipStatusVo> volist = new ArrayList<HistoryBillEquipStatusVo>();
		
		Iterator<HistoryBillEquipStatus> iter = list.getList().iterator();
		HistoryBillEquipStatusVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<HistoryBillEquipStatusVo> vpage = new Page<HistoryBillEquipStatusVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public HistoryBillEquipStatusVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		HistoryBillEquipStatus entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<HistoryBillEquipStatusVo>  selectListExtendVoByParamVo(HistoryBillEquipStatusParamVo historyBillEquipStatus, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(historyBillEquipStatus==null){
			historyBillEquipStatus = new HistoryBillEquipStatusParamVo();
		}
		historyBillEquipStatus.setTenantId(commonParam.getTenantId());	
					
		List<HistoryBillEquipStatus> list = (List<HistoryBillEquipStatus>) this.getBaseService().selectListByParamVo(historyBillEquipStatus, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<HistoryBillEquipStatusVo> selectPageExtendVoByParamVo(HistoryBillEquipStatusParamVo historyBillEquipStatus, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(historyBillEquipStatus==null){
			historyBillEquipStatus = new HistoryBillEquipStatusParamVo();
		}
		historyBillEquipStatus.setTenantId(commonParam.getTenantId());	
					
		PageInfo<HistoryBillEquipStatus> list  = (PageInfo<HistoryBillEquipStatus>) this.getBaseService().selectPageByParamVo(historyBillEquipStatus, commonParam, pageNo, pageSize);
		List<HistoryBillEquipStatusVo> volist = new ArrayList<HistoryBillEquipStatusVo>();
		
		Iterator<HistoryBillEquipStatus> iter = list.getList().iterator();
		HistoryBillEquipStatusVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<HistoryBillEquipStatusVo> vpage = new Page<HistoryBillEquipStatusVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(HistoryBillEquipStatusParamVo historyBillEquipStatusParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		HistoryBillEquipStatus historyBillEquipStatus = null;
		try {
			if (historyBillEquipStatusParamVo.getId() == null) {//新增
			 
				historyBillEquipStatusParamVo.setTenantId(commonParam.getTenantId());
				historyBillEquipStatus = historyBillEquipStatusService.saveOrUpdate(historyBillEquipStatusParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				HistoryBillEquipStatus historyBillEquipStatusVoTemp = this.selectById(historyBillEquipStatusParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(historyBillEquipStatusVoTemp,
						historyBillEquipStatusParamVo);
  
				historyBillEquipStatus = historyBillEquipStatusService.saveOrUpdate(
						historyBillEquipStatusVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(historyBillEquipStatus);
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
