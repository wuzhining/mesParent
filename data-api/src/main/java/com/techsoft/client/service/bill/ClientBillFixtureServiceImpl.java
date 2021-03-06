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
import com.techsoft.common.enums.EnumEquipBillType;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;

import com.techsoft.entity.common.BillFixture;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.bill.BillFixtureVo;
import com.techsoft.entity.bill.BillFixtureParamVo;
import com.techsoft.service.bill.BillFixtureService;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.firm.FirmDepartmentService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructWorkstationService;

@org.springframework.stereotype.Service
public class ClientBillFixtureServiceImpl extends BaseClientServiceImpl<BillFixture>
		implements ClientBillFixtureService {
	@com.alibaba.dubbo.config.annotation.Reference
	private BillFixtureService billFixtureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmDepartmentService firmDepartmentService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkstationService structWorkstationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	
	@Override
	public BaseService<BillFixture> getBaseService() {
		return billFixtureService;
	}

	private BillFixtureVo getVo(BillFixture billFixture, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillFixtureVo vo = new BillFixtureVo(billFixture);
		if (vo.getBillTypeFixtureDictId() != null && vo.getBillTypeFixtureDictId() > 0L) {
			ConfigDictionary configDictionaryType = configDictionaryService.selectById(vo.getBillTypeFixtureDictId(),
					commonParam);
			if (configDictionaryType != null) {
				vo.setConfigDictionaryType(configDictionaryType);
			}
		}
		if (vo.getBillStatusFixtureDictId() != null && vo.getBillStatusFixtureDictId() > 0L) {
			ConfigDictionary configDictionaryStatus = configDictionaryService
					.selectById(vo.getBillStatusFixtureDictId(), commonParam);
			if (configDictionaryStatus != null) {
				vo.setConfigDictionaryStatus(configDictionaryStatus);
			}
		}
		if (vo.getDepartmentId() != null && vo.getDepartmentId() > 0L) {
			FirmDepartment firmDepartment = firmDepartmentService.selectById(vo.getDepartmentId(), commonParam);
			if (firmDepartment != null) {
				vo.setFirmDepartment(firmDepartment);
			}
		}
		if (vo.getWorkstationId() != null && vo.getWorkstationId() > 0L) {
			StructWorkstation structWorkstation = structWorkstationService.selectById(vo.getWorkstationId(),
					commonParam);
			if (structWorkstation != null) {
				vo.setStructWorkstation(structWorkstation);
			}
		}
		if(vo.getFactoryId() != null && vo.getFactoryId() > 0L){
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if(structFactory != null){
				vo.setStructFactory(structFactory);
			}
		}
		if(vo.getAuditStatusDictId() != null && vo.getAuditStatusDictId() > 0L){
			ConfigDictionary auditStatusDictType = configDictionaryService.selectById(vo.getAuditStatusDictId(), commonParam);
			if(auditStatusDictType != null){
				vo.setAuditStatusDictType(auditStatusDictType);
			}
		}
		return vo;
	}

	private BillFixtureVo getExtendVo(BillFixture billFixture, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillFixtureVo vo = this.getVo(billFixture, commonParam);

		return vo;
	}

	private List<BillFixtureVo> getVoList(List<BillFixture> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillFixtureVo> voList = new ArrayList<BillFixtureVo>();
		for (BillFixture entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<BillFixtureVo> getExtendVoList(List<BillFixture> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillFixtureVo> voList = new ArrayList<BillFixtureVo>();
		for (BillFixture entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public BillFixtureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillFixture entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<BillFixtureVo> selectListVoByParamVo(BillFixtureParamVo billFixture, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (billFixture == null) {
			billFixture = new BillFixtureParamVo();
		}
		billFixture.setTenantId(commonParam.getTenantId());

		List<BillFixture> list = (List<BillFixture>) this.getBaseService().selectListByParamVo(billFixture,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillFixtureVo> selectPageVoByParamVo(BillFixtureParamVo billFixture, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billFixture == null) {
			billFixture = new BillFixtureParamVo();
		}
		billFixture.setTenantId(commonParam.getTenantId());

		PageInfo<BillFixture> list = (PageInfo<BillFixture>) this.getBaseService().selectPageByParamVo(billFixture,
				commonParam, pageNo, pageSize);
		List<BillFixtureVo> volist = new ArrayList<BillFixtureVo>();

		Iterator<BillFixture> iter = list.getList().iterator();
		BillFixtureVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillFixtureVo> vpage = new Page<BillFixtureVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public BillFixtureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillFixture entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<BillFixtureVo> selectListExtendVoByParamVo(BillFixtureParamVo billFixture, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (billFixture == null) {
			billFixture = new BillFixtureParamVo();
		}
		billFixture.setTenantId(commonParam.getTenantId());

		List<BillFixture> list = (List<BillFixture>) this.getBaseService().selectListByParamVo(billFixture,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillFixtureVo> selectPageExtendVoByParamVo(BillFixtureParamVo billFixture, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billFixture == null) {
			billFixture = new BillFixtureParamVo();
		}
		billFixture.setTenantId(commonParam.getTenantId());

		PageInfo<BillFixture> list = (PageInfo<BillFixture>) this.getBaseService().selectPageByParamVo(billFixture,
				commonParam, pageNo, pageSize);
		List<BillFixtureVo> volist = new ArrayList<BillFixtureVo>();

		Iterator<BillFixture> iter = list.getList().iterator();
		BillFixtureVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillFixtureVo> vpage = new Page<BillFixtureVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(BillFixtureParamVo billFixtureParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		BillFixture billFixture = null;
		try {
			if (billFixtureParamVo.getId() == null) {// 新增
				//生成编码
				String code = configCodeRuleService.createCode(BillFixture.class.getName(), null, null, commonParam);
				if(code!=null&&code!=""){
					billFixtureParamVo.setBillCode(code);
					billFixtureParamVo.setTenantId(commonParam.getTenantId());
					billFixture = billFixtureService.saveOrUpdate(billFixtureParamVo, commonParam);
					resultMessage.setIsSuccess(true);
				}else{
					resultMessage.addErr("请维护工具领用申请编码再添加");
					return resultMessage;
				}
			} else { // 修改
				BillFixture billFixtureVoTemp = this.selectById(billFixtureParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(billFixtureVoTemp, billFixtureParamVo);

				billFixture = billFixtureService.saveOrUpdate(billFixtureVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(billFixture);
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
