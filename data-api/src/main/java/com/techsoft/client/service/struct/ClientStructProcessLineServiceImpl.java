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
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProcessLine;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.struct.StructProcessLineVo;
import com.techsoft.entity.struct.StructProcessVo;
import com.techsoft.entity.struct.StructProcessLineParamVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructProcessLineService;
import com.techsoft.service.struct.StructProcessNodeService;
import com.techsoft.service.struct.StructProcessService;

@org.springframework.stereotype.Service
public class ClientStructProcessLineServiceImpl extends BaseClientServiceImpl<StructProcessLine>
		implements ClientStructProcessLineService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessLineService structProcessLineService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessService structProcessService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessNodeService structProcessNodeService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;

	@Override
	public BaseService<StructProcessLine> getBaseService() {
		return structProcessLineService;
	}

	private StructProcessLineVo getVo(StructProcessLine structProcessLine, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructProcessLineVo vo = new StructProcessLineVo(structProcessLine);

		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}
		if (vo.getProcessId() != null && vo.getProcessId() > 0L) {
			StructProcess structProcess = structProcessService.selectById(vo.getProcessId(), commonParam);
			if (structProcess != null) {
				vo.setStructProcess(structProcess);
			}
		}
		if (vo.getLineTypeDictId() != null && vo.getLineTypeDictId() > 0L) {
			ConfigDictionary lineType = configDictionaryService.selectById(vo.getLineTypeDictId(), commonParam);
			if (lineType != null) {
				vo.setProcessDictionary(lineType);
			}
		}

		if (vo.getPrevNodeId() != null && vo.getPrevNodeId() > 0L) {
			StructProcessNode processNodePrev = structProcessNodeService.selectById(vo.getPrevNodeId(), commonParam);
			if (processNodePrev != null) {
				vo.setStructProcessNodePrev(processNodePrev);
			}
		}

		if (vo.getNextNodeId() != null && vo.getNextNodeId() > 0L) {
			StructProcessNode processNodeNext = structProcessNodeService.selectById(vo.getNextNodeId(), commonParam);
			if (processNodeNext != null) {
				vo.setStructProcessNodeNext(processNodeNext);
			}
		}

		return vo;
	}

	private StructProcessLineVo getExtendVo(StructProcessLine structProcessLine, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructProcessLineVo vo = this.getVo(structProcessLine, commonParam);

		return vo;
	}

	private List<StructProcessLineVo> getVoList(List<StructProcessLine> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructProcessLineVo> voList = new ArrayList<StructProcessLineVo>();
		for (StructProcessLine entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<StructProcessLineVo> getExtendVoList(List<StructProcessLine> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructProcessLineVo> voList = new ArrayList<StructProcessLineVo>();
		for (StructProcessLine entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public StructProcessLineVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcessLine entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<StructProcessLineVo> selectListVoByParamVo(StructProcessLineParamVo structProcessLine,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structProcessLine == null) {
			structProcessLine = new StructProcessLineParamVo();
		}
		structProcessLine.setTenantId(commonParam.getTenantId());

		List<StructProcessLine> list = (List<StructProcessLine>) this.getBaseService()
				.selectListByParamVo(structProcessLine, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructProcessLineVo> selectPageVoByParamVo(StructProcessLineParamVo structProcessLine,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structProcessLine == null) {
			structProcessLine = new StructProcessLineParamVo();
		}
		structProcessLine.setTenantId(commonParam.getTenantId());

		PageInfo<StructProcessLine> list = (PageInfo<StructProcessLine>) this.getBaseService()
				.selectPageByParamVo(structProcessLine, commonParam, pageNo, pageSize);
		List<StructProcessLineVo> volist = new ArrayList<StructProcessLineVo>();

		Iterator<StructProcessLine> iter = list.getList().iterator();
		StructProcessLineVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructProcessLineVo> vpage = new Page<StructProcessLineVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public StructProcessLineVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructProcessLine entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<StructProcessLineVo> selectListExtendVoByParamVo(StructProcessLineParamVo structProcessLine,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structProcessLine == null) {
			structProcessLine = new StructProcessLineParamVo();
		}
		structProcessLine.setTenantId(commonParam.getTenantId());

		List<StructProcessLine> list = (List<StructProcessLine>) this.getBaseService()
				.selectListByParamVo(structProcessLine, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructProcessLineVo> selectPageExtendVoByParamVo(StructProcessLineParamVo structProcessLine,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structProcessLine == null) {
			structProcessLine = new StructProcessLineParamVo();
		}
		structProcessLine.setTenantId(commonParam.getTenantId());

		PageInfo<StructProcessLine> list = (PageInfo<StructProcessLine>) this.getBaseService()
				.selectPageByParamVo(structProcessLine, commonParam, pageNo, pageSize);
		List<StructProcessLineVo> volist = new ArrayList<StructProcessLineVo>();

		Iterator<StructProcessLine> iter = list.getList().iterator();
		StructProcessLineVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructProcessLineVo> vpage = new Page<StructProcessLineVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(StructProcessLineParamVo structProcessLineParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		StructProcessLine structProcessLine = null;
		try {
			if (structProcessLineParamVo.getId() == null) {// 新增

				structProcessLineParamVo.setTenantId(commonParam.getTenantId());
				structProcessLine = structProcessLineService.saveOrUpdate(structProcessLineParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				StructProcessLine structProcessLineVoTemp = this.selectById(structProcessLineParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(structProcessLineVoTemp, structProcessLineParamVo);

				structProcessLine = structProcessLineService.saveOrUpdate(structProcessLineVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(structProcessLine);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}

	@Override
	public ResultMessage saveBatchListInsert(List<ConfigDictionary> listDictionary, StructProcessVo entity,
			String[] data, List<StructProcessLineVo> processLineList,CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			structProcessLineService.insertEntityAndItem(listDictionary, entity, data, processLineList,commonParam);
			resultMessage.setIsSuccess(true);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
}
