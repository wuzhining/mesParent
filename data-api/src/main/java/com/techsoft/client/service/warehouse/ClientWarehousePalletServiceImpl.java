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
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.WarehousePallet;
import com.techsoft.entity.warehouse.WarehousePalletParamVo;
import com.techsoft.entity.warehouse.WarehousePalletVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructWarehouseService;
import com.techsoft.service.warehouse.WarehousePalletService;

@org.springframework.stereotype.Service
public class ClientWarehousePalletServiceImpl extends BaseClientServiceImpl<WarehousePallet>
		implements ClientWarehousePalletService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehousePalletService warehousePalletService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWarehouseService StructWarehouseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService ConfigDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService ProductMainService;

	@Override
	public BaseService<WarehousePallet> getBaseService() {
		return warehousePalletService;
	}

	private WarehousePalletVo getVo(WarehousePallet warehousePallet, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehousePalletVo vo = new WarehousePalletVo(warehousePallet);

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
		if (vo.getPalletStatusDictId() != null && vo.getPalletStatusDictId() > 0L) {
			ConfigDictionary configDictionary = ConfigDictionaryService.selectById(vo.getPalletStatusDictId(),
					commonParam);
			if (configDictionary != null) {
				vo.setConfigDictionary(configDictionary);
			}
		}
		if (vo.getProductId() != null && vo.getProductId() > 0L) {
			ProductMain productMain = ProductMainService.selectById(vo.getProductId(), commonParam);
			if (productMain != null) {
				vo.setProductMain(productMain);
			}
		}
		return vo;
	}

	private WarehousePalletVo getExtendVo(WarehousePallet warehousePallet, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehousePalletVo vo = this.getVo(warehousePallet, commonParam);

		return vo;
	}

	private List<WarehousePalletVo> getVoList(List<WarehousePallet> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehousePalletVo> voList = new ArrayList<WarehousePalletVo>();
		for (WarehousePallet entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<WarehousePalletVo> getExtendVoList(List<WarehousePallet> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehousePalletVo> voList = new ArrayList<WarehousePalletVo>();
		for (WarehousePallet entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public WarehousePalletVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WarehousePallet entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<WarehousePalletVo> selectListVoByParamVo(WarehousePalletParamVo warehousePallet,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (warehousePallet == null) {
			warehousePallet = new WarehousePalletParamVo();
		}
		warehousePallet.setTenantId(commonParam.getTenantId());

		List<WarehousePallet> list = (List<WarehousePallet>) this.getBaseService().selectListByParamVo(warehousePallet,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehousePalletVo> selectPageVoByParamVo(WarehousePalletParamVo warehousePallet,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (warehousePallet == null) {
			warehousePallet = new WarehousePalletParamVo();
		}
		warehousePallet.setTenantId(commonParam.getTenantId());

		PageInfo<WarehousePallet> list = (PageInfo<WarehousePallet>) this.getBaseService()
				.selectPageByParamVo(warehousePallet, commonParam, pageNo, pageSize);
		List<WarehousePalletVo> volist = new ArrayList<WarehousePalletVo>();

		Iterator<WarehousePallet> iter = list.getList().iterator();
		WarehousePalletVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehousePalletVo> vpage = new Page<WarehousePalletVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public WarehousePalletVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WarehousePallet entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<WarehousePalletVo> selectListExtendVoByParamVo(WarehousePalletParamVo warehousePallet,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (warehousePallet == null) {
			warehousePallet = new WarehousePalletParamVo();
		}
		warehousePallet.setTenantId(commonParam.getTenantId());

		List<WarehousePallet> list = (List<WarehousePallet>) this.getBaseService().selectListByParamVo(warehousePallet,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehousePalletVo> selectPageExtendVoByParamVo(WarehousePalletParamVo warehousePallet,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (warehousePallet == null) {
			warehousePallet = new WarehousePalletParamVo();
		}
		warehousePallet.setTenantId(commonParam.getTenantId());

		PageInfo<WarehousePallet> list = (PageInfo<WarehousePallet>) this.getBaseService()
				.selectPageByParamVo(warehousePallet, commonParam, pageNo, pageSize);
		List<WarehousePalletVo> volist = new ArrayList<WarehousePalletVo>();

		Iterator<WarehousePallet> iter = list.getList().iterator();
		WarehousePalletVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehousePalletVo> vpage = new Page<WarehousePalletVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(WarehousePalletParamVo warehousePalletParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		WarehousePallet warehousePallet = null;

		if (warehousePalletParamVo.getPalletCode() == null) {
			resultMessage.addErr("栈板编码不能为空");
			return resultMessage;
		}
		if (warehousePalletParamVo.getQuantityPackbox() == null) {
			resultMessage.addErr("箱数不能为空");
			return resultMessage;
		}
		if (warehousePalletParamVo.getQuantitySn() == null) {
			resultMessage.addErr("SN数不能为空");
			return resultMessage;
		}
		try {
			if (warehousePalletParamVo.getId() == null) {// 新增

				warehousePalletParamVo.setTenantId(commonParam.getTenantId());
				warehousePallet = warehousePalletService.saveOrUpdate(warehousePalletParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				WarehousePallet warehousePalletVoTemp = this.selectById(warehousePalletParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(warehousePalletVoTemp, warehousePalletParamVo);

				warehousePallet = warehousePalletService.saveOrUpdate(warehousePalletVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(warehousePallet);
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
	public int updatePallet(List<Map> list, CommonParam commonParam) throws BusinessException, SQLException {
		int pallet = warehousePalletService.updatePallet(list, commonParam);// 栈板合并
		return pallet;
	}

	@Override
	public int updateBarcodeMain(Map<Object, Object> map, CommonParam commonParam)
			throws BusinessException, SQLException {

		return warehousePalletService.updateBarcodeMain(map, commonParam);
	}

	@Override
	public int updateTrackBarcode(Map<Object, Object> map, CommonParam commonParam)
			throws BusinessException, SQLException {
		return warehousePalletService.updateTrackBarcode(map, commonParam);
	}

	@Override
	public int updatePalletPull(List<Map> map, CommonParam commonParam) throws BusinessException, SQLException {
		return warehousePalletService.updatePalletPull(map, commonParam);// 栈板拆除
	}
}
