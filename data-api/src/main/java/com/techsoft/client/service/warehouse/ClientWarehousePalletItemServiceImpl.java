package com.techsoft.client.service.warehouse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.WarehousePallet;
import com.techsoft.entity.common.WarehousePalletItem;
import com.techsoft.entity.warehouse.WarehousePalletItemVo;
import com.techsoft.entity.warehouse.WarehousePalletItemParamVo;
import com.techsoft.service.warehouse.WarehousePalletService;
import com.techsoft.service.warehouse.WarehousePalletItemService;

@org.springframework.stereotype.Service
public class ClientWarehousePalletItemServiceImpl extends BaseClientServiceImpl<WarehousePalletItem>
		implements ClientWarehousePalletItemService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehousePalletItemService warehousePalletItemService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehousePalletService warehousePalletService;

	@Override
	public BaseService<WarehousePalletItem> getBaseService() {
		return warehousePalletItemService;
	}

	private WarehousePalletItemVo getVo(WarehousePalletItem warehousePalletItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehousePalletItemVo vo = new WarehousePalletItemVo(warehousePalletItem);
		if (vo.getPalletId() != null && vo.getPalletId() > 0L) {
			WarehousePallet warehousePallet = warehousePalletService.selectById(vo.getPalletId(), commonParam);
			if (warehousePallet != null) {
				vo.setWarehousePallet(warehousePallet);
			}
		}
		return vo;
	}

	private WarehousePalletItemVo getExtendVo(WarehousePalletItem warehousePalletItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehousePalletItemVo vo = this.getVo(warehousePalletItem, commonParam);

		return vo;
	}

	private List<WarehousePalletItemVo> getVoList(List<WarehousePalletItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehousePalletItemVo> voList = new ArrayList<WarehousePalletItemVo>();
		for (WarehousePalletItem entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<WarehousePalletItemVo> getExtendVoList(List<WarehousePalletItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehousePalletItemVo> voList = new ArrayList<WarehousePalletItemVo>();
		for (WarehousePalletItem entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public WarehousePalletItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WarehousePalletItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<WarehousePalletItemVo> selectListVoByParamVo(WarehousePalletItemParamVo warehousePalletItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (warehousePalletItem == null) {
			warehousePalletItem = new WarehousePalletItemParamVo();
		}
		warehousePalletItem.setTenantId(commonParam.getTenantId());

		List<WarehousePalletItem> list = (List<WarehousePalletItem>) this.getBaseService()
				.selectListByParamVo(warehousePalletItem, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehousePalletItemVo> selectPageVoByParamVo(WarehousePalletItemParamVo warehousePalletItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (warehousePalletItem == null) {
			warehousePalletItem = new WarehousePalletItemParamVo();
		}
		warehousePalletItem.setTenantId(commonParam.getTenantId());

		PageInfo<WarehousePalletItem> list = (PageInfo<WarehousePalletItem>) this.getBaseService()
				.selectPageByParamVo(warehousePalletItem, commonParam, pageNo, pageSize);
		List<WarehousePalletItemVo> volist = new ArrayList<WarehousePalletItemVo>();

		Iterator<WarehousePalletItem> iter = list.getList().iterator();
		WarehousePalletItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehousePalletItemVo> vpage = new Page<WarehousePalletItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public WarehousePalletItemVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehousePalletItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<WarehousePalletItemVo> selectListExtendVoByParamVo(WarehousePalletItemParamVo warehousePalletItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (warehousePalletItem == null) {
			warehousePalletItem = new WarehousePalletItemParamVo();
		}
		warehousePalletItem.setTenantId(commonParam.getTenantId());

		List<WarehousePalletItem> list = (List<WarehousePalletItem>) this.getBaseService()
				.selectListByParamVo(warehousePalletItem, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehousePalletItemVo> selectPageExtendVoByParamVo(WarehousePalletItemParamVo warehousePalletItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (warehousePalletItem == null) {
			warehousePalletItem = new WarehousePalletItemParamVo();
		}
		warehousePalletItem.setTenantId(commonParam.getTenantId());

		PageInfo<WarehousePalletItem> list = (PageInfo<WarehousePalletItem>) this.getBaseService()
				.selectPageByParamVo(warehousePalletItem, commonParam, pageNo, pageSize);
		List<WarehousePalletItemVo> volist = new ArrayList<WarehousePalletItemVo>();

		Iterator<WarehousePalletItem> iter = list.getList().iterator();
		WarehousePalletItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehousePalletItemVo> vpage = new Page<WarehousePalletItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(WarehousePalletItemParamVo warehousePalletItemParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		WarehousePalletItem warehousePalletItem = null;

		if (warehousePalletItemParamVo.getPackboxId() == null) {
			resultMessage.addErr("包装箱不能为空");
			return resultMessage;
		}

		try {
			if (warehousePalletItemParamVo.getId() == null) {// 新增

				warehousePalletItemParamVo.setTenantId(commonParam.getTenantId());
				warehousePalletItem = warehousePalletItemService.saveOrUpdate(warehousePalletItemParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				WarehousePalletItem warehousePalletItemVoTemp = this.selectById(warehousePalletItemParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(warehousePalletItemVoTemp, warehousePalletItemParamVo);

				warehousePalletItem = warehousePalletItemService.saveOrUpdate(warehousePalletItemVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(warehousePalletItem);
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
	public int updateBarcodeMainByBarcode(Map<Object, Object> map, CommonParam commonParam)
			throws BusinessException, SQLException {

		return warehousePalletItemService.updateBarcodeMainByBarcode(map, commonParam);
	}
}
