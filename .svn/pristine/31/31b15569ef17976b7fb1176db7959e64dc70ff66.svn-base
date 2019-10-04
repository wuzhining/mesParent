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
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.common.WarehouseStrategyUpshelf;
import com.techsoft.entity.warehouse.WarehouseStrategyUpshelfParamVo;
import com.techsoft.entity.warehouse.WarehouseStrategyUpshelfVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.product.ProductClassesService;
import com.techsoft.service.product.ProductMaterialService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructWarehouseService;
import com.techsoft.service.warehouse.WarehouseAreaService;
import com.techsoft.service.warehouse.WarehouseLocationService;
import com.techsoft.service.warehouse.WarehouseRackService;
import com.techsoft.service.warehouse.WarehouseStrategyUpshelfService;

@org.springframework.stereotype.Service
public class ClientWarehouseStrategyUpshelfServiceImpl extends BaseClientServiceImpl<WarehouseStrategyUpshelf>
		implements ClientWarehouseStrategyUpshelfService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseStrategyUpshelfService warehouseStrategyUpshelfService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWarehouseService StructWarehouseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductClassesService ProductClassesService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseRackService WarehouseRackService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService ProductMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseAreaService warehouseAreaService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseLocationService warehouseLocationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	

	@Override
	public BaseService<WarehouseStrategyUpshelf> getBaseService() {
		return warehouseStrategyUpshelfService;
	}

	private WarehouseStrategyUpshelfVo getVo(WarehouseStrategyUpshelf warehouseStrategyUpshelf, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseStrategyUpshelfVo vo = new WarehouseStrategyUpshelfVo(warehouseStrategyUpshelf);

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
		if (vo.getRackId() != null && vo.getRackId() > 0L) {
			WarehouseRack warehouseRack = WarehouseRackService.selectById(vo.getRackId(), commonParam);
			if (warehouseRack != null) {
				vo.setWarehouseRack(warehouseRack);
			}
		}

		if (vo.getAreaId() != null && vo.getAreaId() > 0L) {
			WarehouseArea warehouseArea = warehouseAreaService.selectById(vo.getAreaId(), commonParam);
			if (warehouseArea != null) {
				vo.setWarehouseArea(warehouseArea);
			}
		}
		
		if (vo.getLocationId() != null && vo.getLocationId() > 0L) {
			WarehouseLocation warehouseLocation = warehouseLocationService.selectById(vo.getLocationId(), commonParam);
			if (warehouseLocation != null) {
				vo.setWarehouseLocation(warehouseLocation);
			}
		}
		return vo;
	}

	private WarehouseStrategyUpshelfVo getExtendVo(WarehouseStrategyUpshelf warehouseStrategyUpshelf,
			CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseStrategyUpshelfVo vo = this.getVo(warehouseStrategyUpshelf, commonParam);

		return vo;
	}

	private List<WarehouseStrategyUpshelfVo> getVoList(List<WarehouseStrategyUpshelf> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehouseStrategyUpshelfVo> voList = new ArrayList<WarehouseStrategyUpshelfVo>();
		for (WarehouseStrategyUpshelf entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<WarehouseStrategyUpshelfVo> getExtendVoList(List<WarehouseStrategyUpshelf> list,
			CommonParam commonParam) throws BusinessException, SQLException {
		List<WarehouseStrategyUpshelfVo> voList = new ArrayList<WarehouseStrategyUpshelfVo>();
		for (WarehouseStrategyUpshelf entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public WarehouseStrategyUpshelfVo getVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseStrategyUpshelf entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<WarehouseStrategyUpshelfVo> selectListVoByParamVo(
			WarehouseStrategyUpshelfParamVo warehouseStrategyUpshelf, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (warehouseStrategyUpshelf == null) {
			warehouseStrategyUpshelf = new WarehouseStrategyUpshelfParamVo();
		}
		warehouseStrategyUpshelf.setTenantId(commonParam.getTenantId());

		List<WarehouseStrategyUpshelf> list = (List<WarehouseStrategyUpshelf>) this.getBaseService()
				.selectListByParamVo(warehouseStrategyUpshelf, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseStrategyUpshelfVo> selectPageVoByParamVo(
			WarehouseStrategyUpshelfParamVo warehouseStrategyUpshelf, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException {
		if (warehouseStrategyUpshelf == null) {
			warehouseStrategyUpshelf = new WarehouseStrategyUpshelfParamVo();
		}
		warehouseStrategyUpshelf.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseStrategyUpshelf> list = (PageInfo<WarehouseStrategyUpshelf>) this.getBaseService()
				.selectPageByParamVo(warehouseStrategyUpshelf, commonParam, pageNo, pageSize);
		List<WarehouseStrategyUpshelfVo> volist = new ArrayList<WarehouseStrategyUpshelfVo>();

		Iterator<WarehouseStrategyUpshelf> iter = list.getList().iterator();
		WarehouseStrategyUpshelfVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseStrategyUpshelfVo> vpage = new Page<WarehouseStrategyUpshelfVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public WarehouseStrategyUpshelfVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseStrategyUpshelf entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<WarehouseStrategyUpshelfVo> selectListExtendVoByParamVo(
			WarehouseStrategyUpshelfParamVo warehouseStrategyUpshelf, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (warehouseStrategyUpshelf == null) {
			warehouseStrategyUpshelf = new WarehouseStrategyUpshelfParamVo();
		}
		warehouseStrategyUpshelf.setTenantId(commonParam.getTenantId());

		List<WarehouseStrategyUpshelf> list = (List<WarehouseStrategyUpshelf>) this.getBaseService()
				.selectListByParamVo(warehouseStrategyUpshelf, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseStrategyUpshelfVo> selectPageExtendVoByParamVo(
			WarehouseStrategyUpshelfParamVo warehouseStrategyUpshelf, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException {
		if (warehouseStrategyUpshelf == null) {
			warehouseStrategyUpshelf = new WarehouseStrategyUpshelfParamVo();
		}
		warehouseStrategyUpshelf.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseStrategyUpshelf> list = (PageInfo<WarehouseStrategyUpshelf>) this.getBaseService()
				.selectPageByParamVo(warehouseStrategyUpshelf, commonParam, pageNo, pageSize);
		List<WarehouseStrategyUpshelfVo> volist = new ArrayList<WarehouseStrategyUpshelfVo>();

		Iterator<WarehouseStrategyUpshelf> iter = list.getList().iterator();
		WarehouseStrategyUpshelfVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseStrategyUpshelfVo> vpage = new Page<WarehouseStrategyUpshelfVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(WarehouseStrategyUpshelfParamVo warehouseStrategyUpshelfParamVo,
			CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		WarehouseStrategyUpshelf warehouseStrategyUpshelf = null;
		try {
			if (warehouseStrategyUpshelfParamVo.getId() == null) {// 新增

				//获取自动生成的上架策略编码
				String strategyCode = configCodeRuleService.createCode(WarehouseStrategyUpshelf.class.getName(),
						null, null, commonParam);
				warehouseStrategyUpshelfParamVo.setStrategyCode(strategyCode);
				
				warehouseStrategyUpshelfParamVo.setTenantId(commonParam.getTenantId());
				warehouseStrategyUpshelf = warehouseStrategyUpshelfService.saveOrUpdate(warehouseStrategyUpshelfParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				WarehouseStrategyUpshelf warehouseStrategyUpshelfVoTemp = this
						.selectById(warehouseStrategyUpshelfParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(warehouseStrategyUpshelfVoTemp, warehouseStrategyUpshelfParamVo);

				warehouseStrategyUpshelf = warehouseStrategyUpshelfService.saveOrUpdate(warehouseStrategyUpshelfVoTemp,
						commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(warehouseStrategyUpshelf);
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
