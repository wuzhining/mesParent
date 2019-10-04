package com.techsoft.client.service.struct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.struct.StructWorkshopAreaParamVo;
import com.techsoft.entity.struct.StructWorkshopAreaVo;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructWorkshopAreaService;
import com.techsoft.service.struct.StructWorkshopService;

@org.springframework.stereotype.Service
public class ClientStructWorkshopAreaServiceImpl extends BaseClientServiceImpl<StructWorkshopArea>
		implements ClientStructWorkshopAreaService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopAreaService structWorkshopAreaService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopService structWorkshopService;
	@Override
	public BaseService<StructWorkshopArea> getBaseService() {
		return structWorkshopAreaService;
	}

	private StructWorkshopAreaVo getVo(StructWorkshopArea structWorkshopArea, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructWorkshopAreaVo vo = new StructWorkshopAreaVo(structWorkshopArea);
		//工厂名称
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}
		//车间
		if (vo.getWorkshopId() != null && vo.getWorkshopId() > 0L) {
			StructWorkshop structWorkshop = structWorkshopService.selectById(vo.getWorkshopId(), commonParam);
			if (structWorkshop != null) {
				vo.setStructWorkshop(structWorkshop);
			}
		}
		return vo;
	}

	private StructWorkshopAreaVo getExtendVo(StructWorkshopArea structWorkshopArea, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructWorkshopAreaVo vo = this.getVo(structWorkshopArea, commonParam);

		return vo;
	}

	private List<StructWorkshopAreaVo> getVoList(List<StructWorkshopArea> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructWorkshopAreaVo> voList = new ArrayList<StructWorkshopAreaVo>();
		for (StructWorkshopArea entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<StructWorkshopAreaVo> getExtendVoList(List<StructWorkshopArea> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructWorkshopAreaVo> voList = new ArrayList<StructWorkshopAreaVo>();
		for (StructWorkshopArea entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public StructWorkshopAreaVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructWorkshopArea entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<StructWorkshopAreaVo> selectListVoByParamVo(StructWorkshopAreaParamVo structWorkshopArea,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structWorkshopArea == null) {
			structWorkshopArea = new StructWorkshopAreaParamVo();
		}
		structWorkshopArea.setTenantId(commonParam.getTenantId());

		List<StructWorkshopArea> list = (List<StructWorkshopArea>) this.getBaseService()
				.selectListByParamVo(structWorkshopArea, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructWorkshopAreaVo> selectPageVoByParamVo(StructWorkshopAreaParamVo structWorkshopArea,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structWorkshopArea == null) {
			structWorkshopArea = new StructWorkshopAreaParamVo();
		}
		structWorkshopArea.setTenantId(commonParam.getTenantId());

		PageInfo<StructWorkshopArea> list = (PageInfo<StructWorkshopArea>) this.getBaseService()
				.selectPageByParamVo(structWorkshopArea, commonParam, pageNo, pageSize);
		List<StructWorkshopAreaVo> volist = new ArrayList<StructWorkshopAreaVo>();

		Iterator<StructWorkshopArea> iter = list.getList().iterator();
		StructWorkshopAreaVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructWorkshopAreaVo> vpage = new Page<StructWorkshopAreaVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public StructWorkshopAreaVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructWorkshopArea entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<StructWorkshopAreaVo> selectListExtendVoByParamVo(StructWorkshopAreaParamVo structWorkshopArea,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structWorkshopArea == null) {
			structWorkshopArea = new StructWorkshopAreaParamVo();
		}
		structWorkshopArea.setTenantId(commonParam.getTenantId());

		List<StructWorkshopArea> list = (List<StructWorkshopArea>) this.getBaseService()
				.selectListByParamVo(structWorkshopArea, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructWorkshopAreaVo> selectPageExtendVoByParamVo(StructWorkshopAreaParamVo structWorkshopArea,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structWorkshopArea == null) {
			structWorkshopArea = new StructWorkshopAreaParamVo();
		}
		structWorkshopArea.setTenantId(commonParam.getTenantId());

		PageInfo<StructWorkshopArea> list = (PageInfo<StructWorkshopArea>) this.getBaseService()
				.selectPageByParamVo(structWorkshopArea, commonParam, pageNo, pageSize);
		List<StructWorkshopAreaVo> volist = new ArrayList<StructWorkshopAreaVo>();

		Iterator<StructWorkshopArea> iter = list.getList().iterator();
		StructWorkshopAreaVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructWorkshopAreaVo> vpage = new Page<StructWorkshopAreaVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(StructWorkshopAreaParamVo structWorkshopAreaParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		StructWorkshopArea structWorkshopArea = null;
		try {
			if (structWorkshopAreaParamVo.getId() == null) {// 新增

				structWorkshopAreaParamVo.setTenantId(commonParam.getTenantId());
				structWorkshopArea = structWorkshopAreaService.saveOrUpdate(structWorkshopAreaParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				StructWorkshopArea structWorkshopAreaVoTemp = this.selectById(structWorkshopAreaParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(structWorkshopAreaVoTemp, structWorkshopAreaParamVo);

				structWorkshopArea = structWorkshopAreaService.saveOrUpdate(structWorkshopAreaVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(structWorkshopArea);
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
