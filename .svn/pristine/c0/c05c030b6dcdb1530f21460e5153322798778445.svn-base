package com.techsoft.client.service.bill;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumAuditStatus;
import com.techsoft.common.enums.EnumBillStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.bill.BillSaleorderItemParamVo;
import com.techsoft.entity.bill.BillSaleorderParamVo;
import com.techsoft.entity.bill.BillSaleorderVo;
import com.techsoft.entity.bill.BillWorkorderVo;
import com.techsoft.entity.common.BillSaleorder;
import com.techsoft.entity.common.BillSaleorderItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.service.bill.BillSaleorderItemService;
import com.techsoft.service.bill.BillSaleorderService;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.firm.FirmPartnerService;
import com.techsoft.service.history.HistoryBillStatusAuditService;
import com.techsoft.service.history.HistoryBillStatusService;

@org.springframework.stereotype.Service
public class ClientBillSaleorderServiceImpl extends BaseClientServiceImpl<BillSaleorder>
		implements ClientBillSaleorderService {
	@com.alibaba.dubbo.config.annotation.Reference
	private BillSaleorderService billSaleorderService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmPartnerService firmPartnerService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private HistoryBillStatusService historyBillStatusService;
	@com.alibaba.dubbo.config.annotation.Reference
	private HistoryBillStatusAuditService historyBillStatusAuditService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillSaleorderItemService billSaleorderItemService;
	@Override
	public BaseService<BillSaleorder> getBaseService() {
		return billSaleorderService;
	}

	private BillSaleorderVo getVo(BillSaleorder billSaleorder, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillSaleorderVo vo = new BillSaleorderVo(billSaleorder);
		// 客户
		if (vo.getCustomerId() != null && vo.getCustomerId() > 0L) {
			FirmPartner firmPartner = firmPartnerService.selectById(vo.getCustomerId(), commonParam);
			vo.setFirmPartner(firmPartner);
		}
		// 销售单状态
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

	private BillSaleorderVo getExtendVo(BillSaleorder billSaleorder, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillSaleorderVo vo = this.getVo(billSaleorder, commonParam);

		return vo;
	}

	private List<BillSaleorderVo> getVoList(List<BillSaleorder> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillSaleorderVo> voList = new ArrayList<BillSaleorderVo>();
		for (BillSaleorder entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<BillSaleorderVo> getExtendVoList(List<BillSaleorder> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillSaleorderVo> voList = new ArrayList<BillSaleorderVo>();
		for (BillSaleorder entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public BillSaleorderVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillSaleorder entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<BillSaleorderVo> selectListVoByParamVo(BillSaleorderParamVo billSaleorder, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (billSaleorder == null) {
			billSaleorder = new BillSaleorderParamVo();
		}
		billSaleorder.setTenantId(commonParam.getTenantId());

		List<BillSaleorder> list = (List<BillSaleorder>) this.getBaseService().selectListByParamVo(billSaleorder,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillSaleorderVo> selectPageVoByParamVo(BillSaleorderParamVo billSaleorder, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billSaleorder == null) {
			billSaleorder = new BillSaleorderParamVo();
		}
		billSaleorder.setTenantId(commonParam.getTenantId());

		PageInfo<BillSaleorder> list = (PageInfo<BillSaleorder>) this.getBaseService()
				.selectPageByParamVo(billSaleorder, commonParam, pageNo, pageSize);
		List<BillSaleorderVo> volist = new ArrayList<BillSaleorderVo>();

		Iterator<BillSaleorder> iter = list.getList().iterator();
		BillSaleorderVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillSaleorderVo> vpage = new Page<BillSaleorderVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public BillSaleorderVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillSaleorder entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<BillSaleorderVo> selectListExtendVoByParamVo(BillSaleorderParamVo billSaleorder,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (billSaleorder == null) {
			billSaleorder = new BillSaleorderParamVo();
		}
		billSaleorder.setTenantId(commonParam.getTenantId());

		List<BillSaleorder> list = (List<BillSaleorder>) this.getBaseService().selectListByParamVo(billSaleorder,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillSaleorderVo> selectPageExtendVoByParamVo(BillSaleorderParamVo billSaleorder,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billSaleorder == null) {
			billSaleorder = new BillSaleorderParamVo();
		}
		billSaleorder.setTenantId(commonParam.getTenantId());

		PageInfo<BillSaleorder> list = (PageInfo<BillSaleorder>) this.getBaseService()
				.selectPageByParamVo(billSaleorder, commonParam, pageNo, pageSize);
		List<BillSaleorderVo> volist = new ArrayList<BillSaleorderVo>();

		Iterator<BillSaleorder> iter = list.getList().iterator();
		BillSaleorderVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillSaleorderVo> vpage = new Page<BillSaleorderVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(BillSaleorderParamVo billSaleorderParamVo, CommonParam commonParam,String SP) {
		ResultMessage resultMessage = new ResultMessage();
		/*if (commonParam.getUserId() != null) {
			billSaleorderParamVo.setCreateUserId(Long.parseLong(commonParam.getUserId()));
		}

		if (billSaleorderParamVo.getCreateUserId() == null) {
			resultMessage.addErr("请先登录");
			return resultMessage;
		}*/

		BillSaleorder billSaleorder = null;
		try {
			if (billSaleorderParamVo.getId() == null) {// 新增
				// 自动生成销售单编码
				String code = configCodeRuleService.createCode(BillSaleorder.class.getName(), null, null, commonParam);
				
				if(code!=null&&code!=""){
					billSaleorderParamVo.setBillCode(code);
					billSaleorderParamVo.setTenantId(commonParam.getTenantId());
				    billSaleorderService.saveOrUpdate(billSaleorderParamVo, commonParam);
					resultMessage.setIsSuccess(true);
				}else{
					resultMessage.addErr("请维护销售单编码再添加");
					return resultMessage;
				}
			/*	//新增历史表 放到service层去做了
				historyBillStatusService.billHistoryInsert(EnumDictBillType.BILL_TYPE_SALEORDER.getValue(), EnumDictBillStatus.NEW.getValue(), billSaleorder.getId(), commonParam);
				//新增单据审批历史记录,新建都是未审批状态
				Long auditId=Long.getLong(EnumAuditStatus.UNAUDITED.getValue());
				historyBillStatusAuditService.billAuditHistoryInsert(EnumDictionary.AUDIT_STATUS.getValue(), auditId, billSaleorder.getId(), commonParam);
				*/
			} else { // 修改
				BillSaleorder billSaleorderVoTemp = this.selectById(billSaleorderParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(billSaleorderVoTemp, billSaleorderParamVo);
				if(SP!=null){
					billSaleorderVoTemp.setBillStatusDictId(EnumBillStatus.DOING.getValue());//处理中状态
				}
				billSaleorder = billSaleorderService.saveOrUpdate(billSaleorderVoTemp, commonParam);
		/*		//新增历史表
				historyBillStatusService.billHistoryInsert(EnumDictBillType.BILL_TYPE_SALEORDER.getValue(),billSaleorder.getBillStatusDictId(), billSaleorder.getId(), commonParam);
				//新增单据审批历史记录
				Long auditId=billSaleorderVoTemp.getAuditStatusDictId();
				historyBillStatusAuditService.billAuditHistoryInsert(EnumDictionary.AUDIT_STATUS.getValue(), auditId, billSaleorder.getId(), commonParam);*/
				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(billSaleorder);
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
