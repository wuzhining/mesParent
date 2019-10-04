package com.techsoft.client.service.equip;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipClassesFixture;
import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.equip.EquipSpecsFixtureParamVo;
import com.techsoft.entity.equip.EquipSpecsFixtureVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.equip.EquipClassesFixtureService;
import com.techsoft.service.equip.EquipSpecsFixtureService;
import com.techsoft.service.firm.FirmPartnerService;

@org.springframework.stereotype.Service
public class ClientEquipSpecsFixtureServiceImpl extends BaseClientServiceImpl<EquipSpecsFixture>
		implements ClientEquipSpecsFixtureService {
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipSpecsFixtureService equipSpecsFixtureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmPartnerService firmPartnerService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipClassesFixtureService equipClassesFixtureService;
	@Override
	public BaseService<EquipSpecsFixture> getBaseService() {
		return equipSpecsFixtureService;
	}

	private EquipSpecsFixtureVo getVo(EquipSpecsFixture equipSpecsFixture, CommonParam commonParam)
			throws BusinessException, SQLException {
		EquipSpecsFixtureVo vo = new EquipSpecsFixtureVo(equipSpecsFixture);
		//工具分类
		if (vo.getClassesId() != null && vo.getClassesId() > 0L) {
			EquipClassesFixture equipClassesFixture = equipClassesFixtureService.selectById(vo.getClassesId(), commonParam);
			if (equipClassesFixture != null) {
				vo.setEquipClassesFixture(equipClassesFixture);
			}
		}
		if (vo.getFixtureStatusDictId() != null && vo.getFixtureStatusDictId() > 0L) {
			ConfigDictionary configDictionaryStatus = configDictionaryService.selectById(vo.getFixtureStatusDictId(),
					commonParam);
			if (configDictionaryStatus != null) {
				vo.setConfigDictionaryStatus(configDictionaryStatus);
			}
		}
		if (vo.getSupplierId() != null && vo.getSupplierId() > 0L) {
			FirmPartner firmPartner = firmPartnerService.selectById(vo.getSupplierId(), commonParam);
			if (firmPartner != null) {
				vo.setFirmPartner(firmPartner);
			}
		}
		return vo;
	}

	private EquipSpecsFixtureVo getExtendVo(EquipSpecsFixture equipSpecsFixture, CommonParam commonParam)
			throws BusinessException, SQLException {
		EquipSpecsFixtureVo vo = this.getVo(equipSpecsFixture, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	}

	private List<EquipSpecsFixtureVo> getVoList(List<EquipSpecsFixture> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<EquipSpecsFixtureVo> voList = new ArrayList<EquipSpecsFixtureVo>();
		for (EquipSpecsFixture entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<EquipSpecsFixtureVo> getExtendVoList(List<EquipSpecsFixture> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<EquipSpecsFixtureVo> voList = new ArrayList<EquipSpecsFixtureVo>();
		for (EquipSpecsFixture entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public EquipSpecsFixtureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipSpecsFixture entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<EquipSpecsFixtureVo> selectListVoByParamVo(EquipSpecsFixtureParamVo equipSpecsFixture,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (equipSpecsFixture == null) {
			equipSpecsFixture = new EquipSpecsFixtureParamVo();
		}
		equipSpecsFixture.setTenantId(commonParam.getTenantId());

		List<EquipSpecsFixture> list = (List<EquipSpecsFixture>) this.getBaseService()
				.selectListByParamVo(equipSpecsFixture, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<EquipSpecsFixtureVo> selectPageVoByParamVo(EquipSpecsFixtureParamVo equipSpecsFixture,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (equipSpecsFixture == null) {
			equipSpecsFixture = new EquipSpecsFixtureParamVo();
		}
		equipSpecsFixture.setTenantId(commonParam.getTenantId());

		PageInfo<EquipSpecsFixture> list = (PageInfo<EquipSpecsFixture>) this.getBaseService()
				.selectPageByParamVo(equipSpecsFixture, commonParam, pageNo, pageSize);
		List<EquipSpecsFixtureVo> volist = new ArrayList<EquipSpecsFixtureVo>();

		Iterator<EquipSpecsFixture> iter = list.getList().iterator();
		EquipSpecsFixtureVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<EquipSpecsFixtureVo> vpage = new Page<EquipSpecsFixtureVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public EquipSpecsFixtureVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		EquipSpecsFixture entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<EquipSpecsFixtureVo> selectListExtendVoByParamVo(EquipSpecsFixtureParamVo equipSpecsFixture,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (equipSpecsFixture == null) {
			equipSpecsFixture = new EquipSpecsFixtureParamVo();
		}
		equipSpecsFixture.setTenantId(commonParam.getTenantId());

		List<EquipSpecsFixture> list = (List<EquipSpecsFixture>) this.getBaseService()
				.selectListByParamVo(equipSpecsFixture, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<EquipSpecsFixtureVo> selectPageExtendVoByParamVo(EquipSpecsFixtureParamVo equipSpecsFixture,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (equipSpecsFixture == null) {
			equipSpecsFixture = new EquipSpecsFixtureParamVo();
		}
		equipSpecsFixture.setTenantId(commonParam.getTenantId());

		PageInfo<EquipSpecsFixture> list = (PageInfo<EquipSpecsFixture>) this.getBaseService()
				.selectPageByParamVo(equipSpecsFixture, commonParam, pageNo, pageSize);
		List<EquipSpecsFixtureVo> volist = new ArrayList<EquipSpecsFixtureVo>();

		Iterator<EquipSpecsFixture> iter = list.getList().iterator();
		EquipSpecsFixtureVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<EquipSpecsFixtureVo> vpage = new Page<EquipSpecsFixtureVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(EquipSpecsFixtureParamVo equipSpecsFixtureParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		EquipSpecsFixture equipSpecsFixture = null;
		try {
			
			if(equipSpecsFixtureParamVo.getFixtureSpecsName()==null){
				resultMessage.addErr("工具品种规格名称不能为空！");
				return resultMessage;
			}
			
			if(equipSpecsFixtureParamVo.getClassesId()==null){
				resultMessage.addErr("工具类型不能为空！");
				return resultMessage;
			}
			if(equipSpecsFixtureParamVo.getFixtureStatusDictId()==null){
				resultMessage.addErr("工具状态不能为空！");
				return resultMessage;
			}

			if(equipSpecsFixtureParamVo.getStandarlive()==null){
				resultMessage.addErr("标准寿命不能为空！");
				return resultMessage;
			}
			
			if(equipSpecsFixtureParamVo.getQuantity()==null){
				resultMessage.addErr("数量不能为空！");
				return resultMessage;
			}
			if(equipSpecsFixtureParamVo.getSupplierId()==null){
				resultMessage.addErr("供应商名称不能为空！");
				return resultMessage;
			}
			if (equipSpecsFixtureParamVo.getId() == null) {// 新增
				//生成编码
				String code = equipSpecsFixtureParamVo.getFixtureSpecsCode();
				if(StringUtils.isBlank(code)){
					 code = configCodeRuleService.createCode(EquipSpecsFixture.class.getName(), null, null, commonParam);
					 equipSpecsFixtureParamVo.setFixtureSpecsCode(code);
				}
				if(StringUtils.isBlank(code)){
					resultMessage.addErr("工具品种规格编码不能为空");
					return resultMessage;
				}
				//检验编码是否已存在
				EquipSpecsFixtureParamVo equipSpecsFixtureSearch = new EquipSpecsFixtureParamVo();
				equipSpecsFixtureSearch.setFixtureSpecsCode(code);
				List<EquipSpecsFixture> list = equipSpecsFixtureService.selectListByParamVo(equipSpecsFixtureSearch, commonParam);
				if((list!=null)&&(!list.isEmpty())){
					resultMessage.addErr("工具品种规格编码已存在");
					return resultMessage;
				}
				if(code!=null&&code!=""){
					equipSpecsFixtureParamVo.setFixtureSpecsCode(code);
					equipSpecsFixtureParamVo.setTenantId(commonParam.getTenantId());
					equipSpecsFixture = equipSpecsFixtureService.saveOrUpdate(equipSpecsFixtureParamVo, commonParam);
					resultMessage.setIsSuccess(true);
				}else{
					resultMessage.addErr("请维护冶具品种规格编码再添加");
					return resultMessage;
				}
				
			} else { // 修改
				EquipSpecsFixture equipSpecsFixtureVoTemp = this.selectById(equipSpecsFixtureParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(equipSpecsFixtureVoTemp, equipSpecsFixtureParamVo);

				equipSpecsFixture = equipSpecsFixtureService.saveOrUpdate(equipSpecsFixtureVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(equipSpecsFixture);
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
