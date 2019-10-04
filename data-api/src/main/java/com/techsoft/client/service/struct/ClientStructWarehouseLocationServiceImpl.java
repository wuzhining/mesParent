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

import com.techsoft.entity.common.StructWarehouseLocation;
import com.techsoft.entity.struct.StructWarehouseLocationVo;
import com.techsoft.entity.struct.StructWarehouseLocationParamVo;
import com.techsoft.service.struct.StructWarehouseLocationService;

@org.springframework.stereotype.Service
public class ClientStructWarehouseLocationServiceImpl extends BaseClientServiceImpl<StructWarehouseLocation>
		implements ClientStructWarehouseLocationService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWarehouseLocationService structWarehouseLocationService;

	@Override
	public BaseService<StructWarehouseLocation> getBaseService() {
		return structWarehouseLocationService;
	}

	private StructWarehouseLocationVo getVo(StructWarehouseLocation structWarehouseLocation, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructWarehouseLocationVo vo = new StructWarehouseLocationVo(structWarehouseLocation);

		return vo;
	}

	private StructWarehouseLocationVo getExtendVo(StructWarehouseLocation structWarehouseLocation,
			CommonParam commonParam) throws BusinessException, SQLException {
		StructWarehouseLocationVo vo = this.getVo(structWarehouseLocation, commonParam);

		return vo;
	}

	private List<StructWarehouseLocationVo> getVoList(List<StructWarehouseLocation> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructWarehouseLocationVo> voList = new ArrayList<StructWarehouseLocationVo>();
		for (StructWarehouseLocation entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<StructWarehouseLocationVo> getExtendVoList(List<StructWarehouseLocation> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructWarehouseLocationVo> voList = new ArrayList<StructWarehouseLocationVo>();
		for (StructWarehouseLocation entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public StructWarehouseLocationVo getVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructWarehouseLocation entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<StructWarehouseLocationVo> selectListVoByParamVo(StructWarehouseLocationParamVo structWarehouseLocation,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structWarehouseLocation == null) {
			structWarehouseLocation = new StructWarehouseLocationParamVo();
		}
		structWarehouseLocation.setTenantId(commonParam.getTenantId());

		List<StructWarehouseLocation> list = (List<StructWarehouseLocation>) this.getBaseService()
				.selectListByParamVo(structWarehouseLocation, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructWarehouseLocationVo> selectPageVoByParamVo(
			StructWarehouseLocationParamVo structWarehouseLocation, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException {
		if (structWarehouseLocation == null) {
			structWarehouseLocation = new StructWarehouseLocationParamVo();
		}
		structWarehouseLocation.setTenantId(commonParam.getTenantId());

		PageInfo<StructWarehouseLocation> list = (PageInfo<StructWarehouseLocation>) this.getBaseService()
				.selectPageByParamVo(structWarehouseLocation, commonParam, pageNo, pageSize);
		List<StructWarehouseLocationVo> volist = new ArrayList<StructWarehouseLocationVo>();

		Iterator<StructWarehouseLocation> iter = list.getList().iterator();
		StructWarehouseLocationVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructWarehouseLocationVo> vpage = new Page<StructWarehouseLocationVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public StructWarehouseLocationVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructWarehouseLocation entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<StructWarehouseLocationVo> selectListExtendVoByParamVo(
			StructWarehouseLocationParamVo structWarehouseLocation, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (structWarehouseLocation == null) {
			structWarehouseLocation = new StructWarehouseLocationParamVo();
		}
		structWarehouseLocation.setTenantId(commonParam.getTenantId());

		List<StructWarehouseLocation> list = (List<StructWarehouseLocation>) this.getBaseService()
				.selectListByParamVo(structWarehouseLocation, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructWarehouseLocationVo> selectPageExtendVoByParamVo(
			StructWarehouseLocationParamVo structWarehouseLocation, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException {
		if (structWarehouseLocation == null) {
			structWarehouseLocation = new StructWarehouseLocationParamVo();
		}
		structWarehouseLocation.setTenantId(commonParam.getTenantId());

		PageInfo<StructWarehouseLocation> list = (PageInfo<StructWarehouseLocation>) this.getBaseService()
				.selectPageByParamVo(structWarehouseLocation, commonParam, pageNo, pageSize);
		List<StructWarehouseLocationVo> volist = new ArrayList<StructWarehouseLocationVo>();

		Iterator<StructWarehouseLocation> iter = list.getList().iterator();
		StructWarehouseLocationVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructWarehouseLocationVo> vpage = new Page<StructWarehouseLocationVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(StructWarehouseLocationParamVo structWarehouseLocationParamVo,
			CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		StructWarehouseLocation structWarehouseLocation = null;
		try {
			if (structWarehouseLocationParamVo.getId() == null) {// 新增

				structWarehouseLocationParamVo.setTenantId(commonParam.getTenantId());
				structWarehouseLocation = structWarehouseLocationService.saveOrUpdate(structWarehouseLocationParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				StructWarehouseLocation structWarehouseLocationVoTemp = this
						.selectById(structWarehouseLocationParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(structWarehouseLocationVoTemp, structWarehouseLocationParamVo);

				structWarehouseLocation = structWarehouseLocationService.saveOrUpdate(structWarehouseLocationVoTemp,
						commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(structWarehouseLocation);
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
