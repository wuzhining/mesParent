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
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.common.EquipWorkStack;
import com.techsoft.entity.equip.EquipWorkStackVo;
import com.techsoft.entity.equip.EquipWorkStackParamVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.equip.EquipWorkService;
import com.techsoft.service.equip.EquipWorkStackService;

@org.springframework.stereotype.Service
public class ClientEquipWorkStackServiceImpl extends BaseClientServiceImpl<EquipWorkStack>
		implements ClientEquipWorkStackService {
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipWorkStackService equipWorkStackService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipWorkService equipWorkService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@Override
	public BaseService<EquipWorkStack> getBaseService() {
		return equipWorkStackService;
	}

	private EquipWorkStackVo getVo(EquipWorkStack equipWorkStack, CommonParam commonParam)
			throws BusinessException, SQLException {
		EquipWorkStackVo vo = new EquipWorkStackVo(equipWorkStack);
		if (vo.getEquipWorkId() != null && vo.getEquipWorkId() > 0L) {
			EquipWork equipWork = equipWorkService.selectById(vo.getEquipWorkId(), commonParam);
			if (equipWork != null) {
				vo.setEquipWork(equipWork);
			}
		}
		return vo;
	}

	private EquipWorkStackVo getExtendVo(EquipWorkStack equipWorkStack, CommonParam commonParam)
			throws BusinessException, SQLException {
		EquipWorkStackVo vo = this.getVo(equipWorkStack, commonParam);

		return vo;
	}

	private List<EquipWorkStackVo> getVoList(List<EquipWorkStack> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<EquipWorkStackVo> voList = new ArrayList<EquipWorkStackVo>();
		for (EquipWorkStack entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<EquipWorkStackVo> getExtendVoList(List<EquipWorkStack> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<EquipWorkStackVo> voList = new ArrayList<EquipWorkStackVo>();
		for (EquipWorkStack entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public EquipWorkStackVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipWorkStack entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<EquipWorkStackVo> selectListVoByParamVo(EquipWorkStackParamVo equipWorkStack, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (equipWorkStack == null) {
			equipWorkStack = new EquipWorkStackParamVo();
		}
		equipWorkStack.setTenantId(commonParam.getTenantId());

		List<EquipWorkStack> list = (List<EquipWorkStack>) this.getBaseService().selectListByParamVo(equipWorkStack,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<EquipWorkStackVo> selectPageVoByParamVo(EquipWorkStackParamVo equipWorkStack,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (equipWorkStack == null) {
			equipWorkStack = new EquipWorkStackParamVo();
		}
		equipWorkStack.setTenantId(commonParam.getTenantId());

		PageInfo<EquipWorkStack> list = (PageInfo<EquipWorkStack>) this.getBaseService()
				.selectPageByParamVo(equipWorkStack, commonParam, pageNo, pageSize);
		List<EquipWorkStackVo> volist = new ArrayList<EquipWorkStackVo>();

		Iterator<EquipWorkStack> iter = list.getList().iterator();
		EquipWorkStackVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<EquipWorkStackVo> vpage = new Page<EquipWorkStackVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public EquipWorkStackVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipWorkStack entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<EquipWorkStackVo> selectListExtendVoByParamVo(EquipWorkStackParamVo equipWorkStack,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (equipWorkStack == null) {
			equipWorkStack = new EquipWorkStackParamVo();
		}
		equipWorkStack.setTenantId(commonParam.getTenantId());

		List<EquipWorkStack> list = (List<EquipWorkStack>) this.getBaseService().selectListByParamVo(equipWorkStack,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<EquipWorkStackVo> selectPageExtendVoByParamVo(EquipWorkStackParamVo equipWorkStack,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (equipWorkStack == null) {
			equipWorkStack = new EquipWorkStackParamVo();
		}
		equipWorkStack.setTenantId(commonParam.getTenantId());

		PageInfo<EquipWorkStack> list = (PageInfo<EquipWorkStack>) this.getBaseService()
				.selectPageByParamVo(equipWorkStack, commonParam, pageNo, pageSize);
		List<EquipWorkStackVo> volist = new ArrayList<EquipWorkStackVo>();

		Iterator<EquipWorkStack> iter = list.getList().iterator();
		EquipWorkStackVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<EquipWorkStackVo> vpage = new Page<EquipWorkStackVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(EquipWorkStackParamVo equipWorkStackParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		EquipWorkStack equipWorkStack = null;
		try {
			if (equipWorkStackParamVo.getId() == null) {// 新增
				//生成编码
				String code = equipWorkStackParamVo.getEquipStackCode();
				if(StringUtils.isBlank(code)){
					 code = configCodeRuleService.createCode(EquipWorkStack.class.getName(), null, null, commonParam);
					equipWorkStackParamVo.setEquipStackCode(code);
				}
				if(StringUtils.isBlank(code)){
					resultMessage.addErr("生产设备栈位编码不能为空");
					return resultMessage;
				}
				//检验编码是否已存在
				EquipWorkStackParamVo equipWorkStackSearch = new EquipWorkStackParamVo();
				equipWorkStackSearch.setEquipStackCode(code);
				List<EquipWorkStack> list = equipWorkStackService.selectListByParamVo(equipWorkStackSearch, commonParam);
				if((list!=null)&&(!list.isEmpty())){
					resultMessage.addErr("生产设备栈位编码已存在");
					return resultMessage;
				}
					equipWorkStackParamVo.setTenantId(commonParam.getTenantId());
					equipWorkStack = equipWorkStackService.saveOrUpdate(equipWorkStackParamVo, commonParam);
					resultMessage.setIsSuccess(true);

			} else { // 修改
				EquipWorkStack equipWorkStackVoTemp = this.selectById(equipWorkStackParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(equipWorkStackVoTemp, equipWorkStackParamVo);

				equipWorkStack = equipWorkStackService.saveOrUpdate(equipWorkStackVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(equipWorkStack);
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
