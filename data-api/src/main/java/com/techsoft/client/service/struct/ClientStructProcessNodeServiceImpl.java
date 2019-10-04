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
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.struct.StructProcessNodeVo;
import com.techsoft.entity.struct.StructProcessNodeParamVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructProcessNodeService;
import com.techsoft.service.struct.StructProcessService;

@org.springframework.stereotype.Service
public class ClientStructProcessNodeServiceImpl extends BaseClientServiceImpl<StructProcessNode>
		implements ClientStructProcessNodeService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessNodeService structProcessNodeService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessService structProcessService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;

	@Override
	public BaseService<StructProcessNode> getBaseService() {
		return structProcessNodeService;
	}

	private StructProcessNodeVo getVo(StructProcessNode structProcessNode, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructProcessNodeVo vo = new StructProcessNodeVo(structProcessNode);

		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}
		if (vo.getExecutiveTypeDictId() != null && vo.getExecutiveTypeDictId() > 0L) {
			ConfigDictionary productType = configDictionaryService.selectById(vo.getExecutiveTypeDictId(), commonParam);
			if (productType != null) {
				vo.setExecutiveTypeDictionary(productType);
			}
		}
		
		if (vo.getProcessId() != null && vo.getProcessId() > 0L) {
			StructProcess structProcess = structProcessService.selectById(vo.getProcessId(), commonParam);
			if (structProcess != null) {
				vo.setStructProcess(structProcess);
			}
		}
		
		return vo;
	}

	private StructProcessNodeVo getExtendVo(StructProcessNode structProcessNode, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructProcessNodeVo vo = this.getVo(structProcessNode, commonParam);

		return vo;
	}

	private List<StructProcessNodeVo> getVoList(List<StructProcessNode> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructProcessNodeVo> voList = new ArrayList<StructProcessNodeVo>();
		for (StructProcessNode entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<StructProcessNodeVo> getExtendVoList(List<StructProcessNode> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructProcessNodeVo> voList = new ArrayList<StructProcessNodeVo>();
		for (StructProcessNode entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public StructProcessNodeVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcessNode entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<StructProcessNodeVo> selectListVoByParamVo(StructProcessNodeParamVo structProcessNode,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structProcessNode == null) {
			structProcessNode = new StructProcessNodeParamVo();
		}
		structProcessNode.setTenantId(commonParam.getTenantId());

		List<StructProcessNode> list = (List<StructProcessNode>) this.getBaseService()
				.selectListByParamVo(structProcessNode, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructProcessNodeVo> selectPageVoByParamVo(StructProcessNodeParamVo structProcessNode,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structProcessNode == null) {
			structProcessNode = new StructProcessNodeParamVo();
		}
		structProcessNode.setTenantId(commonParam.getTenantId());

		PageInfo<StructProcessNode> list = (PageInfo<StructProcessNode>) this.getBaseService()
				.selectPageByParamVo(structProcessNode, commonParam, pageNo, pageSize);
		List<StructProcessNodeVo> volist = new ArrayList<StructProcessNodeVo>();

		Iterator<StructProcessNode> iter = list.getList().iterator();
		StructProcessNodeVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructProcessNodeVo> vpage = new Page<StructProcessNodeVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public StructProcessNodeVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructProcessNode entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<StructProcessNodeVo> selectListExtendVoByParamVo(StructProcessNodeParamVo structProcessNode,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structProcessNode == null) {
			structProcessNode = new StructProcessNodeParamVo();
		}
		structProcessNode.setTenantId(commonParam.getTenantId());

		List<StructProcessNode> list = (List<StructProcessNode>) this.getBaseService()
				.selectListByParamVo(structProcessNode, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructProcessNodeVo> selectPageExtendVoByParamVo(StructProcessNodeParamVo structProcessNode,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structProcessNode == null) {
			structProcessNode = new StructProcessNodeParamVo();
		}
		structProcessNode.setTenantId(commonParam.getTenantId());

		PageInfo<StructProcessNode> list = (PageInfo<StructProcessNode>) this.getBaseService()
				.selectPageByParamVo(structProcessNode, commonParam, pageNo, pageSize);
		List<StructProcessNodeVo> volist = new ArrayList<StructProcessNodeVo>();

		Iterator<StructProcessNode> iter = list.getList().iterator();
		StructProcessNodeVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructProcessNodeVo> vpage = new Page<StructProcessNodeVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(StructProcessNodeParamVo structProcessNodeParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		StructProcessNode structProcessNode = null;
		try {
			if (structProcessNodeParamVo.getId() == null) {// 新增
				
				//生成编码
				String code = structProcessNodeParamVo.getNodeCode();
				if(StringUtils.isBlank(code)){
					code = configCodeRuleService.createCode(StructProcessNode.class.getName(), null, null, commonParam);
					structProcessNodeParamVo.setNodeCode(code);
				}
				if(StringUtils.isBlank(code)){
					resultMessage.addErr("工序流程节点编码不能为空");
					return resultMessage;
				}
				//检验编码是否已存在
				StructProcessNodeParamVo structProcessNodeSerach = new StructProcessNodeParamVo();
				structProcessNodeSerach.setNodeCode(code);
				List<StructProcessNode> list = structProcessNodeService.selectListByParamVo(structProcessNodeSerach, commonParam);
				if((list!=null)&&(!list.isEmpty())){
					resultMessage.addErr("工序编码已存在");
					return resultMessage;
				}
				structProcessNodeParamVo.setTenantId(commonParam.getTenantId());
				structProcessNode = structProcessNodeService.saveOrUpdate(structProcessNodeParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				StructProcessNode structProcessNodeVoTemp = this.selectById(structProcessNodeParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(structProcessNodeVoTemp, structProcessNodeParamVo);

				structProcessNode = structProcessNodeService.saveOrUpdate(structProcessNodeVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(structProcessNode);
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
