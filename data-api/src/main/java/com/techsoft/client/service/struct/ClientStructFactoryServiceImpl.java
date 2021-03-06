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
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructFactoryVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.struct.StructFactoryService;

@org.springframework.stereotype.Service
public class ClientStructFactoryServiceImpl extends BaseClientServiceImpl<StructFactory>
		implements ClientStructFactoryService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@Override
	public BaseService<StructFactory> getBaseService() {
		return structFactoryService;
	}

	private StructFactoryVo getVo(StructFactory structFactory, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructFactoryVo vo = new StructFactoryVo(structFactory);
		if (vo.getFactoryTypeDictId() != null && vo.getFactoryTypeDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getFactoryTypeDictId(),
					commonParam);
			if (configDictionary != null) {
				vo.setConfigDictionary(configDictionary);
			}
		}
		return vo;
	}

	private StructFactoryVo getExtendVo(StructFactory structFactory, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructFactoryVo vo = this.getVo(structFactory, commonParam);

		return vo;
	}

	private List<StructFactoryVo> getVoList(List<StructFactory> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructFactoryVo> voList = new ArrayList<StructFactoryVo>();
		for (StructFactory entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<StructFactoryVo> getExtendVoList(List<StructFactory> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructFactoryVo> voList = new ArrayList<StructFactoryVo>();
		for (StructFactory entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public StructFactoryVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructFactory entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<StructFactoryVo> selectListVoByParamVo(StructFactoryParamVo structFactory, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (structFactory == null) {
			structFactory = new StructFactoryParamVo();
		}
		structFactory.setTenantId(commonParam.getTenantId());

		List<StructFactory> list = (List<StructFactory>) this.getBaseService().selectListByParamVo(structFactory,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructFactoryVo> selectPageVoByParamVo(StructFactoryParamVo structFactory, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structFactory == null) {
			structFactory = new StructFactoryParamVo();
		}
		structFactory.setTenantId(commonParam.getTenantId());

		PageInfo<StructFactory> list = (PageInfo<StructFactory>) this.getBaseService()
				.selectPageByParamVo(structFactory, commonParam, pageNo, pageSize);
		List<StructFactoryVo> volist = new ArrayList<StructFactoryVo>();

		Iterator<StructFactory> iter = list.getList().iterator();
		StructFactoryVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructFactoryVo> vpage = new Page<StructFactoryVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public StructFactoryVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructFactory entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<StructFactoryVo> selectListExtendVoByParamVo(StructFactoryParamVo structFactory,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structFactory == null) {
			structFactory = new StructFactoryParamVo();
		}
		structFactory.setTenantId(commonParam.getTenantId());

		List<StructFactory> list = (List<StructFactory>) this.getBaseService().selectListByParamVo(structFactory,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructFactoryVo> selectPageExtendVoByParamVo(StructFactoryParamVo structFactory,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structFactory == null) {
			structFactory = new StructFactoryParamVo();
		}
		structFactory.setTenantId(commonParam.getTenantId());

		PageInfo<StructFactory> list = (PageInfo<StructFactory>) this.getBaseService()
				.selectPageByParamVo(structFactory, commonParam, pageNo, pageSize);
		List<StructFactoryVo> volist = new ArrayList<StructFactoryVo>();

		Iterator<StructFactory> iter = list.getList().iterator();
		StructFactoryVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructFactoryVo> vpage = new Page<StructFactoryVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(StructFactoryParamVo structFactoryParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		StructFactory structFactory = null;
		/*if (structFactoryParamVo.getFactoryCode() == null) {
			resultMessage.addErr("工厂编码不能为空");
			return resultMessage;
		}*/
		if (structFactoryParamVo.getFactoryName() == null) {
			resultMessage.addErr("工厂名称不能为空");
			return resultMessage;
		}
		if (structFactoryParamVo.getFactoryTypeDictId() == null) {
			resultMessage.addErr("请选择工厂类型");
			return resultMessage;
		}
		try {
			if (structFactoryParamVo.getId() == null) {// 新增
				//生成编码
				String code = structFactoryParamVo.getFactoryCode();
				if(StringUtils.isBlank(code)){
					code = configCodeRuleService.createCode(StructFactory.class.getName(), null, null, commonParam);
					structFactoryParamVo.setFactoryCode(code);
				}
				if(StringUtils.isBlank(code)){
					resultMessage.addErr("工厂编码不能为空");
					return resultMessage;
				}
				//检验编码是否已存在
				StructFactoryParamVo structFactorySearch = new StructFactoryParamVo();
				structFactorySearch.setFactoryCode(code);
				List<StructFactory> list = structFactoryService.selectListByParamVo(structFactorySearch, commonParam);
				if((list != null)&&(!list.isEmpty())){
					resultMessage.addErr("工厂编码已存在");
					return resultMessage;
				}
				structFactoryParamVo.setTenantId(commonParam.getTenantId());
				structFactory = structFactoryService.saveOrUpdate(structFactoryParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				StructFactory structFactoryVoTemp = this.selectById(structFactoryParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(structFactoryVoTemp, structFactoryParamVo);

				structFactory = structFactoryService.saveOrUpdate(structFactoryVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(structFactory);
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
