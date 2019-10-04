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
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.struct.StructProductionlineVo;
import com.techsoft.entity.struct.StructProductionlineParamVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructProcessService;
import com.techsoft.service.struct.StructProductionlineService;
import com.techsoft.service.struct.StructWorkshopService;

@org.springframework.stereotype.Service
public class ClientStructProductionlineServiceImpl extends BaseClientServiceImpl<StructProductionline>
		implements ClientStructProductionlineService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProductionlineService structProductionlineService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopService structWorkshopService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessService structProcessService;
	

	@Override
	public BaseService<StructProductionline> getBaseService() {
		return structProductionlineService;
	}

	private StructProductionlineVo getVo(StructProductionline structProductionline, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructProductionlineVo vo = new StructProductionlineVo(structProductionline);
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}
		if (vo.getWorkshopId() != null && vo.getWorkshopId() > 0L) {
			StructWorkshop structWorkshop = structWorkshopService.selectById(vo.getWorkshopId(), commonParam);
			if (structWorkshop != null) {
				vo.setStructWorkshop(structWorkshop);
			}
		}
 
		
		return vo;
	}

	private StructProductionlineVo getExtendVo(StructProductionline structProductionline, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructProductionlineVo vo = this.getVo(structProductionline, commonParam);

		return vo;
	}

	private List<StructProductionlineVo> getVoList(List<StructProductionline> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructProductionlineVo> voList = new ArrayList<StructProductionlineVo>();
		for (StructProductionline entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<StructProductionlineVo> getExtendVoList(List<StructProductionline> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructProductionlineVo> voList = new ArrayList<StructProductionlineVo>();
		for (StructProductionline entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public StructProductionlineVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProductionline entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<StructProductionlineVo> selectListVoByParamVo(StructProductionlineParamVo structProductionline,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structProductionline == null) {
			structProductionline = new StructProductionlineParamVo();
		}
		structProductionline.setTenantId(commonParam.getTenantId());

		List<StructProductionline> list = (List<StructProductionline>) this.getBaseService()
				.selectListByParamVo(structProductionline, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructProductionlineVo> selectPageVoByParamVo(StructProductionlineParamVo structProductionline,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structProductionline == null) {
			structProductionline = new StructProductionlineParamVo();
		}
		structProductionline.setTenantId(commonParam.getTenantId());

		PageInfo<StructProductionline> list = (PageInfo<StructProductionline>) this.getBaseService()
				.selectPageByParamVo(structProductionline, commonParam, pageNo, pageSize);
		List<StructProductionlineVo> volist = new ArrayList<StructProductionlineVo>();

		Iterator<StructProductionline> iter = list.getList().iterator();
		StructProductionlineVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructProductionlineVo> vpage = new Page<StructProductionlineVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public StructProductionlineVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructProductionline entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<StructProductionlineVo> selectListExtendVoByParamVo(StructProductionlineParamVo structProductionline,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structProductionline == null) {
			structProductionline = new StructProductionlineParamVo();
		}
		structProductionline.setTenantId(commonParam.getTenantId());

		List<StructProductionline> list = (List<StructProductionline>) this.getBaseService()
				.selectListByParamVo(structProductionline, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructProductionlineVo> selectPageExtendVoByParamVo(
			StructProductionlineParamVo structProductionline, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException {
		if (structProductionline == null) {
			structProductionline = new StructProductionlineParamVo();
		}
		structProductionline.setTenantId(commonParam.getTenantId());

		PageInfo<StructProductionline> list = (PageInfo<StructProductionline>) this.getBaseService()
				.selectPageByParamVo(structProductionline, commonParam, pageNo, pageSize);
		List<StructProductionlineVo> volist = new ArrayList<StructProductionlineVo>();

		Iterator<StructProductionline> iter = list.getList().iterator();
		StructProductionlineVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructProductionlineVo> vpage = new Page<StructProductionlineVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(StructProductionlineParamVo structProductionlineParamVo,
			CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		StructProductionline structProductionline = null;
		if (structProductionlineParamVo.getProductionlineCode() == null) {
			resultMessage.addErr("产线编码不能为空");
			return resultMessage;
		}
		if (structProductionlineParamVo.getProductionlineName() == null) {
			resultMessage.addErr("产线名不能为空");
			return resultMessage;
		}
		if (structProductionlineParamVo.getFactoryId() == null) {
			resultMessage.addErr("请选择工厂名称");
			return resultMessage;
		}
		if (structProductionlineParamVo.getWorkshopId() == null) {
			resultMessage.addErr("请选择所属车间");
			return resultMessage;
		}
	 

		try {
			if (structProductionlineParamVo.getId() == null) {// 新增

				structProductionlineParamVo.setTenantId(commonParam.getTenantId());
				structProductionline = structProductionlineService.saveOrUpdate(structProductionlineParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				StructProductionline structProductionlineVoTemp = this.selectById(structProductionlineParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(structProductionlineVoTemp, structProductionlineParamVo);

				structProductionline = structProductionlineService.saveOrUpdate(structProductionlineVoTemp,
						commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(structProductionline);
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
