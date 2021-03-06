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
import com.techsoft.common.enums.EnumAuditStatus;
import com.techsoft.common.enums.EnumBillStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;

import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.BillPurchaseItem;
import com.techsoft.entity.common.BillSaleorder;
import com.techsoft.entity.common.BillSaleorderItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.HistoryBillStatus;
import com.techsoft.entity.history.HistoryBillStatusVo;
import com.techsoft.entity.bill.BillPurchaseVo;
import com.techsoft.entity.bill.BillSaleorderItemParamVo;
import com.techsoft.entity.bill.BillSaleorderParamVo;
import com.techsoft.entity.bill.BillSaleorderVo;
import com.techsoft.entity.bill.BillPurchaseItemParamVo;
import com.techsoft.entity.bill.BillPurchaseParamVo;
import com.techsoft.service.bill.BillPurchaseItemService;
import com.techsoft.service.bill.BillPurchaseService;
import com.techsoft.service.bill.BillSaleorderItemService;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.firm.FirmPartnerService;
import com.techsoft.service.history.HistoryBillStatusService;

@org.springframework.stereotype.Service
public class ClientBillPurchaseServiceImpl extends BaseClientServiceImpl<BillPurchase>
		implements ClientBillPurchaseService {
	@com.alibaba.dubbo.config.annotation.Reference
	private BillPurchaseService billPurchaseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmPartnerService firmPartnerService;
	@com.alibaba.dubbo.config.annotation.Reference
	private HistoryBillStatusService historyBillStatusService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillPurchaseItemService billPurchaseItemService;
	@Override
	public BaseService<BillPurchase> getBaseService() {
		return billPurchaseService;
	}

	private BillPurchaseVo getVo(BillPurchase billPurchase, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillPurchaseVo vo = new BillPurchaseVo(billPurchase);
		//供应商
		if (vo.getSupplierId() != null && vo.getSupplierId() > 0L) {
			FirmPartner firmPartner = firmPartnerService.selectById(vo.getSupplierId(), commonParam);
			if (firmPartner != null) {
				vo.setFirmPartnerLiat(firmPartner);
			}
		}
		//采购单状态
		if (vo.getBillStatusDictId() != null && vo.getBillStatusDictId() > 0L) {
			ConfigDictionary billStatus = configDictionaryService.selectById(vo.getBillStatusDictId(), commonParam);
			if (billStatus != null) {
				vo.setBillStatusDic(billStatus);
			}
		}
		// 销售单审批状态
		if (vo.getAuditStatusDictId() != null && vo.getAuditStatusDictId() > 0L) {
			ConfigDictionary auditStatusDict = configDictionaryService.selectById(vo.getAuditStatusDictId(), commonParam);
			if (auditStatusDict != null) {
				vo.setAuditStatusDict(auditStatusDict);
			}
		}
		return vo;
	}

	private BillPurchaseVo getExtendVo(BillPurchase billPurchase, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillPurchaseVo vo = this.getVo(billPurchase, commonParam);

		return vo;
	}

	private List<BillPurchaseVo> getVoList(List<BillPurchase> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillPurchaseVo> voList = new ArrayList<BillPurchaseVo>();
		for (BillPurchase entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<BillPurchaseVo> getExtendVoList(List<BillPurchase> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillPurchaseVo> voList = new ArrayList<BillPurchaseVo>();
		for (BillPurchase entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public BillPurchaseVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillPurchase entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<BillPurchaseVo> selectListVoByParamVo(BillPurchaseParamVo billPurchase, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (billPurchase == null) {
			billPurchase = new BillPurchaseParamVo();
		}
		billPurchase.setTenantId(commonParam.getTenantId());

		List<BillPurchase> list = (List<BillPurchase>) this.getBaseService().selectListByParamVo(billPurchase,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillPurchaseVo> selectPageVoByParamVo(BillPurchaseParamVo billPurchase, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billPurchase == null) {
			billPurchase = new BillPurchaseParamVo();
		}
		billPurchase.setTenantId(commonParam.getTenantId());
		
		PageInfo<BillPurchase> list = (PageInfo<BillPurchase>) this.getBaseService().selectPageByParamVo(billPurchase,
				commonParam, pageNo, pageSize);
		List<BillPurchaseVo> volist = new ArrayList<BillPurchaseVo>();

		Iterator<BillPurchase> iter = list.getList().iterator();
		BillPurchaseVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillPurchaseVo> vpage = new Page<BillPurchaseVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public BillPurchaseVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillPurchase entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<BillPurchaseVo> selectListExtendVoByParamVo(BillPurchaseParamVo billPurchase, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (billPurchase == null) {
			billPurchase = new BillPurchaseParamVo();
		}
		billPurchase.setTenantId(commonParam.getTenantId());

		List<BillPurchase> list = (List<BillPurchase>) this.getBaseService().selectListByParamVo(billPurchase,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillPurchaseVo> selectPageExtendVoByParamVo(BillPurchaseParamVo billPurchase,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billPurchase == null) {
			billPurchase = new BillPurchaseParamVo();
		}
		billPurchase.setTenantId(commonParam.getTenantId());

		PageInfo<BillPurchase> list = (PageInfo<BillPurchase>) this.getBaseService().selectPageByParamVo(billPurchase,
				commonParam, pageNo, pageSize);
		List<BillPurchaseVo> volist = new ArrayList<BillPurchaseVo>();

		Iterator<BillPurchase> iter = list.getList().iterator();
		BillPurchaseVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillPurchaseVo> vpage = new Page<BillPurchaseVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(BillPurchaseParamVo billPurchaseParamVo, CommonParam commonParam ,String SP) {
		ResultMessage resultMessage = new ResultMessage();
		BillPurchase billPurchase = null;
		try {
			if (billPurchaseParamVo.getId() == null) {// 新增
				//采购单编码生成
				String code = configCodeRuleService.createCode(BillPurchase.class.getName(), null, null, commonParam);
				if(code!=null&&code!=""){
					  billPurchaseParamVo.setBillCode(code);
					  billPurchaseParamVo.setTenantId(commonParam.getTenantId());
					  billPurchaseService.saveOrUpdate(billPurchaseParamVo, commonParam);
					  resultMessage.setIsSuccess(true);
				}else{
					resultMessage.addErr("请维护采购单编码再添加");
					return resultMessage;
				}

			} else { // 修改
				BillPurchase billPurchaseVoTemp = this.selectById(billPurchaseParamVo.getId(), commonParam);
				BeanUtil.copyNotNullProperties(billPurchaseVoTemp, billPurchaseParamVo);
				if(SP!=null){
					billPurchaseVoTemp.setBillStatusDictId(EnumBillStatus.DOING.getValue());//处理中状态
				}
				billPurchase = billPurchaseService.saveOrUpdate(billPurchaseVoTemp, commonParam);			
				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(billPurchase);
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
