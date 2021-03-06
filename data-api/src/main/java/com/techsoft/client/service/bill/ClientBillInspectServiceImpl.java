package com.techsoft.client.service.bill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.techsoft.entity.bill.BillInspectParamVo;
import com.techsoft.entity.bill.BillInspectVo;
import com.techsoft.entity.bill.BillWarehouseItemParamVo;
import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.history.HistoryBillStatusAuditParamVo;
import com.techsoft.entity.history.HistoryBillStatusParamVo;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.entity.track.TrackBarcodeParamVo;
import com.techsoft.service.bill.BillInspectService;
import com.techsoft.service.bill.BillWarehouseItemService;
import com.techsoft.service.bill.BillWarehouseService;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.firm.FirmPartnerService;
import com.techsoft.service.history.HistoryBillStatusAuditService;
import com.techsoft.service.history.HistoryBillStatusService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.sys.UserPassportService;
import com.techsoft.service.track.TrackBarcodeService;

@org.springframework.stereotype.Service
public class ClientBillInspectServiceImpl extends BaseClientServiceImpl<BillInspect>
		implements ClientBillInspectService {
	@com.alibaba.dubbo.config.annotation.Reference
	private BillInspectService billInspectService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmPartnerService firmPartnerService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWarehouseService billWarehouseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWarehouseItemService billWarehouseItemService;
	@com.alibaba.dubbo.config.annotation.Reference
	private TrackBarcodeService trackBarcodeService;
	@com.alibaba.dubbo.config.annotation.Reference
	private HistoryBillStatusService historyBillStatusService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	//工厂名称
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	//操作人
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
	
	@com.alibaba.dubbo.config.annotation.Reference
	private HistoryBillStatusAuditService historyBillStatusAuditService;
	@Override
	public BaseService<BillInspect> getBaseService() {
		return billInspectService;
	}

	private BillInspectVo getVo(BillInspect billInspect, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillInspectVo vo = new BillInspectVo(billInspect);

		// 源单据类型
		if (vo.getFromBillTypeDictId() != null && vo.getFromBillTypeDictId() > 0L) {
			ConfigDictionary getFromBillType = configDictionaryService.selectById(vo.getFromBillTypeDictId(),
					commonParam);
			if (getFromBillType != null) {
				vo.setFromBillTypeList(getFromBillType);
			}
		}
		// 检验单状态
		if (vo.getInspectStatusDictId() != null && vo.getInspectStatusDictId() > 0L) {
			ConfigDictionary getInspectStatus = configDictionaryService.selectById(vo.getInspectStatusDictId(),
					commonParam);
			if (getInspectStatus != null) {
				vo.setInspectStatusList(getInspectStatus);
			}
		}
		// 检验结果
		if (vo.getInspectResultDictId() != null && vo.getInspectResultDictId() > 0L) {
			ConfigDictionary getInspectResult = configDictionaryService.selectById(vo.getInspectResultDictId(),
					commonParam);
			if (getInspectResult != null) {
				vo.setInspectResultList(getInspectResult);
			}
		}

		// 处理结果
		if (vo.getDealResultDictId() != null && vo.getDealResultDictId() > 0L) {
			ConfigDictionary getDealResult = configDictionaryService.selectById(vo.getDealResultDictId(), commonParam);
			if (getDealResult != null) {
				vo.setDealResultList(getDealResult);
			}
		}

		// 获取供应商
		if (vo.getSupplierId() != null && vo.getSupplierId() > 0L) {
			FirmPartner getFirmPartner = firmPartnerService.selectById(vo.getSupplierId(), commonParam);
			if (getFirmPartner != null) {
				vo.setFirmPartnerList(getFirmPartner);
			}
		}

		// 获取物料信息
		if (vo.getMaterialId() != null && vo.getMaterialId() > 0L) {
			ProductMaterial productMaterial = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if (productMaterial != null) {
				//物品
				if(productMaterial.getProductId() != null && productMaterial.getProductId() > 0L){
					ProductMain productMain=productMainService.selectById(productMaterial.getProductId(), commonParam);
					if(productMain != null){
						vo.setProductMain(productMain);
					}
				}
				//物品类型
				if(productMaterial.getProductTypeDictId() != null && productMaterial.getProductTypeDictId() > 0L){
					ConfigDictionary productType=configDictionaryService.selectById(productMaterial.getProductTypeDictId(), commonParam);
					if(productType != null){
						vo.setProductType(productType);
					}
				}
				//物品规格值
				if(productMaterial.getSkuValue()!=null&&productMaterial.getSkuValue()!=""){
					ProductMaterialVo productMateriaVo=new ProductMaterialVo();
					productMateriaVo.setSkuValue(productMaterial.getSkuValue());
					vo.setProductMaterialVo(productMateriaVo);
				}
				vo.setProductMaterial(productMaterial);
			}
		}

		// 从数据字典里获取抽样方式
		if (vo.getInspectModeDictId() != null && vo.getInspectModeDictId() > 0L) {
			ConfigDictionary getInspectModeResult = configDictionaryService.selectById(vo.getInspectModeDictId(),
					commonParam);
			if (getInspectModeResult != null) {
				vo.setInspectModeList(getInspectModeResult);
			}
		}
		
		//操作人
		if (vo.getCreateUserId() != null && vo.getCreateUserId() > 0L) {
			UserPassport userPassport = userPassportService.selectById(vo.getCreateUserId(), commonParam);
			if (userPassport != null) {
				vo.setUserPassportList(userPassport);
			}
		}
		
		//工厂名称
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactorylist(structFactory);
			}
		}
		
		//仓库到货到
		if (vo.getFromBillId() != null && vo.getFromBillId() > 0L) {
			BillWarehouse billWarehouse = billWarehouseService.selectById(vo.getFromBillId(), commonParam);
			if (billWarehouse != null) {
				vo.setBillWarehouse(billWarehouse);
			}
		}
		//审核状态
		if(vo.getAuditStatusDictId() != null && vo.getAuditStatusDictId() > 0L){
			ConfigDictionary auditStatusDict = configDictionaryService.selectById(vo.getAuditStatusDictId(), commonParam);
			if(auditStatusDict != null){
				vo.setAuditStatusDict(auditStatusDict);
			}
		}
		// IQC来料待检看板待检时长
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String createtime = simpleFormat.format(vo.getCreateTime());
		Date date = new Date();
		String nowtime = simpleFormat.format(date);
		Date old = null;
		Date now = null;
		try {
			old = simpleFormat.parse(createtime);
			now = simpleFormat.parse(nowtime);
			long from2 = old.getTime();
			long to2 = now.getTime();
			int days = (int) ((to2 - from2) / (1000 * 60 * 60 * 24));
			int hours = (int) (((to2 - from2) % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
			int minutes = (int) ((((to2 - from2) % (1000 * 60 * 60 * 24)) % (1000 * 60 * 60)) / (1000 * 60));
			int ss = (int) (((((to2 - from2) % (1000 * 60 * 60 * 24)) % (1000 * 60 * 60)) % (1000 * 60)) / 1000);
			vo.setWaitingTime(days + "天" + hours + "时" + minutes + "分" + ss + "秒");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return vo;
	}

	private BillInspectVo getExtendVo(BillInspect billInspect, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillInspectVo vo = this.getVo(billInspect, commonParam);

		return vo;
	}

	private List<BillInspectVo> getVoList(List<BillInspect> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillInspectVo> voList = new ArrayList<BillInspectVo>();
		for (BillInspect entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<BillInspectVo> getExtendVoList(List<BillInspect> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillInspectVo> voList = new ArrayList<BillInspectVo>();
		for (BillInspect entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public BillInspectVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillInspect entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<BillInspectVo> selectListVoByParamVo(BillInspectParamVo billInspect, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (billInspect == null) {
			billInspect = new BillInspectParamVo();
		}
		billInspect.setTenantId(commonParam.getTenantId());

		List<BillInspect> list = (List<BillInspect>) this.getBaseService().selectListByParamVo(billInspect,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillInspectVo> selectPageVoByParamVo(BillInspectParamVo billInspect, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billInspect == null) {
			billInspect = new BillInspectParamVo();
		}
		billInspect.setTenantId(commonParam.getTenantId());

		PageInfo<BillInspect> list = (PageInfo<BillInspect>) this.getBaseService().selectPageByParamVo(billInspect,
				commonParam, pageNo, pageSize);
		List<BillInspectVo> volist = new ArrayList<BillInspectVo>();

		Iterator<BillInspect> iter = list.getList().iterator();
		BillInspectVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillInspectVo> vpage = new Page<BillInspectVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public BillInspectVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillInspect entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<BillInspectVo> selectListExtendVoByParamVo(BillInspectParamVo billInspect, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (billInspect == null) {
			billInspect = new BillInspectParamVo();
		}
		billInspect.setTenantId(commonParam.getTenantId());

		List<BillInspect> list = (List<BillInspect>) this.getBaseService().selectListByParamVo(billInspect,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillInspectVo> selectPageExtendVoByParamVo(BillInspectParamVo billInspect, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billInspect == null) {
			billInspect = new BillInspectParamVo();
		}
		billInspect.setTenantId(commonParam.getTenantId());

		PageInfo<BillInspect> list = (PageInfo<BillInspect>) this.getBaseService().selectPageByParamVo(billInspect,
				commonParam, pageNo, pageSize);
		List<BillInspectVo> volist = new ArrayList<BillInspectVo>();

		Iterator<BillInspect> iter = list.getList().iterator();
		BillInspectVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillInspectVo> vpage = new Page<BillInspectVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	@Override
	public List<BillWarehouseItem> getbillItemListBybillId(Long billId, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillWarehouseItem> list = new ArrayList<BillWarehouseItem>();
		BillWarehouseItemParamVo billWarehouseItemParamVo = new BillWarehouseItemParamVo();
		billWarehouseItemParamVo.setBillId(billId);
		list = billWarehouseItemService.selectListByParamVo(billWarehouseItemParamVo, commonParam);
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	public ResultMessage saveOrUpdate(BillInspectParamVo billInspectParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		BillInspect billInspect = null;
		try {
			if (billInspectParamVo.getId() == null) {// 新增
				billInspectParamVo.setTenantId(commonParam.getTenantId());
				billInspect = billInspectService.saveOrUpdate(billInspectParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				BillInspect billInspectVoTemp = this.selectById(billInspectParamVo.getId(), commonParam);
				BeanUtil.copyNotNullProperties(billInspectVoTemp, billInspectParamVo);
				billInspect = billInspectService.saveOrUpdate(billInspectVoTemp, commonParam);
				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(billInspect);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}
	
	//保存审核
	public ResultMessage saveExamine(BillInspectParamVo billInspectParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		BillInspect billInspect = null;
		try {
			if (billInspectParamVo.getId() != null) {// 审核
				List<TrackBarcode> inspectTrackList = new ArrayList<TrackBarcode>();
				TrackBarcodeParamVo paramVo =new TrackBarcodeParamVo();
				paramVo.setBillItemId(billInspectParamVo.getId());
				inspectTrackList= trackBarcodeService.selectListByParamVo(paramVo, commonParam);
				if (inspectTrackList.size()!= 0) {
					BillInspect billInspectVoTemp = this.selectById(billInspectParamVo.getId(), commonParam);
					BeanUtil.copyNotNullProperties(billInspectVoTemp, billInspectParamVo);
					billInspect = billInspectService.saveOrUpdate(billInspectVoTemp, commonParam);
					
					//查询单据号
					BillInspect bill= billInspectService.selectById(billInspect.getId(), commonParam);
					historyBillStatusService.billHistoryInsert(EnumBillType.BILL_TYPE_EXAMINE.getValue(), EnumBillStatus.DOING.getValue(), billInspect.getId(),bill.getInspectCode(), commonParam);

					//historyBillStatusService.billHistoryInsert(EnumDictBillType.BILL_TYPE_EXAMINE.getValue(), EnumDictBillStatus.DOING.getValue(), billInspect.getId(),billInspect.getFromBillCode(), commonParam);
					historyBillStatusAuditService.billAuditHistoryInsert(EnumBillType.BILL_TYPE_EXAMINE.getValue(), EnumAuditStatus.AUDITED.getValue(), billInspect.getId(), bill.getInspectCode(), commonParam);
					resultMessage.setIsSuccess(true);
				}else{
					resultMessage.setMessage("【"+paramVo.getBillItemId()+"】"+"没有生成标签不能审核");
				}
			}
			resultMessage.setBaseEntity(billInspect);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}
	
	
	//质检
	public ResultMessage inspectionOKorNG(BillInspectParamVo billInspectVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		if (billInspectVo.getInspectResultDictId() == null) {
			resultMessage.addErr("检验结果不能为空");
			return resultMessage;
		}
		if (billInspectVo.getDealResultDictId() == null) {
			resultMessage.addErr("处理结果不能为空");
			return resultMessage;
		}
		
		if (billInspectVo.getQuantitySample() == null) {
			resultMessage.addErr("实际抽样数量不能为空");
			return resultMessage;
		}
		
		if (billInspectVo.getQuantitySampleFail() == null) {
			resultMessage.addErr("抽样不合格数量不能为空");
			return resultMessage;
		}
		/*if (billInspectVo.getRemark().length() > 128) {
			resultMessage.addErr("备注不能超过128个字符");
			return resultMessage;
		}*/
		try {
			  resultMessage = billInspectService.updateInspectOKorNG(billInspectVo, commonParam);
			if (resultMessage.getIsSuccess().equals(true)) {			
				HistoryBillStatusParamVo HistoryBillStatusParamVo = new HistoryBillStatusParamVo();
				HistoryBillStatusParamVo.setBillId(billInspectVo.getId());
				HistoryBillStatusParamVo.setBillTypeDictId(billInspectVo.getFromBillTypeDictId());
				HistoryBillStatusParamVo.setBillStatusDictId(billInspectVo.getInspectStatusDictId());
				HistoryBillStatusParamVo.setTenantId(commonParam.getTenantId());
				historyBillStatusService.saveOrUpdate(HistoryBillStatusParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			}
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillInspectVo> selectIQCIncomeScreen(CommonParam commonParam)
			throws BusinessException, SQLException {

		List<BillInspect> list = (List<BillInspect>) billInspectService.selectIQCIncomeScreen();
		List<BillInspectVo> volist = new ArrayList<BillInspectVo>();

		Iterator<BillInspect> iter = list.iterator();
		BillInspectVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillInspectVo> vpage = new Page<BillInspectVo>();
		vpage.addAll(volist);
		vpage.setPageNum(1);
		vpage.setPageSize(1);
		vpage.setTotal(1);

		return new PageInfo(vpage);
	}

}
