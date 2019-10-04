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
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcedure;
import com.techsoft.entity.struct.StructProcedureVo;
import com.techsoft.entity.struct.StructProcedureParamVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructProcedureService;

@org.springframework.stereotype.Service
public class ClientStructProcedureServiceImpl extends BaseClientServiceImpl<StructProcedure>
		implements ClientStructProcedureService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcedureService structProcedureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;

	@Override
	public BaseService<StructProcedure> getBaseService() {
		return structProcedureService;
	}

	private StructProcedureVo getVo(StructProcedure structProcedure, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructProcedureVo vo = new StructProcedureVo(structProcedure);
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}
		if (vo.getProcessDictId() != null && vo.getProcessDictId() > 0L) {
			ConfigDictionary processDictionary = configDictionaryService.selectById(vo.getProcessDictId(), commonParam);
			if (processDictionary != null) {
				vo.setProcessDictionary(processDictionary);
			}
		}
		if (vo.getWorkgroupDictId() != null && vo.getWorkgroupDictId() > 0L) {
			ConfigDictionary groupDictionary = configDictionaryService.selectById(vo.getWorkgroupDictId(), commonParam);
			if (groupDictionary != null) {
				vo.setGroupDictionary(groupDictionary);
			}
		}
		return vo;
	}

	private StructProcedureVo getExtendVo(StructProcedure structProcedure, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructProcedureVo vo = this.getVo(structProcedure, commonParam);

		return vo;
	}

	private List<StructProcedureVo> getVoList(List<StructProcedure> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructProcedureVo> voList = new ArrayList<StructProcedureVo>();
		for (StructProcedure entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<StructProcedureVo> getExtendVoList(List<StructProcedure> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructProcedureVo> voList = new ArrayList<StructProcedureVo>();
		for (StructProcedure entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public StructProcedureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedure entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<StructProcedureVo> selectListVoByParamVo(StructProcedureParamVo structProcedure,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structProcedure == null) {
			structProcedure = new StructProcedureParamVo();
		}
		structProcedure.setTenantId(commonParam.getTenantId());

		List<StructProcedure> list = (List<StructProcedure>) this.getBaseService().selectListByParamVo(structProcedure,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructProcedureVo> selectPageVoByParamVo(StructProcedureParamVo structProcedure,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structProcedure == null) {
			structProcedure = new StructProcedureParamVo();
		}
		structProcedure.setTenantId(commonParam.getTenantId());

		PageInfo<StructProcedure> list = (PageInfo<StructProcedure>) this.getBaseService()
				.selectPageByParamVo(structProcedure, commonParam, pageNo, pageSize);
		List<StructProcedureVo> volist = new ArrayList<StructProcedureVo>();

		Iterator<StructProcedure> iter = list.getList().iterator();
		StructProcedureVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructProcedureVo> vpage = new Page<StructProcedureVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public StructProcedureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedure entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<StructProcedureVo> selectListExtendVoByParamVo(StructProcedureParamVo structProcedure,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structProcedure == null) {
			structProcedure = new StructProcedureParamVo();
		}
		structProcedure.setTenantId(commonParam.getTenantId());

		List<StructProcedure> list = (List<StructProcedure>) this.getBaseService().selectListByParamVo(structProcedure,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructProcedureVo> selectPageExtendVoByParamVo(StructProcedureParamVo structProcedure,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structProcedure == null) {
			structProcedure = new StructProcedureParamVo();
		}
		structProcedure.setTenantId(commonParam.getTenantId());

		PageInfo<StructProcedure> list = (PageInfo<StructProcedure>) this.getBaseService()
				.selectPageByParamVo(structProcedure, commonParam, pageNo, pageSize);
		List<StructProcedureVo> volist = new ArrayList<StructProcedureVo>();

		Iterator<StructProcedure> iter = list.getList().iterator();
		StructProcedureVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructProcedureVo> vpage = new Page<StructProcedureVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(StructProcedureParamVo structProcedureParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		StructProcedure structProcedure = null;
		if (structProcedureParamVo.getProcedureCode() == null) {
			resultMessage.addErr("工序编码不能为空");
			return resultMessage;
		}
		if (structProcedureParamVo.getProcedureName() == null) {
			resultMessage.addErr("工序名不能为空");
			return resultMessage;
		}
		if (structProcedureParamVo.getFactoryId() == null) {
			resultMessage.addErr("请选择工厂名称");
			return resultMessage;
		}
		if (structProcedureParamVo.getWorkgroupDictId() == null) {
			resultMessage.addErr("请选择工作组");
			return resultMessage;
		}
		if (structProcedureParamVo.getProcessDictId() == null) {
			resultMessage.addErr("请选择制程");
			return resultMessage;
		}

		try {
			if (structProcedureParamVo.getId() == null) {// 新增

				structProcedureParamVo.setTenantId(commonParam.getTenantId());
				structProcedure = structProcedureService.saveOrUpdate(structProcedureParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				StructProcedure structProcedureVoTemp = this.selectById(structProcedureParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(structProcedureVoTemp, structProcedureParamVo);

				structProcedure = structProcedureService.saveOrUpdate(structProcedureVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(structProcedure);
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
