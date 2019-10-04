package com.techsoft.client.service.struct;

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
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.struct.StructProcessVo;
import com.techsoft.entity.struct.StructProcessParamVo;
import com.techsoft.service.config.ConfigCodeRuleItemService;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructProcessService;

@org.springframework.stereotype.Service
public class ClientStructProcessServiceImpl extends BaseClientServiceImpl<StructProcess>
		implements ClientStructProcessService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessService structProcessService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;

	@Override
	public BaseService<StructProcess> getBaseService() {
		return structProcessService;
	}

	private StructProcessVo getVo(StructProcess structProcess, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructProcessVo vo = new StructProcessVo(structProcess);

		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}

		return vo;
	}

	private StructProcessVo getExtendVo(StructProcess structProcess, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructProcessVo vo = this.getVo(structProcess, commonParam);

		return vo;
	}

	private List<StructProcessVo> getVoList(List<StructProcess> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructProcessVo> voList = new ArrayList<StructProcessVo>();
		for (StructProcess entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<StructProcessVo> getExtendVoList(List<StructProcess> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructProcessVo> voList = new ArrayList<StructProcessVo>();
		for (StructProcess entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public StructProcessVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcess entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<StructProcessVo> selectListVoByParamVo(StructProcessParamVo structProcess, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (structProcess == null) {
			structProcess = new StructProcessParamVo();
		}
		structProcess.setTenantId(commonParam.getTenantId());

		List<StructProcess> list = (List<StructProcess>) this.getBaseService().selectListByParamVo(structProcess,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructProcessVo> selectPageVoByParamVo(StructProcessParamVo structProcess, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structProcess == null) {
			structProcess = new StructProcessParamVo();
		}
		structProcess.setTenantId(commonParam.getTenantId());

		PageInfo<StructProcess> list = (PageInfo<StructProcess>) this.getBaseService()
				.selectPageByParamVo(structProcess, commonParam, pageNo, pageSize);
		List<StructProcessVo> volist = new ArrayList<StructProcessVo>();

		Iterator<StructProcess> iter = list.getList().iterator();
		StructProcessVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructProcessVo> vpage = new Page<StructProcessVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public StructProcessVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcess entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<StructProcessVo> selectListExtendVoByParamVo(StructProcessParamVo structProcess,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structProcess == null) {
			structProcess = new StructProcessParamVo();
		}
		structProcess.setTenantId(commonParam.getTenantId());

		List<StructProcess> list = (List<StructProcess>) this.getBaseService().selectListByParamVo(structProcess,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructProcessVo> selectPageExtendVoByParamVo(StructProcessParamVo structProcess,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structProcess == null) {
			structProcess = new StructProcessParamVo();
		}
		structProcess.setTenantId(commonParam.getTenantId());

		PageInfo<StructProcess> list = (PageInfo<StructProcess>) this.getBaseService()
				.selectPageByParamVo(structProcess, commonParam, pageNo, pageSize);
		List<StructProcessVo> volist = new ArrayList<StructProcessVo>();

		Iterator<StructProcess> iter = list.getList().iterator();
		StructProcessVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructProcessVo> vpage = new Page<StructProcessVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(StructProcessParamVo structProcessParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		StructProcess structProcess = null;
		try {
			if (structProcessParamVo.getId() == null) {// 新增
				//生成编码
				String code = structProcessParamVo.getProcessCode();
				if(StringUtils.isBlank(code)){
					code = configCodeRuleService.createCode(StructProcess.class.getName(), null, null, commonParam);
					structProcessParamVo.setProcessCode(code);
				}
				if(StringUtils.isBlank(code)){
					resultMessage.addErr("工艺流程编码不能为空");
					return resultMessage;
				}
				//检验编码是否已存在
				StructProcessParamVo structProcessSearch = new StructProcessParamVo();
				structProcessSearch.setProcessCode(code);
				List<StructProcess> list = structProcessService.selectListByParamVo(structProcessSearch, commonParam);
				if((list!=null)&&(!list.isEmpty())){
					resultMessage.addErr("工艺流程编码已存在");
					return resultMessage;
				}
				structProcessParamVo.setTenantId(commonParam.getTenantId());
				structProcess = structProcessService.saveOrUpdate(structProcessParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				StructProcess structProcessVoTemp = this.selectById(structProcessParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(structProcessVoTemp, structProcessParamVo);

				structProcess = structProcessService.saveOrUpdate(structProcessVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(structProcess);
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
