package com.techsoft.client.service.warehouse;

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
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.WarehouseStrategyDownshelf;
import com.techsoft.entity.common.WarehouseStrategyUpshelf;
import com.techsoft.entity.warehouse.WarehouseStrategyDownshelfParamVo;
import com.techsoft.entity.warehouse.WarehouseStrategyDownshelfVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructWarehouseService;
import com.techsoft.service.warehouse.WarehouseStrategyDownshelfService;

@org.springframework.stereotype.Service
public class ClientWarehouseStrategyDownshelfServiceImpl extends BaseClientServiceImpl<WarehouseStrategyDownshelf>
		implements ClientWarehouseStrategyDownshelfService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseStrategyDownshelfService warehouseStrategyDownshelfService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWarehouseService StructWarehouseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	

	@Override
	public BaseService<WarehouseStrategyDownshelf> getBaseService() {
		return warehouseStrategyDownshelfService;
	}

	private WarehouseStrategyDownshelfVo getVo(WarehouseStrategyDownshelf warehouseStrategyDownshelf,
			CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseStrategyDownshelfVo vo = new WarehouseStrategyDownshelfVo(warehouseStrategyDownshelf);
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}
		if (vo.getWarehouseId() != null && vo.getWarehouseId() > 0L) {
			StructWarehouse structWarehouse = StructWarehouseService.selectById(vo.getWarehouseId(), commonParam);
			if (structWarehouse != null) {
				vo.setStructWarehouse(structWarehouse);
			}
		}
		return vo;
	}

	private WarehouseStrategyDownshelfVo getExtendVo(WarehouseStrategyDownshelf warehouseStrategyDownshelf,
			CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseStrategyDownshelfVo vo = this.getVo(warehouseStrategyDownshelf, commonParam);

		return vo;
	}

	private List<WarehouseStrategyDownshelfVo> getVoList(List<WarehouseStrategyDownshelf> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehouseStrategyDownshelfVo> voList = new ArrayList<WarehouseStrategyDownshelfVo>();
		for (WarehouseStrategyDownshelf entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<WarehouseStrategyDownshelfVo> getExtendVoList(List<WarehouseStrategyDownshelf> list,
			CommonParam commonParam) throws BusinessException, SQLException {
		List<WarehouseStrategyDownshelfVo> voList = new ArrayList<WarehouseStrategyDownshelfVo>();
		for (WarehouseStrategyDownshelf entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public WarehouseStrategyDownshelfVo getVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseStrategyDownshelf entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<WarehouseStrategyDownshelfVo> selectListVoByParamVo(
			WarehouseStrategyDownshelfParamVo warehouseStrategyDownshelf, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (warehouseStrategyDownshelf == null) {
			warehouseStrategyDownshelf = new WarehouseStrategyDownshelfParamVo();
		}
		warehouseStrategyDownshelf.setTenantId(commonParam.getTenantId());

		List<WarehouseStrategyDownshelf> list = (List<WarehouseStrategyDownshelf>) this.getBaseService()
				.selectListByParamVo(warehouseStrategyDownshelf, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseStrategyDownshelfVo> selectPageVoByParamVo(
			WarehouseStrategyDownshelfParamVo warehouseStrategyDownshelf, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException {
		if (warehouseStrategyDownshelf == null) {
			warehouseStrategyDownshelf = new WarehouseStrategyDownshelfParamVo();
		}
		warehouseStrategyDownshelf.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseStrategyDownshelf> list = (PageInfo<WarehouseStrategyDownshelf>) this.getBaseService()
				.selectPageByParamVo(warehouseStrategyDownshelf, commonParam, pageNo, pageSize);
		List<WarehouseStrategyDownshelfVo> volist = new ArrayList<WarehouseStrategyDownshelfVo>();

		Iterator<WarehouseStrategyDownshelf> iter = list.getList().iterator();
		WarehouseStrategyDownshelfVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseStrategyDownshelfVo> vpage = new Page<WarehouseStrategyDownshelfVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public WarehouseStrategyDownshelfVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseStrategyDownshelf entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<WarehouseStrategyDownshelfVo> selectListExtendVoByParamVo(
			WarehouseStrategyDownshelfParamVo warehouseStrategyDownshelf, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (warehouseStrategyDownshelf == null) {
			warehouseStrategyDownshelf = new WarehouseStrategyDownshelfParamVo();
		}
		warehouseStrategyDownshelf.setTenantId(commonParam.getTenantId());

		List<WarehouseStrategyDownshelf> list = (List<WarehouseStrategyDownshelf>) this.getBaseService()
				.selectListByParamVo(warehouseStrategyDownshelf, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseStrategyDownshelfVo> selectPageExtendVoByParamVo(
			WarehouseStrategyDownshelfParamVo warehouseStrategyDownshelf, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException {
		if (warehouseStrategyDownshelf == null) {
			warehouseStrategyDownshelf = new WarehouseStrategyDownshelfParamVo();
		}
		warehouseStrategyDownshelf.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseStrategyDownshelf> list = (PageInfo<WarehouseStrategyDownshelf>) this.getBaseService()
				.selectPageByParamVo(warehouseStrategyDownshelf, commonParam, pageNo, pageSize);
		List<WarehouseStrategyDownshelfVo> volist = new ArrayList<WarehouseStrategyDownshelfVo>();

		Iterator<WarehouseStrategyDownshelf> iter = list.getList().iterator();
		WarehouseStrategyDownshelfVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseStrategyDownshelfVo> vpage = new Page<WarehouseStrategyDownshelfVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(WarehouseStrategyDownshelfParamVo warehouseStrategyDownshelfParamVo,
			CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		WarehouseStrategyDownshelf warehouseStrategyDownshelf = null;
		try {
			if (warehouseStrategyDownshelfParamVo.getId() == null) {// 新增
				//获取自动生成的下架策略编码
				String strategyCode = configCodeRuleService.createCode(WarehouseStrategyDownshelf.class.getName(),
						null, null, commonParam);
				warehouseStrategyDownshelfParamVo.setStrategyCode(strategyCode);
				warehouseStrategyDownshelfParamVo.setTenantId(commonParam.getTenantId());
				warehouseStrategyDownshelf = warehouseStrategyDownshelfService
						.saveOrUpdate(warehouseStrategyDownshelfParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改,
				WarehouseStrategyDownshelf warehouseStrategyDownshelfVoTemp = this
						.selectById(warehouseStrategyDownshelfParamVo.getId(), commonParam);
				
				BeanUtil.copyNotNullProperties(warehouseStrategyDownshelfVoTemp, warehouseStrategyDownshelfParamVo);
				warehouseStrategyDownshelf = warehouseStrategyDownshelfService
						.saveOrUpdate(warehouseStrategyDownshelfVoTemp, commonParam);
				
				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(warehouseStrategyDownshelf);
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
