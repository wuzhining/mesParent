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
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.common.WarehouseStrategyDownshelfItem;
import com.techsoft.entity.warehouse.WarehouseStrategyDownshelfItemParamVo;
import com.techsoft.entity.warehouse.WarehouseStrategyDownshelfItemVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.warehouse.WarehouseAreaService;
import com.techsoft.service.warehouse.WarehouseLocationService;
import com.techsoft.service.warehouse.WarehouseRackService;
import com.techsoft.service.warehouse.WarehouseStrategyDownshelfItemService;

@org.springframework.stereotype.Service
public class ClientWarehouseStrategyDownshelfItemServiceImpl extends
		BaseClientServiceImpl<WarehouseStrategyDownshelfItem> implements ClientWarehouseStrategyDownshelfItemService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseStrategyDownshelfItemService warehouseStrategyDownshelfItemService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseAreaService warehouseAreaService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseLocationService warehouseLocationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseRackService warehouseRackService;

	@Override
	public BaseService<WarehouseStrategyDownshelfItem> getBaseService() {
		return warehouseStrategyDownshelfItemService;
	}

	private WarehouseStrategyDownshelfItemVo getVo(WarehouseStrategyDownshelfItem warehouseStrategyDownshelfItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseStrategyDownshelfItemVo vo = new WarehouseStrategyDownshelfItemVo(warehouseStrategyDownshelfItem);
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
		if (vo.getRackId() != null && vo.getRackId() > 0L) {
			WarehouseRack warehouseRack = warehouseRackService.selectById(vo.getRackId(), commonParam);
			if (warehouseRack != null) {
				vo.setWarehouseRack(warehouseRack);
			}
		}
		if (vo.getModeMatchingDictId() != null && vo.getModeMatchingDictId() > 0L) {
			ConfigDictionary modeMatchingDic = configDictionaryService.selectById(vo.getModeMatchingDictId(),
					commonParam);
			if (modeMatchingDic != null) {
				vo.setModeMatchingDict(modeMatchingDic);
			}
		}
		if (vo.getAdcdesOrderDictId() != null && vo.getAdcdesOrderDictId() > 0L) {
			ConfigDictionary adcdesOrderDic = configDictionaryService.selectById(vo.getAdcdesOrderDictId(),
					commonParam);
			if (adcdesOrderDic != null) {
				vo.setAdcdesOrderDict(adcdesOrderDic);
			}
		}
		if (vo.getAttributeDictId() != null && vo.getAttributeDictId() > 0L) {
			ConfigDictionary attributeDic = configDictionaryService.selectById(vo.getAttributeDictId(), commonParam);
			if (attributeDic != null) {
				vo.setAttributeDict(attributeDic);
			}
		}
		return vo;
	}

	private WarehouseStrategyDownshelfItemVo getExtendVo(WarehouseStrategyDownshelfItem warehouseStrategyDownshelfItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseStrategyDownshelfItemVo vo = this.getVo(warehouseStrategyDownshelfItem, commonParam);

		return vo;
	}

	private List<WarehouseStrategyDownshelfItemVo> getVoList(List<WarehouseStrategyDownshelfItem> list,
			CommonParam commonParam) throws BusinessException, SQLException {
		List<WarehouseStrategyDownshelfItemVo> voList = new ArrayList<WarehouseStrategyDownshelfItemVo>();
		for (WarehouseStrategyDownshelfItem entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<WarehouseStrategyDownshelfItemVo> getExtendVoList(List<WarehouseStrategyDownshelfItem> list,
			CommonParam commonParam) throws BusinessException, SQLException {
		List<WarehouseStrategyDownshelfItemVo> voList = new ArrayList<WarehouseStrategyDownshelfItemVo>();
		for (WarehouseStrategyDownshelfItem entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public WarehouseStrategyDownshelfItemVo getVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseStrategyDownshelfItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<WarehouseStrategyDownshelfItemVo> selectListVoByParamVo(
			WarehouseStrategyDownshelfItemParamVo warehouseStrategyDownshelfItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (warehouseStrategyDownshelfItem == null) {
			warehouseStrategyDownshelfItem = new WarehouseStrategyDownshelfItemParamVo();
		}
		warehouseStrategyDownshelfItem.setTenantId(commonParam.getTenantId());

		List<WarehouseStrategyDownshelfItem> list = (List<WarehouseStrategyDownshelfItem>) this.getBaseService()
				.selectListByParamVo(warehouseStrategyDownshelfItem, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseStrategyDownshelfItemVo> selectPageVoByParamVo(
			WarehouseStrategyDownshelfItemParamVo warehouseStrategyDownshelfItem, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException {
		if (warehouseStrategyDownshelfItem == null) {
			warehouseStrategyDownshelfItem = new WarehouseStrategyDownshelfItemParamVo();
		}
		warehouseStrategyDownshelfItem.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseStrategyDownshelfItem> list = (PageInfo<WarehouseStrategyDownshelfItem>) this.getBaseService()
				.selectPageByParamVo(warehouseStrategyDownshelfItem, commonParam, pageNo, pageSize);
		List<WarehouseStrategyDownshelfItemVo> volist = new ArrayList<WarehouseStrategyDownshelfItemVo>();

		Iterator<WarehouseStrategyDownshelfItem> iter = list.getList().iterator();
		WarehouseStrategyDownshelfItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseStrategyDownshelfItemVo> vpage = new Page<WarehouseStrategyDownshelfItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public WarehouseStrategyDownshelfItemVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseStrategyDownshelfItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<WarehouseStrategyDownshelfItemVo> selectListExtendVoByParamVo(
			WarehouseStrategyDownshelfItemParamVo warehouseStrategyDownshelfItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (warehouseStrategyDownshelfItem == null) {
			warehouseStrategyDownshelfItem = new WarehouseStrategyDownshelfItemParamVo();
		}
		warehouseStrategyDownshelfItem.setTenantId(commonParam.getTenantId());

		List<WarehouseStrategyDownshelfItem> list = (List<WarehouseStrategyDownshelfItem>) this.getBaseService()
				.selectListByParamVo(warehouseStrategyDownshelfItem, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseStrategyDownshelfItemVo> selectPageExtendVoByParamVo(
			WarehouseStrategyDownshelfItemParamVo warehouseStrategyDownshelfItem, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException {
		if (warehouseStrategyDownshelfItem == null) {
			warehouseStrategyDownshelfItem = new WarehouseStrategyDownshelfItemParamVo();
		}
		warehouseStrategyDownshelfItem.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseStrategyDownshelfItem> list = (PageInfo<WarehouseStrategyDownshelfItem>) this.getBaseService()
				.selectPageByParamVo(warehouseStrategyDownshelfItem, commonParam, pageNo, pageSize);
		List<WarehouseStrategyDownshelfItemVo> volist = new ArrayList<WarehouseStrategyDownshelfItemVo>();

		Iterator<WarehouseStrategyDownshelfItem> iter = list.getList().iterator();
		WarehouseStrategyDownshelfItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseStrategyDownshelfItemVo> vpage = new Page<WarehouseStrategyDownshelfItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(WarehouseStrategyDownshelfItemParamVo warehouseStrategyDownshelfItemVo,
			CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		WarehouseStrategyDownshelfItem warehouseStrategyDownshelfItem = null;
		try {
			if (warehouseStrategyDownshelfItemVo.getId() == null) {// 新增

				warehouseStrategyDownshelfItemVo.setTenantId(commonParam.getTenantId());
				warehouseStrategyDownshelfItem = warehouseStrategyDownshelfItemService
						.saveOrUpdate(warehouseStrategyDownshelfItemVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				WarehouseStrategyDownshelfItem warehouseStrategyDownshelfItemVoTemp = this
						.selectById(warehouseStrategyDownshelfItemVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(warehouseStrategyDownshelfItemVoTemp, warehouseStrategyDownshelfItemVo);

				warehouseStrategyDownshelfItem = warehouseStrategyDownshelfItemService
						.saveOrUpdate(warehouseStrategyDownshelfItemVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(warehouseStrategyDownshelfItem);
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
