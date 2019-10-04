package com.techsoft.client.service.history;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillInventory;
import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.BillSaleorder;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.HistoryBillStatus;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.history.HistoryBillStatusParamVo;
import com.techsoft.entity.history.HistoryBillStatusVo;
import com.techsoft.service.bill.BillDeliveryService;
import com.techsoft.service.bill.BillInspectService;
import com.techsoft.service.bill.BillInventoryService;
import com.techsoft.service.bill.BillPurchaseService;
import com.techsoft.service.bill.BillSaleorderService;
import com.techsoft.service.bill.BillWarehouseService;
import com.techsoft.service.bill.BillWorkorderService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.history.HistoryBillStatusService;
import com.techsoft.service.struct.StructWarehouseService;
import com.techsoft.service.sys.UserPassportService;

@org.springframework.stereotype.Service
public class ClientHistoryBillStatusServiceImpl extends BaseClientServiceImpl<HistoryBillStatus>
		implements ClientHistoryBillStatusService {
	@com.alibaba.dubbo.config.annotation.Reference
	private HistoryBillStatusService historyBillStatusService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
	//单据
	@com.alibaba.dubbo.config.annotation.Reference
	private BillDeliveryService billDeliveryService;//发货单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillSaleorderService billSaleorderService;//销售单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillPurchaseService billPurchaseService;//采购单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillInspectService billInspectService;//检验单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWorkorderService billWorkorderService;//工单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWarehouseService billWarehouseService;//仓库库单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillInventoryService billInventoryService;//盘点单
	// 仓库
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWarehouseService structWarehouseService;

	@Override
	public BaseService<HistoryBillStatus> getBaseService() {
		return historyBillStatusService;
	}

	private HistoryBillStatusVo getVo(HistoryBillStatus historyBillStatus, CommonParam commonParam)
			throws BusinessException, SQLException {
		HistoryBillStatusVo vo = new HistoryBillStatusVo(historyBillStatus);
		// 销售单状态
		if (vo.getBillStatusDictId() != null && vo.getBillStatusDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getBillStatusDictId(),
					commonParam);
			if (configDictionary != null) {
				vo.setBillStatusDictionary(configDictionary);
			}
		}
		//单据类型
		if (vo.getBillTypeDictId() != null && vo.getBillTypeDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getBillTypeDictId(),commonParam);
			if (configDictionary != null) {
				vo.setBillTypeDictionary(configDictionary);
				 //单据
				/*if (vo.getBillTypeDictId().equals(EnumDictBillType.BILL_TYPE_DELIVERY.getValue()) || 
						vo.getBillTypeDictId().equals(EnumDictBillType.BILL_TYPE_DELIVERY_SUPPLIER.getValue()) ) {//发货单和供应商发货单
				        BillDelivery billDelivery = billDeliveryService.selectById(vo.getBillId(), commonParam);
				        vo.setBillCode(billDelivery.getBillCode());
				}else if (vo.getBillTypeDictId().equals(EnumDictBillType.BILL_TYPE_SALEORDER.getValue())) {//销售单
					    BillSaleorder billSaleorder = billSaleorderService.selectById(vo.getBillId(), commonParam);
					    vo.setBillCode(billSaleorder.getBillCode());    
				}else if (vo.getBillTypeDictId().equals(EnumDictBillType.BILL_TYPE_PURCHASE.getValue())) {//采购单
				    BillPurchase billPurchase = billPurchaseService.selectById(vo.getBillId(), commonParam);
				    if (billPurchase!=null) {
				    	 vo.setBillCode(billPurchase.getBillCode());
					}
				} else if (vo.getBillTypeDictId().equals(EnumDictBillType.BILL_TYPE_EXAMINE.getValue())) {//检验单
					    BillInspect billInspect = billInspectService.selectById(vo.getBillId(), commonParam);
					    vo.setBillCode(billInspect.getInspectCode()); 
		        } else if (vo.getBillTypeDictId().equals(EnumDictBillType.BILL_TYPE_WORKORDER.getValue())){//工单
		        	    BillWorkorder billWorkorder = billWorkorderService.selectById(vo.getBillId(), commonParam);
					    vo.setBillCode(billWorkorder.getWorkorderCode()); 
		        } else if (vo.getBillTypeDictId().equals(EnumDictBillType.BILL_TYPE_INVENTORY.getValue())){//盘点单
		        	BillInventory billInventory = billInventoryService.selectById(vo.getBillId(), commonParam);
				    vo.setBillCode(billInventory.getBillCode()); 
	            }else{//仓库库单
		        	    BillWarehouse billWarehouse =billWarehouseService.selectById(vo.getBillId(), commonParam);
		        	    if(billWarehouse != null){
						    vo.setBillCode(billWarehouse.getBillCode()); 
		        	    }
		        }*/
			}
		}

		//创建人
		if (vo.getCreateUserId() != null && vo.getCreateUserId() > 0L) {
			UserPassport userPassport =userPassportService.selectById(vo.getCreateUserId(),
					commonParam);
			if (userPassport != null) {
				vo.setCaretUserPassport(userPassport);
			}
		}	
		//修改人
		if (vo.getModifyUserId() != null && vo.getModifyUserId() > 0L) {
			UserPassport userPassport =userPassportService.selectById(vo.getModifyUserId(),
					commonParam);
			if (userPassport != null) {
				vo.setModifyUserPassport(userPassport);
			}
		}	
		return vo;
	}

	private HistoryBillStatusVo getExtendVo(HistoryBillStatus historyBillStatus, CommonParam commonParam)
			throws BusinessException, SQLException {
		HistoryBillStatusVo vo = this.getVo(historyBillStatus, commonParam);

		return vo;
	}

	private List<HistoryBillStatusVo> getVoList(List<HistoryBillStatus> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<HistoryBillStatusVo> voList = new ArrayList<HistoryBillStatusVo>();
		for (HistoryBillStatus entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<HistoryBillStatusVo> getExtendVoList(List<HistoryBillStatus> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<HistoryBillStatusVo> voList = new ArrayList<HistoryBillStatusVo>();
		for (HistoryBillStatus entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public HistoryBillStatusVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		HistoryBillStatus entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<HistoryBillStatusVo> selectListVoByParamVo(HistoryBillStatusParamVo historyBillStatus,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (historyBillStatus == null) {
			historyBillStatus = new HistoryBillStatusParamVo();
		}
		historyBillStatus.setTenantId(commonParam.getTenantId());

		List<HistoryBillStatus> list = (List<HistoryBillStatus>) this.getBaseService()
				.selectListByParamVo(historyBillStatus, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<HistoryBillStatusVo> selectPageVoByParamVo(HistoryBillStatusParamVo historyBillStatus,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (historyBillStatus == null) {
			historyBillStatus = new HistoryBillStatusParamVo();
		}
		historyBillStatus.setTenantId(commonParam.getTenantId());

		PageInfo<HistoryBillStatus> list = (PageInfo<HistoryBillStatus>) this.getBaseService()
				.selectPageByParamVo(historyBillStatus, commonParam, pageNo, pageSize);
		List<HistoryBillStatusVo> volist = new ArrayList<HistoryBillStatusVo>();

		Iterator<HistoryBillStatus> iter = list.getList().iterator();
		HistoryBillStatusVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<HistoryBillStatusVo> vpage = new Page<HistoryBillStatusVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public HistoryBillStatusVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		HistoryBillStatus entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<HistoryBillStatusVo> selectListExtendVoByParamVo(HistoryBillStatusParamVo historyBillStatus,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (historyBillStatus == null) {
			historyBillStatus = new HistoryBillStatusParamVo();
		}
		historyBillStatus.setTenantId(commonParam.getTenantId());

		List<HistoryBillStatus> list = (List<HistoryBillStatus>) this.getBaseService()
				.selectListByParamVo(historyBillStatus, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<HistoryBillStatusVo> selectPageExtendVoByParamVo(HistoryBillStatusParamVo historyBillStatus,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (historyBillStatus == null) {
			historyBillStatus = new HistoryBillStatusParamVo();
		}
		historyBillStatus.setTenantId(commonParam.getTenantId());

		PageInfo<HistoryBillStatus> list = (PageInfo<HistoryBillStatus>) this.getBaseService()
				.selectPageByParamVo(historyBillStatus, commonParam, pageNo, pageSize);
		List<HistoryBillStatusVo> volist = new ArrayList<HistoryBillStatusVo>();

		Iterator<HistoryBillStatus> iter = list.getList().iterator();
		HistoryBillStatusVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<HistoryBillStatusVo> vpage = new Page<HistoryBillStatusVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(HistoryBillStatusParamVo historyBillStatusParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		HistoryBillStatus historyBillStatus = null;
		try {
			if (historyBillStatusParamVo.getId() == null) {// 新增

				historyBillStatusParamVo.setTenantId(commonParam.getTenantId());
				historyBillStatus = historyBillStatusService.saveOrUpdate(historyBillStatusParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				HistoryBillStatus historyBillStatusVoTemp = this.selectById(historyBillStatusParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(historyBillStatusVoTemp, historyBillStatusParamVo);

				historyBillStatus = historyBillStatusService.saveOrUpdate(historyBillStatusVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(historyBillStatus);
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
